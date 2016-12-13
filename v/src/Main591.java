import java.util.Scanner;

/**
*	591 - Box of Bricks
*
*
*	Submision:	9645693
*	Date:		2012-01-14 21:39:23
*	Runtime:	0.252
*	Ranking:	16466
*/
public class Main591 {

	/**
	 * - Simulación
	 */
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int n, cont = 1, total, i, moves;
		while ((n = input.nextInt()) != 0) {
			int arreglo[] = new int[n];
			total = 0;
			for (i = 0; i < n; i++) {
				arreglo[i] = input.nextInt();
				total += arreglo[i];
			}
			total /= n;
			moves = 0;
			for (i = 0; i < n; i++) {
				if (arreglo[i] > total) {
					moves += (arreglo[i] - total);
				}
			}
			System.out.printf(
					"Set #%d\nThe minimum number of moves is %d.\n\n", cont,
					moves);
			cont++;
		}
		input.close();
	}
}
