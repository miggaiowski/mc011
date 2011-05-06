package semant.first_pass.handlers;

import semant.Env;
import symbol.ClassInfo;
import symbol.Symbol;
import symbol.VarInfo;
import syntaxtree.VarDecl;
import syntaxtree.VisitorAdapter;

public class AttributeHandler extends VisitorAdapter {

    private Env env;
    private ClassInfo info;
    
    private AttributeHandler(Env e, ClassInfo i) {
        super();
        env = e;
        info = i;
    }

    public static void firstPass(Env e, ClassInfo classInfo, VarDecl vd) {
        AttributeHandler handler = new AttributeHandler(e, classInfo);
        vd.accept(handler);        
    }

    public void visit(VarDecl node) {
        Symbol name = Symbol.symbol(node.name.s);
        VarInfo varInfo = new VarInfo(node.type, name);
        
        // inserindo nova declaracao na tabela de simbolos
        if (!info.addAttribute(varInfo)) {
            VarInfo previousInfo = info.attributes.get(name);
            env.err.Error(node.name, new Object[]{
                    "Atributo \'" + name 
                    + "\' redefinido para classe \'" + info.name + "\'", 
                    "Declaracao anterior em: [" + previousInfo.type.line + "," + previousInfo.type.row + "]"});
        }
        
    }
}
