import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.io.*; 
import java.util.*; 

public class SkateRampArea {

    private static final int MINIMUM_ARG_COUNT  = 3;
    private static final double DEFAULT_PERCENT = 0.01;
    private static final boolean DEBUG_MODE     = true;


    //may need more than these
    private double[]    coeffs          = null;
    private int         numCoeff        = 0;
    private String      function        = "";
    private double      currentArea     = 0.0;
    private double      previousArea    = 0.0;
    private double      epsilon         = DEFAULT_PERCENT;
    private double      lastArea        = 0.0;
    private double      prcntChange     = 100.0;
    private double      lowerBound      = 0.0;
    private double      upperBound      = 0.0;
    private DecimalFormat df = new DecimalFormat( "#00.0000" );
    private int         numRect         = 1;
    private String[] functions = { "poly", "sin", "cos", "arctan", "asin", "acos", "tanh", "cosh", "sinh" };

    public SkateRampArea () {

    }

    public void validateArgsAndSetupIntegration( String [] args ) {
        double ub = 0.0;
        double lb = 0.0;
        int i = 0;


        //checks if there are enough arguments to meet the minimum, throw an exception if not
            // if 0 args, throw error
        function = args[0];

            
        if (function.matches("poly")) {
            if (args.length < 5) {
                throw new IllegalArgumentException("Not enough arguments for a poly function.");
            }
        } else if (function.matches("sin") || function.matches("cos")) {
            if (args.length < 3) {
                throw new IllegalArgumentException("Not enough arguments for a sin or cos function.");
            }
        } else if (function.matches("atan")) {
            if (args.length < 3) {
                throw new IllegalArgumentException("Not enough arguments for an arctan function.");
            }
        } else if (function.matches("asin")) {
            if (args.length < 3) {
                throw new IllegalArgumentException("Not enough arguments for an arcsin function.");
            }
        } else if (function.matches("acos")) {
            if (args.length < 3) {
                throw new IllegalArgumentException("not enough arguments for an arccos function.");
            } 
        } else if (function.matches("sinh")) {
            if (args.length < 3) {
                throw new IllegalArgumentException("not enough arguments for an hyperbolic sin function.");
            } 
        } else if (function.matches("cosh")) {
            if (args.length < 3) {
                throw new IllegalArgumentException("not enough arguments for an hyperbolic cos function.");
            } 
        } else if (function.matches("tanh")) {
            if (args.length < 3) {
                throw new IllegalArgumentException("not enough arguments for an hyperbolic tan function.");
            } 
        }else if (
            !function.matches("poly")   || 
            !function.matches("sin")    || 
            !function.matches("cos")    ||
            !function.matches("atan")   ||
            !function.matches("acos")   ||
            !function.matches("sinh")   ||
            !function.matches("cosh")   ||
            !function.matches("tanh")   ||
            !function.matches("asin")) {
            throw new IllegalArgumentException("Unexpected function name.");
        }

        if (args[args.length - 1].contains("%")) {
            if (function.matches("poly")) {
                if (args.length < 6) {
                    throw new IllegalArgumentException("Not enough arguments for a poly function.");
                }
            } else if (function.matches("sin") || function.matches("cos")) {
                if (args.length < 4) {
                    throw new IllegalArgumentException("Not enough arguments for a sin pr cps function.");
                }
            } else if (function.matches("atan")) {
                if (args.length < 4) {
                    throw new IllegalArgumentException("Not enough arguments for an arctan function.");
                }
            } else if (function.matches("asin")) {
                if (args.length < 4) {
                    throw new IllegalArgumentException("Not enough arguments for an arcsin function.");
                }
            } else if (function.matches("acos")) {
                if (args.length < 4 ) {
                    throw new IllegalArgumentException("Not enough arguments for an arccos function.");
                }
            } else if (function.matches("cosh")) {
                if (args.length < 4 ) {
                    throw new IllegalArgumentException("Not enough arguments for an hyperbolic cos function.");
                }
            } else if (function.matches("sinh")) {
                if (args.length < 4 ) {
                    throw new IllegalArgumentException("Not enough arguments for an hyperbolic sin function.");
                }
            } else if (function.matches("tanh")) {
                if (args.length < 4 ) {
                    throw new IllegalArgumentException("Not enough arguments for an hyperbolic tan function.");
                }
            } else {
                throw new IllegalArgumentException("Please check your arguments again.");
            }

            try {
                epsilon = (Double.parseDouble( args[args.length - 1].substring( 0, args[args.length - 1].length() - 1))) / 100.0;
            } catch(NumberFormatException nfe) {
                System.out.println("Failed to parse optional percentage.");
            }
            try {
                ub = Double.parseDouble(args[args.length - 2]);
            } catch(NumberFormatException nfe) {
                System.out.println("Number Format Exception in upper bound input.");
            }
            try {
                lb = Double.parseDouble(args[args.length - 3]);
            } catch(NumberFormatException nfe) {
                System.out.println("Number Format Exception in lower bound input.");
            }
            if ( ub < lb ) {
                ub = Double.parseDouble(args[args.length - 3]);
                lb = Double.parseDouble(args[args.length - 2]);
                upperBound = ub;
                lowerBound = lb;
            } else {
                upperBound = ub;
                lowerBound = lb;
            }
        } else {
            try {
                ub = Double.parseDouble(args[args.length - 1]);
            } catch(NumberFormatException nfe) {
                System.out.println("Number Format Exception in upper bound input.");
            }
            try {
                lb = Double.parseDouble(args[args.length - 2]);
            } catch(NumberFormatException nfe) {
                System.out.println("Number Format Exception in lower bound input.");
            }
            if ( ub < lb ) {
                ub = Double.parseDouble(args[args.length - 2]);
                lb = Double.parseDouble(args[args.length - 1]);
                upperBound = ub;
                lowerBound = lb;
            } else {
                upperBound = ub;
                lowerBound = lb;
            }
        }
        //check bounds for arcsin and arccos
        if ((upperBound > 1 || lowerBound < -1) && (function.matches("asin") || function.matches("acos"))) {
            throw new IllegalArgumentException("Arcsin can only take argumnts between -1 and 1.");
        }

        if (function.matches("poly") && epsilon != DEFAULT_PERCENT) {
            numCoeff = (int)((args.length - 3) - (1));
            try {
                coeffs = new double[numCoeff];
                for ( i = 1; i <= numCoeff; i++) {
                    coeffs[i-1] = Double.parseDouble( args[i] );
                }
            } catch (Exception e) {
                System.out.println( (numCoeff - i) + "Exception in finding coefficients.");
            }
        } else if (function.matches("poly") && epsilon == DEFAULT_PERCENT) {
            numCoeff = (int)((args.length - 2) - (1));
            try {
                coeffs = new double[numCoeff];
                for ( i = 1; i <= numCoeff; i++) {
                    coeffs[i-1] = Double.parseDouble( args[i] );
                }
            } catch (Exception e) {
                System.out.println("Exception in finding coefficients.");
            }
    }
}

