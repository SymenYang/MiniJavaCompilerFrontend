class ClassTest{
    public static void main(String[] a){
        System.out.println(new Test().test());
        }
}

class Data {
    int a;

    public int init(){
        a = 100;
        return 0;
    }

    public int change(){
        a = 999;
        System.out.println(a);
        return 0;
    }

    public int print(){
        System.out.println(a);
        return 0;
    }
}

class Test {
    public int test(){
        Data data;
        int a;
        int b;
        
        data = new Data();
        a = data.init();
        b = 0;

        a = this.test2(data,b);
        a = data.print();
        System.out.println(b);
        return 0;
    }

    public int test2(Data d,int b){
        int a;
        a = d.change();
        b = 1000;
        System.out.println(b);
        return 0;
    }
}