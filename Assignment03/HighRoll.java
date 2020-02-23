public class HighRoll {


	public static void main (String[] args) {
		
	String menu = "\n Menu: \n    <R> : Roll all \n    <I> : Roll Individual \n    <C> : Display your current score \n    <S> : Saves your current score to High Roll \n    <H> : Display your High Roll \n    <M> : Display menu \n    <N> : Creates new game \n    <Q> : Quit the game \n ";
	int count = 0;
	int sides = 0;
	var console = System.console();

		if (args.length == 0) {
			System.out.println("No dice set inputted, using default 4 die with 6 sides!");
			count = 4;
			sides = 6;
		} else if (args.length < 2 || args.length > 2) {
			System.out.println("You are either missing the number of die, or the number of sides! \n System will now exit, please try again!");
			System.exit(0);
		} else {
			try {
				count = Integer.parseInt(args[0]);
				sides = Integer.parseInt(args[1]);
			} catch (IllegalArgumentException iae) {
				System.out.println("Die needs to have at least 4 sides. Please try again!");
				System.exit(0);
			} catch (ArrayIndexOutOfBoundsException aioobe) {
				System.exit(0);
			}
			count = Integer.parseInt(args[0]);
			sides = Integer.parseInt(args[1]);
		}
		//creating new DiceSet
		try {
			DiceSet highRoll = new DiceSet(count, sides);
		} catch (IllegalArgumentException iae) {
				System.out.println("Die needs to have at least 4 sides. Please try again!");
				System.exit(0);
		} catch (ArrayIndexOutOfBoundsException aioobe) {
				System.exit(0);
		}
		DiceSet highRoll = new DiceSet(count, sides);
		/*Since DiceSet initializes with Dice set to max values, roll randomizes so that high score
		 is not achieved immediately */
		highRoll.roll();
		System.out.println("\n Welcome to High Roll! \n");
		System.out.println("	The objective of this game is to roll the highest possible score.");
		System.out.println(menu);
		System.out.println("Your current dice set is: ");
		System.out.println(highRoll.toString());
		// Saves initial roll as high score
		int highRollScore = highRoll.sum();
		System.out.println("Your current score and High Roll is: " + highRollScore);
		

		while(true) {
			try {
				String input = console.readLine("What do you want to do? ").trim(); 

				switch (input.toUpperCase()) {
					case "R":
					System.out.println("Rolling all your die!");
					highRoll.roll();
					highRoll.toString();
					System.out.println(" ");
					break;
					case "I": 
					int individual = Integer.parseInt(console.readLine("Which die would you like to roll?").trim()); 
					highRoll.rollIndividual(individual);
					highRoll.toString();
					System.out.println(" ");
					break;
					case "C":
					System.out.println("Your current score is: ");
					System.out.println(highRoll.sum());
					System.out.println(" ");
					break;
					case "S":
					int score = highRoll.sum();
					if (score > highRollScore) {
					highRollScore = score;
					System.out.println("You beat your old score!");
					System.out.println("Your new High Roll is: " + highRollScore);
					} else {
					System.out.println("Sorry, your score is not higher than your current High Roll. Keep rolling!");
					}
					System.out.println(" ");
					break;
					case "M":
					System.out.println(menu);
					System.out.println(" ");					
					break;
					case "H":
					System.out.println("Your current High Roll is: " + highRollScore);
					System.out.println(" ");
					break;
					case "N":
					int newCount = Integer.parseInt(console.readLine("How many die do you want in your new dice set? "));
					int newSides = Integer.parseInt(console.readLine("How many sides do you want your new die to have?"));
					System.out.println("New dice set created with " + newCount + " die and " + newSides + " sides!");
					highRoll = new DiceSet(newCount, newSides);
					highRoll.roll();
					System.out.println(" ");
					break;
					case "Q":
					System.out.println("See you next time!");
					System.exit(0);
					default: System.out.println("High Roll!");
				}
			} catch (Exception e) {
				System.err.println(e.getMessage());
			} 

		}
	}
	

}