    public double calculateAreaPoly ( double lb, double ub, double[] coefficients, int n ) {
        int i = 0;
        int j = 0;
        double midpoint = 0.0;
        double totalArea = 0.0;
        double yCoord = 0.0;
        double rectLength = 0.0;
        numRect = n;
        //new variables (midpoint, total area, yCoord)
        // find length of rectangles
        rectLength = getLength(lb, ub, n);
        // System.out.println("Rectangles: " + n);
        // System.out.println(coeffsToString());

        for ( i = 1; i <= numRect; i++) {
            midpoint = getMidpoint(lb, rectLength, i);
            yCoord = 0.0;
            for ( j = 0; j < coeffs.length; j++ ) {
                yCoord += (coeffs[j] * Math.pow(midpoint, j));
            }
            totalArea += yCoord * rectLength;
        }

        if (n == 1) {
            currentArea = totalArea;
            previousArea = totalArea;
        } else if (n > 1) {
            currentArea = totalArea;
            updatePercentChange(currentArea, previousArea);
            previousArea = currentArea;
        }
        // System.out.println("C: " + currentArea);
        // System.out.println("P: " + previousArea);
        // System.out.println(n);
        return totalArea;
    }

    public double calculateAreaSin ( double lb, double ub, int n ) {
        int i = 0;
        double midpoint = 0.0;
        double totalArea = 0.0;
        double yCoord = 0.0;
        double rectLength = 0.0;
        numRect = n;

        rectLength = getLength(lb, ub, n);
        for ( i = 1; i <= numRect; i++) {
            midpoint = getMidpoint(lb, rectLength, i);
            yCoord = 0.0;
            yCoord = (Math.sin(midpoint));
            System.out.println("Midpoint: " + midpoint + " Y: " + yCoord + " Length: " + rectLength + " Rectangles: " + n);
            totalArea += yCoord * rectLength;
        }

        if (n == 1) {
            currentArea = totalArea;
            previousArea = totalArea;
        } else if (n > 1) {
            currentArea = totalArea;
            updatePercentChange(currentArea, previousArea);
            previousArea = currentArea;
        }
        
        return totalArea;
    }

