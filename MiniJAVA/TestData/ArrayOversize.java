class ArrayOversize{
    public static void main(String[] a){
	System.out.println(new Fac().ComputeFac(10));
    }
}

class Fac {
    int[] a;
    int[] b;
    Fac c;

    public int ComputeFac(int num){
    int num_aux ;
    a = new int[10];

//    num_aux = a[10];
//    num_aux = b[10];
    num_aux = c.ComputeFac(10);

	if (num < 1)
	    num_aux = 1 ;
	else 
	    num_aux = num * (this.ComputeFac(num-1)) ;
	return num_aux ;
    }

}