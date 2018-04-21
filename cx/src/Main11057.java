import java.util.Arrays;
import java.util.Scanner;

/**
*	11057 - Exact Sum
*
*
*	Submission:	16499984
*	Date:		2015-11-27 11:59:44
*	Runtime:	0.469
*	Ranking:	3259
*/
public class Main11057 {

	/**
	 * - Simulaci�n
	 * - Sort
	 * 
	 * De una lista de n�meros y un target, encontrar la menor diferencia oara
	 * llegar al target
	 */
	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);

		int array[];
		int n, price, i;
		while (input.hasNext()) {
			n = input.nextInt();

			array = new int[n];

			for (i = 0; i < n; i++) {
				array[i] = input.nextInt();
			}

			price = input.nextInt();

			int min = price;
			int value = -1;
			int dif, pos;
			Arrays.sort(array);
			for (i = 0; i < n; i++) {

				dif = price - array[i];
				pos = Arrays.binarySearch(array, dif);
				if (pos > -1 && pos != i) {
					dif = Math.abs(array[i] - array[pos]);
					if (dif < min) {
						min = dif;
						value = array[i];
					}
				}

			}

			System.out.println("Peter should buy books whose prices are "
					+ (value) + " and " + (price - value) + ".\n");
		}
		input.close();
	}

}
