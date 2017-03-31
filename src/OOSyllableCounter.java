
public class OOSyllableCounter {

	private final State START = new StartState();
	private final State SINGLEVOWEL = new SingleVowelState();
	private final State MULTIVOWEL = new MultiVowelState();
	private final State CONSONANT = new ConsonantState();
	private final State NONWORD = new NonWordState();
	private final State HYPHEN = new HyphenState();

	private State state = START;
	private int syllables = 0;

	public int countSyllables(String word) {
		char c = ' ';
		for (int k = 0; k < word.length(); k++) {

		}
	}

	public void setState(State newState) {
		if (newState != state)
			newState.enterState();
		state = newState;
	}

	// SingleVowel
	class SingleVowelState extends State {

		@Override
		public void handleChar(char c) {

			if (isVowelOrY(c))
				setState(MULTIVOWEL);
		}

		@Override
		public void enterState() {
			// TODO Auto-generated method stub

		}

	}

	class StartState extends State {

		@Override
		public void handleChar(char c) {
			// TODO Auto-generated method stub

		}

		@Override
		public void enterState() {
			// TODO Auto-generated method stub

		}

	}

	class ConsonantState extends State {
		@Override
		public void handleChar(char c) {
			// TODO Auto-generated method stub

		}

		@Override
		public void enterState() {
			// TODO Auto-generated method stub

		}
	}
	
	class MultiVowelState extends State {
		@Override
		public void handleChar(char c) {
			// TODO Auto-generated method stub

		}

		@Override
		public void enterState() {
			// TODO Auto-generated method stub

		}
	}
	
	class NonWord extends State {
		@Override
		public void handleChar(char c) {
			// TODO Auto-generated method stub

		}

		@Override
		public void enterState() {
			// TODO Auto-generated method stub

		}
	}
	
	class HyphenState extends State {
		@Override
		public void handleChar(char c) {
			// TODO Auto-generated method stub

		}

		@Override
		public void enterState() {
			// TODO Auto-generated method stub

		}
	}
}
