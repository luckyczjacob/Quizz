package quiz.app;

import loadFiles.UlozitSkore;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;

public class Metody {
    /**
     * Index aktuální otázky
     */
    private static int indexAktualniOtazky = 0;
    /**
     * Index vybrané odpovědi
     */
    private static int indexVybraneOdpovedi = -1;
    /**
     * Celkový počet správných odpovědí
     */
    public static int pocetSpravnychOdpovedi = 0;
    private static Timer casovac;
    private static JLabel casText;

    /**
     * Metoda pro zobrazení další otázky
     * @param otazky Seznam otázek
     * @param odpovedi Mapa odpovědí na otázky
     * @param otazkyText Popisek pro otázku
     * @param tlacitkaOdpovedi Pole tlačítek pro odpovědi
     */
    public static void dalsiOtazka(ArrayList<String> otazky, HashMap<Integer, ArrayList<String>> odpovedi, JLabel otazkyText, JButton[] tlacitkaOdpovedi) {
        /**
         * Kontrola, aby uživatel nemohl proklikat kvíz, musí odpovědět
         */
        if (indexVybraneOdpovedi == -1 && indexAktualniOtazky > 0) {
            JOptionPane.showMessageDialog(null, "Musíte vybrat odpověď!", "Chyba", JOptionPane.ERROR_MESSAGE);
            return;
        }
        /**
         * Zobrazí další otázku, pokud ještě nějaká zbývá
         */
        if (indexAktualniOtazky < otazky.size()) {
            otazkyText.setText(otazky.get(indexAktualniOtazky));
            ArrayList<String> currentAnswers = odpovedi.get(indexAktualniOtazky + 1);
            for (int i = 0; i < tlacitkaOdpovedi.length; i++) {
                tlacitkaOdpovedi[i].setText(currentAnswers.get(i));
                tlacitkaOdpovedi[i].setEnabled(true);
            }
            indexVybraneOdpovedi = -1;
        } else {
            /**
             * Zastavení časovače a zpráva o konci
             */
            casovac.stop();
            JOptionPane.showMessageDialog(null, "Odpověděli jste na všechny otázky.", "Konec kvízu", JOptionPane.INFORMATION_MESSAGE);
            UlozitSkore.ulozit(pocetSpravnychOdpovedi);
            zastavitCasovac();
            new Kongratulace(pocetSpravnychOdpovedi);
        }
        indexAktualniOtazky++;
    }

    /**
     * Metoda pro kontrolu správnosti odpovědi
     * @param spravneOdpovedi Mapa správných odpovědí na otázky
     * @param indexAktualniOtazky Index aktuální otázky
     * @param indexVybraneOdpovedi Index vybrané odpovědi
     * @param odpovedi Mapa odpovědí na otázky
     */
    public static void kontrolaOdpovedi(HashMap<Integer, Integer> spravneOdpovedi, int indexAktualniOtazky, int indexVybraneOdpovedi, HashMap<Integer, ArrayList<String>> odpovedi) {
        if (indexVybraneOdpovedi != -1) {
            int correctIndex = spravneOdpovedi.get(indexAktualniOtazky);
            boolean isCorrect = indexVybraneOdpovedi == correctIndex;
            if (isCorrect) {
                JOptionPane.showMessageDialog(null, "Správně!" ,  "Jeej", JOptionPane.INFORMATION_MESSAGE);
                Metody.pocetSpravnychOdpovedi++;
            } else {
                JOptionPane.showMessageDialog(null, "Špatně! Správná odpověď: " + odpovedi.get(indexAktualniOtazky ).get(correctIndex),"Oops", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    /**
     * Vnitřní třída pro  události po kliknutí na tlačítko odpovědi
     */
    public static class ReakceOdpovedi implements ActionListener {
        private int index;
        private ArrayList<String> otazky;
        private HashMap<Integer, ArrayList<String>> odpovedi;
        private JLabel otazkyText;
        private JButton[] opovediTlacitka;
        private HashMap<Integer, Integer> spravneOdpovedi;

        /**
         * Konstruktor třídy ReakceOdpovedi
         * @param index Index vybrané odpovědi
         * @param otazky Seznam otázek
         * @param odpovedi Mapa odpovědí na otázky
         * @param otazkyText Popisek pro otázku
         * @param odpovedtTlacitka Pole tlačítek pro odpovědi
         * @param spravneOdpovedi Mapa správných odpovědí na otázky
         */
        public ReakceOdpovedi(int index, ArrayList<String> otazky, HashMap<Integer, ArrayList<String>> odpovedi, JLabel otazkyText, JButton[] odpovedtTlacitka, HashMap<Integer, Integer> spravneOdpovedi) {
            this.index = index;
            this.otazky = otazky;
            this.odpovedi = odpovedi;
            this.otazkyText = otazkyText;
            this.opovediTlacitka = odpovedtTlacitka;
            this.spravneOdpovedi = spravneOdpovedi;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            setIndexVybraneOdpovedi(index);
            for (JButton button : opovediTlacitka) {
                button.setEnabled(false);
            }
            kontrolaOdpovedi(spravneOdpovedi, indexAktualniOtazky, indexVybraneOdpovedi, odpovedi);
        }
    }

    public static void spustitCasovac(JFrame frame, JLabel label) {
        casText = label;
        casovac = new Timer(1000, new ActionListener() {
            int remainingTime = 300;

            @Override
            public void actionPerformed(ActionEvent e) {
                remainingTime--;
                if (remainingTime >= 0) {
                    casText.setText("Čas: " + remainingTime + " sekund");
                } else {
                    zastavitCasovac();
                    JOptionPane.showMessageDialog(frame, "Čas vypršel!", "Konec kvízu", JOptionPane.INFORMATION_MESSAGE);
                    UlozitSkore.ulozit(pocetSpravnychOdpovedi);
                    new Kongratulace(pocetSpravnychOdpovedi);
                }
            }
        });
        casovac.start();
    }
    public static void zastavitCasovac() {
        if (casovac != null && casovac.isRunning()) {
            casovac.stop();
        }
    }


    public static void setIndexVybraneOdpovedi(int index) {
        indexVybraneOdpovedi = index;
    }
}