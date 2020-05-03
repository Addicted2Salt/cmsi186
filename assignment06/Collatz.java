public class Collatz {

    // method to run collatz conjecture

    public static void main(String[] args) {
        if(args.length != 1) {
            System.out.println("This program requires one argument");
            System.exit(-1);
        }
        try {
            BrobInt c = new BrobInt(args[0]);
        } catch (Exception e) {
            System.out.println("Problem constructing BrobInt");
        }
        return;
    }
}