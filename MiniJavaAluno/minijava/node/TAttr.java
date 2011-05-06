/* This file was generated by SableCC (http://www.sablecc.org/). */

package minijava.node;

import minijava.analysis.*;

@SuppressWarnings("nls")
public final class TAttr extends Token
{
    public TAttr()
    {
        super.setText("=");
    }

    public TAttr(int line, int pos)
    {
        super.setText("=");
        setLine(line);
        setPos(pos);
    }

    @Override
    public Object clone()
    {
      return new TAttr(getLine(), getPos());
    }

    public void apply(Switch sw)
    {
        ((Analysis) sw).caseTAttr(this);
    }

    @Override
    public void setText(@SuppressWarnings("unused") String text)
    {
        throw new RuntimeException("Cannot change TAttr text.");
    }
}
