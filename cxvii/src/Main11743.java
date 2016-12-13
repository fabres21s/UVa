import java.util.Scanner;

/**
*	11743 - Credit Check
*
*
*	Submision:	9852876
*	Date:		2012-03-13 12:35:02
*	Runtime:	0.928
*	Ranking:	2802
*/
public class Main11743 {

	/**
	 * - Proceso matemático
	 */
	public static void main(String[] args) {
		int i, k, sum, n, x, y;
		Scanner input = new Scanner(System.in);
		k = input.nextInt();
		while (k > 0) {
			k--;
			sum = 0;
			for (i = 0; i < 4; i++) {
				n = input.nextInt();
				x = (n / 1000) * 2;
				y = ((n / 10) % 10) * 2;
				sum += x % 10 + x / 10 + y % 10 + y / 10 + n % 10 + (n / 100)
						% 10;
			}
			if (sum % 10 == 0)
				System.out.println("Valid");
			else
				System.out.println("Invalid");
		}
		input.close();
	}
}
