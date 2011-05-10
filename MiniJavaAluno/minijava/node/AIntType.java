/* This file was generated by SableCC (http://www.sablecc.org/). */

package minijava.node;

import minijava.analysis.Analysis;

@SuppressWarnings("nls")
public final class AIntType extends PType
{
    private TInt _token_;

    public AIntType()
    {
        // Constructor
    }

    public AIntType(
        @SuppressWarnings("hiding") TInt _token_)
    {
        // Constructor
        setToken(_token_);

    }

    @Override
    public Object clone()
    {
        return new AIntType(
            cloneNode(this._token_));
    }

    public void apply(Switch sw)
    {
        ((Analysis) sw).caseAIntType(this);
    }

    public TInt getToken()
    {
        return this._token_;
    }

    public void setToken(TInt node)
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

    @Override
    public String toString()
    {
        return ""
            + toString(this._token_);
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

        throw new RuntimeException("Not a child.");
    }

    @Override
    void replaceChild(@SuppressWarnings("unused") Node oldChild, @SuppressWarnings("unused") Node newChild)
    {
        // Replace child
        if(this._token_ == oldChild)
        {
            setToken((TInt) newChild);
            return;
        }

        throw new RuntimeException("Not a child.");
    }
}
