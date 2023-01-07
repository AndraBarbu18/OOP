/**
 * Represents an enumeration consisting of the available questions of the quiz
 */
public enum Question {
    Q1("Care din urmatoarele raspunsuri sunt limbaje de programare?"),
    Q2("Care din urmatoarele raspunsuri reprezinta companii care produc calculatoare?"),
    Q3("Care din urmatoarele raspunsuri fac parte din categoria masinilor?"),
    Q4("Care din urmatoarele raspunsuri reprezinta animale domestice?"),
    Q5("Care din urmatoarele raspunsuri sunt legume?");

    private final String questionText;

    /**
     * Constructor
     * @param questionText
     */
    private Question(String questionText) {
        this.questionText = questionText;
    }

    /**
     * Gets the question text
     * @return A String representing the question text
     */
    public String getQuestionText() {
        return questionText;
    }

    /**
     * Gets the right Question using the question text
     * @param questionText A String representing the question text
     * @return A Question according to the passed question text
     */
    public static Question valueByQuestionText(String questionText) {
        for (Question q : values()) {
            if (q.getQuestionText().equals(questionText)) {
                return q;
            }
        }
        return null;
    }
}
