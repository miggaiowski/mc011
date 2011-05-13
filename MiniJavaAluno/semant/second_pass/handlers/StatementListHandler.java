package semant.second_pass.handlers;

import semant.Env;
import symbol.ClassInfo;
import symbol.MethodInfo;
import syntaxtree.Statement;
import syntaxtree.VisitorAdapter;
import util.List;

public class StatementListHandler extends VisitorAdapter{
	
	private StatementListHandler(Env e){
        super();
    }

    public static void secondpass(Env env, ClassInfo classInfo, MethodInfo methodInfo, List<Statement> stmList) {
        // checking each of the statements
        while(stmList != null) {
            StatementHandler.secondpass(env, classInfo, methodInfo, stmList.head);
            stmList = stmList.tail;
        }
    }
}
