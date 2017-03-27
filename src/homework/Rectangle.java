package homework;

/**
 * Created by ST001 on 2017/3/22.
 */
public class Rectangle {
    public static void main(String[] args) {
        double width=10.0;
        double height=4.0;
        System.out.println("长："+width+"，宽"+height+"，周长："+L(width,height)+"，面积："+S(width,height));
    }

    static double S(double width, double height) {
        return width*height;
    }

    static double L(double width, double height) {
        return (width+height)*2;
    }
}