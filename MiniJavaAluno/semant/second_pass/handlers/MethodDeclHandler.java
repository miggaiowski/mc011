package semant.second_pass.handlers;

import semant.Env;
import symbol.ClassInfo;
import symbol.MethodInfo;
import symbol.Symbol;
import symbol.VarInfo;
import syntaxtree.MethodDecl;
import syntaxtree.Type;
import syntaxtree.VisitorAdapter;
import util.List;

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
                    "Esperado: " + node.returnType.toString(),
                    "Encontrado: " + returnExpType.toString() }
            );  
        }
        
        // checar se a classe deste método herda de outra
        // se sim, procurar este método nas classes pai 
        // se encontrar, verificar tipo de retorno.
        // overload só pode se o tipo de retorno for igual
        
        
        ClassInfo baseClassInfo = classInfo.base;
        
        // checa se o metodo ja foi definido nas classes base
        while (baseClassInfo != null){
        	if(baseClassInfo.methods.containsKey(name)){
        		//se foi definido anteriormente, confere se as definicoes sao compativeis
        		MethodInfo baseMethodInfo = baseClassInfo.methods.get(name);
        		
        		// mostra uma mensagem de erro se os tipos de retorno nao forem iguais
        		if ((baseMethodInfo.type).getClass() != (methodInfo.type).getClass()){
        			env.err.Error(node, new Object[]{"Redefinicao do metodo \'" + methodInfo.name.toString() + "\' na classe \'" + classInfo.name.toString() + "\' possue tipo de retorno diferente.",
                            "Esperado: " + baseMethodInfo.type.toString(),
                            "Encontrado: " + methodInfo.type.toString() }
                    );  
        		}
        		
        		// mostra uma mensagem de erro se o numero de parametros nao forem iguais
        		if (baseMethodInfo.formals.size() != methodInfo.formals.size()){
        			env.err.Error(node, new Object[]{"Redefinicao do metodo \'" + methodInfo.name.toString() + "\' na classe \'" + classInfo.name.toString() + "\' possue numero de parametros diferente.",
                            "Esperado: " + baseMethodInfo.formals.size(),
                            "Encontrado: " + methodInfo.formals.size() }
                    );  
        		}
        		
        		// mostra uma mensagem de erro se os tipos dos parametros nao forem iguais
        		List<VarInfo> baseFormalsList = baseMethodInfo.formals;
        		List<VarInfo> formalsList = methodInfo.formals;
        		
        		// percorre por todos os parametros, e mostra uma mensagem para os que não forem compativeis
        		for( ; baseFormalsList != null && formalsList != null; baseFormalsList = baseFormalsList.tail, formalsList = formalsList.tail){
	        		if ( (baseFormalsList.head.type).getClass() != (formalsList.head.type).getClass()){
	        			env.err.Error(node, new Object[]{"Redefinicao do metodo \'" + methodInfo.name.toString() + "\' possue tipo do parametro \'" + formalsList.head.name + "\' diferente da definicao anterior.",
	                            "Esperado: " + baseFormalsList.head.type.toString(),
	                            "Encontrado: " + formalsList.head.type.toString() }
	                    );  
	        		}
        		}
        	}
        	
        	baseClassInfo = baseClassInfo.base;
        }
        
        	
        
        
        // second pass no corpo do método
        StatementListHandler.secondpass(env, classInfo, methodInfo, node.body);
        
	}
	
}
