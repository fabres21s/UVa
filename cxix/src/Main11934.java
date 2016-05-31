import java.util.Scanner;

/**
*	11934 - Magic Formula
*
*
*	Submision:	9706191
*	Date:		2012-02-03 18:29:21
*	Runtime:	0.160
*	Ranking:	2681
*/
public class Main11934 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int i, con;
		long a, b, c, d, l;
		while (true) {
			a = input.nextLong();
			b = input.nextLong();
			c = input.nextLong();
			d = input.nextLong();
			l = input.nextLong();
			if (a == 0 && b == 0 && c == 0 && d == 0 && l == 0) {
				break;
			}
			con = 0;
			for (i = 0; i <= l; i++) {
				if ((a * i * i + b * i + c) % d == 0) {
					con++;
				}
			}
			System.out.println(con);
		}
		input.close();
	}
}
