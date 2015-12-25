/**
 * 
 */

/**
 * @author Salman
 *
 */
public class Game {
	
	private String mAnswer;
	private String mHits;
	private String mMisses;
	
	/*
	 *  Every Game object, that represents a different 
	 *  hangman game, has a unique answer
	 */
	public Game(String answer) {
		mAnswer = answer;
		mHits = "";
		mMisses = "";
	}
	
	/*
	 *  Takes the guessed letter and checks if the 
	 *  answer for the current game contains that letter
	 */
	public boolean applyGuess(char letter) {
		boolean isHit = mAnswer.indexOf(letter) >= 0;
		
		if (isHit) {
			mHits += letter;
		}
		else {
			mMisses += letter;
		}
		return isHit;
	}

}
