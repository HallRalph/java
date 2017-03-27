package test;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * * datou on 2017/2/24.
 */
public class DVD {
    //属性
    int id;
    String name;
    String type;
    boolean status;
    Date lendTime;
    Date returnTime;

    public DVD(int id,String name,String type){
        this.id=id;
        this.name=name;
        this.type = type;
        this.status = false;
        this.lendTime = null;
        this.returnTime = null;
    }

    //方法
    //显示DVD信息的方法
    public String showInfo(){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss a");

        String isLend;
        isLend = this.status?"已借出":"未借出";
        String bt = this.lendTime==null?"":sdf.format(this.lendTime);  //借出时间
        String rt = this.returnTime==null?"":sdf.format(this.returnTime);  //归还时间

        return  "编号:"+this.id+"," +
                "片名:<<"+this.name+">>," +
                "类型:"+this.type+"," +
                "状态："+isLend+"，" +
                "借出时间："+bt+"，" +
                "归还时间："+rt;
    }
}