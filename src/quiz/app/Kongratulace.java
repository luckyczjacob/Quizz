package quiz.app;



import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Kongratulace extends JFrame implements ActionListener {

    JButton scoreboard;
        public Kongratulace(int spravneOdpovedi) {

            setTitle("Gratulace");
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setSize(1920, 1080);
            setLayout(null);

            JLabel label = new JLabel("Gratulujeme! Dokončili jste kvíz.");
            label.setBounds(825,150,400,80);
            label.setForeground(Color.WHITE);
            label.setFont(new Font("Arial", Font.BOLD, 20));
            add(label);

            /**
             * Celkový počet správných odpovědí
             */
            JLabel correctLabel = new JLabel("Získali jste celkem " + spravneOdpovedi + " správných odpovědí.");
            correctLabel.setForeground(Color.WHITE);
            correctLabel.setBounds(800,200,400,80);
            correctLabel.setFont(new Font("Arial", Font.BOLD, 20));
            add(correctLabel);

            /**
             * Tlačítko pro zobrazení skóre
             */
            scoreboard = new JButton("Scoreboard");
            scoreboard.setBounds(760,430,400,100);
            scoreboard.setFont(new Font("Arial", Font.BOLD, 40));
            scoreboard.setBackground(Color.BLUE);
            scoreboard.setForeground(Color.WHITE);
            scoreboard.addActionListener(this);
            add(scoreboard);

            ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/otazky2.jpg"));
            JLabel image = new JLabel(i1);
            image.setBounds(0,0,1920,1080);
            add(image);

            setVisible(true);
        }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == scoreboard){
            setVisible(false);
            new ScoreboardOkno();
        }
    }

}


