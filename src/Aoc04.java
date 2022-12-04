public class Aoc04 {
    public static void main(String[] args) {
        String input = Utils.getInput("inputs/aoc04Input.txt");

        firstPart(input);
        secondPart(input);

    }


    private static void firstPart(String input) {
        Integer result = 0;
        String[] lines = input.split("\n");

        for (String line : lines) {
            String[] currentLine = line.split(",");

            String[] splitLeft = currentLine[0].split("-");
            String[] splitRight = currentLine[1].split("-");

            int startLeft = Integer.parseInt(splitLeft[0]);
            int endLeft = Integer.parseInt(splitLeft[1]);

            int startRight = Integer.parseInt(splitRight[0]);
            int endRight = Integer.parseInt(splitRight[1]);

            if ((startLeft <= startRight && endLeft >= endRight) || (startRight <= startLeft && endRight >= endLeft)) {
                result += 1;
            }
        }
        System.out.println(result);
    }

    private static void secondPart(String input) {
        Integer result = 0;

        String[] lines = input.split("\n");

        for (String line : lines) {
            String[] currentLine = line.split(",");
            String[] splitLeft = currentLine[0].split("-");
            String[] splitRight = currentLine[1].split("-");

            int startLeft = Integer.parseInt(splitLeft[0]);
            int endLeft = Integer.parseInt(splitLeft[1]);

            int startRight = Integer.parseInt(splitRight[0]);
            int endRight = Integer.parseInt(splitRight[1]);

            if ((startLeft <= startRight && endLeft >= startRight) || (startRight <= startLeft && endRight >= startLeft)) {
                result += 1;
            }
        }
        System.out.println(result);
    }
}
