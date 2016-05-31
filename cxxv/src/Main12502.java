import java.util.Scanner;

/**
*	12502 - Three Families
*
*
*	Submision:	10763259
*	Date:		2012-10-19 23:39:50
*	Runtime:	0.180
*	Ranking:	2509
*/
public class Main12502 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int casos = input.nextInt();
		double a, b, x, prom;
		while (casos-- > 0) {
			a = input.nextInt();
			b = input.nextInt();
			x = input.nextInt();
			prom = (a + b) / 3;
			System.out.println(Math.round((x * (a - prom)) / prom));
		}

	}

}
