import java.math.BigDecimal;
import java.util.Scanner;

/**
*	107 - The Cat in the Hat
*
*
*	Submission:	10297971
*	Date:		2012-07-06 14:54:04
*	Runtime:	2.536
*	Ranking:	4873
*/
public class Main107 {

	/**
	 * - Potencias
	 * - Proceso matem�tico
	 */
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		double h, gt, totalaltura, vagos, n, raizngt, raiznh, x;
		while ((h = input.nextInt()) != 0) {
			gt = input.nextInt();
			if (h == 1 && gt == 1) {
				System.out.println("0 1");
				continue;
			}
			totalaltura = h + gt;
			n = 0;
			raizngt = gt;
			raiznh = h;
			while ((raiznh - raizngt) != 1) {
				n++;
				raiznh = redondear((Math.pow(h, 1 / n)));
				raizngt = redondear((Math.pow(gt, 1 / n)));
			}
			vagos = 1;
			x = raizngt;

			while (raiznh < h) {
				h /= raiznh;
				vagos += raizngt;
				totalaltura += h * raizngt;
				raizngt *= x;
			}
			System.out.println((int) vagos + " " + (int) totalaltura);
		}
		input.close();
	}

	static public double redondear(double valor) {
		BigDecimal aux;
		aux = new BigDecimal(valor);
		aux = aux.setScale(4, BigDecimal.ROUND_HALF_UP);
		valor = aux.doubleValue();
		return valor;
	}
}
