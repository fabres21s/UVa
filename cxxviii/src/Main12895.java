import java.util.Scanner;

/**
 * 12895 - Armstrong Number Dado un número, encontrar si la sumatoria de cada
 * dígito, elevado a la potencia cantidad de digitos, es igual alnúmero original
 * ej 153 1^3 +5^3 +3^3 = 152 Arreglos, potencias
 *
 */
/**
*	12895 - Armstrong Number
*
*
*	Submision:	17423901
*	Date:		2016-05-27 00:18:21
*	Runtime:	0.060
*	Ranking:	690
*/
public class Main12895 {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int testCases = input.nextInt();

		for (int i = 0; i < testCases; i++) {
			boolean armstrong = false;

			long original = input.nextLong();

			int digits = (int) Math.log10(original) + 1;

			int[] arrayDigits = new int[digits];

			int n = (int) original;
			for (int x = 0; x < digits; x++) {
				arrayDigits[x] = n % 10;
				n /= 10;
			}

			int sum = 0;
			for (int x = 0; x < digits; x++) {
				sum += Math.pow(arrayDigits[x], digits);
			}
			// System.out.println("sum = "+sum);
			if (sum == original) {
				armstrong = true;
			}

			if (armstrong) {
				System.out.println("Armstrong");
			} else {
				System.out.println("Not Armstrong");
			}

		}
	}

}
