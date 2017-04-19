//package study;
//import javax.swing.*;
//import java.awt.*;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//import java.awt.event.ItemEvent;
//import java.awt.event.ItemListener;
//
///**
// * Created by ST001 on 2017/4/12.
// */
///*
//public class Gui {
//    public static void main(String[] args) {
//            JFrame f=new JFrame();
//            f.setTitle("学生信息管理系统");
//            f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
////            f.setExtendedState(JFrame.MAXIMIZED_BOTH);
//            f.setSize(400,300);
//            f.setLocation(200,200);
//
//            Container con=f.getContentPane();
//            JPanel pan=new JPanel();
//            JLabel l_name= new JLabel("姓名");
//            pan.add(l_name);
//            final JTextField tf_name=new JTextField(20);
//            pan.add(tf_name);
//
//            final JLabel l_pwd=new JLabel("密码");
//            pan.add(l_pwd);
//            final JPasswordField password = new JPasswordField(20);
//            password.setEchoChar('*');
//            pan.add(password);
//
//            JLabel l_sex= new JLabel("性别");
//            pan.add(l_sex);
//            JRadioButton male=new JRadioButton("男",true);
//            JRadioButton female=new JRadioButton("女");
//            ButtonGroup group = new ButtonGroup();
//            group.add(male);
//            group.add(female);
//            pan.add(male);
//            pan.add(female);
//
//
//            JLabel l_ah= new JLabel("爱好");
//            final JCheckBox chkApple = new JCheckBox("Apple");
//            final JCheckBox chkMango = new JCheckBox("Mango");
//            final JCheckBox chkPeer = new JCheckBox("Peer");
//            pan.add(chkApple);
//            pan.add(chkMango);
//            pan.add(chkPeer);
//
//
///*            JCheckBox[] hobby={new JCheckBox("音乐"),
//                    new JCheckBox("足球"),
//                    new JCheckBox("绘画")};
//            pan.add(l_ah);
//            pan.add(hobby[0]);
//            pan.add(hobby[1]);
//            pan.add(hobby[2]);
//*/
//            JLabel l_yx=new JLabel("院系");
//            pan.add(l_yx);
//            String[] departmentNames={"计算机科学与技术","电子信息与技术"};
//            JComboBox department=new JComboBox(departmentNames);
//            department.setEditable(false);
//            pan.add(department);
//
//
//
//            JLabel l_xk=new JLabel("选课");
//            String[] coursesNames={"JAVA","Linux","Python"};
//            JList course = new JList(coursesNames);
//            pan.add(l_xk);
//            pan.add(course);
//
//            JLabel l_jf=new JLabel("加分");
//            pan.add(l_jf);
//            JSlider addition = new JSlider(JSlider.HORIZONTAL, 0, 100, 50);
//            addition.setMajorTickSpacing(10);
//            addition.setMinorTickSpacing(5);
//            addition.setPaintTicks(true);
//            addition.setPaintLabels(true);
//            addition.setSnapToTicks(true);
//            pan.add(addition);
//
//            JProgressBar progbar=new JProgressBar(JProgressBar.HORIZONTAL,0,100);
//            progbar.setStringPainted(true);
//
//            JButton b_sub=new JButton("确认");
//            pan.add(b_sub);
//            JButton b_save=new JButton("保存");
//            pan.add(b_save);
//
//            JLabel l_jg=new JLabel("录入结果");
//            final JTextArea result=new JTextArea(10,30);
//            JScrollPane sp=new JScrollPane(result);
//            pan.add(sp);
//            pan.add(l_jg);
//
//            final String sex;
//            if(male.isSelected())
//                sex="男";
//            else
//                sex="女";
//
//
//
//
//
//        b_sub.addActionListener(new ActionListener() {
//                                        public void actionPerformed(ActionEvent e) {
//                                            result.setText(tf_name.getText()+","+password.getText()+","+sex+",");
//                                        }
//                                    });
//
//        chkMango.addItemListener(new ItemListener() {
//            public void itemStateChanged(ItemEvent e) {
//                if(e.getStateChange()==1)
//                    result.setText(result.getText()+chkMango.getText()+",");
//            }
//        });
//        chkPeer.addItemListener(new ItemListener() {
//            public void itemStateChanged(ItemEvent e) {
//                if(e.getStateChange()==1)
//                    result.setText(result.getText()+chkPeer.getText()+",");
//            }
//        });
//
//        //-----------------------
//        b_save.addActionListener(new ActionListener() {
//            public void actionPerformed(ActionEvent e) {
//                String data = "";
//                /*if (yx.getSelectedIndex() != -1) {
//                    data = "Fruits Selected: "
//                            + departmentNames.getItemAt
//                            (fruitCombo.getSelectedIndex());
//                }
//                statusLabel.setText(data);*/
//            }
//        });
//        //------------------------
//
//        con.add(pan);
//            f.setVisible(true);
//        }
//    }
