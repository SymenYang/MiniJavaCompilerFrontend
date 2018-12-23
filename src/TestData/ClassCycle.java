class ClassCycle{
    public static void main(String[] a){
        System.out.println(new ClassA().ComputeFac(10));
    }
}

class ClassA extends ClassC {
    public int ComputeFac(int num){
        return num;
    }
}

class ClassB extends ClassA {
    public int ComputeFac(int num){
        return num;
    }
}

class ClassC extends ClassB {
    public int ComputeFac(int num){
        return num;
    }
}