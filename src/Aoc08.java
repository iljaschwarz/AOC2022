public class Aoc08 {
    public static void main(String[] args) {
        String input = Utils.getInput("inputs/aoc08Input.txt");

        firstPart(input);
        secondPart(input);
    }

    public static Integer width = 99;

    private static void firstPart(String input) {
        Integer result = 0;
//        input = "30373\n" +
//                "25512\n" +
//                "65332\n" +
//                "33549\n" +
//                "35390";
        String[] lines = input.split("\n");
        Integer[][] arr = new Integer[99][99];
        for (int x = 0; x < lines.length; x++) {
            for (int y = 0; y < lines[x].length(); y++) {
                arr[x][y] = Integer.parseInt(String.valueOf(lines[x].charAt(y)));
            }
        }
        for (int r = 0; r < arr.length; r++) {
            for (int c = 0; c < arr[r].length; c++) {
                Integer current = arr[r][c];
                boolean left = true;
                for (int i = 0; i < c; i++) {
                    left = left && arr[r][i] < current;
                }
                if (left) {
                    result += 1;
                    continue;
                }
                boolean right = true;
                for (int i = c + 1; i < arr.length; i++) {
                    right = right && arr[r][i] < current;
                }
                if (right) {
                    result += 1;
                    continue;
                }
                boolean top = true;
                for (int i = 0; i < r; i++) {
                    top = top && arr[i][c] < current;
                }
                if (top) {
                    result += 1;
                    continue;
                }
                boolean bottom = true;
                for (int i = r + 1; i < arr.length; i++) {
                    bottom = bottom && arr[i][c] < current;
                }
                if (bottom) {
                    result += 1;
                    continue;
                }
            }
        }


        System.out.println(result);
    }

    private static void secondPart(String input) {
        Integer result = 0;
        String[] lines = input.split("\n");
        Integer[][] arr = new Integer[99][99];
        for (int x = 0; x < lines.length; x++) {
            for (int y = 0; y < lines[x].length(); y++) {
                arr[x][y] = Integer.parseInt(String.valueOf(lines[x].charAt(y)));
            }
        }

        for (int r = 0; r < arr.length; r++) {
            for (int c = 0; c < arr[r].length; c++) {

                Integer current = arr[r][c];
                int left = 0;
                int right = 0;
                int top = 0;
                int bottom = 0;

                for (int i = c - 1; i > -1; i--) {
                    left += 1;
                    if (arr[r][i] >= current) {
                        break;
                    }
                }

                for (int i = c + 1; i < arr.length; i++) {
                    right += 1;
                    if (arr[r][i] >= current) {
                        break;
                    }
                }

                for (int i = r - 1; i > -1; i--) {
                    top += 1;
                    if (arr[i][c] >= current) {
                        break;
                    }
                }

                for (int i = r + 1; i < arr.length; i++) {
                    bottom += 1;
                    if (arr[i][c] >= current) {
                        break;
                    }
                }
                result = Integer.max(result, left * right * top * bottom);
            }
        }


        System.out.println(result);
    }
}



