package GUI;

import java.awt.*;

/**
 * dt112 on 2017/3/30.
 */
public class TestFrame {
    public static void main(String[] args) {
        Frame f = new Frame("My First Test");
        f.setLocation(300,300);
        f.setSize(170,100);
        f.setBackground(Color.black);
        f.setResizable(false);
        f.setVisible(true);

    }
}
