/** ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 *  File name     :  Ball.java
 *  Purpose       :  A class for a single ball that has a location and speed.
 *  @author       :  Alissa Volosin
 *  Date          :  2019-08-06
 *  Description   :  Coming soon...
 *  Notes         :  Coming soon...
 *  Warnings      :  None
 *  Exceptions    :  Coming soon...
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 *  Revision History
 *  ---------------
 *            Rev      Date     Modified by:  Reason for change/modification
 *           -----  ----------  ------------  -----------------------------------------------------------
 *  @version 1.3.0  2019-01-05  A. Volosin    Update method code
 *  @version 2.1.0  2020-02-2   A. Volosin    Convert to Playground problem
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */

// Use to format string output of location and speed doubles
import java.text.DecimalFormat;

public class Ball {

   // Private class wide data
       private static final double DEFAULT_BALL_RADIUS = 4.45; // radius in inches as given by the problem
       private static final double FRICTION_COEFFICIENT = 0.99; // one percent slowdown per second due to friction
       private static final int X_INDEX = 0; // index of X values within location and speed arrays
       private static final int Y_INDEX = 1; // index of Y values within location and speed arrays

   // Private instance data
       private boolean inBounds = true; // all balls will start in bounds by default
       private boolean isStillMoving = true; // all balls will start moving by default
       private double[] ballLocation = new double[2];// array containing both coordinate values
       private double[] ballSpeed = new double[2];// array containing both direction speed values

  /**
   * Constructor to make a new Ball
   *  @param xLoc double-precision value of the X location of the ball
   *  @param yLoc double-precision value of the Y location of the ball
   *  @param xSpeed double-precision value for the initial speed of the ball in X direction
   *  @param ySpeed double-precision value for the initial speed of the ball in Y direction
   */
   public Ball( double xLoc, double yLoc, double xSpeed, double ySpeed ) {
      // To create an instance of a ball, set the private instance data equal to argument values
    this.ballLocation[X_INDEX] = xLoc;
    this.ballLocation[Y_INDEX] = yLoc;
    this.ballSpeed[X_INDEX] = xSpeed;
    this.ballSpeed[Y_INDEX] = ySpeed;
   }

  /**
   *  method to fetch the current speed of the ball
   *  @return  double-precision two-element array of X and Y speed values
   */
   public double[] getSpeed() {

      return ballSpeed;
   }

   public double getSpeed( String xy ) {
    xy.toUpperCase().trim();
      if (xy.equals("X")) {
        return ballSpeed[X_INDEX];
      } else if (xy.equals("Y")) {
        return ballSpeed[Y_INDEX];
      }
      else {
      System.out.println( "Please indicate which index you would like to check!" );
      return 0;
    }
   }

  /**
   *  method to fetch the current position of the ball
   *  @return  double-precision two-element array of X and Y location values
   */
   public double[] getPosition() {
      return ballLocation;
   }

   public double getPosition( String xy ) {
    xy.toUpperCase().trim();
    if ( xy.equals("X")) {
      return ballLocation[X_INDEX];
    } else if ( xy.equals("Y")) {
      return ballLocation[Y_INDEX];
    } else {
      System.out.println( "Please indicate which index you would like to check!" );
      return 0;
    }
   }

  /**
   *  method to flag the ball as "is still moving"
   *  @return  boolean true if ball is moving, false if at rest
   *  @note    at rest is defined as speed <= 1.0 inch/second
   */
   public boolean isStillMoving() {
      if (this.ballSpeed[X_INDEX] <= 1/12 || this.ballSpeed[Y_INDEX] <= 1/12) {
        this.isStillMoving = false;
        return this.isStillMoving;
      } else {
        this.isStillMoving = true;
        return this.isStillMoving;
      }
   }


  /**
   *  method to flag the ball as "out of bounds" which will set its speed to zero and its
   *    "outOfBounds" value to true so it will effectively no longer be in the simulation
   *  @param playgroundWidth    double-precision value of 1/2 the designated playground width
   *  @param playgroundHeight   double-precision value of 1/2 the designated playground height
   */
   public boolean isBallOutOfBounds( double playgroundWidth, double playgroundHeight ) {
      //Check to see if ball is out of bounds given a playground size

      if (ballLocation[X_INDEX] > playgroundWidth || ballLocation[X_INDEX] < (0-playgroundWidth)
        || ballLocation[Y_INDEX] > playgroundHeight || ballLocation[Y_INDEX] < (0-playgroundHeight)) {
        this.inBounds = false;
      } else {
        this.inBounds = true;
      }

      if (this.inBounds == false) {
        this.ballSpeed[X_INDEX] = 0.0;
        this.ballSpeed[Y_INDEX] = 0.0;
      }
      // Decrease Speed to 0
      return this.inBounds;
   }

