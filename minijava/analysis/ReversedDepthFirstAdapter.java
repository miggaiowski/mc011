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
            List<PMethoddecl> copy = new ArrayList<PMethoddecl>(node.getMethoddecl());
            Collections.reverse(copy);
            for(PMethoddecl e : copy)
            {
                e.apply(this);
            }
        }
        {
            List<PVardecl> copy = new ArrayList<PVardecl>(node.getVardecl());
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
        if(node.getId() != null)
        {
            node.getId().apply(this);
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
            List<PMethoddecl> copy = new ArrayList<PMethoddecl>(node.getMethoddecl());
            Collections.reverse(copy);
            for(PMethoddecl e : copy)
            {
                e.apply(this);
            }
        }
        {
            List<PVardecl> copy = new ArrayList<PVardecl>(node.getVardecl());
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
        if(node.getIf() != null)
        {
            node.getIf().apply(this);
        }
        if(node.getExtends() != null)
        {
            node.getExtends().apply(this);
        }
        if(node.getId() != null)
        {
            node.getId().apply(this);
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
        if(node.getId() != null)
        {
            node.getId().apply(this);
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
        if(node.getExp() != null)
        {
            node.getExp().apply(this);
        }
        if(node.getReturn() != null)
        {
            node.getReturn().apply(this);
        }
        {
            List<PStatement> copy = new ArrayList<PStatement>(node.getStatement());
            Collections.reverse(copy);
            for(PStatement e : copy)
            {
                e.apply(this);
            }
        }
        {
            List<PVardecl> copy = new ArrayList<PVardecl>(node.getVardecl());
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
        if(node.getFormallist() != null)
        {
            node.getFormallist().apply(this);
        }
        if(node.getLParenthese() != null)
        {
            node.getLParenthese().apply(this);
        }
        if(node.getId() != null)
        {
            node.getId().apply(this);
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

    public void inADeclareFormallist(ADeclareFormallist node)
    {
        defaultIn(node);
    }

    public void outADeclareFormallist(ADeclareFormallist node)
    {
        defaultOut(node);
    }

    @Override
    public void caseADeclareFormallist(ADeclareFormallist node)
    {
        inADeclareFormallist(node);
        {
            List<PFormalrest> copy = new ArrayList<PFormalrest>(node.getFormalrest());
            Collections.reverse(copy);
            for(PFormalrest e : copy)
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
        outADeclareFormallist(node);
    }

    public void inAEmptyFormallist(AEmptyFormallist node)
    {
        defaultIn(node);
    }

    public void outAEmptyFormallist(AEmptyFormallist node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAEmptyFormallist(AEmptyFormallist node)
    {
        inAEmptyFormallist(node);
        if(node.getBlank() != null)
        {
            node.getBlank().apply(this);
        }
        outAEmptyFormallist(node);
    }

    public void inAFormalrest(AFormalrest node)
    {
        defaultIn(node);
    }

    public void outAFormalrest(AFormalrest node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAFormalrest(AFormalrest node)
    {
        inAFormalrest(node);
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
        outAFormalrest(node);
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

    public void inAOpExp(AOpExp node)
    {
        defaultIn(node);
    }

    public void outAOpExp(AOpExp node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAOpExp(AOpExp node)
    {
        inAOpExp(node);
        if(node.getRight() != null)
        {
            node.getRight().apply(this);
        }
        if(node.getOp() != null)
        {
            node.getOp().apply(this);
        }
        if(node.getLeft() != null)
        {
            node.getLeft().apply(this);
        }
        outAOpExp(node);
    }

    public void inAArraygetExp(AArraygetExp node)
    {
        defaultIn(node);
    }

    public void outAArraygetExp(AArraygetExp node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAArraygetExp(AArraygetExp node)
    {
        inAArraygetExp(node);
        if(node.getRBracket() != null)
        {
            node.getRBracket().apply(this);
        }
        if(node.getOffset() != null)
        {
            node.getOffset().apply(this);
        }
        if(node.getLBracket() != null)
        {
            node.getLBracket().apply(this);
        }
        if(node.getPointer() != null)
        {
            node.getPointer().apply(this);
        }
        outAArraygetExp(node);
    }

    public void inALengthExp(ALengthExp node)
    {
        defaultIn(node);
    }

    public void outALengthExp(ALengthExp node)
    {
        defaultOut(node);
    }

    @Override
    public void caseALengthExp(ALengthExp node)
    {
        inALengthExp(node);
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
        outALengthExp(node);
    }

    public void inAIdlistExp(AIdlistExp node)
    {
        defaultIn(node);
    }

    public void outAIdlistExp(AIdlistExp node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAIdlistExp(AIdlistExp node)
    {
        inAIdlistExp(node);
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
        outAIdlistExp(node);
    }

    public void inANumberExp(ANumberExp node)
    {
        defaultIn(node);
    }

    public void outANumberExp(ANumberExp node)
    {
        defaultOut(node);
    }

    @Override
    public void caseANumberExp(ANumberExp node)
    {
        inANumberExp(node);
        if(node.getNumber() != null)
        {
            node.getNumber().apply(this);
        }
        outANumberExp(node);
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
        if(node.getTrue() != null)
        {
            node.getTrue().apply(this);
        }
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
        if(node.getFalse() != null)
        {
            node.getFalse().apply(this);
        }
        outAFalseExp(node);
    }

    public void inAIdExp(AIdExp node)
    {
        defaultIn(node);
    }

    public void outAIdExp(AIdExp node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAIdExp(AIdExp node)
    {
        inAIdExp(node);
        if(node.getId() != null)
        {
            node.getId().apply(this);
        }
        outAIdExp(node);
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
        if(node.getThis() != null)
        {
            node.getThis().apply(this);
        }
        outAThisExp(node);
    }

    public void inANewintExp(ANewintExp node)
    {
        defaultIn(node);
    }

    public void outANewintExp(ANewintExp node)
    {
        defaultOut(node);
    }

    @Override
    public void caseANewintExp(ANewintExp node)
    {
        inANewintExp(node);
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
        outANewintExp(node);
    }

    public void inANewidExp(ANewidExp node)
    {
        defaultIn(node);
    }

    public void outANewidExp(ANewidExp node)
    {
        defaultOut(node);
    }

    @Override
    public void caseANewidExp(ANewidExp node)
    {
        inANewidExp(node);
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
        outANewidExp(node);
    }

    public void inANotexpExp(ANotexpExp node)
    {
        defaultIn(node);
    }

    public void outANotexpExp(ANotexpExp node)
    {
        defaultOut(node);
    }

    @Override
    public void caseANotexpExp(ANotexpExp node)
    {
        inANotexpExp(node);
        if(node.getExp() != null)
        {
            node.getExp().apply(this);
        }
        if(node.getNot() != null)
        {
            node.getNot().apply(this);
        }
        outANotexpExp(node);
    }

    public void inALparexprparExp(ALparexprparExp node)
    {
        defaultIn(node);
    }

    public void outALparexprparExp(ALparexprparExp node)
    {
        defaultOut(node);
    }

    @Override
    public void caseALparexprparExp(ALparexprparExp node)
    {
        inALparexprparExp(node);
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
        outALparexprparExp(node);
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
