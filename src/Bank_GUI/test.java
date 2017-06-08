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
    private static String url = "jdbc:mysql://localhost:3306/test";//�������ݿ��url��test�����Լ���һ�����ݿⰡ�����ǡ�
    private static String user = "root";//mysql��¼��
    private static String pass = "123456";//mysql��¼����
    private static Connection con;//
    private static float balance;


    public static void main(String[] args) throws ClassNotFoundException, SQLException {


        Class.forName("com.mysql.jdbc.Driver");
        con = DriverManager.getConnection(url, user, pass);

        final JFrame[] f = {new JFrame("Test")};
        f[0].setSize(500, 500);
        f[0].setLocation(710, 290);

        JPanel p = new JPanel();

        JButton btn1 = new JButton("��¼");
        JButton btn2 = new JButton("����");
        p.add(btn1);
        p.add(btn2);
        p.setVisible(true);
        f[0].add(p);
        f[0].setVisible(true);

        //�����¼��ť
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

                JButton btn = new JButton("ȷ��");
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
                            //�ӵ�¼�û��������˺�����������ѯ�����ݿ�����Ƿ������ͬ���˺�����
                            if (rs.next()) {
                                balance = rs.getFloat("balance");
                                p2.setVisible(false);
                                mainPanel.setVisible(true);
                            } else {
                                //��¼��Ϣ����
                                JOptionPane.showMessageDialog(p2, "��Ϣ����", "title", JOptionPane.WARNING_MESSAGE);
                                nameText.setText("");
                                pwdText.setText("");
                                p2.setVisible(true);
                            }
                        } catch (SQLException e1) {
                            e1.printStackTrace();
                        }


                        JButton btn1 = new JButton("��ѯ");
                        JButton btn2 = new JButton("���");
                        JButton btn3 = new JButton("ȡ��");
                        JButton btn4 = new JButton("ת��");
                        JButton btn5 = new JButton("����");
                        JButton btn6 = new JButton("����");
                        JButton btn7 = new JButton("�˿�");
                        JButton btn8 = new JButton("����");
                        mainPanel.add(btn1);
                        mainPanel.add(btn2);
                        mainPanel.add(btn3);
                        mainPanel.add(btn4);
                        mainPanel.add(btn5);
                        mainPanel.add(btn6);
                        mainPanel.add(btn7);
                        mainPanel.add(btn8);
                        f[0].add(mainPanel);

                        //��ѯ��ť
                        btn1.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {

                                JPanel p1 = new JPanel();

                                String sql = "select * from account where card_id=10000";
                                try {
                                    PreparedStatement ptmt = con.prepareStatement(sql);
                                    ResultSet rs = ptmt.executeQuery();
                                    if (rs.next()) {
                                        JLabel l = new JLabel("��ǰ���:" + rs.getFloat("balance") + "Ԫ");
                                        p1.add(l);
                                        f[0].add(p1);
                                        mainPanel.setVisible(false);
                                        JButton btn = new JButton("����");
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

                        //��ť
                        btn2.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                JPanel p2 = new JPanel();
                                JLabel l = new JLabel("����������:");
                                JTextField t = new JTextField(20);
                                JButton b = new JButton("ȷ��");
                                JButton b2 = new JButton("����");
                                f[0].add(p2);
                                //ȷ�ϴ��
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
                                            JOptionPane.showMessageDialog(p2, "���ɹ�", "OK", JOptionPane.INFORMATION_MESSAGE);

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

                        //ȡ�ť
                        btn3.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                JPanel p3=new JPanel();
                                mainPanel.setVisible(false);

                                JLabel l=new JLabel("��ǰ�������:"+balance+"Ԫ��������ȡ����:");
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
