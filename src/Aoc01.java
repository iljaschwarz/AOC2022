import java.util.ArrayList;
import java.util.Collections;

public class Aoc01 {

    public static void main(String[] args) {
        String input = Utils.getInput("inputs/aoc01Input.txt");

        firstPart(input);
        secondPart(input);

    }

    private static void firstPart(String input) {
        ArrayList<Integer> elvs = new ArrayList<>();
        String[] lines = input.split("\n");
        Integer current = 0;
        for (int i = 0; i < lines.length; i++) {
            if (lines[i].isEmpty()) {
                elvs.add(current);
                current = 0;
                continue;
            }
            current += Integer.parseInt(lines[i]);
        }
        Collections.sort(elvs, Collections.reverseOrder());
        System.out.println(elvs.get(0));
    }

    private static void secondPart(String input) {
        ArrayList<Integer> elvs = new ArrayList<>();
        String[] lines = input.split("\n");
        Integer current = 0;
        for (int i = 0; i < lines.length; i++) {
            if (lines[i].isEmpty()) {
                elvs.add(current);
                current = 0;
                continue;
            }
            current += Integer.parseInt(lines[i]);
        }
        Collections.sort(elvs, Collections.reverseOrder());

        System.out.println(elvs.get(0) + elvs.get(1) + elvs.get(2));
    }


}
