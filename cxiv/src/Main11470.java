import java.util.Scanner;

/**
*	11470 - Square Sums
*
*
*	Submision:	16074008
*	Date:		2015-09-09 20:42:05
*	Runtime:	0.075
*	Ranking:	1986
*/
public class Main11470 {

	/**
	 * - Arreglos
	 */
	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);
		int n = -1, i, j, cases = 0, numbers, sum;
		int arreglo[][];
		StringBuffer buffer;
		while (n != 0) {
			n = input.nextInt();
			if (n > 0) {
				cases++;
				buffer = new StringBuffer();
				buffer.append("Case " + cases + ":");
				arreglo = new int[n][n];
				for (i = 0; i < n; i++) {
					for (j = 0; j < n; j++) {
						arreglo[i][j] = input.nextInt();
					}
				}
				numbers = n % 2 + n / 2;
				// System.out.println("numbers "+numbers);
				for (i = 0; i < numbers; i++) {
					sum = 0;
					for (j = i; j < (n - i); j++) {// sumamos la primera fila
						sum += arreglo[i][j];
						// System.out.print(arreglo[i][j]+" ");
					}
					// System.out.println();
					for (j = i + 1; j < (n - i); j++) {// sumamos la primera
														// columna
						sum += arreglo[j][i];
						// System.out.print(arreglo[j][i]+" * ");
					}
					// System.out.println();

					for (j = i + 1; j < (n - i); j++) {// sumamos la �ltima
														// columna
						sum += arreglo[n - i - 1][j];
						// System.out.print(arreglo[n-1-i][j]+" & ");
					}
					// System.out.println();

					for (j = i + 1; j < (n - i - 1); j++) {
						sum += arreglo[j][n - i - 1];
						// System.out.print(arreglo[j][n-1-i]+" $ ");
					}
					buffer.append(" " + sum);
				}
				System.out.println(buffer);

			}
		}
		input.close();
	}

}
