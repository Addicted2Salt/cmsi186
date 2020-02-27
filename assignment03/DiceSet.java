/** ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 *  File name     :  DiceSet.java
 *  Purpose       :  Provides a class describing a set of dice
 *  Author        :  A. Volosin
 *  Date          :  2020-02.03
 *  Description   :  This helper class provides everything needed (pretty much) to describe a set of dice.  The
 *                   idea here is to have an implementing class that uses the Die.java class.  Includes
 *                   the following:
 *                   public DiceSet( int k, int n );                  // Constructor for a set of k dice each with n-sides
 *                   public int sum();                                // Returns the present sum of this set of dice
 *                   public void roll();                              // Randomly rolls all of the dice in this set
 *                   public void rollIndividual( int i );             // Randomly rolls only the ith die in this set
 *                   public int getIndividual( int i );               // Gets the value of the ith die in this set
 *                   public String toString();                        // Returns a stringy representation of this set of dice
 *                   public static String toString( DiceSet ds );     // Classwide version of the preceding instance method
 *                   public boolean isIdentical( DiceSet ds );        // Returns true iff this set is identical to the set ds
 *                   public static void main( String[] args );        // The built-in test program for this class
 *
 *  Notes         :  Stolen from Dr. Dorin pretty much verbatim, then stolen from B.J. Johnson, then modified to show some 
 *                   interesting things about Java, and to add this header block and some JavaDoc comments.
 *  Warnings      :  None
 *  Exceptions    :  IllegalArgumentException when the number of sides or pips is out of range
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 *  Revision Histor
 *  ---------------
 *            Rev      Date     Modified by:  Reason for change/modification
 *           -----  ----------  ------------  -----------------------------------------------------------
 *  @version 1.0.0  2017-02-09  B.J. Johnson  Initial writing and release
 *  @version 2.0.0  2019-02-03  A. Volosin    Update naming conventions and comments
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */
public class DiceSet {

  /**
   * private instance data
   */
   private int count;
   private int sides;
   private Die[] ds = null;

   // public constructor:
  /**
   * This constructor is a method you will run to CREATE a DiceSet
   * @param  count int value containing total dice count
   * @param  sides int value containing the number of pips on each die
   * @throws IllegalArgumentException if one or both arguments don't make sense
   * @note   parameters are checked for validity; invalid values throw "IllegalArgumentException"
   */
   public DiceSet( int count, int sides ) {
      if ( count == 0 ) {
        throw new IllegalArgumentException("Can't have a DiceSet of length 0.");
      }
      this.count = count;
      this.sides = sides;
      this.ds = new Die[ count ];

      for ( int i = 0; i < count; i++ ) {
        this.ds[i] = new Die(sides);
      }
   }

  /**
   * Sums up all dice in the DiceSet
   * @return the sum of all the dice values in the set
   */
   public int sum() {
      int sumOfDie = 0;
      for ( int i = 0; i < this.ds.length; i++ ) {
        sumOfDie = sumOfDie + this.ds[i].getValue();
      }
      return sumOfDie;
   }

  /**
   * Randomly rolls all of the dice in this set
   *  This method does not return anything, it just rolls new values for all die
   *  in the DiceSet.
   *  You will need to use one of the "toString()" methods to obtain
   *  the values of the dice in the set
   */
   public void roll() {
      for ( int i = 0; i < this.ds.length; i++ ) {
        this.ds[i].roll();
      }
   }

  /**
   * Rolls a single die of the dice in this set indexed by 'dieIndex' to a random value
   * @param  dieIndex int of which die to roll
   * @return the integer value of the newly rolled die
   * @throws IllegalArgumentException if the index is out of range
   */
   public int rollIndividual( int dieIndex ) {
      if (dieIndex > this.ds.length+1) {
        throw new IllegalArgumentException("dieIndex is out of range of DiceSet!");
      } 
      return this.ds[(dieIndex-1)].roll();
      
   }

  /**
   * Gets the value of the die in this set indexed by 'dieIndex'
   * @param  dieIndex int of which die to roll
   * @throws IllegalArgumentException if the index is out of range
   */
   public int getIndividual( int dieIndex ) {
      if (dieIndex-1 > this.ds.length - 1) {
        throw new IllegalArgumentException("dieIndex is out of range of DiceSet!");
      }
      return this.ds[dieIndex].getValue();
   }

