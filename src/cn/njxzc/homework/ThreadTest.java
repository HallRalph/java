package cn.njxzc.homework;

class Thread1 extends Thread{
    private String name;
    public Thread1(String name) {
        this.name=name;
    }

    public void run() {

        int n=1,sum=0;
        for (int i = 1; i < 21; i++) {
            n=n*i;
            sum=sum+n;
            //if(super.getName().equals("Thread-1"))
            System.out.println(name + "结果:" + sum);

            try {
                if(super.getName().equals("Thread-1"))
                    sleep(2000);
                else
                    sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

public class ThreadTest {
    public static void main(String[] args) {
        Thread1 mTh1=new Thread1("A");
        Thread1 mTh2=new Thread1("B");
        mTh1.start();
        mTh2.start();
    }
}