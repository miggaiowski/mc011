package util;

import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Stack;

import semant.Env;
import symbol.ClassInfo;
import symbol.MethodInfo;
import symbol.Symbol;
import symbol.VarInfo;

public class EnvPrint {

	//***** Attributes *****//
	private Stack<Hashtable<Symbol,ClassInfo>> initStack;
	private int ident;
	
	
	//***** Constructor *****//
	public EnvPrint(Env e){
		initStack = e.classes.env;
	}
	
	
	//***** Methods *****//
	public void print(){
		printEnvClasses(initStack);
	}


	private void printEnvClasses(Stack<Hashtable<Symbol, ClassInfo>> classStack) {
		
		for(Enumeration<ClassInfo> enumer = classStack.peek().elements(); enumer.hasMoreElements(); ){
			ClassInfo cinfo = enumer.nextElement();
			System.out.println("class: " + cinfo.name);
			printClassAttributes(cinfo);
			printClassMethods(cinfo);
		}
	}


	private void printClassAttributes(ClassInfo cinfo) {
		
		for(Enumeration<VarInfo> enumer = cinfo.attributes.elements(); enumer.hasMoreElements(); ){
			VarInfo vinfo = enumer.nextElement();
			System.out.println("attribute: " + vinfo.type.toString() + vinfo.name);
		}
	}

	
    private void printClassMethods(ClassInfo cinfo) {
    	for(Enumeration<MethodInfo> enumer = cinfo.methods.elements(); enumer.hasMoreElements(); ){
			MethodInfo minfo = enumer.nextElement();
			System.out.println("method: " + minfo.type.toString() + minfo.name);
		}
	}
	
    
    
}
