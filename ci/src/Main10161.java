import java.util.Scanner;

/**
*	10161 - Ant on a Chessboard
*
*
*	Submision:	9678547
*	Date:		2012-01-26 14:38:21
*	Runtime:	0.008
*	Ranking:	3744
*/
public class Main10161 {

	/**
	 * - Simulación
	 */
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int aux, n, cuadrado, diagonal;
		while ((n = input.nextInt()) != 0) {
			aux = (int) Math.sqrt(n);
			if (aux * aux == n) {
				if (aux % 2 == 0) {
					System.out.printf("%d 1\n", aux);
				} else {
					System.out.printf("1 %d\n", aux);
				}
				continue;
			}
			aux++;
			cuadrado = aux * aux;
			diagonal = cuadrado - aux + 1;
			if (n == diagonal) {
				System.out.printf("%d %d\n", aux, aux);
				continue;
			}
			if (aux % 2 == 0) {
				if (n > diagonal) {
					System.out.printf("%d %d\n", aux, (aux + diagonal - n));
				} else {
					System.out.printf("%d %d\n", (n + aux - diagonal), aux);
				}
			} else {
				if (n > diagonal) {
					System.out.printf("%d %d\n", (aux + diagonal - n), aux);
				} else {
					System.out.printf("%d %d\n", aux, (n + aux - diagonal));
				}
			}
		}
		input.close();
	}
}
