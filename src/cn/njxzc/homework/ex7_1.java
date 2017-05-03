package cn.njxzc.homework;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ST001 on 2017/4/19.
 */
public class ex7_1 {
    public static void main(String[] args) {
        List<Integer> a = new ArrayList<Integer>();
        for(int i=1;i<=50;i++)
            a.add(i);

        a.remove(10);

        for(int t:a)
            System.out.println(t+ " ");
    }
}
