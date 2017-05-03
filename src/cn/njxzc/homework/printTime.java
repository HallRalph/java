package cn.njxzc.homework;

/**
 * dt112 on 2017/5/3.
 */
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

class printTime1 extends Thread {
    private String name;
    public printTime1(String name) {
        this.name=name;
    }

    public void run() {
        for (int i = 0; i < 20; i++) {
            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
            System.out.println(name+":"+df.format(new Date()));// new Date()为获取当前系统时间

            try {
                sleep((int) (Math.random()*3000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

public class printTime {
    public static void main(String[] args) {
        printTime1 mTh1=new printTime1("T1");
        printTime1 mTh2=new printTime1("T2");
        mTh1.start();
        mTh2.start();
    }
}
