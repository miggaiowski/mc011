package semant;

import semant.first_pass.FirstPass;
import semant.second_pass.SecondPass;
import syntaxtree.Program;
import errors.ErrorEchoer;

public class TypeChecker
{
    private TypeChecker()
    {
        super();
    }

    public static Env TypeCheck(ErrorEchoer err, Program p)
    {		
       Env e = FirstPass.firstPass(err, p);
       
       SecondPass.secondPass(e, p);
       return e;
    }
}
