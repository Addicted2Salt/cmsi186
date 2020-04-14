import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.io.*; 
import java.util.*; 

public class SkateRampArea {

    private static final int MINIMUM_ARG_COUNT  = 3;
    private static final double DEFAULT_PERCENT = 0.01;
    private static final boolean DEBUG_MODE     = true;


    //may need more than these
    private double[]    coeffs               = null;
    private int         numCoeff             = 0;
    private String      function             = "";
    private double      currentArea          = 0.0;
    private String      currentAreaString    = "";
    private double      previousArea         = 0.0;
    private double      epsilon              = DEFAULT_PERCENT;
    private String      lastArea             = "";
    private double      prcntChange          = 100.0;
    private String      prcntChangeString    = "";
    private double      lowerBound           = 0.0;
    private double      upperBound           = 0.0;
    private DecimalFormat df = new DecimalFormat( "#00.0000" );
    private int         numRect         = 1;

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
        } else if (function.matches("runtests")) {
            if (args.length > 1) {
                throw new IllegalArgumentException("too many arguments for tests.");
            }
        } else if (
            !function.matches("poly")   || 
            !function.matches("sin")    || 
            !function.matches("cos")    ||
            !function.matches("atan")   ||
            !function.matches("acos")   ||
            !function.matches("sinh")   ||
            !function.matches("cosh")   ||
            !function.matches("tanh")   ||
            !function.matches("runtests") ||
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
            currentAreaString = df.format(currentArea);
            previousArea = totalArea;
        } else if (n > 1) {
            currentArea = totalArea;
            currentAreaString = df.format(currentArea);
            updatePercentChange(currentArea, previousArea);
            previousArea = currentArea;
            lastArea = df.format(currentArea);
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
            totalArea += yCoord * rectLength;
        }

        if (n == 1) {
            currentArea = totalArea;
            currentAreaString = df.format(currentArea);
            previousArea = totalArea;
        } else if (n > 1) {
            currentArea = totalArea;
            currentAreaString = df.format(currentArea);
            updatePercentChange(currentArea, previousArea);
            previousArea = currentArea;
            lastArea = df.format(currentArea);
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
            totalArea += yCoord * rectLength;
        }

        if (n == 1) {
            currentArea = totalArea;
            currentAreaString = df.format(currentArea);
            previousArea = totalArea;
        } else if (n > 1) {
            currentArea = totalArea;
            currentAreaString = df.format(currentArea);
            updatePercentChange(currentArea, previousArea);
            previousArea = currentArea;
            lastArea = df.format(currentArea);
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
            totalArea += yCoord * rectLength;
        }

        if (n == 1) {
            currentArea = totalArea;
            currentAreaString = df.format(currentArea);
            previousArea = totalArea;
        } else if (n > 1) {
            currentArea = totalArea;
            currentAreaString = df.format(currentArea);
            updatePercentChange(currentArea, previousArea);
            previousArea = currentArea;
            lastArea = df.format(currentArea);
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
            totalArea += yCoord * rectLength;
        }

        if (n == 1) {
            currentArea = totalArea;
            currentAreaString = df.format(currentArea);
            previousArea = totalArea;
        } else if (n > 1) {
            currentArea = totalArea;
            currentAreaString = df.format(currentArea);
            updatePercentChange(currentArea, previousArea);
            previousArea = currentArea;
            lastArea = df.format(currentArea);
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
            totalArea += yCoord * rectLength;
        }

        if (n == 1) {
            currentArea = totalArea;
            currentAreaString = df.format(currentArea);
            previousArea = totalArea;
        } else if (n > 1) {
            currentArea = totalArea;
            currentAreaString = df.format(currentArea);
            updatePercentChange(currentArea, previousArea);
            previousArea = currentArea;
            lastArea = df.format(currentArea);
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
            totalArea += yCoord * rectLength;
        }

        if (n == 1) {
            currentArea = totalArea;
            currentAreaString = df.format(currentArea);
            previousArea = totalArea;
        } else if (n > 1) {
            currentArea = totalArea;
            currentAreaString = df.format(currentArea);
            updatePercentChange(currentArea, previousArea);
            previousArea = currentArea;
            lastArea = df.format(currentArea);
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
            totalArea += yCoord * rectLength;
        }

        if (n == 1) {
            currentArea = totalArea;
            currentAreaString = df.format(currentArea);
            previousArea = totalArea;
        } else if (n > 1) {
            currentArea = totalArea;
            currentAreaString = df.format(currentArea);
            updatePercentChange(currentArea, previousArea);
            previousArea = currentArea;
            lastArea = df.format(currentArea);
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
            totalArea += yCoord * rectLength;
        }

        if (n == 1) {
            currentArea = totalArea;
            currentAreaString = df.format(currentArea);
            previousArea = totalArea;
        } else if (n > 1) {
            currentArea = totalArea;
            currentAreaString = df.format(currentArea);
            updatePercentChange(currentArea, previousArea);
            previousArea = currentArea;
            lastArea = df.format(currentArea);
        }
        
        return totalArea;
    }

    public String updatePercentChange (double cArea, double pArea) {
        prcntChange = Math.abs(1 - (cArea / pArea));
        prcntChangeString = df.format(prcntChange);
        return prcntChangeString;
    }

    public double getLength (double lb, double ub, int numRect) {
        double length = ( ub - lb ) / numRect;
        return length;
    }

    public double getMidpoint ( double lb, double length, int rectNum) {
        double midpoint = lb + (( length / 2 ) * (( rectNum * 2 ) - 1));
        return midpoint;
    }

    public void runtests () {
        double midpoint = 0.0;
        double rectLength = 0.0;

        double aub1 = 0.99;
        double aub2 = -0.01;
        double aub3 = 0.45;
        double aub4 = -0.2;
        double aub5 = 0.99;
        double aub6 = 0.89;
        double aub7 = 0.765;
        double aub8 = 0.54;
        double aub9 = 0.873;
        double aub10 = 0.234;
        double alb1 = 0.45;
        double alb2 = -0.45;
        double alb3 = -0.987;
        double alb4 = -0.7632;
        double alb5 = -0.6542;
        double alb6 = 0.4235;
        double alb7 = 0.4655;
        double alb8 = 0.4445;
        double alb9 = -0.545;
        double alb10 = -0.25;
        double[] aupperBounds = {aub1, aub2, aub3, aub4, aub5, aub6, aub7, aub8, aub9, aub10};
        double[] alowerBounds = {alb1, alb2, alb3, alb4, alb5, alb6, alb7, alb8, alb9, alb10};
        double[] co1 = {10, 2, -3};
        double[] co2 = {-4, -7, -3, -54};
        double[] co3 = {6, 12, -34, -4};
        double[] co4 = {0, -2, -13, 5, 6};
        double[] co5 = {13, 12, -3, 0, 9};
        double[] co6 = {10, 21, -23, 1};
        double[] co7 = {10, 20, -3};
        double[] co8 = {-400, 2, -30};
        double[] co9 = {2, -3};
        double[] co10 = {11, -232, -3};
        double ub1   = 2.0;
        double ub2   = -12.0;
        double ub3   = -232.0;
        double ub4   = 32.0;
        double ub5   = 62.0;
        double ub6   = 342.0;
        double ub7   = 82.0;
        double ub8   = 122.0;
        double ub9   = -432.0;
        double ub10   = 2.2345;
        double lb1  = -3.2;
        double lb2  = -153.2;
        double lb3  = -63.2;
        double lb4  = 3.2;
        double lb5  = 53.2;
        double lb6  = 53.2;
        double lb7  = 55.2;
        double lb8  = 53.2;
        double lb9  = -553.2;
        double lb10  = -1.2;
        double[]    upperBounds = {ub1, ub2, ub3, ub4, ub5, ub6, ub7, ub8, ub9, ub10};
        double[]    lowerBounds = {lb1, lb2, lb3, lb4, lb5, lb6, lb7, lb8, lb9, lb10};
        double[][] polyArray = {co1, co2, co3, co4, co5, co6, co7, co8, co9, co10};

        System.out.println("**********NOW RUNNING 10 TESTS PER METHOD********** \n \n");
        System.out.println("*****TESTING GET MIDPOINT***** \n \n");
        midpoint = getMidpoint(5, 26, 1);
        System.out.println("<Lower Bound: 5> <Length: 26> \n<Midpoint: " + midpoint + ">");
        midpoint = getMidpoint(-5, 3, 1);
        System.out.println("<Lower Bound: -5> <Length: 3> \n<Midpoint: " + midpoint + ">");
        midpoint = getMidpoint(6, 12, 1);
        System.out.println("<Lower Bound: 6> <Length: 12> \n<Midpoint: " + midpoint + ">");
        midpoint = getMidpoint(1, 15, 1);
        System.out.println("<Lower Bound: 1> <Length: 15> \n<Midpoint: " + midpoint + ">");
        midpoint = getMidpoint(-7, 7, 1);
        System.out.println("<Lower Bound: -7> <Length: 7> \n<Midpoint: " + midpoint + ">");
        midpoint = getMidpoint(-9.3, 18, 1);
        System.out.println("<Lower Bound: -9.3> <Length: 18> \n<Midpoint: " + midpoint + ">");
        midpoint = getMidpoint(12, 4, 1);
        System.out.println("<Lower Bound: 12> <Length: 4> \n<Midpoint: " + midpoint + ">");
        midpoint = getMidpoint(4, 0.25, 1);
        System.out.println("<Lower Bound: 4> <Length: 0.25> \n<Midpoint: " + midpoint + ">");
        midpoint = getMidpoint(6.7, 3.6, 1);
        System.out.println("<Lower Bound: 6.7> <Length: 3.6> \n<Midpoint: " + midpoint + ">");
        midpoint = getMidpoint(2, 0.47, 1);
        System.out.println("<Lower Bound: 2> <Length: 0.47> \n<Midpoint: " + midpoint + ">");

        System.out.println("\n \n*****TESTING GET LENGTH***** \n \n");
        rectLength = getLength(-9.4, 14, 16);
        System.out.println("<Lower bound: -9.4> <Length: 14> <Num of Rectangles: 16> \n<Length: " + df.format(rectLength) + ">");
        rectLength = getLength(-0.01, 3.2, 8);
        System.out.println("<Lower bound: -0.01> <Length: 3.2> <Num of Rectangles: 8> \n<Length: " + df.format(rectLength) + ">");
        rectLength = getLength(5.5, 6.4, 9);
        System.out.println("<Lower bound: 5.5> <Length: 6.4> <Num of Rectangles: 9> \n<Length: " + df.format(rectLength) + ">");
        rectLength = getLength(6.7, 7.4, 16);
        System.out.println("<Lower bound: 6.7> <Length: 7.4> <Num of Rectangles: 16> \n<Length: " + df.format(rectLength) + ">");
        rectLength = getLength(-8.4, 16.7, 42);
        System.out.println("<Lower bound: -8.4> <Length: 16.7> <Num of Rectangles: 42> \n<Length: " + df.format(rectLength) + ">");
        rectLength = getLength(-1, 11.7, 24);
        System.out.println("<Lower bound: -1> <Length: 11.7> <Num of Rectangles: 24> \n<Length: " + df.format(rectLength) + ">");
        rectLength = getLength(-3, 82, 100);
        System.out.println("<Lower bound: -3> <Length: 82> <Num of Rectangles: 100> \n<Length: " + df.format(rectLength) + ">");
        rectLength = getLength(-9.4, 6, 92);
        System.out.println("<Lower bound: -9.4> <Length: 6> <Num of Rectangles: 92> \n<Length: " + df.format(rectLength) + ">");
        rectLength = getLength(-9.465, 18.456, 16);
        System.out.println("<Lower bound: -9.465> <Length: 18.456> <Num of Rectangles: 16> \n<Length: " + df.format(rectLength) + ">");
        rectLength = getLength(7.4, 16.456, 94);
        System.out.println("<Lower bound: 7.4> <Length: 16.456> <Num of Rectangles: 94> \n<Length: " + df.format(rectLength) + ">");

        System.out.println("\n \n*****TESTING UPDATE PERCENT CHANGE***** \n \n");
        updatePercentChange(100, 97);
        System.out.println("<Current Area: 100> <Previous Area: 97> \n<PercentChange: " + prcntChangeString + "%");
        updatePercentChange(47, 8);
        System.out.println("<Current Area: 47> <Previous Area: 8> \n<PercentChange: " + prcntChangeString + "%");
        updatePercentChange(11548.4562, 2674.1564);
        System.out.println("<Current Area: 11548.4562> <Previous Area: 2674.1564> \n<PercentChange: " + prcntChangeString + "%");
        updatePercentChange(19453.65431, 9864.3546);
        System.out.println("<Current Area: 19453.65431> <Previous Area: 9864.3546> \n<PercentChange: " + prcntChangeString + "%");
        updatePercentChange(32.126, 432.12);
        System.out.println("<Current Area: 32.126> <Previous Area: 432.12> \n<PercentChange: " + prcntChangeString + "%");
        updatePercentChange(2.156, 43);
        System.out.println("<Current Area: 2.156> <Previous Area: 43> \n<PercentChange: " + prcntChangeString + "%");
        updatePercentChange(6.54, 42.3);
        System.out.println("<Current Area: 6.54> <Previous Area: 42.3> \n<PercentChange: " + prcntChangeString + "%");
        updatePercentChange(112674.123, 45631.123);
        System.out.println("<Current Area: 112674.123> <Previous Area: 45631.123> \n<PercentChange: " + prcntChangeString + "%");
        updatePercentChange(654.1235, 5641.2);
        System.out.println("<Current Area: 654.1235> <Previous Area: 5641.2> \n<PercentChange: " + prcntChangeString + "%");
        updatePercentChange(43654, 35441);
        System.out.println("<Current Area: 43654> <Previous Area: 35441> \n<PercentChange: " + prcntChangeString + "%");

        System.out.println("\n \n*****TESTING CALCULATE POLYNOMIAL AREA*****");
        System.out.println("*****FIRST FIVE TESTS WITH DEFAULT EPSILON***** \n \n");
        for ( int j = 0; j < polyArray.length; j++){
            epsilon = DEFAULT_PERCENT;
            if (j > 4) {
                epsilon = (j*0.4 - .2*j)/100 ;
            }
            coeffs = polyArray[j];
            upperBound = upperBounds[j];
            lowerBound = lowerBounds[j];
            prcntChange = 100.0;
            System.out.println("<Coefficients: " + Arrays.toString(polyArray[j]) + ">");
            System.out.println("<Lower Bound: " + lowerBounds[j] + ">  <Upper Bound: " + upperBounds[j] + ">" + "  <Target Percent Difference: " + epsilon*100 + "% >"); 
            int i = 0;
            while (prcntChange > epsilon) {
                calculateAreaPoly(lowerBounds[j], upperBounds[j], polyArray[j], i);
                i += 1;
            }
            System.out.println("Area: " + lastArea + " \n" + numRect + " rectangles were used. \n");
        }   

        System.out.println("\n \n*****TESTING CALCULATE SINE AREA***** \n \n");
        System.out.println("*****FIRST FIVE TESTS WITH DEFAULT EPSILON***** \n \n");
        System.out.println("Using bounds from poly function.\n");
        for (int j = 0; j < 10; j++ ) {
            epsilon = DEFAULT_PERCENT;
            if (j > 4) {
                epsilon = (j*0.4 - .2*j)/100 ;
            }
            upperBound = upperBounds[j];
            lowerBound = lowerBounds[j];
            prcntChange = 100.0;
            System.out.println("<Lower Bound: " + lowerBounds[j] + ">  <Upper Bound: " + upperBounds[j] + ">" + "  <Target Percent Difference: " + epsilon*100 + "% >"); 
            int i = 0;
            while (prcntChange > epsilon) {
                calculateAreaSin(lowerBound, upperBound, i);
                i += 1;
            }
            System.out.println("Area: " + lastArea + " \n" + numRect + " rectangles were used. \n");
        }

        System.out.println("\n \n*****TESTING CALCULATE COSINE AREA***** \n \n");
        System.out.println("*****FIRST FIVE TESTS WITH DEFAULT EPSILON***** \n \n");
        System.out.println("Using bounds from poly function.\n");
        for (int j = 0; j < 10; j++ ) {
            epsilon = DEFAULT_PERCENT;
            if (j > 4) {
                epsilon = (j*0.4 - .2*j)/100 ;
            }
            upperBound = upperBounds[j];
            lowerBound = lowerBounds[j];
            prcntChange = 100.0;
            System.out.println("<Lower Bound: " + lowerBounds[j] + "> Upper Bound: " + upperBounds[j] + ">" + "  <Target Percent Difference: " + epsilon*100 + "% >"); 
            int i = 0;
            while (prcntChange > epsilon) {
                calculateAreaCos(lowerBound, upperBound, i);
                i += 1;
            }
            System.out.println("Area: " + lastArea + " \n" + numRect + " rectangles were used. \n");
        }

        System.out.println("\n \n*****TESTING CALCULATE INVERSE SINE AREA***** \n \n");
        System.out.println("*****FIRST FIVE TESTS WITH DEFAULT EPSILON***** \n \n");
        for (int j = 0; j < 10; j++ ) {
            epsilon = DEFAULT_PERCENT;
            if (j > 4) {
                epsilon = (j*0.4 - .2*j)/100 ;
            }
            upperBound = aupperBounds[j];
            lowerBound = alowerBounds[j];
            prcntChange = 100.0;
            System.out.println("<Lower Bound: " + alowerBounds[j] + "> Upper Bound: " + aupperBounds[j] + ">" + "  <Target Percent Difference: " + epsilon*100 + "% >");
            int i = 0;
            while (prcntChange > epsilon) {
                calculateAreaArcsin(lowerBound, upperBound, i);
                i += 1;
            }
            System.out.println("Area: " + lastArea + " \n" + numRect + " rectangles were used. \n");
        }

        System.out.println("\n \n*****TESTING CALCULATE INVERSE COSINE AREA***** \n \n");
        System.out.println("*****FIRST FIVE TESTS WITH DEFAULT EPSILON***** \n \n");
        for (int j = 0; j < 10; j++ ) {
            epsilon = DEFAULT_PERCENT;
            if (j > 4) {
                epsilon = (j*0.4 - .2*j)/100 ;
            }
            upperBound = aupperBounds[j];
            lowerBound = alowerBounds[j];
            prcntChange = 100.0;
            System.out.println("<Lower Bound: " + alowerBounds[j] + "> Upper Bound: " + aupperBounds[j] + ">" + "  <Target Percent Difference: " + epsilon*100 + "% >");
            int i = 0;
            while (prcntChange > epsilon) {
                calculateAreaArccos(lowerBound, upperBound, i);
                i += 1;
            }
            System.out.println("Area: " + lastArea + " \n" + numRect + " rectangles were used. \n");
        }

        System.out.println("\n \n*****TESTING CALCULATE INVERSE TANGENT AREA***** \n \n");
        System.out.println("*****FIRST FIVE TESTS WITH DEFAULT EPSILON***** \n \n");
        System.out.println("Using bounds from poly function.\n");
        for (int j = 0; j < 10; j++ ) {
            epsilon = DEFAULT_PERCENT;
            if (j > 4) {
                epsilon = (j*0.4 - .2*j)/100 ;
            }
            upperBound = upperBounds[j];
            lowerBound = lowerBounds[j];
            prcntChange = 100.0;
            System.out.println("<Lower Bound: " + lowerBounds[j] + "> Upper Bound: " + upperBounds[j] + ">" + "  <Target Percent Difference: " + epsilon*100 + "% >"); 
            int i = 0;
            while (prcntChange > epsilon) {
                calculateAreaArctan(lowerBound, upperBound, i);
                i += 1;
            }
            System.out.println("Area: " + lastArea + " \n" + numRect + " rectangles were used. \n");
        }

        System.out.println("\n \n*****TESTING CALCULATE HYPERBOLIC SINE AREA***** \n \n");
        System.out.println("*****FIRST FIVE TESTS WITH DEFAULT EPSILON***** \n \n");
        System.out.println("Using bounds from poly function.\n");
        for (int j = 0; j < 10; j++ ) {
            epsilon = DEFAULT_PERCENT;
            if (j > 4) {
                epsilon = (j*0.4 - .2*j)/100 ;
            }
            upperBound = upperBounds[j];
            lowerBound = lowerBounds[j];
            prcntChange = 100.0;
            System.out.println("<Lower Bound: " + lowerBounds[j] + "> Upper Bound: " + upperBounds[j] + ">" + "  <Target Percent Difference: " + epsilon*100 + "% >"); 
            int i = 0;
            while (prcntChange > epsilon) {
                calculateAreaSinh(lowerBound, upperBound, i);
                i += 1;
            }
            System.out.println("Area: " + lastArea + " \n" + numRect + " rectangles were used. \n");
        }

        
        System.out.println("\n \n*****TESTING CALCULATE HYPERBOLIC COSINE AREA***** \n \n");
        System.out.println("*****FIRST FIVE TESTS WITH DEFAULT EPSILON***** \n \n");
        System.out.println("Using bounds from poly function.\n");
        for (int j = 0; j < 10; j++ ) {
            epsilon = DEFAULT_PERCENT;
            if (j > 4) {
                epsilon = (j*0.4 - .2*j)/100 ;
            }
            upperBound = upperBounds[j];
            lowerBound = lowerBounds[j];
            prcntChange = 100.0;
            System.out.println("<Lower Bound: " + lowerBounds[j] + "> Upper Bound: " + upperBounds[j] + ">" + "  <Target Percent Difference: " + epsilon*100 + "% >"); 
            int i = 0;
            while (prcntChange > epsilon) {
                calculateAreaCosh(lowerBound, upperBound, i);
                i += 1;
            }
            System.out.println("Area: " + lastArea + " \n" + numRect + " rectangles were used. \n");
        }

        
        System.out.println("\n \n*****TESTING CALCULATE HYPERBOLIC TANGENT AREA***** \n \n");
        System.out.println("*****FIRST FIVE TESTS WITH DEFAULT EPSILON***** \n \n");
        System.out.println("Using bounds from poly function.\n");
        for (int j = 0; j < 10; j++ ) {
            epsilon = DEFAULT_PERCENT;
            if (j > 4) {
                epsilon = (j*0.4 - .2*j)/100 ;
            }
            upperBound = upperBounds[j];
            lowerBound = lowerBounds[j];
            prcntChange = 100.0;
            System.out.println("<Lower Bound: " + lowerBounds[j] + "> Upper Bound: " + upperBounds[j] + ">" + "  <Target Percent Difference: " + epsilon*100 + "% >"); 
            int i = 0;
            while (prcntChange > epsilon) {
                calculateAreaTanh(lowerBound, upperBound, i);
                i += 1;
            }
            System.out.println("Area: " + lastArea + " \n" + numRect + " rectangles were used. \n");
        }

    }

    public static void main( String[] args ) {
        System.out.println(args[0]);
        //change name before turn in
        SkateRampArea sk8erBoi = new SkateRampArea();
        if (args[0].matches("runtests")) {
            sk8erBoi.runtests();
        } else {
        System.out.println( "\n   Welcome to my SkateRampArea program!" );
        System.out.println( "\n   This program allows you to estimate the area of the following functions: \n");
        System.out.println( "     <poly:    <coefficients, lower bound, upper bound, optional %> >");
        System.out.println( "     <sin:     <lower bound, upper bound, optional %> >");
        System.out.println( "     <cos:     <lower bound, upper bound, optional %> >");
        System.out.println( "     <asin:    <lower bound [>= -1], upper bound [<= 1], optional %> >");
        System.out.println( "     <acos:    <lower bound [>= -1], upper bound [<= 1], optional %> >");
        System.out.println( "     <atan:    <lower bound, upper bound, optional %> >");
        System.out.println( "     <sinh:    <lower bound, upper bound, optional %> >");
        System.out.println( "     <cosh:    <lower bound, upper bound, optional %> >");
        System.out.println( "     <sinh:    <lower bound, upper bound, optional %> >\n \n");

        try {
            sk8erBoi.validateArgsAndSetupIntegration(args);
        } catch( IllegalArgumentException iae) {
            System.out.println("Error with arguments or setup.");
            System.exit(-1);
        }

        if (sk8erBoi.function.matches("poly")) {
            System.out.println("Calculating a polynomial function. \n");
            int i = 1;
            while (sk8erBoi.prcntChange > sk8erBoi.epsilon) {
                sk8erBoi.calculateAreaPoly(sk8erBoi.lowerBound, sk8erBoi.upperBound, sk8erBoi.coeffs, i);
                i += 1;
                System.out.println("Rectangles: " + i);
                System.out.println("Current Area: " + sk8erBoi.currentAreaString);
                System.out.println(sk8erBoi.prcntChangeString + "% change \n");
            }
            System.out.println(sk8erBoi.prcntChangeString + " is less than " + sk8erBoi.epsilon );
            System.out.println("Final Area: " + sk8erBoi.lastArea + " \n" + sk8erBoi.numRect + " rectangles were used. \n \n");
        } else if (sk8erBoi.function.matches("sin")) {
            System.out.println("Calculating a sine function.\n");
            int i = 1;
            while (sk8erBoi.prcntChange > sk8erBoi.epsilon) {
                sk8erBoi.calculateAreaSin(sk8erBoi.lowerBound, sk8erBoi.upperBound, i);
                i += 1;
                System.out.println("Rectangles: " + i);
                System.out.println("Current Area: " + sk8erBoi.currentAreaString);
                System.out.println(sk8erBoi.prcntChangeString + "% change \n");
            }
            System.out.println("Final Area: " + sk8erBoi.lastArea + " \n" + sk8erBoi.numRect + " rectangles were used. \n \n");
        } else if (sk8erBoi.function.matches("cos")) {
            System.out.println("Calculating a cosine function.\n");
            int i = 1;
            while (sk8erBoi.prcntChange > sk8erBoi.epsilon) {
                sk8erBoi.calculateAreaCos(sk8erBoi.lowerBound, sk8erBoi.upperBound, i);
                i += 1;
                System.out.println("Rectangles: " + i);
                System.out.println("Current Area: " + sk8erBoi.currentAreaString);
                System.out.println(sk8erBoi.prcntChangeString + "% change \n");
            }
            System.out.println("Final Area: " + sk8erBoi.lastArea + " \n" + sk8erBoi.numRect + " rectangles were used. \n \n");
        } else if (sk8erBoi.function.matches("atan")) {
            System.out.println("Calculating a inverse tangent function.\n");
            int i = 1;
            while (sk8erBoi.prcntChange > sk8erBoi.epsilon) {
                sk8erBoi.calculateAreaArctan(sk8erBoi.lowerBound, sk8erBoi.upperBound, i);
                i += 1;
                System.out.println("Rectangles: " + i);
                System.out.println("Current Area: " + sk8erBoi.currentAreaString);
                System.out.println(sk8erBoi.prcntChangeString + "% change \n");            
            }
            System.out.println("Final Area: " + sk8erBoi.lastArea + " \n" + sk8erBoi.numRect + " rectangles were used. \n \n");
        } else if (sk8erBoi.function.matches("asin")) {
            System.out.println("Calculating a inverse sine function.\n");
            int i = 1;
            while (sk8erBoi.prcntChange > sk8erBoi.epsilon) {
                sk8erBoi.calculateAreaArcsin(sk8erBoi.lowerBound, sk8erBoi.upperBound, i);
                i += 1;
                System.out.println("Rectangles: " + i);
                System.out.println("Current Area: " + sk8erBoi.currentAreaString);
                System.out.println(sk8erBoi.prcntChangeString + "% change \n");            
            }
            System.out.println("Final Area: " + sk8erBoi.lastArea + " \n" + sk8erBoi.numRect + " rectangles were used. \n \n");
        } else if (sk8erBoi.function.matches("acos")) {
            System.out.println("Calculating a inverse cosine function.\n");
            int i = 1;
            while (sk8erBoi.prcntChange > sk8erBoi.epsilon) {
                sk8erBoi.calculateAreaArccos(sk8erBoi.lowerBound, sk8erBoi.upperBound, i);
                i += 1;
                System.out.println("Rectangles: " + i);
                System.out.println("Current Area: " + sk8erBoi.currentAreaString);
                System.out.println(sk8erBoi.prcntChangeString + "% change \n");            
            }
            System.out.println("Final Area: " + sk8erBoi.lastArea + " \n" + sk8erBoi.numRect + " rectangles were used. \n \n");
        } else if (sk8erBoi.function.matches("cosh")) {
            System.out.println("Calculating a hyperbolic cosine function.\n");
            int i = 1;
            while (sk8erBoi.prcntChange > sk8erBoi.epsilon) {
                sk8erBoi.calculateAreaCosh(sk8erBoi.lowerBound, sk8erBoi.upperBound, i);
                i += 1;
                System.out.println("Rectangles: " + i);
                System.out.println("Current Area: " + sk8erBoi.currentAreaString);
                System.out.println(sk8erBoi.prcntChangeString + "% change \n");            
            }
            System.out.println("Final Area: " + sk8erBoi.lastArea + " \n" + sk8erBoi.numRect + " rectangles were used. \n \n");
        } else if (sk8erBoi.function.matches("sinh")) {
            System.out.println("Calculating a hyperbolic sine function.\n");
            int i = 1;
            while (sk8erBoi.prcntChange > sk8erBoi.epsilon) {
                sk8erBoi.calculateAreaSinh(sk8erBoi.lowerBound, sk8erBoi.upperBound, i);
                i += 1;
                System.out.println("Rectangles: " + i);
                System.out.println("Current Area: " + sk8erBoi.currentAreaString);
                System.out.println(sk8erBoi.prcntChangeString + "% change \n");            
            }
            System.out.println("Final Area: " + sk8erBoi.lastArea + " \n" + sk8erBoi.numRect + " rectangles were used. \n \n");
        } else if (sk8erBoi.function.matches("tanh")) {
            System.out.println("Calculating a hyperbolic tangent function.\n");
            int i = 1;
            while (sk8erBoi.prcntChange > sk8erBoi.epsilon) {
                sk8erBoi.calculateAreaTanh(sk8erBoi.lowerBound, sk8erBoi.upperBound, i);
                i += 1;
                System.out.println("Rectangles: " + i);
                System.out.println("Current Area: " + sk8erBoi.currentAreaString);
                System.out.println(sk8erBoi.prcntChangeString + "% change \n");
            }
            System.out.println("Final Area: " + sk8erBoi.lastArea + " \n" + sk8erBoi.numRect + " rectangles were used. \n \n");
          }
    }
}
}
