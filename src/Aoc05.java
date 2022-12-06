import java.util.ArrayList;
import java.util.Stack;

public class Aoc05 {
    public static void main(String[] args) {
        String input = Utils.getInput("inputs/aoc05Input.txt");

        firstPart(input);
        secondPart(input);

    }


    private static void firstPart(String input) {

        String[] lines = input.split("\n");
        ArrayList<Stack<String>> stacks = new ArrayList<>() {{
            add(new Stack<>() {{
                push("D");
                push("B");
                push("J");
                push("V");
            }});
            add(new Stack<>() {{
                push("P");
                push("V");
                push("B");
                push("W");
                push("R");
                push("D");
                push("F");
            }});
            add(new Stack<>() {{
                push("R");
                push("G");
                push("F");
                push("L");
                push("D");
                push("C");
                push("W");
                push("Q");
            }});
            add(new Stack<>() {{
                push("W");
                push("J");
                push("P");
                push("M");
                push("L");
                push("N");
                push("D");
                push("B");
            }});
            add(new Stack<>() {{
                push("H");
                push("N");
                push("B");
                push("P");
                push("C");
                push("S");
                push("Q");
            }});

            add(new Stack<>() {{
                push("R");
                push("D");
                push("B");
                push("S");
                push("N");
                push("G");
            }});
            add(new Stack<>() {{
                push("Z");
                push("B");
                push("P");
                push("M");
                push("Q");
                push("F");
                push("S");
                push("H");
            }});
            add(new Stack<>() {{
                push("W");
                push("L");
                push("F");
            }});
            add(new Stack<>() {{
                push("S");
                push("V");
                push("F");
                push("M");
                push("R");
            }});
        }};
        boolean emtpyLine = false;
        for (int i = 0; i < lines.length; i++) {
            if (!emtpyLine) {

            }
            if (lines[i].isEmpty()) {
                emtpyLine = true;
                continue;
            }

            if (emtpyLine) {
                String[] curLine = lines[i].split(" from ");
                Integer stackNr = Integer.valueOf(curLine[1].split(" to ")[0]);
                Integer amount = Integer.valueOf(curLine[0].substring(5));
                Integer newStackNr = Integer.valueOf(curLine[1].split(" to ")[1]);
                Stack<String> oldStack = stacks.get(stackNr - 1);
                Stack<String> newStack = stacks.get(newStackNr - 1);
                for (int z = 0; z < amount; z++) {
                    newStack.push(oldStack.pop());

                }
            }
        }
        for (Stack stack : stacks) {
            System.out.print(stack.pop());
        }
        System.out.println();
    }

    private static void secondPart(String input) {
        String[] lines = input.split("\n");

        ArrayList<Stack<String>> stacks = new ArrayList<>() {{
            add(new Stack<>() {{
                push("D");
                push("B");
                push("J");
                push("V");
            }});
            add(new Stack<>() {{
                push("P");
                push("V");
                push("B");
                push("W");
                push("R");
                push("D");
                push("F");
            }});
            add(new Stack<>() {{
                push("R");
                push("G");
                push("F");
                push("L");
                push("D");
                push("C");
                push("W");
                push("Q");
            }});
            add(new Stack<>() {{
                push("W");
                push("J");
                push("P");
                push("M");
                push("L");
                push("N");
                push("D");
                push("B");
            }});
            add(new Stack<>() {{
                push("H");
                push("N");
                push("B");
                push("P");
                push("C");
                push("S");
                push("Q");
            }});

            add(new Stack<>() {{
                push("R");
                push("D");
                push("B");
                push("S");
                push("N");
                push("G");
            }});
            add(new Stack<>() {{
                push("Z");
                push("B");
                push("P");
                push("M");
                push("Q");
                push("F");
                push("S");
                push("H");
            }});
            add(new Stack<>() {{
                push("W");
                push("L");
                push("F");
            }});
            add(new Stack<>() {{
                push("S");
                push("V");
                push("F");
                push("M");
                push("R");
            }});
        }};
        boolean emtpyLine = false;
        for (int i = 0; i < lines.length; i++) {
            if (!emtpyLine) {

            }
            if (lines[i].isEmpty()) {
                emtpyLine = true;
                continue;
            }

            if (emtpyLine) {
                String[] curLine = lines[i].split(" from ");
                Integer stackNr = Integer.valueOf(curLine[1].split(" to ")[0]);
                Integer amount = Integer.valueOf(curLine[0].substring(5));
                Integer newStackNr = Integer.valueOf(curLine[1].split(" to ")[1]);
                Stack<String> oldStack = stacks.get(stackNr - 1);
                Stack<String> newStack = stacks.get(newStackNr - 1);
                Stack<String> tempStack = new Stack<>();
                for (int z = 0; z < amount; z++) {
                    tempStack.push(oldStack.pop());

                }
                while (!tempStack.isEmpty()) {
                    newStack.push(tempStack.pop());
                }
            }
        }
        for (Stack stack : stacks) {
            System.out.print(stack.pop());
        }
        System.out.println();
    }
}
