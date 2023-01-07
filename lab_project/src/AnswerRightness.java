import java.util.HashMap;

/**
 * Incorporates some defined answers and their rightness for the available quiz questions
 */
public class AnswerRightness {

    public static final HashMap<String, Boolean> Q1_ANSWER = new HashMap<>() {
        {
            put("Java", true);
            put("C", true);
            put("Asus", false);
            put("C++", true);
        }
    };
    public static final HashMap<String, Boolean> Q2_ANSWER = new HashMap<>() {
        {
            put("Opel", false);
            put("Asus", true);
            put("HP", true);
            put("Peugeot", false);
        }
    };
    public static final HashMap<String, Boolean> Q3_ANSWER = new HashMap<>() {
        {
            put("Sarpe", false);
            put("Porche", true);
            put("Puma", false);
            put("Samsung", false);
        }
    };
    public static final HashMap<String, Boolean> Q4_ANSWER = new HashMap<>() {
        {
            put("pantera", false);
            put("caine", true);
            put("paine", false);
            put("rinocer", false);
        }
    };
    public static final HashMap<String, Boolean> Q5_ANSWER = new HashMap<>() {
        {
            put("rosie", true);
            put("castravete", true);
            put("ou", false);
            put("mar", false);
        }
    };
}
