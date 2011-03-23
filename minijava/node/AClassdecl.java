/* This file was generated by SableCC (http://www.sablecc.org/). */

package node;

import java.util.*;
import analysis.*;

@SuppressWarnings("nls")
public final class AClassdecl extends PClassdecl
{
    private TId _classname_;
    private TId _super_;
    private final LinkedList<PVardecl> _vars_ = new LinkedList<PVardecl>();
    private final LinkedList<PMethoddecl> _methods_ = new LinkedList<PMethoddecl>();

    public AClassdecl()
    {
        // Constructor
    }

    public AClassdecl(
        @SuppressWarnings("hiding") TId _classname_,
        @SuppressWarnings("hiding") TId _super_,
        @SuppressWarnings("hiding") List<PVardecl> _vars_,
        @SuppressWarnings("hiding") List<PMethoddecl> _methods_)
    {
        // Constructor
        setClassname(_classname_);

        setSuper(_super_);

        setVars(_vars_);

        setMethods(_methods_);

    }

    @Override
    public Object clone()
    {
        return new AClassdecl(
            cloneNode(this._classname_),
            cloneNode(this._super_),
            cloneList(this._vars_),
            cloneList(this._methods_));
    }

    public void apply(Switch sw)
    {
        ((Analysis) sw).caseAClassdecl(this);
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

    public TId getSuper()
    {
        return this._super_;
    }

    public void setSuper(TId node)
    {
        if(this._super_ != null)
        {
            this._super_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._super_ = node;
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

    public LinkedList<PMethoddecl> getMethods()
    {
        return this._methods_;
    }

    public void setMethods(List<PMethoddecl> list)
    {
        this._methods_.clear();
        this._methods_.addAll(list);
        for(PMethoddecl e : list)
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
            + toString(this._classname_)
            + toString(this._super_)
            + toString(this._vars_)
            + toString(this._methods_);
    }

    @Override
    void removeChild(@SuppressWarnings("unused") Node child)
    {
        // Remove child
        if(this._classname_ == child)
        {
            this._classname_ = null;
            return;
        }

        if(this._super_ == child)
        {
            this._super_ = null;
            return;
        }

        if(this._vars_.remove(child))
        {
            return;
        }

        if(this._methods_.remove(child))
        {
            return;
        }

        throw new RuntimeException("Not a child.");
    }

    @Override
    void replaceChild(@SuppressWarnings("unused") Node oldChild, @SuppressWarnings("unused") Node newChild)
    {
        // Replace child
        if(this._classname_ == oldChild)
        {
            setClassname((TId) newChild);
            return;
        }

        if(this._super_ == oldChild)
        {
            setSuper((TId) newChild);
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

        for(ListIterator<PMethoddecl> i = this._methods_.listIterator(); i.hasNext();)
        {
            if(i.next() == oldChild)
            {
                if(newChild != null)
                {
                    i.set((PMethoddecl) newChild);
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
