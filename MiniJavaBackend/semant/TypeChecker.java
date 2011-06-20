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

    public static Env TypeCheck(ErrorEchoer err, Program p) {
       //First phase of the Type Checking 
       Env e = FirstPass.firstPass(err, p);
       //Second phase of the Type Checking 
       SecondPass.secondPass(e, p);
       return e;
    }
}
