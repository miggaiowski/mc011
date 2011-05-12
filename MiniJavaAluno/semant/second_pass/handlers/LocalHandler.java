package semant.second_pass.handlers;

import semant.Env;
import symbol.MethodInfo;
import symbol.Symbol;
import symbol.VarInfo;
import syntaxtree.Formal;
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
        Symbol name = Symbol.symbol(node.name.s);
        VarInfo varInfo = new VarInfo(node.type, name);
        
        // o que tem que conferir aqui?
		
	}
	
}
