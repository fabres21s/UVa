import java.util.Scanner;

/**
*	352 - The Seasonal War
*
*
*	Submision:	9897571
*	Date:		2012-03-22 21:42:40
*	Runtime:	0.148
*	Ranking:	5623
*/
public class Main352 {
	static int cont;
	static String war[][];

	/**
	 * - Recursividad
	 */
	public static void main(String[] args) {
		int m, n, i, j, x = 1;
		Scanner input = new Scanner(System.in);
		while (input.hasNext()) {
			m = input.nextInt();
			n = m;
			cont = 0;
			war = new String[m + 2][n + 2];
			inicializar();
			for (i = 1; i <= m; i++) {
				args = input.next().split("");
				for (j = 1; j <= n; j++) {
					war[i][j] = args[j];
				}
			}
			for (i = 1; i <= m; i++) {
				for (j = 1; j <= n; j++) {
					if (war[i][j].equals("1")) {
						cont++;
						recursividad(i, j);
					}
				}
			}
			System.out.printf("Image number %d contains %d war eagles.\n", x,
					cont);
			x++;
		}
		input.close();
	}

	private static void recursividad(int i, int j) {
		war[i][j] += cont;
		if (war[i - 1][j - 1].equals("1"))
			recursividad(i - 1, j - 1);
		if (war[i - 1][j].equals("1"))
			recursividad(i - 1, j);
		if (war[i - 1][j + 1].equals("1"))
			recursividad(i - 1, j + 1);
		if (war[i][j - 1].equals("1"))
			recursividad(i, j - 1);
		if (war[i][j + 1].equals("1"))
			recursividad(i, j + 1);
		if (war[i + 1][j - 1].equals("1"))
			recursividad(i + 1, j - 1);
		if (war[i + 1][j].equals("1"))
			recursividad(i + 1, j);
		if (war[i + 1][j + 1].equals("1"))
			recursividad(i + 1, j + 1);
	}

	private static void inicializar() {
		for (int i = 0; i < war.length; i++) {
			for (int j = 0; j < war[0].length; j++)
				war[i][j] = "";
		}

	}

}
