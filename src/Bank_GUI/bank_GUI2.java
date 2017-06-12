package Bank_GUI;

import com.mysql.jdbc.*;
import com.sun.org.apache.regexp.internal.RE;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.sql.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;

/**
 * Created by dt112 on 2017/6/9.
 */
public class bank_GUI2{
    //数据库
    private static String url = "jdbc:mysql://localhost:3306/test";//连接数据库的url，test是我自己的一个数据库啊宝宝们。
    private static String user = "root";//mysql登录名
    private static String pass = "123456";//mysql登录密码
    private static Connection con;//


    private static JFrame f = new JFrame("ATM");    //  主窗体
    private static JPanel p = new JPanel(null);   //  登录/开户
    private static JPanel p1 = new JPanel();             //  查询
    private static JPanel p2 = new JPanel();             //  存款
    private static JPanel p3 = new JPanel();             //  取款
    private static JPanel p4 = new JPanel(null);  //  转账
    private static JPanel p5 = new JPanel(null);  //  改密
    private static JPanel lp = new JPanel(null);  //  登录页面
    private static JPanel zcp = new JPanel(null); //  注册页面

    private static int card_id;
    private static String sex;
    private static String name;
    private static String pwd;
    private static int id;
    private static int card_type;
    private static float balance;
    private static float overdraw;

    private static JPanel mainp = new JPanel(null);


    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.jdbc.Driver");
        con = DriverManager.getConnection(url, user, pass);

        createFrame();
        loginPanel();
        showp();
        mainP();
        chaxun();
        cunkuan();
        qukuan();
        zhuanzhang();
        gaimi();
        zhuce();

