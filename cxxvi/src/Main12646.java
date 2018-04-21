import java.util.Scanner;

/**
*	12646 - Zero or One
*
*
*	Submission:	16194711
*	Date:		2015-10-01 22:22:27
*	Runtime:	0.066
*	Ranking:	2434
*/
public class Main12646 {

	/**
	 * - Muy f�cil
	 * - Simulaci�n
	 */
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int a, b, c;
		while (input.hasNext()) {

			a = input.nextInt();
			b = input.nextInt();
			c = input.nextInt();

			if (a == b && b == c) {
				System.out.println("*");
			} else if (a != b && b == c) {
				System.out.println("A");
			} else if (b != c && a == c) {
				System.out.println("B");
			} else if (c != b && a == b) {
				System.out.println("C");
			}
		}
		input.close();
	}

}
