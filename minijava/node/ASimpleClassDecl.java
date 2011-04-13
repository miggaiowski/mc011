/* This file was generated by SableCC (http://www.sablecc.org/). */

package node;

import java.util.*;
import analysis.*;

@SuppressWarnings("nls")
public final class ASimpleClassDecl extends PClassDecl
{
    private TId _className_;
    private final LinkedList<PVarDecl> _varDecl_ = new LinkedList<PVarDecl>();
    private final LinkedList<PMethodDecl> _methodDecl_ = new LinkedList<PMethodDecl>();

    public ASimpleClassDecl()
    {
        // Constructor
    }

    public ASimpleClassDecl(
        @SuppressWarnings("hiding") TId _className_,
        @SuppressWarnings("hiding") List<PVarDecl> _varDecl_,
        @SuppressWarnings("hiding") List<PMethodDecl> _methodDecl_)
    {
        // Constructor
        setClassName(_className_);

        setVarDecl(_varDecl_);

        setMethodDecl(_methodDecl_);

    }

    @Override
    public Object clone()
    {
        return new ASimpleClassDecl(
            cloneNode(this._className_),
            cloneList(this._varDecl_),
            cloneList(this._methodDecl_));
    }

    public void apply(Switch sw)
    {
        ((Analysis) sw).caseASimpleClassDecl(this);
    }

    public TId getClassName()
    {
        return this._className_;
    }

    public void setClassName(TId node)
    {
        if(this._className_ != null)
        {
            this._className_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._className_ = node;
    }

    public LinkedList<PVarDecl> getVarDecl()
    {
        return this._varDecl_;
    }

    public void setVarDecl(List<PVarDecl> list)
    {
        this._varDecl_.clear();
        this._varDecl_.addAll(list);
        for(PVarDecl e : list)
        {
            if(e.parent() != null)
            {
                e.parent().removeChild(e);
            }

            e.parent(this);
        }
    }

    public LinkedList<PMethodDecl> getMethodDecl()
    {
        return this._methodDecl_;
    }

    public void setMethodDecl(List<PMethodDecl> list)
    {
        this._methodDecl_.clear();
        this._methodDecl_.addAll(list);
        for(PMethodDecl e : list)
        {
            if(e.parent() != null)
            {
                e.parent().removeChild(e);
            }

            e.parent(this);
        }
    }

    @Override
    public String toString()
    {
        return ""
            + toString(this._className_)
            + toString(this._varDecl_)
            + toString(this._methodDecl_);
    }

    @Override
    void removeChild(@SuppressWarnings("unused") Node child)
    {
        // Remove child
        if(this._className_ == child)
        {
            this._className_ = null;
            return;
        }

        if(this._varDecl_.remove(child))
        {
            return;
        }

        if(this._methodDecl_.remove(child))
        {
            return;
        }

        throw new RuntimeException("Not a child.");
    }

    @Override
    void replaceChild(@SuppressWarnings("unused") Node oldChild, @SuppressWarnings("unused") Node newChild)
    {
        // Replace child
        if(this._className_ == oldChild)
        {
            setClassName((TId) newChild);
            return;
        }

        for(ListIterator<PVarDecl> i = this._varDecl_.listIterator(); i.hasNext();)
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

        for(ListIterator<PMethodDecl> i = this._methodDecl_.listIterator(); i.hasNext();)
        {
            if(i.next() == oldChild)
            {
                if(newChild != null)
                {
                    i.set((PMethodDecl) newChild);
                    newChild.parent(this);
                    oldChild.parent(null);
                    return;
                }

                i.remove();
                oldChild.parent(null);
                return;
            }
        }

        throw new RuntimeException("Not a child.");
    }
}
