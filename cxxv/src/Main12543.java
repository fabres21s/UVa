import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main {

	/**
	 *12543 - Longest Word
	 *
	 *Cadena de Caracteres
	 *
	 *Encontrar la palabra más grande de la entrada
	 *entiendase por palabra, caracteres de la a a la z seguidos, incluyendo -
	 * 
	 */
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line;
		int maxSize = 0;
		String maxWord = "", word = "";
		char [] array;
		while ((line = br.readLine()) != null) {
			array = line.toLowerCase().toCharArray();
			word = "";
			for (int c : array) {
				
				if ( (c > 96 && c < 123) || c == 45 ) {
					word = word + (char)c;
				} else {
					if (word.length() > maxSize) {
						maxSize = word.length();
						  maxWord = word;
					}
					word = "";
				}
			}
			if (line.endsWith("E-N-D")) {
				break;
			}
		}
		System.out.println(maxWord);
	}

}
