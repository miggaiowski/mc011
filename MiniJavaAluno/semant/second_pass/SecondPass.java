package semant.second_pass;

import semant.Env;
import semant.second_pass.handlers.ClassDeclListHandler;
import semant.second_pass.handlers.MainClassHandler;
import syntaxtree.Program;

public final class SecondPass {
 
    private SecondPass() {
        super();
    }
    
    public static void secondPass(Env e, Program p) {
    	//First we must find any possible cyclic inheritances that could mess things up
    	InheritanceBuilder.secondPass(e, p);
    	
    	// Do a second pass in the main class
    	MainClassHandler.secondpass(e, p.mainClass);
    	
    	// Do a second pass in the other classes
    	ClassDeclListHandler.secondpass(e, p.classList);
    		

    }
}
