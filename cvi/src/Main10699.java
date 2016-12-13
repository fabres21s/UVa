import java.util.Scanner;

/**
*	10699 - Count the factors
*
*
*	Submision:	9496989
*	Date:		2011-11-22 20:41:29
*	Runtime:	0.364
*	Ranking:	4439
*/
public class Main10699 {

	static int MX = 1000000;
	static boolean ver[] = new boolean[MX];
	static int list[] = new int[MX];

	/**
	 * - Pregenerados
	 * - Proceso matemático
	 */
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int n, m;
		generar();

		while ((n = input.nextInt()) != 0) {
			m = n;
			if (!ver[n])
				System.out.printf("%d : 1\n", n);
			else
				System.out.printf("%d : %d\n", m, fact(n));
		}
		input.close();

	}

	static void generar() {
		int i, j, k = 0;
		list[k++] = 2;
		for (i = 3; i < MX; i += 2) {
			if (ver[i] == false) {
				list[k++] = i;
				for (j = 3; i * j <= MX; j += 2) {
					ver[i * j] = true;
				}
			}
		}
		for (i = 4; i < MX; i += 2) {
			ver[i] = true;
		}
		list[0] = 2;
		// return k;
	}

	static int fact(int n) {
		int i, cnt = 1, prev = -1;
		int j = 1;
		int t = (int) Math.sqrt(n);
		for (i = list[0]; i <= t; i = list[j++]) {
			while (n % i == 0) {
				if (prev == -1) {
					prev = i;
				}
				if (prev != i)
					cnt++;
				prev = i;
				n /= i;
			}
		}
		if (n > 1)
			cnt++;
		return cnt;
	}
}
