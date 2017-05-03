package study;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

/**
 * dt112 on 2017/4/12.
 */
public class test {
    public static void main(String[] args) {
        JFrame f=new JFrame();
        f.setTitle("学生信息管理系统");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setSize(400,300);
        f.setLocation(200,200);
        Container con=f.getContentPane();
        JPanel pan=new JPanel();

        JLabel l_ah= new JLabel("爱好");
        final JCheckBox chkApple = new JCheckBox("Apple");
        final JCheckBox chkMango = new JCheckBox("Mango");
        final JCheckBox chkPeer = new JCheckBox("Peer");
        final JButton sub=new JButton("提交");

        JTextField res=new JTextField(20);

        sub.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                res.setText("abc");
                if(chkApple.isSelected())
                    res.setText(res.getText()+","+chkApple.getText());
                if(chkMango.isSelected())
                    res.setText(res.getText()+","+chkMango.getText());
                if(chkPeer.isSelected())
                    res.setText(res.getText()+","+chkPeer.getText());
            }
        });

        pan.add(l_ah);
        pan.add(chkApple);
        pan.add(chkMango);
        pan.add(chkPeer);
        pan.add(sub);
        pan.add(res);
        con.add(pan);
        f.setVisible(true);
    }
}
