/* This file was generated by SableCC (http://www.sablecc.org/). */

package node;

import java.util.*;
import analysis.*;

@SuppressWarnings("nls")
public final class AMethoddecl extends PMethoddecl
{
    private TPublic _public_;
    private PType _type_;
    private TId _methodname_;
    private TLParenthese _lParenthese_;
    private PParamlist _paramlist_;
    private TRParenthese _rParenthese_;
    private TLBrace _lBrace_;
    private final LinkedList<PVardecl> _vars_ = new LinkedList<PVardecl>();
    private final LinkedList<PStatement> _statements_ = new LinkedList<PStatement>();
    private TReturn _return_;
    private PExp _returnexpression_;
    private TSemicolon _semicolon_;
    private TRBrace _rBrace_;

    public AMethoddecl()
    {
        // Constructor
    }

    public AMethoddecl(
        @SuppressWarnings("hiding") TPublic _public_,
        @SuppressWarnings("hiding") PType _type_,
        @SuppressWarnings("hiding") TId _methodname_,
        @SuppressWarnings("hiding") TLParenthese _lParenthese_,
        @SuppressWarnings("hiding") PParamlist _paramlist_,
        @SuppressWarnings("hiding") TRParenthese _rParenthese_,
        @SuppressWarnings("hiding") TLBrace _lBrace_,
        @SuppressWarnings("hiding") List<PVardecl> _vars_,
        @SuppressWarnings("hiding") List<PStatement> _statements_,
        @SuppressWarnings("hiding") TReturn _return_,
        @SuppressWarnings("hiding") PExp _returnexpression_,
        @SuppressWarnings("hiding") TSemicolon _semicolon_,
        @SuppressWarnings("hiding") TRBrace _rBrace_)
    {
        // Constructor
        setPublic(_public_);

        setType(_type_);

        setMethodname(_methodname_);

        setLParenthese(_lParenthese_);

        setParamlist(_paramlist_);

        setRParenthese(_rParenthese_);

        setLBrace(_lBrace_);

        setVars(_vars_);

        setStatements(_statements_);

        setReturn(_return_);

        setReturnexpression(_returnexpression_);

        setSemicolon(_semicolon_);

        setRBrace(_rBrace_);

    }

    @Override
    public Object clone()
    {
        return new AMethoddecl(
            cloneNode(this._public_),
            cloneNode(this._type_),
            cloneNode(this._methodname_),
            cloneNode(this._lParenthese_),
            cloneNode(this._paramlist_),
            cloneNode(this._rParenthese_),
            cloneNode(this._lBrace_),
            cloneList(this._vars_),
            cloneList(this._statements_),
            cloneNode(this._return_),
            cloneNode(this._returnexpression_),
            cloneNode(this._semicolon_),
            cloneNode(this._rBrace_));
    }

    public void apply(Switch sw)
    {
        ((Analysis) sw).caseAMethoddecl(this);
    }

    public TPublic getPublic()
    {
        return this._public_;
    }

