/**
 * By Ray Toal
 */



public class SharedBirthday {

    public static void main(String[] args) {
        try {
            if (args.length != 3) {
                throw new IllegalArgumentException("Exactly three arguments required");
            }
            int people = Integer.parseInt(args[0]);
            int days = Integer.parseInt(args[1]);
            int trials = Integer.parseInt(args[2]);
            System.out.println(probabilityEstimate(people, days, trials));
        } catch (NumberFormatException e) {
            System.err.println("Arguments must all be integers");
        } catch (IllegalArgumentException e) {
            System.err.println(e.getMessage());
        }
    }
    //
    public static double probabilityEstimate(int people, int days, int trials) {
        int numDays[];
        numDays = new int[days]; 
        double sharedBdayCount = 0;
        double daysOver1Bday = 0;
        for ( int i = 1; i <= trials; i++ ) {
                sharedBdayCount = 0;
            for (int x = 0; x < numDays.length; x++) {
                numDays[x] = 0;
            }
          for (int p = 1; p <= people; p++ ) {
            int birthday = (int)(Math.random() * (days));
            numDays[birthday]++;
        } 
        for (int d = 0; d < days; d++) {
            if (numDays[d] > 1) {
                sharedBdayCount++;
            }
        }
        if (sharedBdayCount >= 1) {
            daysOver1Bday++;

        }
    }
        //
        // TODO: Do the main work here. I've just returned 0.0 as a place holder
        // so the code compiles. It isn't right though. Remove the return here and
        // implement the whole method on your own.
        //

        return (daysOver1Bday/trials);
    }
    //
    // TODO: Don't be afraid to write private helper methods to keep your code modular.
}

