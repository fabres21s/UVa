import java.util.Scanner;

/**
 * 
 * @author fabio
 * 108 - Maximum Sum
 * Lo entender� su puta madre
 * 
 * Submit:	2016-05-18 21:40:24
 * Runtime:	0.150
 * Ranking:	9365
 */

/**
*	108 - Maximum Sum	54187
*
*
*	Submission:	17382149
*	Date:		2016-05-18 21:40:24
*	Runtime:	0.150
*	Ranking:	9369
*/
public class Main108 {

	/**
	 * TODO Asignar Categor�a!!!
	 */
	public static void main(String args[]) {
		Scanner input = new Scanner(System.in);
		int N;
		while (input.hasNext()) {
			N = input.nextInt();
			int Table[][] = new int[N + 2][N + 2];

			for (int i = 1; i <= N; i++) {
				for (int j = 0; j < N; j++) {
					Table[i][j] = input.nextInt();

				}
			}

			int i, j, k, t;
			for (i = 1; i <= N; i++) {
				for (j = 0; j < N; j++)
					Table[i][j] = Table[i][j] + Table[i - 1][j];
			}

			int MAX = Table[1][0];
			for (k = 1; k <= N; k++) {
				for (i = 0; i <= N - k; i++) {
					for (t = 0, j = 0; j < N; j++) {
						if (t >= 0)
							t += Table[i + k][j] - Table[i][j];
						else
							t = Table[i + k][j] - Table[i][j];
						if (t > MAX)
							MAX = t;
					}
				}
			}
			System.out.printf("%d\n", MAX);
		}
		input.close();
	}
}
