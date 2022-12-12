public class Aoc11 {
    public static void main(String[] args) {
        String input = Utils.getInput("inputs/aoc11Input.txt");
        Aoc11 a = new Aoc11();
        a.firstPart(input);
        a.secondPart(input);

    }


    private void firstPart(String input) {
        String test="Monkey 0:\n" +
                "  Starting items: 89, 84, 88, 78, 70\n" +
                "  Operation: new = old * 5\n" +
                "  Test: divisible by 7\n" +
                "    If true: throw to monkey 6\n" +
                "    If false: throw to monkey 7\n" +
                "\n" +
                "Monkey 1:\n" +
                "  Starting items: 76, 62, 61, 54, 69, 60, 85\n" +
                "  Operation: new = old + 1\n" +
                "  Test: divisible by 17\n" +
                "    If true: throw to monkey 0\n" +
                "    If false: throw to monkey 6\n" +
                "\n" +
                "Monkey 2:\n" +
                "  Starting items: 83, 89, 53\n" +
                "  Operation: new = old + 8\n" +
                "  Test: divisible by 11\n" +
                "    If true: throw to monkey 5\n" +
                "    If false: throw to monkey 3\n" +
                "\n" +
                "Monkey 3:\n" +
                "  Starting items: 95, 94, 85, 57\n" +
                "  Operation: new = old + 4\n" +
                "  Test: divisible by 13\n" +
                "    If true: throw to monkey 0\n" +
                "    If false: throw to monkey 1\n" +
                "\n" +
                "Monkey 4:\n" +
                "  Starting items: 82, 98\n" +
                "  Operation: new = old + 7\n" +
                "  Test: divisible by 19\n" +
                "    If true: throw to monkey 5\n" +
                "    If false: throw to monkey 2\n" +
                "\n" +
                "Monkey 5:\n" +
                "  Starting items: 69\n" +
                "  Operation: new = old + 2\n" +
                "  Test: divisible by 2\n" +
                "    If true: throw to monkey 1\n" +
                "    If false: throw to monkey 3\n" +
                "\n" +
                "Monkey 6:\n" +
                "  Starting items: 82, 70, 58, 87, 59, 99, 92, 65\n" +
                "  Operation: new = old * 11\n" +
                "  Test: divisible by 5\n" +
                "    If true: throw to monkey 7\n" +
                "    If false: throw to monkey 4\n" +
                "\n" +
                "Monkey 7:\n" +
                "  Starting items: 91, 53, 96, 98, 68, 82\n" +
                "  Operation: new = old * old\n" +
                "  Test: divisible by 3\n" +
                "    If true: throw to monkey 4\n" +
                "    If false: throw to monkey 2";
//        input ="Monkey 0:\n" +
//                "  Starting items: 79, 98\n" +
//                "  Operation: new = old * 19\n" +
//                "  Test: divisible by 23\n" +
//                "    If true: throw to monkey 2\n" +
//                "    If false: throw to monkey 3\n" +
//                "\n" +
//                "Monkey 1:\n" +
//                "  Starting items: 54, 65, 75, 74\n" +
//                "  Operation: new = old + 6\n" +
//                "  Test: divisible by 19\n" +
//                "    If true: throw to monkey 2\n" +
//                "    If false: throw to monkey 0\n" +
//                "\n" +
//                "Monkey 2:\n" +
//                "  Starting items: 79, 60, 97\n" +
//                "  Operation: new = old * old\n" +
//                "  Test: divisible by 13\n" +
//                "    If true: throw to monkey 1\n" +
//                "    If false: throw to monkey 3\n" +
//                "\n" +
//                "Monkey 3:\n" +
//                "  Starting items: 74\n" +
//                "  Operation: new = old + 3\n" +
//                "  Test: divisible by 17\n" +
//                "    If true: throw to monkey 0\n" +
//                "    If false: throw to monkey 1";
        String[] lines = input.split("\n");
//        ArrayList<Monkey> monkeys = new ArrayList<>();
//        int current = 0;
//        Monkey currentMonkey = new Monkey();
//        for (String line : lines) {
//            if (line.startsWith("Monkey ")) {
//                current = Integer.parseInt(line.split(" ")[1].replaceAll(":", ""));
//                currentMonkey = new Monkey();
//                currentMonkey.number = current;
//            } else if (line.startsWith("  Starting items: ")) {
//                String startingString = line.split("  Starting items: ")[1];
//                String[] startItems = startingString.split(",");
//                for (String item : startItems) {
//                    currentMonkey.items.add(Integer.parseInt(item.trim()));
//                }
//            } else if (line.startsWith("  Operation: new = old ")) {
//                if (line.startsWith("  Operation: new = old * old")) {
//                    currentMonkey.mul = true;
//                    currentMonkey.quadrad = true;
//
//                } else if (line.startsWith("  Operation: new = old *")) {
//                    currentMonkey.mul = true;
//                    currentMonkey.amount = Integer.parseInt(line.split("  Operation: new = old \\* ")[1]);
//                } else {
//                    currentMonkey.amount = Integer.parseInt(line.split("  Operation: new = old \\+ ")[1]);
//                }
//            } else if (line.startsWith("  Test: divisible by ")) {
//                currentMonkey.test = Integer.valueOf(line.split("  Test: divisible by ")[1]);
//            } else if (line.startsWith("    If true: throw to monkey ")) {
//                currentMonkey.ifTrue = Integer.valueOf(line.split("    If true: throw to monkey ")[1]);
//            } else if (line.startsWith("    If false: throw to monkey ")) {
//                currentMonkey.ifFalse = Integer.valueOf(line.split("    If false: throw to monkey ")[1]);
//            } else {
//                monkeys.add(currentMonkey);
//            }
//
//        }
//        monkeys.add(currentMonkey);
//        for (int i = 0; i < 20; i++) {
//            for (int j = 0; j < monkeys.size(); j++) {
//                Monkey monkey = monkeys.get(j);
//                for (Integer curItem : monkey.items) {
//                    if (monkey.quadrad) {
//                        curItem *= curItem;
//                    } else if (monkey.mul) {
//                        curItem *= monkey.amount;
//                    } else {
//                        curItem += monkey.amount;
//                    }
//
//                    curItem /= 3;
//                    if (curItem % monkey.test == 0) {
//                        monkeys.get(monkey.ifTrue).items.add(curItem);
//                    } else {
//                        monkeys.get(monkey.ifFalse).items.add(curItem);
//                    }
//                }
//                monkey.activ += monkey.items.size();
//                monkey.items = new ArrayList<>();
//            }
//        }
//        ArrayList<Integer> result = new ArrayList<>();
//        for (Monkey monkey : monkeys) {
//            result.add(monkey.activ);
//        }
//        Collections.sort(result);
//        Collections.reverse(result);
//        System.out.println(result.get(0) * result.get(1));
    }


    private void secondPart(String input) {
        String[] lines = input.split("\n");

    }

//    public class Monkey {
//        public int number;
//        ArrayList<Integer> items = new ArrayList<>();
//        boolean mul = false;
//        Integer amount = 0;
//        Integer test = 0;
//
//        Integer ifTrue = 0;
//        Integer ifFalse = 0;
//        Integer activ = 0;
//
//        boolean quadrad = false;
//    }
}




