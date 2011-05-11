package semant.second_pass.handlers;

import semant.Env;
import symbol.ClassInfo;
import symbol.Symbol;
import syntaxtree.BooleanType;
import syntaxtree.IdentifierType;
import syntaxtree.IntArrayType;
import syntaxtree.IntegerType;
import syntaxtree.Type;

final class TypeHandler{
	
	
	//Called by the StatementHandler->Assing to check if the lhs and rhs of the assignment are compatible
	public static final boolean compatible(Env e, Type target, Type source){
		
		//No enheritance types
		//Check if the result of the right side of the assign
		if (target instanceof IntegerType)
			return (source instanceof IntegerType);
		else if (target instanceof BooleanType)
			return (source instanceof BooleanType);
		else if (target instanceof IntArrayType)
			return (source instanceof IntArrayType);
		
		//If the target is not a primary type, it can only be an Identifier, 
		//and if the source is not an Identifier too, return false
		if (!(source instanceof IdentifierType))
			return false;
		
		//Well so lets check the compatibility between the identifiers that are supposed to be classes
		Symbol targetClassName = Symbol.symbol(((IdentifierType)target).name);
		Symbol sourceClassName = Symbol.symbol(((IdentifierType)source).name);
		
		ClassInfo targetClass = e.classes.get(targetClassName);
		ClassInfo sourceClass = e.classes.get(sourceClassName);
		
		//Check the compatibility between them
		return compatible(e, targetClass, sourceClass);
	}
	
	//Called to check the compatibility between two classes, note that they can be passed as null
	public static final boolean compatible(Env e, ClassInfo target, ClassInfo source){
		
		//Maybe target was not a class at all
		if (target == null)
			return false;
		
		//Check if the target is compatible with source, walking through the whole source inheritance line
		while (source != null)
			if (target.name == source.name)
				return true;
			else
				source = source.base;
		
		//At last, if source does have nothing to do with target, return false
		return false;
	}
	
}