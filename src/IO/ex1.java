import java.io.*;
import java.util.Scanner;

/**
 * Created by ST001 on 2017/5/10.
 */
public class ex1 {
    public static void main(String[] args) throws IOException {
        File f = new File("src/ex1.txt");
        FileWriter fw =  new FileWriter(f);
        fw.write("");

        System.out.println("输入字符串：");
        Scanner scanner = new Scanner(System.in);
        String str= scanner.next();
        String str2="";
        char[] chars = str.toCharArray(); //把字符中转换为字符数组
        System.out.print("加密:");
        for (int i = 0; i < chars.length; i++) {//输出结果
            BufferedWriter out = null;
            try {
                out = new BufferedWriter(new OutputStreamWriter(
                        new FileOutputStream("src/ex1.txt", true)));
                out.write(((int) chars[i])*3+" ");
                System.out.print(((int) chars[i])*3);

                str2 += String.valueOf((int) chars[i]*3)+" ";

            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                try {
                    out.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
     }System.out.println("str2:"+str2);

        //--------------------------
        System.out.println("");

        String[]chars2=str2.split(" ");
        System.out.print("解密：");
        for(int i=0;i<chars.length;i++){
            int n = (int)Integer.parseInt(chars2[i])/3;
//            System.out.println(n);
            System.out.print((char)Integer.parseInt(String.valueOf(n)));
        }
    }
}
