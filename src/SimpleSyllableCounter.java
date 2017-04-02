
/**
 * A simple syllable counter that count a syllable from a 
 * given word.
 * @author Narut Poovorakit
 * @version 02.04.2017
 *
 */
public class SimpleSyllableCounter {
	
	/**
	 * Counting a syllables from a given word checking each of the
	 * character
	 * @param word is a given word in each line of the text.
	 * @return an amount of the syllables.
	 */
	public int countSyllables(String word) {
		int syllables = 0;
		char c = ' ';
		EnumState state = EnumState.START; // Start
		for (int k = 0; k < word.length(); k++) {
			c = word.charAt(k);
			if (c == '\'') continue; //ignore apostrophe
			switch (state) {
				// process character c using state machine
			case START: 
				if (isVowelOrY(c)) {
					state = EnumState.SINGLE_VOWEL;
					syllables++;
				}
				else if (c == 'e' || c == 'E') {
					state = EnumState.E;
					syllables++;
				}
				else if (Character.isLetter(c)) {
					state = EnumState.CONSONANT;
				}
				else state = EnumState.NONWORD;
				break;
				
			case CONSONANT:
				if (isVowelOrY(c)) { 
					state = EnumState.SINGLE_VOWEL;
					syllables++;
				}
				else if (c == 'e' || c == 'E') {
					state = EnumState.E;
					syllables++;
				}
				else if (Character.isLetter(c)) {
					state = EnumState.CONSONANT;
				}
				else if (c == '-') {
					state = EnumState.HYPHEN;
				}
				else state = EnumState.NONWORD;
				break;
				
			case E:
				if (isVowelOrY(c)) {
					if (c == 'y') {
						state = EnumState.CONSONANT;
					}
					else {
						state = EnumState.MULTIVOWEL;
					}
				}
				else if (c == 'e' || c == 'E') {
					state = EnumState.MULTIVOWEL;
				}
				else if (Character.isLetter(c)) {
					state = EnumState.CONSONANT;
				}
				else if (c == '-') {
					state = EnumState.HYPHEN;
				}
				else state = EnumState.NONWORD;
				break;
				
			case SINGLE_VOWEL:
				if (isVowelOrY(c)) {
					if (c == 'y') {
						state = EnumState.CONSONANT;
					}
					else {
						state = EnumState.MULTIVOWEL;
					}
				}
				else if (c == 'e' || c == 'E') {
					state = EnumState.MULTIVOWEL;
				}
				else if (Character.isLetter(c)) {
					state = EnumState.CONSONANT;
				}
				else if (c == '-') {
					state = EnumState.HYPHEN;
				}
				else state = EnumState.NONWORD;
				break;
				
			case MULTIVOWEL:
				if (isVowelOrY(c)) {
					state = EnumState.MULTIVOWEL;
				}
				else if (c == 'e' || c == 'E') {
					state = EnumState.MULTIVOWEL;
				}
				else if (Character.isLetter(c)) {
					state = EnumState.CONSONANT;
				}
				else if (c == '-') {
					state = EnumState.HYPHEN;
				}
				else state = EnumState.NONWORD;
				break;
				
			case HYPHEN:
				if (isVowelOrY(c)) {
					state = EnumState.SINGLE_VOWEL;
					syllables++;
				}
				else if (c == 'e' || c == 'E') {
					state = EnumState.E;
					syllables++;
				}
				else if (Character.isLetter(c)) {
					state = EnumState.CONSONANT;
				}
				else state = EnumState.NONWORD;
				break;
				
			default:
				if (Character.isWhitespace(c))
				break;
			}
		}
		if (state == EnumState.E && syllables > 1) {
			syllables--;
		}
		return syllables;
	}
	
	public boolean isVowelOrY(char c) {
		String s = c + "";
		if (s.equalsIgnoreCase("a") || s.equalsIgnoreCase("i") || s.equalsIgnoreCase("o") || s.equalsIgnoreCase("u") || s.equalsIgnoreCase("y")) 
			return true;
		else 
			return false;
	}
	
}
