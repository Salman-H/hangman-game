/**
 * 
 */

/**
 * @author Salman
 *
 */
public class Hangman {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Game game = new Game("reflection");
		Prompter prompter = new Prompter(game);
		
		// Display current progress before prompting user for new guess
		prompter.displayProgress();
		
		// Then prompt for guess 
		boolean isHit = prompter.promptForGuess();
		
		if (isHit) {
			System.out.println("We got a hit!");
		}
		else {
			System.out.println("Whoops that was a miss!");
		}
		
		// Display current progress again after user submits their guess
		prompter.displayProgress();

	}

}
