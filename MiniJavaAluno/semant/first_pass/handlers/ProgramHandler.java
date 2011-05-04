package semant.first_pass.handlers;

import errors.ErrorEchoer;
import semant.Env;
import syntaxtree.Program;
import syntaxtree.VisitorAdapter;

public class ProgramHandler extends VisitorAdapter {
    
    private Env result;
    
    private ProgramHandler(ErrorEchoer err) {
        super();
        result = new Env(err);
    }
    
    static Env firstPass(ErrorEchoer err, Program p) {
        // Cria novo objeto visitor
        ProgramHandler h = new ProgramHandler(err);
        
        p.accept(h); // esse método vai chamar h.visit(p)
        
        return h.result;
    }
    
    public void visit(Program node) {
        // Agora temos que visitar cada parte deste programa
        
        // Fazendo firstPass na classe principal
        MainClassHandler.firstPass(result, node.mainClass);
        
        // Agora nas outras classes
        ClassDeclListHandler.firstPass(result, node.classList);
    }
}
