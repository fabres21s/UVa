import java.util.Scanner;

/**
*	11078 - Open Credit System
*
*
*	Submision:	9673564
*	Date:		2012-01-25 00:58:24
*	Runtime:	1.452
*	Ranking:	1884
*/
public class Main11078 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int i, n, diff, N, max, T = input.nextInt();
		while (T > 0) {
			T--;
			N = input.nextInt();
			diff = -1600;
			max = input.nextInt();
			for (i = 1; i < N; i++) {
				n = input.nextInt();
				diff = Math.max(diff, (max - n));
				max = Math.max(max, n);
			}
			System.out.println(diff);
		}
		input.close();
		// TODO Auto-generated method stub

	}

}
