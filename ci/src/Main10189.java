import java.io.IOException;
import java.util.Scanner;

/**
*	10189 - Minesweeper
*
*
*	Submision:	9239782
*	Date:		2011-09-08 19:04:37
*	Runtime:	0.708
*	Ranking:	17243
*/
public class Main10189 {
	/**
	 * - Arreglos
	 */
	public static void main(String[] args) throws IOException {
		Scanner input = new Scanner(System.in);
		int i, j, campos = 0;
		int n, m;
		String[] tokens;
		while (true) {
			tokens = input.nextLine().split(" ");
			n = Integer.valueOf(tokens[0]);
			m = Integer.valueOf(tokens[1]);
			String[][] tablero = new String[n][m];
			if (n == 0 || m == 0) {
				break;
			}
			for (i = 0; i < n; i++) {
				tokens = input.nextLine().split("");
				for (j = 1; j < m + 1; j++) {
					tablero[i][j - 1] = tokens[j];
				}
			}
			if (campos > 0) {
				System.out.println();
			}
			campos++;
			int minas[][] = new int[n + 2][m + 2];
			System.out.println("Field #" + campos + ":");
			for (i = 1; i < n + 1; i++) {
				for (j = 1; j < m + 1; j++) {
					if (tablero[i - 1][j - 1].equals("*")) {
						minas[i - 1][j - 1]++;
						minas[i - 1][j]++;
						minas[i - 1][j + 1]++;
						minas[i][j - 1]++;
						minas[i][j + 1]++;
						minas[i + 1][j - 1]++;
						minas[i + 1][j]++;
						minas[i + 1][j + 1]++;
					}
				}
			}
			for (i = 0; i < n; i++) {
				for (j = 0; j < m; j++) {
					if (tablero[i][j].equals("*")) {
						System.out.print("*");
					} else {
						System.out.print(minas[i + 1][j + 1]);
					}
				}
				System.out.print("\n");
			}

		}
		input.close();
	}
}