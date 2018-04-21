import java.util.Scanner;

/**
*	11332 - Summing Digits
*
*
*	Submission:	9536246
*	Date:		2011-12-05 17:49:15
*	Runtime:	0.304
*	Ranking:	11557
*/
public class Main11332 {
	static int sum;

	/**
	 * - Recursividad
	 */
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int n;
		while ((n = input.nextInt()) != 0) {
			descomponer(n);
			System.out.println(sum);
		}
		input.close();
	}

	static void descomponer(int n) {
		sum = 0;
		while (n > 0) {
			sum += n % 10;
			n = n / 10;
			// mul*=10;
			// System.out.println(n+"   "+sum);
		}
		if (sum > 9) {
			descomponer(sum);
		}
	}

}
