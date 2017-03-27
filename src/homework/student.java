package homework;

import java.util.Scanner;

/**
 * Created by ST001 on 2017/3/22.
 */
public class student
{
    String username;
    String name;
    String sex;
    String birth;

    void init(String username, String name, String sex, String birth)
    {
        this.username = username;
        this.name = name;
        this.sex = sex;
        this.birth = birth;
    }

    void display() {
        System.out.println("用户名：" + username + "，姓名：" + name + "，性别：" + sex + "，出生日期：" + birth);
    }
    void modify(String username)
    {
        this.name=username;
        display();
    }

    public static void main(String[] args) {
        student stu = new student();
        stu.init("这是用户名","这是姓名","男","2015-5-5");
        stu.display();

        System.out.println("输入1执行修改姓名");
        Scanner in = new Scanner(System.in);
        int x=in.nextInt();

        if(x==1){
            stu.modify("新的姓名");
        }

        Granduate gra= new Granduate();
        gra.setSubject("语文");
        gra.setAdviser("导师");
        System.out.println(gra.getAdviser()+","+gra.getSubject());
    }
}

class Granduate extends student{
    String subject;
    String adviser;

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getAdviser() {
        return adviser;
    }

    public void setAdviser(String adviser) {
        this.adviser = adviser;
    }
}