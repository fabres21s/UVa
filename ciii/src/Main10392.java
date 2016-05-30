import java.util.Scanner;

/**
*	10392 - Factoring Large Numbers
*
*
*	Submision:	9530767
*	Date:		2011-12-03 20:04:52
*	Runtime:	0.188
*	Ranking:	1351
*/
public class Main10392 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		long n, i;
		while ((n = input.nextLong()) != -1) {
			while ((n % 2) == 0) {
				System.out.println("    " + 2);
				n = n / 2;
			}
			i = 3;
			while (i <= Math.sqrt(n) + 1) {
				if ((n % i) == 0) {
					System.out.println("    " + i);
					n = n / i;
				} else {
					i += 2;
				}

			}
			if (n > 1) {
				System.out.println("    " + n);
			}
			System.out.println();
		}
		input.close();
		// TODO Auto-generated method stub
	}
}
