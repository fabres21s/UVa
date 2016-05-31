import java.util.Scanner;

/**
*	11547 - Automatic Answer
*
*
*	Submision:	9728806
*	Date:		2012-02-10 15:51:12
*	Runtime:	0.276
*	Ranking:	11805
*/
public class Main11547 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int n;
		int k = input.nextInt();
		while (k > 0) {
			k--;
			n = input.nextInt();
			n *= 63;
			n += 7492;
			n *= 5;
			n -= 498;
			n /= 10;

			System.out.println(Math.abs(n % 10));
		}
		input.close();
	}
}
