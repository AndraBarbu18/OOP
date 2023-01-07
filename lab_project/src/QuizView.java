import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Represents the view
 */
public class QuizView extends JFrame {
    private JPanel contentPanel;
    private JLabel scoreLabel;
    private JTextField scoreTextField;
    private JLabel questionLabel;
    private JCheckBox checkBox;
    private JCheckBox checkBox2;
    private JCheckBox checkBox3;
    private JCheckBox checkBox4;
    private JButton nextQuestionButton;
    private JButton tryAgainButton;

    private List<JCheckBox> checkBoxList = Arrays.asList(checkBox, checkBox2, checkBox3, checkBox4);
    private QuizModel quizModel;

    /**
     * Constructor
     * @param model The model
     */
    public QuizView(QuizModel model) {
        quizModel = model;
        initializeDefaultView();
        setContentPane(contentPanel);
        setTitle("Quiz");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    /**
     * Prepares the quiz view for a new try
     */
    public void initializeDefaultView() {
        tryAgainButton.setVisible(false);
        scoreTextField.setText(quizModel.getCurrentScore());
        questionLabel.setVisible(true);
        nextQuestionButton.setVisible(true);
        for (JCheckBox cb : checkBoxList) {
            cb.setVisible(true);
        }
        prepareNextQuestion();
    }

    /**
     * Gets the list of answers provided by user
     * @return A List<String> consisting of the answers provided by user
     */
    public List<String> getAnswers() {
        List<String> answers = new ArrayList<>();
        List<JCheckBox> checkBoxList = Arrays.asList(checkBox, checkBox2, checkBox3, checkBox4);
        for (JCheckBox cb : checkBoxList) {
            if (cb.isSelected()) {
                answers.add(cb.getText());
            }
        }
        return answers;
    }

    /**
     * Prepares and display the next question and the possible answer for it;
     * If there are no answer available then display the score and the 'Try Again' button
     */
    public void prepareNextQuestion() {
        if (quizModel.getCurrentQuestion() < Question.values().length) {
            questionLabel.setText(String.valueOf(quizModel.getCurrentQuestion() + 1) + ". " + Question.values()[quizModel.getCurrentQuestion()].getQuestionText());
            Answer answer = quizModel.getQuiz().get(Question.values()[quizModel.getCurrentQuestion()]);
            int index = 0;
            for (String keyAnswer : answer.getAnswerMap().keySet()) {
                checkBoxList.get(index).setText(keyAnswer);
                index++;
            }
            resetCheckBoxes();
        } else {
            displayScore();
        }
    }

    /**
     * Prepares the checkboxes for the next question by unselected them
     */
    public void resetCheckBoxes() {
        for (JCheckBox cb : checkBoxList) {
            cb.setSelected(false);
        }
    }

    /**
     * If there are no answer available then display the score and the 'Try Again' button
     */
    public void displayScore() {
        questionLabel.setVisible(false);
        nextQuestionButton.setVisible(false);
        for (JCheckBox cb : checkBoxList) {
            cb.setVisible(false);
        }
        tryAgainButton.setVisible(true);
    }

    /**
     * Adds an ActionListener to the button
     * @param nqal the ActionListener to be added
     */
    public void addNextQuestionListener(ActionListener nqal) {
        nextQuestionButton.addActionListener(nqal);
    }

    /**
     * Adds an ActionListener to the button
     * @param tral the ActionListener to be added
     */
    public void addTryAgainListener(ActionListener tral) {
        tryAgainButton.addActionListener(tral);
    }

    /**
     * Gets the text of the current question without its number
     * @return A String representing the text of the current question
     */
    public String getQuestionLabel() {
        return questionLabel.getText().substring(questionLabel.getText().indexOf(". ") + 2);
    }

    /**
     * Sets the score
     * @param scoreTextField A string representing the score
     */
    public void setScoreTextField(String scoreTextField) {
        this.scoreTextField.setText(scoreTextField);
    }
}
