/** ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * File name  :  BrobIntTester.java
 * Purpose    :  Test Harness for the BrobInt java class
 * @author    :  A.Volosin
 * Date       :  2019-03-01
 * Description:  
 * Notes      :  None
 * Warnings   :  None
 *
 *  ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Revision History
 * ================
 *   Ver      Date     Modified by:  Reason for change or modification
 *  -----  ----------  ------------  ---------------------------------------------------------------------
 *  1.0.0  2019-03-01  A.Volosin     Initial writing and release
 *
 *  ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */

public class BrobIntTester {

   private static String g01String = "144127909719710664015092431502440849849506284148982076191826176553";
   private static String g02String = "144127909719710664015092431502440849849506284148982076191826176553";
   private static String g03String = "144127909719710664015092431502440849849506284108982076191826176553";
   private static String g04String = "14412790971971066401509243150244084984950628410898207";
   private static String g05String = "0";
   private static String g06String = "1";
   private static String g07String = "10";
   private static String g11String = "10";
   private static String g12String = "20";
   private static String g13String = "234567";
   private static String g14String = "-234567";
   private static String g15String = "-10";
   private static String g16String = "-999999";
   private static String g17String = "765";
   private static String g18String = "23";
   private static String g19String = "56789";
   private static String g20String = "37";
   private static String t01String = "123456789987654321012345678998765432101023564898765432130231098753218972";
   private static String t02String = "123456789987654321012345678998765432101023564898765432130231098753218972";
   private static String t03String = "1234567899876543210123asdf45678998765432101023564898765432130231098753218972";
   private static String t04String = "-22222222222222222222222222222222222222222222222222";
   private static String t05String = "00000000";
   private static String t06String = "164213213";
   private static String t07String = "98423864442223256898441332";
   private static String t08String = "-4444444449856765432";
   private static String t09String = "++1";
   private static String t10String = "-248392";
   private static String t11String = "seventy three";
   private static String t12String = "9987541112220";
   private static String t13String = "-84521022654897965219844";
   private static String t14String = "++23sk";
   private static String t15String = "20000000666666666654321";
   private static String t16String = "-2342+";
   private static String t17String = "++23422--";
   private static String t18String = "138492832]";
   private static String t19String = "five+";
   private static String t20String = "-five";
   private static String s01String = "3";
   private static String s02String = "542";
   private static String s03String = "1";
   private static String s04String = "2";
   private static String s05String = "5";
   private static String s06String = "10";

   private static BrobInt g1 = null;
   private static BrobInt g2 = null;
   private static BrobInt g3 = null;
   private static BrobInt g4 = null;
   private static BrobInt g5 = null;
   private static BrobInt g6 = null;
   private static BrobInt g7 = null;
   private static BrobInt g8 = null;
   private static BrobInt g9 = null;
   private static BrobInt g10 = null;
   private static BrobInt g11 = null;
   private static BrobInt g12 = null;
   private static BrobInt g13 = null;
   private static BrobInt g14 = null;
   private static BrobInt g15 = null;
   private static BrobInt g16 = null;
   private static BrobInt g17 = null;
   private static BrobInt g18 = null;
   private static BrobInt g19 = null;
   private static BrobInt g20 = null;
   private static BrobInt t1 = null;
   private static BrobInt t2 = null;
   private static BrobInt t3 = null;
   private static BrobInt t4 = null;
   private static BrobInt t5 = null;
   private static BrobInt t6 = null;
   private static BrobInt t7 = null;
   private static BrobInt t8 = null;
   private static BrobInt t9 = null;
   private static BrobInt t10 = null;
   private static BrobInt t11 = null;
   private static BrobInt t12 = null;
   private static BrobInt t13 = null;
   private static BrobInt t14 = null;
   private static BrobInt t15 = null;
   private static BrobInt t16 = null;
   private static BrobInt t17 = null;
   private static BrobInt t18 = null;
   private static BrobInt t19 = null;
   private static BrobInt t20 = null;
   private static BrobInt s1 = null;
   private static BrobInt s2 = null;
   private static BrobInt s3 = null;
   private static BrobInt s4 = null;
   private static BrobInt s5 = null;
   private static BrobInt s6 = null;


   public BrobIntTester() {
      
   }

