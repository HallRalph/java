package test;

import java.util.Date;

/**
 * * datou on 2017/2/24.
 */
public class DVDManagement {

    //属性
    DVD [] dvds = new DVD[1000];

    //构造方法
    public DVDManagement(){
        dvds[0] = new DVD(0001,"泰坦尼克","爱情片");
        dvds[1] = new DVD(0002,"叶问","动作片");
        dvds[2] = new DVD(0003,"大话西游","喜剧片");
        dvds[3] = new DVD(0004,"小时代","烂片");
    }

    //方法
    public void queryAllDVD(){
        for(int i=0;i<dvds.length;i++){
            if(dvds[i]==null)   //如果对象为空，结束查询
                break;
            else
                System.out.println(dvds[i].showInfo());
        }
    }

    //显示主菜单的方法
    public void showMenu(){
        System.out.println("********迷你DVD管理系统********");
        System.out.println("1.查询所有DVD资料");
        System.out.println("2.新增DVD资料");
        System.out.println("3.删除DVD资料");
        System.out.println("4.借出DVD");
        System.out.println("5.归还DVD");
        System.out.println("6.退出系统");
        System.out.println("请选择(1~6)：");
    }

    //添加
    public boolean addDVD(DVD dvd)
    {
        //首先检查DVD ID是否重复
        if(searchId(dvd.id))
        {
            System.out.println("DVD编号重复！");
            return false;
        }
        else
        {
            for( int i=0;i<dvds.length;i++)
            {
                if(dvds[i]==null)
                {
                    dvds[i]=dvd;
                    return true;
                }
            }
            return false;
        }
    }

    public boolean delDVD(int id)
    {
        int pos=-1;
        for(int i=0;i<dvds.length;i++)
        {
            if(dvds[i].id==id)//找到
            {
                pos=i;
                for(;pos<dvds.length && dvds[pos]!= null;pos++)
                {
                    dvds[pos]=dvds[pos+1];
                }
                return true;
            }
        }
        return false;
    }



    //检查碟片ID是否重复
    public boolean searchId(int id)
    {
        for(int i=0 ;i<dvds.length;i++)
        {
            if(dvds[i]==null)
                break;
            if(dvds[i].id==id)  //ID重复
            {
                return true;
            }
        }
        return false;
    }


    //借出
    public boolean lendDVD(int id){
        for(int i=0;i<dvds.length;i++)
        {
            if(dvds[i]==null)
            {
                System.out.println("此碟片不存在");
                return false;   //遍历结束，DVD不存在
            }
            if(dvds[i].id==id)  //说明找到了
            {
                if(dvds[i].status)    //说明已经被借出
                {
                    System.out.println("此碟片已经被借出");
                    return false;
                }
                else{
                    dvds[i].status = true;
                    dvds[i].lendTime = new Date();
                    return true;
                }
            }
        }
        return false;
    }



    public boolean returnDVD(int id){
        for(int i=0;i<dvds.length;i++)
        {
            if(dvds[i]==null)
                return false;   //遍历结束，DVD不存在
            if(dvds[i].id==id)  //说明找到了
            {
                if(!dvds[i].status)    //说明已经被借出
                {
                    System.out.println("此碟片未被借出");
                    return false;
                }
                else{
                    dvds[i].status = false;
                    dvds[i].returnTime = new Date();
                    return true;
                }
            }
        }
        return false;
    }


}
