package minijava;

import java.util.*;
import java.io.PrintStream;
import minijava.node.*;
import minijava.analysis.*;

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

    public void inAMainClass(AMainClass node)
    {
	print("class " + node.getClassName().getText());
	println(" {");
	beginNest();
		
	print( "public static void main(String[] " + node.getMainArgName().getText());
	println( ") {");
	beginNest();
    }

    public void outAMainClass(AMainClass node)
    {
	endNest();
	println("}");
	endNest();
	println("}");
    }

    public void caseASimpleClassDecl(ASimpleClassDecl node)
    {
        inASimpleClassDecl(node);
	print("class " + node.getClassName().getText());
	println( " {" );
	beginNest();
        {
            List<PVarDecl> copy = new ArrayList<PVarDecl>(node.getVarDecl());
            for(PVarDecl e : copy)
            {
                e.apply(this);
		println(";");
            }
        }
        {
            List<PMethodDecl> copy = new ArrayList<PMethodDecl>(node.getMethodDecl());
            for(PMethodDecl e : copy)
            {
                e.apply(this);
            }
        }
	endNest();
	println("}");
        outASimpleClassDecl(node);
    }

    public void caseAExtendsClassDecl(AExtendsClassDecl node)
    {
        inAExtendsClassDecl(node);
	print("class " + node.getClassName().getText());
	print( " extends " + node.getParentName().getText());
	println(" {");
	beginNest();
        {
            List<PVarDecl> copy = new ArrayList<PVarDecl>(node.getVarDecl());
            for(PVarDecl e : copy)
            {
                e.apply(this);
		println(";");
            }
        }
        {
            List<PMethodDecl> copy = new ArrayList<PMethodDecl>(node.getMethodDecl());
            for(PMethodDecl e : copy)
            {
                e.apply(this);
            }
        }
	endNest();
	println("}");
        outAExtendsClassDecl(node);
    }

    public void outAVarDecl(AVarDecl node)
    {
	print(node.getId().getText());
    }

    public void caseAMethodDecl(AMethodDecl node)
    {
        inAMethodDecl(node);
	print("public ");
        if(node.getType() != null)
        {
            node.getType().apply(this);
        }
	print(node.getId().getText());
	print( "(");
	{
	    List<PVarDecl> copy = new ArrayList<PVarDecl>(node.getArgs());
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
            List<PVarDecl> copy = new ArrayList<PVarDecl>(node.getLocals());
            for(PVarDecl e : copy)
            {
                e.apply(this);
		println(";");
            }
        }
        {
            List<PStatement> copy = new ArrayList<PStatement>(node.getStatement());
            for(PStatement e : copy)
            {
                e.apply(this);
            }
        }
	print("return ");
        if(node.getExp() != null)
        {
            node.getExp().apply(this);
        }
	println(";");
	endNest();
	println("}");
        outAMethodDecl(node);
    }

    public void inAIntArrayType(AIntArrayType node)
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

    public void inABlockStatement(ABlockStatement node)
    {
	println("{");
	beginNest();
    }

    public void outABlockStatement(ABlockStatement node)
    {
	endNest();
	println("}");
    }

    public void caseAIfStatement(AIfStatement node)
    {
        inAIfStatement(node);
	print( "if (" );
        if(node.getCondition() != null)
        {
            node.getCondition().apply(this);
        }
	print( ") " );
        if(node.getThenClause() != null)
        {
            node.getThenClause().apply(this);
        }
        if(node.getElseClause() != null)
        {
	    print("else ");
            node.getElseClause().apply(this);
        }
        outAIfStatement(node);
    }

    public void caseAWhileStatement(AWhileStatement node)
    {
        inAWhileStatement(node);
	print( "while(" );
        if(node.getCondition() != null)
        {
            node.getCondition().apply(this);
        }
	print( ") " );
        if(node.getBody() != null)
        {
            node.getBody().apply(this);
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

    public void caseAAssignStatement(AAssignStatement node)
    {
        inAAssignStatement(node);
	print(node.getVar().getText() + " = " );
        if(node.getValue() != null)
        {
            node.getValue().apply(this);
        }
	println( ";" );
        outAAssignStatement(node);
    }

    public void caseAArrayAssignStatement(AArrayAssignStatement node)
    {
        inAArrayAssignStatement(node);
	print(node.getVar().getText() + "[" );
        if(node.getIndex() != null)
        {
            node.getIndex().apply(this);
        }
	print( "] = " );
        if(node.getValue() != null)
        {
            node.getValue().apply(this);
        }
	println( ";" );
        outAArrayAssignStatement(node);
    }

    public void caseAAndExp(AAndExp node)
    {
        inAAndExp(node);
        if(node.getLeft() != null)
        {
            node.getLeft().apply(this);
        }
	print( " && ");
        if(node.getRight() != null)
        {
            node.getRight().apply(this);
        }
        outAAndExp(node);
    }

    public void caseALessExp(ALessExp node)
    {
        inALessExp(node);
        if(node.getLeft() != null)
        {
            node.getLeft().apply(this);
        }
	print( " < ");
        if(node.getRight() != null)
        {
            node.getRight().apply(this);
        }
        outALessExp(node);
    }

    public void caseAPlusExp(APlusExp node)
    {
        inAPlusExp(node);
        if(node.getLeft() != null)
        {
            node.getLeft().apply(this);
        }
	print( " + ");
        if(node.getRight() != null)
        {
            node.getRight().apply(this);
        }
        outAPlusExp(node);
    }

    public void caseAMinusExp(AMinusExp node)
    {
        inAMinusExp(node);
        if(node.getLeft() != null)
        {
            node.getLeft().apply(this);
        }
	print( " - ");
        if(node.getRight() != null)
        {
            node.getRight().apply(this);
        }
        outAMinusExp(node);
    }

    @Override
    public void caseATimesExp(ATimesExp node)
    {
        inATimesExp(node);
        if(node.getLeft() != null)
        {
            node.getLeft().apply(this);
        }
	print( " * ");
        if(node.getRight() != null)
        {
            node.getRight().apply(this);
        }
        outATimesExp(node);
    }


    public void caseALookupExp(ALookupExp node)
    {
        inALookupExp(node);
        if(node.getBase() != null)
        {
            node.getBase().apply(this);
        }
	print( "[" );
        if(node.getIndex() != null)
        {
            node.getIndex().apply(this);
        }
	print( "]" );
        outALookupExp(node);
    }

    public void caseALengthExp(ALengthExp node)
    {
        inALengthExp(node);
        if(node.getExp() != null)
        {
            node.getExp().apply(this);
        }
	print(".length");
        outALengthExp(node);
    }

    public void caseAMemberExp(AMemberExp node)
    {
        inAMemberExp(node);
        if(node.getObject() != null)
        {
            node.getObject().apply(this);
        }
	print("." + node.getMemberName().getText() + "(");
	List<PExp> copy = new ArrayList<PExp>(node.getArgs());
        if(copy.size()>0){
            for(int i = 0; i<copy.size()-1; i++)
            {
                copy.get(i).apply(this);
		print(", ");
            }
	    copy.get(copy.size()-1).apply(this);
        }
	print(")");
        outAMemberExp(node);
    }

    public void inANotExp(ANotExp node)
    {
	print( "!" );
    }

    public void inAParenExp(AParenExp node)
    {
        print("(");
    }

    public void outAParenExp(AParenExp node)
    {
        print(")");
    }

    public void inAIntegerExp(AIntegerExp node)
    {
	print(node.getInteger().getText());
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

    public void inANewArrayExp(ANewArrayExp node)
    {
	print( "new int[" );
    }

    public void outANewArrayExp(ANewArrayExp node)
    {
	print( "]" );
    }

    public void inANewObjectExp(ANewObjectExp node)
    {
	print( "new " + node.getClassName().getText() + "()");
    }
}
