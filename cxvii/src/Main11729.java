import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

/**
*	11729 - Commando War
*
*	Submission:	22591268
*	Date:		2019-01-10 14:54:08
*	Runtime:	0.480
*	Ranking:	3088
*/
public class Main11729 {

	
	/**
	 * - Simulación 
	 * - Arreglos
	 * 
	 *  Una persona se demora un tiempo t1 en dar una orden a otra persona
	 *  que demora un tiempo t2 en ejecutar esa orden
	 *  Encontrar el mínimo tiempo para dar y ejecutar todas las órdenes 
	 */
	public static void main(String[] args) throws IOException {

		Scanner input = new Scanner(System.in);
		StringBuffer output = new StringBuffer();

		int soldiers, testCases = 0;

		while ((soldiers = input.nextInt()) != 0) {
			testCases++;
			int array[][] = new int[soldiers][2];
			for (int i = 0; i < soldiers; i++) {
				array[i][0] = input.nextInt();
				array[i][1] = input.nextInt();
			}

			Arrays.sort(array, (a, b) -> Double.compare(b[1], a[1]));

			int timeCommando = 0, timeExecution = 0;

			for (int i = 0; i < soldiers; i++) {
				timeCommando += array[i][0];
				timeExecution = Math.max(timeExecution, timeCommando + array[i][1]);
			}

			output.append(String.format("Case %d: %d\n", testCases, timeExecution));
		}
		input.close();
		System.out.print(output);

	}

}
