package GUI;

import java.awt.*;

/**
 * datou on 2017/6/6.
 */
public class Bank {
    public static void main(String[] args) {
        Frame f = new Frame("My Frame with Panel");
        Panel p = new Panel(null);
        f.setLayout(null);
        f.setBounds(300,300,500,500);
        f.setBackground(new Color(0,0,102));
        p.setBounds(50,50,400,400);
        p.setBackground(new Color(204,204,255));
        f.add(p);
        f.setVisible(true);
    }
}
