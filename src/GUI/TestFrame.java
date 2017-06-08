package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * dt112 on 2017/3/30.
 */
public class TestFrame {
    public static void main(String[] args) {
        Frame f = new Frame("My First Test");
        f.setLocation(300,300);
        f.setSize(500,500);
        f.setResizable(false);
        JPanel panel = new JPanel();
        f.add(panel);
        f.setVisible(true);

        Button login = new Button("Login");
        Button signup = new Button("Signup");
        f.add(login);
        f.add(signup);

        login.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Frame f2 = new Frame("Login");
                f2.setLocation(300,300);
                f2.setSize(500,500);
                f2.setLayout(new FlowLayout());
                f2.setResizable(false);
                f2.setVisible(true);

                JLabel name = new JLabel("卡号");
                JLabel pwd = new JLabel("密码");
                JTextField nametext = new JTextField();
                JPasswordField pwdtext = new JPasswordField();
                JButton login = new JButton("Login");
                nametext.setBounds(10,10,50,10);
                pwdtext.setBounds(10,40,50,10);
                f2.add(name);
                f2.add(nametext);
                f2.add(pwd);
                f2.add(pwdtext);
                f2.add(login);

                login.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        //check();
                    }
                });
            }
        });



    }

    public void check(){

    }
}
