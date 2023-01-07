import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

/**
 * Represents the controller.
 */
public class QuizController {
    private QuizModel model;
    private QuizView view;

    /**
     * Constructor
     * @param model The model
     * @param view The view
     */
    public QuizController(QuizModel model, QuizView view) {
        this.model = model;
        this.view = view;
        view.addNextQuestionListener(new NextQuestionListener());
        view.addTryAgainListener(new TryAgainListener());
    }

    /**
     * When the 'Next Question' button is pressed:
     * 1. Get the current question
     * 2. Get a list consisting of the selected answers
     * 3. Check the rightness of the selected answers for the current question and increment the score
     * 4. Display the new value of the score
     * 5. Prepare and display the next question and the possible answer for it
     */
    class NextQuestionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            Question currentQuestion = Question.valueByQuestionText(view.getQuestionLabel());
            List<String> answers = view.getAnswers();
            model.checkAnswer(currentQuestion, answers);
            view.setScoreTextField(model.getCurrentScore());
            view.prepareNextQuestion();
        }
    }

    /**
     * Initialize again the quiz
     */
    class TryAgainListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            model.initializeQuiz();
            view.initializeDefaultView();
        }
    }
}
