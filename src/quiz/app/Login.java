package quiz.app;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;



public class Login extends JFrame implements ActionListener {

    Font font = new Font("Arial",Font.BOLD,40);
    Font font2 = new Font("Arial",Font.BOLD,20);
    JButton rules, close;

    Login(){
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        setTitle("Quiz");
        ImageIcon i = new ImageIcon(ClassLoader.getSystemResource("icons/Logo.png"));
        setIconImage(i.getImage());


        JLabel heading = new JLabel("QUIZ");
        heading.setBounds(850,150,200,80);
        heading.setFont(new Font("Arial", Font.BOLD, 80));
        heading.setForeground(Color.WHITE);
        add(heading);


        JLabel name = new JLabel("Zadejte jméno");
        name.setBounds(810,300,500,90);
        name.setFont(font);
        name.setForeground(Color.WHITE);
        add(name);

        JTextField tfname = new JTextField();
        tfname.setBounds(803,370,275,35);
        tfname.setFont(font2);
        tfname.setForeground(Color.BLUE);
        tfname.setHorizontalAlignment(SwingConstants.CENTER);
        add(tfname);

        rules = new JButton("Start");
        rules.setBounds(803,430,130,25);
        rules.setFont(font2);
        rules.setBackground(Color.BLUE);
        rules.setForeground(Color.WHITE);
        rules.addActionListener(this);
        add(rules);


        close = new JButton("Zavřít");
        close.setBounds(947,430,130,25);
        close.setFont(font2);
        close.setBackground(Color.BLUE);
        close.setForeground(Color.WHITE);
        close.addActionListener(this);
        add(close);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/logi.jpg"));
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
