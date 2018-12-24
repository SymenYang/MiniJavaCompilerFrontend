class ClassLongExtend{
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
        System.out.println(new Son3().test(10));
        System.out.println(new Son3().test());
        System.out.println(new Father().test(10));
        System.out.println(new Father().test());
        System.out.println(new Father().devilTest(new Father()));
        System.out.println(new Son1().devilTest(new Son1()));
        System.out.println(new Son1().devilTest(new Father()));
        System.out.println(new Father().moreDevilTest(new Father(),new Son1()));
        System.out.println(new Son1().moreDevilTest(new Son1(), new Father()));
        //System.out.println(new Son1().moreDevilTest(new Father(),new Father()));
        //System.out.println(new Son1().moreDevilTest(new Son1(),new Son1()));

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

    public int devilTest(Father a){
        return 10;
    }

    public int moreDevilTest(Father a,Son1 b){
        return 100;
    }
}

class Son1 extends Father {
    public int test(){
        return 777;
    }

    public int test(int a){
        return 777 + a;
    }

    public int devilTest(Son1 a){
        return 11;
    }

    public int moreDevilTest(Son1 a,Father b){
        return 101;
    }
}

class Son2 extends Father {
    public int test(int a) {
        return 888 + a;
    }
}

class Son3 extends Son1 {
    public int test(){
        return 999;
    }
}