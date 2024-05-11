package quiz.app;

import javax.swing.*;
import java.awt.*;

public class Rules extends JFrame  {



    Rules(){
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);


        String filename = "Rules";
        LoadRules loadRules = new LoadRules();
        String[] lines = loadRules.loadTextFromFile(filename);

        int y = 300;
        for (String line : lines) {
            JLabel text = new JLabel(line);
            text.setBounds(600, y, 700, 50);
            text.setFont(new Font("Viner Hand ITC", Font.BOLD, 20));
            text.setForeground(Color.WHITE);
            add(text);
            y += 50;
        }


        ImageIcon imageIcon = new ImageIcon(ClassLoader.getSystemResource("icons/rules3.png"));
        JLabel icon = new JLabel(imageIcon);
        icon.setBounds(0,0,1920,1080);
        add(icon);





        setSize(1920,1080);
        setVisible(true);
    }


    public static void main(String[] args) {
        new Rules();
    }
}
