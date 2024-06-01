package quiz.app;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Scoreboard {
    /**
     * Seznam hráčů se skóre
     */
    private List<Hrac> players;

    public Scoreboard() {
        players = new ArrayList<>();
        cteniSkoreZeSouboru("uzivatel.txt");
        serazeniPodleSkore();
    }

    /**
     * Metoda pro čtení skóre hráčů ze souboru
     * @param filename Název souboru, ze kterého se čte skóre hráčů
     */
    private void cteniSkoreZeSouboru(String filename) {
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split("\\s+");
                if (parts.length == 2) {
                    String name = parts[0];
                    int score = Integer.parseInt(parts[1]);
                    players.add(new Hrac(name, score));
                }
            }
        } catch (IOException | NumberFormatException e) {
            e.printStackTrace();
        }
    }

    /**
     * Metoda pro seřazení hráčů podle skóre sestupně
     */
    private void serazeniPodleSkore() {
        Collections.sort(players, Comparator.comparingInt(Hrac::getScore).reversed());
    }

    /**
     *  Metoda pro získání nejlepších hráčů podle počtu
     * @param count  Metoda pro získání nejlepších hráčů podle počtu
     * @return Seznam nejlepších hráčů podle zadaného počtu
     */
    public List<Hrac> ziskejNejlepsiHrace(int count) {
        return players.subList(0, Math.min(count, players.size()));
    }

    /**
     * Statická vnitřní třída pro hráče.
     */
    public static class Hrac {
        private String jmeno;
        private int score;

        public Hrac(String name, int score) {
            this.jmeno = name;
            this.score = score;
        }

        /**
         * Metoda pro získání jména hráče.
         * @return Jméno hráče.
         */
        public String getJmeno() {
            return jmeno;
        }

        /**
         * Metoda pro získání skóre hráče.
         * @return Skóre hráče.
         */
        public int getScore() {
            return score;
        }
    }
}
