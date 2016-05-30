import java.util.Scanner;

/**
*	913 - Joana and the Odd Numbers
*
*
*	Submision:	9574973
*	Date:		2011-12-19 13:58:12
*	Runtime:	0.132
*	Ranking:	5844
*/
public class Main913 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		long n;
		while (input.hasNext()) {
			n = input.nextLong();
			n = (n + 1) / 2;
			n = n * n;
			n = 2 * n - 1;
			n = 3 * n - 6;
			System.out.println(n);
		}
		// TODO Auto-generated method stub

	}

}
