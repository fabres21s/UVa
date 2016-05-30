import java.util.Scanner;

/**
*	11152 - Colourful Flowers
*
*
*	Submision:	16645171
*	Date:		2015-12-29 14:38:17
*	Runtime:	1.392
*	Ranking:	2847
*/
public class Main11152 {

	/**
	 * Matemáticas - Fórmula - Triángulos -Círculos
	 * 
	 * Dadas las medidas de un triángulo, hallar el área del círculo externo,
	 * menos la del tríangulo, y hallar el área del círculo interno al
	 * triángulo, y cuánto le queda al triángulo
	 * 
	 * @param args
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

			// hallamos el área del triángulo
			triangle = Math.sqrt(s * (s - a) * (s - b) * (s - c));

			// hallamos el radio de la circunferencia externa al triángulo
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
