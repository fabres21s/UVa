import java.util.Scanner;

/**
*	10922 - 2 the 9s
*
*
*	Submision:	9974964
*	Date:		2012-04-09 20:27:51
*	Runtime:	0.500
*	Ranking:	3960
*/
public class Main10922 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		char p[];
		int s, i, c;
		Scanner input = new Scanner(System.in);
		while (true) {
			String k = input.next();
			p = k.toCharArray();
			if (p[0] == '0')
				break;
			c = 0;
			do {
				s = 0;
				c++;
				for (i = 0; i < p.length; i++)
					s += p[i] - 48;
				p = (s + "").toCharArray();
			} while (p.length > 1);
			if (s == 9)
				System.out.printf(
						"%s is a multiple of 9 and has 9-degree %d.\n", k, c);
			else
				System.out.printf("%s is not a multiple of 9.\n", k);
		}
		input.close();

	}

}
