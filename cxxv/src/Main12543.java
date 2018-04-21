import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
*	12543 - Longest Word
*
*
*	Submission:	17131593
*	Date:		2016-04-02 02:19:32
*	Runtime:	0.049
*	Ranking:	728
*/
public class Main12543 {

	/**
	 * - Cadena de caracteres
	 * 
	 * Encontrar la palabra m�s grande de la entrada entiendase por palabra,
	 * caracteres de la a a la z seguidos, incluyendo -
	 */
	//TODO String - Poner categoria
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line;
		int maxSize = 0;
		String maxWord = "", word = "";
		char[] array;
		while ((line = br.readLine()) != null) {
			array = line.toLowerCase().toCharArray();
			word = "";
			for (int c : array) {

				if ((c > 96 && c < 123) || c == 45) {
					word = word + (char) c;
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
