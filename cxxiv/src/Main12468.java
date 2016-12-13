import java.util.Scanner;

/**
*	12468 - Zapping
*
*
*	Submision:	10645786
*	Date:		2012-09-24 11:58:37
*	Runtime:	0.204
*	Ranking:	4342
*/
public class Main12468 {

	/**
	 * - Simulación
	 */
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int a, b, x, y;
		while (true) {
			a = input.nextInt();
			b = input.nextInt();
			x = Math.min(a, b);
			y = Math.max(a, b);
			if (a == -1 && b == -1)
				break;
			System.out.println(Math.min((100 - y + x), (y - x)));
			// System.out.println((100-b+a)+"   "+Math.abs(a-b));

		}
		input.close();

	}

}
