class ClassCycle{
    public static void main(String[] a){
        System.out.println(new testClass().ComputeFac(10));
    }
}

class ClassA {
    public int ComputeFac(int num){
        return num;
    }
}

class ClassB extends ClassA {
    public boolean ComputeFac(boolean num){
        return num;
    }
}

class testClass {
    ClassA a;
    ClassB b;

    public int ComputeFac(int num){
        b = new ClassB();
        a = b;
        //b = a;
        return num;
    }
}
