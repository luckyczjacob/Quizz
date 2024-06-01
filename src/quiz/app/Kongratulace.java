package quiz.app;


import Quizz.Historie;

import javax.swing.*;
import java.awt.*;

public class Kongratulace extends JFrame {

        public Kongratulace(int totalCorrectAnswers) {
            setTitle("Gratulace");
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setSize(1920, 1080);
            setLayout(null);

            JLabel label = new JLabel("Gratulujeme! Dokončili jste kvíz.");
            label.setBounds(850,150,400,80);
            label.setForeground(Color.WHITE);
            label.setFont(new Font("Arial", Font.BOLD, 20));
            add(label);

            JLabel correctLabel = new JLabel("Získali jste celkem " + totalCorrectAnswers + " správných odpovědí.");
            correctLabel.setForeground(Color.WHITE);
            correctLabel.setBounds(800,200,400,80);
            correctLabel.setFont(new Font("Arial", Font.BOLD, 20));
            add(correctLabel);

            ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/otazky2.jpg"));
            JLabel image = new JLabel(i1);
            image.setBounds(0,0,1920,1080);
            add(image);

            setVisible(true);
        }

    }


