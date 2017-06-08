package Bank_GUI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * datou on 2017/6/8.
 */
public class test2 {
    public static void main(String[] args) {
        JFrame f = new JFrame("Test");
        f.setSize(500,500);
        f.setLocation(710,290);

        JPanel p = new JPanel();
        JLabel txt1=new JLabel("p1");
        JButton btn1=new JButton("btn1");
        p.add(txt1);p.add(btn1);
        p.setVisible(true);
        f.add(p);
        f.setVisible(true);
        btn1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JPanel p2=new JPanel();
                JLabel txt2=new JLabel("p2");
                JButton btn2=new JButton("btn2");
                p2.add(txt2);p2.add(btn2);
                f.add(p2);
                p.setVisible(false);
                btn2.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        p.setVisible(true);
                        p2.setVisible(false);
                    }
                });
            }
        });
    }
}
