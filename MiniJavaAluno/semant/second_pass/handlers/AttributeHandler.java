package semant.second_pass.handlers;

import semant.Env;
import syntaxtree.Type;
import syntaxtree.TypeVisitorAdapter;
import syntaxtree.VarDecl;

public class AttributeHandler extends TypeVisitorAdapter{
	
	Env env;
	
	private AttributeHandler(Env e) {
		super();
		env = e;
	}
	
	
	public static Type secondpass(Env e, VarDecl v){
		AttributeHandler handler = new AttributeHandler(e);
		return v.accept(handler);
	}
	
	public Type visit(VarDecl node){
		//TODO: Precisamos desse handler?
	}
}