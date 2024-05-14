package Quizz;

import loadFiles.LoadQuestions;

import javax.swing.*;
import java.awt.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Historie extends JFrame {
    private ArrayList<String> questions;
    private int currentQuestionIndex;
    private JLabel questionLabel;
    private JButton nextButton;

    public Historie() {
        setTitle("Historie");
        getContentPane().setBackground(Color.CYAN);
        setLayout(null);

        String filename = "Historie";
        questions = LoadQuestions.loadQuestionsFromFile(filename);

        questionLabel = new JLabel();
        questionLabel.setBounds(50, 50, 1000, 50);
        add(questionLabel);

        nextButton = new JButton("Další otázka");
        nextButton.setBounds(50, 150, 150, 50);
        nextButton.addActionListener(e -> showNextQuestion());
        add(nextButton);

        showNextQuestion();

        setSize(1920, 1080);
        setVisible(true);
    }

    private void showNextQuestion() {
        if (currentQuestionIndex < questions.size()) {
            questionLabel.setText(questions.get(currentQuestionIndex));
            currentQuestionIndex++;
            if (currentQuestionIndex == questions.size()) {
                nextButton.setText("Konec kvízu");
                nextButton.setEnabled(false);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Konec kvízu!");

        }
    }

    public static void main(String[] args) {
        new Historie();
    }
}