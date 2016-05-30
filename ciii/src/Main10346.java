import java.util.Scanner;

/**
*	10346 - Peter's Smokes
*
*
*	Submision:	9567556
*	Date:		2011-12-17 01:09:54
*	Runtime:	0.420
*	Ranking:	12087
*/
public class Main10346 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int n, k;
		while (input.hasNext()) {
			n = input.nextInt();
			k = input.nextInt();
			System.out.println((n + (n - 1) / (k - 1)));
		}
		input.close();
		// TODO Auto-generated method stub
	}
}
