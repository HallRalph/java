package homework;

/**
 * * datou on 2017/3/2.
 */
public class a9 {
    public static void main(String[] args) {
        int [][] arr=new int[9][9];     //9*9数组
        int i,j;
        for(i=0;i<9;i++)    //第1行，第1列
        {
            arr[i][0]=i+1;
            arr[0][i]=i+1;
        }

        for(i=1;i<9;i++){   //剩余行列
            for(j=1;j<9;j++){
                if(i+1==j)
                    break;
                arr[i][j]=(i+1)*(j+1);      //积
            }
        }



        for(i=0;i<9;i++){
            if(i==1)    //第1行下面输出----------------
                System.out.println("--------------------------------------");
            for(j=0;j<9;j++){
                if(j==1)    //第1列右边输出一个|
                    System.out.print("|\t");    //不换行输出
                if(arr[i][j]==0)    //超出部分不输出
                    break;
                System.out.print(arr[i][j]+"\t");       //输出值和空格
            }
            System.out.println("");     // 一行9个，然后换行输出
        }
    }
}
