public class Aoc10 {
    public static void main(String[] args) {
        String input = Utils.getInput("inputs/aoc10Input.txt");

        firstPart(input);
        secondPart(input);
    }


    private static void firstPart(String input) {

        String[] lines = input.split("\n");
        int reg = 1;
        int cycle = 0;
        int result = 0;
        for (String line : lines) {
            if (line.startsWith("noop")) {
                cycle++;
                if (cycle % 40 == 20) {
                    result += reg * cycle;
                    System.out.println();
                  //  System.out.println(reg+" "+cycle+" "+ reg*cycle);
                }
                continue;
            }
            if (line.startsWith("addx")) {
                int amount = Integer.parseInt(line.split(" ")[1]);
                cycle++;
                if (cycle % 40 == 20) {
                    result += reg * cycle;
                    System.out.println();
                   // System.out.println(reg+" "+cycle+" "+ reg*cycle);
                }



                cycle++;
                if (cycle % 40 == 20) {
                    result += reg * cycle;
                    System.out.println();
                   // System.out.println(reg+" "+cycle+" "+ reg*cycle);
                }
                reg += amount;
            }

        }
        System.out.println(result);
    }


    private static void secondPart(String input) {
        String[] lines = input.split("\n");
        int reg = 1;
        int cycle = 0;
        int result = 0;
        for (String line : lines) {
            int abs = 0;
            if (line.startsWith("noop")) {
                abs = Math.abs(cycle%40 - reg);
                if(abs<2){
                    System.out.print("#");
                }else{
                    System.out.print('.');
                }
                cycle++;
                if (cycle % 40==0) {
                    result += reg * cycle;
                    System.out.println();
                    //  System.out.println(reg+" "+cycle+" "+ reg*cycle);
                }
                continue;
            }
            if (line.startsWith("addx")) {
                int amount = Integer.parseInt(line.split(" ")[1]);
                abs = Math.abs(cycle%40 - reg);
                if(abs<2){
                    System.out.print("#");
                }else{
                    System.out.print('.');
                }
                cycle++;
                if (cycle % 40 ==0) {
                    result += reg * cycle;
                    System.out.println();
                    // System.out.println(reg+" "+cycle+" "+ reg*cycle);
                }

                abs = Math.abs(cycle%40 - reg);
                if(abs<2){
                    System.out.print("#");
                }else{
                    System.out.print('.');
                }
                cycle++;
                if (cycle % 40 ==0) {
                    result += reg * cycle;
                    System.out.println();
                    // System.out.println(reg+" "+cycle+" "+ reg*cycle);
                }
                reg += amount;
            }

        }
        System.out.println(result);
    }
}




