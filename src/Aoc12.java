import java.util.HashSet;
import java.util.LinkedList;

public class Aoc12 {
    public static void main(String[] args) {
        String input = Utils.getInput("inputs/aoc12Input.txt");
        Aoc12 a = new Aoc12();
        a.firstPart();
        a.secondPart();

    }

    private String input = "abaaaaacccccccccccccccccccccccccccccccccccccccaaaaaaaccccaaaaaaaaaaaaaaaaacccccaaaaaacccccccccccccccccccccccaaaaaaaaccccccccccccccccccccccccccccccccaaaaaa\n" +
            "abaaaaaacccaaaacccccccccccccccccccccccaccccccccaaaaaaaaccaaaaaaaaaaaaaaaaccccccaaaaaacccccccccccccccccccccccccaaaaccccccccccccccccccccccccccccccccccaaaaaa\n" +
            "abaaaaaacccaaaacccccccccccccccccaaaaaaaacccccccaaaaaaaaacaaaaaaaaaaaaacccccccccaaaaacccccccccccccccccccccccccaaaaacccccccccccccccccccaaaccccccccccccaaaaaa\n" +
            "abaaacaccccaaaaccccccccccccccccccaaaaaacccccccccaaaaaaaccccaaaaaaaaaaacccccccccaaaaacccccccccccccccccccccccccaacaaaccccccccccccccccccaaacccccccccccccccaaa\n" +
            "abaaacccccccaaacccccccccccaacccccaaaaaaccccccccaaaaaaccccccaacaaaaaaaacccccccccccccccccccccccaaccccccccccccccacccaaaaacccccccccaaccccaaacccccccccccccccaaa\n" +
            "abccccccccccccccccccccccccaaaaccaaaaaaaacccccccaaaaaaaccccccccaaaaaaaaaccccccccccaacccccccccaaaccccccccccccccccccacaaacccccccccaaaaccaaacccccccccccccccaac\n" +
            "abccccccccccccccccccccccaaaaaacaaaaaaaaaaccccccaaccaaaaacccccaaaaccaaaaccccccccccaaacaacccccaaacaaacccaaccccccccaaaaaaaacccccccaaaaakkkkkkcccccccccccccccc\n" +
            "abccccccccccccccccccccccaaaaaccaaaaaaaaaacccccccccccaaaaaaccccacccaaaaaccccccccccaaaaaaccaaaaaaaaaaaaaaaccccccccaaaaaaaaccccccccaaajkkkkkkkaccccccaacccccc\n" +
            "abcccccccccccccccccccccccaaaaacacacaaaccccccccccccccaaaaaaccccccccaaaacccccccccaaaaaaacccaaaaaaaaaaaaaaaaaccccccccaaaaaccccccccccjjjkkkkkkkkccaaaaaacccccc\n" +
            "abcccccccccccccccccccccccaacaacccccaaacccaccccccccccaaaaaaccccccccaaaacccccccccaaaaaaacccccaaaaaacaaaaaaaacccccccaaaaacccccccjjjjjjjooopppkkkcaaaaaaaccccc\n" +
            "abcccccccccccccccccaacaacccccccccccaaaaaaacccccccccccaaaaacccccccccccccccccccccccaaaaaaccccaaaaaaccaaaaaaacccccccaaaaaacciijjjjjjjjoooopppkkkcaaaaaaaacccc\n" +
            "abccccccccccaaaccccaaaaacccccccccccccaaaaacccccccccccaaaaccccccccccccccccccccccccaacaaaccccaaaaaaacaaaaacccccccccaccaaaciiiijjjjjjoooopppppkllcaaaaaaacccc\n" +
            "abccaaccccccaaaaacaaaaacccccccccccccaaaaaacccccccccccccccccccccccccccccccccccccccaacccccccaaaacaaaaaaaaacccaaccccaaaaaciiiiinoooooooouuuupplllaaaaaacccccc\n" +
            "abcaaacccccaaaaaacaaaaaacccccccccccaaaaaaaaccccccccaacaccccccccccccccccccccccccccccccccccccaccccccccccaaccaaaccccaaaaaciiinnnooooooouuuuuppplllaaacacccccc\n" +
            "abaaaaaacccaaaaaacccaaaacccccccccccaaaaaaaaccccccccaaaaccccccccccccccccccccccccccccccccccccccccccccccccaaaaacaacaaaaaaiiinnnnntttoouuuuuupppllllcccccccccc\n" +
            "abaaaaaaccccaaaaacccaaccccccccccacccccaaccccccccccaaaaaccccccccccccccccccccccccccccccccccccccccccccccccaaaaaaaacaaaaaaiiinnnnttttuuuuxxuuupppllllccccccccc\n" +
            "abaaaaacccccaacaaccccccccccccccaaaccccaacccccaacccaaaaaacccccccccccccccccccccccccccccccccccccccccccccccccaaaaaccaaaaaaiiinnnttttxxuuxxyyuuppppllllcccccccc\n" +
            "abaaaacccccccccccccccccccccaaacaaaccccccaaacaaaaccacaaaacccccccccccccccccccccccccccccccccccaacccccccccccaaaaaccccaaaccciinnntttxxxxxxxyyvvvqqqqqlllccccccc\n" +
            "abaaaaaccccccccccccccccccccaaaaaaaaaacccaaaaaaacccccaaccccccccccccccccccccccccccccccccccccaaacccccccccccaacaaaccccccccciiinntttxxxxxxxyyvvvvvqqqqljjcccccc\n" +
            "abccaaaccaccccccccaaacccccccaaaaaaaaaccccaaaaaacccccccccccccccccccccccccccccccaacccccccaaaaacaaccccccccccccaacccccccccchhinnnttxxxxxxyyyyyvvvvqqqjjjcccccc\n" +
            "SbccccaaaacccccccaaaaaacccccccaaaaaccccccaaaaaaaaccccccccccccccccccccaaccccccaaaaccccccaaaaaaaacccccccccccccccccccccccchhhnnntttxxxxEzyyyyyvvvqqqjjjcccccc\n" +
            "abccccaaaacccccccaaaaaaccccccaaaaaacccccaaaaaaaaaacccccccccccccccccccaaccccccaaaaccccccccaaaaacccccccccccccccccccccccccchhhnntttxxxyyyyyyyvvvvqqqjjjcccccc\n" +
            "abcccaaaaaaccccccaaaaaacccccaaaaaaaccccaaaaaaaaaacccccccccccccccccaaaaaaaacccaaaacccccccaaaaaccccccccccccccccccccccccccchhmmmttxxxyyyyyyvvvvvqqqjjjdcccccc\n" +
            "abcccaaaaaacccccccaaaaacccccaaacaaacaaaaaaaaaaccccccccccccaaacccccaaaaaaaaccccccccccccccaacaaacccccccaacaaacccccccccccchhhmmmtswwwyyyyyyvvvqqqqjjjjdddcccc\n" +
            "abcccccaacccccccccaacaacccccccccccacaaaaaccaaaccccccccccaaaaacccccccaaaacccccccccccccccccccaaccccccccaaaaaacccccccccccchhhmmssswwwwwwyyywvrqqqjjjjdddccccc\n" +
            "abcccccccccccccccccccccccccccccccccaaaaaccccaaccccccccacaaaaaacccccaaaaacccccccccccccccccccccccccccccaaaaaacccccccccccchhhmmssswwwwwwywywwrrqjjjjddddccccc\n" +
            "abcccccccccccccccccccccccccccccccccaaaaaccccccccaaacaaacaaaaaacccccaaaaaaccccccccccccccccccccccccccccaaaaaaaccccccccccchhmmmsssswwsswwwwwwrrkkjjddddcccccc\n" +
            "abccccccccccccccccccccccccccccccccccaaaaacccccccaaaaaaacaaaaaccccccaaccaacccccccccccaaccccccccccccccaaaaaaaacaacaaccccchhhmmmsssssssswwwwrrrkkjddddaaccccc\n" +
            "abcccccccccccccccccccccccccaaaaaccccaacccccccccccaaaaaacaaaaacccccccccccccaacccccccaaaaaacccccccccccaaaaaaaacaaaaaccccchhgmmmmssssssrrwwwrrrkkddddaaaccccc\n" +
            "abcccccccccccccccccccccccccaaaaacccccccccccccccccaaaaaaaacccccccccccccccaaaaaaccccccaaaaaccccaaccccccccaaacccaaaaaaccccgggmmmmmmllllrrrrrrrkkkeedaaaaccccc\n" +
            "abcccccccccccaaccccccccccccaaaaaacccccccccccccccaaaaaaaaacccccccccccccccaaaaaaccccaaaaaaacccaaaacccccccaaccccaaaaaaccccggggmmmmllllllrrrrrkkkkeedaaaaacccc\n" +
            "abcccccccccccaaacaacaaaccccaaaaaaccccccccccccccaaaaaaaaaacccccccccccccccaaaaaaccccaaaaaaaaccaaaacccccccccccccaaaaaccccccgggggglllllllllrrkkkkeeeaaaaaacccc\n" +
            "abcccccccccccaaaaaacaaaacccaaaaaaccccccccccccccaaacaaaaaaccccccccccccccccaaaaaccccaaaaaaaaccaaaacccccccccccaaccaaaccccccgggggggggffflllkkkkkkeeeaaaaaacccc\n" +
            "abaccccccccaaaaaaaccaaaacccccaaacccccccccccccccccccaaaaaacaccccccccaaccccaaaacccccccaaacacccccccccccccccaaaaaccccccccccccccgggggffffflllkkkkeeeccaaacccccc\n" +
            "abaccccccccaaaaaaaccaaacccccccccccccccccaaaccccccccaaacaaaaaccccccaaacccccccccccccaaaacccccccccccccccccccaaaaaccccccccccccccccccaffffffkkkeeeeeccaaccccccc\n" +
            "abaaaccccccccaaaaaaccccccccccccccccccccaaaaaacccccccaaaaaaaacaaaacaaacccccccccaaaaaacccccccccccccccccccccaaaaaccccccccccccccccccccaffffffeeeeecccccccccccc\n" +
            "abaacccccccccaacaaaccccccccccccccccccccaaaaaaccccccccaaaaaccaaaaaaaaacccccccccaaaaaaaaccccccccccaaccccccaaaaacccccccccccccccccccccaaaffffeeeecccccccccccaa\n" +
            "abaacccccccccaaccccccccccccccccaaccccccaaaaacaaccaacccaaaaacaaaaaaaaacccccccccaaaaaaaaccccccaaacaacccccccccaacccccccccccccccccccccaaaccceaecccccccccccccaa\n" +
            "abaacccccccccccccccccccccccccccaaaaaacccaaaaaaaaaaaccaaacaaccaaaaaaaaaaaaacccccaaaaaaacccccccaaaaaccccccccccccccccccccccccccccccccaaacccccccccccccccaaacaa\n" +
            "abcccccccccccccccccccccccccccccaaaaaccccaacaacaaaaacccaaccccccaaaaaaaaaaaacccccaaaaacccccccccaaaaaaaccccccccccccccccccccccccccccccaaacccccccccccccccaaaaaa\n" +
            "abcccccccccccccccccccccccccccaaaaaaaccccccccaaaaaaaaccccccccccaaaaaaaaaaccccccaaaaaaccccccccaaaaaaaaccccccccccccccccccccccccccccccccccccccccccccccccaaaaaa\n";

