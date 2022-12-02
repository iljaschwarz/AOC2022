import java.util.HashMap;

public class Aoc02 {

    public static void main(String[] args) {
        String input = Utils.getInput("inputs/aoc02Input.txt");

        firstPart(input);
        secondPart(input);

    }

    public static HashMap<String, Integer> mapFirst = new HashMap<>() {{
        put("A X", 4);
        put("A Y", 8);
        put("A Z", 3);
        put("B X", 1);
        put("B Y", 5);
        put("B Z", 9);
        put("C X", 7);
        put("C Y", 2);
        put("C Z", 6);
    }};

    public static HashMap<String, Integer> mapSecond = new HashMap<>() {{
        put("A X", 3);
        put("A Y", 4);
        put("A Z", 8);
        put("B X", 1);
        put("B Y", 5);
        put("B Z", 9);
        put("C X", 2);
        put("C Y", 6);
        put("C Z", 7);
    }};

    private static void firstPart(String input) {
        String[] lines = input.split("\n");
        Integer score = 0;
        for (String line : lines) {
            score += mapFirst.get(line);
        }
        System.out.println(score);
    }

    private static void secondPart(String input) {
        String[] lines = input.split("\n");
        Integer score = 0;
        for (String line : lines) {
            score += mapSecond.get(line);
        }
        System.out.println(score);

    }

}
