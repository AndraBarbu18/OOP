import java.math.BigInteger;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Represents the model.
 */
public class QuizModel {
    static final String INITIAL_SCORE = "0";

    private HashMap<Question, Answer> quiz = new HashMap<>();
    private BigInteger currentScore;

    private int currentQuestion;

    /**
     * Constructor
     */
    public QuizModel() {
        initializeQuiz();
    }

    /**
     * Initializes the quiz game.
     */
    public void initializeQuiz() {
        currentScore = new BigInteger(INITIAL_SCORE);
        currentQuestion = 0;
        this.quiz = new HashMap<>() {
            {
                put(Question.Q1, new Answer(AnswerRightness.Q1_ANSWER));
                put(Question.Q2, new Answer(AnswerRightness.Q2_ANSWER));
                put(Question.Q3, new Answer(AnswerRightness.Q3_ANSWER));
                put(Question.Q4, new Answer(AnswerRightness.Q4_ANSWER));
                put(Question.Q5, new Answer(AnswerRightness.Q5_ANSWER));
            }
        };
    }

    /**
     * Checks the rightness of the selected answers for the current question;
     * Adds 1 point to the score only if only all correct answers to the question are selected.
     * @param currentQuestion Current question user must offer answer for
     * @param answers The list of the answers selected by user
     */
    public void checkAnswer(Question currentQuestion, List<String> answers) {
        int noOfCorrectAnswers = 0;
        Answer answer = quiz.get(currentQuestion);
        for (Map.Entry<String, Boolean> set : answer.getAnswerMap().entrySet()) {
            if (set.getValue() == true) {
                noOfCorrectAnswers++;
            }
        }
        Boolean completeCorrectAnswer = true;
        if (noOfCorrectAnswers == answers.size()) {
            for (Map.Entry<String, Boolean> set : answer.getAnswerMap().entrySet()) {
                if (set.getValue() == false && answers.contains(set.getKey())) {
                    completeCorrectAnswer = false;
                    break;
                }
            }
        }else {
            completeCorrectAnswer = false;
        }
        if (completeCorrectAnswer == true) {
            currentScore = currentScore.add(new BigInteger("1"));
        }
        this.currentQuestion++;
    }

    /**
     * Gets a map consisting of question - answer.
     * @return A HashMap consisting of the question as a key and the specific answers (with their correctness) as a value.
     */
    public HashMap<Question, Answer> getQuiz() {
        return quiz;
    }

    /**
     * Sets the map consisting of question - answer
     * @param quiz A HashMap consisting of the question as a key and the specific answers (with their correctness) as a value.
     */
    public void setQuiz(HashMap<Question, Answer> quiz) {
        this.quiz = quiz;
    }

    /**
     * Gets the current score
     * @return A String representing the current score
     */
    public String getCurrentScore() {
        return currentScore.toString();
    }

    /**
     * Sets the current score
     * @param currentScore A BigInteger representing the current score
     */
    public void setCurrentScore(BigInteger currentScore) {
        this.currentScore = currentScore;
    }

    /**
     * Gets the number of current question
     * @return An int representing the number of current question
     */
    public int getCurrentQuestion() {
        return currentQuestion;
    }

    /**
     * Sets the number of current question
     * @param currentQuestion An int representing the number of current question
     */
    public void setCurrentQuestion(int currentQuestion) {
        this.currentQuestion = currentQuestion;
    }
}
