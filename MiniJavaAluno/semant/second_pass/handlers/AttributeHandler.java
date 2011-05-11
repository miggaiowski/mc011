package semant.second_pass.handlers;

import semant.Env;
import syntaxtree.IdentifierType;
import syntaxtree.Type;
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
	
	public void visit(VarDecl node){
		
		//There is a problem only when the type is of the identifier type
		if (node.type instanceof IdentifierType){
			
			IdentifierType nodeType = (IdentifierType) node.type;
		    
			//If the type of the attribute is not a class, nor one of the standard types, an error is shown
			if (!env.classes.env.peek().containsKey(nodeType.name))
				env.err.Error(node, new Object[]{"O tipo do atributo " + node.name + " eh invalido."});
		}
	}
}