//
//public enum State {
//	START,
//	CONSONANT,
//	SINGLE_VOWEL,
//	MULTIVOWEL,
//	HYPHEN,
//	NONWORD,
//	E
//}

abstract class State {
	public abstract void handleChar(char c);
	public void enterState() {};
	public boolean isVowelOrY(char c) {
		String s = c + "";
		if (s.equalsIgnoreCase("a") || s.equalsIgnoreCase("i") || s.equalsIgnoreCase("o") || s.equalsIgnoreCase("u") || s.equalsIgnoreCase("y")) 
			return true;
		else 
			return false;
	}
}
