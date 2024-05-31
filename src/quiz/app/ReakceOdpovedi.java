package quiz.app;

import Quizz.Historie;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ReakceOdpovedi implements ActionListener {
    private Historie historie;
    private int index;


    public ReakceOdpovedi(Historie historie, int index) {
        this.historie = historie;
        this.index = index;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        historie.selectedAnswerIndex = index;
        for (int i = 0; i < historie.answerButtons.length; i++) {
            historie.answerButtons[i].setEnabled(i == index);
        }
        historie.checkAnswer();
    }
}
