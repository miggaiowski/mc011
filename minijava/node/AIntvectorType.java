/* This file was generated by SableCC (http://www.sablecc.org/). */

package node;

import analysis.*;

@SuppressWarnings("nls")
public final class AIntvectorType extends PType
{

    public AIntvectorType()
    {
        // Constructor
    }

    @Override
    public Object clone()
    {
        return new AIntvectorType();
    }

    public void apply(Switch sw)
    {
        ((Analysis) sw).caseAIntvectorType(this);
    }

    @Override
    public String toString()
    {
        return "";
    }

    @Override
    void removeChild(@SuppressWarnings("unused") Node child)
    {
        // Remove child
        throw new RuntimeException("Not a child.");
    }

    @Override
    void replaceChild(@SuppressWarnings("unused") Node oldChild, @SuppressWarnings("unused") Node newChild)
    {
        // Replace child
        throw new RuntimeException("Not a child.");
    }
}
