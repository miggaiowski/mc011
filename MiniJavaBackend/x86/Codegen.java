package x86;

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
    	if (s instanceof MOVE)
    		munchMove((MOVE) s);    		
    	else if (s instanceof EXPSTM)
    		//TODO: munchExpStm((EXPSTM) s);
    		System.out.println("munchExpStm((EXPSTM) s)");
    	else if (s instanceof CJUMP)
    		//TODO: munchCJump((CJUMP) s);
    		System.out.println("munchCJump((CJUMP) s)");
    	else if (s instanceof LABEL)
    		//TODO: munchLabel((LABEL) s);
    		System.out.println("munchLabel((LABEL) s)");
    	else if (s instanceof JUMP)
    		munchJump((JUMP) s);
    	else
    		throw new Error("Unhandled: " + s.getClass());
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
    	Temp add = munchExp(dst.exp);
    	
    	emit (new assem.OPER("mov [`s0] `s1",
    						  null,
    						  new List<Temp>(add, new List<Temp>(val,null)))); //add = s0, val = s1
    	return;
    }
    
    // **MUNCH MOVE (TEMP, Exp)** //
    private void munchMove (TEMP s, Exp src){
    	//TODO: implement
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
    	if (exp instanceof BINOP)
    		//TODO: munchBinop((BINOP) exp);
    		System.out.println("munchBinop((BINOP) exp)");
    	else if (exp instanceof CALL)
    		//TODO: munchCall((CALL) exp);
    		System.out.println("munchCall((CALL) exp)");
    	else if (exp instanceof CONST)
    		//TODO: munchConst((CONST) exp);
    		System.out.println("munchConst((CONST) exp)");
    	else if (exp instanceof ESEQ)
    		//TODO: munchESeq((ESEQ) exp);
    		System.out.println("munchESeq((ESEQ) exp)");
    	else if (exp instanceof MEM)
    		//TODO: munchMem((MEM) exp);
    		System.out.println("munchMem((MEM) exp)");
    	else if (exp instanceof NAME)
    		//TODO: munchName((NAME) exp);
    		System.out.println("munchName((NAME) exp)");
    	else if (exp instanceof TEMP)
    		//TODO: munchTemp((TEMP) exp);
    		System.out.println("munchTemp((TEMP) exp)");
    	else
    		throw new Error("Unhandled: " + exp.getClass());
    	
    	return null; //TODO: delete this!
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
