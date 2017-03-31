import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

public class Main {

	public static void main(String[] args) throws IOException {
		SimpleSyllableCounter sy = new SimpleSyllableCounter();
		final String DICT_URL = "http://se.cpe.ku.ac.th/dictionary.txt";
		URL url = new URL(DICT_URL);
		InputStream input = url.openStream();
		BufferedReader br = new BufferedReader(new InputStreamReader(input));
		int total = 0;
		while(true) {
			String word = br.readLine();
			if (word == null) break;
			total += sy.countSyllables(word);
			
		}
		System.out.println(total);
	}
}
