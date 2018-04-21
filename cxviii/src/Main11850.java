import java.util.Arrays;
import java.util.Scanner;

/**
*	11850 - Alaska
*
*
*	Submission:	16288194
*	Date:		2015-10-18 14:35:26
*	Runtime:	0.102
*	Ranking:	1871
*/
public class Main11850 {

	/**
	 * - Simulaci�n
	 */
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int estaciones;
		int arreglo[];
		StringBuffer output = new StringBuffer();
		while (input.hasNext()) {
			estaciones = input.nextInt();
			if (estaciones == 0) {
				break;
			}
			arreglo = new int[estaciones * 2];
			for (int i = 0; i < estaciones; i++) {
				arreglo[i] = input.nextInt();
				arreglo[estaciones * 2 - 1 - i] = 2844 - arreglo[i];
			}
			Arrays.sort(arreglo);
			boolean posible = true;
			for (int i = 0; i < estaciones * 2 - 1; i++) {
				if (Math.abs(arreglo[i] - arreglo[i + 1]) > 200) {
					posible = false;
					break;
				}
			}

			output.append(posible ? "POSSIBLE\n" : "IMPOSSIBLE\n");

		}
		System.out.print(output);
		input.close();
	}

}
