package semant.second_pass.handlers;

import semant.Env;
import symbol.ClassInfo;
import symbol.MethodInfo;
import symbol.Symbol;
import syntaxtree.MethodDecl;
import syntaxtree.Type;
import syntaxtree.VisitorAdapter;

public class MethodDeclHandler extends VisitorAdapter{
	
	Env env;
	ClassInfo classInfo;
	
	private MethodDeclHandler(Env e, ClassInfo ci){
		super();
		env = e;
		classInfo = ci;
	}

	public static void secondpass(Env e, ClassInfo ci, MethodDecl cd){
		MethodDeclHandler handler = new MethodDeclHandler(e, ci);
		cd.accept(handler);
	}
	
	public void visit(MethodDecl node){
        Symbol name = Symbol.symbol(node.name.s);
        MethodInfo methodInfo = env.classes.env.peek().get(classInfo.name).methods.get(name);
	    
        // confere lista de formals
        FormalListHandler.secondpass(env, methodInfo, node.formals);
        
        // confere lista de locals
        LocalListHandler.secondpass(env, methodInfo, node.locals);
        
        // confere returnExp com returnType
        Type returnExpType = ExpHandler.secondpass(env, classInfo, methodInfo, node.returnExp);
        
        if ((returnExpType).getClass() != (node.returnType).getClass()) {
            env.err.Error(node, new Object[]{"Tipo de retorno inválido para o método \'" + methodInfo.name.toString() + "\' da classe \'" + classInfo.name.toString() + "\'.",
                    "Linha: " + returnExpType.line,
                    "Esperado: " + node.returnType.toString(),
                    "Encontrado: " + returnExpType.toString() }
            );  
        }
        
        // checar se a classe deste método herda de outra
        // se sim, procurar este método nas classes pai 
        // se encontrar, verificar tipo de retorno.
        // overload só pode se o tipo de retorno for igual
        
        // second pass no corpo do método
        StatementListHandler.secondpass(env, classInfo, methodInfo, node.body);
        
	}
	
}
