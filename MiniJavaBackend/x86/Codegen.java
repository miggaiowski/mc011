package x86;

import java.util.ArrayList;

import assem.Instr;
import temp.Label;
import temp.Temp;
import tree.BINOP;
import tree.CALL;
import tree.CJUMP;
import tree.CONST;
import tree.ESEQ;
import tree.EXPSTM;
import tree.Exp;
import tree.JUMP;
import tree.LABEL;
import tree.MEM;
import tree.MOVE;
import tree.NAME;
import tree.Stm;
import tree.TEMP;
import util.List;

public class Codegen
{
    Frame frame;
    public Codegen(Frame f)
    {
        frame=f;        
    }

    private List<Instr> ilist=null;
    private List<Instr> last=null;

    private void emit(Instr inst)
    {
        if (last!=null)
            last = last.tail = new List<Instr>(inst,null);
        else 
            last = ilist = new List<Instr>(inst,null);
    }

    // **MUNCH STATEMENT** // 
    private void munchStm (Stm s) {
        if (s instanceof MOVE) {
            System.out.println("munchMove((MOVE) s)");
            munchMove((MOVE) s);
        }
        else if (s instanceof EXPSTM) {
            System.out.println("munchExpStm((EXPSTM) s)");
            munchExpStm((EXPSTM) s);
        }
        else if (s instanceof CJUMP) {
            System.out.println("munchCJump((CJUMP) s)");
            munchCJump((CJUMP) s);
        }
        else if (s instanceof LABEL) {
            System.out.println("munchLabel((LABEL) s)");
            munchLabel((LABEL) s); 
        }
        else if (s instanceof JUMP) {
            munchJump((JUMP) s);
        }
        else
            throw new Error("Unhandled: " + s.getClass());
    }

    private void munchExpStm(EXPSTM s) {
        munchExp(s.exp);
    }

    private void munchLabel(LABEL l) {
        emit(new assem.LABEL(l.label.toString() + ":", l.label));
    }



    // **MUNCH MOVE (MOVE)** //
    private void munchMove (MOVE s){
        if (s.dst instanceof MEM)
            munchMove((MEM) s.dst, s.src);
        else
            munchMove((TEMP) s.dst, s.src);
    }

    // **MUNCH MOVE (MEM, Exp)** //
    private void munchMove (MEM dst, Exp src){
        Temp val = munchExp(src);

        if (dst.exp instanceof BINOP) {
            BINOP bo = (BINOP) dst.exp;
            if (bo.binop == BINOP.PLUS) {
                if (bo.left instanceof TEMP && bo.right instanceof CONST) {
                    CONST c = (CONST) bo.right;
                    TEMP t = (TEMP)bo.left;
                    emit(new assem.OPER("mov [`s0 + " + c.value + "], `s1", 
                            null,
                            new List<Temp>(t.temp, new List<Temp>(val, null))));
                    return;
                }
                else if ((bo.left instanceof TEMP || bo.left instanceof MEM) && bo.right instanceof BINOP) {
                    BINOP bo_shl = (BINOP) bo.right;
                    Temp t = null;
                    if (bo.left instanceof MEM) {
                        t = munchExp(bo.left);
                    }
                    else {
                        TEMP te = (TEMP)bo.left;
                        t = te.temp;
                    }
                    if (bo_shl.binop == BINOP.LSHIFT) {
                        System.out.println("Tratando aquele caso --------------------*************************************************");
                        CONST c = (CONST) bo_shl.right;
                        if (bo_shl.left instanceof CONST) {
                            System.out.println("ExpMem com Plus e LSHIFTexp");
                            CONST bo_shl_left = (CONST) bo_shl.left;
                            emit(new assem.OPER("mov [`s0 + " + (int)Math.pow(2, c.value) * bo_shl_left.value + "], `s1",  
                                    null,
                                    new List<Temp>(t, new List<Temp>(val, null))));
                        }
                        else {
                            System.out.println("ExpMem com Plus e LSHIFTexp");                            
                            Temp index = munchExp(bo_shl.left);
                            emit(new assem.OPER("mov [`s0 + " + (int)Math.pow(2, c.value) + " * `s1], `s2",  
                                    null,
                                    new List<Temp>(t, new List<Temp>(index, new List<Temp>(val, null)))));
                        }
                        return;
                    }
                }
            }
            else if (bo.binop == BINOP.MINUS) {
                if (bo.left instanceof TEMP && bo.right instanceof CONST) {
                    CONST c = (CONST) bo.right;
                    TEMP t = (TEMP)bo.left;
                    emit(new assem.OPER("mov [`s0 - " + c.value + "], `s1",                     
                            null,
                            new List<Temp>(t.temp, new List<Temp>(val, null))));
                    return;
                }
            }
        }
        
        
        
        Temp add = munchExp(dst.exp); // o &destino é o resultado desta Exp.
        emit (new assem.OPER("mov [`s0], `s1",
                null,
                new List<Temp>(add, new List<Temp>(val,null)))); //add = s0, val = s1
        return;
    }

