package semant.second_pass.handlers;

import semant.Env;
import symbol.ClassInfo;
import symbol.Symbol;
import syntaxtree.MainClass;
import syntaxtree.VisitorAdapter;

public class MainClassHandler extends VisitorAdapter{
	
	private Env env;
	
	private MainClassHandler(Env e) {
		super();
		env = e;
	}
	
	public static void secondpass(Env e, MainClass mainClass) {
    	MainClassHandler handler = new MainClassHandler(e);
    	mainClass.accept(handler);
    }
	
	public void visit (MainClass node){
		Symbol name = Symbol.symbol(node.className.s);
		ClassInfo classinfo = env.classes.get(name);
		
		//The only thing that is really important in the mainclass are its statements
		StatementHandler.secondpass(env,classinfo,null,node.s);
	}
}
