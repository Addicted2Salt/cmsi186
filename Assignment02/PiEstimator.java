/**
 * By Ray Toal
 */
public class PiEstimator {
    public static void main(String[] args) {
        System.out.println( "\n   Welcome to PiEstimator!\n" );
        int darts = 10000;
        if (args.length == 0) {
            System.out.println( "\n  No argument inputted, running with 10,000 values by default!\n" );
            System.out.println(estimate(darts));
                // use 10000 default for total darts

        } else {
            try {
            darts = Integer.parseInt( args[0] );
            if (darts <= 1) {
                System.out.println( "Enter an integer larger than 1");
            } else {
                System.out.println(estimate(darts));
            }
            //
            // TODO: Parse the command line argument 
            //
        } catch (IllegalArgumentException iae) {
            System.out.println( "Sorry, bad input: must be an integer number! Please try again...");
            System.exit( -1 );
        } catch (ArrayIndexOutOfBoundsException aiobe) {
            System.out.println( "   Sorry, bad input: must be an integer number! Please try again..." );
            System.exit( -1 );
        } 

        //
        // TODO: Call estimate() to run and print results.
       //
    }
}
    public static double estimate(int darts) {
        int dartsInCircle = 0;
        int totalDarts = 0;
        for ( int i = 1; i < darts+1; i++ ) {
            totalDarts = i;
            double x = Math.random()*2; 
            double y = Math.random()*2;
            // double xValue = Math.pow(x-1, 2);
            // double yValue = Math.pow(y-1, 2);
            // double point = (Math.sqrt(xValue+yValue));
            if ((double)(Math.sqrt(Math.pow(x-1,2)+Math.pow(y-1,2)))<1){
                dartsInCircle++;
            } else {
                dartsInCircle = dartsInCircle;
                //System.out.println(piEstimate + " ");
            }
        }
        double piEstimate = 4 * (double)dartsInCircle / totalDarts;
        //
        // TODO: Do the main work here. I've just returned 0.0 as a place holder
        // so the code compiles. It isn't right though. Remove the return here and
        // implement the whole method on your own.
        //
        return piEstimate;
    }
    //
    // Don't be afraid to put in some private "helper" methods. You don't have to, of
    // course, but they could be useful and keep your code modular.
    //
}

