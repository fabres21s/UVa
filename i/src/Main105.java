import java.util.Scanner;

/**
 * 105 - The Skyline Problem
 * Simulación - Arreglos
 * Analizar las alturas máximas de cada edificio
 * Recibí un poco de ayuda
 * @author fabio
 *
 */

/**
*	105 - The Skyline Problem
*
*
*	Submision:	16945389
*	Date:		2016-03-03 22:31:58
*	Runtime:	0.189
*	Ranking:	6559
*/
public class Main105 {

	/**
	 * - Simulación
	 * - Arreglos
	 */
	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);
		int buildings[] = new int[10005];
		int triples = 0;
		int maxRight = 0;
		while (input.hasNext()) {
			int left = input.nextInt();
			int height = input.nextInt();
			int right = input.nextInt();

			maxRight = Math.max(right, maxRight);

			for (int i = left; i < right; i++) {
				buildings[i] = Math.max(buildings[i], height);
			}
		}
		analize(buildings, maxRight);
	}

	private static void analize(int[] buildings, int right) {
		int height = 0;
		StringBuffer buffer = new StringBuffer();
		for (int i = 0; i <= right; i++) {
			if (buildings[i] != height) {
				buffer.append((i) + " " + buildings[i] + " ");
				height = buildings[i];

			}
		}
		System.out.println(buffer.toString().trim());
	}

}

/*
 * 
 * 1 11 5 2 6 7 3 13 9 12 7 16 14 3 25 19 18 22 23 13 29 24 4 28
 */
