import java.util.Scanner;

/**
*	974 - Kaprekar Numbers
*
*
*	Submission:	10318695
*	Date:		2012-07-11 11:56:35
*	Runtime:	0.564
*	Ranking:	898
*/
public class Main974 {

	/**
	 * - Pregenerados
	 * - Proceso matemático
	 */
	public static void main(String[] args) {
		int kaprekars[] = { 9, 45, 55, 99, 297, 703, 999, 2223, 2728, 4879,
				4950, 5050, 5292, 7272, 7777, 9999, 17344, 22222, 38962 };
		Scanner input = new Scanner(System.in);
		int casos = input.nextInt() + 1, inf, sup, k;
		boolean found;
		for (int i = 1; i < casos; i++) {
			inf = input.nextInt();
			sup = input.nextInt();
			found = false;
			System.out.println("case #" + i);
			for (k = 0; k < kaprekars.length; k++)
				if (kaprekars[k] >= inf && kaprekars[k] <= sup) {
					System.out.println(kaprekars[k]);
					found = true;
				}
			if (!found)
				System.out.println("no kaprekar numbers");
			if (i != (casos - 1))
				System.out.println();
		}
		input.close();
	}
}
