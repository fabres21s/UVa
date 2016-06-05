import java.util.Scanner;

/**
*	10300 - Ecological Premium
*
*
*	Submision:	9483931
*	Date:		2011-11-19 00:24:32
*	Runtime:	0.176
*	Ranking:	20476
*/
public class Main10300 {

	/**
	 * - Muy fácil
	 */
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int k = input.nextInt(), f, j;
		long sum, a, c;
		for (int i = 0; i < k; i++) {
			f = input.nextInt();
			sum = 0;
			for (j = 0; j < f; j++) {
				a = input.nextLong();
				c = input.nextLong();
				sum += a * c;
			}
			System.out.println(sum);
		}
		input.close();
	}
}
