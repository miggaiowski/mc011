/* This file was generated by SableCC (http://www.sablecc.org/). */

package node;

import java.util.*;
import analysis.*;

@SuppressWarnings("nls")
public final class ABlockStatement extends PStatement
{
    private final LinkedList<PStatement> _statementlist_ = new LinkedList<PStatement>();

    public ABlockStatement()
    {
        // Constructor
    }

    public ABlockStatement(
        @SuppressWarnings("hiding") List<PStatement> _statementlist_)
    {
        // Constructor
        setStatementlist(_statementlist_);

    }

    @Override
    public Object clone()
    {
        return new ABlockStatement(
            cloneList(this._statementlist_));
    }

    public void apply(Switch sw)
    {
        ((Analysis) sw).caseABlockStatement(this);
    }

    public LinkedList<PStatement> getStatementlist()
    {
        return this._statementlist_;
    }

    public void setStatementlist(List<PStatement> list)
    {
        this._statementlist_.clear();
        this._statementlist_.addAll(list);
        for(PStatement e : list)
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
            + toString(this._statementlist_);
    }

    @Override
    void removeChild(@SuppressWarnings("unused") Node child)
    {
        // Remove child
        if(this._statementlist_.remove(child))
        {
            return;
        }

        throw new RuntimeException("Not a child.");
    }

    @Override
    void replaceChild(@SuppressWarnings("unused") Node oldChild, @SuppressWarnings("unused") Node newChild)
    {
        // Replace child
        for(ListIterator<PStatement> i = this._statementlist_.listIterator(); i.hasNext();)
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

        throw new RuntimeException("Not a child.");
    }
}
