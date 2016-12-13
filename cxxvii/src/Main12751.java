import java.util.Scanner;

/**
 * 12751 - An Interesting Game Sumatoria de números Dados números del 1 al n,
 * quitar k números, desde la posición x, encontrar la sumatoria de los
 * restantes
 * 
 * @author fabio
 *
 */

/**
*	12751 - An Interesting Game
*
*
*	Submision:	16911094
*	Date:		2016-02-26 20:43:22
*	Runtime:	0.082
*	Ranking:	573
*/
public class Main12751 {

	/**
	 * - Sumatoria de números
	 */
	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);
		int testCases = input.nextInt();
		for (int i = 1; i <= testCases; i++) {
			int n = input.nextInt();
			int k = input.nextInt();
			int x = input.nextInt();
			System.out.println("Case " + i + ": "
					+ (sumatoria(n) + sumatoria(x - 1) - sumatoria(x + k - 1)));
		}
		input.close();
	}

	private static int sumatoria(int n) {
		return n * (n + 1) / 2;
	}

}
