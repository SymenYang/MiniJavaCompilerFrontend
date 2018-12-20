class ReloadTest{
    public static void main(String[] a){
        System.out.println(new printer().print());
    }
}

class printer {
    public int print(){
        System.out.println(new Son1().test(10));
        System.out.println(new Son1().test());
        System.out.println(new Son2().test(10));
        System.out.println(new Son2().test());
        System.out.println(new Father().test(10));
        System.out.println(new Father().test());
        return 0;
    }
}

class Father {
    public int test(){
        return 666;
    }

    public int test(int a){
        return 666 + a;
    }
}

class Son1 extends Father {
    public int test(){
        return 777;
    }

    public int test(int a){
        return 777 + a;
    }
}

class Son2 extends Father {
    public int test(int a) {
        return 888 + a;
    }
}