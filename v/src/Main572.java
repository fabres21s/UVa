import java.util.Scanner;

/**
*	572 - Oil Deposits
*
*
*	Submision:	9886993
*	Date:		2012-03-20 14:35:30
*	Runtime:	0.324
*	Ranking:	9055
*/
public class Main572 {
	static int cont;
	static String oil[][];

	/**
	 * - Recursividad
	 */
	public static void main(String[] args) {
		int m, n, i, j;
		Scanner input = new Scanner(System.in);
		while (input.hasNext()) {
			m = input.nextInt();
			n = input.nextInt();
			if (m == 0 && n == 0)
				break;
			cont = 0;
			oil = new String[m + 2][n + 2];
			inicializar();
			for (i = 1; i <= m; i++) {
				args = input.next().split("");
				for (j = 1; j <= n; j++) {
					oil[i][j] = args[j];
				}
			}
			for (i = 1; i <= m; i++) {
				for (j = 1; j <= n; j++) {
					if (oil[i][j].equals("@")) {
						cont++;
						recursividad(i, j);
					}
				}
			}
			System.out.println(cont);
		}
		input.close();

	}

	private static void inicializar() {
		for (int i = 0; i < oil.length; i++) {
			for (int j = 0; j < oil[0].length; j++)
				oil[i][j] = "";
		}

	}

	private static void recursividad(int i, int j) {
		oil[i][j] += cont;
		if (oil[i - 1][j - 1].equals("@"))
			recursividad(i - 1, j - 1);
		if (oil[i - 1][j].equals("@"))
			recursividad(i - 1, j);
		if (oil[i - 1][j + 1].equals("@"))
			recursividad(i - 1, j + 1);
		if (oil[i][j - 1].equals("@"))
			recursividad(i, j - 1);
		if (oil[i][j + 1].equals("@"))
			recursividad(i, j + 1);
		if (oil[i + 1][j - 1].equals("@"))
			recursividad(i + 1, j - 1);
		if (oil[i + 1][j].equals("@"))
			recursividad(i + 1, j);
		if (oil[i + 1][j + 1].equals("@"))
			recursividad(i + 1, j + 1);
	}

}
