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
	}
	
	//***** ARRAY LENGTH *****//
	public Type visit(ArrayLength node){
		//TODO: implement
	}
	
	//***** CALL *****//
	public Type visit(Call node){
		//TODO: implement
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
	    // Check is 'this' was used inside the mainclass
	    // The methodinfo should be null if this comes from the mainclass
	    
	    if (this.methodInfo == null) {
	        env.err.Error(node, new Object[]{"Expressão \'this\' usada dentro da MainClass."});
	        return null;
	    }
	    
	    //TODO: Falta coisa aqui, só fiz esse erro da mainclass!!!
	    
	    return null; // arrumar isso, nao é sempre null nao!
	}
	
	//***** NEW ARRAY *****//
	public Type visit(NewArray node){
		//TODO: implement
	}
	
	//***** NEW OBJECT *****//
	public Type visit(NewObject node){
		//TODO: implement
	}
	
	//***** NOT *****//
	public Type visit(Not node){
		//TODO: implement
	}

	
	
	
	//***** Auxiliar Method *****//
	
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
	
}
