package semant.second_pass.handlers;

import semant.Env;
import syntaxtree.VarDecl;
import syntaxtree.VisitorAdapter;
import util.List;

public class AttributeListHandler extends VisitorAdapter {
    
    private AttributeListHandler(Env e){
        super();
    }
    
    public static void secondpass(Env e, List<VarDecl> varList) {
        
        // percorre lista ligada varList das VarDecl
        VarDecl vd;
        while (varList != null) {
            vd = varList.head;
            AttributeHandler.secondpass(e, vd); // chama secondPass para poder visitar cada VarDecl
            varList = varList.tail;
        }
    }


}