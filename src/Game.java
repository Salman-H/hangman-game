/**
 * 
 */

/**
 * @author Salman
 *
 */
public class Game {
	
	public static final int MAX_MISSES = 7;
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
	 * Validate user's guess by checking if:
	 * - guess submitted is actually a letter
	 * - guess submitted has not already been guessed before 
	 */
	private char validateGuess(char letter) {
		// throw an exception if guess is not a letter
		if (! Character.isLetter(letter)) {
			throw new IllegalArgumentException("A letter is required!");
		}
		// otherwise make the letter lowercase in case user submitted an uppercase letter
		letter = Character.toLowerCase(letter);
		
		// throw an exception if a guess has been guessed before
		// Check if submitted letter hasn't been guessed before
		// either as a Miss (incorrect guess) or a Hit (correct guess)
		if (mMisses.indexOf(letter) >= 0 || mHits.indexOf(letter) >= 0) {
			// we would still consider the already guessed letter as an illegal argument
			throw new IllegalArgumentException(letter + " has already been guessed!");
		}
		
		// all clear
		return letter;
	}
	
	/*
	 * 
	 */
	public boolean applyGuess(String letters) {
		if (letters.length() == 0) {
			throw new IllegalArgumentException("No letters found!");
		}
		return applyGuess(letters.charAt(0));
	}
	 
	/*
	 *  Takes the guessed letter and checks if the 
	 *  answer for the current game contains that letter
	 */
	public boolean applyGuess(char letter) {
		boolean isHit = mAnswer.indexOf(letter) >= 0;
		
		// Validate submitted letter
		letter = validateGuess(letter);
		
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
		// else, display a '-'
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
	
	public int getRemainingTries() {
		return MAX_MISSES - mMisses.length();
	}

}
