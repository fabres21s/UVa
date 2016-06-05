import java.util.Scanner;

/**
*	10222 - Decode the Mad man
*
*
*	Submision:	9857458
*	Date:		2012-03-14 12:04:07
*	Runtime:	0.204
*	Ranking:	7862
*/
public class Main10222 {

	/**
	 * - Cadena de caracteres
	 */
	public static void main(String[] args) {
		String abc = "`1234567890-=qwertyuiop[]\\asdfghjkl;'zxcvbnm,./";
		abc = abc.toLowerCase();
		Scanner input = new Scanner(System.in);
		String frase = "";
		String[] tokens;
		while (input.hasNext()) {
			frase = "";
			tokens = input.nextLine().toLowerCase().split("");
			for (int i = 1; i < tokens.length; i++) {
				if (tokens[i].equals(" ")) {
					frase += " ";
				} else {
					frase += abc.charAt(abc.indexOf(tokens[i]) - 2);
				}
			}
			System.out.println(frase);
		}
		input.close();
	}
}
