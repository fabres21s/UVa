import java.util.Scanner;

/**
*	11466 - Largest Prime Divisor
*
*
*	Submision:	9566859
*	Date:		2011-12-16 19:25:43
*	Runtime:	0.304
*	Ranking:	788
*/
public class Main11466 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		long n;
		while ((n = input.nextLong()) != 0)
			factorizacion(n);
		input.close();
	}

	static void factorizacion(long n) {
		n = Math.abs(n);
		long i, ultimo = -1, x = n;
		int cont = 0;
		while ((n % 2) == 0) {
			n = n / 2;
			cont = 1;
		}
		i = 3;
		while (i <= Math.sqrt(n) + 1) {
			if ((n % i) == 0) {
				cont++;
				ultimo = i;
				while (n % i == 0) {
					n = n / i;
				}
			}
			i += 2;
		}
		if (n > 1 && n != x) {
			ultimo = n;
			cont++;
		}
		if (cont < 2) {
			ultimo = -1;
		}
		System.out.println(ultimo);
	}
}
