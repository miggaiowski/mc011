package interp;

import grammar.AssignStm;
import grammar.CompoundStm;
import grammar.EseqExp;
import grammar.Exp;
import grammar.ExpList;
import grammar.IdExp;
import grammar.LastExpList;
import grammar.NumExp;
import grammar.OpExp;
import grammar.PairExpList;
import grammar.PrintStm;
import grammar.Stm;

public class Interpreter {
    
    static int maxargs(ExpList el) {
        int max = 0, expval;
        int n = 1;
        while (el instanceof PairExpList) { // traverse linked list
            expval = maxargs(((PairExpList)el).head); // get the maxargs for this exp
            if (expval > max) // if it returns not zero, then it had a print somewhere
                max = expval; // save this value, we need it to compare to ourself
            n++; // anyhow, this was one more parameter for us
            el = ((PairExpList)el).tail; // move the pointer to the next linked list item
        }
        return Math.max(n, max); // return our size or some other print inside us that was bigger
    }
    
    static int maxargs(Exp e) {
        // this is the only case where you might have a print somewhere, because there is a statement
        // in there. See?
        if (e instanceof EseqExp) {
            return maxargs(((EseqExp) e).stm);
        }
        return 0; 
    }
    
	static int maxargs(Stm s){
	    if (s instanceof CompoundStm) { // We have two sub statements, call recursive.
	        return Math.max(maxargs(((CompoundStm) s).stm1), maxargs(((CompoundStm) s).stm2));
	    }
	    else if (s instanceof AssignStm) { // Assign statement
	        return maxargs(((AssignStm) s).exp);
	    }
	    else if (s instanceof PrintStm) { // Print statement has a list of expressions
	        return maxargs(((PrintStm) s).exps);
	    }
	    return 0;
	}
	
	static IntAndTable interpExp(Exp s, Table t) {
	    if (s instanceof IdExp) {
	        IntAndTable iat1 = new IntAndTable(Table.lookup(t, ((IdExp) s).id), t);
	        return iat1;
	    }
	    else if (s instanceof NumExp) {
	        IntAndTable iat1 = new IntAndTable(((NumExp) s).num, t);
	        return iat1;
	    }
	    else if (s instanceof OpExp) {
	        IntAndTable iat1 = interpExp(((OpExp) s).left, t);
	        IntAndTable iat2 = interpExp(((OpExp) s).right, iat1.t);
	        IntAndTable iat3;
	        switch (((OpExp) s).oper) {
	        case OpExp.Plus:
	            iat3 = new IntAndTable(iat1.i + iat2.i, iat2.t);
	            break;
	        case OpExp.Minus:
                iat3 = new IntAndTable(iat1.i - iat2.i, iat2.t);
                break;
	        case OpExp.Times:
                iat3 = new IntAndTable(iat1.i * iat2.i, iat2.t);
                break;
	        case OpExp.Div:
                iat3 = new IntAndTable(iat1.i / iat2.i, iat2.t);
                break;
	        default:
	            // does not enter here, but the java compiler complains without it
	            iat3 = new IntAndTable(-1, t); 
	            break;
	        }
	        return iat3;
	    }
	    else if(s instanceof EseqExp) {
	        Table t1 = interpStm(((EseqExp) s).stm, t);
	        IntAndTable iat1 = interpExp(((EseqExp) s).exp, t1);
	        return iat1;
	    }  
	    else {
	        return new IntAndTable(0, t);
	    }     
	}
	
	static Table interpStm(Stm s, Table t) {
	    if (s instanceof CompoundStm) {
	        Table t1 = interpStm(((CompoundStm) s).stm1, t);
	        Table t2 = interpStm(((CompoundStm) s).stm2, t1);
	        return t2;
	    }
	    else if (s instanceof AssignStm) {
	        // process Expression with Table t and get the integer result
	        // and a new table of side effects
            IntAndTable iat1 = interpExp(((AssignStm) s).exp, t);
	        // New table is the one with the side effects with
	        // this assignment in front
	        Table t1 = Table.update(iat1.t, ((AssignStm) s).id, iat1.i);
	        return t1;
	    }
	    else if(s instanceof PrintStm) {
	        // traverse the expression list and do stuff
	        IntAndTable iat = new IntAndTable(0, t); // the results from interpExp
	        ExpList el = ((PrintStm) s).exps;
	        while (el instanceof PairExpList) {
	            iat = interpExp(((PairExpList)el).head, iat.t);
	            System.out.print(iat.i + ", ");
	            el = ((PairExpList)el).tail;
	        }
	        iat = interpExp(((LastExpList)el).head, iat.t);
	        System.out.println(iat.i);
	        return iat.t;
	    }
	    else
	        return t; // never gets here.
	}
	
	static void interp(Stm s){
	    Table t = interpStm(s, null);
	    
	    // lets print the final state of the Symbols Table.
	    while (t != null) {
	        System.out.println(t.id + " : " + t.value);
	        t = t.tail;
	    }
	}
    
    public static void main (String args[]) {
    	System.out.println("===== Calculating MaxArgs from the programs =====");
        System.out.println("maxargs(prog) = " + maxargs(prog.prog));
        System.out.println("maxargs(prog2) = " + maxargs(prog.prog2));
        System.out.println("maxargs(small) = " + maxargs(prog.small));
        System.out.println("maxargs(big) = " + maxargs(prog.big));
        System.out.println("maxargs(tricky) = " + maxargs(prog.tricky));
        System.out.println("maxargs(easy) = " + maxargs(prog.easy));
        System.out.println("maxargs(squares) = " + maxargs(prog.squares));
        
        System.out.println("\n===== Interpreting the programs =====");
        
        System.out.println("prog:");
        interp(prog.prog);
        
        System.out.println("prog2:");
        interp(prog.prog2);
        
        System.out.println("small:");
        interp(prog.small);
        
        System.out.println("big:");
        interp(prog.big);
        
        System.out.println("tricky:");
        interp(prog.tricky);
        
        System.out.println("easy:");
        interp(prog.easy);
        
        System.out.println("squares:");
        interp(prog.squares);
        
        
	}
}