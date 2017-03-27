package homework;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


/**
 * dt112 on 2017/3/8.
 */
public class ex3_3 {
    public static void main(String[] args) throws ParseException {
        int year,month,day;

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        System.out.println("按yyyy-MM-dd格式输入日期：");
        Scanner in = new Scanner(System.in);
        String line = in.nextLine();
        //System.out.println(line);

        String pattern = "[0-9]{4}-[0-9]{2}-[0-9]{2}";
        Pattern r = Pattern.compile(pattern);
        Matcher m = r.matcher(line);

        if(m.matches()){
            year = Integer.parseInt(line.substring(0,4));
            //System.out.println(year);
            month = Integer.parseInt(line.substring(5,7));
            //System.out.println(month);
            day = Integer.parseInt(line.substring(8,10));
            //System.out.println(day);
        }else{
            System.err.println("输入错误，按规定格式输入");
            return;
        }




        if(year>0 && month > 0 && month < 13 && day >0 && day < 32){
            if((year%4==0&&year%100!=0)||(year%400==0)&&day<30)
            {
                Date d = sdf.parse(line);
                Calendar calendar = new GregorianCalendar();
                calendar.setTime(d);
                calendar.add(calendar.DATE, 1);  //日期+1天
                d = calendar.getTime(); //获取+1天的结果
                String dateString = sdf.format(d);
                System.out.println(dateString);
                //System.out.println(d.getTime()/1000);

            }else{
                System.err.println("输入错误");
                return;
            }
        }
        else {
            System.err.println("输入错误");
            return;
        }
    }
}

