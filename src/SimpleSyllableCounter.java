
public class SimpleSyllableCounter {
	
	public int countSyllables(String word) {
		int syllables = 0;
		char c = ' ';
		State state = State.START; // Start
		for (int k = 0; k < word.length(); k++) {
			c = word.charAt(k);
			if (c == '\'') continue; //ignore apostrophe
			switch (state) {
				// process character c using state machine
			case START: 
				if (isVowelOrY(c)) {
					state = State.SINGLE_VOWEL;
					syllables++;
				}
				else if (c == 'e' || c == 'E') {
					state = State.E;
					syllables++;
				}
				else if (Character.isLetter(c)) {
					state = State.CONSONANT;
				}
				else state = State.NONWORD;
				break;
				
			case CONSONANT:
				if (isVowelOrY(c)) { 
					state = State.SINGLE_VOWEL;
					syllables++;
				}
				else if (c == 'e' || c == 'E') {
					state = State.E;
					syllables++;
				}
				else if (Character.isLetter(c)) {
					state = State.CONSONANT;
				}
				else if (c == '-') {
					state = State.HYPHEN;
				}
				else state = State.NONWORD;
				break;
				
			case E:
				if (isVowelOrY(c)) {
					if (c == 'y') {
						state = State.CONSONANT;
					}
					else {
						state = State.MULTIVOWEL;
					}
				}
				else if (c == 'e' || c == 'E') {
					state = State.MULTIVOWEL;
				}
				else if (Character.isLetter(c)) {
					state = State.CONSONANT;
				}
				else if (c == '-') {
					state = State.HYPHEN;
				}
				else state = State.NONWORD;
				break;
				
			case SINGLE_VOWEL:
				if (isVowelOrY(c)) {
					if (c == 'y') {
						state = State.CONSONANT;
					}
					else {
						state = State.MULTIVOWEL;
					}
				}
				else if (c == 'e' || c == 'E') {
					state = State.MULTIVOWEL;
				}
				else if (Character.isLetter(c)) {
					state = State.CONSONANT;
				}
				else if (c == '-') {
					state = State.HYPHEN;
				}
				else state = State.NONWORD;
				break;
				
			case MULTIVOWEL:
				if (isVowelOrY(c)) {
					state = State.MULTIVOWEL;
				}
				else if (c == 'e' || c == 'E') {
					state = State.MULTIVOWEL;
				}
				else if (Character.isLetter(c)) {
					state = State.CONSONANT;
				}
				else if (c == '-') {
					state = State.HYPHEN;
				}
				else state = State.NONWORD;
				break;
				
			case HYPHEN:
				if (isVowelOrY(c)) {
					state = State.SINGLE_VOWEL;
					syllables++;
				}
				else if (c == 'e' || c == 'E') {
					state = State.E;
					syllables++;
				}
				else if (Character.isLetter(c)) {
					state = State.CONSONANT;
				}
				else state = State.NONWORD;
				break;
				
			default:
				if (Character.isWhitespace(c))
				break;
			}
		}
		if (state == State.E && syllables > 1) {
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
