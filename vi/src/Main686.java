import java.util.Scanner;

/**
*	686 - Goldbach's Conjecture (II)
*
*
*	Submision:	9435575
*	Date:		2011-11-02 19:56:24
*	Runtime:	0.312
*	Ranking:	6130
*/
public class Main686 {
	static int[] primos = new int[3513];

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		generar();
		Scanner input = new Scanner(System.in);
		int n, cont;
		while ((n = input.nextInt()) != 0) {
			cont = 0;
			for (int i = 0; primos[i] <= (n) / 2; i++) {
				if (esta(n - primos[i])) {
					cont++;
				}
			}
			System.out.println(cont);
		}
		// TODO Auto-generated method stub

	}

	static boolean esta(int valor) {
		for (int i = 0; i < 3513; i++) {
			if (primos[i] == valor) {
				return true;
			}
		}
		return false;
	}

	static void generar() {
		int n = 32768;
		int i, c = 2, aux;
		int j;

		primos[0] = 2;
		for (i = 3; i <= n; i += 2) {
			j = 3;
			aux = 1;
			while (i % j != 0 && j <= i / j) {
				j = primos[aux];
				aux++;
			}

			if (j > i / j) {
				primos[c - 1] = i;
				c++;
			}

		}
	}

}
