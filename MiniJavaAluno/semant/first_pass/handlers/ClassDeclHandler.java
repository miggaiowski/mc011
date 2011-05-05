package semant.first_pass.handlers;

import semant.Env;
import symbol.ClassInfo;
import symbol.Symbol;
import syntaxtree.ClassDecl;
import syntaxtree.ClassDeclExtends;
import syntaxtree.ClassDeclSimple;
import syntaxtree.VisitorAdapter;

public class ClassDeclHandler extends VisitorAdapter {

    private Env env;
    
    private ClassDeclHandler(Env e) {
        super();
        env = e;
    }

    public static void firstPass(Env e, ClassDecl cd) {
        ClassDeclHandler h = new ClassDeclHandler(e);
        cd.accept(h);
    }
    
    public void visit(ClassDeclSimple node) {
        Symbol name = Symbol.symbol(node.name.s);
        ClassInfo info = new ClassInfo(name);
        
        // verificando as partes de dentro da classe, atributos e metodos
        // Atributos
        AttributeListHandler.firstPass(env, info, node.varList);
        
        // Metodos
        MethodDeclListHandler.firstPass(env, info, node.methodList);
        
        // inserindo nova classe na tabela de simbolos
        if (!env.classes.put(name, info)) {
            env.err.Error(node, new Object[]{"Redefinição da classe \'" + name + "\'"});
        }
    }
    
    public void visit(ClassDeclExtends node) {
        Symbol name = Symbol.symbol(node.name.s);
        Symbol baseName = Symbol.symbol(node.superClass.s);
        ClassInfo baseInfo = new ClassInfo(baseName);
        ClassInfo info = new ClassInfo(name, baseInfo);
                
        // verificando as partes de dentro da classe, atributos e metodos
        // Atributos
        AttributeListHandler.firstPass(env, info, node.varList);
        
        // Metodos
        MethodDeclListHandler.firstPass(env, info, node.methodList);
        
        // inserindo nova classe na tabela de simbolos
        if (!env.classes.put(name, info)) {
            env.err.Error(node, new Object[]{"Nome de classe redefinido", "Simbolo: " + name});
        }
    }

}
