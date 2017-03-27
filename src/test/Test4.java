/*public class Test4 {
    public static void main(String[] args){
        //实例化
        Person datou=new Person();
        datou.pid=1;
        datou.name="datou";
        datou.age=21;
        datou.display();

        Person DT=new Person();
        DT.pid=2;
        DT.name="DT";
        DT.age=22;
        DT.display();

        Person abc=new Person();
        abc.pid=3;
        abc.name="abc";
        abc.age=17;
        abc.display();

    }
}

class CPU{

}
class ROM{

}
class PC{
    CPU cpu;
    ROM rom;
}

class Person{
    // 属性
    public int pid;
    public String name;
    public int age;
    // 构造方法
    Person(){

    }
    // 方法
    void display(){
        String msg=pid+","+name+","+age;
        System.out.println(msg);
    }

    /*void buy（Car car){

    }*//*
}
*/