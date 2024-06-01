package quiz.app;

import loadFiles.NacistPravidla;
import startQuiz.Start;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;



public class Pravidla extends JFrame implements ActionListener {

    JButton start;
    Font font = new Font("Arial",Font.BOLD,20);

    Pravidla(){
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        setTitle("Pravidla");

        String nazevSouboru = "Pravidla";
        /**
         * Metoda, která načte text ze souboru "Pravidla"
         */
        NacistPravidla loadRules = new NacistPravidla();
        String[] radky = loadRules.loadTextFromFile(nazevSouboru);

        /**
         * Oddělování každé řádky ze souboru
         */
        int y = 300;
        for (String line : radky) {
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
        new Pravidla();
    }
}
