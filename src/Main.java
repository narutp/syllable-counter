import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Main class that run the OOSyllable counter that count a dictionary.
 * 
 * @author Narut Poovorakit
 * @version 02.04.2017
 *
 */
public class Main {

	public static void main(String[] args) throws IOException {
		SimpleSyllableCounter sy = new SimpleSyllableCounter();
		OOSyllableCounter osy = new OOSyllableCounter();
		
		final String DICT_URL = "http://se.cpe.ku.ac.th/dictionary.txt";
		URL url = new URL(DICT_URL);
		InputStream input = url.openStream();
		BufferedReader br = new BufferedReader(new InputStreamReader(input));
		int ooTotal = 0;
		int simpleTotal = 0;
		
		while (true) {
			String word = br.readLine();
			if (word == null)
				break;
			ooTotal += osy.countSyllables(word);
			simpleTotal += sy.countSyllables(word);
		}
		
		System.out.println("Simple syllable counter : " + simpleTotal);
		System.out.println("OOSyllable counter : " + ooTotal);
	}
}
