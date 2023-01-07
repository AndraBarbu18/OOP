/**
 * The main class that is running
 */
public class Main {
    /**
     * Starts the quiz by creating a single instance of the model, view, controller;
     * Each of them is passed to the parts that need them.
     * @param args
     */
    public static void main(String[] args) {
        QuizModel model = new QuizModel();
        QuizView view = new QuizView(model);
        QuizController controller = new QuizController(model, view);
    }
}