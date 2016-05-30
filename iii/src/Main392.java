import java.util.Scanner;

/*
 * Armar un polinomio de acuerdo a ciertas reglas
 * negativos, ceros, exponentes...
 */
/**
*	392 - Polynomial Showdown
*
*
*	Submision:	16455798
*	Date:		2015-11-18 16:32:30
*	Runtime:	1.155
*	Ranking:	3572
*/
public class Main392 {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int n;
		while (input.hasNext()) {
			boolean first = true;
			StringBuffer buffer = new StringBuffer();
			for (int i = 0; i < 9; i++) {
				int exp = 8 - i;

				n = input.nextInt();
				int abs = Math.abs(n);
				if (n != 0) {
					if (n < 0) {
						if (first) {
							buffer.append("-");
						} else {
							buffer.append(" - ");
						}

						if (abs != 1) {
							buffer.append(abs);
						}

						if (exp > 1) {
							buffer.append("x^" + exp);
						} else if (exp == 1) {
							buffer.append("x");
						} else if (exp == 0) {
							if (abs == 1) {
								buffer.append(abs);
							}
						}
					} else {
						if (!first) {
							buffer.append(" + ");
						}

						if (abs != 1) {
							buffer.append(abs);
						}
						if (exp > 1) {
							buffer.append("x^" + exp);
						} else if (exp == 1) {
							buffer.append("x");
						} else if (exp == 0) {
							if (abs == 1) {
								buffer.append(abs);
							}
						}
					}

					first = false;
				}
			}
			if (first) {
				System.out.println(0);
			} else {
				System.out.println(buffer);
			}
		}
		input.close();
	}

	/*
	 * x^5 + 22x^4 - 333x^3 + x - 1 -x^8 0 -7x^2 + 30x + 66 x^2 - 3x -x^3 + x^2
	 * + 3x - 1 -5x^8 - 243x^4 - 9 -x^7 - x^6 - x^5 - x^4 - x^3 - x^2 - x - 1
	 * -1999999999x^8 - 978456x^7 + 56x^2 - 89x + 8
	 */
}
