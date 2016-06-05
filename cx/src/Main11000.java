import java.util.Scanner;

/**
*	11000 - Bee
*
*
*	Submision:	9975000
*	Date:		2012-04-09 20:44:05
*	Runtime:	0.128
*	Ranking:	5334
*/
public class Main11000 {

	/**
	 * - Pregenerados
	 * - Fibonacci
	 */
	public static void main(String[] args) {
		long arreglo[] = new long[65];
		arreglo[0] = 1;
		arreglo[1] = 1;
		for (int i = 2; i < 60; i++) {
			arreglo[i] = arreglo[i - 1] + arreglo[i - 2];
		}
		Scanner input = new Scanner(System.in);
		int k;
		while ((k = input.nextInt()) != -1)
			System.out.println((arreglo[k + 1] - 1) + " "
					+ (arreglo[k + 2] - 1));
		input.close();
		//

	}

}
