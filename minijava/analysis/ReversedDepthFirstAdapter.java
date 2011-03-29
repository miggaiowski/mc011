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
        if(node.getMainmethod() != null)
        {
            node.getMainmethod().apply(this);
        }
        if(node.getClassname() != null)
        {
            node.getClassname().apply(this);
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
        if(node.getStatements() != null)
        {
            node.getStatements().apply(this);
        }
        if(node.getParamname() != null)
        {
            node.getParamname().apply(this);
        }
        outAMainmethod(node);
    }

    public void inAClassdecl(AClassdecl node)
    {
        defaultIn(node);
    }

    public void outAClassdecl(AClassdecl node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAClassdecl(AClassdecl node)
    {
        inAClassdecl(node);
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
        if(node.getSuper() != null)
        {
            node.getSuper().apply(this);
        }
        if(node.getClassname() != null)
        {
            node.getClassname().apply(this);
        }
        outAClassdecl(node);
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
        if(node.getReturnexpression() != null)
        {
            node.getReturnexpression().apply(this);
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
        {
            List<PParameter> copy = new ArrayList<PParameter>(node.getParameters());
            Collections.reverse(copy);
            for(PParameter e : copy)
            {
                e.apply(this);
            }
        }
        if(node.getMethodname() != null)
        {
            node.getMethodname().apply(this);
        }
        if(node.getType() != null)
        {
            node.getType().apply(this);
        }
        outAMethoddecl(node);
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

    public void inAStatementlistStatement(AStatementlistStatement node)
    {
        defaultIn(node);
    }

    public void outAStatementlistStatement(AStatementlistStatement node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAStatementlistStatement(AStatementlistStatement node)
    {
        inAStatementlistStatement(node);
        {
            List<PStatement> copy = new ArrayList<PStatement>(node.getStatementlist());
            Collections.reverse(copy);
            for(PStatement e : copy)
            {
                e.apply(this);
            }
        }
        outAStatementlistStatement(node);
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
        if(node.getIfstatement() != null)
        {
            node.getIfstatement().apply(this);
        }
        if(node.getIfexp() != null)
        {
            node.getIfexp().apply(this);
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
        if(node.getExp() != null)
        {
            node.getExp().apply(this);
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
        if(node.getRighthandside() != null)
        {
            node.getRighthandside().apply(this);
        }
        if(node.getArrayindex() != null)
        {
            node.getArrayindex().apply(this);
        }
        if(node.getId() != null)
        {
            node.getId().apply(this);
        }
        outAArrayattrStatement(node);
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
        {
            List<PExp> copy = new ArrayList<PExp>(node.getAndexps());
            Collections.reverse(copy);
            for(PExp e : copy)
            {
                e.apply(this);
            }
        }
        outAAndExp(node);
    }

    public void inALessExp(ALessExp node)
    {
        defaultIn(node);
    }

    public void outALessExp(ALessExp node)
    {
        defaultOut(node);
    }

    @Override
    public void caseALessExp(ALessExp node)
    {
        inALessExp(node);
        {
            List<PExp> copy = new ArrayList<PExp>(node.getExps());
            Collections.reverse(copy);
            for(PExp e : copy)
            {
                e.apply(this);
            }
        }
        outALessExp(node);
    }

    public void inAMulExp(AMulExp node)
    {
        defaultIn(node);
    }

    public void outAMulExp(AMulExp node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAMulExp(AMulExp node)
    {
        inAMulExp(node);
        {
            List<PExp> copy = new ArrayList<PExp>(node.getFactor());
            Collections.reverse(copy);
            for(PExp e : copy)
            {
                e.apply(this);
            }
        }
        outAMulExp(node);
    }

    public void inAAddExp(AAddExp node)
    {
        defaultIn(node);
    }

    public void outAAddExp(AAddExp node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAAddExp(AAddExp node)
    {
        inAAddExp(node);
        {
            List<PExp> copy = new ArrayList<PExp>(node.getTerms());
            Collections.reverse(copy);
            for(PExp e : copy)
            {
                e.apply(this);
            }
        }
        outAAddExp(node);
    }

    public void inASubExp(ASubExp node)
    {
        defaultIn(node);
    }

    public void outASubExp(ASubExp node)
    {
        defaultOut(node);
    }

    @Override
    public void caseASubExp(ASubExp node)
    {
        inASubExp(node);
        {
            List<PExp> copy = new ArrayList<PExp>(node.getTerms());
            Collections.reverse(copy);
            for(PExp e : copy)
            {
                e.apply(this);
            }
        }
        outASubExp(node);
    }

    public void inAIndexExp(AIndexExp node)
    {
        defaultIn(node);
    }

    public void outAIndexExp(AIndexExp node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAIndexExp(AIndexExp node)
    {
        inAIndexExp(node);
        if(node.getOffset() != null)
        {
            node.getOffset().apply(this);
        }
        if(node.getPointer() != null)
        {
            node.getPointer().apply(this);
        }
        outAIndexExp(node);
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
        outALengthExp(node);
    }

    public void inAMethodcallExp(AMethodcallExp node)
    {
        defaultIn(node);
    }

    public void outAMethodcallExp(AMethodcallExp node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAMethodcallExp(AMethodcallExp node)
    {
        inAMethodcallExp(node);
        {
            List<PExp> copy = new ArrayList<PExp>(node.getExplist());
            Collections.reverse(copy);
            for(PExp e : copy)
            {
                e.apply(this);
            }
        }
        if(node.getId() != null)
        {
            node.getId().apply(this);
        }
        outAMethodcallExp(node);
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
        outAThisExp(node);
    }

    public void inANewintarrayExp(ANewintarrayExp node)
    {
        defaultIn(node);
    }

    public void outANewintarrayExp(ANewintarrayExp node)
    {
        defaultOut(node);
    }

    @Override
    public void caseANewintarrayExp(ANewintarrayExp node)
    {
        inANewintarrayExp(node);
        if(node.getExp() != null)
        {
            node.getExp().apply(this);
        }
        outANewintarrayExp(node);
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
        if(node.getId() != null)
        {
            node.getId().apply(this);
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
        if(node.getExp() != null)
        {
            node.getExp().apply(this);
        }
        outALparexprparExp(node);
    }

    public void inAPreposExp(APreposExp node)
    {
        defaultIn(node);
    }

    public void outAPreposExp(APreposExp node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAPreposExp(APreposExp node)
    {
        inAPreposExp(node);
        {
            List<PExp> copy = new ArrayList<PExp>(node.getPosfixs());
            Collections.reverse(copy);
            for(PExp e : copy)
            {
                e.apply(this);
            }
        }
        if(node.getPrefix() != null)
        {
            node.getPrefix().apply(this);
        }
        outAPreposExp(node);
    }
}
