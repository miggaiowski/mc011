package semant.second_pass;

import semant.Env;
import syntaxtree.Program;
import errors.ErrorEchoer;

public final class SecondPass {
 
    private SecondPass() {
        super();
    }
    
    public static void secondPass(Env e, Program p) {
    	//First we must find any possible cyclic inheritances that could mess things up
    	InheritanceBuilder.secondPass(e, p);
    		

    }
}
