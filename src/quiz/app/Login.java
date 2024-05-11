package quiz.app;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static java.awt.Font.TRUETYPE_FONT;

public class Login extends JFrame implements ActionListener {

    JButton rules, close;

    Login(){
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        setTitle("Quiz");
        ImageIcon i = new ImageIcon(ClassLoader.getSystemResource("icons/Logo.png"));
        setIconImage(i.getImage());


        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/login3.jpg"));
        JLabel image = new JLabel(i1);
        image.setBounds(0,0,1000,1080);
        add(image);

        JLabel heading = new JLabel("QUIZ");
        heading.setBounds(1400,200,200,50);
        heading.setFont(new Font("Viner Hand ITC", Font.BOLD, 50));
        heading.setForeground(Color.BLACK);
        add(heading);

        JLabel name = new JLabel("Zadejte jméno");
        name.setBounds(1375,300,300,90);
        name.setFont(new Font("Mongolian Baiti", Font.BOLD, 30));
        name.setForeground(Color.BLACK);
        add(name);

        JTextField tfname = new JTextField();
        tfname.setBounds(1388,380,150,25);
        tfname.setFont(new Font("Times New Roman", TRUETYPE_FONT,20));
        add(tfname);

        rules = new JButton("Pravidla");
        rules.setBounds(1403,430,120,25);
        rules.setFont(new Font("Times New Roman", TRUETYPE_FONT,20));
        rules.setBackground(Color.BLUE);
        rules.setForeground(Color.WHITE);
        rules.addActionListener(this);
        add(rules);

        close = new JButton("Zavřít");
        close.setBounds(1403,460,120,25);
        close.setFont(new Font("Times New Roman", TRUETYPE_FONT,20));
        close.setBackground(Color.BLUE);
        close.setForeground(Color.WHITE);
        close.addActionListener(this);
        add(close);

        setSize(1920,1080);
        setVisible(true);
    }


    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == rules){
            setVisible(false);
            new Rules();
        } else if (ae.getSource() == close){
            setVisible(false);
        }
    }
    public static void main(String[] args) {
        new Login();
    }
}
