package Quizz;

import startQuiz.Start;

import javax.swing.*;
import java.awt.*;

public class Filmy extends JFrame {
    public Filmy() {
        getContentPane().setBackground(Color.CYAN);
        setLayout(null);

        setSize(1920,1080);
        setVisible(true);
    }
    public static void main(String[] args) {
        new Filmy();
    }
}
