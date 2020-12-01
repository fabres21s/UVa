import java.math.BigInteger;
import java.util.Scanner;

/**
*	10943 - How do you add?
*
*
*	Submission:	16651124
*	Date:		2015-12-30 21:33:50
*	Runtime:	0.172
*	Ranking:	3875 / 5165
*/
public class Main10943 {

	/**
	 * - Big Numbers
	 * - F�rmula
	 * 
	 * Encontrar de cuantas formas se
	 * puede obtener n, de k valores menores e iguales que n, es decir, para n =
	 * 5 y k = 2, es posible 0+5, 1+4, 2+3, 3+2, 4+1, 5+0, 6 formas, n+1 a
	 * medida que k va aumentando, generalizamos la f�rmula, quedano la
	 * multiplicaci�n de (n/i +1), yendo i desde 1 hasta <k
	 */

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		int n, k;
		while (true) {
			n = input.nextInt();
			k = input.nextInt();

			if (n == k && k == 0) {
				break;
			}

			// ways = 1;
			// d x =1;

			BigInteger mult = BigInteger.ONE;
			BigInteger div = BigInteger.ONE;

			for (int i = 1; i < k; i++) {

				mult = mult.multiply(BigInteger.valueOf(n + i));

				div = div.multiply(BigInteger.valueOf(i));
				// System.out.println(n/i);
				// ways = (ways )*(n + i) / i;
				// ways = Math.floor(ways);
				// System.out.println(ways);
				// ways = Math.rint(ways) ;
				// System.out.println("\t"+ways);

				// ways = ways % 1000000;// 23 64 >> 688576
				// System.out.println(i + "\t"+(int)ways +" \t"+(n/i + 1));
				// ways = x;

			}
			System.out.println(mult.divide(div).mod(
					BigInteger.valueOf(1000 * 1000)));
		}

		input.close();
	}

}
