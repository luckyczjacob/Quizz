package Quizz;

import loadFiles.LoadAnswers;
import loadFiles.LoadQuestions;
import quiz.app.ReakceOdpovedi;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;

public class Historie extends JFrame {
    private ArrayList<String> questions;
    private HashMap<Integer, ArrayList<String>> answers;
    private HashMap<Integer, Integer> correctAnswers;
    private int currentQuestionIndex;
    private JLabel questionLabel;
    private JButton nextButton;
    public JButton[] answerButtons;
    public int selectedAnswerIndex = -1;

    public Historie() {
        setTitle("Historie");
        getContentPane().setBackground(Color.CYAN);
        setLayout(null);

        setSize(1920, 1080);
        String questionsFilename = "HistorieOtazky";
        String answersFilename = "HistorieOdpovedi";
        questions = LoadQuestions.loadQuestionsFromFile(questionsFilename);
        correctAnswers = new HashMap<>();
        answers = LoadAnswers.loadAnswersFromFile(answersFilename, correctAnswers);

        questionLabel = new JLabel();
        questionLabel.setBounds(50, 50, 1000, 50);
        add(questionLabel);

        answerButtons = new JButton[4];
        answerButtons[0] = new JButton();
        answerButtons[0].setBounds(50, 150, 250, 50);
        answerButtons[0].addActionListener(new ReakceOdpovedi(this,0));
        add(answerButtons[0]);

        answerButtons[1] = new JButton();
        answerButtons[1].setBounds(350, 150, 250, 50);
        answerButtons[1].addActionListener(new ReakceOdpovedi(this,1));
        add(answerButtons[1]);

        answerButtons[2] = new JButton();
        answerButtons[2].setBounds(50, 250, 250, 50);
        answerButtons[2].addActionListener(new ReakceOdpovedi(this,2));
        add(answerButtons[2]);

        answerButtons[3] = new JButton();
        answerButtons[3].setBounds(350, 250, 250, 50);
        answerButtons[3].addActionListener(new ReakceOdpovedi(this,3));
        add(answerButtons[3]);

        nextButton = new JButton("Další otázka");
        nextButton.setBounds(50, 400, 150, 50);
        nextButton.addActionListener(e -> showNextQuestion());
        add(nextButton);

        currentQuestionIndex = 0;
        showNextQuestion();

        setVisible(true);
    }

    private void showNextQuestion() {
        if (currentQuestionIndex < questions.size()) {
            questionLabel.setText(questions.get(currentQuestionIndex));
            ArrayList<String> currentAnswers = answers.get(currentQuestionIndex + 1);
            for (int i = 0; i < 4; i++) {
                answerButtons[i].setText(currentAnswers.get(i));
                answerButtons[i].setEnabled(true);
            }
            selectedAnswerIndex = -1;
        } else {
            JOptionPane.showMessageDialog(this, "Konec kvízu!");
            dispose();
        }
        currentQuestionIndex++;
    }

    public void checkAnswer() {
        if (selectedAnswerIndex != -1) {
            int correctIndex = correctAnswers.get(currentQuestionIndex);
            boolean isCorrect = selectedAnswerIndex == correctIndex;
            if (isCorrect) {
                JOptionPane.showMessageDialog(this, "spravne", "ddd", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(this, "spatne", "sss", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    public static void main(String[] args) {
        new Historie();
    }
}