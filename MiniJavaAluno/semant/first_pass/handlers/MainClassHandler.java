package semant.first_pass.handlers;


import semant.Env;
import symbol.ClassInfo;
import symbol.Symbol;
import syntaxtree.Exp;
import syntaxtree.Formal;
import syntaxtree.Identifier;
import syntaxtree.IdentifierType;
import syntaxtree.MainClass;
import syntaxtree.MethodDecl;
import syntaxtree.Statement;
import syntaxtree.Type;
import syntaxtree.VarDecl;
import syntaxtree.VisitorAdapter;
import util.List;


public class MainClassHandler extends VisitorAdapter {

	private Env env;

	private MainClassHandler(Env e) {
		super();
		env = e;
	}
	
    public static void firstPass(Env e, MainClass mainClass) {
    	MainClassHandler handler = new MainClassHandler(e);
    	mainClass.accept(handler);
    }
    
    public void visit(MainClass node) {
    	Symbol name = Symbol.symbol(node.className.s);
    	ClassInfo info = new ClassInfo(name);
    	
    	Formal mainArg = new Formal(node.line, node.row, (Type) new IdentifierType(node.line, node.row, "String [] "), node.mainArgName);
    	List<Formal> fl = new List<Formal>(mainArg,null);
    	List<Statement> sl = new List<Statement>(node.s,null);
    	
    	MethodDecl md = new MethodDecl(node.line, node.row,(Type) new IdentifierType(node.line, node.row, "void "), new Identifier(node.line, node.row, "main "), fl, (List<VarDecl>) null , sl, (Exp)null);
    	
    	MethodDeclHandler.firstPass(env, info, md);
    	
    	
    	if (!env.classes.put(name, info)) {
    		env.err.Error(node, new Object[]{"Nome de classe redefinido", "Simbolo: " + name});
    	}
    }

}
