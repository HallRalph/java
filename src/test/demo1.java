package test;

/**
 * dt112 on 2017/3/6.
 */
public class demo1 {
    public static void main(String[] args){
        int age = 130;
        checkAge(age);

        int a=10;
        test1(a);
        System.out.println(a);
    }


    public static void test1(int a) {
        a = 20;
    }

        public static void checkAge(int age){
        if (age<0){
            System.out.println("不能小于0");
            return;
        }
        if (age>120){
            System.out.println("不能大于120");
            return;
        }
        System.out.println("合法");
    }
}
