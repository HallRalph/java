package study;

import javax.swing.*;
import java.awt.*;

/**
 * Created by ST001 on 2017/4/10.
 */
public class stu {
    public static void main(String[] args) {
        JFrame f=new JFrame();
        f.setTitle("学生信息管理系统");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setExtendedState(JFrame.MAXIMIZED_BOTH);
        f.setSize(400,300);
        f.setLocation(200,200);

        Container con=f.getContentPane();
        JPanel pan=new JPanel();
        JLabel l_name= new JLabel("姓名");
        pan.add(l_name);
        JTextField tf_name=new JTextField(20);
        pan.add(tf_name);
        JLabel l_sex= new JLabel("性别");
        pan.add(l_sex);

        JButton b_sub=new JButton("确认");
        pan.add(b_sub);
        JButton b_save=new JButton("保存");
        pan.add(b_save);

        con.add(pan);
        f.setVisible(true);
    }
}
