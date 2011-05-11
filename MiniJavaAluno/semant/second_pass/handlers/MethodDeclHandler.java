package semant.second_pass.handlers;

import semant.Env;
import syntaxtree.ClassDecl;
import syntaxtree.MethodDecl;
import syntaxtree.VisitorAdapter;

public class MethodDeclHandler extends VisitorAdapter{
	
	Env env;
	
	private MethodDeclHandler(Env e){
		super();
		env = e;
	}

	public static void secondpass(Env e, MethodDecl cd){
		MethodDeclHandler handler = new MethodDeclHandler(e);
		cd.accept(handler);
	}
	
	public void visit(MethodDecl node){
	    
	}
	
}
