package study;

/**
 * * datou on 2017/4/2.
 */
interface Inter{
    public static final int NUM=3;
    public abstract void show();
}

abstract class Test implements Inter{

}

class InterfaceDemo{
    public static void main(String[] args) {
        System.out.println("HELLO");
    }
}
