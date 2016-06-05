import java.util.Scanner;

/**
*	12372 - Packing for Holiday
*
*
*	Submision:	10329082
*	Date:		2012-07-13 15:45:09
*	Runtime:	0.184
*	Ranking:	6570
*/
public class Main12372{

	/**
	 * - Muy fácil
	 */
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int casos = input.nextInt() + 1, i;
		int a, b, c;
		for (i = 1; i < casos; i++) {
			a = input.nextInt();
			b = input.nextInt();
			c = input.nextInt();
			if (a > 20 || b > 20 || c > 20)
				System.out.printf("Case %d: bad\n", i);
			else
				System.out.printf("Case %d: good\n", i);
		}
		input.close();

	}

}
