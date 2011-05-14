package semant.second_pass.handlers;

import semant.Env;
import symbol.MethodInfo;
import symbol.Symbol;
import syntaxtree.IdentifierType;
import syntaxtree.VarDecl;
import syntaxtree.VisitorAdapter;

public class LocalHandler extends VisitorAdapter{
	
	Env env;
	MethodInfo methodInfo;
	
	private LocalHandler(Env e, MethodInfo mi){
		super();
		env = e;
		methodInfo = mi;
	}

	public static void secondpass(Env e, MethodInfo methodInfo, VarDecl varDecl){
		LocalHandler handler = new LocalHandler(e, methodInfo);
		varDecl.accept(handler);
	}
	
	public void visit(VarDecl node){
		
		//There is a problem only when the type is an identifier type
		if (node.type instanceof IdentifierType){
			
			IdentifierType nodeType = (IdentifierType) node.type;
			Symbol name = Symbol.symbol(nodeType.name);
			
			//If the type of the local is not a class, nor one of the standard types, an error is shown
			if (!env.classes.env.peek().containsKey(name))
				env.err.Error(node, new Object[]{"O tipo do parametro " + node.name + " eh invalido."});
		}
		
	}
	
}
