import java.util.Arrays;
import java.util.Scanner;

/**
*	11875 - Brick Game
*
*
*	Submission:	9705521
*	Date:		2012-02-03 14:53:21
*	Runtime:	0.376
*	Ranking:	5967
*/
public class Main11875 {

	/**
	 * - Sort
	 */
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int casos = input.nextInt(), tam, j;
		for (int i = 1; i <= casos; i++) {
			tam = input.nextInt();
			int arreglo[] = new int[tam];
			for (j = 0; j < tam; j++) {
				arreglo[j] = input.nextInt();
			}
			Arrays.sort(arreglo);
			System.out.printf("Case %d: %d\n", i, arreglo[tam / 2]);
		}
		input.close();
	}

}
