import java.util.Scanner;

/**
*	12463 - Little Nephew
*
*
*	Submision:	10645850
*	Date:		2012-09-24 12:27:46
*	Runtime:	0.180
*	Ranking:	612
*/
public class Main12463 {

	/**
	 * - Estadística
	 */
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		while (true) {

			int a = 0;

			int res = 1;

			boolean z = false;
			while (a < 5) {
				int valor = input.nextInt();
				if (valor == 0) {
					z = true;
					break;
				}
				if (a > 2) {
					// res = res*(valor*valor);
					if (valor == 1) {
						res = res * valor;
					} else {
						res = res * (valor * valor);
					}

				} else {

					res = res * valor;
				}

				a++;

			}
			if (z)
				break;

			System.out.println(res);
		}


	}

}
