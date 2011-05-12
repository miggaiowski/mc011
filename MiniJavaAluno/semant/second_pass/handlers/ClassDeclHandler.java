package semant.second_pass.handlers;

import semant.Env;
import symbol.ClassInfo;
import symbol.Symbol;
import syntaxtree.ClassDecl;
import syntaxtree.ClassDeclExtends;
import syntaxtree.ClassDeclSimple;
import syntaxtree.VisitorAdapter;

public class ClassDeclHandler extends VisitorAdapter{
	
	Env env;
	
	private ClassDeclHandler(Env e){
		super();
		env = e;
	}

	public static void secondpass(Env e, ClassDecl cd){
		ClassDeclHandler handler = new ClassDeclHandler(e);
		cd.accept(handler);
	}
	
	public void visit(ClassDeclSimple node){
        Symbol name = Symbol.symbol(node.name.s);
        ClassInfo cinfo = env.classes.get(name);
        
		//Do a secondpass in all the attributes of the class
		AttributeListHandler.secondpass(env,node.varList);        

		//Do a secondpass in all the methods of the class
		MethodDeclListHandler.secondpass(env, cinfo, node.methodList);
	}
	
    public void visit(ClassDeclExtends node){
        Symbol name = Symbol.symbol(node.name.s);
        ClassInfo info = new ClassInfo(name);
        
        //Do a secondpass in all the attributes of the class
        AttributeListHandler.secondpass(env,node.varList);        

        //Do a secondpass in all the methods of the class
        MethodDeclListHandler.secondpass(env, info, node.methodList);
    }
}
