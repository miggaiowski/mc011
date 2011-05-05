package semant.first_pass.handlers;

import semant.Env;
import symbol.ClassInfo;
import symbol.Symbol;
import syntaxtree.MainClass;
import syntaxtree.VisitorAdapter;

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
    	
    	// TODO Fazer aqui o firstPass do método main
    	
    	
    	if (!env.classes.put(name, info)) {
    		env.err.Error(node, new Object[]{"Nome de classe redefinido", "Simbolo: " + name});
    	}
    }

}
