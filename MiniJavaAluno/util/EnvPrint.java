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
	private boolean printSpace;
	
	//***** Constructor *****//
	public EnvPrint(Env e){
		initStack = e.classes.env;
		printSpace = true;
		ident = 0;
	}
	
	
	//***** Methods *****//
	public void print(){
		while (!initStack.isEmpty()){
			printEnvClasses(initStack);
			initStack.pop();
		}
	}


	private void printEnvClasses(Stack<Hashtable<Symbol, ClassInfo>> classStack) {
		for(Enumeration<ClassInfo> enumer = classStack.peek().elements(); enumer.hasMoreElements(); ){
			ClassInfo cinfo = enumer.nextElement();
			println("class: " + cinfo.name);
			beginScope();
			printClassAttributes(cinfo);
			printClassMethods(cinfo);
			endScope();
		}
	}


	private void printClassAttributes(ClassInfo cinfo) {
		for(Enumeration<VarInfo> enumer = cinfo.attributes.elements(); enumer.hasMoreElements(); ){
			VarInfo vinfo = enumer.nextElement();
			println("attribute: " + vinfo.type.toString() + vinfo.name);
		}
	}

	
    private void printClassMethods(ClassInfo cinfo) {
    	for(Enumeration<MethodInfo> enumer = cinfo.methods.elements(); enumer.hasMoreElements(); ){
			MethodInfo minfo = enumer.nextElement();
			println("method: " + minfo.type.toString() + minfo.name);
			beginScope();
			printMethodFormals(minfo.formals);
			printMethodVariables(minfo.locals);
			endScope();
		}
	}


	private void printMethodVariables(List<VarInfo> locals) {
		for( ; locals != null; locals = locals.tail){
			println("variable: " + locals.head.type.toString() + locals.head.name);
		}
	}


	private void printMethodFormals(List<VarInfo> formals) {
		for( ; formals != null; formals = formals.tail){
			println("formal: " + formals.head.type.toString() + formals.head.name);
		}
	}
	
	
	// ***** Auxiliar Methods *****//
	private void print(String s)
	{
		if ( printSpace )
			for (int i = 0; i < ident; i++ )
				System.out.print(" ");
		System.out.print(s);

		printSpace = false;
	}

	private void println(String s)
	{
		if ( printSpace )
			for (int i = 0; i < ident; i++ )
				System.out.print(" ");
		System.out.println(s);

		printSpace = true;
	}
    
	private void beginScope(){
		ident += 4;
	}
	
	private void endScope(){
		ident -= 4;
	}
}
