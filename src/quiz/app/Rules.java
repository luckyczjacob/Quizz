package quiz.app;

import loadFiles.LoadRules;
import startQuiz.Start;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;



public class Rules extends JFrame implements ActionListener {

    JButton start;
    Font font = new Font("Arial",Font.BOLD,20);

    Rules(){
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        setTitle("Pravidla");


        String filename = "Rules";
        LoadRules loadRules = new LoadRules();
        String[] lines = loadRules.loadTextFromFile(filename);

        int y = 300;
        for (String line : lines) {
            JLabel text = new JLabel(line);
            text.setBounds(600, y, 700, 50);
            text.setFont(font);
            text.setForeground(Color.WHITE);
            add(text);
            y += 50;
        }

        start = new JButton("Vybrat téma");
        start.setBounds(860,600,150,40);
        start.setFont(font);
        start.setBackground(Color.WHITE);
        start.setForeground(Color.BLACK);
        start.addActionListener(this);
        add(start);




        ImageIcon imageIcon = new ImageIcon(ClassLoader.getSystemResource("icons/rules3.png"));
        JLabel icon = new JLabel(imageIcon);
        icon.setBounds(0,0,1920,1080);
        add(icon);





        setSize(1920,1080);
        setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == start){
            setVisible(false);
            new Start();
        }
    }

    public static void main(String[] args) {
        new Rules();
    }
}
