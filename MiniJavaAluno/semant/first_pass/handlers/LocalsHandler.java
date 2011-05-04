package semant.first_pass.handlers;

import semant.Env;
import symbol.ClassInfo;
import symbol.MethodInfo;
import symbol.Symbol;
import symbol.VarInfo;
import syntaxtree.VarDecl;
import syntaxtree.VisitorAdapter;

public class LocalsHandler extends VisitorAdapter {

    private Env env;
    private MethodInfo info;
    
    private LocalsHandler(Env e, MethodInfo i) {
        super();
        env = e;
        info = i;
    }

    public static void firstPass(Env e, MethodInfo methodInfo, VarDecl vd) {
        LocalsHandler handler = new LocalsHandler(e, methodInfo);
        vd.accept(handler);        
    }

    public void visit(VarDecl node) {
        Symbol name = Symbol.symbol(node.name.s);
        VarInfo varInfo = new VarInfo(node.type, name);
        
        // inserindo nova declaracao na tabela de simbolos
        if (!info.addLocal(varInfo)) {
            VarInfo previousInfo = info.localsTable.get(name);
            env.err.Error(node.name, new Object[]{
                    "Variável local \'" + name 
                    + "\' redefinida no método \'" + info.name + "\'", 
                    "Declaracao anterior em: [" + previousInfo.type.line + "," + previousInfo.type.row + "]"});
        }
    }
}
