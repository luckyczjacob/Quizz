package Quizz;

import loadFiles.LoadAnswers;
import loadFiles.LoadQuestions;
import quiz.app.Metody;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;

public class Veda extends JFrame {
    private ArrayList<String> questions;
    private HashMap<Integer, ArrayList<String>> answers;
    public static HashMap<Integer, Integer> correctAnswers;
    private JLabel questionLabel;
    private JButton nextButton;
    public static JButton[] answerButtons;


    public Veda() {
        setTitle("Věda");
        getContentPane().setBackground(Color.CYAN);
        setLayout(null);

        setSize(1920, 1080);
        String questionsFilename = "VedaOtazky";
        String answersFilename = "VedaOdpovedi";
        questions = LoadQuestions.loadQuestionsFromFile(questionsFilename);
        correctAnswers = new HashMap<>();
        answers = LoadAnswers.loadAnswersFromFile(answersFilename, correctAnswers);

        questionLabel = new JLabel();
        questionLabel.setBounds(50, 50, 1000, 50);
        add(questionLabel);

        answerButtons = new JButton[4];
        answerButtons[0] = new JButton();
        answerButtons[0].setBounds(50, 150, 250, 50);
        answerButtons[0].addActionListener(new Metody.ReakceOdpovedi(0, questions, answers, questionLabel, answerButtons, correctAnswers));
        add(answerButtons[0]);

        answerButtons[1] = new JButton();
        answerButtons[1].setBounds(350, 150, 250, 50);
        answerButtons[1].addActionListener(new Metody.ReakceOdpovedi(1, questions, answers, questionLabel, answerButtons, correctAnswers));
        add(answerButtons[1]);

        answerButtons[2] = new JButton();
        answerButtons[2].setBounds(50, 250, 250, 50);
        answerButtons[2].addActionListener(new Metody.ReakceOdpovedi(2, questions, answers, questionLabel, answerButtons, correctAnswers));
        add(answerButtons[2]);

        answerButtons[3] = new JButton();
        answerButtons[3].setBounds(350, 250, 250, 50);
        answerButtons[3].addActionListener(new Metody.ReakceOdpovedi(3, questions, answers, questionLabel, answerButtons, correctAnswers));
        add(answerButtons[3]);

        nextButton = new JButton("Další otázka");
        nextButton.setBounds(50, 400, 150, 50);
        nextButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Metody.showNextQuestion(questions, answers, questionLabel, answerButtons);
            }
        });
        add(nextButton);

        Metody.showNextQuestion(questions, answers, questionLabel, answerButtons);


        setVisible(true);
    }


    public static void main(String[] args) {
        new Veda();
    }
}