   public static void main( String[] args ) {
      BrobIntTester git = new BrobIntTester();

      System.out.println( "\n  Hello, world, from the BrobInt program!!\n" );

      System.out.println( "    TESTING CONSTRUCTOR AND CONSTANTS:\n" +
                          "    ==================================" );
      try {
         System.out.println( "    Test 001: Making a new BrobInt: " );
         g1 = new BrobInt( g01String );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " ); }
      try {
         System.out.println( "      expecting: " + g01String + "\n" +
                             "        and got: " + g1.toString() );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " ); }

      try {
         t1 = new BrobInt( t01String );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " ); }
      try {
         System.out.println( "      expecting: " + t01String + "\n" +
                             "        and got: " + t1.toString() );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " ); }

      try {
         s1 = new BrobInt( s01String );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " ); }
      try {
         System.out.println( "      expecting: " + s01String + "\n" +
                             "        and got: " + s1.toString() );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " ); }

      try {
         s2 = new BrobInt( s02String );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " ); }
      try {
         System.out.println( "      expecting: " + s02String + "\n" +
                             "        and got: " + s2.toString() );
      }
      
      catch( Exception e ) { System.out.println( "        Exception thrown:  " ); }

      try {
         t2 = new BrobInt( t02String );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " ); }
      try {
         System.out.println( "      expecting: " + t02String + "\n" +
                             "        and got: " + t2.toString() );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " ); }
      
      try {
         s3 = new BrobInt( s03String );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " ); }
      try {
         System.out.println( "      expecting: " + s03String + "\n" +
                             "        and got: " + s3.toString() );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " ); }      try {
         s4 = new BrobInt( s04String );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " ); }
      try {
         System.out.println( "      expecting: " + s04String + "\n" +
                             "        and got: " + s4.toString() );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " ); }

      try {
         s5 = new BrobInt( s05String );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " ); }
      try {
         System.out.println( "      expecting: " + s05String + "\n" +
                             "        and got: " + s5.toString() );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " ); }

      try {
         s6 = new BrobInt( s06String );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " ); }
      try {
         System.out.println( "      expecting: " + s06String + "\n" +
                             "        and got: " + s6.toString() );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " ); }



      try {
         t3 = new BrobInt( t03String );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " ); }
      try {
         System.out.println( "      expecting: " + t03String + "\n" +
                             "        and got: " + t3.toString() );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " ); }

      try {
         t4 = new BrobInt( t04String );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " ); }
      try {
         System.out.println( "      expecting: " + t04String + "\n" +
                             "        and got: " + t4.toString() );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " ); }

      try {
         t5 = new BrobInt( t05String );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " ); }
      try {
         System.out.println( "      expecting: " + t05String + "\n" +
                             "        and got: " + t5.toString() );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " ); }

      try {
         t6 = new BrobInt( t06String );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " ); }
      try {
         System.out.println( "      expecting: " + t06String + "\n" +
                             "        and got: " + t6.toString() );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " ); }

      try {
         t7 = new BrobInt( t07String );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " ); }
      try {
         System.out.println( "      expecting: " + t07String + "\n" +
                             "        and got: " + t7.toString() );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " ); }

      try {
         t8 = new BrobInt( t08String );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " ); }
      try {
         System.out.println( "      expecting: " + t08String + "\n" +
                             "        and got: " + t8.toString() );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " ); }

      try {
         t9 = new BrobInt( t09String );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " ); }
      try {
         System.out.println( "      expecting: " + t09String + "\n" +
                             "        and got: " + t9.toString() );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " ); }

      try {
         t10 = new BrobInt( t10String );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " ); }
      try {
         System.out.println( "      expecting: " + t10String + "\n" +
                             "        and got: " + t10.toString() );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " ); }

      try {
         t11 = new BrobInt( t11String );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " ); }
      try {
         System.out.println( "      expecting: " + t11String + "\n" +
                             "        and got: " + t11.toString() );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " ); }

      try {
         t12 = new BrobInt( t12String );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " ); }
      try {
         System.out.println( "      expecting: " + t12String + "\n" +
                             "        and got: " + t12.toString() );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " ); }

      try {
         t13 = new BrobInt( t13String );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " ); }
      try {
         System.out.println( "      expecting: " + t13String + "\n" +
                             "        and got: " + t13.toString() );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " ); }

      try {
         t14 = new BrobInt( t14String );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " ); }
      try {
         System.out.println( "      expecting: " + t14String + "\n" +
                             "        and got: " + t14.toString() );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " ); }

      try {
         t15 = new BrobInt( t15String );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " ); }
      try {
         System.out.println( "      expecting: " + t15String + "\n" +
                             "        and got: " + t15.toString() );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " ); }

      try {
         t16 = new BrobInt( t16String );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " ); }
      try {
         System.out.println( "      expecting: " + t16String + "\n" +
                             "        and got: " + t16.toString() );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " ); }

      try {
         t17 = new BrobInt( t17String );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " ); }
      try {
         System.out.println( "      expecting: " + t17String + "\n" +
                             "        and got: " + t17.toString() );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " ); }

      try {
         t18 = new BrobInt( t18String );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " ); }
      try {
         System.out.println( "      expecting: " + t18String + "\n" +
                             "        and got: " + t18.toString() );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " ); }

      try {
         t19 = new BrobInt( t19String );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " ); }
      try {
         System.out.println( "      expecting: " + t19String + "\n" +
                             "        and got: " + t19.toString() );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " ); }

      try {
         t20 = new BrobInt( t20String );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " ); }
      try {
         System.out.println( "      expecting: " + t20String + "\n" +
                             "        and got: " + t20.toString() );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " ); }

      System.out.println( "\n    Test 002: Making a second new BrobInt [same as first]: " );
      try {
         g2 = new BrobInt( g02String );
         System.out.println( "      expecting: " + g02String + "\n" +
                             "        and got: " + g2.toString() );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " ); }

      try {
         t2 = new BrobInt( t02String );
         System.out.println( "      expecting: " + t02String + "\n" +
                             "        and got: " + t2.toString() );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " ); }

      try {
         System.out.println( "    Test 003: Comparing equality of g1 and g2 with 'equals()': " );
         System.out.println( "      expecting: true\n" + "        and got: " + g1.equals( g2 ) );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " ); }

      try {
         System.out.println( "    Test 003b: Comparing equality of t1 and t2 with 'equals()': " );
         System.out.println( "      expecting: true\n" + "        and got: " + t1.equals( t2 ) );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " ); }

      try {
         System.out.println( "\n    Test 004: Making a third new BrobInt [differs at position 47    |]: " +
                             "\n           [position indicated by down arrow]                  v   " );
         g3 = new BrobInt( g03String );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " ); }

      try {
         System.out.println( "      expecting: " + g03String + "\n" +
                             "        and got: " + g3.toString() );
         System.out.println( "          g1 is: " + g1.toString() );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " ); }

      try {
         System.out.println( "    Test 005: Comparing equality of g1 and g3 [detect different digit]: " );
         System.out.println( "      expecting: false\n" + "        and got: " + g1.equals( g3 ) );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " ); }

      try {
         System.out.println( "\n    Test 006: Making a fourth new BrobInt [same as g3 but truncated]: "  );
         g4 = new BrobInt( g04String );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " ); }

      try {
         System.out.println( "      expecting: " + g04String + "\n" +
                             "        and got: " + g4.toString() );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " ); }

      try {
         System.out.println( "    Test 007: Comparing equality of g3 and g4 [detect different length prior to detecting different digit]: " );
         System.out.println( "      expecting: false\n" + "        and got: " + g3.equals( g4 ) );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " ); }

      try {
         System.out.println( "\n    Test 008: Making a fifth new BrobInt, checking BrobInt.ZERO: "  );
         g5 = new BrobInt( "0" );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " ); }

      try {
         System.out.println( "      expecting: " + BrobInt.ZERO + "\n" +
                             "        and got: " + g5.toString() );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " ); }

      try {
         System.out.println( "\n    Test 009: Making a sixth new BrobInt, checking BrobInt.ONE: "  );
         g6 = new BrobInt( "1" );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " ); }

      try {
         System.out.println( "      expecting: " + BrobInt.ONE + "\n" +
                             "        and got: " + g6.toString() );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " ); }

      try {
         System.out.println( "\n    Test 010: Making a seventh new BrobInt, checking BrobInt.TEN: "  );
         g7 = new BrobInt( g07String );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " ); }

      try {
         System.out.println( "      expecting: " + BrobInt.TEN + "\n" +
                             "        and got: " + g7.toString() );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " ); }

      System.out.println( "\n\n    TESTING VALUEOF( LONG ) METHOD:\n" +
                          "    ===============================" );
      System.out.println( "\n    Test 011: Creating several long type values to check the 'valueOf()' method: " );
      long long01 = Long.MAX_VALUE;
      long long02 = Long.MIN_VALUE;
      long long03 = 1234567890;
      try {
         System.out.println( "      expecting: " + Long.MAX_VALUE + "\n" +
                             "        and got: " + long01 );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " ); }

      try {
         System.out.println( "      expecting: " + Long.MIN_VALUE + "\n" +
                             "        and got: " + long02 );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " ); }

      try {
         System.out.println( "      expecting: 1234567890\n" +
                             "        and got: " + long03 );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " ); }

      try {
         System.out.println( "    Test 012: Now testing 'valueOf()' method: " );
         g8  = BrobInt.valueOf( long01 );
         g9  = BrobInt.valueOf( long02 );
         g10 = BrobInt.valueOf( long03 );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " ); }

      try {
         System.out.println( "      expecting: " + Long.MAX_VALUE + "\n" +
                             "        and got: " + g8.toString() );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " ); }

      try {
         System.out.println( "      expecting: " + Long.MIN_VALUE + "\n" +
                             "        and got: " + g9.toString() );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " ); }

      try {
         System.out.println( "      expecting: 1234567890\n" +
                             "        and got: " + g10.toString() );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " ); }

      System.out.println( "\n\n    TESTING ADD() METHODS:\n" +
                          "    ==========================" );
      try {
         System.out.println( "\n    Test 013: Making an eleventh and twelfth new BrobInt, calling add method: "  );
         g11 = new BrobInt( g11String );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " ); }

      try {
         System.out.println( "      expecting: 10\n" +
                             "        and got: " + g11.toString() );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " ); }

      try {
         g12 = new BrobInt( g12String );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " ); }

      try {
         System.out.println( "      expecting: 20\n" +
                             "        and got: " + g12.toString() );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " ); }

      try {
         System.out.println( "    Test 014: Adding g11 and g12: " );
         System.out.println( "      expecting: 30 and got " + (g11.add( g12 )).toString() );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " ); }

      try {
         System.out.println( "    Test 014a: Adding t6 and t7: " );
         System.out.println( "      expecting: 98423864442223257062654545 and got " + (t6.add( t7 )).toString() );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " ); }

      try {
         System.out.println( "    Test 014b: Adding t9 and t6: " );
         System.out.println( "      expecting: " + t6.toString() + " and got " + (t9.add( t6 )).toString() );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " ); }

      try {
         System.out.println( "    Test 014c: Adding t6 and t8: " );
         System.out.println( "      expecting: -4444444449692552219 and got " + t6.add( t8 ).toString() );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " ); }

      try {
         System.out.println( "    Test 014d: Adding t6 and t10: " );
         System.out.println( "      expecting: 163964821 and got " + t6.add( t10 ).toString() );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " ); }

      try {
         System.out.println( "    Test 014e: Adding t6 and t12: " );
         System.out.println( "      expecting: 9987705325433 and got " + t6.add( t12 ).toString() );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " ); }

      try {
         System.out.println( "    Test 014f: Adding t6 and t13: " );
         System.out.println( "      expecting: -84521022654897801006631 and got " + t6.add( t13 ).toString() );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " ); }

      try {
         System.out.println( "    Test 014g: Adding t6 and t15: " );
         System.out.println( "      expecting: 30 and got " + t6.add( t15 ).toString() );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " ); }

      try {
         System.out.println( "    Test 014h: Adding t6 and t15: " );
         System.out.println( "      expecting: 20000000666666830867534 and got " + t6.add( t15 ).toString() );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " ); }

      try {
         System.out.println( "    Test 014i: Adding t16 and t17: " );
         System.out.println( "      expecting: exception and got " + t16.add( t17 ).toString() );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " ); }

      try {
         System.out.println( "    Test 014j: Adding t7 and t8: " );
         System.out.println( "      expecting: 98423859997778807041675900 and got " + t7.add( t8 ).toString() );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " ); }

      try {
         System.out.println( "    Test 014k: Adding t11 and t16: " );
         System.out.println( "      expecting: exception and got " + t11.add( t16 ).toString() );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " ); }

      try {
         System.out.println( "    Test 014l: Adding t7 and t10: " );
         System.out.println( "      expecting: 98423864442223256898192940 and got " + t7.add( t10 ).toString() );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " ); }

      try {
         System.out.println( "    Test 014m: Adding t7 and t12: " );
         System.out.println( "      expecting: 98423864442233244439553552 and got " + t7.add( t12 ).toString() );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " ); }

      try {
         System.out.println( "    Test 014n: Adding t9 and t10: " );
         System.out.println( "      expecting: exception and got " + t9.add( t10 ).toString() );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " ); }

      try {
         System.out.println( "    Test 014o: Adding t5 and t6: " );
         System.out.println( "      expecting: 164213213 and got " + t5.add( t6 ).toString() );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " ); }

      try {
         System.out.println( "    Test 014p: Adding t16 and t6: " );
         System.out.println( "      expecting: exception and got " + t16.add( t6 ).toString() );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " ); }

      try {
         System.out.println( "    Test 014q: Adding t8 and t13: " );
         System.out.println( "      expecting: -84525467099347821985276 and got " + t8.add( t13 ) );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " ); }

      try {
         System.out.println( "    Test 014r: Adding t5 and t7: " );
         System.out.println( "      expecting: 98423864442223256898441332 and got " + t5.add( t7 ) );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " ); }

      try {
         System.out.println( "    Test 014s: Adding t11 and t12: " );
         System.out.println( "      expecting: exception and got " + t11.add( t12 ) );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " ); }

      try {
         System.out.println( "    Test 014t: Adding t9 and t16: " );
         System.out.println( "      expecting: exception and got " + t9.add( t16 ) );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " ); }

      System.out.println( "\n    Test 015: Making a thirteenth new BrobInt, calling add methods: "  );
      try {
         g13 = new BrobInt( g13String );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " ); }

      try {
         System.out.println( "      expecting: 234567\n" +
                             "        and got: " + g13.toString() );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " ); }

      try {
         System.out.println( "    Test 016: Adding g11 and g13 [10 + 234567] using bytes: " );
         System.out.println( "      expecting: 234577 and got " + g11.add( g13 ) );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " ); }

      try {
         System.out.println( "    Test 016a: Adding t6 and t15 [164213213 + 20000000666666666654321] using bytes: " );
         System.out.println( "      expecting: 20000000666666830867534 and got " + t6.add( t15 ) );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " ); }

      try {
         System.out.println( "    Test 016b: Adding t11 and t9 [seventy three + ++1] using bytes: " );
         System.out.println( "      expecting: exception and got " + t11.add( t9 ) );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " ); }

      try {
         System.out.println( "    Test 016c: Adding t10 and t12 [-248392 + 9987541112220] using bytes: " );
         System.out.println( "      expecting: 9987540863828 and got " + t10.add( t12 ) );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " ); }

      try {
         System.out.println( "    Test 016d: Adding t19 and t20 [five+ + -five] using bytes: " );
         System.out.println( "      expecting: exception and got " + t19.add( t20 ) );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " ); }

      try {
         System.out.println( "    Test 016e: Adding t6 and t5 [164213213 + 00000000] using bytes: " );
         System.out.println( "      expecting: 164213213 and got " + t6.add( t5 ) );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " ); }

      try {
         System.out.println( "    Test 016f: Adding t10 and t8 [-248392 + -4444444449856765432] using bytes: " );
         System.out.println( "      expecting: -4444444449857013824 and got " + t10.add( t8 ) );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " ); }

      try {
         System.out.println( "    Test 016g: Adding t6 and t15 [164213213 + 20000000666666666654321] using bytes: " );
         System.out.println( "      expecting: 20000000666666830867534 and got " + g11.add( g13 ) );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " ); }

      try {
         System.out.println( "    Test 016h: Adding t18 and t15 [138492832] + 20000000666666666654321] using bytes: " );
         System.out.println( "      expecting: exception and got " + t18.add( t15 ) );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " ); }

      try {
         System.out.println( "    Test 016i: Adding t7 and t15 [98423864442223256898441332 + 20000000666666666654321] using bytes: " );
         System.out.println( "      expecting: 98443864442889923565095653 and got " + t7.add( t15 ) );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " ); }

      try {
         System.out.println( "    Test 016j: Adding t12 and t10 [9987541112220 + -248392] using bytes: " );
         System.out.println( "      expecting: 9987540863828 and got " + t12.add( t10 ) );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " ); }

      try {
         System.out.println( "    Test 016k: Adding t13 and t6 [-84521022654897965219844 + 164213213] using bytes: " );
         System.out.println( "      expecting: -84521022654897801006631 and got " + t13.add( t6 ) );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " ); }

      try {
         System.out.println( "    Test 016l: Adding t6 and t15 [164213213 + 20000000666666666654321] using bytes: " );
         System.out.println( "      expecting: 20000000666666830867534 and got " + g11.add( g13 ) );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " ); }

      try {
         System.out.println( "    Test 016m: Adding t15 and t15 [20000000666666666654321 + 20000000666666666654321] using bytes: " );
         System.out.println( "      expecting: 40000001333333333308642 and got " + t15.add( t15 ) );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " ); }

      try {
         System.out.println( "    Test 016n: Adding t6 and t6 [164213213 + 164213213] using bytes: " );
         System.out.println( "      expecting: 328426426 and got " + t6.add( t6 ) );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " ); }

      try {
         System.out.println( "    Test 016o: Adding t10 and t10 [-248392 + -248392] using bytes: " );
         System.out.println( "      expecting: -496784 and got " + t10.add( t10 ) );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " ); }

      try {
         System.out.println( "    Test 016p: Adding t7 and t7 [98423864442223256898441332 + 98423864442223256898441332] using bytes: " );
         System.out.println( "      expecting: 196847728884446513796882664 and got " + t7.add( t7 ) );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " ); }

      try {
         System.out.println( "    Test 016q: Adding t14 and t15 [++23sk + 20000000666666666654321] using bytes: " );
         System.out.println( "      expecting: exception and got " + t14.add( t15 ) );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " ); }

      try {
         System.out.println( "    Test 016r: Adding t9 and t20 [++1 + -five] using bytes: " );
         System.out.println( "      expecting: exception and got " + t9.add( t20 ) );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " ); }

      try {
         System.out.println( "    Test 016s: Adding t17 and t15 [++23422-- + 20000000666666666654321] using bytes: " );
         System.out.println( "      expecting: exception and got " + t17.add( t15 ).toString() );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " ); }

      try {
         System.out.println( "    Test 016t: Adding t16 and t15 [-2342+ + 20000000666666666654321] using bytes: " );
         System.out.println( "      expecting: exception and got " + t16.add( t15 ).toString() );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " ); }

      try {
         System.out.println( "    Test 017: Adding g13 and g11 [234567 + 10] using bytes: " );
         System.out.println( "      expecting: 234577 and got " + g13.add( g11 ) );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " ); }

      System.out.println( "\n    Test 018: Making a fourteenth new BrobInt, calling add methods: "  );
      try {
         g14 = new BrobInt( g14String );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " ); }

      try {
         System.out.println( "      expecting: -234567\n" +
                             "        and got: " + g14.toString() );
         System.out.println( "\n    Test 019: Making a fifteenth new BrobInt, calling add methods: "  );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " ); }

      try {
         g15 = new BrobInt( g15String );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " ); }

      try {
         System.out.println( "      expecting: -10\n" +
                             "        and got: " + g15.toString() );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " ); }

      try {
         System.out.println( "    Test 020: Adding g14 and g15 [-234567 + -10] using bytes: " );
         System.out.println( "      expecting: -234577 and got " + g14.add( g15 ) );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " ); }

      try {
         System.out.println( "    Test 021: Adding g15 and g14 [-10 + -234567] using bytes: " );
         System.out.println( "      expecting: -234577 and got " + g15.add( g14 ) );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " ); }

      System.out.println( "\n    Test 022: Making a sixteenth new BrobInt, calling add methods: "  );
      try {
         g16 = new BrobInt( g16String );
         System.out.println( "      expecting: -999999\n" +
                             "        and got: " + g16.toString() );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " ); }

      try {
         System.out.println( "    Test 023: Adding g14 and g16 [-234567 + -999999] using bytes: " );
         System.out.println( "      expecting: -1234566 and got " + g14.add( g16 ) );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " ); }

      try {
         System.out.println( "    Test 024: Adding g16 and g14 [-999999 + -234567] using bytes: " );
         System.out.println( "      expecting: -1234566 and got " + g16.add( g14 ) );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " ); }

      try {
         System.out.println( "\n      Test 025: Adding g1 and g4 using bytes: " );
         System.out.println( "      expecting: 144127909719725076806064402568842359092656528233967026820237074760\n" +
                             "        and got: " + g1.add( g4 ) );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " ); }

      System.out.println( "\n\n    TESTING COMPARETO() METHOD:\n" +
                          "    ===========================\n" +
                          "    NOTE: this.compareTo(that) returns: -1 if this < that\n" +
                          "                               returns: +1 if this > that\n" +
                          "                               returns:  0 if this = that" );
      try {
         System.out.println( "\n    Test 026: Checking compareTo() method on g1.compareTo g2: "  );
         System.out.println( "      expecting: 0 and got: " + g1.compareTo( g2 ) );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " ); }

      try {
         System.out.println( "\n    Test 027: Checking compareTo() method on g2.compareTo g1: "  );
         System.out.println( "      expecting: 0 and got: " + g2.compareTo( g1 ) );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " ); }

      try {
         System.out.println( "\n    Test 028: Checking compareTo() method on g1.compareTo g3: "  );
         System.out.println( "      expecting: positive value and got: " + g1.compareTo( g3 ) );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " ); }

      try {
         System.out.println( "\n    Test 029: Checking compareTo() method on g3.compareTo g1: "  );
         System.out.println( "      expecting: negative value and got: " + g3.compareTo( g1 ) );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " ); }

      try {
         System.out.println( "\n    Test 030: Checking compareTo() method on g3.compareTo g4: "  );
         System.out.println( "      expecting: positive value and got: " + g3.compareTo( g4 ) );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " ); }

      try {
         System.out.println( "\n    Test 030a: Checking compareTo() method on 123456789.compareTo 234: "  );
         System.out.println( "      expecting: positive value and got: " + (new BrobInt("123456789").compareTo( new BrobInt("234"))) );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " ); }

      try {
         System.out.println( "\n    Test 030b: Checking compareTo() method on 123.compareTo 123456789: "  );
         System.out.println( "      expecting: ngative value and got: " + (new BrobInt("123").compareTo( new BrobInt("123456789"))) );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " ); }

      try {
         System.out.println( "\n    Test 030c: Checking compareTo() method on g3.compareTo 999: "  );
         System.out.println( "      expecting: positive value and got: " + g3.compareTo( new BrobInt( "999" ) ) );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " ); }

      try {
         System.out.println( "\n    Test 030d: Checking compareTo() method on 1234.compareTo -999: "  );
         System.out.println( "      expecting: positive value and got: " + (new BrobInt("1234").compareTo( new BrobInt( "-999" ) ) ) );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " ); }

      try {
         System.out.println( "\n    Test 030e: Checking compareTo() method on -999.compareTo G3: "  );
         System.out.println( "      expecting: negative value and got: " + new BrobInt( "-999" ).compareTo( g3 ) );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " ); }

      try {
         System.out.println( "\n    Test 030f: Checking compareTo() method on t6.compareTo t8: "  );
         System.out.println( "      expecting: positive value and got: " + t6.compareTo( t8 ) );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " ); }

      try {
         System.out.println( "\n    Test 030g: Checking compareTo() method on t8.compareTo t6: "  );
         System.out.println( "      expecting: negative value and got: " + t8.compareTo( t6 ) );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " ); }

      try {
         System.out.println( "\n    Test 030h: Checking compareTo() method on t11.compareTo t12: "  );
         System.out.println( "      expecting: exception and got: " + t11.compareTo( t12 ) );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " ); }

      try {
         System.out.println( "\n    Test 030i: Checking compareTo() method on t12.compareTo t11: "  );
         System.out.println( "      expecting: exception value and got: " + t12.compareTo( t11 ) );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " ); }

      try {
         System.out.println( "\n    Test 030j: Checking compareTo() method on t15.compareTo t6: "  );
         System.out.println( "      expecting: positive value and got: " + t15.compareTo( t6 ) );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " ); }

      try {
         System.out.println( "\n    Test 030k: Checking compareTo() method on t6.compareTo t15: "  );
         System.out.println( "      expecting: negative value and got: " + t6.compareTo( t15 ) );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " ); }

      try {
         System.out.println( "\n    Test 030l: Checking compareTo() method on t5.compareTo t6: "  );
         System.out.println( "      expecting: negative value and got: " + t5.compareTo( t6 ) );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " ); }

      try {
         System.out.println( "\n    Test 030m: Checking compareTo() method on t6.compareTo t5: "  );
         System.out.println( "      expecting: positive value and got: " + t6.compareTo( t5 ) );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " ); }

      try {
         System.out.println( "\n    Test 030n: Checking compareTo() method on t17.compareTo t13: "  );
         System.out.println( "      expecting: exception value and got: " + t17.compareTo( t13 ) );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " ); }

      try {
         System.out.println( "\n    Test 030o: Checking compareTo() method on t13.compareTo t17: "  );
         System.out.println( "      expecting: exception value and got: " + t13.compareTo( t17 ) );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " ); }

      try {
         System.out.println( "\n    Test 030p: Checking compareTo() method on t10.compareTo t6: "  );
         System.out.println( "      expecting: negative value and got: " + t10.compareTo( t6 ) );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " ); }

      try {
         System.out.println( "\n    Test 030q: Checking compareTo() method on t6.compareTo t10: "  );
         System.out.println( "      expecting: positive value and got: " + t6.compareTo( t10 ) );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " ); }

      try {
         System.out.println( "\n    Test 030r: Checking compareTo() method on t10.compareTo t12: "  );
         System.out.println( "      expecting: negative value and got: " + t10.compareTo( t12 ) );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " ); }

      try {
         System.out.println( "\n    Test 030s: Checking compareTo() method on t12.compareTo t10: "  );
         System.out.println( "      expecting: positive value and got: " + t12.compareTo( t10 ) );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " ); }

      try {
         System.out.println( "\n    Test 030t: Checking compareTo() method on t15.compareTo t12: "  );
         System.out.println( "      expecting: positive value and got: " + t15.compareTo( t12 ) );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " ); }

      try {
         System.out.println( "\n    Test 030u: Checking compareTo() method on t12.compareTo t15: "  );
         System.out.println( "      expecting: negative value and got: " + t12.compareTo( t15 ) );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " ); }

      try {
         System.out.println( "\n    Test 030v: Checking compareTo() method on t8.compareTo t7: "  );
         System.out.println( "      expecting: negative value and got: " + t8.compareTo( t7 ) );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " ); }

      try {
         System.out.println( "\n    Test 030w: Checking compareTo() method on t7.compareTo t8: "  );
         System.out.println( "      expecting: positive value and got: " + t7.compareTo( t8 ) );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " ); }

      try {
         System.out.println( "\n    Test 030x: Checking compareTo() method on t9.compareTo t16: "  );
         System.out.println( "      expecting: exception value and got: " + t9.compareTo( t16 ) );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " ); }

      try {
         System.out.println( "\n    Test 030y: Checking compareTo() method on t16.compareTo t9: "  );
         System.out.println( "      expecting: exception value and got: " + t16.compareTo( t9 ) );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " ); }

      System.out.println( "\n\n    TESTING SUBTRACTBYTE() METHOD:\n" +
                          "    ==============================" );
      System.out.println( "\n      Test 031: Subtracting g13 take away g11 [234567 - 10] using bytes: " );
      try {
         System.out.println( "      expecting: 234557\n" +
                             "        and got: " + g13.subtract( g11 ) );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " ); }

      System.out.println( "\n      Test 032: Subtracting g11 take away g13 [10 - 234567] using bytes: " );
      try {
         System.out.println( "      expecting: -234557\n" +
                             "        and got: " + g11.subtract( g13 ) );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " ); }

      System.out.println( "\n      Test 033: Subtracting g13 take away g15 [234567 - (-10)] using bytes: " );
      try {
         System.out.println( "      expecting: 234577\n" +
                             "        and got: " + g13.subtract( g15 ) );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " ); }

      System.out.println( "\n      Test 034: Subtracting g15 take away g13 [(-10) - 234567] using bytes: " );
      try {
         System.out.println( "      expecting: -234577\n" +
                             "        and got: " + g15.subtract( g13 ) );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " ); }

      System.out.println( "\n      Test 035: Subtracting g14 take away g16 [(-234567) - (-999999)] using bytes: " );
      try {
         System.out.println( "      expecting: 765432\n" +
                             "        and got: " + g14.subtract( g16 ) );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " ); }

      System.out.println( "\n      Test 036: Subtracting g16 take away g14 [(-999999) - (-234567)] using bytes: " );
      try {
         System.out.println( "      expecting: -765432\n" +
                             "        and got: " + g16.subtract( g14 ) );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " ); }

      System.out.println( "\n      Test 037: Subtracting g1 take away g1 [too long to list] using bytes: " );
      try {
         System.out.println( "      expecting: 000000000000000000000000000000000000000000000000000000000000000000\n" +
                             "        and got: " + g1.subtract( g1 ) );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " ); }

      System.out.println( "\n      Test 037a: Subtracting t7 take away t12 [98423864442223256898441332 - 9987541112220] using bytes: " );
      try {
         System.out.println( "      expecting: 98423864442213269357329112\n" +
                             "        and got: " + t7.subtract( t12 ) );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " ); }

      System.out.println( "\n      Test 037b: Subtracting t12 take away t7 [9987541112220 - 98423864442223256898441332] using bytes: " );
      try {
         System.out.println( "      expecting: -98426864442213269357329112\n" +
                             "        and got: " + t12.subtract( t7 ) );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " ); }

      System.out.println( "\n      Test 037c: Subtracting t7 take away t6 [9987541112220 - 164213213] using bytes: " );
      try {
         System.out.println( "      expecting: 9987376899007\n" +
                             "        and got: " + t7.subtract( t6 ) );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " ); }

      System.out.println( "\n      Test 037d: Subtracting t6 take away t7 [164213213 - 9987541112220] using bytes: " );
      try {
         System.out.println( "      expecting: -9987376899007\n" +
                             "        and got: " + t6.subtract( t7 ) );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " ); }

      System.out.println( "\n      Test 037e: Subtracting t6 take away t10 [164213213 - (-248392)] using bytes: " );
      try {
         System.out.println( "      expecting: 164461605\n" +
                             "        and got: " + t6.subtract( t10 ) );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " ); }

      System.out.println( "\n      Test 037f: Subtracting t10 take away t6 [(-248392) - 164213213] using bytes: " );
      try {
         System.out.println( "      expecting: -164461605\n" +
                             "        and got: " + t10.subtract( t6 ) );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " ); }

      System.out.println( "\n      Test 037g: Subtracting t9 take away t6 [++1 - 164213213] using bytes: " );
      try {
         System.out.println( "      expecting: exception\n" +
                             "        and got: " + t9.subtract( t6 ) );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " ); }

      System.out.println( "\n      Test 037h: Subtracting t6 take away t8 [164213213 - (-4444444449856765432)] using bytes: " );
      try {
         System.out.println( "      expecting: 4444444449856765432\n" +
                             "        and got: " + t6.subtract( t8 ) );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " ); }

      System.out.println( "\n      Test 037i: Subtracting t8 take away t6 [(-4444444449856765432) - 164213213] using bytes: " );
      try {
         System.out.println( "      expecting: -4444444449856765432\n" +
                             "        and got: " + t8.subtract( t6 ) );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " ); }

      System.out.println( "\n      Test 037j: Subtracting t15 take away t5 [20000000666666666654321 - 00000000] using bytes: " );
      try {
         System.out.println( "      expecting: 20000000666666666654321\n" +
                             "        and got: " + t15.subtract( t5 ) );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " ); }

      System.out.println( "\n      Test 037k: Subtracting t5 take away t15 [00000000 - 20000000666666666654321] using bytes: " );
      try {
         System.out.println( "      expecting: -20000000666666666654321\n" +
                             "        and got: " + t5.subtract( t15 ) );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " ); }

      System.out.println( "\n      Test 037l: Subtracting t7 take away t13 [98423864442223256898441332 - (-84521022654897965219844)] using bytes: " );
      try {
         System.out.println( "      expecting: 98508385464878155027874389\n" +
                             "        and got: " + t7.subtract( t13 ) );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " ); }

      System.out.println( "\n      Test 037m: Subtracting t13 take away t7 [(-84521022654897965219844) - 98423864442223256898441332] using bytes: " );
      try {
         System.out.println( "      expecting: -98508385464878155027874389\n" +
                             "        and got: " + t13.subtract( t7 ) );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " ); }

      System.out.println( "\n      Test 037n: Subtracting t17 take away t5 [++23422-- - 00000000] using bytes: " );
      try {
         System.out.println( "      expecting: exception\n" +
                             "        and got: " + t17.subtract( t5 ) );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " ); }

      System.out.println( "\n      Test 037o: Subtracting t8 take away t15 [(-4444444449856765432) - 20000000666666666654321] using bytes: " );
      try {
         System.out.println( "      expecting: -20004445111116523419753\n" +
                             "        and got: " + t8.subtract( t15 ) );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " ); }

      System.out.println( "\n      Test 037p: Subtracting t15 take away t8 [20000000666666666654321 - (-4444444449856765432)] using bytes: " );
      try {
         System.out.println( "      expecting: 20004445111116523419753\n" +
                             "        and got: " + t15.subtract( t8 ) );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " ); }

      System.out.println( "\n      Test 037q: Subtracting t12 take away t13 [9987541112220 - (-84521022654897965219844)] using bytes: " );
      try {
         System.out.println( "      expecting: 84521022664885506332064\n" +
                             "        and got: " + t12.subtract( t13 ) );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " ); }

      System.out.println( "\n      Test 037r: Subtracting t13 take away t12 [(-84521022654897965219844) - 9987541112220] using bytes: " );
      try {
         System.out.println( "      expecting: -84521022664885506332064\n" +
                             "        and got: " + t13.subtract( t12 ) );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " ); }

      System.out.println( "\n      Test 037s: Subtracting t12 take away t8 [9987541112220 - (-4444444449856765432)] using bytes: " );
      try {
         System.out.println( "      expecting: 4444454437397877652\n" +
                             "        and got: " + t12.subtract( t8 ) );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " ); }

      System.out.println( "\n      Test 037t: Subtracting t8 take away t12 [(-4444444449856765432) - 9987541112220] using bytes: " );
      try {
         System.out.println( "      expecting: -4444454437397877652\n" +
                             "        and got: " + t8.subtract( t12 ) );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " ); }


      System.out.println( "\n\n    TESTING MULTIPLY() METHOD:\n" +
                          "    ==========================" );
      System.out.println( "\n      Test 038: Multiplying g7 by g12 [10 * 20]: " );
      try {
         System.out.println( "      expecting: 200\n" +
                             "        and got: " + g7.multiply( g12 ) );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " + e.toString() ); }

      System.out.println( "\n    Test 039: Making a seventeenth new BrobInt: "  );
      try {
         g17 = new BrobInt( g17String );
         System.out.println( "      expecting: 765\n" +
                             "        and got: " + g17.toString() );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " ); }

      System.out.println( "\n    Test 040: Making a eightteenth new BrobInt: "  );
      try {
         g18 = new BrobInt( g18String );
         System.out.println( "      expecting: 23\n" +
                             "        and got: " + g18.toString() );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " ); }

      System.out.println( "\n    Test 041: Making a nineteenth new BrobInt: "  );
      try {
         g19 = new BrobInt( g19String );
         System.out.println( "      expecting: 56789\n" +
                             "        and got: " + g19.toString() );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " ); }

      System.out.println( "\n    Test 042: Making a twentieth new BrobInt: "  );
      try {
         g20 = new BrobInt( g20String );
         System.out.println( "      expecting: 37\n" +
                             "        and got: " + g20.toString() );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " ); }

      System.out.println( "\n      Test 043: Multiplying g17 by g18 [765 * 23]: " );
      try {
         System.out.println( "      expecting: 17595\n" +
                             "        and got: " + g17.multiply( g18 ) );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " + e.toString() ); }

      System.out.println( "\n      Test 044: Multiplying g18 by g20 [23 * 37]: " );
      try {
         System.out.println( "      expecting: 851\n" +
                             "        and got: " + g18.multiply( g20 ) );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " + e.toString() ); }

      System.out.println( "\n      Test 045: Multiplying g19 by g20 [56789 * 37]: " );
      try {
         System.out.println( "      expecting: 2101193\n" +
                             "        and got: " + g19.multiply( g20 ) );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " + e.toString() ); }

      System.out.println( "\n      Test 046: Multiplying g18 by g17 [23 * 765]: " );
      try {
         System.out.println( "      expecting: 17595\n" +
                             "        and got: " + g18.multiply( g17 ) );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " + e.toString() ); }

      System.out.println( "\n      Test 047: Multiplying g17 by g19 [765 * 56789]: " );
      try {
         System.out.println( "      expecting: 43443585\n" +
                             "        and got: " + g17.multiply( g19 ) );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " + e.toString() ); }

      System.out.println( "\n      Test 048: Multiplying g20 by g19 [37 * 56789]: " );
      try {
         System.out.println( "      expecting: 2101193\n" +
                             "        and got: " + g20.multiply( g19 ) );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " + e.toString() ); }

      System.out.println( "\n      Test 048a: Multiplying t6 by 542 [164213213 * 542]: " );
      try {
         System.out.println( "      expecting: 89003561446\n" +
                             "        and got: " + t6.multiply( s2 ) );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " + e.toString() ); }

      System.out.println( "\n      Test 048b: Multiplying t7 by 3 [98423864442223256898441332 * 3]: " );
      try {
         System.out.println( "      expecting: 295271593326669770695323996\n" +
                             "        and got: " + t7.multiply( s1 ) );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " + e.toString() ); }

      System.out.println( "\n      Test 048c: Multiplying 3 by t7 [10 * 20]: " );
      try {
         System.out.println( "      expecting: 295271593326669770695323996\n" +
                             "        and got: " + s1.multiply( t7 ) );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " + e.toString() ); }

      System.out.println( "\n      Test 048d: Multiplying 542 by t6 [542 * 164213213]: " );
      try {
         System.out.println( "      expecting: 200\n" +
                             "        and got: " + s2.multiply( t6 ) );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " + e.toString() ); }

      System.out.println( "\n      Test 048e: Multiplying s2 by s1 [542 * 3]: " );
      try {
         System.out.println( "      expecting: 1626\n" +
                             "        and got: " + s2.multiply( s1 ) );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " + e.toString() ); }

      System.out.println( "\n      Test 048f: Multiplying s1 by s2 [3 * 542]: " );
      try {
         System.out.println( "      expecting: 1626\n" +
                             "        and got: " + s1.multiply( s2 ) );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " + e.toString() ); }

      System.out.println( "\n      Test 048g: Multiplying t9 by s1 [++1 * 3]: " );
      try {
         System.out.println( "      expecting: exception\n" +
                             "        and got: " + t9.multiply( s1 ) );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " + e.toString() ); }

      System.out.println( "\n      Test 048h: Multiplying t16 by s2 [-2342+ * 542]: " );
      try {
         System.out.println( "      expecting: exception\n" +
                             "        and got: " + t16.multiply( s2 ) );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " + e.toString() ); }

      System.out.println( "\n      Test 048i: Multiplying s1 by s1 [3 * 3]: " );
      try {
         System.out.println( "      expecting: 9\n" +
                             "        and got: " + s1.multiply( s1 ) );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " + e.toString() ); }

      System.out.println( "\n      Test 048j: Multiplying s2 by s2 [542 * 542]: " );
      try {
         System.out.println( "      expecting: 293764\n" +
                             "        and got: " + s2.multiply( s2 ) );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " + e.toString() ); }

      System.out.println( "\n      Test 048k: Multiplying t12 by s2 [9987541112220 * 542]: " );
      try {
         System.out.println( "      expecting: 5413247282823240\n" +
                             "        and got: " + t12.multiply( s2 ) );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " + e.toString() ); }

      System.out.println( "\n      Test 048l: Multiplying s2 by t12 [542 * 9987541112220]: " );
      try {
         System.out.println( "      expecting: 5413247282823240\n" +
                             "        and got: " + s2.multiply( t12 ) );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " + e.toString() ); }

      System.out.println( "\n      Test 048m: Multiplying t12 by t12 [9987541112220 * 9987541112220]: " );
      try {
         System.out.println( "      expecting: 99750977468284714633328400\n" +
                             "        and got: " + t12.multiply( t12 ) );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " + e.toString() ); }

      System.out.println( "\n      Test 048n: Multiplying t12 by s1 [9987541112220 * 3]: " );
      try {
         System.out.println( "      expecting: 29962623336660\n" +
                             "        and got: " + t12.multiply( s1 ) );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " + e.toString() ); }

      System.out.println( "\n      Test 048o: Multiplying s1 by t12 [9987541112220 * 3]: " );
      try {
         System.out.println( "      expecting: 29962623336660\n" +
                             "        and got: " + s1.multiply( t12 ) );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " + e.toString() ); }

      System.out.println( "\n      Test 048p: Multiplying t15 by s2 [20000000666666666654321 * 542]: " );
      try {
         System.out.println( "      expecting: 10840000361333333326641982\n" +
                             "        and got: " + t15.multiply( s2 ) );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " + e.toString() ); }

      System.out.println( "\n      Test 048q: Multiplying s2 by t15 [542 * 20000000666666666654321]: " );
      try {
         System.out.println( "      expecting: 10840000361333333326641982\n" +
                             "        and got: " + s2.multiply( t15 ) );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " + e.toString() ); }

      System.out.println( "\n      Test 048r: Multiplying t15 by s1 [20000000666666666654321 * 3]: " );
      try {
         System.out.println( "      expecting: 200\n" +
                             "        and got: " + t15.multiply( s1 ) );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " + e.toString() ); }

      System.out.println( "\n      Test 048s: Multiplying s1 by t15 [3 * 20000000666666666654321]: " );
      try {
         System.out.println( "      expecting: 60000001999999999962963\n" +
                             "        and got: " + s1.multiply( t15 ) );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " + e.toString() ); }

      System.out.println( "\n      Test 048t: Multiplying t10 by t10 [-248392 * -248392]: " );
      try {
         System.out.println( "      expecting: 61698585664\n" +
                             "        and got: " + t10.multiply( t10 ) );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " + e.toString() ); }



      System.out.println( "\n\n    TESTING DIVIDE() METHOD:\n" +
                          "    ========================" );
      System.out.println( "\n      Test 049: Dividing g19 by g20 [56789 / 37]: " );
      try {
         System.out.println( "      expecting: 1534\n" +
                             "        and got: " + g19.divide( g20 ) );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " + e.toString() ); }

      System.out.println( "\n      Test 050: Dividing g17 by g20 [765 / 37]: " );
      try {
         System.out.println( "      expecting: 20\n" +
                             "        and got: " + g17.divide( g20 ) );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " + e.toString() ); }

      System.out.println( "\n      Test 050a: Dividing t12 by s6 [9987541112220 / 10]: " );
      try {
         System.out.println( "      expecting: 998754111222\n" +
                             "        and got: " + t12.divide( s6 ) );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " + e.toString() ); }

      System.out.println( "\n      Test 050b: Dividing t12 by s5 [9987541112220 / 5]: " );
      try {
         System.out.println( "      expecting: 1997508222444\n" +
                             "        and got: " + t12.divide( s5 ) );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " + e.toString() ); }

      System.out.println( "\n      Test 050c: Dividing t12 by s4 [9987541112220 / 2]: " );
      try {
         System.out.println( "      expecting: 4993770556110\n" +
                             "        and got: " + t12.divide( s4 ) );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " + e.toString() ); }

      System.out.println( "\n      Test 050d: Dividing t12 by s3 [9987541112220 / 1]: " );
      try {
         System.out.println( "      expecting: 9987541112220\n" +
                             "        and got: " + t12.divide( s3 ) );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " + e.toString() ); }

      System.out.println( "\n      Test 050e: Dividing t10 by s3 [(-248392) / 1]: " );
      try {
         System.out.println( "      expecting: -248392\n" +
                             "        and got: " + t10.divide( s3 ) );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " + e.toString() ); }

      System.out.println( "\n      Test 050f: Dividing t10 by s4 [(-248392) / 2]: " );
      try {
         System.out.println( "      expecting: 20\n" +
                             "        and got: " + t10.divide( s4 ) );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " + e.toString() ); }

      System.out.println( "\n      Test 050g: Dividing t18 by s4 [138492832 / 2]: " );
      try {
         System.out.println( "      expecting: exception\n" +
                             "        and got: " + t18.divide( s4 ) );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " + e.toString() ); }

      System.out.println( "\n      Test 050h: Dividing t18 by s3 [138492832 / 1]: " );
      try {
         System.out.println( "      expecting: exception\n" +
                             "        and got: " + t18.divide( s3 ) );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " + e.toString() ); }

      System.out.println( "\n      Test 050i: Dividing t13 by s1 [(-84521022654897965219844) / 3]: " );
      try {
         System.out.println( "      expecting: -28173674218299321739948\n" +
                             "        and got: " + t13.divide( s1 ) );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " + e.toString() ); }

      System.out.println( "\n      Test 050j: Dividing t13 by s3 [(-84521022654897965219844) / 1]: " );
      try {
         System.out.println( "      expecting: -84521022654897965219844\n" +
                             "        and got: " + t13.divide( s3 ) );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " + e.toString() ); }

      System.out.println( "\n      Test 050k: Dividing t8 by s4 [(-4444444449856765432) / 2]: " );
      try {
         System.out.println( "      expecting: -2222222224928382716\n" +
                             "        and got: " + t8.divide( s4 ) );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " + e.toString() ); }

      System.out.println( "\n      Test 050l: Dividing t8 by s3 [(-4444444449856765432) / 1]: " );
      try {
         System.out.println( "      expecting: -4444444449856765432\n" +
                             "        and got: " + t8.divide( s3 ) );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " + e.toString() ); }

      System.out.println( "\n      Test 050m: Dividing s2 by s4 [542 / 2]: " );
      try {
         System.out.println( "      expecting: 271\n" +
                             "        and got: " + s2.divide( s4 ) );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " + e.toString() ); }

      System.out.println( "\n      Test 050n: Dividing t4 by s4 [(-22222222222222222222222222222222222222222222222222) / 2]: " );
      try {
         System.out.println( "      expecting: -11111111111111111111111111111111111111111111111111\n" +
                             "        and got: " + t4.divide( s4 ) );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " + e.toString() ); }

      System.out.println( "\n      Test 050o: Dividing t6 by s3 [164213213 / 1]: " );
      try {
         System.out.println( "      expecting: 164213213\n" +
                             "        and got: " + t6.divide( s3 ) );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " + e.toString() ); }

      System.out.println( "\n      Test 050p: Dividing t6 by t6 [164213213 / 164213213]: " );
      try {
         System.out.println( "      expecting: 1\n" +
                             "        and got: " + t6.divide( t6 ) );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " + e.toString() ); }

      System.out.println( "\n      Test 050q: Dividing t5 by s4 [00000000 / 2]: " );
      try {
         System.out.println( "      expecting: 0\n" +
                             "        and got: " + t5.divide( s4 ) );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " + e.toString() ); }

      System.out.println( "\n      Test 050r: Dividing s6 by s5 [10 / 5]: " );
      try {
         System.out.println( "      expecting: 2\n" +
                             "        and got: " + s6.divide( s5 ) );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " + e.toString() ); }

      System.out.println( "\n      Test 050s: Dividing s6 by s4 [10 / 2]: " );
      try {
         System.out.println( "      expecting: 5\n" +
                             "        and got: " + s6.divide( s4 ) );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " + e.toString() ); }

      System.out.println( "\n      Test 050t: Dividing s6 by s6 [10 / 10]: " );
      try {
         System.out.println( "      expecting: 1\n" +
                             "        and got: " + s6.divide( s6 ) );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " + e.toString() ); }

      System.out.println( "\n\n    TESTING REMAINDER() METHOD:\n" +
                          "    ===========================" );
      System.out.println( "\n      Test 051: Modding g17 by g18 [765 % 23]: " );
      try {
         System.out.println( "      expecting: 6\n" +
                             "        and got: " + g17.remainder( g18 ) );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " + e.toString() ); }

      System.out.println( "\n      Test 052: Modding g19 by g20 [56789 % 37]: " );
      try {
         System.out.println( "      expecting: 31\n" +
                             "        and got: " + g19.remainder( g20 ) );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " + e.toString() ); }

      System.out.println( "\n      Test 052a: Modding s6 by s5 [10 % 5]: " );
      try {
         System.out.println( "      expecting: 0\n" +
                             "        and got: " + s6.remainder( s5 ) );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " + e.toString() ); }

      System.out.println( "\n      Test 052b: Modding t15 by s5 [20000000666666666654321 % 5]: " );
      try {
         System.out.println( "      expecting: 1\n" +
                             "        and got: " + t15.remainder( s5 ) );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " + e.toString() ); }

      System.out.println( "\n      Test 052c: Modding t13 by s5 [(-84521022654897965219844) % 5]: " );
      try {
         System.out.println( "      expecting: 4\n" +
                             "        and got: " + t13.remainder( s5 ) );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " + e.toString() ); }

      System.out.println( "\n      Test 052d: Modding s2 by s5 [542 % 5]: " );
      try {
         System.out.println( "      expecting: 2\n" +
                             "        and got: " + s2.remainder( s5 ) );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " + e.toString() ); }

      System.out.println( "\n      Test 052e: Modding t12 by s5 [9987541112220 % 5]: " );
      try {
         System.out.println( "      expecting: 0\n" +
                             "        and got: " + t12.remainder( s5 ) );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " + e.toString() ); }

      System.out.println( "\n      Test 052f: Modding t10 by s5 [(-248392) % 5]: " );
      try {
         System.out.println( "      expecting: 2\n" +
                             "        and got: " + t10.remainder( s5 ) );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " + e.toString() ); }

      System.out.println( "\n      Test 052g: Modding t8 by s5 [(-4444444449856765432) % 5]: " );
      try {
         System.out.println( "      expecting: 2\n" +
                             "        and got: " + t8.remainder( s5 ) );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " + e.toString() ); }

      System.out.println( "\n      Test 052h: Modding t7 by s5 [98423864442223256898441332 % 5]: " );
      try {
         System.out.println( "      expecting: 2\n" +
                             "        and got: " + t7.remainder( s5 ) );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " + e.toString() ); }

      System.out.println( "\n      Test 052i: Modding t6 by s5 [164213213 % 5]: " );
      try {
         System.out.println( "      expecting: 3\n" +
                             "        and got: " + t6.remainder( s5 ) );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " + e.toString() ); }

      System.out.println( "\n      Test 052j: Modding t4 by s5 [(-22222222222222222222222222222222222222222222222222) % 5]: " );
      try {
         System.out.println( "      expecting: 2\n" +
                             "        and got: " + t4.remainder( s5 ) );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " + e.toString() ); }

      System.out.println( "\n      Test 052k: Modding t2 by s5 [123456789987654321012345678998765432101023564898765432130231098753218972 % 5]: " );
      try {
         System.out.println( "      expecting: 2\n" +
                             "        and got: " + t2.remainder( s5 ) );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " + e.toString() ); }

      System.out.println( "\n      Test 052l: Modding g16 by s5 [56789 % 5]: " );
      try {
         System.out.println( "      expecting: 4\n" +
                             "        and got: " + g16.remainder( s5 ) );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " + e.toString() ); }

      System.out.println( "\n      Test 052m: Modding g13 by s5 [234567 % 5]: " );
      try {
         System.out.println( "      expecting: 2\n" +
                             "        and got: " + g13.remainder( s5 ) );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " + e.toString() ); }

      System.out.println( "\n      Test 052n: Modding g19 by g20 [56789 % 37]: " );
      try {
         System.out.println( "      expecting: 31\n" +
                             "        and got: " + g19.remainder( g20 ) );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " + e.toString() ); }

      System.out.println( "\n      Test 052o: Modding t15 by s4 [20000000666666666654321 % 2]: " );
      try {
         System.out.println( "      expecting: 1\n" +
                             "        and got: " + t15.remainder( s4 ) );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " + e.toString() ); }

      System.out.println( "\n      Test 052p: Modding t15 by t6 [20000000666666666654321 % 164213213]: " );
      try {
         System.out.println( "      expecting: 103301199\n" +
                             "        and got: " + t15.remainder( t6 ) );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " + e.toString() ); }

      System.out.println( "\n      Test 052q: Modding t7 by t15 [98423864442223256898441332 % 20000000666666666654321]: " );
      try {
         System.out.println( "      expecting: 3861161556590292527691\n" +
                             "        and got: " + t7.remainder( t15 ) );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " + e.toString() ); }

      System.out.println( "\n      Test 052r: Modding t7 by t12 [98423864442223256898441332 % 9987541112220]: " );
      try {
         System.out.println( "      expecting: 6105465869852\n" +
                             "        and got: " + t7.remainder( t12 ) );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " + e.toString() ); }

      System.out.println( "\n      Test 052s: Modding t15 by s6 [20000000666666666654321 % 10]: " );
      try {
         System.out.println( "      expecting: 1\n" +
                             "        and got: " + t15.remainder( s6 ) );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " + e.toString() ); }

      System.out.println( "\n      Test 052t: Modding g19 by s6 [56789 % 10]: " );
      try {
         System.out.println( "      expecting: 9\n" +
                             "        and got: " + g19.remainder( s6 ) );
      }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " + e.toString() ); }

      System.exit( 0 );

   }
}