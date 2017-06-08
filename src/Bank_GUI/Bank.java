package Bank_GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * datou on 2017/6/8.
 */
public class Bank {
    public static void main(String[] args) {
        JFrame frame = new JFrame("ATM");
        frame.setLayout(null);
        frame.setSize(350,200);
        frame.setLocation(220,100);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        //panel.setLayout(null);
        frame.add(panel);

        JButton loginbtn = new JButton("µÇÂ¼");
        JButton signupbtn = new JButton("¿ª»§");

        //loginbtn.setLocation(220,10);
        //signupbtn.setLocation(220,40);

        panel.add(loginbtn);
        panel.add(signupbtn);

        loginbtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                loginFrame();
            }
        });

        frame.setResizable(false);
        frame.setVisible(true);
    }

    private static void loginFrame(){
        JFrame loginF = new JFrame("Login");
        loginF.setSize(350,200);
        loginF.setLocation(220,100);

        loginF.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JPanel loginP = new JPanel();
        loginP.setLayout(null);
        loginF.add(loginP);

        JLabel userLabel = new JLabel("ID:");
        userLabel.setBounds(10,20,80,25);
        loginP.add(userLabel);

        JTextField userText = new JTextField(20);
        userText.setBounds(100,20,165,25);
        loginP.add(userText);

        JLabel passwordLabel = new JLabel("Password:");
        passwordLabel.setBounds(10,50,80,25);
        loginP.add(passwordLabel);

        JPasswordField passwordText = new JPasswordField(20);
        passwordText.setBounds(100,50,165,25);
        loginP.add(passwordText);

        JButton loginButton = new JButton("login");
        loginButton.setBounds(10, 80, 80, 25);
        loginP.add(loginButton);

        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username=userText.getText();
                String pwd = new String(passwordText.getPassword());
                check(username,pwd);

            }
        });

        loginF.setResizable(false);
        loginF.setVisible(true);
    }

    private static void check(String username, String pwd){
        JFrame afterLoginF = new JFrame("ATM");
        afterLoginF.setLayout(null);
        afterLoginF.setSize(600,250);
        afterLoginF.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JPanel afterLoginP = new JPanel();

        JButton chaxun=new JButton("²éÑ¯");


        afterLoginF.setVisible(true);
    }
}
