package semant.second_pass.handlers;

import semant.Env;
import syntaxtree.Type;
import syntaxtree.TypeVisitorAdapter;
import syntaxtree.VarDecl;
import syntaxtree.VisitorAdapter;

public class AttributeHandler extends VisitorAdapter{
	
	Env env;
	
	private AttributeHandler(Env e) {
		super();
		env = e;
	}
	
	
	public static void secondpass(Env e, VarDecl v){
		AttributeHandler handler = new AttributeHandler(e);
		v.accept(handler);
	}
	
	public Type visit(VarDecl node){
		//TODO: Precisamos desse handler?
	}
}