package analysis;

import java.util.*;
import java.io.PrintStream;
import node.*;

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

	public void caseAArrayAssignStatement(AArrayAssignStatement node)
	{
		inAArrayAssignStatement(node);
		print(node.getId().getText() + "[" );
		if(node.getArrayindex() != null)
		{
			node.getArrayindex().apply(this);
		}
		print( "] = " );
		if(node.getValue() != null)
		{
			node.getValue().apply(this);
		}
		println( ";" );
		outAArrayAssignStatement(node);
	}

	public void caseAAssignStatement(AAssignStatement node)
	{
		inAAssignStatement(node);
		print(node.getId().getText() + " = " );
		if(node.getExp() != null)
		{
			node.getExp().apply(this);
		}
		println( ";" );
		outAAssignStatement(node);
	}

	public void caseACallExp(ACallExp node)
	{
		inACallExp(node);
		if(node.getObject() != null)
		{
			node.getObject().apply(this);
		}
		print("." + node.getMethodName().getText() + "(");
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
		outACallExp(node);
	}

	public void caseAExtendsClassDecl(AExtendsClassDecl node)
	{
		inAExtendsClassDecl(node);
		print("class " + node.getClassName().getText());
		print( " extends " + node.getSuper().getText());
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

	public void caseAIfStatement(AIfStatement node) {
		inAIfStatement(node);
		print( "if (" );
		if (node.getIfexp() != null) {
			node.getIfexp().apply(this);
		}
		println(") {");
		beginNest();
		if(node.getIfstatement() != null) {
			node.getIfstatement().apply(this);
		}
		endNest();
		println("}");
		println("else {");
		beginNest();
		if(node.getElsestatement() != null) {
			node.getElsestatement().apply(this);
		}
		endNest();
		println("}");
		outAIfStatement(node);
	}

	public void caseALengthExp(AArrayLengthExp node)
	{
		inAArrayLengthExp(node);
		if(node.getExp() != null)
		{
			node.getExp().apply(this);
		}
		print(".length");
		outAArrayLengthExp(node);
	}

	public void caseALessThanExp(ALessThanExp node)
	{
		inALessThanExp(node);
		if(node.getLeft() != null)
		{
			node.getLeft().apply(this);
		}
		print( " < ");
		if(node.getRight() != null)
		{
			node.getRight().apply(this);
		}
		outALessThanExp(node);
	}

	public void caseALookupExp(AArrayLookupExp node)
	{
		inAArrayLookupExp(node);
		if(node.getExp() != null)
		{
			node.getExp().apply(this);
		}
		print( "[" );
		if(node.getIndex() != null)
		{
			node.getIndex().apply(this);
		}
		print( "]" );
		outAArrayLookupExp(node);
	}

	public void caseAMethodDecl(AMethodDecl node)
	{
		inAMethodDecl(node);
		print("public ");
		if(node.getType() != null)
		{
			node.getType().apply(this);
		}
		print(node.getMethodName().getText());
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
			List<PVarDecl> copy = new ArrayList<PVarDecl>(node.getVarDecl());
			for(PVarDecl e : copy)
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
		if(node.getReturnExpression() != null)
		{
			node.getReturnExpression().apply(this);
		}
		println(";");
		endNest();
		println("}");
		outAMethodDecl(node);
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

	private void endNest()
	{
		ident -= 4;
	}

	public void inABlockStatement(ABlockStatement node)
	{
		println("{");
		beginNest();
	}

	public void inABooleanType(ABooleanType node)
	{
		print("boolean ");
	}

	public void inAFalseExp(AFalseExp node)
	{
		print("false");
	}

	public void inAIdentifierExp(AIdentifierExp node)
	{
		print(node.getId().getText());
	}

	public void inAIdType(AIdentifierType node)
	{
		print(node.getId().getText() + " ");
	}

	public void inAIntArrayType(AIntArrayType node)
	{
		print("int[] ");
	}

	public void inAIntegerLiteralExp(AIntegerLiteralExp node)
	{
		print(node.getNumber().getText());
	}

	public void inAIntegerType(AIntegerType node)
	{
		print("int ");
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

	public void inANewArrayExp(ANewArrayExp node)
	{
		print( "new int[" );
	}


	public void inANewObjectExp(ANewObjectExp node)
	{
		print( "new " + node.getId().getText() + "()");
	}

	public void inANotExp(ANotExp node)
	{
		print( "!" );
	}

	public void inAPrintStatement(APrintStatement node)
	{
		print( "System.out.println(" );
	}

	public void inAThisExp(AThisExp node)
	{
		print("this");
	}

//	public void inAParenExp(AParenExp node)
//	{
//		print("(");
//	}
//
//	public void outAParenExp(AParenExp node)
//	{
//		print(")");
//	}

	public void inATrueExp(ATrueExp node)
	{
		print("true");
	}

	public void outABlockStatement(ABlockStatement node)
	{
		endNest();
		println("}");
	}

	public void outAMainClass(AMainClass node)
	{
		endNest();
		println("}");
		endNest();
		println("}");
	}

	public void outANewArrayExp(ANewArrayExp node)
	{
		print( "]" );
	}

	public void outAPrintStatement(APrintStatement node)
	{
		println( ");" );
	}

	public void outAVarDecl(AVarDecl node)
	{
		print(node.getVarName().getText());
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
