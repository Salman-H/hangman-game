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
	
	@SuppressWarnings("resource")
	public boolean promptForGuess() {
		
		// String guessAsString = scanner.nextLine();
		
		System.out.println("Enter new guess: ");
		Scanner scan = new Scanner(System.in);
		
		// Scanner reads guess as a String so it has 
		// to be converted to char since the applyGuess method
		// takes guess of type char as input
		String guessAsString = scan.nextLine();
		char guess = guessAsString.charAt(0);
		
		return mGame.applyGuess(guess);
	}
	
	public void displayProgress() {
		System.out.printf("Your current progress: %s\n", mGame.getCurrentProgress());
	}

}