    public void setPublic(TPublic node)
    {
        if(this._public_ != null)
        {
            this._public_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._public_ = node;
    }

    public PType getType()
    {
        return this._type_;
    }

    public void setType(PType node)
    {
        if(this._type_ != null)
        {
            this._type_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._type_ = node;
    }

    public TId getMethodname()
    {
        return this._methodname_;
    }

    public void setMethodname(TId node)
    {
        if(this._methodname_ != null)
        {
            this._methodname_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._methodname_ = node;
    }

    public TLParenthese getLParenthese()
    {
        return this._lParenthese_;
    }

    public void setLParenthese(TLParenthese node)
    {
        if(this._lParenthese_ != null)
        {
            this._lParenthese_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._lParenthese_ = node;
    }

    public PParamlist getParamlist()
    {
        return this._paramlist_;
    }

    public void setParamlist(PParamlist node)
    {
        if(this._paramlist_ != null)
        {
            this._paramlist_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._paramlist_ = node;
    }

    public TRParenthese getRParenthese()
    {
        return this._rParenthese_;
    }

    public void setRParenthese(TRParenthese node)
    {
        if(this._rParenthese_ != null)
        {
            this._rParenthese_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._rParenthese_ = node;
    }

    public TLBrace getLBrace()
    {
        return this._lBrace_;
    }

    public void setLBrace(TLBrace node)
    {
        if(this._lBrace_ != null)
        {
            this._lBrace_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._lBrace_ = node;
    }

    public LinkedList<PVardecl> getVars()
    {
        return this._vars_;
    }

    public void setVars(List<PVardecl> list)
    {
        this._vars_.clear();
        this._vars_.addAll(list);
        for(PVardecl e : list)
        {
            if(e.parent() != null)
            {
                e.parent().removeChild(e);
            }

            e.parent(this);
        }
    }

    public LinkedList<PStatement> getStatements()
    {
        return this._statements_;
    }

    public void setStatements(List<PStatement> list)
    {
        this._statements_.clear();
        this._statements_.addAll(list);
        for(PStatement e : list)
        {
            if(e.parent() != null)
            {
                e.parent().removeChild(e);
            }

            e.parent(this);
        }
    }

    public TReturn getReturn()
    {
        return this._return_;
    }

    public void setReturn(TReturn node)
    {
        if(this._return_ != null)
        {
            this._return_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._return_ = node;
    }

    public PExp getReturnexpression()
    {
        return this._returnexpression_;
    }

    public void setReturnexpression(PExp node)
    {
        if(this._returnexpression_ != null)
        {
            this._returnexpression_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._returnexpression_ = node;
    }

    public TSemicolon getSemicolon()
    {
        return this._semicolon_;
    }

    public void setSemicolon(TSemicolon node)
    {
        if(this._semicolon_ != null)
        {
            this._semicolon_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._semicolon_ = node;
    }

    public TRBrace getRBrace()
    {
        return this._rBrace_;
    }

    public void setRBrace(TRBrace node)
    {
        if(this._rBrace_ != null)
        {
            this._rBrace_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._rBrace_ = node;
    }

    @Override
    public String toString()
    {
        return ""
            + toString(this._public_)
            + toString(this._type_)
            + toString(this._methodname_)
            + toString(this._lParenthese_)
            + toString(this._paramlist_)
            + toString(this._rParenthese_)
            + toString(this._lBrace_)
            + toString(this._vars_)
            + toString(this._statements_)
            + toString(this._return_)
            + toString(this._returnexpression_)
            + toString(this._semicolon_)
            + toString(this._rBrace_);
    }

    @Override
    void removeChild(@SuppressWarnings("unused") Node child)
    {
        // Remove child
        if(this._public_ == child)
        {
            this._public_ = null;
            return;
        }

        if(this._type_ == child)
        {
            this._type_ = null;
            return;
        }

        if(this._methodname_ == child)
        {
            this._methodname_ = null;
            return;
        }

        if(this._lParenthese_ == child)
        {
            this._lParenthese_ = null;
            return;
        }

        if(this._paramlist_ == child)
        {
            this._paramlist_ = null;
            return;
        }

        if(this._rParenthese_ == child)
        {
            this._rParenthese_ = null;
            return;
        }

        if(this._lBrace_ == child)
        {
            this._lBrace_ = null;
            return;
        }

        if(this._vars_.remove(child))
        {
            return;
        }

        if(this._statements_.remove(child))
        {
            return;
        }

        if(this._return_ == child)
        {
            this._return_ = null;
            return;
        }

        if(this._returnexpression_ == child)
        {
            this._returnexpression_ = null;
            return;
        }

        if(this._semicolon_ == child)
        {
            this._semicolon_ = null;
            return;
        }

        if(this._rBrace_ == child)
        {
            this._rBrace_ = null;
            return;
        }

        throw new RuntimeException("Not a child.");
    }

    @Override
    void replaceChild(@SuppressWarnings("unused") Node oldChild, @SuppressWarnings("unused") Node newChild)
    {
        // Replace child
        if(this._public_ == oldChild)
        {
            setPublic((TPublic) newChild);
            return;
        }

        if(this._type_ == oldChild)
        {
            setType((PType) newChild);
            return;
        }

        if(this._methodname_ == oldChild)
        {
            setMethodname((TId) newChild);
            return;
        }

        if(this._lParenthese_ == oldChild)
        {
            setLParenthese((TLParenthese) newChild);
            return;
        }

        if(this._paramlist_ == oldChild)
        {
            setParamlist((PParamlist) newChild);
            return;
        }

        if(this._rParenthese_ == oldChild)
        {
            setRParenthese((TRParenthese) newChild);
            return;
        }

        if(this._lBrace_ == oldChild)
        {
            setLBrace((TLBrace) newChild);
            return;
        }

        for(ListIterator<PVardecl> i = this._vars_.listIterator(); i.hasNext();)
        {
            if(i.next() == oldChild)
            {
                if(newChild != null)
                {
                    i.set((PVardecl) newChild);
                    newChild.parent(this);
                    oldChild.parent(null);
                    return;
                }

                i.remove();
                oldChild.parent(null);
                return;
            }
        }

        for(ListIterator<PStatement> i = this._statements_.listIterator(); i.hasNext();)
        {
            if(i.next() == oldChild)
            {
                if(newChild != null)
                {
                    i.set((PStatement) newChild);
                    newChild.parent(this);
                    oldChild.parent(null);
                    return;
                }

                i.remove();
                oldChild.parent(null);
                return;
            }
        }

        if(this._return_ == oldChild)
        {
            setReturn((TReturn) newChild);
            return;
        }

        if(this._returnexpression_ == oldChild)
        {
            setReturnexpression((PExp) newChild);
            return;
        }

        if(this._semicolon_ == oldChild)
        {
            setSemicolon((TSemicolon) newChild);
            return;
        }

        if(this._rBrace_ == oldChild)
        {
            setRBrace((TRBrace) newChild);
            return;
        }

        throw new RuntimeException("Not a child.");
    }
}