  /**
   * @return Public Instance method that returns a String representation of the DiceSet instance
   */
   public String toString() {
      
      String result = "";
      for ( int i = 0; i < this.ds.length; i++ ) {
      System.out.print(ds[i].toString());
      }
      System.out.println("\n");
      return result;
   }

  /**
   * @return Class-wide version of the preceding instance method
   */
   public static String toString( DiceSet ds ) {
      return ds.toString();
   }



  /**
   * A little test main to check things out
   * Write tests that out put results of each method at least twice
   * This main method only serves as a tester.
   */
   public static void main( String[] args ) {
      DiceSet tester = null;

      //sum method tests
      System.out.println("\nTests for sum method of DiceSet: \n");
      try {
        tester = new DiceSet(4, 6);
      System.out.println(" Sum of 4 6-sided die: \n " + tester.sum() + "\n");
      } catch(IllegalArgumentException iae) {System.out.println("Invalid input.");}
      try {
        tester = new DiceSet(2, 43);
      System.out.println( "Sum of 2 43-sided die: \n " + tester.sum() + "\n");
      } catch(IllegalArgumentException iae) {System.out.println("Invalid input.");}


      //roll method tests
      System.out.println("\nTests for roll method of DiceSet: \n");
      try {
        tester = new DiceSet(4, 6);
      System.out.println(" Rolling 4 6-sided die:");
      tester.roll();
      System.out.println(tester.toString() + "\n");
      } catch(IllegalArgumentException iae) {System.out.println("Invalid input.");}

      try {
        tester = new DiceSet(7, 4);
      System.out.println(" Rolling 7 4-sided die:");
      tester.roll();
      System.out.println(tester.toString() + "\n");      } 
      catch(IllegalArgumentException iae) {System.out.println("Invalid input.");}

      //rollIndividual method tests
      System.out.println("\nTests for rollIndividual method of DiceSet: \n");
      try {
        tester = new DiceSet(4, 40);
      System.out.println( "Rolling 4 40-sided die:");
      tester.roll();
      System.out.println(tester.toString());
      System.out.println( "Now rolling fourth die:");
      tester.rollIndividual(3);
      System.out.println(tester.toString() + "\n");
      } catch(Exception e) {System.out.println("Invalid input.");}

      try {
        tester = new DiceSet(5, 30);
        System.out.println( "Rolling 5 30-sided die:");
        tester.roll();
        System.out.println(tester.toString());
        System.out.println( "Now rolling SIXTH die:");
        tester.rollIndividual(5);
        System.out.println(tester.toString() + "\n");
      } catch(Exception e) {System.out.println("Out of range!");}
      System.out.println("\n");

      //getIndividual method tests
      System.out.println("\nTests for getIndividual method of DiceSet: \n");
      try {
        tester = new DiceSet(5, 30);
        System.out.println( "Rolling 5 30-sided die:");
        tester.roll();
        System.out.println(tester.toString());
        System.out.println( "Now getting value of SIXTH die:");
        System.out.println(tester.getIndividual(5));
      } catch(Exception e) {System.out.println("Out of range!");}
      System.out.println("\n");
      try {
        tester = new DiceSet(4, 40);
        System.out.println( "Rolling 4 40-sided die:");
        tester.roll();
        System.out.println(tester.toString());
        System.out.println( "Now getting value of third die:");
        System.out.println(tester.getIndividual(2));
      } catch(Exception e) {System.out.println("Out of range!");}
      System.out.println("\n");

      //toString method tests
      System.out.println("\nTests for toString method of DiceSet: \n");
      try {
        tester = new DiceSet(7, 35);
        System.out.println( "Rolling 7 35-sided die");
        tester.roll();
        System.out.println( "DiceSet toString is: ");
        tester.toString();
      } catch(Exception e) {System.out.println("Something went wrong uh oh");}
      try {
        tester = new DiceSet(4, 5);
        System.out.println( "Rolling 4 5-sided die");
        tester.roll();
        System.out.println( "DiceSet toString is: ");
        tester.toString();
      } catch(Exception e) {System.out.println("Something went wrong uh oh");}
      System.out.println( "\n End of DiceSet tests!");





   } //end of main

} //end of class