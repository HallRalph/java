import java.util.Scanner;

public class pj1 {
    public static void main(String[] args) {
        int min, max, avg, sum = 0;     //初始化
        System.out.print("输入数组元素个数：");  //元素个数
        Scanner in=new Scanner(System.in);
        int n = in.nextInt();
        int[] arr = new int[n];
        System.out.print("输入每个元素：");    //添加元素
        for(int i=0;i<arr.length;i++){
            arr[i] = in.nextInt();
        }

        min = max = arr[0];     //默认arr[0]
        for (int i = 0; i < arr.length; i++) {  //比大小
            if (arr[i] < min)
                min = arr[i];
            if (arr[i] > max)
                max = arr[i];
            sum += arr[i];
        }
        avg = sum / (arr.length);   //平均值

        System.out.println("min:" + min + ",max:" + max + ",avg:" + avg + ",sum:" + sum);
    }
}