package semant.first_pass.handlers;

import semant.Env;
import symbol.ClassInfo;
import syntaxtree.VarDecl;
import syntaxtree.VisitorAdapter;
import util.List;

public class AttributeListHandler extends VisitorAdapter {
    
    private AttributeListHandler(Env e){
        super();
    }
    
    public static void firstPass(Env e, ClassInfo classInfo, List<VarDecl> varList) {
        
        // percorre lista ligada varList das VarDecl
        VarDecl vd;
        while (varList != null) {
            vd = varList.head;
            AttributeHandler.firstPass(e, classInfo, vd); // chama firstPass para poder visitar cada VarDecl
            varList = varList.tail;
        }
    }
}
