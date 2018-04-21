import java.io.IOException;
import java.util.Scanner;

/**
*	12696 - Cabin Baggage
*
*
*	Submission:	16490277
*	Date:		2015-11-25 15:16:34
*	Runtime:	0.179
*	Ranking:	1134
*/
public class Main12696 {

	/**
	 * - Validaciones
	 * 
	 * Validar tamaño y peso de una maleta que no supere 125cm, excepto con 56,
	 * 45 y 25 - ni 7kg
	 */
	public static void main(String[] args) throws IOException {

		Scanner input = new Scanner(System.in);
		int casos = input.nextInt();
		double x, y, z, w;
		int allows = 0;
		while (casos-- > 0) {
			boolean allowed = true;
			x = input.nextDouble();
			y = input.nextDouble();
			z = input.nextDouble();

			w = input.nextDouble();

			if ((x + y + z) > 125) {
				allowed = false;
			}

			if (x < 57 && y < 46 && z < 26) {
				allowed = true;
			}

			if (w > 7) {
				allowed = false;
			}

			if (allowed) {
				allows++;
			}
			System.out.println(allowed ? "1" : "0");
		}
		System.out.println(allows);

		input.close();
	}

}
