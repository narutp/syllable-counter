
/**
 * Counter that count a syllables from a given word.
 * 
 * @author Narut Poovorakit
 * @version 02.04.2017
 *
 */
public class OOSyllableCounter {

	private final State START = new StartState();
	private final State SINGLEVOWEL = new SingleVowelState();
	private final State MULTIVOWEL = new MultiVowelState();
	private final State CONSONANT = new ConsonantState();
	private final State NONWORD = new NonWordState();
	private final State HYPHEN = new HyphenState();
	private final State E = new EState();

	private State state;
	private int syllables = 0;

	/**
	 * Count a syllables by checking each character
	 * 
	 * @param word
	 *            is a word that given line by line to check the syllables.
	 * @return an amount of the syllable in that word.
	 */
	public int countSyllables(String word) {
		syllables = 0;
		char c = ' ';
		state = START;
		for (int k = 0; k < word.length(); k++) {
			c = word.charAt(k);
			if (c == '\'')
				continue;
			state.handleChar(c);
		}
		if (state == E && syllables > 1) {
			syllables--;
		}
		return syllables;
	}

	/**
	 * A single vowel state class. It will access this class if the character is
	 * a single vowel.
	 *
	 */
	class SingleVowelState extends State {
		@Override
		public void handleChar(char c) {
			if (isVowelOrY(c)) {
				if (c == 'y') {
					setState(CONSONANT);
				} else {
					setState(MULTIVOWEL);
				}
			} else if (c == 'e' || c == 'E') {
				setState(MULTIVOWEL);
			} else if (Character.isLetter(c)) {
				setState(CONSONANT);
			} else if (c == '-') {
				setState(HYPHEN);
			} else
				setState(NONWORD);
		}

		@Override
		public void enterState() {
		}

	}

	/**
	 * A start state class. It will access this class at the beginning of a
	 * word.
	 *
	 */
	class StartState extends State {

		@Override
		public void handleChar(char c) {
			if (isVowelOrY(c)) {
				setState(SINGLEVOWEL);
				enterState();
			} else if (c == 'e' || c == 'E') {
				setState(E);
				enterState();
			} else if (Character.isLetter(c)) {
				setState(CONSONANT);
			} else
				setState(NONWORD);
		}

		@Override
		public void enterState() {
			syllables++;
		}

	}

	/**
	 * A Consonant class. It will access this class only if the character is a
	 * consonant or a letter that not a vowel.
	 *
	 */
	class ConsonantState extends State {
		@Override
		public void handleChar(char c) {
			if (isVowelOrY(c)) {
				setState(SINGLEVOWEL);
				enterState();
			} else if (c == 'e' || c == 'E') {
				setState(E);
				enterState();
			} else if (Character.isLetter(c)) {
				setState(CONSONANT);
			} else if (c == '-') {
				setState(HYPHEN);
			} else
				setState(NONWORD);
		}

		@Override
		public void enterState() {
			syllables++;
		}
	}

	/**
	 * A MultiVowel class. It will access this class if the character is multi
	 * vowel or the before-character is a vowel and the current vowel is also
	 * vowel.
	 *
	 */
	class MultiVowelState extends State {
		@Override
		public void handleChar(char c) {
			if (isVowelOrY(c)) {
				setState(MULTIVOWEL);
			} else if (c == 'e' || c == 'E') {
				setState(MULTIVOWEL);
			} else if (Character.isLetter(c)) {
				setState(CONSONANT);
			} else if (c == '-') {
				setState(HYPHEN);
			} else
				setState(NONWORD);
		}

		@Override
		public void enterState() {
			// Nothing to do.
		}
	}

	/**
	 * A NonWord state class. It will access this class if the character is not
	 * a letter or not a word.
	 *
	 */
	class NonWordState extends State {
		@Override
		public void handleChar(char c) {
		}

		@Override
		public void enterState() {
			// TODO Auto-generated method stub
		}
	}

	/**
	 * A Hyphen state class. It will access this class if the character is a
	 * hyphen or a '-' symbol.
	 *
	 */
	class HyphenState extends State {
		@Override
		public void handleChar(char c) {
			if (isVowelOrY(c)) {
				setState(SINGLEVOWEL);
				enterState();
			} else if (c == 'e' || c == 'E') {
				setState(E);
				enterState();
			} else if (Character.isLetter(c)) {
				setState(CONSONANT);
			} else
				setState(NONWORD);
		}

		@Override
		public void enterState() {
			syllables++;
		}
	}

	/**
	 * An E state class. It will access this class if the character is an 'e'.
	 *
	 */
	class EState extends State {
		@Override
		public void handleChar(char c) {
			if (isVowelOrY(c)) {
				if (c == 'y') {
					setState(CONSONANT);
				} else {
					setState(MULTIVOWEL);
				}
			} else if (c == 'e' || c == 'E') {
				setState(MULTIVOWEL);
			} else if (Character.isLetter(c)) {
				setState(CONSONANT);
			} else if (c == '-') {
				setState(HYPHEN);
			} else
				setState(NONWORD);
		}

		@Override
		public void enterState() {
		}
	}

	/**
	 * Set a new state.
	 * @param newState is a new state.
	 */
	public void setState(State newState) {
		state = newState;
	}
}
