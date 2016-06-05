import java.util.Scanner;

/**
*	948 - Fibonaccimal Base
*
*
*	Submision:	9473844
*	Date:		2011-11-15 13:16:25
*	Runtime:	0.568
*	Ranking:	1732
*/
public class Main948 {

	/**
	 * - Fibonacci
	 */
	public static void main(String[] args) {
		int fibos[] = new int[40];
		fibos[0] = 1;
		fibos[1] = 2;
		for (int i = 2; i < 39; i++) {
			fibos[i] = fibos[i - 1] + fibos[i - 2];
		}
		Scanner input = new Scanner(System.in);
		int k = input.nextInt() + 1, n, j, sum;
		StringBuffer buf;// =new StringBuffer();
		for (int i = 1; i < k; i++) {
			buf = new StringBuffer();
			n = input.nextInt();
			j = 0;
			while (fibos[j] < n) {
				j++;
			}
			sum = 0;
			if (fibos[j] > n) {
				j--;
			}
			while (j != -1) {
				if ((sum + fibos[j]) <= n) {
					sum += fibos[j];
					buf.append(1);
				} else {
					buf.append(0);
				}
				j--;
			}
			System.out.println(n + " = " + buf + " (fib)");
		}
	}
}
