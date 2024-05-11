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
        LoadRules loadRules = new LoadRules();
        String[] lines = loadRules.loadTextFromFile(filename);

        int y = 200;
        for (String line : lines) {
            JLabel text = new JLabel(line);
            text.setBounds(100, y, 700, 50);
            text.setFont(new Font("Viner Hand ITC", Font.BOLD, 20));
            text.setForeground(Color.BLACK);
            add(text);
            y += 50;
        }



        setSize(1920,1080);
        setVisible(true);
    }


    public static void main(String[] args) {
        new Rules();
    }
}
