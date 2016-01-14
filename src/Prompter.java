/**
 * 
 */

/**
 * @author Salman
 *
 */
import java.util.Scanner;

public class Prompter {
	private Game mGame;
	
	public Prompter(Game game) {
		mGame = game;
	}
	
	public void play() {
		// play as long as there are guesses remaining
		while (mGame.getRemainingTries() > 0) {
			displayProgress();
			promptForGuess();
		}
	}
	
	@SuppressWarnings("resource")
	public boolean promptForGuess() {
	
		System.out.print("Enter new letter: ");
		Scanner scan = new Scanner(System.in);
	
		
		boolean isHit = false;
		boolean isValidGuess = false;
		
		// Keep prompting user until a valid guess is submitted
		while (! isValidGuess) {
			// Scanner reads guess as a String so it has 
			// to be converted to char since the applyGuess method
			// takes guess of type char as input
			String guessAsString = scan.nextLine();
			char guess = guessAsString.charAt(0);
			
			try {
				// since applyGuess() can throw an exception
				isHit = mGame.applyGuess(guess);
				isValidGuess = true;	// if no exception thrown
			} catch (IllegalArgumentException iae) {
				System.out.println("Please try again");
				System.out.println(iae.getMessage());
			}
		}
		return isHit;
	}
	
	public void displayProgress() {
		System.out.printf("Your current progress is %s\nyou have %d guesses left\n\n", 
				mGame.getCurrentProgress(),
				mGame.getRemainingTries()
				);
	}

}
