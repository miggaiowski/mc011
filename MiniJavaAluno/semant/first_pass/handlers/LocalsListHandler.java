package semant.first_pass.handlers;

import semant.Env;
import symbol.ClassInfo;
import symbol.MethodInfo;
import syntaxtree.VarDecl;
import syntaxtree.VisitorAdapter;
import util.List;

public class LocalsListHandler extends VisitorAdapter {
    
    private LocalsListHandler(Env e){
        super();
    }

    public static void firstPass(Env env, MethodInfo methodInfo, List<VarDecl> locals) {

        // percorre lista ligada varList das VarDecl
        VarDecl vd;
        while (locals != null) {
            vd = locals.head;
            LocalsHandler.firstPass(env, methodInfo, vd); // chama firstPass para poder visitar cada VarDecl
            locals = locals.tail;
        }
    }
}
