package grammar;
public class OpExp extends Exp {
    public Exp left, right; public int oper;
    final public static int Plus=1, Minus=2, Times=3, Div=4;
    public OpExp(Exp l, int o, Exp r) {left=l; oper=o; right=r;}		
}
	
public class EseqExp extends Exp {
    public Stm stm; public Exp exp;
    public EseqExp(Stm s, Exp e) {stm=s; exp=e;}
}