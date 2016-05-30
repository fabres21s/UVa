import java.util.Scanner;

/**
*	10323 - Factorial! You Must be Kidding!!!
*
*
*	Submision:	9567278
*	Date:		2011-12-16 22:49:56
*	Runtime:	2.876
*	Ranking:	6159
*/
public class Main10323 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		long n = 1;
		long[] fact = new long[15];
		for (int i = 2; i <= 13; i++) {
			n = n * i;
			fact[i] = n;
		}
		int i;
		while (input.hasNext()) {
			i = input.nextInt();
			if (i < 0) {
				if (i % 2 == 0) {
					System.out.println("Underflow!");
				} else {
					System.out.println("Overflow!");
				}
				continue;
			}
			if (i > 13) {
				System.out.println("Overflow!");
			} else if (i < 8) {
				System.out.println("Underflow!");
			} else {
				System.out.println(fact[i]);
			}
		}
		input.close();
		// TODO Auto-generated method stub
	}
}
