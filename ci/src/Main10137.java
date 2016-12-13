import java.util.Scanner;

/**
*	10137 - The Trip
*
*
*	Submision:	9215650
*	Date:		2011-09-02 17:36:29
*	Runtime:	0.912
*	Ranking:	7033
*/
public class Main10137 {

	/**
	 * - Simulación
	 */
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int a, i;
		double total, prom, dif1, dif2;
		long t;
		while (true) {
			a = input.nextInt();
			if (a == 0) {
				break;
			}
			double[] valores = new double[a];
			total = 0;
			for (i = 0; i < a; i++) {
				valores[i] = input.nextDouble();
				total += valores[i];
			}
			prom = total / a;
			t = Math.round(prom * 100);
			prom = (double) t / 100;
			dif1 = 0;
			dif2 = 0;
			for (i = 0; i < a; i++) {
				if (valores[i] > prom) {
					dif1 += valores[i] - prom;
				} else {
					dif2 += prom - valores[i];
				}
			}
			System.out.printf("$%.2f\n", Math.min(dif1, dif2));
		}
		input.close();
	}
}
