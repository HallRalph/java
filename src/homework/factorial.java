package homework;

import java.util.Scanner;

/**
 * dt112 on 2017/3/6.
 */
public class factorial {
    public static void main(String[] args) {
        double i,n=1,sum=0,end;
        Scanner in = new Scanner(System.in);
        end = in.nextInt();
        for(i=1;i<=end;i++)
        {
            n=n*i;
            sum=sum+1/n;
        }
        System.out.println(sum);
    }
}
