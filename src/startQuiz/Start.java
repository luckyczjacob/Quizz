package startQuiz;



import Quizz.*;
import loadFiles.NacistUzivatele;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


/**
 * Třída, kde si uživatel vybírá téma
 */
public class Start extends JFrame implements ActionListener {
    private static String username;
    /**
     * Tlačítka pro výběr témat
     */
    JButton historie, sport, veda, filmy, literatura, geografie;
    Font font = new Font("Bla",Font.BOLD,40);
    public Start() {
        /**
         * Nahrání jména
         */
        username = NacistUzivatele.nacistUzivatel();
        /**
         * Vzhled okna
         */
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        setTitle("Výběr tématu");
        setLayout(new GridLayout(2, 3));

        ImageIcon historieI = new ImageIcon(ClassLoader.getSystemResource("icons/historie.png"));
        historie = new JButton("Historie");
        historie.setBounds(95,170,450,300);
        historie.setFont(font);
        historie.setForeground(Color.WHITE);
        historie.addActionListener(this);
        historie.setHorizontalTextPosition(SwingConstants.CENTER);
        historie.setVerticalTextPosition(SwingConstants.CENTER);
        add(historie);
        historie.setIcon(historieI);

        ImageIcon sportI = new ImageIcon(ClassLoader.getSystemResource("icons/sport.png"));
        sport = new JButton("Sport");
        sport.setBounds(735,170,450,300);
        sport.setFont(font);
        sport.setForeground(Color.WHITE);
        sport.addActionListener(this);
        sport.setHorizontalTextPosition(SwingConstants.CENTER);
        sport.setVerticalTextPosition(SwingConstants.CENTER);
        add(sport);
        sport.setIcon(sportI);

        ImageIcon vedaI = new ImageIcon(ClassLoader.getSystemResource("icons/veda.png"));
        veda = new JButton("Věda");
        veda.setBounds(1375,170,450,300);
        veda.setFont(font);
        veda.setForeground(Color.WHITE);
        veda.addActionListener(this);
        veda.setHorizontalTextPosition(SwingConstants.CENTER);
        veda.setVerticalTextPosition(SwingConstants.CENTER);
        add(veda);
        veda.setIcon(vedaI);

        ImageIcon filmyI = new ImageIcon(ClassLoader.getSystemResource("icons/filmy.png"));
        filmy = new JButton("Filmy");
        filmy.setBounds(95,620,450,300);
        filmy.setFont(font);
        filmy.setForeground(Color.WHITE);
        filmy.addActionListener(this);
        filmy.setHorizontalTextPosition(SwingConstants.CENTER);
        filmy.setVerticalTextPosition(SwingConstants.CENTER);
        add(filmy);
        filmy.setIcon(filmyI);

        ImageIcon literaturaI = new ImageIcon(ClassLoader.getSystemResource("icons/literatura.png"));
        literatura = new JButton("Literatura");
        literatura.setBounds(735,620,450,300);
        literatura.setFont(font);
        literatura.setForeground(Color.WHITE);
        literatura.addActionListener(this);
        literatura.setHorizontalTextPosition(SwingConstants.CENTER);
        literatura.setVerticalTextPosition(SwingConstants.CENTER);
        add(literatura);
        literatura.setIcon(literaturaI);

        ImageIcon geografieI = new ImageIcon(ClassLoader.getSystemResource("icons/geografie.png"));
        geografie = new JButton("Geografie");
        geografie.setBounds(1375,620,450,300);
        geografie.setFont(font);
        geografie.setForeground(Color.WHITE);
        geografie.addActionListener(this);
        geografie.setHorizontalTextPosition(SwingConstants.CENTER);
        geografie.setVerticalTextPosition(SwingConstants.CENTER);
        add(geografie);
        geografie.setIcon(geografieI);

        setSize(1920,1080);
        setVisible(true);
    }





    /**
     * Metoda volaná při stisknutí tlačítka. Otevře nové okno s tématem kvízu.
     * @param ae the event to be processed
     */
    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == historie) {
            setVisible(false);
            new Historie();
        } else if (ae.getSource() == sport) {
            setVisible(false);
            new Sport();
        } else if (ae.getSource() == veda) {
            setVisible(false);
            new Veda();
        } else if (ae.getSource() == filmy) {
            setVisible(false);
            new Filmy();
        } else if (ae.getSource() == literatura) {
            setVisible(false);
            new Literatura();
        } else if (ae.getSource() == geografie) {
            setVisible(false);
            new Geografie();
        }
    }
}
