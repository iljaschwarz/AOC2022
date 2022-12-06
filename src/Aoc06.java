import java.util.HashSet;

public class Aoc06 {
    public static void main(String[] args) {
        String input = Utils.getInput("inputs/aoc06Input.txt");

        firstPart(input);
        secondPart(input);
    }

    private static void firstPart(String input) {
        String[] lines = input.split("\n");

        boolean found = false;
        for (String line : lines) {
            for (int i = 0; i < line.length() - 4; i++) {
                if (found) {
                    break;
                }
                HashSet<Character> set = new HashSet<>();
                set.add(line.charAt(i));
                set.add(line.charAt(i + 1));
                set.add(line.charAt(i + 2));
                set.add(line.charAt(i + 3));

                if (set.size() == 4) {
                    found = true;
                    System.out.println(i + 4);
                    break;
                }
            }
        }
    }

    private static void secondPart(String input) {
        String[] lines = input.split("\n");

        boolean found = false;
        for (String line : lines) {
            for (int i = 0; i < line.length() - 14; i++) {
                if (found) {
                    break;
                }
                HashSet<Character> set = new HashSet<>();
                set.add(line.charAt(i));
                set.add(line.charAt(i + 1));
                set.add(line.charAt(i + 2));
                set.add(line.charAt(i + 3));
                set.add(line.charAt(i + 4));
                set.add(line.charAt(i + 5));
                set.add(line.charAt(i + 6));
                set.add(line.charAt(i + 7));
                set.add(line.charAt(i + 8));
                set.add(line.charAt(i + 9));
                set.add(line.charAt(i + 10));
                set.add(line.charAt(i + 11));
                set.add(line.charAt(i + 12));
                set.add(line.charAt(i + 13));

                if (set.size() == 14) {
                    found = true;
                    System.out.println(i + 14);
                    break;
                }

            }
        }
    }
}
