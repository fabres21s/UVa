import java.util.Arrays;
import java.util.Scanner;

/**
*	11727 - Cost Cutting
*
*
*	Submission:	9503101
*	Date:		2011-11-25 01:24:56
*	Runtime:	0.292
*	Ranking:	15907
*/
public class Main11727 {

	/**
	 * - Sort
	 */
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int casos = input.nextInt();
		int[] arreglo = new int[3];
		for (int i = 1; i <= casos; i++) {
			arreglo[0] = input.nextInt();
			arreglo[1] = input.nextInt();
			arreglo[2] = input.nextInt();
			Arrays.sort(arreglo);
			System.out.printf("Case %d: %d\n", i, arreglo[1]);
		}
		input.close();
	}

}
