package GUI;

import java.awt.*;

/**
 * dt112 on 2017/3/30.
 */
public class CenterPanel {
    public static void main(String[] args) {
        new Myframe3(300,300,400,300,Color.BLUE);
    }


}

class Myframe3 extends Frame {
    private Panel p;
    public Myframe3(int x,int y,int w,int h,Color c) {
        super("FrameWithPanel");
        setLayout(null);
        setBounds(x,y,w,h);
        setBackground(c);
        p = new Panel(null);
        p.setBounds(w/4,h/4,w/2,h/2);
        p.setBackground(Color.CYAN);
        add(p);
        setVisible(true);
    }
}
