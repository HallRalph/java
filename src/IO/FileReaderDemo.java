package IO;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * dt112 on 2017/5/10.
 */
public class FileReaderDemo {
    public static void main(String[] args) throws IOException {
        FileReader fr = new FileReader("src/IO/a.txt");

        /*
        int ch=0;
        while ((ch=fr.read())!=-1){
            System.out.println("ch="+(char)ch);
        }
        */

        //通过字符数组进行读取
        //定义一个字符数组，用于存储读到的字符
        //该read(char[])返回的是读到字符的个数
        char [] buf=new char[1024];
        int num=0;
        while((num=fr.read(buf))!=-1)
            System.out.println(num+new String (buf,0,num));
        fr.close();
    }
}
