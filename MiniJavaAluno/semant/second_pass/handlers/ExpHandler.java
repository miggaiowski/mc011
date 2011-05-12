package semant.second_pass.handlers;

import semant.Env;
import symbol.ClassInfo;
import symbol.MethodInfo;
import symbol.Symbol;
import symbol.VarInfo;
import syntaxtree.And;
import syntaxtree.ArrayLength;
import syntaxtree.ArrayLookup;
import syntaxtree.BooleanType;
import syntaxtree.Call;
import syntaxtree.Equal;
import syntaxtree.Exp;
import syntaxtree.False;
import syntaxtree.IdentifierExp;
import syntaxtree.IdentifierType;
import syntaxtree.IntegerLiteral;
import syntaxtree.IntegerType;
import syntaxtree.LessThan;
import syntaxtree.Minus;
import syntaxtree.NewArray;
import syntaxtree.NewObject;
import syntaxtree.Not;
import syntaxtree.Plus;
import syntaxtree.This;
import syntaxtree.Times;
import syntaxtree.True;
import syntaxtree.Type;
import syntaxtree.TypeVisitorAdapter;
import util.List;

public class ExpHandler extends TypeVisitorAdapter{
	
	Env env;
	ClassInfo classInfo;
	MethodInfo methodInfo;
	
	private ExpHandler(Env e, ClassInfo ci, MethodInfo mi) {
		super();
		env = e;
        classInfo = ci;
        methodInfo = mi;
	}
	
	
	public static Type secondpass(Env e, ClassInfo ci, MethodInfo mi, Exp exp){
		ExpHandler handler = new ExpHandler(e, ci, mi);		
		return exp.accept(handler);
	}
	
	//***** AND *****//
	public Type visit(And node){
	    // Second pass on both left and right hand side expressions
        Type leftExp = ExpHandler.secondpass(env, classInfo, methodInfo, node.lhs);
        Type rightExp = ExpHandler.secondpass(env, classInfo, methodInfo, node.rhs);
        
        // The expressions must return a type BooleanType!
        if (!(leftExp instanceof BooleanType)) {
            env.err.Error(node.lhs, new Object[]{"Tipo invalido para o lado esquerdo do operador \'&&\'.",
                    "Esperado: boolean," +
                    "Encontrado: " + leftExp}
            );
        }
        if(!(rightExp instanceof BooleanType)){
            env.err.Error(node.rhs, new Object[]{"Tipo invalido para o lado direito do operador \'<\'.",
                                                 "Esperado: int," +
                                                 "Encontrado: " + leftExp}
            );
        }
        return node.type = new BooleanType(node.line, node.row);
	}
	
	//***** EQUAL *****//
	public Type visit(Equal node){
	    // Second pass on both left and right hand side expressions
        Type leftExp = ExpHandler.secondpass(env, classInfo, methodInfo, node.lhs);
        Type rightExp = ExpHandler.secondpass(env, classInfo, methodInfo, node.rhs);
        
        // The expressions must have the same Type
        if (!(leftExp.getClass() == rightExp.getClass())) {
            env.err.Error(node.lhs, new Object[]{"Tipos diferentes sendo comparados com operador \'==\'.",
                    "Tipo do LHS: " + leftExp,
                    "Tipo do RHS: " + rightExp}
            );
        }
        return node.type = new BooleanType(node.line, node.row);
	}
	
	//***** LESS THAN *****//
	public Type visit(LessThan node){	    
		//First we do a secondpass in the left and right statements
		Type leftExp = ExpHandler.secondpass(env, classInfo, methodInfo, node.lhs);
		Type rightExp = ExpHandler.secondpass(env, classInfo, methodInfo, node.rhs);
		
		//The statements types must be IntegerType, if not, an error message is shown
		if(!(leftExp instanceof IntegerType)){
			env.err.Error(node.lhs, new Object[]{"Tipo invalido para o lado esquerdo do operador \'<\'.",
					                             "Esperado: int," +
					                             "Encontrado: " + leftExp}
			);
		}	
		if(!(rightExp instanceof IntegerType)){
			env.err.Error(node.rhs, new Object[]{"Tipo invalido para o lado direito do operador \'<\'.",
					                             "Esperado: int," +
					                             "Encontrado: " + leftExp}
			);
		}
		
		//Returning an error or not, we assume its ok to continue the type checking
		return node.type = new BooleanType(node.line, node.row);
	}
	
