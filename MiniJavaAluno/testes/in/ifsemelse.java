class Factorial{
    public static void main(String[] a){
	System.out.println(new Fac().ComputeFac(10));
    }
}

class Fac {
    public int ComputeFac(int num){
	int a;
	if (num < 1)
	    a = 1;
	return num * (this.ComputeFac(num-1)) ;
    }
}
