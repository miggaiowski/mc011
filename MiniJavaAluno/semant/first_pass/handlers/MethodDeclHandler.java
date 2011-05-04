package semant.first_pass.handlers;

import semant.Env;
import symbol.ClassInfo;
import symbol.MethodInfo;
import symbol.Symbol;
import syntaxtree.MethodDecl;
import syntaxtree.VisitorAdapter;

public class MethodDeclHandler extends VisitorAdapter {

    private Env env;
    private ClassInfo classInfo;
    
    private MethodDeclHandler(Env e, ClassInfo i) {
        super();
        env = e;
        classInfo = i;
    }
    
    public static void firstPass(Env e, ClassInfo info, MethodDecl md) {
        MethodDeclHandler handler = new MethodDeclHandler(e, info);
        md.accept(handler);
    }
    
    public void visit(MethodDecl node) {
        Symbol name = Symbol.symbol(node.name.s);
        MethodInfo methodInfo = new MethodInfo(node.returnType, name, classInfo.name);
        
        if (!classInfo.addMethod(methodInfo)) {
            MethodInfo previousInfo = classInfo.methods.get(name);
            env.err.Error(node.name, new Object[]{
                    "Método \'" + name 
                    + "\' redefinido para classe \'" + classInfo.name + "\'", 
                    "Declaracao anterior em: [" + previousInfo.type.line + "," + previousInfo.type.row + "]"});
        }
    }
}
