import java.util.Scanner;

/**
*	11498 - Division of Nlogonia
*
*
*	Submision:	9567522
*	Date:		2011-12-17 00:48:26
*	Runtime:	0.832
*	Ranking:	10306
*/

public class Main11498 {

	/**
	 * - Simulación
	 */
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int query, x, y, px, py;
		while ((query = input.nextInt()) != 0) {
			x = input.nextInt();
			y = input.nextInt();
			while (query > 0) {
				query--;
				px = input.nextInt() - x;
				py = input.nextInt() - y;
				if (px > 0 && py > 0) {
					System.out.println("NE");
				} else if (px > 0 && py < 0) {
					System.out.println("SE");
				} else if (px < 0 && py > 0) {
					System.out.println("NO");
				} else if (px < 0 && py < 0) {
					System.out.println("SO");
				} else {
					System.out.println("divisa");
				}
			}
		}
		input.close();
	}
}
