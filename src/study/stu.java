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

        JLabel l_pwd=new JLabel("密码");
        pan.add(l_pwd);
        JPasswordField password = new JPasswordField(20);
        password.setEchoChar('*');
        pan.add(password);

        JLabel l_sex= new JLabel("性别");
        pan.add(l_sex);
        JRadioButton male=new JRadioButton("男",true);
        JRadioButton female=new JRadioButton("女");
        ButtonGroup group = new ButtonGroup();
        group.add(male);
        group.add(female);
        pan.add(male);
        pan.add(female);

        JLabel l_ah= new JLabel("爱好");
        JCheckBox[] hobby={new JCheckBox("音乐"),
                            new JCheckBox("足球"),
                            new JCheckBox("绘画")};
        pan.add(l_ah);
        pan.add(hobby[0]);
        pan.add(hobby[1]);
        pan.add(hobby[2]);

        JLabel l_yx=new JLabel("院系");
        pan.add(l_yx);
        String[] departmentNames={"计算机科学与技术","电子信息与技术"};
        JComboBox department=new JComboBox(departmentNames);
        department.setEditable(false);
        pan.add(department);

        JLabel l_xk=new JLabel("选课");
        String[] coursesNames={"JAVA","Linux","Python"};
        JList course = new JList(coursesNames);
        pan.add(l_xk);
        pan.add(course);

        JLabel l_jf=new JLabel("加分");
        pan.add(l_jf);
        JSlider addition = new JSlider(JSlider.HORIZONTAL, 0, 100, 50);
        addition.setMajorTickSpacing(10);
        addition.setMinorTickSpacing(5);
        addition.setPaintTicks(true);
        addition.setPaintLabels(true);
        addition.setSnapToTicks(true);
        pan.add(addition);

        JProgressBar progbar=new JProgressBar(JProgressBar.HORIZONTAL,0,100);
        progbar.setStringPainted(true);

        JButton b_sub=new JButton("确认");
        pan.add(b_sub);
        JButton b_save=new JButton("保存");
        pan.add(b_save);

        JLabel l_jg=new JLabel("录入结果");
        JTextArea result=new JTextArea(10,30);
        JScrollPane sp=new JScrollPane(result);
        pan.add(sp);
        pan.add(l_jg);

        con.add(pan);
        f.setVisible(true);
    }
}
