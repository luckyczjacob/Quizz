package quiz.app;

import javax.swing.*;
import java.awt.*;

public class Rules extends JFrame  {



    Rules(){
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        JLabel heading = new JLabel("PRAVIDLA");
        heading.setBounds(880,20,700,50);
        heading.setFont(new Font("Viner Hand ITC", Font.BOLD, 50));
        heading.setForeground(Color.BLACK);
        add(heading);

        String filename = "Rules";

        JLabel text = new JLabel(LoadRules.loadTextFromFile(filename));
        text.setBounds(880,200,700,50);
        text.setFont(new Font("Viner Hand ITC", Font.BOLD, 20));
        text.setForeground(Color.BLACK);
        add(text);

        setSize(1920,1080);
        setVisible(true);
    }


    public static void main(String[] args) {
        new Rules();
    }
}
