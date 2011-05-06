package semant.first_pass.handlers;

import semant.Env;
import symbol.MethodInfo;
import syntaxtree.Formal;
import syntaxtree.VisitorAdapter;
import util.List;

public class FormalsListHandler extends VisitorAdapter {
    
    private FormalsListHandler(Env e){
        super();
    }

    public static void firstPass(Env env, MethodInfo methodInfo, List<Formal> formals) {
        
        // percorre lista ligada varList das VarDecl
        Formal formal;
        while (formals != null) {
            formal = formals.head;
            FormalsHandler.firstPass(env, methodInfo, formal); // chama firstPass para poder visitar cada VarDecl
            formals = formals.tail;
        }
    }
}
