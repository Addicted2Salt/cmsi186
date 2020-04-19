// First, let's import BigInt

import java.math.BigInteger;


public class LetsAddWithBigInt {

   
   public static void main( String[] args ) {
   		BigInteger a = null;
   		BigInteger b = null;
   		BigInteger c = null;

   		try {
   			a = new BigInteger("203000000000000000000000000000000000000000000000000984");
        	b = new BigInteger("293847");
        	c = new BigInteger("-10000000000000000000000000000000000000000000000000000000000000000000000");
   		} catch (NumberFormatException nfe) {
   			System.out.println("Error converting string to BigInteger");
   		}

   		System.out.println("Adding: "+ b.toString() + " + " + a.toString() + " = " + (a.add(b)).toString() );
        System.out.println("Dividing: "+ b.toString() + " / " + a.toString() + " = " + (b.divide(a)).toString() );
        System.out.println("Remainder: "+ b.toString() + " % " + a.toString() + " = " + (b.remainder(a)).toString() );  
        System.out.println("Adding: "+ b.toString() + " + " + c.toString() + " = " + (b.add(c)).toString() ); 
   }
}