	//***** TIMES *****//
	public Type visit(Times node){
		//Both sides of the expression must be IntegerTypes
		if (!(node.lhs.accept(this) instanceof IntegerType))
			env.err.Error(node, new Object[]{"Left side of the expression must be an IntegerType"});
		if (!(node.rhs.accept(this) instanceof IntegerType))
			env.err.Error(node, new Object[]{"Left side of the expression must be an IntegerType"});
		
		//Return an Integer type if its ok, and if there was an error too, to continue the second pass
		return new IntegerType(node.line, node.row);
	}
	
	//***** PLUS *****//
	public Type visit(Plus node){
		//Both sides of the expression must be IntegerTypes
		if (!(node.lhs.accept(this) instanceof IntegerType))
			env.err.Error(node, new Object[]{"Left side of the expression must be an IntegerType"});
		if (!(node.rhs.accept(this) instanceof IntegerType))
			env.err.Error(node, new Object[]{"Left side of the expression must be an IntegerType"});
		
		//Return an Integer type if its ok, and if there was an error too, to continue the second pass
		return new IntegerType(node.line, node.row);
	}
	
	//***** MINUS *****//
	public Type visit(Minus node){
		//Both sides of the expression must be IntegerTypes
		if (!(node.lhs.accept(this) instanceof IntegerType))
			env.err.Error(node, new Object[]{"Left side of the expression must be an IntegerType"});
		if (!(node.rhs.accept(this) instanceof IntegerType))
			env.err.Error(node, new Object[]{"Left side of the expression must be an IntegerType"});
		
		//Return an Integer type if its ok, and if there was an error too, to continue the second pass
		return new IntegerType(node.line, node.row);
	}
	
	//***** ARRAY LOOKUP *****//
	public Type visit(ArrayLookup node){
		//TODO: implement
	    return null;
	}
	
	//***** ARRAY LENGTH *****//
	public Type visit(ArrayLength node){
		//TODO: implement
	    return null;
	}
	
	//***** CALL *****//
	public Type visit(Call node){
		//Get the type of the caller of the method
		Type type = ExpHandler.secondpass(env, classInfo, methodInfo, node.object);
		Symbol methodName = Symbol.symbol(node.method.s);
		
		//If the type returned is not an IdentifierType, then it's not class
		if ( !(type instanceof IdentifierType)){
			env.err.Error(node, new Object[]{"Chamada de metodo aplicada a tipo invalido",
					                         "Esperado: <class>",
					                         "Encontrado: " + type}
			);
			//After the error, suppose this call returns an integer type to continue the secondpass
			return node.type = new IntegerType(node.line, node.row);
		}
		
		//Well so the caller is a class
		IdentifierType classId = (IdentifierType) type;
		
		//Try to find out if the method called exists in this class
		MethodInfo method = getMethod(Symbol.symbol(classId.name), methodName);
		
		//If it doesn't exists, an error message is shown and we suposse the call returned an IntegerType 
		if (method == null){
			env.err.Error(node, new Object[]{"Metodo " + method + " nao definido para a classe \'" + classId.name + "\'"});
			return node.type = new IntegerType(node.line, node.row);
		}
		
		//Now we know that the method can be called in the given class, but we must check the parameters too
		List<Type> actuals = ExpListHandler.secondpass(env, classInfo, methodInfo, node.actuals); //actual parameters
		List<VarInfo> formals; //formal parameters
		int i;
		
		//Check if all the parameters are compatible
		for (formals = method.formals, i = 1; actuals != null && formals != null; actuals = actuals.tail, formals = formals.tail, i++){
			if (!(TypeHandler.compatible(env, formals.head.type, actuals.head))){
				env.err.Error(node, new Object[]{"Tipo do argumento #" + i + " para o metodo " + classId.name + "." + method.name + "nao eh compativel.",
                                                 "Esperado: " + formals.head.type,
                                                 "Encontrado: " + actuals.head}
				);
			}
		}
		
		//If the parameters check finished but there stil are actuals or formals, then the # of args are invalid
		if (actuals != null || formals != null)
			env.err.Error(node, new Object[]{"Numero de parametros invalido para o metodo " + classId.name + "." + method.name + "."});
		
		//If everything is all right, the method called returns its standard return Type
		return node.type = method.type;
		
	}
	
