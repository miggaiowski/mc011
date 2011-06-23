// // classes com mesmo nome
// class m
// {
//     public static void main(String[] args)
//     {
// 	System.out.println(new a().bla());
//     }
// }

// class a {
//     public int bla() {
// 	int i;
// 	i = 2 + 5;
// 	i = 2 * 5;
// 	return i;
//     }
// }

class Factorial{
    public static void main(String[] a){
	System.out.println(new Fac().ComputeFac(10));
    }
}

class Fac {
    public int ComputeFac(int num){
	int num_aux ;
	if (num < 1)
	    num_aux = 1 ;
	// comentario
	else 
	    num_aux = num * (this.ComputeFac(num-1)) ;
	return num_aux ;
    }

}

// class Factorial{
//     public static void main(String[] a){
// 	{
// 	    System.out.println(544);
// 	    System.out.println(new Fac().ComputeFac(3));
// 	}
//     }
// }

// class Fac {
//     public int ComputeFac(int num){
// 	int num_aux;
// 	if (num < 6)
// 	    num_aux = num;
// 	else {
// 	    num_aux = 7;
// 	}
// 	return 3 * num_aux;
//     }

// }
