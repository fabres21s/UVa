import java.util.Scanner;

/**
*	11970 - Lucky Numbers
*
*
*	Submision:	9838532
*	Date:		2012-03-09 22:00:58
*	Runtime:	0.612
*	Ranking:	874
*/
public class Main11970 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int i, n, x, k, j;
		int cuadrados[] = new int[31624];
		for (i = 1; i < 31624; i++)
			cuadrados[i] = i * i;
		k = input.nextInt() + 1;
		double div;
		for (i = 1; i < k; i++) {
			n = input.nextInt();
			j = (int) Math.sqrt(n) - 1;
			System.out.printf("Case %d:", i);
			while (j > 0) {
				x = n - cuadrados[j];
				div = x / Math.sqrt(n - x);
				if (div % 1 == 0) {
					System.out.printf(" %d", x);
				}
				j--;
			}
			System.out.println();
		}
		input.close();
		// TODO Auto-generated method stub
	}
}
