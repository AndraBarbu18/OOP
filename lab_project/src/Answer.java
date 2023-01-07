import java.util.ArrayList;
import java.util.HashMap;

/**
 * Represents the answer
 */
public class Answer {

    private HashMap<String, Boolean> answerMap = new HashMap<>();

    /**
     * Default constructor
     */
    public Answer() {

    }

    /**
     * Constructor
     * @param answerMap The HashMap
     */
    public Answer(HashMap<String, Boolean> answerMap) {
        this.answerMap = answerMap;
    }

    /**
     * Gets the Answer for a Question
     * @return A HashMap consisting of the available answers (as key) and their rightness (as value)
     */
    public HashMap<String, Boolean> getAnswerMap() {
        return answerMap;
    }

}
