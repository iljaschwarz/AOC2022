import java.util.HashSet;

public class Aoc14 {
    public static void main(String[] args) {
        String input = Utils.getInput("inputs/aoc14Input.txt");
        Aoc14 a = new Aoc14();
        a.firstPart(input);

    }


    private void firstPart(String input) {
        HashSet<Point> r = new HashSet<>();

        String[] lines = input.split("\n");
        for (String line : lines) {
            Point prev = null;
            for (String point : line.split(" -> ")) {
                int x = Integer.parseInt(point.split(",")[0]);
                int y = Integer.parseInt(point.split(",")[1]);
                if (prev != null) {
                    int dx = x - prev.x;
                    int dy = y - prev.y;
                    int steps = Math.max(Math.abs(dx), Math.abs(dy));
                    for (int i = 0; i < steps+1; i++) {
                        int dirX = 0;

                        if (dx > 0) {
                            dirX = 1;
                        }
                        if (dx < 0) {
                            dirX = -1;
                        }
                        int dirY = 0;
                        if (dy > 0) {
                            dirY = 1;
                        }
                        if (dy < 0) {
                            dirY = -1;
                        }
                        int newx = prev.x + i * dirX;
                        int newy = prev.y + i * dirY;
                        r.add(new Point(newx, newy));
                    }
                }
                prev = new Point(x, y);
            }
        }
        int floor = Integer.MIN_VALUE;
        int loX = Integer.MAX_VALUE;
        int hiX = Integer.MIN_VALUE;
        for (Point point : r) {
            if (point.y > floor) {
                floor = point.y;
            }
            if (point.x < loX) {
                loX = point.x;
            }
            if (point.x > hiX) {
                hiX = point.x;
            }

        }

        floor += 2;
        loX -= 2000;
        hiX += 2000;
        for (int i = loX; i < hiX; i++) {
            r.add(new Point(i, floor));
        }

        boolean part1 = false;
        for (int t = 0; t < 1000000; t++) {


            Point rock = new Point(500, 0);
            while (true) {
                if (rock.y + 1 >= floor && !part1) {
                    part1 = true;
                    System.out.println(t);
                }
                if (!r.contains(new Point(rock.x, rock.y + 1))) {
                    rock = new Point(rock.x, rock.y + 1);
                } else if (!r.contains(new Point(rock.x - 1, rock.y + 1))) {
                    rock = new Point(rock.x - 1, rock.y + 1);
                } else if (!r.contains(new Point(rock.x + 1, rock.y + 1))) {
                    rock = new Point(rock.x + 1, rock.y + 1);
                } else {
                    break;
                }
            }
            if (rock.equals(new Point(500, 0))) {
                System.out.println(t + 1);
                break;
            }

            r.add(rock);
        }

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

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Point point = (Point) o;

            if (x != point.x) return false;
            return y == point.y;
        }

        @Override
        public int hashCode() {
            int result = x;
            result = 31 * result + y;
            return result;
        }
    }
}




