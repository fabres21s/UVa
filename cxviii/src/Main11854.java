import java.util.Arrays;
import java.util.Scanner;

/**
*	11854 - Egypt
*
*
*	Submission:	9483505
*	Date:		2011-11-18 19:33:35
*	Runtime:	0.164
*	Ranking:	7512
*/
public class Main11854 {

	/**
	 * - Tri�ngulos
	 * - F�rmula
	 */
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		// double a,b,c;
		int[] valores = new int[3];
		while (input.hasNext()) {
			valores[0] = input.nextInt();
			valores[1] = input.nextInt();
			valores[2] = input.nextInt();
			if (valores[0] == 0 && valores[1] == 0 && valores[2] == 0) {
				break;
			}
			Arrays.sort(valores);
			if ((valores[0] * valores[0] + valores[1] * valores[1]) == (valores[2] * valores[2])) {
				System.out.println("right");
			} else {
				System.out.println("wrong");
			}

		}
		input.close();
	}

}
