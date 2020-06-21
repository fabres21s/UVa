import java.io.IOException;
import java.util.Scanner;

/**
*	1260 - Sales
*
*
*	Submission:	25159953
*	Date:		2020-06-21 00:01:31
*	Runtime:	0.370
*	Ranking:	3463 / 3772
*/
public class Main1260 {

	/**
	 * - Validaciones
	 * 
	 * Encontrar cuántos números son menores o iguales a a[n]
	 * en el rango a[0] hasta a[n-1] 
	 */
	public static void main(String[] args) throws NumberFormatException, IOException {

		Scanner input = new Scanner(System.in);
		StringBuilder output = new StringBuilder();
		int testCases = input.nextInt();
		int days;
		while (testCases-- > 0) {

			days = input.nextInt();

			int[] array = new int[days];
			int count = 0;
			for (int i = 0; i < days; i++) {
				array[i] = input.nextInt();
				for (int j = 0; j < i; j++) {
					if (array[j] <= array[i]) {
						count++;
					}
				}
			}

			output.append(count);
			output.append("\n");

		}
		System.out.print(output);

		input.close();
	}

}
