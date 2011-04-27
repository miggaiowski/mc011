/* This file was generated by SableCC (http://www.sablecc.org/). */

package minijava.node;

import minijava.analysis.*;

@SuppressWarnings("nls")
public final class AArrayAssignStatement extends PStatement
{
    private TAttr _token_;
    private TId _target_;
    private PExp _index_;
    private PExp _value_;

    public AArrayAssignStatement()
    {
        // Constructor
    }

    public AArrayAssignStatement(
        @SuppressWarnings("hiding") TAttr _token_,
        @SuppressWarnings("hiding") TId _target_,
        @SuppressWarnings("hiding") PExp _index_,
        @SuppressWarnings("hiding") PExp _value_)
    {
        // Constructor
        setToken(_token_);

        setTarget(_target_);

        setIndex(_index_);

        setValue(_value_);

    }

    @Override
    public Object clone()
    {
        return new AArrayAssignStatement(
            cloneNode(this._token_),
            cloneNode(this._target_),
            cloneNode(this._index_),
            cloneNode(this._value_));
    }

    public void apply(Switch sw)
    {
        ((Analysis) sw).caseAArrayAssignStatement(this);
    }

    public TAttr getToken()
    {
        return this._token_;
    }

    public void setToken(TAttr node)
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

    public TId getTarget()
    {
        return this._target_;
    }

    public void setTarget(TId node)
    {
        if(this._target_ != null)
        {
            this._target_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._target_ = node;
    }

    public PExp getIndex()
    {
        return this._index_;
    }

    public void setIndex(PExp node)
    {
        if(this._index_ != null)
        {
            this._index_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._index_ = node;
    }

    public PExp getValue()
    {
        return this._value_;
    }

    public void setValue(PExp node)
    {
        if(this._value_ != null)
        {
            this._value_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._value_ = node;
    }

    @Override
    public String toString()
    {
        return ""
            + toString(this._token_)
            + toString(this._target_)
            + toString(this._index_)
            + toString(this._value_);
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

        if(this._target_ == child)
        {
            this._target_ = null;
            return;
        }

        if(this._index_ == child)
        {
            this._index_ = null;
            return;
        }

        if(this._value_ == child)
        {
            this._value_ = null;
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
            setToken((TAttr) newChild);
            return;
        }

        if(this._target_ == oldChild)
        {
            setTarget((TId) newChild);
            return;
        }

        if(this._index_ == oldChild)
        {
            setIndex((PExp) newChild);
            return;
        }

        if(this._value_ == oldChild)
        {
            setValue((PExp) newChild);
            return;
        }

        throw new RuntimeException("Not a child.");
    }
}
