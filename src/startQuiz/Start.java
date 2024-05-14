package startQuiz;



import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;



public class Start extends JFrame implements ActionListener {

    JButton historie, sport, veda, film, literatura, geografie;
    Font font = new Font("Bla",Font.BOLD,40);
    public Start() {
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


        film = new JButton("Film");
        film.setBounds(95,620,450,300);
        film.setFont(font);
        film.setBackground(Color.WHITE);
        film.setForeground(Color.BLACK);
        film.addActionListener(this);
        film.setHorizontalTextPosition(SwingConstants.CENTER);
        film.setVerticalTextPosition(SwingConstants.CENTER);
        add(film);

        literatura = new JButton("Literatura");
        literatura.setBounds(735,620,450,300);
        literatura.setFont(font);
        literatura.setBackground(Color.WHITE);
        literatura.setForeground(Color.BLACK);
        literatura.addActionListener(this);
        literatura.setHorizontalTextPosition(SwingConstants.CENTER);
        literatura.setVerticalTextPosition(SwingConstants.CENTER);
        add(literatura);

        geografie = new JButton("Geografie");
        geografie.setBounds(1375,620,450,300);
        geografie.setFont(font);
        geografie.setBackground(Color.WHITE);
        geografie.setForeground(Color.BLACK);
        geografie.addActionListener(this);
        geografie.setHorizontalTextPosition(SwingConstants.CENTER);
        geografie.setVerticalTextPosition(SwingConstants.CENTER);
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
