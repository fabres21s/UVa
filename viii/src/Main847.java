import java.util.Scanner;

/**
*	847 - A Multiplication Game
*
*
*	Submision:	9243297
*	Date:		2011-09-09 20:06:43
*	Runtime:	0.120
*	Ranking:	4655
*/
public class Main847 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int n, p, j;
		while (input.hasNext()) {
			n = input.nextInt();
			for (p = 1, j = 0; p < n;) {
				if (j++ % 2 == 0) {
					p *= 9;
				} else {
					p *= 2;
				}
			}
			if (j % 2 == 0) {
				System.out.println("Ollie wins.");
			} else {
				System.out.println("Stan wins.");
			}
		}
		// TODO Auto-generated method stub

	}

}
