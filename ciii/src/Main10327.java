import java.util.Scanner;

/**
*	10327 - Flip Sort
*
*
*	Submission:	9618688
*	Date:		2012-01-05 00:30:30
*	Runtime:	0.680
*	Ranking:	12697 / 13781
*/
public class Main10327 {

	/**
	 * - Simulaci�n
	 */
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int n, s, i, j;
		while (input.hasNext()) {
			s = 0;
			n = input.nextInt();
			long[] arreglo = new long[n];
			for (i = 0; i < n; i++) {
				arreglo[i] = input.nextLong();
			}
			for (i = 0; i < n - 1; i++) {
				for (j = i + 1; j < n; j++) {

					if (arreglo[i] > arreglo[j]) {
						// System.out.println(arreglo[i]+" "+arreglo[j]);
						s++;
					}
				}
			}
			System.out.println("Minimum exchange operations : " + s);
		}
		input.close();
	}
}
