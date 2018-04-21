import java.util.Scanner;

/**
*	11984 - A Change in Thermal Unit
*
*
*	Submission:	9705427
*	Date:		2012-02-03 14:12:28
*	Runtime:	0.372
*	Ranking:	5932
*/
public class Main11984 {

	/**
	 * - F�rmula
	 */
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		double c;
		int casos = input.nextInt();
		for (int i = 1; i <= casos; i++) {
			c = input.nextDouble();
			c = 9 * c / 5 + 32;
			// System.out.println("   "+c);
			c += input.nextDouble();
			c = 5 * (c - 32) / 9;
			System.out.printf("Case %d: %.2f\n", i, c);
		}
		input.close();
	}
}