        //显示选择登录/开户，隐藏其他Panel
        p.setVisible(true);
        p1.setVisible(false);
        p2.setVisible(false);
        p4.setVisible(false);
        p5.setVisible(false);
        lp.setVisible(false);
        mainp.setVisible(false);

    }

    public static void createFrame() {
        f.setSize(500, 535);
        f.setLocation(710, 290);
        f.setResizable(false);

        JButton denglu = new JButton("登录");
        JButton kaihu = new JButton("开户");

        denglu.setBounds(113,150,80,25);
        kaihu.setBounds(306,150,80,25);

        p.add(denglu);
        p.add(kaihu);

        //登录
        denglu.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                f.setTitle("登录");
                showloginp();
            }
        });
        //开户
        kaihu.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                f.setTitle("开户");
                showzcp();
            }
        });
        f.add(p);




        f.setVisible(true);
    }

    private static void showp() {
        f.setTitle("ATM");
        zcp.setVisible(false);
        lp.setVisible(false);
        p.setVisible(true);

        f.add(p);
    }

    //注册Panel
    private static void zhuce() {
        JLabel l2 = new JLabel("性别：");
        l2.setBounds(50,30,80,25);

        JRadioButton male = new JRadioButton("男");
        JRadioButton female = new JRadioButton("女");
        ButtonGroup bg = new ButtonGroup();
        bg.add(male);
        bg.add(female);
        male.setBounds(150,30,50,25);
        female.setBounds(220,30,50,25);
        JLabel l3 = new JLabel("姓名：");
        l3.setBounds(50,60,80,25);

        JTextField t3 = new JTextField(20);
        t3.setBounds(150,60,150,25);

        JLabel l4 = new JLabel("密码：");
        l4.setBounds(50,90,80,25);
        JPasswordField t4 = new JPasswordField(20);
        t4.setBounds(150,90,150,25);

        JLabel l0 = new JLabel("确认密码：");
        l0.setBounds(50,120,150,25);

        JPasswordField t0 = new JPasswordField(20);
        t0.setBounds(150,120,150,25);

        JLabel l5 = new JLabel("ID：");
        l5.setBounds(50,150,50,25);

        JTextField t5 = new JTextField(20);
        t5.setBounds(150,150,150,25);
        JLabel l6 = new JLabel("卡类型：");
        l6.setBounds(50,180,80,25);
        JRadioButton s = new JRadioButton("借记卡");
        JRadioButton c = new JRadioButton("信用卡");
        ButtonGroup ct=new ButtonGroup();
        ct.add(s);ct.add(c);
        s.setBounds(150,180,70,25);
        c.setBounds(230,180,80,25);
        JLabel l7 = new JLabel("存入金额：");
        l7.setBounds(50,210,150,25);
        JTextField t7 = new JTextField(20);
        t7.setBounds(150,210,150,25);
        JLabel l8 = new JLabel("透支额度：");
        l8.setBounds(50,240,150,25);
        JTextField t8 = new JTextField(20);
        t8.setBounds(150,240,150,25);
        JButton b = new JButton("确认");
        b.setBounds(50,270,80,25);
        JButton b2 = new JButton("返回");
        b2.setBounds(150,270,80,25);
        zcp.add(l2);        zcp.add(male);        zcp.add(female);        zcp.add(l3);        zcp.add(t3);        zcp.add(l4);        zcp.add(t4);        zcp.add(l0);        zcp.add(t0);        zcp.add(l5);        zcp.add(t5);        zcp.add(l6);        zcp.add(s);        zcp.add(c);        zcp.add(l7);        zcp.add(t7);        zcp.add(l8);        zcp.add(t8);        zcp.add(b);        zcp.add(b2);        zcp.setVisible(false);

        b.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String s1=t3.getText();

                String s2=new String(t4.getPassword());
                String s3=new String(t0.getPassword());
                String s4=t5.getText();
                String s5=t7.getText();
                String s6=t8.getText();


                //JOptionPane.showMessageDialog(null,"信息错误！","失败",JOptionPane.WARNING_MESSAGE);
                if (bg.isSelected(null)||ct.isSelected(null)||s1.equals("")||s2.equals("")||!s2.equals(s3)||s4.equals("")||s5.equals("")||s6.equals("")) {
                    JOptionPane.showMessageDialog(null, "信息错误！", "失败", JOptionPane.WARNING_MESSAGE);
                } else {
                    String a = String.valueOf(t0.getPassword());
                    String sex = male.isSelected() ? "男" : "女";
                    String name = t3.getText();
                    String pwd = String.valueOf(t4.getPassword());
                    String pwd2 = String.valueOf(t0.getPassword());
                    int id = Integer.parseInt(t5.getText());
                    int card_type = Integer.parseInt(s.isSelected() ? "0" : "1");
                    float balance = Float.parseFloat(t7.getText());
                    float overdraw = Float.parseFloat(t8.getText());
                    String sql = "insert into account(sex,name,password,id,card_type,balance,overdraw) values(?,?,?,?,?,?,?)";
                    try {
                        PreparedStatement ptmt = con.prepareStatement(sql);
                        //ptmt.setInt(1,card_id);
                        ptmt.setString(1, sex);
                        ptmt.setString(2, name);
                        ptmt.setString(3, pwd);
                        ptmt.setInt(4, id);
                        ptmt.setInt(5, card_type);
                        ptmt.setFloat(6, balance);
                        ptmt.setFloat(7, overdraw);
                        ptmt.execute();
                        JOptionPane.showMessageDialog(null, "注册成功！", "OK", JOptionPane.PLAIN_MESSAGE);
                        showloginp();       //转到登录界面
                    } catch (SQLException e1) {
                        e1.printStackTrace();
                    }
                }
            }
        });
        b2.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showp();
            }
        });
    }

    private static void showzcp() {     //显示注册界面
        p.setVisible(false);
        f.add(zcp);
        zcp.setVisible(true);
    }

    private static void loginPanel() {      //登录界面
        JLabel card_idL = new JLabel("card_id:");
        JTextField card_idT = new JTextField(20);
        JLabel pwdL = new JLabel("password:");
        JPasswordField pwdT = new JPasswordField(20);
        JButton queren = new JButton("确认");
        JButton back = new JButton("返回");

        card_idL.setBounds(50,30,80,25);
        card_idT.setBounds(145,30,120,25);
        pwdL.setBounds(50,70,120,25);
        pwdT.setBounds(145,70,120,25);

        queren.setBounds(50,100,80,25);
        back.setBounds(150,100,80,25);
        lp.add(card_idL);
        lp.add(card_idT);
        lp.add(pwdL);
        lp.add(pwdT);
        lp.add(queren);
        lp.add(back);
        queren.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int card_id = Integer.parseInt(card_idT.getText());
                String pwd = String.valueOf(pwdT.getPassword());
                try {
                    check(card_id, pwd);    //检查卡号和密码是否正确
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }
                card_idT.setText("");
                pwdT.setText("");
            }
        });
        back.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showp();
            }
        });
    }

    private static void showloginp() {
        f.add(lp);  //添加登录界面
        p.setVisible(false);
        zcp.setVisible(false);
        mainp.setVisible(false);
        lp.setVisible(true);
    }

    //登录
    private static void check(int card_id2, String pwd2) throws SQLException {
        String sql = "select * from account where card_id=? and password=?";
        PreparedStatement ptmt = con.prepareStatement(sql);
        ptmt.setInt(1, card_id2);
        ptmt.setString(2, pwd2);
        ResultSet rs = ptmt.executeQuery();

        if (rs.next()) {
            JOptionPane.showMessageDialog(null, "登录成功！", "OK", JOptionPane.PLAIN_MESSAGE);
            card_id = rs.getInt("card_id");
            sex = rs.getString("sex");
            name = rs.getString("name");
            pwd = rs.getString("password");
            id = rs.getInt("id");
            card_type = rs.getInt("card_type");
            balance = rs.getFloat("balance");
            overdraw = rs.getFloat("overdraw");
            showmainp();    //转到主界面
        } else {
            JOptionPane.showMessageDialog(null, "信息错误！", "WARNING", JOptionPane.WARNING_MESSAGE);
            showloginp();   //回到登录界面
        }
    }

    private static void mainP() {

        //主界面按钮
        JButton btn1 = new JButton("查询");
        JButton btn2 = new JButton("存款");
        JButton btn3 = new JButton("取款");
        JButton btn4 = new JButton("转账");
        JButton btn5 = new JButton("改密");
        JButton btn6 = new JButton("销户");
        JButton btn7 = new JButton("退卡");
        JButton btn8 = new JButton("返回");

        //调整位置
        btn1.setBounds(113, 80, 80, 25);
        btn2.setBounds(306, 80, 80, 25);
        btn3.setBounds(113, 185, 80, 25);
        btn4.setBounds(306, 185, 80, 25);
        btn5.setBounds(113, 290, 80, 25);
        btn6.setBounds(306, 290, 80, 25);
        btn7.setBounds(113, 395, 80, 25);
        btn8.setBounds(306, 395, 80, 25);

        //添加按钮
        mainp.add(btn1);
        mainp.add(btn2);
        mainp.add(btn3);
        mainp.add(btn4);
        mainp.add(btn5);
        mainp.add(btn6);
        mainp.add(btn7);
        mainp.add(btn8);
        mainp.setVisible(false);

        //查询
        btn1.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    showchaxun();
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }
            }
        });

        //存款
        btn2.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showcunkuan();
            }
        });

