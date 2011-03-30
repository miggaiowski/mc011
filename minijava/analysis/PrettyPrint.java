package analysis;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import node.AAddExp;
import node.AAndExp;
import node.AArrayattrStatement;
import node.AArraygetExp;
import node.AAttrStatement;
import node.ABooleanType;
import node.AClassdecl;
import node.AFalseExp;
import node.AIdExp;
import node.AIdType;
import node.AIfelseStatement;
import node.AIntType;
import node.AIntvectorType;
import node.ALengthExp;
import node.ALessExp;
import node.ALparexprparExp;
import node.AMainclass;
import node.AMainmethod;
import node.AMethodcallExp;
import node.AMethoddecl;
import node.AMulExp;
import node.ANewidExp;
import node.ANewintarrayExp;
import node.ANotexpExp;
import node.ANumberExp;
import node.AParameter;
import node.APreposExp;
import node.APrintStatement;
import node.AStatementlistStatement;
import node.ASubExp;
import node.AThisExp;
import node.ATrueExp;
import node.AVardecl;
import node.AWhileStatement;
import node.PExp;
import node.PMethoddecl;
import node.PParameter;
import node.PStatement;
import node.PVardecl;
import node.TId;

public class PrettyPrint extends DepthFirstAdapter
{
    PrintStream out;

    private int ident;
    private boolean printSpace;

    private void beginNest()
    {
        ident += 4;
    }

    private void endNest()
    {
        ident -= 4;
    }

    private void print(String s)
    {
        if ( printSpace )
            for (int i = 0; i < ident; i++ )
                out.print(" ");
        out.print(s);

        printSpace = false;
    }

    private void println(String s)
    {
        if ( printSpace )
            for (int i = 0; i < ident; i++ )
                out.print(" ");
        out.println(s);

        printSpace = true;
    }

    public PrettyPrint(PrintStream p)
    {
        super();
        out = p;
        ident = 0;
        printSpace = true;
    }

    public PrettyPrint()
    {
        this(System.out);
    }

    public void inAMainclass(AMainclass node)
    {
        print("class " + node.getClassname().getText());
        println(" {");
        beginNest();
        //        node.getMainmethod().apply(this);
    }

    public void outAMainclass(AMainclass node)
    {
        endNest();
        println("}");
    }

    public void inAMainmethod(AMainmethod node) {
        print( "public static void main(String[] " + node.getParamname().getText());
        println( ") {");
        beginNest();
    }

    public void outAMainmethod(AMainmethod node) {
        endNest();
        println( "}");
    }


    public void caseAClassdecl(AClassdecl node)
    {
        inAClassdecl(node);
        print("class " + node.getClassname().getText());
        if (node.getSuper() != null) {
            print( " extends " + node.getSuper().getText());
        }
        println( " {" );
        beginNest();
        {
            List<PVardecl> copy = new ArrayList<PVardecl>(node.getVars());
            for(PVardecl e : copy)
            {
                e.apply(this);
                println(";");
            }
        }
        {
            List<PMethoddecl> copy = new ArrayList<PMethoddecl>(node.getMethods());
            for(PMethoddecl e : copy)
            {
                e.apply(this);
            }
        }
        endNest();
        println("}");
        outAClassdecl(node);
    }

    public void outAVardecl(AVardecl node)
    {
        print(node.getVarname().getText());
    }

    public void caseAParameter(AParameter node)
    {
        inAParameter(node);
        if(node.getType() != null)
        {
            node.getType().apply(this);
        }
        if(node.getId() != null)
        {
            print(node.getId().getText());
        }
        outAParameter(node);
    }


    public void caseAMethoddecl(AMethoddecl node)
    {
        inAMethoddecl(node);
        print("public ");
        if(node.getType() != null)
        {
            node.getType().apply(this);
        }
        print(node.getMethodname().getText());
        print( "(");
        {
            List<PParameter> copy = new ArrayList<PParameter>(node.getParameters());
            if(copy.size()>0){
                for(int i = 0; i<copy.size()-1; i++)
                {
                    copy.get(i).apply(this);
                    print(", ");
                }
                copy.get(copy.size()-1).apply(this);
            }
        }
        print(")");
        println(" {");
        beginNest();
        {
            List<PVardecl> copy = new ArrayList<PVardecl>(node.getVars());
            for(PVardecl e : copy)
            {
                e.apply(this);
                println(";");
            }
        }
        {
            List<PStatement> copy = new ArrayList<PStatement>(node.getStatements());
            for(PStatement e : copy)
            {
                e.apply(this);
            }
        }
        print("return ");
        if(node.getReturnexpression() != null)
        {
            node.getReturnexpression().apply(this);
        }
        println(";");
        endNest();
        println("}");
        outAMethoddecl(node);
    }

    public void inAIntvectorType(AIntvectorType node)
    {
        print("int[] ");
    }

    public void inABooleanType(ABooleanType node)
    {
        print("boolean ");
    }

    public void inAIntType(AIntType node)
    {
        print("int ");
    }

    public void inAIdType(AIdType node)
    {
        print(node.getId().getText() + " ");
    }

    public void inAStatementlistStatement(AStatementlistStatement node)
    {
        println("{");
        beginNest();
    }

    public void outAStatementlistStatement(AStatementlistStatement node)
    {
        endNest();
        println("}");
    }

    public void caseAIfelseStatement(AIfelseStatement node)
    {
        inAIfelseStatement(node);
        print( "if (" );
        if(node.getIfexp() != null)
        {
            node.getIfexp().apply(this);
        }
        println( ") { " );
        if(node.getIfstatement() != null)
        {
            beginNest();
            node.getIfstatement().apply(this);
            endNest();         
        }
        println("}");
        println("else {");
        if(node.getElsestatement() != null)
        {
            beginNest();
            node.getElsestatement().apply(this);
            endNest();
        }
        println("}");
        outAIfelseStatement(node);
    }

