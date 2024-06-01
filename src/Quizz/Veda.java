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
    public  HashMap<Integer, Integer> correctAnswers;
    private JLabel questionLabel;
    private JButton nextButton;
    public JButton[] answerButtons;
    private JLabel timerLabel;


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
        questionLabel.setBounds(400,200,1000,80);
        questionLabel.setFont(new Font("Arial", Font.BOLD, 20));
        questionLabel.setForeground(Color.BLACK);
        add(questionLabel);

        answerButtons = new JButton[4];

        answerButtons[0] = new JButton();
        answerButtons[0].setBounds(150, 400, 400, 100);
        answerButtons[0].setFont(new Font("Arial", Font.BOLD, 20));
        answerButtons[0].setForeground(Color.BLACK);
        answerButtons[0].setBackground(Color.WHITE);
        answerButtons[0].addActionListener(new Metody.ReakceOdpovedi(0, questions, answers, questionLabel, answerButtons, correctAnswers));
        add(answerButtons[0]);

        answerButtons[1] = new JButton();
        answerButtons[1].setBounds(150, 600, 400, 100);
        answerButtons[1].setFont(new Font("Arial", Font.BOLD, 20));
        answerButtons[1].setForeground(Color.BLACK);
        answerButtons[1].setBackground(Color.WHITE);
        answerButtons[1].addActionListener(new Metody.ReakceOdpovedi(1, questions, answers, questionLabel, answerButtons, correctAnswers));
        add(answerButtons[1]);

        answerButtons[2] = new JButton();
        answerButtons[2].setBounds(600, 400, 400, 100);
        answerButtons[2].setFont(new Font("Arial", Font.BOLD, 20));
        answerButtons[2].setForeground(Color.BLACK);
        answerButtons[2].setBackground(Color.WHITE);
        answerButtons[2].addActionListener(new Metody.ReakceOdpovedi(2, questions, answers, questionLabel, answerButtons, correctAnswers));
        add(answerButtons[2]);

        answerButtons[3] = new JButton();
        answerButtons[3].setBounds(600, 600, 400, 100);
        answerButtons[3].setFont(new Font("Arial", Font.BOLD, 20));
        answerButtons[3].setForeground(Color.BLACK);
        answerButtons[3].setBackground(Color.WHITE);
        answerButtons[3].addActionListener(new Metody.ReakceOdpovedi(3, questions, answers, questionLabel, answerButtons, correctAnswers));
        add(answerButtons[3]);


        nextButton = new JButton("Další otázka");
        nextButton.setBounds(460, 820, 250, 70);
        nextButton.setBackground(Color.WHITE);
        nextButton.setForeground(Color.BLACK);

        timerLabel = new JLabel("Čas: 300 sekund");
        timerLabel.setBounds(540, 900, 250, 70);
        add(timerLabel);
        nextButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Metody.showNextQuestion(questions, answers, questionLabel, answerButtons);
            }
        });
        add(nextButton);

        Metody.showNextQuestion(questions, answers, questionLabel, answerButtons);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/pozadi22.jpg"));
        JLabel image = new JLabel(i1);
        image.setBounds(0,0,1920,1080);
        add(image);

        Metody.startTimer(this,timerLabel);
        setVisible(true);
    }


    public static void main(String[] args) {
        new Veda();
    }
}







