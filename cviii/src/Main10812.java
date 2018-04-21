import java.util.Scanner;

/**
*	10812 - Beat the Spread!
*
*
*	Submission:	9842970
*	Date:		2012-03-10 23:10:36
*	Runtime:	0.204
*	Ranking:	12347
*/
public class Main10812 {

	/**
	 * - Proceso matem�tico
	 */
	public static void main(String[] args) {
		int x, y, k, z;
		Scanner input = new Scanner(System.in);
		k = input.nextInt();
		while (k > 0) {
			k--;
			x = input.nextInt();
			y = input.nextInt();
			z = x + y;
			if (x < y || z % 2 == 1)
				System.out.print("impossible\n");
			else
				System.out.printf("%d %d\n", z / 2, (x - z / 2));
		}
		input.close();

	}

}
