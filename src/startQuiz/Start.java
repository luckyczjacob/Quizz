package startQuiz;

import quiz.app.Rules;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static java.awt.Font.TRUETYPE_FONT;

public class Start extends JFrame implements ActionListener {

    JButton historie, sport, věda, film, literatura, geografie;
    public Start() {
        getContentPane().setBackground(Color.CYAN);
        setLayout(null);

        JLabel text = new JLabel("Vyberte si téma.");
        text.setBounds(930,200,130,25);
        text.setFont(new Font("Times New Roman", TRUETYPE_FONT,20));
        text.setForeground(Color.BLACK);
        text.setBackground(Color.WHITE);
        add(text);

        historie = new JButton("Start");
        historie.setBounds(890,600,130,25);
        historie.setFont(new Font("Times New Roman", TRUETYPE_FONT,20));
        historie.setBackground(Color.WHITE);
        historie.setForeground(Color.BLACK);
        historie.addActionListener(this);
        add(historie);

        sport = new JButton("Start");
        sport.setBounds(890,600,130,25);
        sport.setFont(new Font("Times New Roman", TRUETYPE_FONT,20));
        sport.setBackground(Color.WHITE);
        sport.setForeground(Color.BLACK);
        sport.addActionListener(this);
        add(sport);

        věda = new JButton("Start");
        věda.setBounds(890,600,130,25);
        věda.setFont(new Font("Times New Roman", TRUETYPE_FONT,20));
        věda.setBackground(Color.WHITE);
        věda.setForeground(Color.BLACK);
        věda.addActionListener(this);
        add(věda);

        film = new JButton("Start");
        film.setBounds(890,600,130,25);
        film.setFont(new Font("Times New Roman", TRUETYPE_FONT,20));
        film.setBackground(Color.WHITE);
        film.setForeground(Color.BLACK);
        film.addActionListener(this);
        add(film);

        literatura = new JButton("Start");
        literatura.setBounds(890,600,130,25);
        literatura.setFont(new Font("Times New Roman", TRUETYPE_FONT,20));
        literatura.setBackground(Color.WHITE);
        literatura.setForeground(Color.BLACK);
        literatura.addActionListener(this);
        add(literatura);

        geografie = new JButton("Start");
        geografie.setBounds(890,600,130,25);
        geografie.setFont(new Font("Times New Roman", TRUETYPE_FONT,20));
        geografie.setBackground(Color.WHITE);
        geografie.setForeground(Color.BLACK);
        geografie.addActionListener(this);
        add(geografie);



        setSize(1920,1080);
        setVisible(true);

    }

    public static void main(String[] args) {
        new Start();
    }

    @Override
    public void actionPerformed(ActionEvent ae) {

    }
}
