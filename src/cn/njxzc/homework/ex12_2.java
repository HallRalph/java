package cn.njxzc.homework;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import static java.lang.System.exit;

/**
 * Created by dt112 on 2017/5/31.
 */
public class ex12_2 {
    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);
        String name="";
        while (!name.equals("done"))
        {
            System.out.print("姓名：");
            name=in.next();
            if(name.equals("done")){
                exit(0);
            }
            System.out.print("密码：");

        String pwd=in.next();

        File file = new File("ex12_1.txt");
        if(!file.exists()) {
            file.createNewFile();
        }

        FileWriter fileWriter = new FileWriter(file.getName(),true);
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
        bufferedWriter.write("姓名："+name+"，密码："+pwd+"\r\n");
        bufferedWriter.close();
        }


    }
}