    public double calculateAreaCos( double lb, double ub, int n ) {
        int i = 0;
        double midpoint = 0.0;
        double totalArea = 0.0;
        double yCoord = 0.0;
        double rectLength = 0.0;
        numRect = n;

        rectLength = getLength(lb, ub, n);
        for ( i = 1; i <= numRect; i++) {
            midpoint = getMidpoint(lb, rectLength, i);
            yCoord = 0.0;
            yCoord = (Math.cos(midpoint));
            System.out.println("Midpoint: " + midpoint + " Y: " + yCoord + " Length: " + rectLength + " Rectangles: " + n);
            totalArea += yCoord * rectLength;
        }

        if (n == 1) {
            currentArea = totalArea;
            previousArea = totalArea;
        } else if (n > 1) {
            currentArea = totalArea;
            updatePercentChange(currentArea, previousArea);
            previousArea = currentArea;
        }
        
        return totalArea;
    }

    public double calculateAreaArctan ( double lb, double ub, int n ) {
        int i = 0;
        double midpoint = 0.0;
        double totalArea = 0.0;
        double yCoord = 0.0;
        double rectLength = 0.0;
        numRect = n;

        rectLength = getLength(lb, ub, n);
        for ( i = 1; i <= numRect; i++) {
            midpoint = getMidpoint(lb, rectLength, i);
            yCoord = 0.0;
            yCoord = (Math.atan(midpoint));
            System.out.println("Midpoint: " + midpoint + " Y: " + yCoord + " Length: " + rectLength + " Rectangles: " + n);
            totalArea += yCoord * rectLength;
        }

        if (n == 1) {
            currentArea = totalArea;
            previousArea = totalArea;
        } else if (n > 1) {
            currentArea = totalArea;
            updatePercentChange(currentArea, previousArea);
            previousArea = currentArea;
        }
        
        return totalArea;
    }

    public double calculateAreaArcsin ( double lb, double ub, int n ) {
        int i = 0;
        double midpoint = 0.0;
        double totalArea = 0.0;
        double yCoord = 0.0;
        double rectLength = 0.0;
        numRect = n;

        rectLength = getLength(lb, ub, n);
        for ( i = 1; i <= numRect; i++) {
            midpoint = getMidpoint(lb, rectLength, i);
            yCoord = 0.0;
            yCoord = (Math.asin(midpoint));
            System.out.println("Midpoint: " + midpoint + " Y: " + yCoord + " Length: " + rectLength + " Rectangles: " + n);
            totalArea += yCoord * rectLength;
        }

        if (n == 1) {
            currentArea = totalArea;
            previousArea = totalArea;
        } else if (n > 1) {
            currentArea = totalArea;
            updatePercentChange(currentArea, previousArea);
            previousArea = currentArea;
        }
        
        return totalArea;
    }

