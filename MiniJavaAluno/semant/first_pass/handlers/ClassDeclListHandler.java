package semant.first_pass.handlers;

import semant.Env;
import syntaxtree.ClassDecl;
import syntaxtree.VisitorAdapter;
import util.List;

public class ClassDeclListHandler extends VisitorAdapter {
    
    private ClassDeclListHandler(Env e){
        super();
    }
    
    public static void firstPass(Env e, List<ClassDecl> classList) {
        
        // percorre lista ligada classList das ClassDecl
        ClassDecl cd;
        while (classList != null) {
            cd = classList.head;
            ClassDeclHandler.firstPass(e, cd); // chama firstPass para poder visitar cada ClassDecl
            classList = classList.tail;
        }
    }
}