//        取款
        btn3.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showqukuan();
            }
        });

        //转账
        btn4.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showzhuanzhang();
            }
        });

        //改密
        btn5.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showgaimi();
            }
        });

        //销户
        btn6.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    xiaohu();
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }
            }
        });


        btn7.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showloginp();
            }
        });
        btn8.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showloginp();
            }
        });
    }

    //显示主界面选择功能
    private static void showmainp() {
        f.setTitle("ATM");
        f.add(mainp);
        lp.setVisible(false);
        mainp.setVisible(true);
    }

    static JLabel bl = new JLabel();
    static JButton b = new JButton("返回");

    private static void chaxun() throws SQLException {

        b.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                p1.setVisible(false);
                showmainp();
                p1.remove(bl);
                f.setTitle("ATM");
            }
        });
        p1.setVisible(false);
    }

    private static void showchaxun() throws SQLException {
        p1.add(bl);
        p1.add(b);

        f.setTitle("查询");

        String sql = "select balance from account where card_id=?";
        PreparedStatement ptmt = con.prepareStatement(sql);
        ptmt.setInt(1, card_id);
        ResultSet rs = ptmt.executeQuery();
        if (rs.next()) {
            bl.setText("当前余额" + rs.getFloat("balance") + "元");
        }
        f.setTitle("查询");
        mainp.setVisible(false);
        p1.setVisible(true);
        f.add(p1);
    }

    private static void cunkuan() {
        JLabel l = new JLabel("请输入存款金额:");
        JTextField t = new JTextField(20);
        JButton b = new JButton("确认");
        JButton b2 = new JButton("返回");

        b.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                float num = Float.parseFloat(t.getText());
                num += balance;
                String sql = "update account set balance=? where card_id=?";
                try {
                    PreparedStatement preStmt = con.prepareStatement(sql);
                    preStmt.setFloat(1, num);
                    preStmt.setInt(2, card_id);
                    preStmt.executeUpdate();
                    JOptionPane.showMessageDialog(null, "存款成功！", "OK", JOptionPane.PLAIN_MESSAGE);
                    showchaxun();
                    balance = num;
                    p2.setVisible(false);
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }
            }
        });
        b2.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                t.setText("");
                p2.setVisible(false);
                showmainp();
            }
        });
        p2.add(l);
        p2.add(t);
        p2.add(b);
        p2.add(b2);
        p2.setVisible(false);
    }

    private static void showcunkuan() {
        f.setTitle("存款");

        mainp.setVisible(false);
        f.add(p2);
        p2.setVisible(true);
    }

    private static void qukuan() {
        mainp.setVisible(false);
        JLabel l = new JLabel("请输入取款金额:");
        JTextField t = new JTextField(20);
        JButton b = new JButton("确认");
        JButton b2 = new JButton("返回");

        p3.add(l);
        p3.add(t);
        p3.add(b);
        p3.add(b2);
        b.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                float num = Float.parseFloat(t.getText());
                if (num != 0 && num > 0) {
                    if (card_type == 0) {  //储蓄卡
                        if (balance < num) {
                            JOptionPane.showMessageDialog(null, "余额不足！", "WARNING", JOptionPane.WARNING_MESSAGE);
                            t.setText("");
                        } else {
                            balance -= num;
                            String sql = "update account set balance=? where card_id=?";
                            try {
                                PreparedStatement preStmt = con.prepareCall(sql);
                                preStmt.setFloat(1, balance);
                                preStmt.setInt(2, card_id);
                                preStmt.executeUpdate();
                                JOptionPane.showMessageDialog(null, "取款成功！", "OK", JOptionPane.PLAIN_MESSAGE);
                                t.setText("");
                            } catch (SQLException e1) {
                                e1.printStackTrace();
                            }
                        }
                    } else {  //信用卡
                        if (balance - num < -overdraw) {
                            JOptionPane.showMessageDialog(null, "额度不足！", "WARNING", JOptionPane.WARNING_MESSAGE);
                            t.setText("");
                        } else {
                            balance -= num;
                            String sql = "update account set balance=? where card_id=?";
                            try {
                                PreparedStatement preStmt = con.prepareStatement(sql);
                                preStmt.setFloat(1, balance);
                                preStmt.setInt(2, card_id);
                                preStmt.executeUpdate();
                                JOptionPane.showMessageDialog(null, "取款成功！", "OK", JOptionPane.PLAIN_MESSAGE);
                                t.setText("");

                            } catch (SQLException e1) {
                                e1.printStackTrace();
                            }
                        }
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "金额错误！", "WARNING", JOptionPane.WARNING_MESSAGE);
                    t.setText("");
                }

                p2.setVisible(false);
            }
        });
        b2.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                p3.setVisible(false);
