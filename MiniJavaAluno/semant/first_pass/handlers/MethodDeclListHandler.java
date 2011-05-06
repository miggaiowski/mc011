package semant.first_pass.handlers;

import semant.Env;
import symbol.ClassInfo;
import syntaxtree.MethodDecl;
import syntaxtree.VisitorAdapter;
import util.List;

public class MethodDeclListHandler extends VisitorAdapter {
    
    private MethodDeclListHandler(Env e){
        super();
    }
    
    public static void firstPass(Env e, ClassInfo classInfo, List<MethodDecl> methodList) {
        
        // percorre lista ligada varList das VarDecl
        MethodDecl md;
        while (methodList != null) {
            md = methodList.head;
            MethodDeclHandler.firstPass(e, classInfo, md); // chama firstPass para poder visitar cada MethodDecl
            methodList = methodList.tail;
        }
    }
}
