import java.util.Scanner;

/**
*	10550 - Combination Lock
*
*
*	Submision:	17207435
*	Date:		2016-04-15 17:27:56
*	Runtime:	0.130
*	Ranking:	6765
*/
public class Main10550 {

	/**
	 * - Simulación
	 * 
	 * Dado un candado de combinación (3
	 * valores) y una posición inicial encontrar cuantos grados hay que girarlo
	 * para abrir el candado
	 */
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		int a, b, c, d, r;

		while (true) {
			a = input.nextInt();
			b = input.nextInt();
			c = input.nextInt();
			d = input.nextInt();

			if (a == 0 && b == 0)
				break;

			r = 1080 + calc(a, b) + calc(c, b) + calc(c, d);
			System.out.println(r);
		}
		input.close();
	}

	private static int calc(int x, int y) {
		return ((40 + x - y) % 40) * 9;
	}

}
