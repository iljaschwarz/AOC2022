import java.util.ArrayList;
import java.util.HashMap;

public class Aoc07 {
    public static void main(String[] args) {
        String input = Utils.getInput("inputs/aoc07Input.txt");

        firstPart(input);
        secondPart(input);
    }

    private static void firstPart(String input) {


        String[] lines = input.split("\n");
        HashMap<String, Integer> map = getMap(lines);

        Integer result = 0;
        for (Integer size : map.values()) {
            if (size <= 100000) {
                result += size;
            }
        }
        System.out.println(result);
    }


    private static void secondPart(String input) {

        String[] lines = input.split("\n");
        HashMap<String, Integer> map = getMap(lines);

        Integer max_used = 70_000_000 - 30_000_000;
        Integer total = map.get("/");
        Integer delete = total - max_used;
        Integer result = Integer.MAX_VALUE;
        for (Integer size : map.values()) {
            if (size >= delete) {
                result = Integer.min(result, size);
            }
        }
        System.out.println(result);
    }

    private static HashMap<String, Integer> getMap(String[] lines) {
        HashMap<String, Integer> map = new HashMap();
        ArrayList<String> paths = new ArrayList<>();
        for (String line : lines) {
            String[] words = line.split(" ");
            if ("cd".equals(words[1])) {
                if ("..".equals(words[2])) {
                    paths.remove(paths.size() - 1);
                } else {
                    paths.add(words[2]);
                }
            } else {
                if (!"ls".equals(words[1]) && !"dir".equals(words[0])) {
                    Integer size = Integer.parseInt(words[0]);
                    for (int i = 0; i < paths.size() + 1; i++) {
                        String curPath = String.join("/", paths.subList(0, i));
                        map.put(curPath, map.getOrDefault(curPath, 0) + size);
                    }
                }
            }
        }
        return map;
    }
}



