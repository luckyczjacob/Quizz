package quiz.app;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Login extends JFrame implements ActionListener {

    JButton rules, back;

    Login(){
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/login.jpg"));
        JLabel image = new JLabel(i1);
        image.setBounds(0,0,1920,1080);
        add(image);

        setSize(1920,1080);
        setVisible(true);
    }











    public void actionPerformed(ActionEvent ae) {

    }
    public static void main(String[] args) {
        new Login();
    }
}
