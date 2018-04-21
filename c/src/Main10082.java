import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
*	10082 - WERTYU
*
*
*	Submission:	9178991
*	Date:		2011-08-22 03:04:42
*	Runtime:	0.244
*	Ranking:	17443
*/
public class Main10082 {

	/**
	 * - Cadena de caracteres
	 */
	//TODO String - Poner categoria
	public static void main(String[] args) throws IOException {
		String abc = "`1234567890-=QWERTYUIOP[]\\ASDFGHJKL;'ZXCVBNM,./";
		final BufferedReader reader = new BufferedReader(new InputStreamReader(
				System.in));
		String linea, frase = "";
		String[] tokens;
		while ((linea = reader.readLine()) != null) {
			frase = "";
			tokens = linea.split("");
			for (int i = 1; i < tokens.length; i++) {
				if (tokens[i].equals(" ")) {
					frase += " ";
				} else {
					frase += abc.charAt(abc.indexOf(tokens[i]) - 1);
				}
			}
			System.out.println(frase);
		}
	}
}
