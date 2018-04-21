import java.util.Scanner;

/**
*	568 - Just the Facts
*
*
*	Submission:	10097433
*	Date:		2012-05-10 16:23:50
*	Runtime:	0.136
*	Ranking:	5591
*/
public class Main568 {

	/**
	 * - Pregenerados
	 * - Factorial
	 */
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int facts[] = new int[10002];
		facts[0] = 1;
		facts[1] = 1;
		int f = 1;
		for (int i = 2; i <= 10001; i++) {
			f *= i;
			// System.out.print(facts[i]);
			while (f % 10 == 0)
				f /= 10;
			f %= 100000;
			facts[i] = f % 10;
		}
		while (input.hasNext()) {
			f = input.nextInt();
			System.out.printf("%5d -> %d\n", f, facts[f]);
		}
		input.close();
	}

}