    public double calculateAreaArccos ( double lb, double ub, int n ) {
        int i = 0;
        double midpoint = 0.0;
        double totalArea = 0.0;
        double yCoord = 0.0;
        double rectLength = 0.0;
        numRect = n;

        rectLength = getLength(lb, ub, n);
        for ( i = 1; i <= numRect; i++) {
            midpoint = getMidpoint(lb, rectLength, i);
            yCoord = 0.0;
            yCoord = (Math.acos(midpoint));
            System.out.println("Midpoint: " + midpoint + " Y: " + yCoord + " Length: " + rectLength + " Rectangles: " + n);
            totalArea += yCoord * rectLength;
        }

        if (n == 1) {
            currentArea = totalArea;
            previousArea = totalArea;
        } else if (n > 1) {
            currentArea = totalArea;
            updatePercentChange(currentArea, previousArea);
            previousArea = currentArea;
        }
        
        return totalArea;
    }

    public double calculateAreaTanh ( double lb, double ub, int n ) {
        int i = 0;
        double midpoint = 0.0;
        double totalArea = 0.0;
        double yCoord = 0.0;
        double rectLength = 0.0;
        numRect = n;

        rectLength = getLength(lb, ub, n);
        for ( i = 1; i <= numRect; i++) {
            midpoint = getMidpoint(lb, rectLength, i);
            yCoord = 0.0;
            yCoord = (Math.tanh(midpoint));
            System.out.println("Midpoint: " + midpoint + " Y: " + yCoord + " Length: " + rectLength + " Rectangles: " + n);
            totalArea += yCoord * rectLength;
        }

        if (n == 1) {
            currentArea = totalArea;
            previousArea = totalArea;
        } else if (n > 1) {
            currentArea = totalArea;
            updatePercentChange(currentArea, previousArea);
            previousArea = currentArea;
        }
        
        return totalArea;
    }

    public double calculateAreaCosh ( double lb, double ub, int n ) {
        int i = 0;
        double midpoint = 0.0;
        double totalArea = 0.0;
        double yCoord = 0.0;
        double rectLength = 0.0;
        numRect = n;

        rectLength = getLength(lb, ub, n);
        for ( i = 1; i <= numRect; i++) {
            midpoint = getMidpoint(lb, rectLength, i);
            yCoord = 0.0;
            yCoord = (Math.cosh(midpoint));
            System.out.println("Midpoint: " + midpoint + " Y: " + yCoord + " Length: " + rectLength + " Rectangles: " + n);
            totalArea += yCoord * rectLength;
        }

        if (n == 1) {
            currentArea = totalArea;
            previousArea = totalArea;
        } else if (n > 1) {
            currentArea = totalArea;
            updatePercentChange(currentArea, previousArea);
            previousArea = currentArea;
        }
        
        return totalArea;
    }

    public double calculateAreaSinh ( double lb, double ub, int n ) {
        int i = 0;
        double midpoint = 0.0;
        double totalArea = 0.0;
        double yCoord = 0.0;
        double rectLength = 0.0;
        numRect = n;

        rectLength = getLength(lb, ub, n);
        for ( i = 1; i <= numRect; i++) {
            midpoint = getMidpoint(lb, rectLength, i);
            yCoord = 0.0;
            yCoord = (Math.sinh(midpoint));
            System.out.println("Midpoint: " + midpoint + " Y: " + yCoord + " Length: " + rectLength + " Rectangles: " + n);
            totalArea += yCoord * rectLength;
        }

        if (n == 1) {
            currentArea = totalArea;
            previousArea = totalArea;
        } else if (n > 1) {
            currentArea = totalArea;
            updatePercentChange(currentArea, previousArea);
            previousArea = currentArea;
        }
        
        return totalArea;
    }

