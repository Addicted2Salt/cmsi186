
public class SubtractRecursion {

	public static long subtract( long biggerLong, long smallerLong ) {
      		
      	biggerLong -= 1;
      	smallerLong -= 1;
      	
      	if( smallerLong > 0 ) {
      		// This is recursion! The subtract function calls itself!
			return subtract(biggerLong,smallerLong);
      	} 	
      	
      	return biggerLong;  
	}

   
   public static void main( String[] args ) {
      try {
        long arg1 = Long.parseLong(args[0]);
        long arg2 = Long.parseLong(args[1]);  
        if ( arg1 < 0 || arg2 < 0 ) {
            throw new IllegalArgumentException("This program only works with positive numbers."); 
        } else if ( arg2 == arg1 ) {
        	System.out.println( arg1 + " - " + arg2 + " = 0"); 
        } else if ( arg2 > arg1 ) {
        	System.out.println( arg2 + " - " + arg1 + " = " + subtract(arg2, arg1)); 
        } else {
        	System.out.println( arg1 + " - " + arg2 + " = " + subtract(arg1, arg2)); 
        }   
      } catch (NumberFormatException nfe) {
        System.out.println("can't convert arg to a long");
      } catch ( IllegalArgumentException iae ) {
      	System.out.println(iae.getMessage());
      }
       

   }
}
