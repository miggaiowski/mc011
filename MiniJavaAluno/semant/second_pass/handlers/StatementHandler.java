package semant.second_pass.handlers;

import semant.Env;
import semant.EnvSearch;
import symbol.ClassInfo;
import symbol.MethodInfo;
import symbol.Symbol;
import symbol.VarInfo;
import syntaxtree.ArrayAssign;
import syntaxtree.Assign;
import syntaxtree.Block;
import syntaxtree.BooleanType;
import syntaxtree.If;
import syntaxtree.IntegerType;
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
	
	//***** BLOCK *****//
	public void visit (Block node) {  
	    // Check each statement from the list
	    while (node.body != null) {
	        StatementHandler.secondpass(env, classInfo, methodInfo, node.body.head);
	        node.body = node.body.tail;
	    }
	}
	
	//***** IF *****//
	public void visit (If node) {
	    // Second pass on the condition expression
        Type condition = ExpHandler.secondpass(env,classInfo,methodInfo,node.condition);
        
        // This condition must be of type BooleanType
        if (!(condition instanceof BooleanType) ){
            env.err.Error(node, new Object[]{"Tipo invalido para condicao do \'while\'.",
                                             "Esperado: boolean",
                                             "Encontrado: " + condition }
            );
        }

        // Checking the statements from thenClause
        StatementHandler.secondpass(env, classInfo, methodInfo, node.thenClause);

        if (node.elseClause != null)
        	// Must also check the statement from elseClause
        	StatementHandler.secondpass(env, classInfo, methodInfo, node.elseClause);        
	}
	
	//***** WHILE *****//
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
	
	//***** PRINT *****//
	public void visit (Print node){
	    // Check the expression to be printed out
	    Type exp = ExpHandler.secondpass(env,classInfo,methodInfo,node.exp);
	    
	    if (!(exp instanceof IntegerType) ){
	        env.err.Error(node, new Object[]{"Tipo invalido para expressão do \'print\'.",
	                "Esperado: int",
	                "Encontrado: " + exp }
	        );
	    }
	}
	
	//***** ASSIGN *****//
	public void visit (Assign node){
		//Get the variable that is the left hand side of the assignment
		Symbol name = Symbol.symbol(node.var.s);
		VarInfo varinfo = EnvSearch.getVariable(classInfo,methodInfo,name);
		
		//If the variable doesnt exist, an error message is shown and the secondpass continues
		if (varinfo == null)
			env.err.Error(node, new Object[]{"Variavel nao declarada.",
					                         "Simbolo: " + name}
			);
		
		//Get the type of the right hand side expression
		Type type = ExpHandler.secondpass(env, classInfo, methodInfo, node.exp);
		
		//If the lhs and rhs terms are not compatible, it's an error
		if (varinfo != null && !TypeHandler.compatible(env, varinfo.type, type))
			env.err.Error(node, new Object[]{"Expressao da atribuicao incompativel com o tipo da variavel.",
                                             "Esperado: " + varinfo.type,
                                             "Encontrado: " + type}
            );
	}

	//***** ARRAY ASSIGN *****//
	public void visit (ArrayAssign node){
		//Get the variable that is the left hand side of the assignment
		Symbol name = Symbol.symbol(node.var.s);
		VarInfo varinfo = EnvSearch.getVariable(classInfo,methodInfo,name);
		
		//If the variable doesnt exist, an error message is shown and the secondpass continues
		if (varinfo == null)
			env.err.Error(node, new Object[]{"Variavel nao declarada.",
					                         "Simbolo: " + name}
			);
		
		//Get the type of the index expression
		Type indexType = ExpHandler.secondpass(env, classInfo, methodInfo, node.index);
		//If the index is not a integer, an error message is shown and the secondpass continues
		if (!(indexType instanceof IntegerType))
			env.err.Error(node, new Object[]{"O indice do vetor eh de um tipo invalido.",
                                             "Esperado: int",
                                             "Encontrado: " + indexType}
			);
		
		//Get the type of the right hand side expression
		Type rhsType = ExpHandler.secondpass(env, classInfo, methodInfo, node.value);
		//If the type of the right expression is not integer, an error message is shown and the secondpass continues
		if (!(indexType instanceof IntegerType))
			env.err.Error(node, new Object[]{"Expressao da atribuicao incompativel com o tipo do vetor.",
                                             "Esperado: int",
                                             "Encontrado: " + rhsType}
			);
	}

}
