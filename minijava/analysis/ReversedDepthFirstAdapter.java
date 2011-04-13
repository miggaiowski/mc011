/* This file was generated by SableCC (http://www.sablecc.org/). */

package analysis;

import java.util.*;
import node.*;

public class ReversedDepthFirstAdapter extends AnalysisAdapter
{
    public void inStart(Start node)
    {
        defaultIn(node);
    }

    public void outStart(Start node)
    {
        defaultOut(node);
    }

    public void defaultIn(@SuppressWarnings("unused") Node node)
    {
        // Do nothing
    }

    public void defaultOut(@SuppressWarnings("unused") Node node)
    {
        // Do nothing
    }

    @Override
    public void caseStart(Start node)
    {
        inStart(node);
        node.getEOF().apply(this);
        node.getPProgram().apply(this);
        outStart(node);
    }

    public void inAProgram(AProgram node)
    {
        defaultIn(node);
    }

    public void outAProgram(AProgram node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAProgram(AProgram node)
    {
        inAProgram(node);
        {
            List<PClassDecl> copy = new ArrayList<PClassDecl>(node.getClassDecl());
            Collections.reverse(copy);
            for(PClassDecl e : copy)
            {
                e.apply(this);
            }
        }
        if(node.getMainClass() != null)
        {
            node.getMainClass().apply(this);
        }
        outAProgram(node);
    }

    public void inAMainClass(AMainClass node)
    {
        defaultIn(node);
    }

    public void outAMainClass(AMainClass node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAMainClass(AMainClass node)
    {
        inAMainClass(node);
        if(node.getStatements() != null)
        {
            node.getStatements().apply(this);
        }
        if(node.getMainArgName() != null)
        {
            node.getMainArgName().apply(this);
        }
        if(node.getClassName() != null)
        {
            node.getClassName().apply(this);
        }
        outAMainClass(node);
    }

    public void inASimpleClassDecl(ASimpleClassDecl node)
    {
        defaultIn(node);
    }

    public void outASimpleClassDecl(ASimpleClassDecl node)
    {
        defaultOut(node);
    }

    @Override
    public void caseASimpleClassDecl(ASimpleClassDecl node)
    {
        inASimpleClassDecl(node);
        {
            List<PMethodDecl> copy = new ArrayList<PMethodDecl>(node.getMethodDecl());
            Collections.reverse(copy);
            for(PMethodDecl e : copy)
            {
                e.apply(this);
            }
        }
        {
            List<PVarDecl> copy = new ArrayList<PVarDecl>(node.getVarDecl());
            Collections.reverse(copy);
            for(PVarDecl e : copy)
            {
                e.apply(this);
            }
        }
        if(node.getClassName() != null)
        {
            node.getClassName().apply(this);
        }
        outASimpleClassDecl(node);
    }

    public void inAExtendsClassDecl(AExtendsClassDecl node)
    {
        defaultIn(node);
    }

    public void outAExtendsClassDecl(AExtendsClassDecl node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAExtendsClassDecl(AExtendsClassDecl node)
    {
        inAExtendsClassDecl(node);
        {
            List<PMethodDecl> copy = new ArrayList<PMethodDecl>(node.getMethodDecl());
            Collections.reverse(copy);
            for(PMethodDecl e : copy)
            {
                e.apply(this);
            }
        }
        {
            List<PVarDecl> copy = new ArrayList<PVarDecl>(node.getVarDecl());
            Collections.reverse(copy);
            for(PVarDecl e : copy)
            {
                e.apply(this);
            }
        }
        if(node.getSuper() != null)
        {
            node.getSuper().apply(this);
        }
        if(node.getClassName() != null)
        {
            node.getClassName().apply(this);
        }
        outAExtendsClassDecl(node);
    }

    public void inAVarDecl(AVarDecl node)
    {
        defaultIn(node);
    }

    public void outAVarDecl(AVarDecl node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAVarDecl(AVarDecl node)
    {
        inAVarDecl(node);
        if(node.getVarName() != null)
        {
            node.getVarName().apply(this);
        }
        if(node.getType() != null)
        {
            node.getType().apply(this);
        }
        outAVarDecl(node);
    }

    public void inAMethodDecl(AMethodDecl node)
    {
        defaultIn(node);
    }

    public void outAMethodDecl(AMethodDecl node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAMethodDecl(AMethodDecl node)
    {
        inAMethodDecl(node);
        if(node.getReturnExpression() != null)
        {
            node.getReturnExpression().apply(this);
        }
        {
            List<PStatement> copy = new ArrayList<PStatement>(node.getStatements());
            Collections.reverse(copy);
            for(PStatement e : copy)
            {
                e.apply(this);
            }
        }
        {
            List<PVarDecl> copy = new ArrayList<PVarDecl>(node.getVarDecl());
            Collections.reverse(copy);
            for(PVarDecl e : copy)
            {
                e.apply(this);
            }
        }
        {
            List<PParameter> copy = new ArrayList<PParameter>(node.getParameters());
            Collections.reverse(copy);
            for(PParameter e : copy)
            {
                e.apply(this);
            }
        }
        if(node.getMethodName() != null)
        {
            node.getMethodName().apply(this);
        }
        if(node.getType() != null)
        {
            node.getType().apply(this);
        }
        outAMethodDecl(node);
    }

    public void inAParameter(AParameter node)
    {
        defaultIn(node);
    }

    public void outAParameter(AParameter node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAParameter(AParameter node)
    {
        inAParameter(node);
        if(node.getId() != null)
        {
            node.getId().apply(this);
        }
        if(node.getType() != null)
        {
            node.getType().apply(this);
        }
        outAParameter(node);
    }

    public void inAIntArrayType(AIntArrayType node)
    {
        defaultIn(node);
    }

    public void outAIntArrayType(AIntArrayType node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAIntArrayType(AIntArrayType node)
    {
        inAIntArrayType(node);
        outAIntArrayType(node);
    }

    public void inABooleanType(ABooleanType node)
    {
        defaultIn(node);
    }

    public void outABooleanType(ABooleanType node)
    {
        defaultOut(node);
    }

    @Override
    public void caseABooleanType(ABooleanType node)
    {
        inABooleanType(node);
        outABooleanType(node);
    }

    public void inAIntegerType(AIntegerType node)
    {
        defaultIn(node);
    }

    public void outAIntegerType(AIntegerType node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAIntegerType(AIntegerType node)
    {
        inAIntegerType(node);
        outAIntegerType(node);
    }

    public void inAIdentifierType(AIdentifierType node)
    {
        defaultIn(node);
    }

    public void outAIdentifierType(AIdentifierType node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAIdentifierType(AIdentifierType node)
    {
        inAIdentifierType(node);
        if(node.getId() != null)
        {
            node.getId().apply(this);
        }
        outAIdentifierType(node);
    }

    public void inABlockStatement(ABlockStatement node)
    {
        defaultIn(node);
    }

    public void outABlockStatement(ABlockStatement node)
    {
        defaultOut(node);
    }

    @Override
    public void caseABlockStatement(ABlockStatement node)
    {
        inABlockStatement(node);
        {
            List<PStatement> copy = new ArrayList<PStatement>(node.getStatementlist());
            Collections.reverse(copy);
            for(PStatement e : copy)
            {
                e.apply(this);
            }
        }
        outABlockStatement(node);
    }

    public void inAIfStatement(AIfStatement node)
    {
        defaultIn(node);
    }

    public void outAIfStatement(AIfStatement node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAIfStatement(AIfStatement node)
    {
        inAIfStatement(node);
        if(node.getElsestatement() != null)
        {
            node.getElsestatement().apply(this);
        }
        if(node.getIfstatement() != null)
        {
            node.getIfstatement().apply(this);
        }
        if(node.getIfexp() != null)
        {
            node.getIfexp().apply(this);
        }
        outAIfStatement(node);
    }

    public void inAWhileStatement(AWhileStatement node)
    {
        defaultIn(node);
    }

    public void outAWhileStatement(AWhileStatement node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAWhileStatement(AWhileStatement node)
    {
        inAWhileStatement(node);
        if(node.getStatement() != null)
        {
            node.getStatement().apply(this);
        }
        if(node.getWhileexp() != null)
        {
            node.getWhileexp().apply(this);
        }
        outAWhileStatement(node);
    }

    public void inAPrintStatement(APrintStatement node)
    {
        defaultIn(node);
    }

    public void outAPrintStatement(APrintStatement node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAPrintStatement(APrintStatement node)
    {
        inAPrintStatement(node);
        if(node.getExp() != null)
        {
            node.getExp().apply(this);
        }
        outAPrintStatement(node);
    }

    public void inAAssignStatement(AAssignStatement node)
    {
        defaultIn(node);
    }

    public void outAAssignStatement(AAssignStatement node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAAssignStatement(AAssignStatement node)
    {
        inAAssignStatement(node);
        if(node.getExp() != null)
        {
            node.getExp().apply(this);
        }
        if(node.getId() != null)
        {
            node.getId().apply(this);
        }
        outAAssignStatement(node);
    }

    public void inAArrayAssignStatement(AArrayAssignStatement node)
    {
        defaultIn(node);
    }

    public void outAArrayAssignStatement(AArrayAssignStatement node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAArrayAssignStatement(AArrayAssignStatement node)
    {
        inAArrayAssignStatement(node);
        if(node.getValue() != null)
        {
            node.getValue().apply(this);
        }
        if(node.getArrayindex() != null)
        {
            node.getArrayindex().apply(this);
        }
        if(node.getId() != null)
        {
            node.getId().apply(this);
        }
        outAArrayAssignStatement(node);
    }

    public void inAAndExp(AAndExp node)
    {
        defaultIn(node);
    }

    public void outAAndExp(AAndExp node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAAndExp(AAndExp node)
    {
        inAAndExp(node);
        if(node.getRight() != null)
        {
            node.getRight().apply(this);
        }
        if(node.getLeft() != null)
        {
            node.getLeft().apply(this);
        }
        outAAndExp(node);
    }

    public void inALessThanExp(ALessThanExp node)
    {
        defaultIn(node);
    }

    public void outALessThanExp(ALessThanExp node)
    {
        defaultOut(node);
    }

    @Override
    public void caseALessThanExp(ALessThanExp node)
    {
        inALessThanExp(node);
        if(node.getRight() != null)
        {
            node.getRight().apply(this);
        }
        if(node.getLeft() != null)
        {
            node.getLeft().apply(this);
        }
        outALessThanExp(node);
    }

    public void inATimesExp(ATimesExp node)
    {
        defaultIn(node);
    }

    public void outATimesExp(ATimesExp node)
    {
        defaultOut(node);
    }

    @Override
    public void caseATimesExp(ATimesExp node)
    {
        inATimesExp(node);
        if(node.getRight() != null)
        {
            node.getRight().apply(this);
        }
        if(node.getLeft() != null)
        {
            node.getLeft().apply(this);
        }
        outATimesExp(node);
    }

    public void inAPlusExp(APlusExp node)
    {
        defaultIn(node);
    }

    public void outAPlusExp(APlusExp node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAPlusExp(APlusExp node)
    {
        inAPlusExp(node);
        if(node.getRight() != null)
        {
            node.getRight().apply(this);
        }
        if(node.getLeft() != null)
        {
            node.getLeft().apply(this);
        }
        outAPlusExp(node);
    }

    public void inAMinusExp(AMinusExp node)
    {
        defaultIn(node);
    }

    public void outAMinusExp(AMinusExp node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAMinusExp(AMinusExp node)
    {
        inAMinusExp(node);
        if(node.getRight() != null)
        {
            node.getRight().apply(this);
        }
        if(node.getLeft() != null)
        {
            node.getLeft().apply(this);
        }
        outAMinusExp(node);
    }

    public void inAArrayLookupExp(AArrayLookupExp node)
    {
        defaultIn(node);
    }

    public void outAArrayLookupExp(AArrayLookupExp node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAArrayLookupExp(AArrayLookupExp node)
    {
        inAArrayLookupExp(node);
        if(node.getIndex() != null)
        {
            node.getIndex().apply(this);
        }
        if(node.getExp() != null)
        {
            node.getExp().apply(this);
        }
        outAArrayLookupExp(node);
    }

    public void inAArrayLengthExp(AArrayLengthExp node)
    {
        defaultIn(node);
    }

    public void outAArrayLengthExp(AArrayLengthExp node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAArrayLengthExp(AArrayLengthExp node)
    {
        inAArrayLengthExp(node);
        if(node.getExp() != null)
        {
            node.getExp().apply(this);
        }
        outAArrayLengthExp(node);
    }

    public void inACallExp(ACallExp node)
    {
        defaultIn(node);
    }

    public void outACallExp(ACallExp node)
    {
        defaultOut(node);
    }

    @Override
    public void caseACallExp(ACallExp node)
    {
        inACallExp(node);
        {
            List<PExp> copy = new ArrayList<PExp>(node.getArgs());
            Collections.reverse(copy);
            for(PExp e : copy)
            {
                e.apply(this);
            }
        }
        if(node.getMethodName() != null)
        {
            node.getMethodName().apply(this);
        }
        if(node.getObject() != null)
        {
            node.getObject().apply(this);
        }
        outACallExp(node);
    }

    public void inAIntegerLiteralExp(AIntegerLiteralExp node)
    {
        defaultIn(node);
    }

    public void outAIntegerLiteralExp(AIntegerLiteralExp node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAIntegerLiteralExp(AIntegerLiteralExp node)
    {
        inAIntegerLiteralExp(node);
        if(node.getNumber() != null)
        {
            node.getNumber().apply(this);
        }
        outAIntegerLiteralExp(node);
    }

    public void inATrueExp(ATrueExp node)
    {
        defaultIn(node);
    }

    public void outATrueExp(ATrueExp node)
    {
        defaultOut(node);
    }

    @Override
    public void caseATrueExp(ATrueExp node)
    {
        inATrueExp(node);
        outATrueExp(node);
    }

    public void inAFalseExp(AFalseExp node)
    {
        defaultIn(node);
    }

    public void outAFalseExp(AFalseExp node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAFalseExp(AFalseExp node)
    {
        inAFalseExp(node);
        outAFalseExp(node);
    }

    public void inAIdentifierExp(AIdentifierExp node)
    {
        defaultIn(node);
    }

    public void outAIdentifierExp(AIdentifierExp node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAIdentifierExp(AIdentifierExp node)
    {
        inAIdentifierExp(node);
        if(node.getId() != null)
        {
            node.getId().apply(this);
        }
        outAIdentifierExp(node);
    }

    public void inAThisExp(AThisExp node)
    {
        defaultIn(node);
    }

    public void outAThisExp(AThisExp node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAThisExp(AThisExp node)
    {
        inAThisExp(node);
        outAThisExp(node);
    }

    public void inANewArrayExp(ANewArrayExp node)
    {
        defaultIn(node);
    }

    public void outANewArrayExp(ANewArrayExp node)
    {
        defaultOut(node);
    }

    @Override
    public void caseANewArrayExp(ANewArrayExp node)
    {
        inANewArrayExp(node);
        if(node.getExp() != null)
        {
            node.getExp().apply(this);
        }
        outANewArrayExp(node);
    }

    public void inANewObjectExp(ANewObjectExp node)
    {
        defaultIn(node);
    }

    public void outANewObjectExp(ANewObjectExp node)
    {
        defaultOut(node);
    }

    @Override
    public void caseANewObjectExp(ANewObjectExp node)
    {
        inANewObjectExp(node);
        if(node.getId() != null)
        {
            node.getId().apply(this);
        }
        outANewObjectExp(node);
    }

    public void inANotExp(ANotExp node)
    {
        defaultIn(node);
    }

    public void outANotExp(ANotExp node)
    {
        defaultOut(node);
    }

    @Override
    public void caseANotExp(ANotExp node)
    {
        inANotExp(node);
        if(node.getExp() != null)
        {
            node.getExp().apply(this);
        }
        outANotExp(node);
    }
}
