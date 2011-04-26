/* This file was generated by SableCC (http://www.sablecc.org/). */

package minijava.analysis;

import minijava.node.*;

public interface Analysis extends Switch
{
    Object getIn(Node node);
    void setIn(Node node, Object o);
    Object getOut(Node node);
    void setOut(Node node, Object o);

    void caseStart(Start node);
    void caseAProgram(AProgram node);
    void caseAMainClass(AMainClass node);
    void caseASimpleClassDecl(ASimpleClassDecl node);
    void caseAExtendsClassDecl(AExtendsClassDecl node);
    void caseAVarDecl(AVarDecl node);
    void caseAMethodDecl(AMethodDecl node);
    void caseAParameter(AParameter node);
    void caseAIntArrayType(AIntArrayType node);
    void caseABooleanType(ABooleanType node);
    void caseAIntegerType(AIntegerType node);
    void caseAIdentifierType(AIdentifierType node);
    void caseABlockStatement(ABlockStatement node);
    void caseAIfStatement(AIfStatement node);
    void caseAIfElseStatement(AIfElseStatement node);
    void caseAWhileStatement(AWhileStatement node);
    void caseAPrintStatement(APrintStatement node);
    void caseAAssignStatement(AAssignStatement node);
    void caseAArrayAssignStatement(AArrayAssignStatement node);
    void caseAAndExp(AAndExp node);
    void caseALessThanExp(ALessThanExp node);
    void caseATimesExp(ATimesExp node);
    void caseAPlusExp(APlusExp node);
    void caseAMinusExp(AMinusExp node);
    void caseAArrayLookupExp(AArrayLookupExp node);
    void caseAArrayLengthExp(AArrayLengthExp node);
    void caseACallExp(ACallExp node);
    void caseAIntegerLiteralExp(AIntegerLiteralExp node);
    void caseATrueExp(ATrueExp node);
    void caseAFalseExp(AFalseExp node);
    void caseAIdentifierExp(AIdentifierExp node);
    void caseAThisExp(AThisExp node);
    void caseANewArrayExp(ANewArrayExp node);
    void caseANewObjectExp(ANewObjectExp node);
    void caseANotExp(ANotExp node);
    void caseAParentheseExp(AParentheseExp node);

    void caseTClassn(TClassn node);
    void caseTExtends(TExtends node);
    void caseTPublic(TPublic node);
    void caseTStatic(TStatic node);
    void caseTVoid(TVoid node);
    void caseTMain(TMain node);
    void caseTString(TString node);
    void caseTInt(TInt node);
    void caseTBoolean(TBoolean node);
    void caseTIf(TIf node);
    void caseTElse(TElse node);
    void caseTWhile(TWhile node);
    void caseTLength(TLength node);
    void caseTNew(TNew node);
    void caseTTrue(TTrue node);
    void caseTFalse(TFalse node);
    void caseTReturn(TReturn node);
    void caseTThis(TThis node);
    void caseTId(TId node);
    void caseTNumber(TNumber node);
    void caseTPlusop(TPlusop node);
    void caseTMinusop(TMinusop node);
    void caseTTimesop(TTimesop node);
    void caseTAnd(TAnd node);
    void caseTLess(TLess node);
    void caseTEqual(TEqual node);
    void caseTNot(TNot node);
    void caseTLBracket(TLBracket node);
    void caseTRBracket(TRBracket node);
    void caseTLBrace(TLBrace node);
    void caseTRBrace(TRBrace node);
    void caseTLParenthese(TLParenthese node);
    void caseTRParenthese(TRParenthese node);
    void caseTDot(TDot node);
    void caseTSemicolon(TSemicolon node);
    void caseTComma(TComma node);
    void caseTBlank(TBlank node);
    void caseTPrint(TPrint node);
    void caseTComment(TComment node);
    void caseEOF(EOF node);
}