  /**
   *  method to update the speed of the ball for one slice of time
   *  @param timeSlice     double-precision value of time slace for simulation
   *  @return  double-precision two element array of new velocity values
   */
   public double[] updateSpeedsForOneTick( double timeSlice ) {
      this.ballSpeed[X_INDEX] *= Math.pow(0.99, timeSlice);
      this.ballSpeed[Y_INDEX] *= Math.pow(0.99, timeSlice);
      // Update x index of ballSpeed
      // Update y index of ballSpeed
      return ballSpeed;
   }

  /**
   *  method to update the ball's position and velocity
   *  @param timeSlice     double-precision value of time slace for simulation
   */
   public void move( double timeSlice ) {
      this.ballLocation[X_INDEX] += this.ballSpeed[X_INDEX] * 0.99 * timeSlice;
      this.ballLocation[Y_INDEX] += this.ballSpeed[Y_INDEX] * 0.99 * timeSlice;
      this.ballSpeed[X_INDEX] *= Math.pow(0.99, timeSlice);
      this.ballSpeed[Y_INDEX] *= Math.pow(0.99, timeSlice);

      // Update x index of ballLocation
      // Update y index of ballLocation
      // Update ballSpeed for one tick given the timeslice parameter
   }

  /**
   *  "toString()" representation of this ball
   *  @return  String-y version of what this Ball is
   */
   public String toString() {
      // Use to format ball location
      DecimalFormat dfl = new DecimalFormat( "#0.00");

      // Use to format speed
      DecimalFormat dfs = new DecimalFormat( "#0.0000" );
      
      // Print ball name (maybe use the index), location and speed
      if (inBounds == false) {
        return "This ball is out of bounds.";
    } else if (isStillMoving == false) {
        return "This ball is not moving."; 
    } else {
      return "Location: [" + dfl.format(this.ballLocation[X_INDEX]) + ", " + dfl.format(this.ballLocation[Y_INDEX]) + "]  Velocity: ["
      + dfs.format(this.ballSpeed[X_INDEX]) + ", " + dfs.format(this.ballSpeed[Y_INDEX]) + "]";
    }
      // OR
      // Print ball name and Out of bounds
      // OR
      // Print ball name and at rest
      
      
   }

  /**
   * a main method for testing -- pretty simple
   *  @param args[] String array of command line arguments
   */
   public static void main( String args[] ) {
      System.out.println( "\n   Testing the Ball class................" );
      Ball b1 = new Ball( 10.0, 50.0, 2.0, 6.0 );
      
      System.out.println( "Ball b1: " + b1.toString() );
      b1.move( 10.0 );
      System.out.println( "Ball b1: " + b1.toString() );
      b1.isBallOutOfBounds(150, 100);
      b1.isStillMoving();
      System.out.println( "Ball b1: " + b1.toString() );

      Ball b2 = new Ball( -125.0, 41.00, 51.0, -6.0 );
      System.out.println( "Ball b2: " + b2.toString() );
      b2.move( 2043);
      System.out.println( "Ball b2: " + b2.toString() );
      b2.isBallOutOfBounds(500000, 500000);
      b2.isStillMoving();
      System.out.println( "Ball b2: " + b2.toString() );

      Ball b3 = new Ball( -465.0, 50.0, 21.0, -546.0 );
      System.out.println( "Ball b3: " + b3.toString() );
      b3.move(2.343);
      System.out.println( "Ball b3: " + b3.toString() );
      b3.isBallOutOfBounds(750, 1000);
      b3.isStillMoving();
      System.out.println( "Ball b3: " + b3.toString() );

      Ball b4 = new Ball( 3010.0, -450.0, 542.0, 16.0 );
      System.out.println( "Ball b4: " + b4.toString() );
      b4.move(23.2);
      System.out.println( "Ball b4: " + b4.toString() );
      b4.isBallOutOfBounds(500000, 500000);
      b4.isStillMoving();
      System.out.println( "Ball b4: " + b4.toString() );

      Ball b5 = new Ball( -10.0, 550.0, -82.0, 86.0 );
      System.out.println( "Ball b5: " + b5.toString() );
      b5.move(14.5);
      System.out.println( "Ball b5: " + b5.toString() );
      b5.isBallOutOfBounds(110, 650);
      b5.isStillMoving();
      System.out.println( "Ball b5: " + b5.toString() );

      Ball b6 = new Ball( 150.0, 750.0, -52.0, -55.0 );
      System.out.println( "Ball b6: " + b6.toString() );
      b6.move(.054);
      System.out.println( "Ball b6: " + b6.toString() );
      b6.isBallOutOfBounds(500000, 500000);
      b6.isStillMoving();
      System.out.println( "Ball b6: " + b6.toString() );

      Ball b7 = new Ball( 150.0, -550.0, 72.0, 65.0 );
      System.out.println( "Ball b7: " + b7.toString() );
      b7.move(-14.5);
      System.out.println( "Ball b7: " + b7.toString() );
      b7.isBallOutOfBounds(500000, 500000);
      b7.isStillMoving();
      System.out.println( "Ball b7: " + b7.toString() );
      

      
   }

}
