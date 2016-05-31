import java.util.Scanner;

/**
*	11455 - Behold my quadrangle
*
*
*	Submision:	9558746
*	Date:		2011-12-14 01:48:02
*	Runtime:	0.236
*	Ranking:	3893
*/
public class Main11455 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int a, b, c, d, casos;
		casos = input.nextInt();
		while (casos > 0) {
			casos--;
			a = input.nextInt();
			b = input.nextInt();
			c = input.nextInt();
			d = input.nextInt();
			if (a == b && b == c && c == d) {
				System.out.println("square");
			} else {
				if ((a == b && c == d) || (a == c && b == d)
						|| (a == d && b == c)) {
					System.out.println("rectangle");
				} else if (b + c + d <= a || a + c + d <= b || a + b + d <= c
						|| a + b + c <= d)
					System.out.println("banana");
				else {
					System.out.println("quadrangle");
				}
			}
		}
		input.close();
	}
}
