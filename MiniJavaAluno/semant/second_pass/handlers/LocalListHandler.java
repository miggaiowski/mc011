package semant.second_pass.handlers;

import semant.Env;
import symbol.MethodInfo;
import syntaxtree.VarDecl;
import syntaxtree.VisitorAdapter;
import util.List;

public class LocalListHandler extends VisitorAdapter{
	
	private LocalListHandler(Env e){
        super();
    }

    public static void secondpass(Env env, MethodInfo methodInfo, List<VarDecl> locals) {

        // TODO: Checar se há repetição de locals?.
        
        // checking each of the formals
        while(locals != null) {
            LocalHandler.secondpass(env, methodInfo, locals.head);
            locals = locals.tail;
        }
    
    }
}
