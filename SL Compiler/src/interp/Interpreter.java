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
        int n = 1;
        while (el instanceof PairExpList) {
//            System.out.println("MAIS UM");
            n++;
            el = ((PairExpList)el).tail;
        }
        return n;
    }
    
    static int maxargs(Exp e) {
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
	    System.out.println(maxargs(prog.prog2));
	}
}