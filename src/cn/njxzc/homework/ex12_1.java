package cn.njxzc.homework;

import java.io.*;
import java.util.Scanner;

/**
 * Created by ST001 on 2017/5/10.
 */
public class ex12_1 {
    public static void main(String[] args) throws IOException {
        File f = new File("./ex12_1.txt");   //运行前清空存储结果的txt
        FileWriter fw =  new FileWriter(f);
        fw.write("");

        System.out.println("输入字符串：");
        Scanner scanner = new Scanner(System.in);
        String str= scanner.next();
        char[] chars = str.toCharArray(); //把字符中转换为字符数组
        System.out.print("加密:");
        for (int i = 0; i < chars.length; i++) {
            BufferedWriter out = null;
            try {
                out = new BufferedWriter(new OutputStreamWriter(
                        new FileOutputStream("./ex12_1.txt", true)));    //追加写入
                out.write(((int) chars[i])*3+" ");      //每个字符的ASCII码*3后写入
                str+=((int) chars[i])*3+" ";
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                try {
                    out.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
     }

        FileReader fr = new FileReader("./ex12_1.txt");
        char [] buf2=new char[1024];
        String str2="";
        int num=0;
        while((num=fr.read(buf2))!=-1)
            str2 +=(new String (buf2,0,num));

        System.out.println("");
        System.out.println(str2);

        String[]chars2=str2.split(" ");
        System.out.print("解密：");
        for(int i=0;i<chars2.length;i++){
            int n = (int)Integer.parseInt(chars2[i])/3;     //ASCII除以3再转为对应字符
            System.out.print((char)Integer.parseInt(String.valueOf(n)));        //输出解密后的结果
        }
    }
}