    // **MUNCH MOVE (TEMP, Exp)** //
    private void munchMove (TEMP s, Exp src){
        System.out.println("MOVING-------------------------------------");
        Temp val = munchExp(src);
        //Temp reg = munchExpTemp(s);
        Temp reg = s.temp; // já temos o Temp de destino        

        emit (new assem.MOVE("mov `d0, `s0", 
                reg,
                val));
//        emit (new assem.OPER("mov `d0, `s0", 
//                new List<Temp>(reg, null),
//                new List<Temp>(val, null)));
        return;
    }

    // **MUNCH JUMP (JUMP)** //
    private void munchJump (JUMP s){
        //Tratando o caso mais comum de jump: -> jump label
        if (s.exp instanceof NAME){
            NAME l = (NAME) s.exp;
            emit (new assem.OPER("jmp `j0",
                    null, null,
                    new List<Label>(l.label,null)));
        }
        //Tratando caso mais complexo de jump: -> jump expressao
        else {
            Temp target = munchExp(s.exp);
            emit (new assem.OPER("jmp `s0",
                    null,
                    new List<Temp>(target,null), s.targets));
        }
    }

    // **MUNCH CJUMP (JUMP)** //
    private void munchCJump (CJUMP s){
        Temp left = munchExp(s.left);
        Temp right = munchExp(s.right);

        emit (new assem.OPER("cmp `s0, `s1", 
                null, 
                new List<Temp>(left, new List<Temp>(right, null))));

        switch (s.op){
        case CJUMP.EQ:
            emit (new assem.OPER("je `j0", null,null, new List<Label>(s.ifTrue,new List<Label>(s.ifFalse, null))));
            break;
        case CJUMP.NE:
            emit (new assem.OPER("jne `j0", null,null, new List<Label>(s.ifTrue,new List<Label>(s.ifFalse, null))));
            break;
        case CJUMP.GE:
            emit (new assem.OPER("jge `j0", null,null, new List<Label>(s.ifTrue,new List<Label>(s.ifFalse, null))));
            break;
        case CJUMP.GT:
            emit (new assem.OPER("jg `j0", null,null, new List<Label>(s.ifTrue,new List<Label>(s.ifFalse, null))));
            break;
        case CJUMP.LE:
            emit (new assem.OPER("jle `j0", null,null, new List<Label>(s.ifTrue,new List<Label>(s.ifFalse, null))));
            break;
        case CJUMP.LT:
            emit (new assem.OPER("jl `j0", null,null, new List<Label>(s.ifTrue, new List<Label>(s.ifFalse, null))));
            break;
        case CJUMP.UGE:
            emit (new assem.OPER("jge `j0", null,null, new List<Label>(s.ifTrue,new List<Label>(s.ifFalse, null))));
            break;
        case CJUMP.UGT:
            emit (new assem.OPER("jg `j0", null,null, new List<Label>(s.ifTrue,new List<Label>(s.ifFalse, null))));
            break;
        case CJUMP.ULE:
            emit (new assem.OPER("jle `j0", null,null, new List<Label>(s.ifTrue,new List<Label>(s.ifFalse, null))));
            break;
        case CJUMP.ULT:
            emit (new assem.OPER("jl `j0", null,null, new List<Label>(s.ifTrue,new List<Label>(s.ifFalse, null))));
            break;
        default:
            throw new Error("Unhandled Conditional Jump: " + s.op);
        }
    }

    
    // **MUNCH EXP** //
    private Temp munchExp (Exp exp){
        Temp ret = null;
        if (exp instanceof BINOP) {
            System.out.println("munchExpBinop((BINOP) exp)");
            ret = munchExpBinop((BINOP) exp);
        }
        else if (exp instanceof CALL) {
            System.out.println("munchExpCall((CALL) exp)");
            ret = munchExpCall((CALL) exp);
        }
        else if (exp instanceof CONST) {
            System.out.println("munchExpConst((CONST) exp)");
            ret = munchExpConst((CONST) exp);
        }
        else if (exp instanceof ESEQ) {
            munchExpESeq((ESEQ) exp);
        }
        else if (exp instanceof MEM) {
            System.out.println("munchExpMem((MEM) exp)");
            ret = munchExpMem((MEM) exp);
        }
        else if (exp instanceof NAME) {
            System.out.println("munchExpName((NAME) exp)");
            ret = munchExpName((NAME) exp);
        }
        else if (exp instanceof TEMP) {
            System.out.println("munchExpTemp((TEMP) exp)");
            ret = munchExpTemp((TEMP) exp);
        }
        else
            throw new Error("Unhandled: " + exp.getClass());

        return ret;
    }

