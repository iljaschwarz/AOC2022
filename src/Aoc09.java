import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;

public class Aoc09 {
    public static void main(String[] args) {
        String input = Utils.getInput("inputs/aoc09Input.txt");
        Aoc09 a = new Aoc09();
        a.firstPart(input);
        a.secondPart(input);
    }


    private void firstPart(String input) {

        String[] lines = input.split("\n");

        Point head = new Point(0, 0);
        Point tail = new Point(0, 0);
        HashMap<String, Integer> map = new HashMap<>();
        for (String line : lines) {
            String[] instruction = line.split(" ");

            switch (instruction[0]) {
                case "R": {
                    move("R", Integer.parseInt(instruction[1]), head, tail, map);
                    break;
                }
                case "U": {
                    move("U", Integer.parseInt(instruction[1]), head, tail, map);
                    break;
                }
                case "L": {
                    move("L", Integer.parseInt(instruction[1]), head, tail, map);
                    break;
                }
                case "D": {
                    move("D", Integer.parseInt(instruction[1]), head, tail, map);
                    break;
                }

            }

        }
        System.out.println(map.size());
    }

    private void move(String direction, Integer amount, Point head, Point tail, HashMap<String, Integer> map) {
        for (int i = 0; i < amount; i++) {

            if (Objects.equals(direction, "R")) {
                head.x += 1;

            } else if (Objects.equals(direction, "U")) {
                head.y += 1;

            } else if (Objects.equals(direction, "D")) {
                head.y -= 1;

            } else if (Objects.equals(direction, "L")) {
                head.x -= 1;
            }
            adjust(head, tail);

            map.put(tail.toString(), 1);
        }
    }

    private void move(String direction, Integer amount, Point head, ArrayList<Point> tails, HashMap<String, Integer> map) {
        for (int i = 0; i < amount; i++) {

            if (Objects.equals(direction, "R")) {
                head.x += 1;

            } else if (Objects.equals(direction, "U")) {
                head.y += 1;

            } else if (Objects.equals(direction, "D")) {
                head.y -= 1;

            } else if (Objects.equals(direction, "L")) {
                head.x -= 1;
            }
            adjust(head, tails.get(0));
            for (int j = 1; j < tails.size(); j++) {
                adjust(tails.get(j - 1), tails.get(j));
            }
            map.put(tails.get(8).toString(), 1);
        }
    }

    private void adjust(Point head, Point tail) {
        int dx = head.x - tail.x;
        int dy = head.y - tail.y;

        if (Math.abs(dx) <= 1 && Math.abs(dy) <= 1) {

        } else if (Math.abs(dx) >= 2 && Math.abs(dy) >= 2) {
            if (tail.x < head.x) {
                tail.x = head.x - 1;
            } else {
                tail.x = head.x + 1;
            }
            if (tail.y < head.y) {
                tail.y = head.y - 1;
            } else {
                tail.y = head.y + 1;
            }
        } else if (Math.abs(dx) >= 2) {
            if (tail.x < head.x) {
                tail.x = head.x - 1;
            } else {
                tail.x = head.x + 1;
            }
            tail.y = head.y;
        } else if (Math.abs(dy) >= 2) {
            if (tail.y < head.y) {
                tail.y = head.y - 1;
            } else {
                tail.y = head.y + 1;
            }
            tail.x = head.x;
        }
    }

    private void secondPart(String input) {
        String[] lines = input.split("\n");

        Point head = new Point(0, 0);
        ArrayList<Point> tails = new ArrayList<>() {{
            add(new Point(0, 0));
            add(new Point(0, 0));
            add(new Point(0, 0));
            add(new Point(0, 0));
            add(new Point(0, 0));
            add(new Point(0, 0));
            add(new Point(0, 0));
            add(new Point(0, 0));
            add(new Point(0, 0));
        }};
        HashMap<String, Integer> map = new HashMap<>();
        for (String line : lines) {
            String[] instruction = line.split(" ");

            switch (instruction[0]) {
                case "R": {
                    move("R", Integer.parseInt(instruction[1]), head, tails, map);
                    break;
                }
                case "U": {
                    move("U", Integer.parseInt(instruction[1]), head, tails, map);
                    break;
                }
                case "L": {
                    move("L", Integer.parseInt(instruction[1]), head, tails, map);
                    break;
                }
                case "D": {
                    move("D", Integer.parseInt(instruction[1]), head, tails, map);
                    break;
                }

            }

        }
        System.out.println(map.size());
    }

    private class Point {
        public int x;
        public int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public String toString() {
            return "" + this.x + "," + this.y;
        }


    }
}




