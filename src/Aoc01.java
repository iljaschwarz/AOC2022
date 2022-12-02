import java.util.ArrayList;
import java.util.Collections;

public class Aoc01 {

    public static void main(String[] args) {
        String input = Utils.getInput("inputs/aoc01Input.txt");

        firstPart(input);
        secondPart(input);

    }

    private static void firstPart(String input) {
        ArrayList<Integer> elves = getCalories(input);
        System.out.println(elves.get(0));
    }

    private static void secondPart(String input) {

        ArrayList<Integer> elves = getCalories(input);

        System.out.println(elves.get(0) + elves.get(1) + elves.get(2));
    }

    private static ArrayList<Integer> getCalories(String input) {
        ArrayList<Integer> elves = new ArrayList<>();
        String[] lines = input.split("\n");
        int current = 0;
        for (String line : lines) {
            if (line.isEmpty()) {
                elves.add(current);
                current = 0;
                continue;
            }
            current += Integer.parseInt(line);
        }
        elves.sort(Collections.reverseOrder());
        return elves;
    }


}
