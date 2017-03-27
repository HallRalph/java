package test;

import java.util.Scanner;

/**
 * * datou on 2017/2/24.
 */
public class test {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int choice;

        DVDManagement dm = new DVDManagement();
        dm.showMenu();
        choice = in .nextInt();
        while (choice!=6){
            switch (choice){
                case 1:
                    //System.out.println("查询所有DVD资料");
                    dm.queryAllDVD();
                    break;
                case 2:
                    //System.out.println("新增DVD资料");
                    int id3;
                    String name,type;
                    System.out.println("输入编号：");
                    id3=in.nextInt();
                    System.out.println("输入片名");
                    name = in.next();
                    System.out.println("输入类型");
                    type = in.next();
                    DVD dvd = new DVD(id3,name,type);
                    if(dm.addDVD(dvd))
                    {
                        System.out.println("添加DVD成功！");
                    }
                    else
                    {
                        System.out.println("添加失败！");
                    }
                    break;
                case 3:
                    System.out.println("删除DVD资料");
                    break;
                case 4:
                    //System.out.println("借出DVD");
                    System.out.println("输入要借的DVD的编号：");
                    int id = in.nextInt();
                    if(dm.lendDVD(id))
                        System.out.println("借出成功！");
                    else
                        System.out.println("借出失败！");
                    break;
                case 5:
                    System.out.println("输入要还的DVD的编号：");
                    int id2 = in.nextInt();
                    if(dm.returnDVD(id2))
                        System.out.println("归还成功！");
                    else
                        System.out.println("归还失败！");
                    break;
            }
            dm.showMenu();
            choice=in.nextInt();
        }
        System.out.println("已退出。");
    }
}
