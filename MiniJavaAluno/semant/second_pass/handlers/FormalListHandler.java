package semant.second_pass.handlers;

import semant.Env;
import symbol.MethodInfo;
import syntaxtree.Formal;
import syntaxtree.VisitorAdapter;
import util.List;

public class FormalListHandler extends VisitorAdapter{
	
	private FormalListHandler(Env e){
        super();
    }

    public static void secondpass(Env env, MethodInfo methodInfo, List<Formal> formals) {

        // TODO: Checar se há repetição de Formals.
        
        // checking each of the formals
        while(formals != null) {
            FormalHandler.secondpass(env, methodInfo, formals.head);
            formals = formals.tail;
        }
    
    }
}
