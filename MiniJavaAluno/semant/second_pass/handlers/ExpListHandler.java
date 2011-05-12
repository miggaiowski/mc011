package semant.second_pass.handlers;

import semant.Env;
import symbol.ClassInfo;
import symbol.MethodInfo;
import syntaxtree.Exp;
import syntaxtree.Type;
import syntaxtree.VisitorAdapter;
import util.List;

public class ExpListHandler extends VisitorAdapter{
	
	private ExpListHandler(Env e){
        super();
    }

    public static List<Type> secondpass(Env e, ClassInfo cinfo, MethodInfo minfo, List<Exp> expList) {
        
    	List<Type> typeListStart = null, typeListTail = null, nextnode;
    	Type type;
    	
		// Walk through the expList...
    	Exp exp;
        while (expList != null) {
            exp = expList.head;
            
            type = ExpHandler.secondpass(e, cinfo, minfo, exp); // ...calling the secondpass of each expression
            nextnode = new List<Type>(type,null);
            
            //If the typeList is not initialized, then do this
            if (typeListStart == null)
            	typeListStart = typeListTail = nextnode;
            //If it is initialized, append the next node to the end of the typelist
            else
            	typeListTail = (typeListTail.tail = nextnode);
            
            expList = expList.tail;
        }
    	
        return typeListStart;
    }
}
