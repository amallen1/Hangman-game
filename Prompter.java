import java.util.Scanner;

public class Prompter {

	private Game game;

	public Prompter(Game game) {
		this.game = game;
	}

	
	public boolean promptForGuess() {
		boolean isHit = false;
		Scanner scnr = new Scanner(System.in);
		 boolean isAcceptable = false;
		
		//Prompting for a guess loop
		do {
			System.out.println("Enter a letter: ");
			String guessInput = scnr.nextLine();
			
			try {
				isHit = game.applyGuess(guessInput);
				isAcceptable = true;
			} catch (IllegalArgumentException e) {
				System.out.printf("%s Please try again. %n", e.getMessage());
			}
		} while (!isAcceptable);
		return isHit;
	}
	
	
	public void displayProgress() {
		System.out.printf("You have %d tries left to solve:   %s%n",
				game.getRemainingTries(),
				game.getCurrentProgress());
	}
	
	public void displayOutcome() {
		if (game.isWon()) {
			System.out.printf("Congratulations you won with %d tries remaining.%n",
					game.getRemainingTries());
		} else {
			System.out.printf("Sorry! The answer was: %s%n", game.getAnswer());
		}
	}
}