    private void firstPart() {

        String[] lines = input.split("\n");
        Integer ROWS = lines.length;
        Integer COLUMNS = lines[0].length();
        Integer[][] map = new Integer[ROWS][COLUMNS];
        Character[][] grid = new Character[ROWS][COLUMNS];
        for (int row = 0; row < lines.length; row++) {
            for (int column = 0; column < lines[row].length(); column++) {
                char c = lines[row].charAt(column);
                if (c == 'S') {
                    map[row][column] = 1;
                } else if (c == 'E') {
                    map[row][column] = 26;
                } else {
                    map[row][column] = c - 'a' + 1;
                }
                grid[row][column] = c;
            }
        }
        System.out.println(bfs(1, map, grid));

    }

    private Integer bfs(Integer part, Integer[][] map, Character[][] grid) {
        LinkedList<Pair> q = new LinkedList<>();
        for (int row = 0; row < map.length; row++) {
            for (int column = 0; column < map[row].length; column++) {
                if (part == 1 && grid[row][column] == 'S') {
                    q.add(new Pair(row + "," + column, 0));
                }
                if (part == 2 && map[row][column] == 1) {
                    q.add(new Pair(row + "," + column, 0));
                }
            }
        }
        HashSet<String> visited = new HashSet<>();
        while (!q.isEmpty()) {
            Pair current = q.removeFirst();
            if (visited.contains(current.first)) {
                continue;
            }
            visited.add(current.first);
            Integer row = Integer.parseInt(current.first.split(",")[0]);
            Integer column = Integer.parseInt(current.first.split(",")[1]);

            if (grid[row][column] == 'E') {
                return current.second;
            }
            if (0 <= (row - 1) && (row - 1) < map.length && map[row - 1][column] <= 1 + map[row][column]) {
                q.add(new Pair((row - 1) + "," + column, current.second + 1));
            }
            if (0 <= (row + 1) && (row + 1) < map.length && map[row + 1][column] <= 1 + map[row][column]) {
                q.add(new Pair((row + 1) + "," + column, current.second + 1));
            }
            if (0 <= (column - 1) && (column - 1) < map[0].length && map[row][column - 1] <= 1 + map[row][column]) {
                q.add(new Pair(row + "," + (column - 1), current.second + 1));
            }
            if (0 <= (column + 1) && (column + 1) < map[0].length && map[row][column + 1] <= 1 + map[row][column]) {
                q.add(new Pair(row + "," + (column + 1), current.second + 1));
            }
        }
        return 0;
    }


    private void secondPart() {

        String[] lines = input.split("\n");
        Integer ROWS = lines.length;
        Integer COLUMNS = lines[0].length();
        Integer[][] map = new Integer[ROWS][COLUMNS];
        Character[][] grid = new Character[ROWS][COLUMNS];
        for (int row = 0; row < lines.length; row++) {
            for (int column = 0; column < lines[row].length(); column++) {
                char c = lines[row].charAt(column);
                if (c == 'S') {
                    map[row][column] = 1;
                } else if (c == 'E') {
                    map[row][column] = 26;
                } else {
                    map[row][column] = c - 'a' + 1;
                }
                grid[row][column] = c;
            }
        }
        System.out.println(bfs(2, map, grid));

    }

    private class Pair {
        public String first;
        public Integer second;

        public Pair(String first, Integer second) {
            this.first = first;
            this.second = second;
        }
    }
}




