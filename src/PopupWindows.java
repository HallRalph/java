import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PopupWindows{
    JFrame mainWindow;
    public PopupWindows(){
        mainWindow = new JFrame("ATM");
        mainWindow.setSize(500,500);
        mainWindow.setLocation(400,500);
        //mainWindow.setBounds(10,10,10,10);
        JButton JB = new JButton("登录");
        JButton JB2 = new JButton("开户");
        JB.addActionListener(new creatNewWindow());
        mainWindow.setVisible(true);
        mainWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainWindow.add(JB);
        mainWindow.pack();
    }

    void newwindows(){
        mainWindow = new JFrame("登录");
        //mainWindow.setBounds(10,10,10,10);
        JButton JB = new JButton("login");
        mainWindow.setVisible(true);
        mainWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainWindow.add(JB);
        mainWindow.pack();
    }

    class creatNewWindow implements ActionListener {
        public void actionPerformed(ActionEvent e){
            newwindows();
        }
    }
    public static void main(String[] args){
        new PopupWindows();
    }
}