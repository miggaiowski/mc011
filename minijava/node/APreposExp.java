/* This file was generated by SableCC (http://www.sablecc.org/). */

package node;

import java.util.*;
import analysis.*;

@SuppressWarnings("nls")
public final class APreposExp extends PExp
{
    private PExp _prefix_;
    private final LinkedList<PExp> _posfixs_ = new LinkedList<PExp>();

    public APreposExp()
    {
        // Constructor
    }

    public APreposExp(
        @SuppressWarnings("hiding") PExp _prefix_,
        @SuppressWarnings("hiding") List<PExp> _posfixs_)
    {
        // Constructor
        setPrefix(_prefix_);

        setPosfixs(_posfixs_);

    }

    @Override
    public Object clone()
    {
        return new APreposExp(
            cloneNode(this._prefix_),
            cloneList(this._posfixs_));
    }

    public void apply(Switch sw)
    {
        ((Analysis) sw).caseAPreposExp(this);
    }

    public PExp getPrefix()
    {
        return this._prefix_;
    }

    public void setPrefix(PExp node)
    {
        if(this._prefix_ != null)
        {
            this._prefix_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._prefix_ = node;
    }

    public LinkedList<PExp> getPosfixs()
    {
        return this._posfixs_;
    }

    public void setPosfixs(List<PExp> list)
    {
        this._posfixs_.clear();
        this._posfixs_.addAll(list);
        for(PExp e : list)
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
            + toString(this._prefix_)
            + toString(this._posfixs_);
    }

    @Override
    void removeChild(@SuppressWarnings("unused") Node child)
    {
        // Remove child
        if(this._prefix_ == child)
        {
            this._prefix_ = null;
            return;
        }

        if(this._posfixs_.remove(child))
        {
            return;
        }

        throw new RuntimeException("Not a child.");
    }

    @Override
    void replaceChild(@SuppressWarnings("unused") Node oldChild, @SuppressWarnings("unused") Node newChild)
    {
        // Replace child
        if(this._prefix_ == oldChild)
        {
            setPrefix((PExp) newChild);
            return;
        }

        for(ListIterator<PExp> i = this._posfixs_.listIterator(); i.hasNext();)
        {
            if(i.next() == oldChild)
            {
                if(newChild != null)
                {
                    i.set((PExp) newChild);
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