
/**
 * State class that contain method for checking the character.
 * 
 * @author Narut Poovorakit
 * @version 02.04.2017
 *
 */
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
