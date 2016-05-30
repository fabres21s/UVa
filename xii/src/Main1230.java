import java.util.Scanner;

/**
*	1230 - MODEX
*
*
*	Submision:	9732634
*	Date:		2012-02-11 20:10:58
*	Runtime:	0.136
*	Ranking:	1156
*/
public class Main1230 {
	static long x, y, z;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int k = input.nextInt();
		while (k > 0) {
			k--;
			x = input.nextLong();
			y = input.nextLong();
			z = input.nextLong();
			modular(x, y, z);
		}
		// TODO Auto-generated method stub

	}

	private static void modular(long x, long y, long z) {
		long residuos[][] = new long[2][500];
		int i = -1, j;
		do {
			i++;
			residuos[0][i] = (long) Math.pow(2, i);
		} while (residuos[0][i] <= y);
		residuos[1][0] = x % z;
		i = 1;
		while (residuos[0][i] <= y) {
			residuos[1][i] = (residuos[1][i - 1] * residuos[1][i - 1]) % z;
			i++;
		}
		i--;
		if (residuos[0][1] == y) {
			System.out.println(residuos[1][i]);
		}
		y -= residuos[0][i];
		while (y > 0) {
			j = 0;
			while (residuos[0][j] <= y) {
				j++;
			}
			j--;
			i++;
			residuos[0][i] = residuos[0][j] + residuos[0][i - 1];
			residuos[1][i] = (residuos[1][j] * residuos[1][i - 1]) % z;
			y -= residuos[0][j];
		}
		System.out.println(residuos[1][i]);
	}
}
