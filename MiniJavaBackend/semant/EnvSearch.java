package semant;

import java.util.Enumeration;

import symbol.ClassInfo;
import symbol.MethodInfo;
import symbol.Symbol;
import symbol.VarInfo;
import util.List;

public class EnvSearch {
	
	//Get variables according to the context, call it with care
	public static VarInfo getVariable(ClassInfo cinfo, MethodInfo minfo, Symbol symbol) {
		
		//If there is a method...
		if (minfo != null){
			//First we check if the variable is a local of the method
			List<VarInfo> localsList = minfo.locals;
			for( ; localsList != null; localsList = localsList.tail){
				if (localsList.head.name == symbol)
					return localsList.head;
			}
			
			//If its not a local, maybe its a formal of the method
			List<VarInfo> formalsList = minfo.formals;
			for( ; formalsList != null; formalsList = formalsList.tail){
				if (formalsList.head.name == symbol)
					return formalsList.head;
			}
		}
		
		//Well, if its has nothing to do with a method, maybe is an attribute of the class
		for(Enumeration<VarInfo> enumer = cinfo.attributes.elements(); enumer.hasMoreElements(); ){
			VarInfo vinfo = enumer.nextElement();
			if (vinfo.name == symbol)
				return vinfo;
		}
    	
		//If its not anywhere, return null
		return null;
	}

	public static MethodInfo getMethod(Env env, ClassInfo classInfo, Symbol className, Symbol methodName){
		//Return null if the class doesnt exists
		//Return null if the method doesnt exists in the specified class
		
		//If the class exists...
		if (env.classes.env.peek().containsKey(className)){
			
			ClassInfo ci = env.classes.env.peek().get(className);
			
			//Check if the class has the specified method
			if (ci.methods.containsKey(methodName)){
				return ci.methods.get(methodName);
			}
			//If there is no method, look at the base classes
			else if(ci.base != null){
					MethodInfo mi = getMethod(env, classInfo, ci.base.name, methodName);
					return mi;
			}
			else
				return null;
		}
		else
			return null;
		
	}
	
}
