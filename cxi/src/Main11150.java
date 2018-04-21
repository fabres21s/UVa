import java.util.Scanner;

/**
*	11150 - Cola
*
*
*	Submission:	9728993
*	Date:		2012-02-10 17:03:24
*	Runtime:	0.192
*	Ranking:	7312
*/
public class Main11150 {

	/**
	 * - Simulaci�n
	 */
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int n;
		while (input.hasNext()) {
			n = input.nextInt();
			System.out.println((n + n / 2));
		}
		input.close();
	}
}
