package semant.second_pass.handlers;

import semant.Env;
import semant.second_pass.handlers.ClassDeclHandler;
import syntaxtree.ClassDecl;
import syntaxtree.VisitorAdapter;
import util.List;

public class ClassDeclListHandler extends VisitorAdapter{
	
	private ClassDeclListHandler(Env e){
        super();
    }

    public static void secondpass(Env e, List<ClassDecl> classList) {

        // percorre lista ligada classList das ClassDecl
        ClassDecl cd;
        while (classList != null) {
            cd = classList.head;
            ClassDeclHandler.secondpass(e, cd); // chama secondpass para poder visitar cada ClassDecl
            classList = classList.tail;
        }
    }
}