    private Temp munchExpESeq(ESEQ eseq){
        munchStm(eseq.stm);
        return munchExp(eseq.exp);
    }

    private Temp munchExpBinop(BINOP exp) {
        Temp tmp = munchExp(exp.left);
        Temp left = new Temp();

        emit (new assem.MOVE("mov `d0, `s0", 
                left,
                tmp));

        if (exp.binop == BINOP.LSHIFT) {
            System.out.println("munchExpBinop(LSHIFT)");
            CONST bla = null;
            if (exp.right instanceof CONST) {
                bla = (CONST)exp.right;
            }
            emit(new assem.OPER("shl `d0, " + bla.value, new List<Temp>(left, null), new List<Temp>(left, null)));
        }
        else {
            if (exp.binop == BINOP.PLUS) {
                System.out.println("munchExpBinop(PLUS)");
                CONST constante = null;
                if (exp.right instanceof CONST) {
                    constante = (CONST)exp.right;
                    emit(new assem.OPER("add `d0, " + constante.value, new List<Temp>(left, null), new List<Temp>(left, null)));
                }
                else {
                    Temp right = munchExp(exp.right);
                    emit(new assem.OPER("add `d0, `s1", new List<Temp>(left, null), new List<Temp>(left, new List<Temp>(right, null))));                }
            }
            else if (exp.binop == BINOP.MINUS){
                System.out.println("munchExpBinop(SUB)");  
                CONST constante = null;
                if (exp.right instanceof CONST) {
                    constante = (CONST)exp.right;
                    emit(new assem.OPER("sub `d0, " + constante.value, new List<Temp>(left, null), new List<Temp>(left, null)));
                }
                else {
                    Temp right = munchExp(exp.right);
                    emit(new assem.OPER("sub `d0, `s1", new List<Temp>(left, null), new List<Temp>(left, new List<Temp>(right, null))));
                }
            }
            else {
                Temp right = munchExp(exp.right);

                if (exp.binop == BINOP.AND) {
                    System.out.println("munchExpBinop(AND)");            
                    emit(new assem.OPER("and `d0, `s1", new List<Temp>(left, null), new List<Temp>(left, new List<Temp>(right, null))));
                }
                else if (exp.binop == BINOP.OR) {
                    System.out.println("munchExpBinop(OR)");            
                    emit(new assem.OPER("or `d0, `s1", new List<Temp>(left, null), new List<Temp>(left, new List<Temp>(right, null))));
                }
                else if (exp.binop == BINOP.XOR) {
                    System.out.println("munchExpBinop(XOR)");            
                    emit(new assem.OPER("xor `d0, `s1", new List<Temp>(left, null), new List<Temp>(left, new List<Temp>(right, null))));
                }
                else if (exp.binop == BINOP.TIMES) {
                    System.out.println("munchExpBinop(TIMES)");            
                    emit(new assem.OPER("imul `d0, `s1", new List<Temp>(left, null), new List<Temp>(left, new List<Temp>(right, null))));
                }
            }

        }
        return left;
    }

    private Temp munchExpMem(MEM exp) {
        Temp dst = new Temp();

        if (exp.exp instanceof BINOP) {
            BINOP bo = (BINOP) exp.exp;
            if (bo.binop == BINOP.PLUS) {
                if (bo.left instanceof TEMP && bo.right instanceof CONST) {
                    System.out.println("ExpMem com Plus e Const");
                    CONST c = (CONST) bo.right;
                    TEMP t = (TEMP)bo.left;
                    emit(new assem.OPER("mov `d0, [`s0 + " + c.value + "]",  
                            new List<Temp>(dst, null),
                            new List<Temp>(t.temp, null)));
                    return dst;
                }
                else if ((bo.left instanceof TEMP || bo.left instanceof MEM) && bo.right instanceof BINOP) {
                    BINOP bo_shl = (BINOP) bo.right;
                    Temp t = null;
                    if (bo.left instanceof MEM) {
                        t = munchExp(bo.left);
                    }
                    else {
                        TEMP te = (TEMP)bo.left;
                        t = te.temp;
                    }
                    if (bo_shl.binop == BINOP.LSHIFT) {
                        System.out.println("Tratando aquele caso --------------------*************************************************");
                        CONST c = (CONST) bo_shl.right;
                        if (bo_shl.left instanceof CONST) {
                            System.out.println("ExpMem com Plus e LSHIFTexp");
                            CONST bo_shl_left = (CONST) bo_shl.left;
                            emit(new assem.OPER("mov `d0, [`s0 + " + (int)Math.pow(2, c.value) * bo_shl_left.value + "]",  
                                    new List<Temp>(dst, null),
                                    new List<Temp>(t, null)));
                        }
                        else {
                            System.out.println("ExpMem com Plus e LSHIFTexp");                            
                            Temp index = munchExp(bo_shl.left);
                            emit(new assem.OPER("mov `d0, [`s0 + " + (int)Math.pow(2, c.value) + " * `s1]",  
                                    new List<Temp>(dst, null),
                                    new List<Temp>(t, new List<Temp>(index, null))));
                        }
                        return dst; 
                    }
                }
            }
            else if (bo.binop == BINOP.MINUS) {
                System.out.println("ExpMem com Minus");
                if (bo.left instanceof TEMP && bo.right instanceof CONST) {
                    CONST c = (CONST) bo.right;
                    TEMP t = (TEMP)bo.left;
                    emit(new assem.OPER("mov `d0, [`s0 - " + c.value + "]",  
                            new List<Temp>(dst, null),
                            new List<Temp>(t.temp, null)));
                    return dst;
                }
            }
        }
        Temp src = munchExp(exp.exp);
        emit(new assem.OPER("mov `d0, [`s0]", 
                new List<Temp>(dst, null),
                new List<Temp>(src, null)));
        return dst;
    }

