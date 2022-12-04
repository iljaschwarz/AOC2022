public class Aoc03 {
    public static void main(String[] args) {
        String input = Utils.getInput("inputs/aoc03Input.txt");

        firstPart(input);
        secondPart(input);

    }

    public static String alphabetMap = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";

    private static void firstPart(String input) {


        int result = 0;

        String[] lines = input.split("\n");
        for (int i = 0; i < lines.length; i++) {
            String a = lines[i].substring(0, lines[i].length() / 2);
            String b = lines[i].substring(lines[i].length() / 2);

            for (int j = 0; j < a.length(); j++) {
                if (b.indexOf(a.charAt(j)) != -1) {
                    System.out.println(a.charAt(j));
                    result += alphabetMap.indexOf(a.charAt(j)) + 1;
                    break;
                }
            }

        }
        System.out.println(result);
    }

    private static void secondPart(String input) {

        int result = 0;

        String[] lines = input.split("\n");
        for (int i = 0; i < lines.length; i = i + 3) {
            String a = lines[i];
            String b = lines[i + 1];
            String c = lines[i + 2];

            for (int j = 0; j < a.length(); j++) {
                if (b.indexOf(a.charAt(j)) != -1 && c.indexOf(a.charAt(j)) != -1) {
                    result += alphabetMap.indexOf(a.charAt(j)) + 1;
                    break;
                }
            }
        }
        System.out.println(result);

    }
}
