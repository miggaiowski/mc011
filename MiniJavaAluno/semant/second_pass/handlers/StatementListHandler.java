package semant.second_pass.handlers;

import semant.Env;
import symbol.MethodInfo;
import syntaxtree.Statement;
import syntaxtree.VisitorAdapter;
import util.List;

public class StatementListHandler extends VisitorAdapter{
	
	private StatementListHandler(Env e){
        super();
    }

    public static void secondpass(Env env, MethodInfo methodInfo, List<Statement> stmList) {
        // checking each of the statements
        while(stmList != null) {
            StatementHandler.secondpass(env, methodInfo, stmList.head);
            stmList = stmList.tail;
        }
    }
}
