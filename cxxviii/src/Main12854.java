import java.util.Scanner;

/**
*	12854 - Automated Checking Machine
*
*
*	Submision:	16194798
*	Date:		2015-10-01 23:01:31
*	Runtime:	0.086
*	Ranking:	705
*/
public class Main12854 {

	/**
	 * - Simulación
	 */
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int[] arregloX = new int[5];
		int[] arregloY = new int[5];
		boolean answer;
		while (input.hasNext()) {
			answer = true;
			for (int i = 0; i < arregloX.length; i++) {
				arregloX[i] = input.nextInt();
			}

			for (int i = 0; i < arregloX.length; i++) {
				arregloY[i] = input.nextInt();

				answer = answer && (arregloX[i] != arregloY[i]);
			}

			System.out.println(answer ? "Y" : "N");
		}
		input.close();
	}

}
