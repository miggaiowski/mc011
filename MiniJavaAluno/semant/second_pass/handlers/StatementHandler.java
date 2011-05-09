package semant.second_pass.handlers;

import semant.Env;
import symbol.ClassInfo;
import symbol.MethodInfo;
import syntaxtree.ArrayAssign;
import syntaxtree.Assign;
import syntaxtree.Block;
import syntaxtree.If;
import syntaxtree.Print;
import syntaxtree.Statement;
import syntaxtree.VisitorAdapter;
import syntaxtree.While;

public class StatementHandler extends VisitorAdapter{
	
	Env env;
	ClassInfo classInfo;
	MethodInfo methodInfo;
	
	private StatementHandler(Env e, ClassInfo ci, MethodInfo mi){
        super();
        env = e;
        classInfo = ci;
        methodInfo = mi;
    }
	
	public static void secondpass(Env e, ClassInfo ci, MethodInfo mi, Statement stm){
		StatementHandler handler = new StatementHandler(e,ci,mi);
		stm.accept(handler);
	}
	
	public void visit (Block node){
		//TODO: implement
	}
	
	public void visit (If node){
		//TODO: implement
	}
	
	public void visit (While node){
		//TODO: implement
	}
	
	public void visit (Print node){
		//TODO: implement
	}
	
	public void visit (Assign node){
		//TODO: implement
	}

	public void visit (ArrayAssign node){
		//TODO: implement
	}
}
