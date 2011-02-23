package interp;

import java.beans.IntrospectionException;

import grammar.AssignStm;
import grammar.CompoundStm;
import grammar.EseqExp;
import grammar.Exp;
import grammar.ExpList;
import grammar.LastExpList;
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
        return 0; // sure it's always zero? must check for statements
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
	
	static void interp(Stm s){
	    // implement here
	}
    
    public static void main (String args[]) {
        System.out.println(maxargs(prog.prog));
        System.out.println(maxargs(prog.prog2));
        System.out.println(maxargs(prog.pequeno));
        System.out.println(maxargs(prog.grande));
        System.out.println(maxargs(prog.tricky));
	}
}