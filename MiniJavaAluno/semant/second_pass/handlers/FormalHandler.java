package semant.second_pass.handlers;

import semant.Env;
import symbol.ClassInfo;
import symbol.MethodInfo;
import symbol.Symbol;
import symbol.VarInfo;
import syntaxtree.ClassDecl;
import syntaxtree.Formal;
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
        Symbol name = Symbol.symbol(node.name.s);
        VarInfo varInfo = new VarInfo(node.type, name);
        
        // o que tem que conferir aqui?
		
	}
	
}
