/* This file was generated by SableCC (http://www.sablecc.org/). */

package node;

import analysis.*;

@SuppressWarnings("nls")
public final class AMainclass extends PMainclass
{
    private TClassn _classn_;
    private TId _classname_;
    private TLBrace _lBrace_;
    private PMainmethod _mainmethod_;
    private TRBrace _rBrace_;

    public AMainclass()
    {
        // Constructor
    }

    public AMainclass(
        @SuppressWarnings("hiding") TClassn _classn_,
        @SuppressWarnings("hiding") TId _classname_,
        @SuppressWarnings("hiding") TLBrace _lBrace_,
        @SuppressWarnings("hiding") PMainmethod _mainmethod_,
        @SuppressWarnings("hiding") TRBrace _rBrace_)
    {
        // Constructor
        setClassn(_classn_);

        setClassname(_classname_);

        setLBrace(_lBrace_);

        setMainmethod(_mainmethod_);

        setRBrace(_rBrace_);

    }

    @Override
    public Object clone()
    {
        return new AMainclass(
            cloneNode(this._classn_),
            cloneNode(this._classname_),
            cloneNode(this._lBrace_),
            cloneNode(this._mainmethod_),
            cloneNode(this._rBrace_));
    }

    public void apply(Switch sw)
    {
        ((Analysis) sw).caseAMainclass(this);
    }

    public TClassn getClassn()
    {
        return this._classn_;
    }

    public void setClassn(TClassn node)
    {
        if(this._classn_ != null)
        {
            this._classn_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._classn_ = node;
    }

    public TId getClassname()
    {
        return this._classname_;
    }

    public void setClassname(TId node)
    {
        if(this._classname_ != null)
        {
            this._classname_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._classname_ = node;
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

    public PMainmethod getMainmethod()
    {
        return this._mainmethod_;
    }

    public void setMainmethod(PMainmethod node)
    {
        if(this._mainmethod_ != null)
        {
            this._mainmethod_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._mainmethod_ = node;
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
            + toString(this._classn_)
            + toString(this._classname_)
            + toString(this._lBrace_)
            + toString(this._mainmethod_)
            + toString(this._rBrace_);
    }

    @Override
    void removeChild(@SuppressWarnings("unused") Node child)
    {
        // Remove child
        if(this._classn_ == child)
        {
            this._classn_ = null;
            return;
        }

        if(this._classname_ == child)
        {
            this._classname_ = null;
            return;
        }

        if(this._lBrace_ == child)
        {
            this._lBrace_ = null;
            return;
        }

        if(this._mainmethod_ == child)
        {
            this._mainmethod_ = null;
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
        if(this._classn_ == oldChild)
        {
            setClassn((TClassn) newChild);
            return;
        }

        if(this._classname_ == oldChild)
        {
            setClassname((TId) newChild);
            return;
        }

        if(this._lBrace_ == oldChild)
        {
            setLBrace((TLBrace) newChild);
            return;
        }

        if(this._mainmethod_ == oldChild)
        {
            setMainmethod((PMainmethod) newChild);
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