package IO;


public class test {
    public static void main(String[] args) {
 /*       String s = "新年快乐！";//字符串

        char[] chars = s.toCharArray(); //把字符中转换为字符数组

        for (int i = 0; i < chars.length; i++) {//输出结果

            System.out.print((int) chars[i]+" ");
        }
*/
        System.out.println("////////////////////");

        String s2="39134 21834";//ASCII码

        String[] chars2=s2.split(" ");
        System.out.println("ASCII 汉字 \n----------------------");
        for(int i=0;i<chars2.length;i++){
            System.out.println(chars2[i]+" "+(char)Integer.parseInt(chars2[i]));
        }
    }
}