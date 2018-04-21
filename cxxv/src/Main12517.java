import java.util.Scanner;

/**
*	12517 - Digit Sum
*
*
*	Submission:	16900903
*	Date:		2016-02-25 00:57:49
*	Runtime:	0.348
*	Ranking:	278
*/
public class Main12517 {

	/**
	 * - Recursividad
	 * - Proceso matem�tico
	 * 
	 * Encontrar la sumatoria
	 * de los digitos hasta n
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (true) {

			int a = sc.nextInt();
			int b = sc.nextInt();

			if (a == b && b == 0) {
				break;
			}
			long[] digita = new long[10];
			long[] digitb = new long[10];
			// int a=sc.nextInt();
			a--;

			recurse(digita, 0, 1);
			recurse(digitb, a, 1);
			int i;
			long sum = 0;
			for (i = 1; i < 10; i++) {
				sum -= Math.abs(digitb[i] - digita[i]) * i;
			}
			// System.out.println(sum);

			digita = new long[10];
			digitb = new long[10];

			recurse(digita, 0, 1);
			recurse(digitb, b, 1);
			for (i = 1; i < 10; i++) {
				sum += Math.abs(digitb[i] - digita[i]) * i;
			}
			System.out.println(sum);
		}
		sc.close();
	}

	static void recurse(long[] digit, int n, long count) {
		if (n <= 0)
			return;
		int oneNo = n % 10, tenNo;
		int m = n / 10;
		tenNo = m;
		for (int i = 0; i <= oneNo; i++) {
			digit[i] += count;
		}
		while (tenNo != 0) {
			digit[tenNo % 10] += (oneNo + 1) * count;
			tenNo /= 10;
		}
		for (int i = 0; i < 10; i++) {
			digit[i] += count * m;
		}
		digit[0] -= count;
		recurse(digit, m - 1, 10 * count);
	}
}
