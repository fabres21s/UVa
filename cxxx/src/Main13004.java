import java.util.Scanner;

/**
 * 13004 - At most twice
 * Arreglos, Recursividad
 * Dado n, encontrar un número <= n
 * que no tenga los digitos más de dos veces
 */

/**
*	13004 - At most twice
*
*
*	Submision:	17017593
*	Date:		2016-03-14 20:08:44	
*	Runtime:	0.082
*	Ranking:	112
*/
public class Main13004 {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		while (input.hasNext()) {

			Long n = input.nextLong();

			int size = n.toString().length();
			int index = size;
			int arreglo[] = new int[size];

			while (n > 0) {
				index--;
				arreglo[index] = (int) (n % 10);
				n /= 10;
			}

			evaluate(arreglo, size);
		}
	}

	private static void evaluate(int[] arreglo, int size) {

		int[] digits = new int[10];
		boolean twice = true;
		int i = 0;
		for (i = 0; i < size; i++) {
			digits[arreglo[i]]++;

			if (digits[arreglo[i]] > 2) {
				twice = false;

				break;
			}
		}

		if (!twice) {
			for (int j = i; j > -1; j--) {
				if (arreglo[j] > 0) {
					arreglo[j]--;
					digits[arreglo[j]]--;
					break;
				} else {
					arreglo[j] = 9;
					digits[9]++;
				}
			}

			int r = 9;
			for (int j = i + 1; j < size; j++) {
				arreglo[j] = r;
				digits[r]++;

			}
		}

		if (twice) {
			long n = 0L;
			// long mult =1;
			for (i = 0; i < size; i++) {
				n = n * 10 + arreglo[i];
			}
			System.out.println(n);
		} else {

			evaluate(arreglo, size);
		}
	}

}
