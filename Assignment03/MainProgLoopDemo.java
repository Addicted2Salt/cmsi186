


public class MainProgLoopDemo{

   public static void main( String args[] ) {
      System.out.println( "\n   Welcome to the MainProgLoopDemo!!\n" );
      System.out.println( "     Press the 'q' key to quit the program." );
      
      var console = System.console();

      while( true ) {
         System.out.print( ">>" );

         try {
            String command = console.readLine("Enter some text! ").trim();
            System.out.println( "   You typed " + command );
         
            /*if( 'q' == command.charAt(0) ) {
               break;
            } */

            switch (command) {
               case "hello": System.out.println("Hi buddy!"); break;
               case "hi": System.out.println("whats up"); break;
               case "q": System.exit(0);
               default: System.out.println("hola!");
            }

         } catch (Exception e) {
            System.err.println(e.getMessage());
         }
      }
   }
}