public class Hangman {

	public static void main(String[] args) {
	
		
		//Creates a game object
		Game game = new Game("Treehouse"); //Treehouse is the word to guess
		
		
		//Creates a prompter object
		Prompter prompter = new Prompter(game);
		
		//Game loop

		while (game.getRemainingTries() > 0 && !game.isWon()) {

			prompter.displayProgress();
			prompter.promptForGuess();
		}
		
		//Once the game is over, displays whether the user wins or loses.
		prompter.displayOutcome();

		//If you are out of tries
		if (game.getRemainingTries() == 0) {
			System.out.println("You Lose!");
		}

	}
}
