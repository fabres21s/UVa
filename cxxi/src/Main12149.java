import java.util.Scanner;

/**
*	12149 - Feynman
*
*
*	Submission:	9544674
*	Date:		2011-12-08 21:41:32
*	Runtime:	0.176
*	Ranking:	4373
*/
public class Main12149 {

	/**
	 * - Pregenerados
	 * - Proceso matem�tico
	 */
	public static void main(String[] args) {
		int[] cuadrados = { 0, 1, 5, 14, 30, 55, 91, 140, 204, 285, 385, 506,
				650, 819, 1015, 1240, 1496, 1785, 2109, 2470, 2870, 3311, 3795,
				4324, 4900, 5525, 6201, 6930, 7714, 8555, 9455, 10416, 11440,
				12529, 13685, 14910, 16206, 17575, 19019, 20540, 22140, 23821,
				25585, 27434, 29370, 31395, 33511, 35720, 38024, 40425, 42925,
				45526, 48230, 51039, 53955, 56980, 60116, 63365, 66729, 70210,
				73810, 77531, 81375, 85344, 89440, 93665, 98021, 102510,
				107134, 111895, 116795, 121836, 127020, 132349, 137825, 143450,
				149226, 155155, 161239, 167480, 173880, 180441, 187165, 194054,
				201110, 208335, 215731, 223300, 231044, 238965, 247065, 255346,
				263810, 272459, 281295, 290320, 299536, 308945, 318549, 328350,
				338350, 348551 };
		int n;
		Scanner input = new Scanner(System.in);
		while ((n = input.nextInt()) != 0) {
			System.out.println(cuadrados[n]);
		}
		input.close();

	}

}
