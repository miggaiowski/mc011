package semant.second_pass.handlers;

import semant.Env;
import symbol.MethodInfo;
import symbol.Symbol;
import syntaxtree.Formal;
import syntaxtree.IdentifierType;
import syntaxtree.VisitorAdapter;

public class FormalHandler extends VisitorAdapter{
	
	Env env;
	MethodInfo methodInfo;
	
	private FormalHandler(Env e, MethodInfo mi){
		super();
		env = e;
		methodInfo = mi;
	}

	public static void secondpass(Env e, MethodInfo methodInfo, Formal formal){
		FormalHandler handler = new FormalHandler(e, methodInfo);
		formal.accept(handler);
	}
	
	public void visit(Formal node){

        //There is a problem only when the type is an identifier type
		if (node.type instanceof IdentifierType){
			
			IdentifierType nodeType = (IdentifierType) node.type;
			Symbol name = Symbol.symbol(nodeType.name);
			
			//If the type of the formal is not a class, nor one of the standard types, an error is shown
			if (!env.classes.env.peek().containsKey(name))
				env.err.Error(node, new Object[]{"O tipo do parametro " + node.name + " eh invalido."});
		}
		
	}
	
}
