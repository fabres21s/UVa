import java.util.Scanner;

/**
*	11716 - Digital Fortress
*
*
*	Submision:	16379117
*	Date:		2015-11-03 14:19:07
*	Runtime:	0.176
*	Ranking:	3045
*/
public class Main11716 {

	/**
	 * - Cadena de caracteres
	 */
	//TODO String - Poner categoria
	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);
		int cases = Integer.valueOf(input.nextLine());
		String word;
		int n, x, j, i;
		char arreglo[];
		StringBuffer response = new StringBuffer();
		while (cases-- > 0) {
			word = input.nextLine();
			n = word.length();
			x = (int) Math.sqrt(n);

			if (x * x == n) {
				arreglo = word.toCharArray();
				for (i = 0; i < x; i++) {
					for (j = i; j < n; j += x) {
						response.append(arreglo[j]);
					}
				}
			} else {
				response.append("INVALID");
			}
			response.append("\n");
		}
		System.out.print(response);
		input.close();
	}

}
