package quiz.app;





import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;


public class Prihlaseni extends JFrame implements ActionListener {
    JTextField jmeno = new JTextField();

    Font font = new Font("Arial",Font.BOLD,40);
    Font font2 = new Font("Arial",Font.BOLD,20);
    JButton pravidla, zavrit;

    public Prihlaseni(){
/**
 * Nastavení vzhledu okna
 */
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        setTitle("Quiz");
        ImageIcon i = new ImageIcon(ClassLoader.getSystemResource("icons/Logo.png"));
        setIconImage(i.getImage());


        JLabel nadpis = new JLabel("QUIZ");
        nadpis.setBounds(850,150,200,80);
        nadpis.setFont(new Font("Arial", Font.BOLD, 80));
        nadpis.setForeground(Color.WHITE);
        add(nadpis);


        JLabel jmenoText = new JLabel("Zadejte jméno");
        jmenoText.setBounds(810,300,500,90);
        jmenoText.setFont(font);
        jmenoText.setForeground(Color.WHITE);
        add(jmenoText);


        jmeno.setBounds(803,370,275,35);
        jmeno.setFont(font2);
        jmeno.setForeground(Color.BLUE);
        jmeno.setHorizontalAlignment(SwingConstants.CENTER);
        add(jmeno);

        pravidla = new JButton("Start");
        pravidla.setBounds(803,430,130,25);
        pravidla.setFont(font2);
        pravidla.setBackground(Color.BLUE);
        pravidla.setForeground(Color.WHITE);
        pravidla.addActionListener(this);
        add(pravidla);


        zavrit = new JButton("Zavřít");
        zavrit.setBounds(947,430,130,25);
        zavrit.setFont(font2);
        zavrit.setBackground(Color.BLUE);
        zavrit.setForeground(Color.WHITE);
        zavrit.addActionListener(this);
        add(zavrit);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/logi.jpg"));
        JLabel image = new JLabel(i1);
        image.setBounds(0,0,1920,1080);
        add(image);


        setSize(1920,1080);
        setVisible(true);
    }

    /**
     * Metoda, která nás hodí na další okno nebo vypne program, potom, co stiskneme tlačítko
     * @param ae the event to be processed
     */
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == pravidla){
            String username = jmeno.getText();
            if (username.isEmpty()) {
                /**
                 * Pokud není jmeno zadané, objeví se tento text.
                 */
                JOptionPane.showMessageDialog(null, "Zadejte prosím své jméno.", "Chyba", JOptionPane.ERROR_MESSAGE);
            } else {
                /**
                 * Uloží se jméno a otevře se jmeno s pravidly
                 */
                SaveUsername.save(username);
                setVisible(false);
                new Pravidla();
            }
        } else if (ae.getSource() == zavrit){
            setVisible(false);
        }
    }


    /**
     * Statická vnitřní třída, která ukládá jméno uživatele do souboru
     */
    static class SaveUsername {
        public static void save(String username) {
            File file = new File("uzivatel.txt");
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(file, true))) {
                writer.write(username + " ");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


}
