import java.util.Scanner;

/*
1709 - Amalgamated Artichokes
-Proceso matemático
Dada una fórmula, encontrar su pico y la máxima diferencia con el punto más bajo

*/

/**
*	1709 - Amalgamated Artichokes
*
*
*	Submision:	16999712
*	Date:		2016-03-12 03:03:39
*	Runtime:	3.579
*	Ranking:	171
*	
*	C++ Resolved, in Java TLE
*/
public class Main1709 {

	/**
	 * - Proceso matemático
	 */
	public static void main(String[] args) {
		// 42 1 23 4 8 10
		// 100 432 406 867 60 1000
		// 100 7 615 998 801 3
		// p a b c d n
		// price(k) = p(sin(ak + b) + cos(ck + d) +2)
		
		//casi que seguro un TLE

		int p = 100, a = 7, b = 615, c = 998, d = 801, n = 3;
		
		double difMayor = 0, price = 0;
		double precioMinimo;
		double precioMaximo;
		Scanner input = new Scanner(System.in);
		while (input.hasNext()) {
			p = input.nextInt();
			a = input.nextInt();
			b = input.nextInt();
			c = input.nextInt();
			d = input.nextInt();
			n = input.nextInt();
			 precioMaximo = precioMinimo = p
					* (Math.sin(a + b) + Math.cos(c + d) + 2);

			for (int k = 2; k <= n; k++) {
				price = p * (Math.sin(a * k + b) + Math.cos(c * k + d) + 2);

				if (price < precioMinimo) {
					difMayor = Math.max(difMayor, (precioMaximo - price));
					precioMinimo = price;

				} else if (price >= precioMaximo) {
					precioMinimo = precioMaximo = price;
				}

			}
			System.out.printf("%.6f\n",difMayor);
		}
		input.close();
	}

}
