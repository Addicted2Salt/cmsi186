/** ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 *  File name     :  PlaygroundSoccerSim.java
 *  Purpose       :  A class for kicking an arbitrary number of balls on a playground and detecting a 
 *                   collision or a goal
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
import java.text.DecimalFormat;

public class PlaygroundSoccerSim {

  // private data for 
  //    - default playground height and width
  private static final double DEFAULT_PLAYGROUND_HEIGHT = 1000;
  private static final double DEFAULT_PLAYGROUND_WIDTH = 1000;
  //   same for width
  //    - default time slice
  private static final double DEFAULT_TIME_SLICE = 1.0;


  // private instance data for
  //    - are any balls still moving (still a chance of a collision)
  private boolean continueSim = true;
  //    - time slice
  private double timeSlice = DEFAULT_TIME_SLICE;
  //    - playground size
  private double playgroundHeight = DEFAULT_PLAYGROUND_HEIGHT;
  private double playgroundWidth = DEFAULT_PLAYGROUND_WIDTH;
  //    - number of balls
  private int ballCount = 0;
  //    - array of soccer balls
  private Ball[] soccerBalls = null;
  private int[] ballsMoving;
  private int[] ballsNotMoving;
  private int[] ballsOutOfBounds;
  //    - clock
  private Clock c = new Clock();

  private int[] ballsCollided;


  private static final String Intro() {
    String intro = "Welcome to PlaygroundSoccerSim! This program will run a simulation of soccer balls.";
    return intro;
  }
  // You can put a private static final String here that includes the intro message
  //  or how to use the program



   public PlaygroundSoccerSim() {
    Ball[] soccerBalls = null;

    // update private instance data
    //  - create a clock
   }

  /**
   *  Method to validate the input arguments
   *  @param arguments String array of the arguments supplied to the program
   */
   public void validateArgsAndSetupSim( String arguments[] ) throws NumberFormatException,
                                                                    IllegalArgumentException {

    // if no arguments specified OR if number of arguments is NOT a factor of 4 
    // OR if number of arguments is NOT a factor of 4 plus 1
    // then dispay message about how to run this program, how it works
    if (arguments.length == 0 || arguments.length % 4 == 2 || 
        arguments.length % 4 == 3 || arguments.length == 1) {
      throw new IllegalArgumentException("Illegal Argument Exception");
    }

    if ( arguments.length % 4 == 1) {
        try {
          timeSlice = c.validateTimeSliceArg(arguments[arguments.length -1]);
        } catch (NumberFormatException nfe) {
          System.out.println("Use numbers please.");
        } catch (IllegalArgumentException iae) {
          System.out.println("Illegal Argument Exception.");
        }
    } else if ( arguments.length % 4 == 0 ) {
      timeSlice = timeSlice;
    }
        
    ballCount = (int)Math.floor(arguments.length / 4);
    soccerBalls = new Ball[ballCount];
    for ( int i = 0; i < soccerBalls.length; i++ ){
        try {
          soccerBalls[i] = new Ball(Double.parseDouble(arguments[i * 4]),
                                    Double.parseDouble(arguments[i * 4 + 1]),
                                    Double.parseDouble(arguments[i * 4 + 2]),
                                    Double.parseDouble(arguments[i * 4 + 3]));

        } catch ( NumberFormatException nfe ){
          System.out.println("NumberFormatException");
        }
      }



    ballsMoving = new int[soccerBalls.length];

    ballsNotMoving = new int[soccerBalls.length];
    ballsOutOfBounds = new int[soccerBalls.length];

    for ( int i = 0; i < soccerBalls.length; i++ ) {
      ballsMoving[i] = 1;
      ballsNotMoving[i] = 0;
      ballsOutOfBounds[i] = 0;
    }
    // populate soccerBall array, similar to DiceSet
    // converting args to doubles should be in a try / catch
  }

   //helper function for balls Moving and Not Moving
   public void ballStatus() {
    int movingBalls = 0;
    int notmovingBalls = 0;
    int outOfBoundsBalls = 0;
    for (int i = 0; i < soccerBalls.length; i++) {
      if (soccerBalls[i].isBallOutOfBounds(playgroundWidth, playgroundHeight) == false) {
        ballsOutOfBounds[i] = 1;
      } else {
        ballsOutOfBounds[i] = 0;
      }
      if (soccerBalls[i].isStillMoving() == true) {
        ballsMoving[i] = 1;
        ballsNotMoving[i] = 0;
      } else {
        ballsMoving[i] = 0;
        ballsNotMoving[i] = 1;
      }
      
    }
    for (int i = 0; i < ballsMoving.length; i++) {
      movingBalls += ballsMoving[i];
      notmovingBalls += ballsNotMoving[i];
      outOfBoundsBalls += ballsOutOfBounds[i];
      if (movingBalls == 0 || (notmovingBalls + outOfBoundsBalls == soccerBalls.length)) {
        continueSim = false;
        System.out.println("All balls are out of bounds or at rest.");
      }
    }
    System.out.println("There are " + movingBalls + " still in motion!");
    System.out.println("There are " + notmovingBalls + " at rest!");
    System.out.println("There are " + outOfBoundsBalls + " out of bounds!");
  }

  /**
   *  method to report the status of the simulation for every clock tick
   *  @param  c  Clock object which keeps track of time
   *  NOTE: this method calls the clock.tick() method to get one second to elapse
   */
   public void report() {
      c.tick(timeSlice);
      if (c.getTotalSeconds() % timeSlice == 1) {
          System.out.println("Playground has a height of: " + playgroundHeight*2 + ", and a width of: " + playgroundWidth*2 + "!");
          System.out.println("There are " + soccerBalls.length + " balls on the field!");
          System.out.println("The time is: " + c.toString());
      } else if (continueSim == false) {
          System.out.println("The simulation is over!");
      } else {
        System.out.println("Time: " + c.toString());
        for (int i = 0; i < soccerBalls.length; i++) {
          soccerBalls[i].toString();
        }
        ballStatus();
      }
   }

  /**
   *  method to move the balls in the soccerBall array
   *
   */
   public void simUpdate() {
    System.out.println(soccerBalls);
      for(int i = 0; i < soccerBalls.length; i++){
        soccerBalls[i].isBallOutOfBounds(playgroundWidth, playgroundHeight);
        soccerBalls[i].move(timeSlice);
        soccerBalls[i].isBallOutOfBounds(playgroundWidth, playgroundHeight);
      }
      report();
      collisionCheck();
      atLeastOneBallStillMoving();
    // for each ball
    //  - if the ball is not out of bounds and not at rest, move the ball
    //  - if the ball is out of bounds after the move or at rest, set the ball out of bounds or at rest
          
          
   }

  /**
   *  method to check for a collision soccerBall array
   *
   */
   public int[] collisionCheck() {
    outer:
     for ( int i = 0; i < soccerBalls.length - 1; i++ ) {
      for ( int j = i + 1; j < soccerBalls.length; j++ ) {
        if ((Math.sqrt(
          (soccerBalls[j].getPosition("X") - soccerBalls[i].getPosition("X")) * (soccerBalls[j].getPosition("X") - soccerBalls[i].getPosition("X")) +
          ((soccerBalls[j].getPosition("Y")-soccerBalls[i].getPosition("Y")) * (soccerBalls[j].getPosition("Y")-soccerBalls[i].getPosition("Y")))) * 12) < 8.9) {
          System.out.println( "Ball " + i + " has collided with Ball " + j );
          continueSim = false;
        } 
      }
    }
    if (continueSim == true) {
      System.out.println("No collisions");
    }

    // Compare location of each ball, to every other ball in the array (unless the ball is out of bounds)
    // Use the distance formula (from our dart assignment) to determine if the balls have collided
    // balls have collided if their distance is <= the radius of ball 1 plus the radius of ball 2
    
    // you can decide what you want this method to return
    // if it returns an array of integers, perhaps the array should contain the indexes
    // of the two balls that collided
      return ballsCollided;
   }


  /**
   *  method to see if the sim should continue
   *  we need at least one ball moving (in bounds) for the sim to continue
   *
   */
   public boolean atLeastOneBallStillMoving() {
      for (int i = 0; i<soccerBalls.length; i++) {
        if (soccerBalls[i].isStillMoving() == false) {
          continueSim = false;
          System.out.println("No balls moving");
          return continueSim;
        } else {
        continueSim = true;
        return continueSim;
      }
    }
    return continueSim;
  }

  /**
   *  main method of the simulation
   *  @param  args  String array of the command line arguments 
   */
   public static void main( String args[] ) {
    PlaygroundSoccerSim myPSS = new PlaygroundSoccerSim();
    myPSS.validateArgsAndSetupSim(args);
    myPSS.soccerBalls.toString();
    while ( myPSS.continueSim == true ) {
      myPSS.simUpdate();
    }
  }
}

