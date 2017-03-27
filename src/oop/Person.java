package oop;

/**
 * * datou on 2017/2/25.
 */
public class Person {
    private String name = "未知";
    private char sex = '男';
    private int age = -1;

    public void showInfo(){
        System.out.println(name+"  "+sex+"  "+age);
    }

    public boolean checkName(String n){
        if(n==null){
            return false;
        }
        if(n.length()>2 && n.length()<8){
            return true;
        }
        return false;
    }

    //  允许方法的参数或临时变量与属性同名但就近原则适用，
    //  方法中如果有重名的变量，使用属性时需要this.
    public void setName(String name) {
        if(!checkName(name)){
            System.err.println("姓名不合法");
            return;
        }
        this.name=name;
    }
    public String getName()    {
        return this.name;
    }


    public void setSex(char sex){
        if(sex != '男' && sex!= '女') {
            System.err.println("性别不合法");
            return;
        }
        this.sex = sex;
    }
    public char getSex(){
        return sex;
    }

    public void setAge(int age){
        if(age<1||age>150){
            System.err.println("年龄不合法");
            return;
        }
        this.age=age;
    }
    public int getAge(){return age;}
}
