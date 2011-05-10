package semant.second_pass.handlers;

import semant.Env;
import symbol.ClassInfo;
import symbol.MethodInfo;
import syntaxtree.ArrayAssign;
import syntaxtree.Assign;
import syntaxtree.Block;
import syntaxtree.BooleanType;
import syntaxtree.If;
import syntaxtree.Print;
import syntaxtree.Statement;
import syntaxtree.Type;
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
		//First we do the secondpass in the condition expression
		Type condition = ExpHandler.secondpass(env,classInfo,methodInfo,node.condition);
		
		//The condition type must be boolean, if not, an error message is shown
		if (!(condition instanceof BooleanType) ){
			env.err.Error(node, new Object[]{"Tipo invalido para condicao do \'while\'.",
					                         "Esperado: boolean",
					                         "Encontrado: " + condition }
			);
		}
		
		//Returning an error or not, we assume its ok to continue the type checking
		StatementHandler.secondpass(env, classInfo, methodInfo, node.body);
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
