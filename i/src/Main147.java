import java.util.Scanner;

/**
*	147 - Dollars
*
*
*	Submision:	9581890
*	Date:		2011-12-21 20:05:07
*	Runtime:	1.828
*	Ranking:	6625
*/
public class Main147 {
	static int MAX = 30000;
	static long[] ss = new long[MAX + 2];
	static int D[] = { 10000, 5000, 2000, 1000, 500, 200, 100, 50, 20, 10, 5 };

	/**
	 * TODO Asignar Categoría!!!
	 */
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		double x;
		int d;
		dynamic();
		while (input.hasNext()) {
			x = input.nextDouble();
			d = (int) (x * 100 + 1E-5);
			if (d == 0) {
				break;
			}
			System.out.printf("%6.2f%17d\n", x, ss[d]);
		}

	}

	static void dynamic() {
		int i, j;
		ss[0] = 1;
		for (i = 0; i < 11; i++) {
			for (j = D[i]; j <= MAX; j++) {
				ss[j] += ss[j - D[i]];
			}
		}
	}
}
