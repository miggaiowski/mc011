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
            List<PClassdecl> copy = new ArrayList<PClassdecl>(node.getClassdecl());
            Collections.reverse(copy);
            for(PClassdecl e : copy)
            {
                e.apply(this);
            }
        }
        if(node.getMainclass() != null)
        {
            node.getMainclass().apply(this);
        }
        outAProgram(node);
    }

    public void inAMainclass(AMainclass node)
    {
        defaultIn(node);
    }

    public void outAMainclass(AMainclass node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAMainclass(AMainclass node)
    {
        inAMainclass(node);
        if(node.getRBrace() != null)
        {
            node.getRBrace().apply(this);
        }
        if(node.getMainmethod() != null)
        {
            node.getMainmethod().apply(this);
        }
        if(node.getLBrace() != null)
        {
            node.getLBrace().apply(this);
        }
        if(node.getClassname() != null)
        {
            node.getClassname().apply(this);
        }
        if(node.getClassn() != null)
        {
            node.getClassn().apply(this);
        }
        outAMainclass(node);
    }

    public void inAMainmethod(AMainmethod node)
    {
        defaultIn(node);
    }

    public void outAMainmethod(AMainmethod node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAMainmethod(AMainmethod node)
    {
        inAMainmethod(node);
        if(node.getRBrace() != null)
        {
            node.getRBrace().apply(this);
        }
        if(node.getStatement() != null)
        {
            node.getStatement().apply(this);
        }
        if(node.getLBrace() != null)
        {
            node.getLBrace().apply(this);
        }
        if(node.getRParenthese() != null)
        {
            node.getRParenthese().apply(this);
        }
        if(node.getParamname() != null)
        {
            node.getParamname().apply(this);
        }
        if(node.getRBracket() != null)
        {
            node.getRBracket().apply(this);
        }
        if(node.getLBracket() != null)
        {
            node.getLBracket().apply(this);
        }
        if(node.getString() != null)
        {
            node.getString().apply(this);
        }
        if(node.getLParenthese() != null)
        {
            node.getLParenthese().apply(this);
        }
        if(node.getMain() != null)
        {
            node.getMain().apply(this);
        }
        if(node.getVoid() != null)
        {
            node.getVoid().apply(this);
        }
        if(node.getStatic() != null)
        {
            node.getStatic().apply(this);
        }
        if(node.getPublic() != null)
        {
            node.getPublic().apply(this);
        }
        outAMainmethod(node);
    }

    public void inASimpleclassClassdecl(ASimpleclassClassdecl node)
    {
        defaultIn(node);
    }

    public void outASimpleclassClassdecl(ASimpleclassClassdecl node)
    {
        defaultOut(node);
    }

    @Override
    public void caseASimpleclassClassdecl(ASimpleclassClassdecl node)
    {
        inASimpleclassClassdecl(node);
        if(node.getRBrace() != null)
        {
            node.getRBrace().apply(this);
        }
        {
            List<PMethoddecl> copy = new ArrayList<PMethoddecl>(node.getMethods());
            Collections.reverse(copy);
            for(PMethoddecl e : copy)
            {
                e.apply(this);
            }
        }
        {
            List<PVardecl> copy = new ArrayList<PVardecl>(node.getVars());
            Collections.reverse(copy);
            for(PVardecl e : copy)
            {
                e.apply(this);
            }
        }
        if(node.getLBrace() != null)
        {
            node.getLBrace().apply(this);
        }
        if(node.getClassname() != null)
        {
            node.getClassname().apply(this);
        }
        if(node.getClassn() != null)
        {
            node.getClassn().apply(this);
        }
        outASimpleclassClassdecl(node);
    }

    public void inAExtendingclassClassdecl(AExtendingclassClassdecl node)
    {
        defaultIn(node);
    }

    public void outAExtendingclassClassdecl(AExtendingclassClassdecl node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAExtendingclassClassdecl(AExtendingclassClassdecl node)
    {
        inAExtendingclassClassdecl(node);
        if(node.getRBrace() != null)
        {
            node.getRBrace().apply(this);
        }
        {
            List<PMethoddecl> copy = new ArrayList<PMethoddecl>(node.getMethods());
            Collections.reverse(copy);
            for(PMethoddecl e : copy)
            {
                e.apply(this);
            }
        }
        {
            List<PVardecl> copy = new ArrayList<PVardecl>(node.getVars());
            Collections.reverse(copy);
            for(PVardecl e : copy)
            {
                e.apply(this);
            }
        }
        if(node.getLBrace() != null)
        {
            node.getLBrace().apply(this);
        }
        if(node.getSuper() != null)
        {
            node.getSuper().apply(this);
        }
        if(node.getExtends() != null)
        {
            node.getExtends().apply(this);
        }
        if(node.getClassname() != null)
        {
            node.getClassname().apply(this);
        }
        if(node.getClassn() != null)
        {
            node.getClassn().apply(this);
        }
        outAExtendingclassClassdecl(node);
    }

    public void inAVardecl(AVardecl node)
    {
        defaultIn(node);
    }

    public void outAVardecl(AVardecl node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAVardecl(AVardecl node)
    {
        inAVardecl(node);
        if(node.getSemicolon() != null)
        {
            node.getSemicolon().apply(this);
        }
        if(node.getVarname() != null)
        {
            node.getVarname().apply(this);
        }
        if(node.getType() != null)
        {
            node.getType().apply(this);
        }
        outAVardecl(node);
    }

    public void inAMethoddecl(AMethoddecl node)
    {
        defaultIn(node);
    }

    public void outAMethoddecl(AMethoddecl node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAMethoddecl(AMethoddecl node)
    {
        inAMethoddecl(node);
        if(node.getRBrace() != null)
        {
            node.getRBrace().apply(this);
        }
        if(node.getSemicolon() != null)
        {
            node.getSemicolon().apply(this);
        }
        if(node.getReturnexpression() != null)
        {
            node.getReturnexpression().apply(this);
        }
        if(node.getReturn() != null)
        {
            node.getReturn().apply(this);
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
            List<PVardecl> copy = new ArrayList<PVardecl>(node.getVars());
            Collections.reverse(copy);
            for(PVardecl e : copy)
            {
                e.apply(this);
            }
        }
        if(node.getLBrace() != null)
        {
            node.getLBrace().apply(this);
        }
        if(node.getRParenthese() != null)
        {
            node.getRParenthese().apply(this);
        }
        if(node.getParamlist() != null)
        {
            node.getParamlist().apply(this);
        }
        if(node.getLParenthese() != null)
        {
            node.getLParenthese().apply(this);
        }
        if(node.getMethodname() != null)
        {
            node.getMethodname().apply(this);
        }
        if(node.getType() != null)
        {
            node.getType().apply(this);
        }
        if(node.getPublic() != null)
        {
            node.getPublic().apply(this);
        }
        outAMethoddecl(node);
    }

    public void inAFirstparameterParamlist(AFirstparameterParamlist node)
    {
        defaultIn(node);
    }

    public void outAFirstparameterParamlist(AFirstparameterParamlist node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAFirstparameterParamlist(AFirstparameterParamlist node)
    {
        inAFirstparameterParamlist(node);
        {
            List<PParamrest> copy = new ArrayList<PParamrest>(node.getParamrest());
            Collections.reverse(copy);
            for(PParamrest e : copy)
            {
                e.apply(this);
            }
        }
        if(node.getId() != null)
        {
            node.getId().apply(this);
        }
        if(node.getType() != null)
        {
            node.getType().apply(this);
        }
        outAFirstparameterParamlist(node);
    }

    public void inAEmptyParamlist(AEmptyParamlist node)
    {
        defaultIn(node);
    }

    public void outAEmptyParamlist(AEmptyParamlist node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAEmptyParamlist(AEmptyParamlist node)
    {
        inAEmptyParamlist(node);
        if(node.getBlank() != null)
        {
            node.getBlank().apply(this);
        }
        outAEmptyParamlist(node);
    }

    public void inAAnotherparameterParamrest(AAnotherparameterParamrest node)
    {
        defaultIn(node);
    }

    public void outAAnotherparameterParamrest(AAnotherparameterParamrest node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAAnotherparameterParamrest(AAnotherparameterParamrest node)
    {
        inAAnotherparameterParamrest(node);
        if(node.getId() != null)
        {
            node.getId().apply(this);
        }
        if(node.getType() != null)
        {
            node.getType().apply(this);
        }
        if(node.getComma() != null)
        {
            node.getComma().apply(this);
        }
        outAAnotherparameterParamrest(node);
    }

    public void inAIntvectorType(AIntvectorType node)
    {
        defaultIn(node);
    }

    public void outAIntvectorType(AIntvectorType node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAIntvectorType(AIntvectorType node)
    {
        inAIntvectorType(node);
        if(node.getRBracket() != null)
        {
            node.getRBracket().apply(this);
        }
        if(node.getLBracket() != null)
        {
            node.getLBracket().apply(this);
        }
        if(node.getInt() != null)
        {
            node.getInt().apply(this);
        }
        outAIntvectorType(node);
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
        if(node.getBoolean() != null)
        {
            node.getBoolean().apply(this);
        }
        outABooleanType(node);
    }

    public void inAIntType(AIntType node)
    {
        defaultIn(node);
    }

    public void outAIntType(AIntType node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAIntType(AIntType node)
    {
        inAIntType(node);
        if(node.getInt() != null)
        {
            node.getInt().apply(this);
        }
        outAIntType(node);
    }

    public void inAIdType(AIdType node)
    {
        defaultIn(node);
    }

    public void outAIdType(AIdType node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAIdType(AIdType node)
    {
        inAIdType(node);
        if(node.getId() != null)
        {
            node.getId().apply(this);
        }
        outAIdType(node);
    }

    public void inAStatementsStatement(AStatementsStatement node)
    {
        defaultIn(node);
    }

    public void outAStatementsStatement(AStatementsStatement node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAStatementsStatement(AStatementsStatement node)
    {
        inAStatementsStatement(node);
        if(node.getRBrace() != null)
        {
            node.getRBrace().apply(this);
        }
        {
            List<PStatement> copy = new ArrayList<PStatement>(node.getStatement());
            Collections.reverse(copy);
            for(PStatement e : copy)
            {
                e.apply(this);
            }
        }
        if(node.getLBrace() != null)
        {
            node.getLBrace().apply(this);
        }
        outAStatementsStatement(node);
    }

    public void inAIfelseStatement(AIfelseStatement node)
    {
        defaultIn(node);
    }

    public void outAIfelseStatement(AIfelseStatement node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAIfelseStatement(AIfelseStatement node)
    {
        inAIfelseStatement(node);
        if(node.getElsestatement() != null)
        {
            node.getElsestatement().apply(this);
        }
        if(node.getElse() != null)
        {
            node.getElse().apply(this);
        }
        if(node.getIfstatement() != null)
        {
            node.getIfstatement().apply(this);
        }
        if(node.getRParenthese() != null)
        {
            node.getRParenthese().apply(this);
        }
        if(node.getExp() != null)
        {
            node.getExp().apply(this);
        }
        if(node.getLParenthese() != null)
        {
            node.getLParenthese().apply(this);
        }
        if(node.getIf() != null)
        {
            node.getIf().apply(this);
        }
        outAIfelseStatement(node);
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
        if(node.getRParenthese() != null)
        {
            node.getRParenthese().apply(this);
        }
        if(node.getExp() != null)
        {
            node.getExp().apply(this);
        }
        if(node.getLParenthese() != null)
        {
            node.getLParenthese().apply(this);
        }
        if(node.getWhile() != null)
        {
            node.getWhile().apply(this);
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
        if(node.getSemicolon() != null)
        {
            node.getSemicolon().apply(this);
        }
        if(node.getRParenthese() != null)
        {
            node.getRParenthese().apply(this);
        }
        if(node.getExp() != null)
        {
            node.getExp().apply(this);
        }
        if(node.getLParenthese() != null)
        {
            node.getLParenthese().apply(this);
        }
        if(node.getPrint() != null)
        {
            node.getPrint().apply(this);
        }
        outAPrintStatement(node);
    }

    public void inAAttrStatement(AAttrStatement node)
    {
        defaultIn(node);
    }

    public void outAAttrStatement(AAttrStatement node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAAttrStatement(AAttrStatement node)
    {
        inAAttrStatement(node);
        if(node.getSemicolon() != null)
        {
            node.getSemicolon().apply(this);
        }
        if(node.getExp() != null)
        {
            node.getExp().apply(this);
        }
        if(node.getEqual() != null)
        {
            node.getEqual().apply(this);
        }
        if(node.getId() != null)
        {
            node.getId().apply(this);
        }
        outAAttrStatement(node);
    }

    public void inAArrayattrStatement(AArrayattrStatement node)
    {
        defaultIn(node);
    }

    public void outAArrayattrStatement(AArrayattrStatement node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAArrayattrStatement(AArrayattrStatement node)
    {
        inAArrayattrStatement(node);
        if(node.getSemicolon() != null)
        {
            node.getSemicolon().apply(this);
        }
        if(node.getRighthandside() != null)
        {
            node.getRighthandside().apply(this);
        }
        if(node.getEqual() != null)
        {
            node.getEqual().apply(this);
        }
        if(node.getRBracket() != null)
        {
            node.getRBracket().apply(this);
        }
        if(node.getArrayindex() != null)
        {
            node.getArrayindex().apply(this);
        }
        if(node.getLBracket() != null)
        {
            node.getLBracket().apply(this);
        }
        if(node.getId() != null)
        {
            node.getId().apply(this);
        }
        outAArrayattrStatement(node);
    }

    public void inAExp(AExp node)
    {
        defaultIn(node);
    }

    public void outAExp(AExp node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAExp(AExp node)
    {
        inAExp(node);
        if(node.getAndstmList() != null)
        {
            node.getAndstmList().apply(this);
        }
        outAExp(node);
    }

    public void inAAndstmList(AAndstmList node)
    {
        defaultIn(node);
    }

    public void outAAndstmList(AAndstmList node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAAndstmList(AAndstmList node)
    {
        inAAndstmList(node);
        {
            List<PAndstmRest> copy = new ArrayList<PAndstmRest>(node.getAndstmRest());
            Collections.reverse(copy);
            for(PAndstmRest e : copy)
            {
                e.apply(this);
            }
        }
        if(node.getLessThan() != null)
        {
            node.getLessThan().apply(this);
        }
        outAAndstmList(node);
    }

    public void inAAndstmRest(AAndstmRest node)
    {
        defaultIn(node);
    }

    public void outAAndstmRest(AAndstmRest node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAAndstmRest(AAndstmRest node)
    {
        inAAndstmRest(node);
        if(node.getLessThan() != null)
        {
            node.getLessThan().apply(this);
        }
        if(node.getAnd() != null)
        {
            node.getAnd().apply(this);
        }
        outAAndstmRest(node);
    }

    public void inALessThan(ALessThan node)
    {
        defaultIn(node);
    }

    public void outALessThan(ALessThan node)
    {
        defaultOut(node);
    }

    @Override
    public void caseALessThan(ALessThan node)
    {
        inALessThan(node);
        if(node.getLessThanPlusMinus() != null)
        {
            node.getLessThanPlusMinus().apply(this);
        }
        if(node.getPlusMinusList() != null)
        {
            node.getPlusMinusList().apply(this);
        }
        outALessThan(node);
    }

    public void inALessThanPlusMinus(ALessThanPlusMinus node)
    {
        defaultIn(node);
    }

    public void outALessThanPlusMinus(ALessThanPlusMinus node)
    {
        defaultOut(node);
    }

    @Override
    public void caseALessThanPlusMinus(ALessThanPlusMinus node)
    {
        inALessThanPlusMinus(node);
        if(node.getPlusMinusList() != null)
        {
            node.getPlusMinusList().apply(this);
        }
        if(node.getLess() != null)
        {
            node.getLess().apply(this);
        }
        outALessThanPlusMinus(node);
    }

    public void inAPlusMinusList(APlusMinusList node)
    {
        defaultIn(node);
    }

    public void outAPlusMinusList(APlusMinusList node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAPlusMinusList(APlusMinusList node)
    {
        inAPlusMinusList(node);
        {
            List<PPlusMinusRest> copy = new ArrayList<PPlusMinusRest>(node.getPlusMinusRest());
            Collections.reverse(copy);
            for(PPlusMinusRest e : copy)
            {
                e.apply(this);
            }
        }
        if(node.getTimesList() != null)
        {
            node.getTimesList().apply(this);
        }
        outAPlusMinusList(node);
    }

    public void inAPlusMinusRest(APlusMinusRest node)
    {
        defaultIn(node);
    }

    public void outAPlusMinusRest(APlusMinusRest node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAPlusMinusRest(APlusMinusRest node)
    {
        inAPlusMinusRest(node);
        if(node.getTimesList() != null)
        {
            node.getTimesList().apply(this);
        }
        if(node.getPlusminusop() != null)
        {
            node.getPlusminusop().apply(this);
        }
        outAPlusMinusRest(node);
    }

    public void inATimesList(ATimesList node)
    {
        defaultIn(node);
    }

    public void outATimesList(ATimesList node)
    {
        defaultOut(node);
    }

    @Override
    public void caseATimesList(ATimesList node)
    {
        inATimesList(node);
        {
            List<PTimesRest> copy = new ArrayList<PTimesRest>(node.getTimesRest());
            Collections.reverse(copy);
            for(PTimesRest e : copy)
            {
                e.apply(this);
            }
        }
        if(node.getPrefixexp() != null)
        {
            node.getPrefixexp().apply(this);
        }
        outATimesList(node);
    }

    public void inATimesRest(ATimesRest node)
    {
        defaultIn(node);
    }

    public void outATimesRest(ATimesRest node)
    {
        defaultOut(node);
    }

    @Override
    public void caseATimesRest(ATimesRest node)
    {
        inATimesRest(node);
        if(node.getPrefixexp() != null)
        {
            node.getPrefixexp().apply(this);
        }
        if(node.getTimesop() != null)
        {
            node.getTimesop().apply(this);
        }
        outATimesRest(node);
    }

    public void inANotExpressionPrefixexp(ANotExpressionPrefixexp node)
    {
        defaultIn(node);
    }

    public void outANotExpressionPrefixexp(ANotExpressionPrefixexp node)
    {
        defaultOut(node);
    }

    @Override
    public void caseANotExpressionPrefixexp(ANotExpressionPrefixexp node)
    {
        inANotExpressionPrefixexp(node);
        if(node.getNotexp() != null)
        {
            node.getNotexp().apply(this);
        }
        outANotExpressionPrefixexp(node);
    }

    public void inAExpressionPrefixexp(AExpressionPrefixexp node)
    {
        defaultIn(node);
    }

    public void outAExpressionPrefixexp(AExpressionPrefixexp node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAExpressionPrefixexp(AExpressionPrefixexp node)
    {
        inAExpressionPrefixexp(node);
        if(node.getPostfixexpList() != null)
        {
            node.getPostfixexpList().apply(this);
        }
        outAExpressionPrefixexp(node);
    }

    public void inANotexp(ANotexp node)
    {
        defaultIn(node);
    }

    public void outANotexp(ANotexp node)
    {
        defaultOut(node);
    }

    @Override
    public void caseANotexp(ANotexp node)
    {
        inANotexp(node);
        if(node.getPostfixexpList() != null)
        {
            node.getPostfixexpList().apply(this);
        }
        {
            List<TNot> copy = new ArrayList<TNot>(node.getNot());
            Collections.reverse(copy);
            for(TNot e : copy)
            {
                e.apply(this);
            }
        }
        outANotexp(node);
    }

    public void inAPostfixexpList(APostfixexpList node)
    {
        defaultIn(node);
    }

    public void outAPostfixexpList(APostfixexpList node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAPostfixexpList(APostfixexpList node)
    {
        inAPostfixexpList(node);
        {
            List<PPostfixexpRest> copy = new ArrayList<PPostfixexpRest>(node.getPostfixexpRest());
            Collections.reverse(copy);
            for(PPostfixexpRest e : copy)
            {
                e.apply(this);
            }
        }
        if(node.getPrimaryExp() != null)
        {
            node.getPrimaryExp().apply(this);
        }
        outAPostfixexpList(node);
    }

    public void inAIndexPostfixexpRest(AIndexPostfixexpRest node)
    {
        defaultIn(node);
    }

    public void outAIndexPostfixexpRest(AIndexPostfixexpRest node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAIndexPostfixexpRest(AIndexPostfixexpRest node)
    {
        inAIndexPostfixexpRest(node);
        if(node.getRBracket() != null)
        {
            node.getRBracket().apply(this);
        }
        if(node.getExp() != null)
        {
            node.getExp().apply(this);
        }
        if(node.getLBracket() != null)
        {
            node.getLBracket().apply(this);
        }
        outAIndexPostfixexpRest(node);
    }

    public void inAIdlistPostfixexpRest(AIdlistPostfixexpRest node)
    {
        defaultIn(node);
    }

    public void outAIdlistPostfixexpRest(AIdlistPostfixexpRest node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAIdlistPostfixexpRest(AIdlistPostfixexpRest node)
    {
        inAIdlistPostfixexpRest(node);
        if(node.getRParenthese() != null)
        {
            node.getRParenthese().apply(this);
        }
        if(node.getExplist() != null)
        {
            node.getExplist().apply(this);
        }
        if(node.getLParenthese() != null)
        {
            node.getLParenthese().apply(this);
        }
        if(node.getId() != null)
        {
            node.getId().apply(this);
        }
        if(node.getDot() != null)
        {
            node.getDot().apply(this);
        }
        if(node.getExp() != null)
        {
            node.getExp().apply(this);
        }
        outAIdlistPostfixexpRest(node);
    }

    public void inALengthPostfixexpRest(ALengthPostfixexpRest node)
    {
        defaultIn(node);
    }

    public void outALengthPostfixexpRest(ALengthPostfixexpRest node)
    {
        defaultOut(node);
    }

    @Override
    public void caseALengthPostfixexpRest(ALengthPostfixexpRest node)
    {
        inALengthPostfixexpRest(node);
        if(node.getLength() != null)
        {
            node.getLength().apply(this);
        }
        if(node.getDot() != null)
        {
            node.getDot().apply(this);
        }
        if(node.getExp() != null)
        {
            node.getExp().apply(this);
        }
        outALengthPostfixexpRest(node);
    }

    public void inANumberPrimaryExp(ANumberPrimaryExp node)
    {
        defaultIn(node);
    }

    public void outANumberPrimaryExp(ANumberPrimaryExp node)
    {
        defaultOut(node);
    }

    @Override
    public void caseANumberPrimaryExp(ANumberPrimaryExp node)
    {
        inANumberPrimaryExp(node);
        if(node.getNumber() != null)
        {
            node.getNumber().apply(this);
        }
        outANumberPrimaryExp(node);
    }

    public void inATruePrimaryExp(ATruePrimaryExp node)
    {
        defaultIn(node);
    }

    public void outATruePrimaryExp(ATruePrimaryExp node)
    {
        defaultOut(node);
    }

    @Override
    public void caseATruePrimaryExp(ATruePrimaryExp node)
    {
        inATruePrimaryExp(node);
        if(node.getTrue() != null)
        {
            node.getTrue().apply(this);
        }
        outATruePrimaryExp(node);
    }

    public void inAFalsePrimaryExp(AFalsePrimaryExp node)
    {
        defaultIn(node);
    }

    public void outAFalsePrimaryExp(AFalsePrimaryExp node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAFalsePrimaryExp(AFalsePrimaryExp node)
    {
        inAFalsePrimaryExp(node);
        if(node.getFalse() != null)
        {
            node.getFalse().apply(this);
        }
        outAFalsePrimaryExp(node);
    }

    public void inAIdPrimaryExp(AIdPrimaryExp node)
    {
        defaultIn(node);
    }

    public void outAIdPrimaryExp(AIdPrimaryExp node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAIdPrimaryExp(AIdPrimaryExp node)
    {
        inAIdPrimaryExp(node);
        if(node.getId() != null)
        {
            node.getId().apply(this);
        }
        outAIdPrimaryExp(node);
    }

    public void inAThisPrimaryExp(AThisPrimaryExp node)
    {
        defaultIn(node);
    }

    public void outAThisPrimaryExp(AThisPrimaryExp node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAThisPrimaryExp(AThisPrimaryExp node)
    {
        inAThisPrimaryExp(node);
        if(node.getThis() != null)
        {
            node.getThis().apply(this);
        }
        outAThisPrimaryExp(node);
    }

    public void inANewintPrimaryExp(ANewintPrimaryExp node)
    {
        defaultIn(node);
    }

    public void outANewintPrimaryExp(ANewintPrimaryExp node)
    {
        defaultOut(node);
    }

    @Override
    public void caseANewintPrimaryExp(ANewintPrimaryExp node)
    {
        inANewintPrimaryExp(node);
        if(node.getRBracket() != null)
        {
            node.getRBracket().apply(this);
        }
        if(node.getExp() != null)
        {
            node.getExp().apply(this);
        }
        if(node.getLBracket() != null)
        {
            node.getLBracket().apply(this);
        }
        if(node.getInt() != null)
        {
            node.getInt().apply(this);
        }
        if(node.getNew() != null)
        {
            node.getNew().apply(this);
        }
        outANewintPrimaryExp(node);
    }

    public void inANewidPrimaryExp(ANewidPrimaryExp node)
    {
        defaultIn(node);
    }

    public void outANewidPrimaryExp(ANewidPrimaryExp node)
    {
        defaultOut(node);
    }

    @Override
    public void caseANewidPrimaryExp(ANewidPrimaryExp node)
    {
        inANewidPrimaryExp(node);
        if(node.getRParenthese() != null)
        {
            node.getRParenthese().apply(this);
        }
        if(node.getLParenthese() != null)
        {
            node.getLParenthese().apply(this);
        }
        if(node.getId() != null)
        {
            node.getId().apply(this);
        }
        if(node.getNew() != null)
        {
            node.getNew().apply(this);
        }
        outANewidPrimaryExp(node);
    }

    public void inALparexprparPrimaryExp(ALparexprparPrimaryExp node)
    {
        defaultIn(node);
    }

    public void outALparexprparPrimaryExp(ALparexprparPrimaryExp node)
    {
        defaultOut(node);
    }

    @Override
    public void caseALparexprparPrimaryExp(ALparexprparPrimaryExp node)
    {
        inALparexprparPrimaryExp(node);
        if(node.getRParenthese() != null)
        {
            node.getRParenthese().apply(this);
        }
        if(node.getExp() != null)
        {
            node.getExp().apply(this);
        }
        if(node.getLParenthese() != null)
        {
            node.getLParenthese().apply(this);
        }
        outALparexprparPrimaryExp(node);
    }

    public void inAExplistheadExplist(AExplistheadExplist node)
    {
        defaultIn(node);
    }

    public void outAExplistheadExplist(AExplistheadExplist node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAExplistheadExplist(AExplistheadExplist node)
    {
        inAExplistheadExplist(node);
        {
            List<PExprest> copy = new ArrayList<PExprest>(node.getExprest());
            Collections.reverse(copy);
            for(PExprest e : copy)
            {
                e.apply(this);
            }
        }
        if(node.getExp() != null)
        {
            node.getExp().apply(this);
        }
        outAExplistheadExplist(node);
    }

    public void inABlankExplist(ABlankExplist node)
    {
        defaultIn(node);
    }

    public void outABlankExplist(ABlankExplist node)
    {
        defaultOut(node);
    }

    @Override
    public void caseABlankExplist(ABlankExplist node)
    {
        inABlankExplist(node);
        if(node.getBlank() != null)
        {
            node.getBlank().apply(this);
        }
        outABlankExplist(node);
    }

    public void inAExprest(AExprest node)
    {
        defaultIn(node);
    }

    public void outAExprest(AExprest node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAExprest(AExprest node)
    {
        inAExprest(node);
        if(node.getExp() != null)
        {
            node.getExp().apply(this);
        }
        if(node.getComma() != null)
        {
            node.getComma().apply(this);
        }
        outAExprest(node);
    }
}