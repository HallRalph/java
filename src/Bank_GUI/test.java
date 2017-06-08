package Bank_GUI;

import javax.imageio.plugins.jpeg.JPEGHuffmanTable;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

/**
 * datou on 2017/6/8.
 */
public class test {
    private static String url = "jdbc:mysql://localhost:3306/test";//连接数据库的url，test是我自己的一个数据库啊宝宝们。
    private static String user = "root";//mysql登录名
    private static String pass = "123456";//mysql登录密码
    private static Connection con;//
    private static float balance;


    public static void main(String[] args) throws ClassNotFoundException, SQLException {


        Class.forName("com.mysql.jdbc.Driver");
        con = DriverManager.getConnection(url, user, pass);

        final JFrame[] f = {new JFrame("Test")};
        f[0].setSize(500, 500);
        f[0].setLocation(710, 290);

        JPanel p = new JPanel();

        JButton btn1 = new JButton("登录");
        JButton btn2 = new JButton("开户");
        p.add(btn1);
        p.add(btn2);
        p.setVisible(true);
        f[0].add(p);
        f[0].setVisible(true);

        //点击登录按钮
        btn1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JPanel p2 = new JPanel();
                p2.setLayout(null);
                JLabel nameLabel = new JLabel("card_id:");
                nameLabel.setBounds(10, 20, 80, 25);
                JLabel pwdLabel = new JLabel("password:");
                pwdLabel.setBounds(10, 80, 80, 25);
                JTextField nameText = new JTextField(20);
                nameText.setBounds(100, 20, 165, 25);
                JPasswordField pwdText = new JPasswordField(20);
                pwdText.setBounds(100, 80, 165, 25);

                JButton btn = new JButton("确认");
                btn.setBounds(10, 130, 80, 25);

                p2.add(nameLabel);
                p2.add(nameText);
                p2.add(pwdLabel);
                p2.add(pwdText);
                p2.add(btn);
                f[0].add(p2);
                p.setVisible(false);

                btn.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        JPanel mainPanel = new JPanel();
                        int card_id = Integer.parseInt(nameText.getText());
                        String pwd = String.valueOf(pwdText.getPassword());

                        String sql = "select * from account where card_id=? and password=?";
                        PreparedStatement ptmt = null;
                        try {
                            ptmt = con.prepareStatement(sql);
                            ptmt.setInt(1, card_id);
                            ptmt.setString(2, pwd);
                            ResultSet rs = ptmt.executeQuery();
                            //从登录用户给出的账号密码来检测查询在数据库表中是否存在相同的账号密码
                            if (rs.next()) {
                                balance = rs.getFloat("balance");
                                p2.setVisible(false);
                                mainPanel.setVisible(true);
                            } else {
                                //登录信息错误
                                JOptionPane.showMessageDialog(p2, "信息错误", "title", JOptionPane.WARNING_MESSAGE);
                                nameText.setText("");
                                pwdText.setText("");
                                p2.setVisible(true);
                            }
                        } catch (SQLException e1) {
                            e1.printStackTrace();
                        }


                        JButton btn1 = new JButton("查询");
                        JButton btn2 = new JButton("存款");
                        JButton btn3 = new JButton("取款");
                        JButton btn4 = new JButton("转账");
                        JButton btn5 = new JButton("改密");
                        JButton btn6 = new JButton("销户");
                        JButton btn7 = new JButton("退卡");
                        JButton btn8 = new JButton("返回");
                        mainPanel.add(btn1);
                        mainPanel.add(btn2);
                        mainPanel.add(btn3);
                        mainPanel.add(btn4);
                        mainPanel.add(btn5);
                        mainPanel.add(btn6);
                        mainPanel.add(btn7);
                        mainPanel.add(btn8);
                        f[0].add(mainPanel);

                        //查询按钮
                        btn1.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {

                                JPanel p1 = new JPanel();

                                String sql = "select * from account where card_id=10000";
                                try {
                                    PreparedStatement ptmt = con.prepareStatement(sql);
                                    ResultSet rs = ptmt.executeQuery();
                                    if (rs.next()) {
                                        JLabel l = new JLabel("当前余额:" + rs.getFloat("balance") + "元");
                                        p1.add(l);
                                        f[0].add(p1);
                                        mainPanel.setVisible(false);
                                        JButton btn = new JButton("返回");
                                        p1.add(btn);
                                        btn.addActionListener(new ActionListener() {
                                            @Override
                                            public void actionPerformed(ActionEvent e) {
                                                p1.setVisible(false);
                                                mainPanel.setVisible(true);
                                            }
                                        });
                                    }
                                } catch (SQLException e1) {
                                    e1.printStackTrace();
                                }
                            }
                        });

                        //存款按钮
                        btn2.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                JPanel p2 = new JPanel();
                                JLabel l = new JLabel("请输入存款金额:");
                                JTextField t = new JTextField(20);
                                JButton b = new JButton("确认");
                                JButton b2 = new JButton("返回");
                                f[0].add(p2);
                                //确认存款
                                b.addActionListener(new ActionListener() {
                                    @Override
                                    public void actionPerformed(ActionEvent e) {
                                        float num = Float.parseFloat(t.getText());
                                        num = num + balance;
                                        String sql = "UPDATE account set balance=?";
                                        PreparedStatement preStmt = null;
                                        try {
                                            preStmt = con.prepareStatement(sql);
                                            preStmt.setFloat(1, num);
                                            preStmt.executeUpdate();
                                            JOptionPane.showMessageDialog(p2, "存款成功", "OK", JOptionPane.INFORMATION_MESSAGE);

                                        } catch (SQLException e1) {
                                            e1.printStackTrace();
                                        }

                                    }
                                });
                                b2.addActionListener(new ActionListener() {
                                    @Override
                                    public void actionPerformed(ActionEvent e) {
                                        p2.setVisible(false);
                                        mainPanel.setVisible(true);
                                    }
                                });
                                p2.add(l);
                                p2.add(t);
                                p2.add(b);
                                p2.add(b2);
                                mainPanel.setVisible(false);
                            }
                        });

                        //取款按钮
                        btn3.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                JPanel p3=new JPanel();
                                mainPanel.setVisible(false);

                                JLabel l=new JLabel("当前可用余额:"+balance+"元，请输入取款金额:");
                                JTextField t=new JTextField(20);

                                float num= Float.parseFloat(t.getText());

                            }
                        });
                    }
                });
            }
        });
    }
}
