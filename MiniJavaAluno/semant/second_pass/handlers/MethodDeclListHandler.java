package semant.second_pass.handlers;

import semant.Env;
import syntaxtree.MethodDecl;
import syntaxtree.VisitorAdapter;
import util.List;

public class MethodDeclListHandler extends VisitorAdapter{
	
	private MethodDeclListHandler(Env e){
        super();
    }

    public static void secondpass(Env e, List<MethodDecl> methodList) {
        
        // percorre lista ligada classList das ClassDecl
        MethodDecl md;
        while (methodList != null) {
            md = methodList.head;
            MethodDeclHandler.secondpass(e, md); // chama secondpass para poder visitar cada MethodDecl
            methodList = methodList.tail;
        }
    }
}
