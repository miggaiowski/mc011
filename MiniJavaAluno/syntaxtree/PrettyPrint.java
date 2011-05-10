package syntaxtree;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import minijava.analysis.DepthFirstAdapter;
import minijava.node.AAndExp;
import minijava.node.AArrayAssignStatement;
import minijava.node.AArrayLengthExp;
import minijava.node.AArrayLookupExp;
import minijava.node.AArrayType;
import minijava.node.AAssignStatement;
import minijava.node.ABlockStatement;
import minijava.node.ABooleanType;
import minijava.node.ACallExp;
import minijava.node.AClassDecl;
import minijava.node.AFalseExp;
import minijava.node.AFormal;
import minijava.node.AIdentifierExp;
import minijava.node.AIfStatement;
import minijava.node.AIntType;
import minijava.node.AIntegerLiteralExp;
import minijava.node.ALessThanExp;
import minijava.node.AMainClass;
import minijava.node.AMethodDecl;
import minijava.node.AMinusExp;
import minijava.node.ANewArrayExp;
import minijava.node.ANewObjectExp;
import minijava.node.ANotExp;
import minijava.node.AObjectType;
import minijava.node.APlusExp;
import minijava.node.APrintStatement;
import minijava.node.AThisExp;
import minijava.node.ATimesExp;
import minijava.node.ATrueExp;
import minijava.node.AVarDecl;
import minijava.node.AWhileStatement;
import minijava.node.PExp;
import minijava.node.PFormal;
import minijava.node.PMethodDecl;
import minijava.node.PStatement;
import minijava.node.PVarDecl;

public class PrettyPrint extends DepthFirstAdapter
{
	private int ident;

	PrintStream out;
	private boolean printSpace;

	public PrettyPrint()
	{
		this(System.out);
	}

	public PrettyPrint(PrintStream p)
	{
		super();
		out = p;
		ident = 0;
		printSpace = true;
	}

	private void beginNest()
	{
		ident += 4;
	}

    @Override
	public void caseAAndExp(AAndExp node)
	{
		inAAndExp(node);
		if(node.getLhs() != null)
		{
			node.getLhs().apply(this);
		}
		print( " && ");
		if(node.getRhs() != null)
		{
			node.getRhs().apply(this);
		}
		outAAndExp(node);
	}

