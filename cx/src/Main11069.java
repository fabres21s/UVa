import java.util.Scanner;

/**
*	11069 - A Graph Problem
*
*
*	Submission:	9618260
*	Date:		2012-01-04 19:55:11
*	Runtime:	0.160
*	Ranking:	2137
*/
public class Main11069 {
	static long[] f = new long[80];

	/**
	 * - Pregenerados
	 * - Fibonacci
	 */
	public static void main(String[] args) {
		calcular();
		Scanner input = new Scanner(System.in);
		while (input.hasNext()) {
			System.out.println(f[input.nextInt()]);
		}
		input.close();
	}

	private static void calcular() {
		int i;
		f[1] = 1;
		f[2] = f[3] = 2;
		for (i = 4; i < 80; i++) {
			f[i] = f[i - 2] + f[i - 3];
		}

	}

}
