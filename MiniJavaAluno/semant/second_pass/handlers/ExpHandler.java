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
	
	
	public Type visit(And node){
		//TODO: implement
		return node.type; //DELETE THIS!, its just here to avoid the annoying error messages
	}
	
	public Type visit(Equal node){
		//TODO: implement
		return node.type; //DELETE THIS!, its just here to avoid the annoying error messages
	}
	
	public Type visit(LessThan node){
		//First we do a secondpass in the left and right statements
		Type leftStatement = ExpHandler.secondpass(env, classInfo, methodInfo, node.lhs);
		Type rightStatement = ExpHandler.secondpass(env, classInfo, methodInfo, node.rhs);
		
		//The statements types must be IntegerType, if not, an error message is shown
		if(!(leftStatement instanceof IntegerType)){
			env.err.Error(node.lhs, new Object[]{"Tipo invalido para o lado esquerdo do operador \'<\'.",
					                             "Esperado: int," +
					                             "Encontrado: " + leftStatement}
			);
		}	
		if(!(rightStatement instanceof IntegerType)){
			env.err.Error(node.rhs, new Object[]{"Tipo invalido para o lado direito do operador \'<\'.",
					                             "Esperado: int," +
					                             "Encontrado: " + leftStatement}
			);
		}
		
		//Returning an error or not, we assume its ok to continue the type checking
		return node.type = new BooleanType(node.line, node.row);
	}
	
	public Type visit(Times node){
		//TODO: implement
		return node.type; //DELETE THIS!, its just here to avoid the annoying error messages
	}
	
	public Type visit(Plus node){
		//TODO: implement
		return node.type; //DELETE THIS!, its just here to avoid the annoying error messages
	}
	
	public Type visit(Minus node){
		//TODO: implement
		return node.type; //DELETE THIS!, its just here to avoid the annoying error messages
	}
	
	public Type visit(ArrayLookup node){
		//TODO: implement
		return node.type; //DELETE THIS!, its just here to avoid the annoying error messages
	}
	
	public Type visit(ArrayLength node){
		//TODO: implement
		return node.type; //DELETE THIS!, its just here to avoid the annoying error messages
	}
	
	public Type visit(Call node){
		//TODO: implement
		return node.type; //DELETE THIS!, its just here to avoid the annoying error messages
	}
	
	public Type visit(IntegerLiteral node){
		//TODO: implement
		return node.type; //DELETE THIS!, its just here to avoid the annoying error messages
	}
	
	public Type visit(True node){
		//TODO: implement
		return node.type; //DELETE THIS!, its just here to avoid the annoying error messages
	}
	
	public Type visit(False node){
		//TODO: implement
		return node.type; //DELETE THIS!, its just here to avoid the annoying error messages
	}
	
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
	
	public Type visit(This node){
		//TODO: implement
		return node.type; //DELETE THIS!, its just here to avoid the annoying error messages
	}
	
	public Type visit(NewArray node){
		//TODO: implement
		return node.type; //DELETE THIS!, its just here to avoid the annoying error messages
	}
	
	public Type visit(NewObject node){
		//TODO: implement
		return node.type; //DELETE THIS!, its just here to avoid the annoying error messages
	}
	
	public Type visit(Not node){
		//TODO: implement
		return node.type; //DELETE THIS!, its just here to avoid the annoying error messages
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
