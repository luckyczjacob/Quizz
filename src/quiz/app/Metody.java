package quiz.app;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;

public class Metody {
    private static int currentQuestionIndex = 0;
    private static int selectedAnswerIndex = -1;

    public static void showNextQuestion(ArrayList<String> questions, HashMap<Integer, ArrayList<String>> answers, JLabel questionLabel, JButton[] answerButtons) {
        if (currentQuestionIndex < questions.size()) {
            questionLabel.setText(questions.get(currentQuestionIndex));
            ArrayList<String> currentAnswers = answers.get(currentQuestionIndex + 1);
            for (int i = 0; i < answerButtons.length; i++) {
                answerButtons[i].setText(currentAnswers.get(i));
                answerButtons[i].setEnabled(true);
            }
            selectedAnswerIndex = -1;
        } else {
            JOptionPane.showMessageDialog(null, "Konec kvízu!");
            System.exit(0);
        }
        currentQuestionIndex++;
    }

    public static void checkAnswer(HashMap<Integer, Integer> correctAnswers, int currentQuestionIndex, int selectedAnswerIndex) {
        if (selectedAnswerIndex != -1) {
            int correctIndex = correctAnswers.get(currentQuestionIndex - 1); // -1 because currentQuestionIndex was incremented in showNextQuestion
            boolean isCorrect = selectedAnswerIndex == correctIndex;
            if (isCorrect) {
                JOptionPane.showMessageDialog(null, "Správně", "Jeej", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "Špatně", "Oops", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    public static class ReakceOdpovedi implements ActionListener {
        private int index;
        private ArrayList<String> questions;
        private HashMap<Integer, ArrayList<String>> answers;
        private JLabel questionLabel;
        private JButton[] answerButtons;
        private HashMap<Integer, Integer> correctAnswers;

        public ReakceOdpovedi(int index, ArrayList<String> questions, HashMap<Integer, ArrayList<String>> answers, JLabel questionLabel, JButton[] answerButtons, HashMap<Integer, Integer> correctAnswers) {
            this.index = index;
            this.questions = questions;
            this.answers = answers;
            this.questionLabel = questionLabel;
            this.answerButtons = answerButtons;
            this.correctAnswers = correctAnswers;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            setSelectedAnswerIndex(index);
            for (int i = 0; i < answerButtons.length; i++) {
                answerButtons[i].setEnabled(i == index);
            }
            checkAnswer(correctAnswers, currentQuestionIndex, index);
        }
    }

    public static void setSelectedAnswerIndex(int index) {
        selectedAnswerIndex = index;
    }
}