showmainp();            }
        });
    }

    private static void showqukuan() {
        f.setTitle("取款");
        mainp.setVisible(false);
        f.add(p3);
        p3.setVisible(true);
    }

    private static void zhuanzhang() {
        mainp.setVisible(false);
        JLabel card_idL = new JLabel("请输入对方卡号：");
        JTextField card_idT = new JTextField(20);
        JLabel l = new JLabel("请输入转账金额:");
        JTextField t = new JTextField(20);
        JButton b = new JButton("确认");
        JButton b2 = new JButton("返回");

        card_idL.setBounds(80,30,120,25);
        card_idT.setBounds(185,30,120,25);
        l.setBounds(80,70,120,25);
        t.setBounds(185,70,120,25);

        b.setBounds(80,100,80,25);
        b2.setBounds(180,100,80,25);

        //确认转账
        b.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {

                int card_id2;
                float num;
                if (card_idT.getText().equals("") || t.getText().equals("")) {
                    JOptionPane.showMessageDialog(null, "信息错误！", "失败", JOptionPane.WARNING_MESSAGE);

                } else {
                    card_id2 = Integer.parseInt(card_idT.getText());
                    num = Float.parseFloat(t.getText());
                    String sql = "select * from account where card_id=?";
                    try {
                        PreparedStatement ptmt = con.prepareStatement(sql);
                        ptmt.setInt(1, card_id2);
                        ResultSet rs = ptmt.executeQuery();
                        if (rs.next()) {
                            if (card_id != card_id2) {
                                if (num > balance && card_type == 0) {
                                    JOptionPane.showMessageDialog(null, "余额不足！", "失败", JOptionPane.WARNING_MESSAGE);
                                    t.setText("");
                                } else if (num < balance || num < overdraw + balance) {
                                    String sql2 = "update account set balance=? where card_id=?";
                                    PreparedStatement preStmt3 = con.prepareStatement(sql2);
                                    preStmt3.setFloat(1, balance - num);
                                    preStmt3.setInt(2, card_id);
                                    preStmt3.executeUpdate();

                                    String sql3 = "update account set balance=? where card_id=?";
                                    PreparedStatement preStmt4 = con.prepareStatement(sql3);
                                    preStmt4.setFloat(1, rs.getFloat("balance") + num);
                                    preStmt4.setInt(2, card_id2);
                                    preStmt4.executeUpdate();
                                    JOptionPane.showMessageDialog(null, "转账成功！", "OK", JOptionPane.PLAIN_MESSAGE);
                                    card_idT.setText("");
                                    t.setText("");
                                } else {
                                    JOptionPane.showMessageDialog(null, "余额不足！", "失败", JOptionPane.WARNING_MESSAGE);
                                    t.setText("");
                                }
                            } else {
                                JOptionPane.showMessageDialog(null, "不能给本卡转账！", "失败", JOptionPane.WARNING_MESSAGE);
                                card_idT.setText("");
                                t.setText("");
                            }
                        } else {
                            JOptionPane.showMessageDialog(null, "对方卡号不存在！", "失败", JOptionPane.WARNING_MESSAGE);
                            card_idT.setText("");
                            t.setText("");
                        }
                    } catch (SQLException e1) {
                        e1.printStackTrace();
                    }
                }


            }
        });
        //返回
        b2.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                p4.setVisible(false);
                showmainp();
            }
        });
        p4.add(card_idL);
        p4.add(card_idT);
        p4.add(l);
        p4.add(t);
        p4.add(b);
        p4.add(b2);
    }

    private static void showzhuanzhang() {
        f.setTitle("转账");
        mainp.setVisible(false);
        f.add(p4);
        p4.setVisible(true);
    }

    private static void gaimi() {
        JLabel l1 = new JLabel("请输入原密码：");
        JPasswordField p1 = new JPasswordField(20);
        JLabel l2 = new JLabel("请输入新密码:");
        JPasswordField p2 = new JPasswordField(20);
        JLabel l3 = new JLabel("请再次输入新密码:");
        JPasswordField p3 = new JPasswordField(20);
        JButton b = new JButton("确认");
        JButton b2 = new JButton("返回");

        l1.setBounds(80,30,120,25);
        p1.setBounds(195,30,120,25);
        l2.setBounds(80,70,120,25);
        p2.setBounds(195,70,120,25);

        l3.setBounds(80,110,120,25);
        p3.setBounds(195,110,120,25);


        b.setBounds(80,150,80,25);
        b2.setBounds(180,150,80,25);


        //确认改密
        b.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String sql = "select password from account where card_id=?";
                try {
                    String pwd1 = String.valueOf(p1.getPassword());
                    String pwd2 = String.valueOf(p2.getPassword());
                    String pwd3 = String.valueOf(p3.getPassword());

                    PreparedStatement ptmt = con.prepareStatement(sql);
                    ptmt.setInt(1, card_id);
                    ResultSet rs = ptmt.executeQuery();
                    if (rs.next()) {
                        if (pwd1.equals(rs.getString("password")) && pwd2.equals(pwd3)) {
                            String sql2 = "update account set password=? where card_id=?";
                            PreparedStatement preStmt = con.prepareStatement(sql2);
                            preStmt.setString(1, pwd2);
                            preStmt.setInt(2, card_id);
                            preStmt.executeUpdate();

                            JOptionPane.showMessageDialog(null, "改密成功！", "OK", JOptionPane.PLAIN_MESSAGE);
                            p1.setText("");
                            p2.setText("");
                            p3.setText("");
                        } else {
                            JOptionPane.showMessageDialog(null, "信息错误！", "失败", JOptionPane.WARNING_MESSAGE);
                            p1.setText("");
                            p2.setText("");
                            p3.setText("");
                        }
                    }
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }
            }
        });
        //返回
        b2.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                p5.setVisible(false);
                showmainp();
            }
        });
        p5.add(l1);
        p5.add(p1);
        p5.add(l2);
        p5.add(p2);
        p5.add(l3);
        p5.add(p3);
        p5.add(b);
        p5.add(b2);
    }

    private static void showgaimi() {
        f.setTitle("改密");
        mainp.setVisible(false);
        p5.setVisible(true);
        f.add(p5);
    }


    //销户
    private static void xiaohu() throws SQLException {
        int exi = JOptionPane.showConfirmDialog(null, "确认销户吗？", "提示", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (exi == JOptionPane.YES_OPTION) {
            String sql = "delete from account where card_id=?";
            PreparedStatement ptmt = con.prepareStatement(sql);
            ptmt.setInt(1, card_id);
            ptmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "销户成功！", "OK", JOptionPane.PLAIN_MESSAGE);
            mainp.setVisible(false);
            showp();
        } else {
            ;
        }
    }
}