	//***** INTEGER LITERAL *****//
	public Type visit(IntegerLiteral node){
		// só retorna o tipo do nó
	    return node.type = new IntegerType(node.line, node.row);
	}
	
	//***** TRUE *****//
	public Type visit(True node){
	    // Basta retornar o tipo do nó
	    return node.type = new BooleanType(node.line, node.row);
	}
	
	//***** FALSE *****//
	public Type visit(False node){
	    // Basta retornar o tipo do nó
        return node.type = new BooleanType(node.line, node.row);
	}
	
	//***** IDENTIFIER EXP *****//
	public Type visit(IdentifierExp node){
		//Look if the identifier exists in the method or class
		Symbol name = Symbol.symbol(node.name.s);
		VarInfo varinfo = ExpHandler.getVariable(classInfo, methodInfo, name);
		
		//If the identifier was not found, an error message is shown and...
		if (varinfo == null){
			env.err.Error(node, new Object[]{"Identificador \'" + name +
					                         "\' nao definido no metodo atual."}
			);
			//We assume its an IntegerType
			return new IntegerType(node.line, node.row);
		}
		
		//If the identifier was found, return its type
		return node.type = varinfo.type;
	}
	
	//***** THIS *****//
	public Type visit(This node){
		//TODO: implement
	    if (classInfo == null) {
	           env.err.Error(node, new Object[]{"\'this\' utilizado na MainClass."}
	           );
	    }
	    return null;
	}
	
	//***** NEW ARRAY *****//
	public Type visit(NewArray node){
		//TODO: implement
	    return null;
	}
	
	//***** NEW OBJECT *****//
	public Type visit(NewObject node){
		//TODO: implement
	    return null;
	}
	
	//***** NOT *****//
	public Type visit(Not node){
		//TODO: implement
	    return null;
	}

	
	
	
	//***** Auxiliar Methods *****//
	
	//Get variables according to the context, call it with care
	static VarInfo getVariable(ClassInfo cinfo, MethodInfo minfo, Symbol symbol) {
		
		VarInfo varinfo = null;
		
		//TODO: Essa sequencia procura com a seguinte prioridade: local > parametro > atributo, tá certo isso?
		
		//If there is a method...
		if (minfo != null){
			//First we check if the variable is a local of the method
			if (minfo.localsTable.containsKey(symbol)){
				varinfo = minfo.localsTable.get(symbol);
				return varinfo;
			}
			//If its not a local, maybe its a formal of the method
			else if (minfo.formalsTable.containsKey(symbol)){
				varinfo = minfo.formalsTable.get(symbol);
				return varinfo;
			}
		}
		
		//Well, if its has nothing to do with a method, maybe is an attribute of the class
		if (cinfo.attributes.containsKey(symbol) )
				varinfo = cinfo.attributes.get(symbol);
    		
		return varinfo;
	}
	
	private MethodInfo getMethod(Symbol className, Symbol methodName){
		//Return null if the class doesnt exists
		//Return null if the method doesnt exists in the specified class
		return env.classes.env.peek().get(className).methods.get(methodName);
	}
	
}
