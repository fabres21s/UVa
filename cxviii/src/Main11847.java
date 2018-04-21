import java.util.Scanner;

/**
*	11847 - Cut the Silver Bar
*
*
*	Submission:	10775595
*	Date:		2012-10-22 11:44:34
*	Runtime:	0.284
*	Ranking:	626
*/
public class Main11847 {

	/**
	 * - Logaritmos
	 */
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int n;
		while ((n = input.nextInt()) != 0) {
			System.out.println((int) (Math.log10(n) / Math.log10(2)));
		}
		input.close();

	}

}