    public double updatePercentChange (double cArea, double pArea) {
        prcntChange = Math.abs(1 - (cArea / pArea));
        return prcntChange;
    }

    public String coeffsToString () {
        String coeffString = Arrays.toString(coeffs);
        return coeffString;
    }
    public double getLength (double lb, double ub, int numRect) {
        double length = ( ub - lb ) / numRect;
        return length;
    }

    public double getMidpoint ( double lb, double length, int rectNum) {
        double midpoint = lb + (( length / 2 ) * (( rectNum * 2 ) - 1));
        return midpoint;
    }

    public static void main( String[] args ) {
        System.out.println( "\n   Welcome to my SkateRampArea program!" );
        System.out.println( "\n   This program allows you to estimate the area of the following functions: \n");
        System.out.println( "     <poly:    <coefficients, lower bound, upper bound, optional %> >");
        System.out.println( "     <sin:     <lower bound, upper bound, optional %> >");
        System.out.println( "     <cos:     <lower bound, upper bound, optional %> >");
        System.out.println( "     <tan:     <lower bound, upper bound, optional %> >");
        System.out.println( "     <asin:    <lower bound [>= -1], upper bound [<= 1], optional %> >");
        System.out.println( "     <acos:    <lower bound [>= -1], upper bound [<= 1], optional %> >");
        System.out.println( "     <atan:    <lower bound, upper bound, optional %> >");
        System.out.println( "     <sinh:    <lower bound, upper bound, optional %> >");
        System.out.println( "     <cosh:    <lower bound, upper bound, optional %> >");
        System.out.println( "     <sinh:    <lower bound, upper bound, optional %> >");

        
        //change name before turn in
        SkateRampArea sk8erBoi = new SkateRampArea();

        try {
            sk8erBoi.validateArgsAndSetupIntegration(args);
        } catch( IllegalArgumentException iae) {
            System.out.println("Error with arguments or setup.");
            System.exit(-1);
        }

        if (sk8erBoi.function.matches("poly")) {
            int i = 1;
            while (sk8erBoi.prcntChange > sk8erBoi.epsilon) {
                System.out.println(sk8erBoi.calculateAreaPoly(sk8erBoi.lowerBound, sk8erBoi.upperBound, sk8erBoi.coeffs, i));
                i += 1;
                System.out.println(sk8erBoi.function + " " + " " + sk8erBoi.prcntChange + "\n");
            }
            sk8erBoi.lastArea = sk8erBoi.currentArea;
            System.out.println("Final Area: " + sk8erBoi.lastArea + " " + sk8erBoi.numRect + " rectangles were used.");
        } else if (sk8erBoi.function.matches("sin")) {
            int i = 1;
            while (sk8erBoi.prcntChange > sk8erBoi.epsilon) {
                System.out.println(sk8erBoi.calculateAreaSin(sk8erBoi.lowerBound, sk8erBoi.upperBound, i));
                i += 1;
                System.out.println(sk8erBoi.function + " " + " " + sk8erBoi.prcntChange + "\n");
            }
            sk8erBoi.lastArea = sk8erBoi.currentArea;
            System.out.println("Final Area: " + sk8erBoi.lastArea + " " + sk8erBoi.numRect + " rectangles were used.");
        } else if (sk8erBoi.function.matches("cos")) {
            int i = 1;
            while (sk8erBoi.prcntChange > sk8erBoi.epsilon) {
                System.out.println(sk8erBoi.calculateAreaCos(sk8erBoi.lowerBound, sk8erBoi.upperBound, i));
                i += 1;
                System.out.println(sk8erBoi.function + " " + " " + sk8erBoi.prcntChange + "\n");
            }
            sk8erBoi.lastArea = sk8erBoi.currentArea;
            System.out.println("Final Area: " + sk8erBoi.lastArea + " " + sk8erBoi.numRect + " rectangles were used.");
        } else if (sk8erBoi.function.matches("atan")) {
            int i = 1;
            while (sk8erBoi.prcntChange > sk8erBoi.epsilon) {
                System.out.println(sk8erBoi.calculateAreaArctan(sk8erBoi.lowerBound, sk8erBoi.upperBound, i));
                i += 1;
                System.out.println(sk8erBoi.function + " " + " " + sk8erBoi.prcntChange + "\n");
            }
            sk8erBoi.lastArea = sk8erBoi.currentArea;
            System.out.println("Final Area: " + sk8erBoi.lastArea + " " + sk8erBoi.numRect + " rectangles were used.");
        } else if (sk8erBoi.function.matches("asin")) {
            int i = 1;
            while (sk8erBoi.prcntChange > sk8erBoi.epsilon) {
                System.out.println(sk8erBoi.calculateAreaArcsin(sk8erBoi.lowerBound, sk8erBoi.upperBound, i));
                i += 1;
                System.out.println(sk8erBoi.function + " " + " " + sk8erBoi.prcntChange + "\n");
            }
            sk8erBoi.lastArea = sk8erBoi.currentArea;
            System.out.println("Final Area: " + sk8erBoi.lastArea + " " + sk8erBoi.numRect + " rectangles were used.");
        } else if (sk8erBoi.function.matches("acos")) {
            int i = 1;
            while (sk8erBoi.prcntChange > sk8erBoi.epsilon) {
                System.out.println(sk8erBoi.calculateAreaArccos(sk8erBoi.lowerBound, sk8erBoi.upperBound, i));
                i += 1;
                System.out.println(sk8erBoi.function + " " + " " + sk8erBoi.prcntChange + "\n");
            }
            sk8erBoi.lastArea = sk8erBoi.currentArea;
            System.out.println("Final Area: " + sk8erBoi.lastArea + " " + sk8erBoi.numRect + " rectangles were used.");
        } else if (sk8erBoi.function.matches("cosh")) {
            int i = 1;
            while (sk8erBoi.prcntChange > sk8erBoi.epsilon) {
                System.out.println(sk8erBoi.calculateAreaCosh(sk8erBoi.lowerBound, sk8erBoi.upperBound, i));
                i += 1;
                System.out.println(sk8erBoi.function + " " + " " + sk8erBoi.prcntChange + "\n");
            }
            sk8erBoi.lastArea = sk8erBoi.currentArea;
            System.out.println("Final Area: " + sk8erBoi.lastArea + " " + sk8erBoi.numRect + " rectangles were used.");
        } else if (sk8erBoi.function.matches("sinh")) {
            int i = 1;
            while (sk8erBoi.prcntChange > sk8erBoi.epsilon) {
                System.out.println(sk8erBoi.calculateAreaSinh(sk8erBoi.lowerBound, sk8erBoi.upperBound, i));
                i += 1;
                System.out.println(sk8erBoi.function + " " + " " + sk8erBoi.prcntChange + "\n");
            }
            sk8erBoi.lastArea = sk8erBoi.currentArea;
            System.out.println("Final Area: " + sk8erBoi.lastArea + " " + sk8erBoi.numRect + " rectangles were used.");
        } else if (sk8erBoi.function.matches("tanh")) {
            int i = 1;
            while (sk8erBoi.prcntChange > sk8erBoi.epsilon) {
                System.out.println(sk8erBoi.calculateAreaTanh(sk8erBoi.lowerBound, sk8erBoi.upperBound, i));
                i += 1;
                System.out.println(sk8erBoi.function + " " + " " + sk8erBoi.prcntChange + "\n");
            }
            sk8erBoi.lastArea = sk8erBoi.currentArea;
            System.out.println("Final Area: " + sk8erBoi.lastArea + " " + sk8erBoi.numRect + " rectangles were used.");        }
    }
}
