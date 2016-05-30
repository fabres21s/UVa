import java.util.Scanner;

/**
*	674 - Coin Change
*
*
*	Submision:	9714723
*	Date:		2012-02-06 13:16:38
*	Runtime:	2.472
*	Ranking:	9308
*/
public class Main674 {
	static int MAX = 7489;
	static long[] ss = new long[MAX + 2];
	static int D[] = { 50, 25, 10, 5, 1 };

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int x;
		// int d;
		dynamic();
		while (input.hasNext()) {
			x = input.nextInt();

			System.out.printf("%d\n", ss[x]);
		}
		// TODO Auto-generated method stub

	}

	static void dynamic() {
		int i, j;
		ss[0] = 1;
		for (i = 0; i < 5; i++) {
			for (j = D[i]; j <= MAX; j++) {
				ss[j] += ss[j - D[i]];
			}
		}
	}
}
