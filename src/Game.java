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
	
	/*
	 *  Displays current progress as a String of 
	 *  '_'s corresponding to the chosen word with 
	 *  correctly guessed letters filled in
	 */
	public String getCurrentProgress() {
		
		String progress = "";
		
		// break the answer String into a char array
		
		char[] answerArray = mAnswer.toCharArray();
		
		// if the mHits String contains the current
		// char being iterated over, display that char
		// else, display a '_'
		for (char letter: answerArray) {
			if (mHits.indexOf(letter) >= 0) {
				progress += letter;
			}
			else {
				progress += '-';
			}
		}
		
		return progress;
	}

}
