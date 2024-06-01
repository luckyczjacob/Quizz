package quiz.app;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;

/**
 * Třída pro okno zobrazující 5 nejlepších hráčů a jejich skóre.
 */
    public class ScoreboardOkno extends JFrame {
    /**
     * Instance třídy Scoreboard pro získání informací o nejlepších hráčích
      */

        private Scoreboard scoreboard;

        public ScoreboardOkno() {
            setTitle("Nejlepší hráči");
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setSize(400, 300);

            scoreboard = new Scoreboard();
/**
 * Nastavení názvů sloupců tabulky
 */
            String[] jmenaSloupce = {"Jméno", "Skóre"};
            /**
             * Vytvoření modelu pro tabulku s definovanými názvy sloupců
             */
            DefaultTableModel model = new DefaultTableModel(jmenaSloupce, 0);
            JTable table = new JTable(model);

            /**
             * Získání informací o nejlepších hráčích a jejich vložení do tabulky
             */
            List<Scoreboard.Hrac> nejlepsiHraci = scoreboard.ziskejNejlepsiHrace(5);
            for (Scoreboard.Hrac player : nejlepsiHraci) {
                Object[] row = {player.getJmeno(), player.getScore()};
                model.addRow(row);
            }

            JScrollPane scrollPane = new JScrollPane(table);
            getContentPane().add(scrollPane, BorderLayout.CENTER);

            setVisible(true);
        }
    /**
     * Metoda pro spuštění okna zobrazujícího nejlepší hráče.
     * @param args Argumenty příkazové řádky.
     */

        public static void main(String[] args) {
            new ScoreboardOkno();
        }

    }

