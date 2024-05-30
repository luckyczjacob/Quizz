package Quizz;

import loadFiles.LoadAnswers;
import loadFiles.LoadQuestions;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;

public class Historie extends JFrame {
    private ArrayList<String> questions;
    private int currentQuestionIndex;
    private JLabel questionLabel;
    private JButton nextButton;
    private HashMap<Integer, ArrayList<String>> answers;
    private JButton[] answerButtons;
    private HashMap<Integer,Integer> correctAnswers;
    public Historie() {
        setTitle("Historie");
        setLayout(null);

        String qFilename = "HistorieOtazky";
        questions = LoadQuestions.loadQuestionsFromFile(qFilename);
        questionLabel = new JLabel();
        questionLabel.setBounds(50, 50, 1000, 50);
        add(questionLabel);

        String aFilename = "HistorieOdpovedi";
        answers = LoadAnswers.loadAnswersFromFile(aFilename,correctAnswers);
        answerButtons = new JButton[4];

        answerButtons[0] = new JButton();
        answerButtons[0].setBounds(50, 150, 250, 50);
        add(answerButtons[0]);

        answerButtons[1] = new JButton();
        answerButtons[1].setBounds(350, 150, 250, 50);
        add(answerButtons[1]);

        answerButtons[2] = new JButton();
        answerButtons[2].setBounds(50, 250, 250, 50);
        add(answerButtons[2]);

        answerButtons[3] = new JButton();
        answerButtons[3].setBounds(350, 250, 250, 50);
        add(answerButtons[3]);

        nextButton = new JButton("Další otázka");
        nextButton.setBounds(50, 150, 150, 50);
        nextButton.addActionListener(e -> showNextQuestion());
        add(nextButton);

        showNextQuestion();

       /* ImageIcon pozadi = new ImageIcon(ClassLoader.getSystemResource("icons/pozadi.png"));
        JLabel image = new JLabel(pozadi);
        image.setBounds(0,0,1920,1080);
        add(image);*/

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