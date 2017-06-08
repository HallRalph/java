package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * datou on 2017/6/6.
 */
public class Bank {
    private Frame f;
    private Button btn;
    private JRadioButton radioButton1;

    Bank(){}

    public void init(){
        f = new Frame("ATM");
        f.setSize(500,400);
        f.setLocation(300,200);
        f.setLayout(new FlowLayout());
        btn = new Button("abc");

        f.add(btn);
        f.setVisible(true);
    }

    public void myEvent(){
        f.addWindowListener(new WindowAdapter(){
            public void windowClosing(WindowEvent e){
                System.exit(0);
            }
        });
    }

}