    private Temp munchExpCall(CALL exp) {
        // lista com os parâmetros em ordem inversa a chamada
        ArrayList<tree.Exp> paramsArrayList = new ArrayList<tree.Exp>();

        int num_args = 0; // numero de params da funcao

        List<tree.Exp> args = exp.args;
        while (args != null) { // percorre a lista de parametros
            num_args += 1; // contando o numero de params
            paramsArrayList.add(0, args.head); // e inserindo no começo da outra lista, para ficar em ordem inversa
            args = args.tail;
        }

        System.out.println("Total de params: " +  num_args);

        // Percorrer lista de parametros colocando na pilha
        // em ordem inversa
        List<Temp> paramsTemp = null;
        for (Exp param : paramsArrayList) {
            Temp p = munchExp(param);
            paramsTemp = new List<Temp>(p, paramsTemp);
            emit(new assem.OPER("push `s0",
                    new List<Temp>(Frame.esp, null),
                    new List<Temp>(p, 
                            new List<Temp>(Frame.esp, null))));
        }

        // Se tivermos o label, damos call nele
        if (exp.func instanceof NAME) {
            NAME calledFunction = (NAME)(exp.func);
            emit(new assem.OPER("call " + calledFunction.label.toString(), 
                    new List<Temp>(Frame.esp, Frame.calldefs), 
                    new List<Temp>(Frame.esp, paramsTemp)));
        }
        else { // Senão temos que processar e jogar o endereço num registrador para dar call.
            Temp funcAdd = munchExp(exp.func);
            emit(new assem.OPER("call `s0", 
                    new List<Temp>(Frame.esp ,Frame.calldefs), 
                    new List<Temp>(funcAdd, new List<Temp>(Frame.esp, paramsTemp))));
        }

        // Só tira coisas da pilha se tiver argumentos, pra não aparecer um add esp, 0
        if (num_args > 0) {
            emit(new assem.OPER("add esp, " + (num_args * frame.wordsize()), new List<Temp>(Frame.esp, null), new List<Temp>(Frame.esp, null)));
        }

        // precisa pegar o valor de retorno
        Temp retornoTemp = new Temp();
        emit(new assem.MOVE("mov `d0, eax", retornoTemp, Frame.eax));

        return retornoTemp;
    }

    private Temp munchExpConst(CONST exp) {
        // Só coloca a constante num registrador, com mov
        Temp retTemp = new Temp();

        emit(new assem.OPER("mov `d0, " + exp.value,
                new List<Temp>(retTemp, null),
                null));
        return retTemp;
    }

    private Temp munchExpTemp(TEMP tmp) {
//        Temp t = new Temp();
//        emit(new assem.MOVE("mov `d0, `s0", t, tmp.temp));
//        return t;
        return tmp.temp;
    }

    private Temp munchExpName(NAME name) {
        Temp retTemp = new Temp();

        emit(new assem.OPER("mov `d0, " + name.label.toString(), 
                new List<Temp>(retTemp, null), 
                null));
        return retTemp;
    }





    /*-------------------------------------------------------------*
     *                              MAIN                           *
     *-------------------------------------------------------------*/
    List<Instr> codegen(Stm s)
    {
        List<Instr> l;
        munchStm(s);
        l=ilist;
        ilist=last=null;
        return l;
    }

    List<Instr> codegen(List<Stm> body)
    {
        List<Instr> l = null, t = null;

        for( ; body != null; body = body.tail )
        {
            munchStm(body.head);
            if ( l == null )
                l = ilist;
            else
                t.tail = ilist;
            t = last;
            ilist=last=null;
        }
        return l;
    }
}
