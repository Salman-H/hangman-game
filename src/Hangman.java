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
		
		prompter.play();
	}
}
