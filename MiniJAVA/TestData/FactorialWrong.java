class Factorial {
    public static void main(String[] a) {
        System.out.println(new Fac().ComputeFac(10));
    }
}

class FacParent {
    boolean test;
    public int ComputeFac(int num) {
        int num_aux;
        if (num < 1)
            num_aux = 1;
        else
            num_aux = num * (this.ComputeFac(num - 1));
        return num_aux;
    }
}

class Fac extends FacParent {

    public int ComputeFac(boolean num) {
        int num_aux;
        int[] num_arr;
        num_arr = new int[10];
        num_aux = num_arr.length;
        if (num && test)
            num_aux = 1;
        else
            num_aux = num_aux * (this.ComputeFac(num_aux - 1));
        return num_aux;
    }

}