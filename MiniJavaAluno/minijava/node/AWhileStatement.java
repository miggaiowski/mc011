/* This file was generated by SableCC (http://www.sablecc.org/). */

package minijava.node;

import minijava.analysis.*;

@SuppressWarnings("nls")
public final class AWhileStatement extends PStatement
{
    private TWhile _token_;
    private PExp _condition_;
    private PStatement _body_;

    public AWhileStatement()
    {
        // Constructor
    }

    public AWhileStatement(
        @SuppressWarnings("hiding") TWhile _token_,
        @SuppressWarnings("hiding") PExp _condition_,
        @SuppressWarnings("hiding") PStatement _body_)
    {
        // Constructor
        setToken(_token_);

        setCondition(_condition_);

        setBody(_body_);

    }

    @Override
    public Object clone()
    {
        return new AWhileStatement(
            cloneNode(this._token_),
            cloneNode(this._condition_),
            cloneNode(this._body_));
    }

    public void apply(Switch sw)
    {
        ((Analysis) sw).caseAWhileStatement(this);
    }

    public TWhile getToken()
    {
        return this._token_;
    }

    public void setToken(TWhile node)
    {
        if(this._token_ != null)
        {
            this._token_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._token_ = node;
    }

    public PExp getCondition()
    {
        return this._condition_;
    }

    public void setCondition(PExp node)
    {
        if(this._condition_ != null)
        {
            this._condition_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._condition_ = node;
    }

    public PStatement getBody()
    {
        return this._body_;
    }

    public void setBody(PStatement node)
    {
        if(this._body_ != null)
        {
            this._body_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._body_ = node;
    }

    @Override
    public String toString()
    {
        return ""
            + toString(this._token_)
            + toString(this._condition_)
            + toString(this._body_);
    }

    @Override
    void removeChild(@SuppressWarnings("unused") Node child)
    {
        // Remove child
        if(this._token_ == child)
        {
            this._token_ = null;
            return;
        }

        if(this._condition_ == child)
        {
            this._condition_ = null;
            return;
        }

        if(this._body_ == child)
        {
            this._body_ = null;
            return;
        }

        throw new RuntimeException("Not a child.");
    }

    @Override
    void replaceChild(@SuppressWarnings("unused") Node oldChild, @SuppressWarnings("unused") Node newChild)
    {
        // Replace child
        if(this._token_ == oldChild)
        {
            setToken((TWhile) newChild);
            return;
        }

        if(this._condition_ == oldChild)
        {
            setCondition((PExp) newChild);
            return;
        }

        if(this._body_ == oldChild)
        {
            setBody((PStatement) newChild);
            return;
        }

        throw new RuntimeException("Not a child.");
    }
}