    @Override
	public void caseAArrayAssignStatement(AArrayAssignStatement node)
	{
		inAArrayAssignStatement(node);
		print(node.getTarget().getText() + "[" );
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

    @Override
	public void caseAAssignStatement(AAssignStatement node)
	{
		inAAssignStatement(node);
		print(node.getTarget().getText() + " = " );
		if(node.getValue() != null)
		{
			node.getValue().apply(this);
		}
		println( ";" );
		outAAssignStatement(node);
	}

    @Override
	public void caseACallExp(ACallExp node)
	{
		inACallExp(node);
		if(node.getObject() != null)
		{
			node.getObject().apply(this);
		}
		print("." + node.getMethod().getText() + "(");
		List<PExp> copy = new ArrayList<PExp>(node.getActuals());
		if(copy.size()>0){
			for(int i = 0; i<copy.size()-1; i++)
			{
				copy.get(i).apply(this);
				print(", ");
			}
			copy.get(copy.size()-1).apply(this);
		}
		print(")");
		outACallExp(node);
	}


    @Override
	public void caseAIfStatement(AIfStatement node)
    {
        inAIfStatement(node);
        print( "if (" );
        if(node.getCondition() != null) {
            node.getCondition().apply(this);
        }
        println(") {");
        beginNest();
        if(node.getThenClause() != null) {
            node.getThenClause().apply(this);
        }
        endNest();
        println("}");
        if(node.getElseClause() != null) {
            println("else {");
            beginNest();
            node.getElseClause().apply(this);
            endNest();
            println("}");
        }
        outAIfStatement(node);
    }
	
    @Override
	public void caseAArrayLengthExp(AArrayLengthExp node)
	{
		inAArrayLengthExp(node);
		if (node.getArray() != null) {
			node.getArray().apply(this);
		}
		print(".length");
		outAArrayLengthExp(node);
	}

    @Override
	public void caseALessThanExp(ALessThanExp node)
	{
		inALessThanExp(node);
		if (node.getLhs() != null) {
			node.getLhs().apply(this);
		}
		print( " < ");
		if(node.getRhs() != null)
		{
			node.getRhs().apply(this);
		}
		outALessThanExp(node);
	}

    @Override
	public void caseAArrayLookupExp(AArrayLookupExp node)
	{
		inAArrayLookupExp(node);
		if (node.getArray() != null) {
			node.getArray().apply(this);
		}
		print( "[" );
		if(node.getIndex() != null)
		{
			node.getIndex().apply(this);
		}
		print( "]" );
		outAArrayLookupExp(node);
	}

    @Override
	public void caseAMethodDecl(AMethodDecl node)
	{
		inAMethodDecl(node);
		print("public ");
		if(node.getReturnType() != null)
		{
			node.getReturnType().apply(this);
		}
		print(node.getName().getText());
		print( "(");
		{
			List<PFormal> copy = new ArrayList<PFormal>(node.getFormals());
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
			List<PStatement> copy = new ArrayList<PStatement>(node.getBody());
			for(PStatement e : copy)
			{
				e.apply(this);
			}
		}
		print("return ");
		if(node.getReturnExp() != null)
		{
			node.getReturnExp().apply(this);
		}
		println(";");
		endNest();
		println("}");
		outAMethodDecl(node);
	}

    @Override
	public void caseAMinusExp(AMinusExp node)
	{
		inAMinusExp(node);
		if(node.getLhs() != null)
		{
			node.getLhs().apply(this);
		}
		print( " - ");
		if(node.getRhs() != null)
		{
			node.getRhs().apply(this);
		}
		outAMinusExp(node);
	}

    @Override
	public void caseAFormal(AFormal node)
    {
        inAFormal(node);
        if(node.getType() != null)
        {
            node.getType().apply(this);
        }
        if(node.getName() != null)
        {
        	print(node.getName().getText());
        }
        outAFormal(node);
    }
	
    @Override
	public void caseAPlusExp(APlusExp node)
	{
		inAPlusExp(node);
		if(node.getLhs() != null)
		{
			node.getLhs().apply(this);
		}
		print( " + ");
		if(node.getRhs() != null)
		{
			node.getRhs().apply(this);
		}
		outAPlusExp(node);
	}

    @Override
	public void caseAClassDecl(AClassDecl node) {
		inAClassDecl(node);
		print("class " + node.getName().getText());
		if (node.getSuper() != null) {
		    print( " extends " + node.getSuper().getText());
		}
		println( " {" );
		beginNest();
		{
			List<PVarDecl> copy = new ArrayList<PVarDecl>(node.getAttributes());
			for(PVarDecl e : copy)
			{
				e.apply(this);
				println(";");
			}
		}
		{
			List<PMethodDecl> copy = new ArrayList<PMethodDecl>(node.getMethods());
			for(PMethodDecl e : copy)
			{
				e.apply(this);
			}
		}
		endNest();
		println("}");
		outAClassDecl(node);
	}

	@Override
	public void caseATimesExp(ATimesExp node)
	{
		inATimesExp(node);
		if(node.getLhs() != null)
		{
			node.getLhs().apply(this);
		}
		print( " * ");
		if(node.getRhs() != null)
		{
			node.getRhs().apply(this);
		}
		outATimesExp(node);
	}

    @Override
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

	private void endNest()
	{
		ident -= 4;
	}

    @Override
	public void inABlockStatement(ABlockStatement node)
	{
		println("{");
		beginNest();
	}

    @Override
	public void inABooleanType(ABooleanType node)
	{
		print("boolean ");
	}

    @Override
	public void inAFalseExp(AFalseExp node)
	{
		print("false");
	}

    @Override
	public void inAIdentifierExp(AIdentifierExp node)
	{
		print(node.getName().getText());
	}

    @Override
	public void inAObjectType(AObjectType node)
	{
		print(node.getName().getText() + " ");
	}

    @Override
	public void inAArrayType(AArrayType node)
	{
		print("int[] ");
	}

    @Override
	public void inAIntegerLiteralExp(AIntegerLiteralExp node)
	{
		print(node.getValue().getText());
	}

    @Override
	public void inAIntType(AIntType node)
	{
		print("int ");
	}

    @Override
	public void inAMainClass(AMainClass node)
	{
		print("class " + node.getName().getText());
		println(" {");
		beginNest();

		print( "public static void main(String[] " + node.getMainArgs().getText());
		println( ") {");
		beginNest();
	}

    @Override
	public void inANewArrayExp(ANewArrayExp node)
	{
		print( "new int[" );
	}


    @Override
	public void inANewObjectExp(ANewObjectExp node)
	{
		print( "new " + node.getName().getText() + "()");
	}

    @Override
	public void inANotExp(ANotExp node)
	{
		print( "!" );
	}

    @Override
	public void inAPrintStatement(APrintStatement node)
	{
		print( "System.out.println(" );
	}

    @Override
	public void inAThisExp(AThisExp node)
	{
		print("this");
	}

    @Override
	public void inATrueExp(ATrueExp node)
	{
		print("true");
	}

    @Override
	public void outABlockStatement(ABlockStatement node)
	{
		endNest();
		println("}");
	}

    @Override
	public void outAMainClass(AMainClass node)
	{
		endNest();
		println("}");
		endNest();
		println("}");
	}

    @Override
	public void outANewArrayExp(ANewArrayExp node)
	{
		print( "]" );
	}

    @Override
	public void outAPrintStatement(APrintStatement node)
	{
		println( ");" );
	}

    @Override
	public void outAVarDecl(AVarDecl node)
	{
		print(node.getName().getText());
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
}
