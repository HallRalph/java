package cn.njxzc.homework;

import java.net.Socket;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by ST001 on 2017/4/19.
 */
public class ex7_2 {
    public static void main(String[] args) {

        Set set=new HashSet();

        set.add("to");
        set.add("be");
        set.add("or");
        set.add("not");
        set.add("to");
        set.add("be");

        int size=set.size();

        System.out.println("Set集合的大小为：" + size);
    }
}
