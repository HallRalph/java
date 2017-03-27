import java.text.DecimalFormat;
import java.util.Scanner;

public class pj2 {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        double n = in.nextDouble();     //输入一个double型数
        System.out.println((int)n);     //输出整数部分
        if(n<1 && n>0){
            System.out.println(n);      //0.几的数
        }else {
            DecimalFormat df = new DecimalFormat( "0.0000 ");   //精确到小数点后4位
            //System.out.println(df.format(b));
            double b = n % (int)n;      //输出小数部分
            System.out.println(df.format(b));   //按格式化输出
        }
    }
}