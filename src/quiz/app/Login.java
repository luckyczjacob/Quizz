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


        JLabel heading = new JLabel("QUIZ");
        heading.setBounds(900,150,200,80);
        heading.setFont(new Font("Viner Hand ITC", Font.BOLD, 80));
        heading.setForeground(Color.BLUE);
        add(heading);

        JLabel name = new JLabel("Zadejte jméno");
        name.setBounds(870,300,500,90);
        name.setFont(new Font("Mongolian Baiti", Font.BOLD, 40));
        name.setForeground(Color.BLUE);
        add(name);

        JTextField tfname = new JTextField();
        tfname.setBounds(853,370,275,35);
        tfname.setFont(new Font("Times New Roman", TRUETYPE_FONT,20));
        add(tfname);

        rules = new JButton("Pravidla");
        rules.setBounds(853,430,130,25);
        rules.setFont(new Font("Times New Roman", TRUETYPE_FONT,20));
        rules.setBackground(Color.BLUE);
        rules.setForeground(Color.WHITE);
        rules.addActionListener(this);
        add(rules);

        close = new JButton("Zavřít");
        close.setBounds(997,430,130,25);
        close.setFont(new Font("Times New Roman", TRUETYPE_FONT,20));
        close.setBackground(Color.BLUE);
        close.setForeground(Color.WHITE);
        close.addActionListener(this);
        add(close);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/login4.jpg"));
        JLabel image = new JLabel(i1);
        image.setBounds(0,0,1920,1080);
        add(image);


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
