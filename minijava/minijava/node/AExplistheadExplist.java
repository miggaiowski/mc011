/* This file was generated by SableCC (http://www.sablecc.org/). */

package node;

import java.util.*;
import analysis.*;

@SuppressWarnings("nls")
public final class AExplistheadExplist extends PExplist
{
    private PExp _exp_;
    private final LinkedList<PExprest> _exprest_ = new LinkedList<PExprest>();

    public AExplistheadExplist()
    {
        // Constructor
    }

    public AExplistheadExplist(
        @SuppressWarnings("hiding") PExp _exp_,
        @SuppressWarnings("hiding") List<PExprest> _exprest_)
    {
        // Constructor
        setExp(_exp_);

        setExprest(_exprest_);

    }

    @Override
    public Object clone()
    {
        return new AExplistheadExplist(
            cloneNode(this._exp_),
            cloneList(this._exprest_));
    }

    public void apply(Switch sw)
    {
        ((Analysis) sw).caseAExplistheadExplist(this);
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

    public LinkedList<PExprest> getExprest()
    {
        return this._exprest_;
    }

    public void setExprest(List<PExprest> list)
    {
        this._exprest_.clear();
        this._exprest_.addAll(list);
        for(PExprest e : list)
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
            + toString(this._exp_)
            + toString(this._exprest_);
    }

    @Override
    void removeChild(@SuppressWarnings("unused") Node child)
    {
        // Remove child
        if(this._exp_ == child)
        {
            this._exp_ = null;
            return;
        }

        if(this._exprest_.remove(child))
        {
            return;
        }

        throw new RuntimeException("Not a child.");
    }

    @Override
    void replaceChild(@SuppressWarnings("unused") Node oldChild, @SuppressWarnings("unused") Node newChild)
    {
        // Replace child
        if(this._exp_ == oldChild)
        {
            setExp((PExp) newChild);
            return;
        }

        for(ListIterator<PExprest> i = this._exprest_.listIterator(); i.hasNext();)
        {
            if(i.next() == oldChild)
            {
                if(newChild != null)
                {
                    i.set((PExprest) newChild);
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