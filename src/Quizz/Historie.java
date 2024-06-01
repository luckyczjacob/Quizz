package Quizz;

import loadFiles.NacistOdpovedi;
import loadFiles.NacistOtazky;
import quiz.app.Metody;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Třída s tématem věda
 */
public class Historie extends JFrame {
    /**
     * Seznam otázek
     */
    private ArrayList<String> otazky;
    /**
     * Mapa která uchovává odpovědi na otázky
     */
    private HashMap<Integer, ArrayList<String>> odpovedi;
    /**
     * Mapa která uchovává správné odpovědi na otázky
     */
    public  HashMap<Integer, Integer> spravneOdpovedi;
    private JLabel otazkyText;
    private JButton dalsiOtazka;
    /**
     * Pole tlačítek pro odpovědi
     */
    public JButton[] tlacitkaOdpovedi;
    /**
     * Zobrazení času
     */
    private JLabel cas;


    public Historie() {
        setTitle("Historie");
        getContentPane().setBackground(Color.CYAN);
        setLayout(null);

        setSize(1920, 1080);
        String otazkySoubor = "HistorieOtazky";
        String odpovediSoubor = "HistorieOdpovedi";
        otazky = NacistOtazky.nacistOtazkyZeSouboru(otazkySoubor);
        spravneOdpovedi = new HashMap<>();
        odpovedi = NacistOdpovedi.loadAnswersFromFile(odpovediSoubor, spravneOdpovedi);

        otazkyText = new JLabel();
        otazkyText.setBounds(400,200,1000,80);
        otazkyText.setFont(new Font("Arial", Font.BOLD, 20));
        otazkyText.setForeground(Color.BLACK);
        add(otazkyText);

        tlacitkaOdpovedi = new JButton[4];

        tlacitkaOdpovedi[0] = new JButton();
        tlacitkaOdpovedi[0].setBounds(150, 400, 400, 100);
        tlacitkaOdpovedi[0].setFont(new Font("Arial", Font.BOLD, 20));
        tlacitkaOdpovedi[0].setForeground(Color.BLACK);
        tlacitkaOdpovedi[0].setBackground(Color.WHITE);
        tlacitkaOdpovedi[0].addActionListener(new Metody.ReakceOdpovedi(0, otazky, odpovedi, otazkyText, tlacitkaOdpovedi, spravneOdpovedi));
        add(tlacitkaOdpovedi[0]);

        tlacitkaOdpovedi[1] = new JButton();
        tlacitkaOdpovedi[1].setBounds(150, 600, 400, 100);
        tlacitkaOdpovedi[1].setFont(new Font("Arial", Font.BOLD, 20));
        tlacitkaOdpovedi[1].setForeground(Color.BLACK);
        tlacitkaOdpovedi[1].setBackground(Color.WHITE);
        tlacitkaOdpovedi[1].addActionListener(new Metody.ReakceOdpovedi(1, otazky, odpovedi, otazkyText, tlacitkaOdpovedi, spravneOdpovedi));
        add(tlacitkaOdpovedi[1]);

        tlacitkaOdpovedi[2] = new JButton();
        tlacitkaOdpovedi[2].setBounds(600, 400, 400, 100);
        tlacitkaOdpovedi[2].setFont(new Font("Arial", Font.BOLD, 20));
        tlacitkaOdpovedi[2].setForeground(Color.BLACK);
        tlacitkaOdpovedi[2].setBackground(Color.WHITE);
        tlacitkaOdpovedi[2].addActionListener(new Metody.ReakceOdpovedi(2, otazky, odpovedi, otazkyText, tlacitkaOdpovedi, spravneOdpovedi));
        add(tlacitkaOdpovedi[2]);

        tlacitkaOdpovedi[3] = new JButton();
        tlacitkaOdpovedi[3].setBounds(600, 600, 400, 100);
        tlacitkaOdpovedi[3].setFont(new Font("Arial", Font.BOLD, 20));
        tlacitkaOdpovedi[3].setForeground(Color.BLACK);
        tlacitkaOdpovedi[3].setBackground(Color.WHITE);
        tlacitkaOdpovedi[3].addActionListener(new Metody.ReakceOdpovedi(3, otazky, odpovedi, otazkyText, tlacitkaOdpovedi, spravneOdpovedi));
        add(tlacitkaOdpovedi[3]);


        dalsiOtazka = new JButton("Další otázka");
        dalsiOtazka.setBounds(460, 820, 250, 70);
        dalsiOtazka.setBackground(Color.WHITE);
        dalsiOtazka.setForeground(Color.BLACK);

        /**
         * Zobrazení času
         */
        cas = new JLabel("Čas: 300 sekund");
        cas.setBounds(540, 900, 250, 70);
        add(cas);
        dalsiOtazka.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Metody.dalsiOtazka(otazky, odpovedi, otazkyText, tlacitkaOdpovedi);
            }
        });
        add(dalsiOtazka);

        Metody.dalsiOtazka(otazky, odpovedi, otazkyText, tlacitkaOdpovedi);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/pozadi22.jpg"));
        JLabel image = new JLabel(i1);
        image.setBounds(0,0,1920,1080);
        add(image);

        /**
         * Spuštění času
         */
        Metody.spustitCasovac(this, cas);
        setVisible(true);
    }



}