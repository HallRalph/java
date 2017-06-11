package Bank_GUI;

import com.mysql.jdbc.*;
import com.sun.org.apache.regexp.internal.RE;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.sql.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;

/**
 * Created by dt112 on 2017/6/9.
 */
public class bank_GUI{
    //?????
    private static String url = "jdbc:mysql://localhost:3306/test";//??????????url??test????????????????????????
    private static String user = "root";//mysql?????
    private static String pass = "";//mysql???????
    private static Connection con;//


    private static JFrame f = new JFrame("ATM");
    private static JPanel p = new JPanel();
    private static JPanel p1 = new JPanel();
    private static JPanel p2 = new JPanel();
    private static JPanel p3 = new JPanel();
    private static JPanel p4 = new JPanel();
    private static JPanel p5 = new JPanel();
    private static JPanel lp = new JPanel();
    private static JPanel zcp = new JPanel();

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

        JButton denglu = new JButton("???");
        JButton kaihu = new JButton("????");
        p.add(denglu);
        p.add(kaihu);

        //?????????
        denglu.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showloginp();
            }
        });
        //????
        kaihu.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showzcp();
            }
        });
        f.setVisible(true);
    }

    private static void showp() {
        zcp.setVisible(false);
        lp.setVisible(false);
        p.setVisible(true);

        f.add(p);
    }

    //???Panel
    private static void zhuce() {
        //JLabel l1 = new JLabel("?????");
        //JTextField t1 = new JTextField(20);
        JLabel l2 = new JLabel("???");
        JRadioButton male = new JRadioButton("??");
        JRadioButton female = new JRadioButton("?");
        ButtonGroup bg = new ButtonGroup();
        bg.add(male);
        bg.add(female);
//        male.setSelected(true);
        JLabel l3 = new JLabel("??????");
        JTextField t3 = new JTextField(20);
        JLabel l4 = new JLabel("????");
        JPasswordField t4 = new JPasswordField(20);
        JLabel l0 = new JLabel("???????");
        JPasswordField t0 = new JPasswordField(20);
        JLabel l5 = new JLabel("ID??");
        JTextField t5 = new JTextField(20);
        JLabel l6 = new JLabel("???????");
        JRadioButton s = new JRadioButton("????");
        JRadioButton c = new JRadioButton("?????");
        JLabel l7 = new JLabel("??????");
        JTextField t7 = new JTextField(20);
        JLabel l8 = new JLabel("??????");
        JTextField t8 = new JTextField(20);
        JButton b = new JButton("???");
        JButton b2 = new JButton("????");

        //zcp.add(l1);
//        zcp.add(t1);
        zcp.add(l2);
        zcp.add(male);
        zcp.add(female);
        zcp.add(l3);
        zcp.add(t3);
        zcp.add(l4);
        zcp.add(t4);
        zcp.add(l0);
        zcp.add(t0);
        zcp.add(l5);
        zcp.add(t5);
        zcp.add(l6);
        zcp.add(s);
        zcp.add(c);
        zcp.add(l7);
        zcp.add(t7);
        zcp.add(l8);
        zcp.add(t8);
        zcp.add(b);
        zcp.add(b2);
        zcp.setVisible(false);

        b.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //int card_id= Integer.parseInt(t1.getText());
                if(!male.isSelected()||!female.isSelected()||t3.getText().equals("")||t4.getPassword().equals("")||t0.getPassword().equals("")||t5.getText().equals("")||!s.isSelected()||!c.isSelected()||t7.getText().equals("")||t8.getText().equals("")){
                    JOptionPane.showMessageDialog(null, "???????", "WARNING", JOptionPane.WARNING_MESSAGE);
                }else {
                    String sex=male.isSelected()?"??":"?";
                    String name=t3.getText();
                    String pwd= String.valueOf(t4.getPassword());
                    String pwd2=String.valueOf(t0.getPassword());
                    int id= Integer.parseInt(t5.getText());
                    int card_type= Integer.parseInt(s.isSelected()?"0":"1");
                    float balance= Float.parseFloat(t7.getText());
                    float overdraw= Float.parseFloat(t8.getText());



                    String sql="insert into account(sex,name,password,id,card_type,balance,overdraw) values(?,?,?,?,?,?,?)";
                    try {
                        PreparedStatement ptmt=con.prepareStatement(sql);
                        //ptmt.setInt(1,card_id);
                        ptmt.setString(1,sex);
                        ptmt.setString(2,name);
                        ptmt.setString(3,pwd);
                        ptmt.setInt(4,id);
                        ptmt.setInt(5,card_type);
                        ptmt.setFloat(6,balance);
                        ptmt.setFloat(7,overdraw);
                        ptmt.execute();
                        JOptionPane.showMessageDialog(null, "???????", "OK", JOptionPane.PLAIN_MESSAGE);
                        showloginp();
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

    private static void showzcp() {
        p.setVisible(false);
        f.add(zcp);
        zcp.setVisible(true);
    }

    private static void loginPanel() {
        JLabel card_idL = new JLabel("card_id:");
        JTextField card_idT = new JTextField(20);
        JLabel pwdL = new JLabel("password:");
        JPasswordField pwdT = new JPasswordField(20);
        JButton queren = new JButton("???");
        JButton back = new JButton("????");
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
                    check(card_id, pwd);
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
        f.add(lp);
        p.setVisible(false);
        zcp.setVisible(false);
        mainp.setVisible(false);
        lp.setVisible(true);
    }

    //???
    private static void check(int card_id2, String pwd2) throws SQLException {
        String sql = "select * from account where card_id=? and password=?";
        PreparedStatement ptmt = con.prepareStatement(sql);
        ptmt.setInt(1, card_id2);
        ptmt.setString(2, pwd2);
        ResultSet rs = ptmt.executeQuery();

        if (rs.next()) {
            JOptionPane.showMessageDialog(null, "????????", "OK", JOptionPane.PLAIN_MESSAGE);
            card_id = rs.getInt("card_id");
            sex = rs.getString("sex");
            name = rs.getString("name");
            pwd = rs.getString("password");
            id = rs.getInt("id");
            card_type = rs.getInt("card_type");
            balance = rs.getFloat("balance");
            overdraw = rs.getFloat("overdraw");
            System.out.println(
                    card_id + "," + sex + "," + name + "," + pwd + "," + id + "," + card_type + "," + balance + "," + overdraw
            );
            showmainp();
        } else {
            JOptionPane.showMessageDialog(null, "???????", "WARNING", JOptionPane.WARNING_MESSAGE);
            showloginp();
        }
    }

    private static void mainP() {
        JButton btn1 = new JButton("???");
        JButton btn2 = new JButton("???");
        JButton btn3 = new JButton("???");
        JButton btn4 = new JButton("???");
        JButton btn5 = new JButton("????");
        JButton btn6 = new JButton("????");
        JButton btn7 = new JButton("???");
        JButton btn8 = new JButton("????");
        //JButton btn5=new JButton("????");

        btn1.setBounds(113, 80, 80, 25);
        btn2.setBounds(306, 80, 80, 25);
        btn3.setBounds(113, 185, 80, 25);
        btn4.setBounds(306, 185, 80, 25);
        btn5.setBounds(113, 290, 80, 25);
        btn6.setBounds(306, 290, 80, 25);
        btn7.setBounds(113, 395, 80, 25);
        btn8.setBounds(306, 395, 80, 25);

        mainp.add(btn1);
        mainp.add(btn2);
        mainp.add(btn3);
        mainp.add(btn4);
        mainp.add(btn5);
        mainp.add(btn6);
        mainp.add(btn7);
        mainp.add(btn8);
        mainp.setVisible(false);
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
        btn2.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showcunkuan();
            }
        });
        btn3.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showqukuan();
            }
        });
        btn4.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showzhuanzhang();
            }
        });
        btn5.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showgaimi();
            }
        });
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

    private static void showmainp() {
        f.add(mainp);
        lp.setVisible(false);
        mainp.setVisible(true);
    }

    static JLabel bl = new JLabel();
    static JButton b = new JButton("????");

    private static void chaxun() throws SQLException {

        b.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                p1.setVisible(false);
                mainp.setVisible(true);
                p1.remove(bl);
                f.setTitle("ATM");
            }
        });


        p1.setVisible(false);
    }

    private static void showchaxun() throws SQLException {
        p1.add(bl);
        p1.add(b);

        String sql = "select balance from account where card_id=?";
        PreparedStatement ptmt = con.prepareStatement(sql);
        ptmt.setInt(1, card_id);
        ResultSet rs = ptmt.executeQuery();
        if (rs.next()) {
            System.out.println("???" + rs.getFloat("balance") + "?");
            bl.setText("??????" + rs.getFloat("balance") + "?");
        }
        f.setTitle("???");
        mainp.setVisible(false);
        p1.setVisible(true);
        f.add(p1);
    }

    private static void cunkuan() {
        JLabel l = new JLabel("??????????:");
        JTextField t = new JTextField(20);
        JButton b = new JButton("???");
        JButton b2 = new JButton("????");

        b.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                float num = Float.parseFloat(t.getText());
                num += balance;
                System.out.println(num);
                String sql = "update account set balance=? where card_id=?";
                try {
                    PreparedStatement preStmt = con.prepareStatement(sql);
                    preStmt.setFloat(1, num);
                    preStmt.setInt(2, card_id);
                    preStmt.executeUpdate();
                    JOptionPane.showMessageDialog(null, "???????", "OK", JOptionPane.PLAIN_MESSAGE);
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
                mainp.setVisible(true);
            }
        });
        p2.add(l);
        p2.add(t);
        p2.add(b);
        p2.add(b2);
        p2.setVisible(false);
    }

    private static void showcunkuan() {
        f.setTitle("???");

        mainp.setVisible(false);
        f.add(p2);
        p2.setVisible(true);
    }

    private static void qukuan() {
        mainp.setVisible(false);
        JLabel l = new JLabel("???????????:");
        JTextField t = new JTextField(20);
        JButton b = new JButton("???");
        JButton b2 = new JButton("????");

        p3.add(l);
        p3.add(t);
        p3.add(b);
        p3.add(b2);
        b.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                float num = Float.parseFloat(t.getText());
                if (num != 0 && num > 0) {
                    if (card_type == 0) {  //????
                        if (balance < num) {
                            JOptionPane.showMessageDialog(null, "?????", "WARNING", JOptionPane.WARNING_MESSAGE);
                            t.setText("");
                        } else {
                            balance -= num;
                            String sql = "update account set balance=? where card_id=?";
                            try {
                                PreparedStatement preStmt = con.prepareCall(sql);
                                preStmt.setFloat(1, balance);
                                preStmt.setInt(2, card_id);
                                preStmt.executeUpdate();
                                JOptionPane.showMessageDialog(null, "???????", "OK", JOptionPane.PLAIN_MESSAGE);
                                t.setText("");
                            } catch (SQLException e1) {
                                e1.printStackTrace();
                            }
                        }
                    } else {  //?????
                        if (balance - num < -overdraw) {
                            JOptionPane.showMessageDialog(null, "??????", "WARNING", JOptionPane.WARNING_MESSAGE);
                            t.setText("");
                        } else {
                            balance -= num;
                            String sql = "update account set balance=? where card_id=?";
                            try {
                                PreparedStatement preStmt = con.prepareStatement(sql);
                                preStmt.setFloat(1, balance);
                                preStmt.setInt(2, card_id);
                                preStmt.executeUpdate();
                                JOptionPane.showMessageDialog(null, "???????", "OK", JOptionPane.PLAIN_MESSAGE);
                                t.setText("");

                            } catch (SQLException e1) {
                                e1.printStackTrace();
                            }
                        }
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "??????", "WARNING", JOptionPane.WARNING_MESSAGE);
                    t.setText("");
                }

                p2.setVisible(false);
            }
        });
        b2.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                p3.setVisible(false);
                mainp.setVisible(true);
            }
        });
    }

    private static void showqukuan() {
        f.setTitle("???");
        mainp.setVisible(false);
        f.add(p3);
        p3.setVisible(true);
    }

    private static void zhuanzhang() {
        mainp.setVisible(false);
        JLabel card_idL = new JLabel("?????????????");
        JTextField card_idT = new JTextField(20);
        JLabel l = new JLabel("???????????:");
        JTextField t = new JTextField(20);
        JButton b = new JButton("???");
        JButton b2 = new JButton("????");

        //??????
        b.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {

                int card_id2;
                float num;
                if (card_idT.getText().equals("") || t.getText().equals("")) {
                    JOptionPane.showMessageDialog(null, "???????", "???", JOptionPane.WARNING_MESSAGE);

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
                                    JOptionPane.showMessageDialog(null, "?????", "???", JOptionPane.WARNING_MESSAGE);
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
                                    JOptionPane.showMessageDialog(null, "???????", "OK", JOptionPane.PLAIN_MESSAGE);
                                    card_idT.setText("");
                                    t.setText("");
                                } else {
                                    JOptionPane.showMessageDialog(null, "?????", "???", JOptionPane.WARNING_MESSAGE);
                                    t.setText("");
                                }
                            } else {
                                JOptionPane.showMessageDialog(null, "?????????????", "???", JOptionPane.WARNING_MESSAGE);
                                card_idT.setText("");
                                t.setText("");
                            }
                        } else {
                            JOptionPane.showMessageDialog(null, "?????????????", "???", JOptionPane.WARNING_MESSAGE);
                            card_idT.setText("");
                            t.setText("");
                        }
                    } catch (SQLException e1) {
                        e1.printStackTrace();
                    }
                }


            }
        });
        //????
        b2.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                p4.setVisible(false);
                mainp.setVisible(true);
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
        f.setTitle("???");
        mainp.setVisible(false);
        f.add(p4);
        p4.setVisible(true);
    }

    private static void gaimi() {
        JLabel l1 = new JLabel("???????????");
        JPasswordField p1 = new JPasswordField(20);
        JLabel l2 = new JLabel("????????????:");
        JPasswordField p2 = new JPasswordField(20);
        JLabel l3 = new JLabel("???????????????:");
        JPasswordField p3 = new JPasswordField(20);
        JButton b = new JButton("???");
        JButton b2 = new JButton("????");

        //??????
        b.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String sql = "select password from account where card_id=?";
                try {
                    String pwd1 = String.valueOf(p1.getPassword());
                    String pwd2 = String.valueOf(p2.getPassword());
                    String pwd3 = String.valueOf(p3.getPassword());
                    /*System.out.println(pwd1);
                    System.out.println(pwd2);
                    System.out.println(pwd3);*/

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

                            JOptionPane.showMessageDialog(null, "????????", "OK", JOptionPane.PLAIN_MESSAGE);
                            p1.setText("");
                            p2.setText("");
                            p3.setText("");
                        } else {
                            JOptionPane.showMessageDialog(null, "???????", "???", JOptionPane.WARNING_MESSAGE);
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
        //????
        b2.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                p5.setVisible(false);
                mainp.setVisible(true);
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
        f.setTitle("????");
        mainp.setVisible(false);
        p5.setVisible(true);
        f.add(p5);
    }


    //????
    private static void xiaohu() throws SQLException {
        int exi = JOptionPane.showConfirmDialog(null, "?????????", "???", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (exi == JOptionPane.YES_OPTION) {
            String sql = "delete from account where card_id=?";
            PreparedStatement ptmt = con.prepareStatement(sql);
            ptmt.setInt(1, card_id);
            ptmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "?????????", "OK", JOptionPane.PLAIN_MESSAGE);
            mainp.setVisible(false);
            showp();
        } else {
            ;
        }
    }
}
