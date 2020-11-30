import java.util.Scanner;

/**
 * 
 * @author fabio 10684 - The jackpot
 * 
 *         -Arreglos Encontrar la sumatoria m�xima en un arreglo
 * 
 *         Submit: 2016-05-18 22:27:28 Runtime: 0.780 Ranking: 5004
 */

/**
*	10684 - The jackpot
*
*
*	Submission:	17382233
*	Date:		2016-05-18 22:27:28
*	Runtime:	0.780
*	Ranking:	8719 / 9623
*/
public class Main10684 {

	/**
	 * TODO Asignar Categor�a!!!
	 */
	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);
		int N;
		int i, j, t;
		while (input.hasNext()) {
			N = input.nextInt();
			if (N == 0) {
				break;
			}
			int Table[] = new int[N];

			for (j = 0; j < N; j++) {
				Table[j] = input.nextInt();

			}

			int MAX = 0;
			t = 0;
			for (i = 0; i < N; i++) {
				t += Table[i];
				if (t < 0) {
					t = 0;
				}
				MAX = Math.max(MAX, t);
			}

			if (MAX > 0) {
				System.out.printf("The maximum winning streak is %d.\n", MAX);
			} else {
				System.out.println("Losing streak.");
			}
		}
		input.close();
	}

}
