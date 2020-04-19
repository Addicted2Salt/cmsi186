
public class LetsAdd {

   
   public static void main( String[] args ) {
      try {
        long l1 = Long.parseLong(args[0]);
        System.out.println(l1 + 1);
      } catch (NumberFormatException nfe) {
        System.out.println("can't convert " + args[0] + " to a long");
      }
      

   }
}
