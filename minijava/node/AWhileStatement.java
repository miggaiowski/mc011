/* This file was generated by SableCC (http://www.sablecc.org/). */

package node;

import analysis.*;

@SuppressWarnings("nls")
public final class AWhileStatement extends PStatement
{
    private TWhile _while_;
    private TLParenthese _lParenthese_;
    private PExp _exp_;
    private TRParenthese _rParenthese_;
    private PStatement _statement_;

    public AWhileStatement()
    {
        // Constructor
    }

    public AWhileStatement(
        @SuppressWarnings("hiding") TWhile _while_,
        @SuppressWarnings("hiding") TLParenthese _lParenthese_,
        @SuppressWarnings("hiding") PExp _exp_,
        @SuppressWarnings("hiding") TRParenthese _rParenthese_,
        @SuppressWarnings("hiding") PStatement _statement_)
    {
        // Constructor
        setWhile(_while_);

        setLParenthese(_lParenthese_);

        setExp(_exp_);

        setRParenthese(_rParenthese_);

        setStatement(_statement_);

    }

    @Override
    public Object clone()
    {
        return new AWhileStatement(
            cloneNode(this._while_),
            cloneNode(this._lParenthese_),
            cloneNode(this._exp_),
            cloneNode(this._rParenthese_),
            cloneNode(this._statement_));
    }

    public void apply(Switch sw)
    {
        ((Analysis) sw).caseAWhileStatement(this);
    }

    public TWhile getWhile()
    {
        return this._while_;
    }

    public void setWhile(TWhile node)
    {
        if(this._while_ != null)
        {
            this._while_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._while_ = node;
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

    public PExp getExp()
    {
        return this._exp_;
    }

    public void setExp(PExp node)
    {
        if(this._exp_ != null)
        {
            this._exp_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._exp_ = node;
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

    public PStatement getStatement()
    {
        return this._statement_;
    }

    public void setStatement(PStatement node)
    {
        if(this._statement_ != null)
        {
            this._statement_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._statement_ = node;
    }

    @Override
    public String toString()
    {
        return ""
            + toString(this._while_)
            + toString(this._lParenthese_)
            + toString(this._exp_)
            + toString(this._rParenthese_)
            + toString(this._statement_);
    }

    @Override
    void removeChild(@SuppressWarnings("unused") Node child)
    {
        // Remove child
        if(this._while_ == child)
        {
            this._while_ = null;
            return;
        }

        if(this._lParenthese_ == child)
        {
            this._lParenthese_ = null;
            return;
        }

        if(this._exp_ == child)
        {
            this._exp_ = null;
            return;
        }

        if(this._rParenthese_ == child)
        {
            this._rParenthese_ = null;
            return;
        }

        if(this._statement_ == child)
        {
            this._statement_ = null;
            return;
        }

        throw new RuntimeException("Not a child.");
    }

    @Override
    void replaceChild(@SuppressWarnings("unused") Node oldChild, @SuppressWarnings("unused") Node newChild)
    {
        // Replace child
        if(this._while_ == oldChild)
        {
            setWhile((TWhile) newChild);
            return;
        }

        if(this._lParenthese_ == oldChild)
        {
            setLParenthese((TLParenthese) newChild);
            return;
        }

        if(this._exp_ == oldChild)
        {
            setExp((PExp) newChild);
            return;
        }

        if(this._rParenthese_ == oldChild)
        {
            setRParenthese((TRParenthese) newChild);
            return;
        }

        if(this._statement_ == oldChild)
        {
            setStatement((PStatement) newChild);
            return;
        }

        throw new RuntimeException("Not a child.");
    }
}