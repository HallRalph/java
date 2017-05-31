package cn.njxzc.homework;

import java.io.*;

/**
 * Created by dt112 on 2017/5/31.
 */
public class ex12_3 {
    public static void readTxtFile(String filePath) throws IOException {
        File file = new File(filePath);
        InputStreamReader read = new InputStreamReader(new FileInputStream(file));
        BufferedReader bufferedReader = new BufferedReader(read);
        int txt;
        txt = bufferedReader.read();

            System.out.println();
            System.out.println(txt);
        read.close();
    }

    public static void main(String[] args) throws IOException {
        readTxtFile("ex12_3.txt");
    }
}
