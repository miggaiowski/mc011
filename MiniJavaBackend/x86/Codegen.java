package x86;

import assem.Instr;
import temp.Temp;
import tree.CJUMP;
import tree.EXPSTM;
import tree.Exp;
import tree.JUMP;
import tree.LABEL;
import tree.MEM;
import tree.MOVE;
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
    		//TODO: munchJump((JUMP) s);
    		System.out.println("munchJump((JUMP) s)");
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
