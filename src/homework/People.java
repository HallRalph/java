package homework;

/**
 * Created by ST001 on 2017/3/22.
 */
public class People {
    protected String name;
    protected int age;

    int getAge(int age){
        return age;
    }
}

class Employee extends People{
    protected int empno;
}
class Teacher extends People{
    int teacno;
    String zc;
}