    public void caseAWhileStatement(AWhileStatement node)
    {
        inAWhileStatement(node);
        print( "while(" );
        if(node.getWhileexp() != null)
        {
            node.getWhileexp().apply(this);
        }
        print( ") " );
        if(node.getStatement() != null)
        {
            node.getStatement().apply(this);
        }
        outAWhileStatement(node);
    }

    public void inAPrintStatement(APrintStatement node)
    {
        print( "System.out.println(" );
    }

    public void outAPrintStatement(APrintStatement node)
    {
        println( ");" );
    }

    public void caseAAttrStatement(AAttrStatement node)
    {
        inAAttrStatement(node);
        print(node.getId().getText() + " = " );
        if(node.getExp() != null)
        {
            node.getExp().apply(this);
        }
        println( ";" );
        outAAttrStatement(node);
    }

    public void caseAArrayattrStatement(AArrayattrStatement node)
    {
        inAArrayattrStatement(node);
        print(node.getId().getText() + "[" );
        if(node.getArrayindex() != null)
        {
            node.getArrayindex().apply(this);
        }
        print( "] = " );
        if(node.getRighthandside() != null)
        {
            node.getRighthandside().apply(this);
        }
        println( ";" );
        outAArrayattrStatement(node);
    }

    public void caseAAndExp(AAndExp node)
    {
        inAAndExp(node);

        if (node.getAndexps().size() > 1) {
            for (int i = 0; i < node.getAndexps().size(); i++) {
                node.getAndexps().get(i).apply(this);
                if (i < node.getAndexps().size() - 1)
                    println(" && ");
            }
        }
        else
            node.getAndexps().get(0).apply(this);

        outAAndExp(node);
    }

    public void caseALessExp(ALessExp node)
    {
        inALessExp(node);

        if (node.getExps().size() > 1) {
            for (int i = 0; i < node.getExps().size(); i++) {
                node.getExps().get(i).apply(this);
                if (i < node.getExps().size() - 1)
                    print(" < ");
            }
        }
        else
            node.getExps().get(0).apply(this);

        outALessExp(node);
    }

    public void caseAAddExp(AAddExp node)
    {
        inAAddExp(node);

        if (node.getTerms().size() > 1) {
            for (int i = 0; i < node.getTerms().size(); i++) {
                node.getTerms().get(i).apply(this);
                if (i < node.getTerms().size() - 1)
                    print(" + ");
            }
        }
        else
            node.getTerms().get(0).apply(this);

        outAAddExp(node);
    }

    public void caseASubExp(ASubExp node)
    {
        inASubExp(node);

        if (node.getTerms().size() > 1) {
            for (int i = 0; i < node.getTerms().size(); i++) {
                node.getTerms().get(i).apply(this);
                if (i < node.getTerms().size() - 1)
                    print(" - ");
            }
        }
        else
            node.getTerms().get(0).apply(this);

        outASubExp(node);
    }

    @Override
    public void caseAMulExp(AMulExp node)
    {
        inAMulExp(node);

        if (node.getFactor().size() > 1) {
            for (int i = 0; i < node.getFactor().size(); i++) {
                node.getFactor().get(i).apply(this);
                if (i < node.getFactor().size() - 1)
                    print(" * ");
            }
        }
        else
            node.getFactor().get(0).apply(this);

        outAMulExp(node);
    }

    public void caseAArraygetExp(AArraygetExp node) {

        inAArraygetExp(node);

        print( "[" );
        if(node.getIndex() != null)
        {
            node.getIndex().apply(this);
        }
        print( "]" );
        outAArraygetExp(node);
    }

    public void caseALengthExp(ALengthExp node)
    {
        inALengthExp(node);
        print(".length");
        outALengthExp(node);
    }

    public void caseAMethodcallExp(AMethodcallExp node)
    {
        inAMethodcallExp(node);
        print(".");
        print(node.getId().getText() + "(");
        for (int i = 0; i < node.getExplist().size(); i++) {
            node.getExplist().get(i).apply(this);
            if (i < node.getExplist().size() - 1)
                print(", ");
        }
        print(")");
        outAMethodcallExp(node);
    }

    public void caseAPreposExp(APreposExp node)
    {
        inAPreposExp(node);
        
        if(node.getPrefix() != null) {
            node.getPrefix().apply(this);
        }
        List<PExp> copy = new ArrayList<PExp>(node.getPosfixs());
        for(PExp e : copy) {
            e.apply(this);
        }
        
        outAPreposExp(node);
    }

    public void inANotexpExp(ANotexpExp node)
    {
        print( "!" );
    }

    public void inALparexprparExp(ALparexprparExp node)
    {
        print("(");
    }

    public void outALparexprparExp(ALparexprparExp node)
    {
        print(")");
    }

    public void inANumberExp(ANumberExp node)
    {
        print(node.getNumber().getText());
    }

    public void inATrueExp(ATrueExp node)
    {
        print("true");
    }

    public void inAFalseExp(AFalseExp node)
    {
        print("false");
    }

    public void inAIdExp(AIdExp node)
    {
        print(node.getId().getText());
    }

    public void inAThisExp(AThisExp node)
    {
        print("this");
    }

    public void inANewintarrayExp(ANewintarrayExp node)
    {
        print( "new int[" );
    }

    public void outANewintarrayExp(ANewintarrayExp node)
    {
        print( "]" );
    }

    public void inANewidExp(ANewidExp node)
    {
        print( "new " + node.getId().getText() + "()");
    }
}
