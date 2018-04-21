import java.util.Scanner;

/**
*	12643 - Tennis Rounds
*
*
*	Submission:	12353615
*	Date:		2013-09-16 14:41:05
*	Runtime:	0.468
*	Ranking:	489
*/
public class Main12643 {

	/**
	 * - Simulaci�n
	 */
	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);
		int n, j1, j2, potencia;
		while (input.hasNext()) {
			n = input.nextInt();
			j1 = input.nextInt();
			j2 = input.nextInt();
			int aux = Math.min(j1, j2);
			j2 = Math.max(j1, j2);
			j1 = aux;
			potencia = (int) (Math.pow(2, n - 1));
			// ronda=n;
			if (j2 - j1 == 1 && j1 % 2 == 1) {
				System.out.println(1);
				continue;
			}
			while (true) {
				if (j1 < potencia && j2 > potencia) {
					break;
				} else if (j1 > potencia && j2 > potencia) {

					j1 -= potencia;
					j2 -= potencia;
					potencia /= 2;
					n--;

				} else if (j1 < potencia && j2 <= potencia) {
					potencia /= 2;

					n--;
				} else {
					// System.err.println(n);
					break;
				}

				// n--;
			}
			System.out.println(n);
		}

		input.close();

	}

}
