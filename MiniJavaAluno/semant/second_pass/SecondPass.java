package semant.second_pass;

import semant.Env;
import syntaxtree.Program;
import errors.ErrorEchoer;

public final class SecondPass {
 
    private SecondPass() {
        super();
    }
    
    public static void secondPass(Env e, Program p) {
    	InheritanceBuilder.secondPass(e, p);
    		

    }
}
