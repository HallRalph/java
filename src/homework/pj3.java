import java.util.Scanner;

public class pj3 {
    public static void main(String[] args) {
        int i, n,start,end;
        Scanner in = new Scanner(System.in);
        System.out.println("输入开始数");
        start = in.nextInt();
        System.out.println("输入结束数");
        end = in.nextInt();
        if(start<=end){
            for (n = start; n <= end; n++) {     //3~100的所有数
                i = 2;
                while (i < n) {
                    if (n % i == 0) break;  //若能整除说明n不是素数，跳出当前循环
                    i++;
                }

                if (i == n)     //如果i==n则说明n不能被2~n-1整除，是素数
                    System.out.print(i+"\t");
            }
        }else {
            System.err.println("输入错误，重新输入");
        }
    }
}