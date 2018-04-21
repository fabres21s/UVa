import java.util.Scanner;

/**
*	11152 - Colourful Flowers
*
*
*	Submission:	16645171
*	Date:		2015-12-29 14:38:17
*	Runtime:	1.392
*	Ranking:	2847
*/
public class Main11152 {

	/**
	 * - C�rculos
	 * - Tri�ngulos
	 * - F�rmula
	 * 
	 * Dadas las medidas de un tri�ngulo, hallar el �rea del c�rculo externo,
	 * menos la del tr�angulo, y hallar el �rea del c�rculo interno al
	 * tri�ngulo, y cu�nto le queda al tri�ngulo
	 */
	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);

		double a, b, c, s, triangle, r1, r2;
		double circum, inscribed;
		while (input.hasNext()) {

			a = input.nextDouble();
			b = input.nextDouble();
			c = input.nextDouble();

			s = (a + b + c) / 2;

			// hallamos el �rea del tri�ngulo
			triangle = Math.sqrt(s * (s - a) * (s - b) * (s - c));

			// hallamos el radio de la circunferencia externa al tri�ngulo
			r1 = ((a * b * c) / Math.sqrt((a + b + c) * (b + c - a)
					* (c + a - b) * (a + b - c)));

			// hallamos el radio de la circunferencia interna
			r2 = triangle / s;

			circum = Math.PI * Math.pow(r1, 2) - triangle;
			inscribed = Math.PI * Math.pow(r2, 2);
			triangle = triangle - inscribed;

			System.out.printf("%.4f %.4f %.4f\n", circum, triangle, inscribed);
		}

		input.close();
	}

}
