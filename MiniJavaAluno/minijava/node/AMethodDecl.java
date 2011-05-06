/* This file was generated by SableCC (http://www.sablecc.org/). */

package minijava.node;

import java.util.*;
import minijava.analysis.*;

@SuppressWarnings("nls")
public final class AMethodDecl extends PMethodDecl
{
    private PType _returnType_;
    private TId _name_;
    private final LinkedList<PFormal> _formals_ = new LinkedList<PFormal>();
    private final LinkedList<PVarDecl> _locals_ = new LinkedList<PVarDecl>();
    private final LinkedList<PStatement> _body_ = new LinkedList<PStatement>();
    private PExp _returnExp_;

    public AMethodDecl()
    {
        // Constructor
    }

    public AMethodDecl(
        @SuppressWarnings("hiding") PType _returnType_,
        @SuppressWarnings("hiding") TId _name_,
        @SuppressWarnings("hiding") List<PFormal> _formals_,
        @SuppressWarnings("hiding") List<PVarDecl> _locals_,
        @SuppressWarnings("hiding") List<PStatement> _body_,
        @SuppressWarnings("hiding") PExp _returnExp_)
    {
        // Constructor
        setReturnType(_returnType_);

        setName(_name_);

        setFormals(_formals_);

        setLocals(_locals_);

        setBody(_body_);

        setReturnExp(_returnExp_);

    }

    @Override
    public Object clone()
    {
        return new AMethodDecl(
            cloneNode(this._returnType_),
            cloneNode(this._name_),
            cloneList(this._formals_),
            cloneList(this._locals_),
            cloneList(this._body_),
            cloneNode(this._returnExp_));
    }

    public void apply(Switch sw)
    {
        ((Analysis) sw).caseAMethodDecl(this);
    }

    public PType getReturnType()
    {
        return this._returnType_;
    }

    public void setReturnType(PType node)
    {
        if(this._returnType_ != null)
        {
            this._returnType_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._returnType_ = node;
    }

    public TId getName()
    {
        return this._name_;
    }

    public void setName(TId node)
    {
        if(this._name_ != null)
        {
            this._name_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._name_ = node;
    }

    public LinkedList<PFormal> getFormals()
    {
        return this._formals_;
    }

    public void setFormals(List<PFormal> list)
    {
        this._formals_.clear();
        this._formals_.addAll(list);
        for(PFormal e : list)
        {
            if(e.parent() != null)
            {
                e.parent().removeChild(e);
            }

            e.parent(this);
        }
    }

    public LinkedList<PVarDecl> getLocals()
    {
        return this._locals_;
    }

    public void setLocals(List<PVarDecl> list)
    {
        this._locals_.clear();
        this._locals_.addAll(list);
        for(PVarDecl e : list)
        {
            if(e.parent() != null)
            {
                e.parent().removeChild(e);
            }

            e.parent(this);
        }
    }

    public LinkedList<PStatement> getBody()
    {
        return this._body_;
    }

    public void setBody(List<PStatement> list)
    {
        this._body_.clear();
        this._body_.addAll(list);
        for(PStatement e : list)
        {
            if(e.parent() != null)
            {
                e.parent().removeChild(e);
            }

            e.parent(this);
        }
    }

    public PExp getReturnExp()
    {
        return this._returnExp_;
    }

    public void setReturnExp(PExp node)
    {
        if(this._returnExp_ != null)
        {
            this._returnExp_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._returnExp_ = node;
    }

    @Override
    public String toString()
    {
        return ""
            + toString(this._returnType_)
            + toString(this._name_)
            + toString(this._formals_)
            + toString(this._locals_)
            + toString(this._body_)
            + toString(this._returnExp_);
    }

    @Override
    void removeChild(@SuppressWarnings("unused") Node child)
    {
        // Remove child
        if(this._returnType_ == child)
        {
            this._returnType_ = null;
            return;
        }

        if(this._name_ == child)
        {
            this._name_ = null;
            return;
        }

        if(this._formals_.remove(child))
        {
            return;
        }

        if(this._locals_.remove(child))
        {
            return;
        }

        if(this._body_.remove(child))
        {
            return;
        }

        if(this._returnExp_ == child)
        {
            this._returnExp_ = null;
            return;
        }

        throw new RuntimeException("Not a child.");
    }

    @Override
    void replaceChild(@SuppressWarnings("unused") Node oldChild, @SuppressWarnings("unused") Node newChild)
    {
        // Replace child
        if(this._returnType_ == oldChild)
        {
            setReturnType((PType) newChild);
            return;
        }

        if(this._name_ == oldChild)
        {
            setName((TId) newChild);
            return;
        }

        for(ListIterator<PFormal> i = this._formals_.listIterator(); i.hasNext();)
        {
            if(i.next() == oldChild)
            {
                if(newChild != null)
                {
                    i.set((PFormal) newChild);
                    newChild.parent(this);
                    oldChild.parent(null);
                    return;
                }

                i.remove();
                oldChild.parent(null);
                return;
            }
        }

        for(ListIterator<PVarDecl> i = this._locals_.listIterator(); i.hasNext();)
        {
            if(i.next() == oldChild)
            {
                if(newChild != null)
                {
                    i.set((PVarDecl) newChild);
                    newChild.parent(this);
                    oldChild.parent(null);
                    return;
                }

                i.remove();
                oldChild.parent(null);
                return;
            }
        }

        for(ListIterator<PStatement> i = this._body_.listIterator(); i.hasNext();)
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

        if(this._returnExp_ == oldChild)
        {
            setReturnExp((PExp) newChild);
            return;
        }

        throw new RuntimeException("Not a child.");
    }
}
