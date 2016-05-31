import java.util.Scanner;

/**
*	160 - Factors and Factorials
*
*
*	Submision:	9709690
*	Date:		2012-02-04 21:09:27
*	Runtime:	0.136
*	Ranking:	8696
*/
public class Main160 {
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[][] numeros = new int[101][101];
		int[] primos = { 2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43,
				47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97 };
		Scanner input = new Scanner(System.in);
		int i, j, aux, n, sum;
		for (i = 2; i < 101; i++) {
			aux = i;
			j = 0;
			while (aux != 1) {
				while (aux % primos[j] == 0) {
					aux /= primos[j];
					numeros[i][primos[j]]++;
				}
				j++;
			}
		}
		while ((n = input.nextInt()) != 0) {
			aux = 0;
			System.out.printf("%3d! =", n);
			for (i = 2; i <= n; i++) {
				sum = 0;
				for (j = 1; j <= n; j++) {
					sum += numeros[j][i];
				}
				if (sum != 0) {
					aux++;
					if (aux == 16) {

						System.out.printf("\n%9d", sum);
					} else {
						System.out.printf("%3d", sum);
					}
				}
			}
			System.out.println();
		}

	}

}
