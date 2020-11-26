import java.util.Scanner;

/**
*	10055 - Hashmat the Brave Warrior
*
*
*	Submission:	9483585
*	Date:		2011-11-18 20:12:25
*	Runtime:	2.848
*	Ranking:	56935 / 57604
*/
public class Main10055 {

	/**
	 * - Muy f�cil
	 * 
	 * Hallar el valor absoluto de
	 * la resta de dos n�meros
	 */
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		long a, b;
		while (input.hasNext()) {
			a = input.nextLong();
			b = input.nextLong();
			System.out.println(Math.abs(a - b));
		}
		input.close();
	}
}
