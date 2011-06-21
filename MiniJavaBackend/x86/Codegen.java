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
    		//TODO: munchCJump((CJUMP) s);
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
    	Temp add = munchExp(dst.exp); // o "destino" é o resultado desta Exp.
    	
    	emit (new assem.OPER("mov [`s0], `s1",
    						  null,
    						  new List<Temp>(add, new List<Temp>(val,null)))); //add = s0, val = s1
    	return;
      }
    
    // **MUNCH MOVE (TEMP, Exp)** //
    private void munchMove (TEMP s, Exp src){
    	Temp val = munchExp(src);
    	Temp reg = s.temp; // já temos o Temp de destino
    	
    	emit (new assem.OPER("mov `d0, `s0", 
    	        new List<Temp>(reg, null),
    	        new List<Temp>(val, null)));
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
    
    // **MUNCH EXP** //
    private Temp munchExp (Exp exp){
        Temp ret = null;
    	if (exp instanceof BINOP) {
            System.out.println("munchBinop((BINOP) exp)");
    		//TODO: munchBinop((BINOP) exp);
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
            System.out.println("munchExpESeq((ESEQ) exp)");
    		//TODO: munchExpESeq((ESEQ) exp);
    	}
    	else if (exp instanceof MEM) {
            System.out.println("munchExpMem((MEM) exp)");
    		//TODO: munchExpMem((MEM) exp);
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
    	
    	if (ret == null)
    	    System.out.println("WTFFFFF");
    	return ret;
    }
    
    private Temp munchExpCall(CALL exp) {
        //TODO: Fazer direito, só coloquei isso pra testar
     
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
        for (Exp param : paramsArrayList) {
            Temp p = munchExp(param);
            emit(new assem.OPER("push `s0",
                    null,
                    new List<Temp>(p, null)));
        }
        
        // Colocando endereço da função num registrador
        Temp funcAdd = munchExp(exp.func);
        emit(new assem.OPER("call `s0", null, new List<Temp>(funcAdd, null)));
        
        emit(new assem.OPER("add esp, " + (num_args * 4), null, null));
        
        // precisa pegar o valor de retorno
        
        return new Temp();
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
        return new Temp();
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
