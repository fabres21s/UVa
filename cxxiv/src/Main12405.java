import java.util.Scanner;

/**
*	12405 - Scarecrow
*
*
*	Submision:	10732248
*	Date:		2012-10-14 00:12:36
*	Runtime:	0.140
*	Ranking:	1948
*/
public class Main12405 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int casos = input.nextInt() + 1, res;
		char p[];
		for (int i = 1; i < casos; i++) {
			res = input.nextInt();
			res = 0;
			p = input.next().toCharArray();
			for (int j = 0; j < p.length;) {
				if (p[j] == '.') {
					j += 3;
					res++;
				} else
					j++;
			}
			System.out.printf("Case %d: %d\n", i, res);
		}

	}

}
