import java.util.Scanner;

/**
*	10678 - The Grazing Cow
*
*
*	Submision:	9623901
*	Date:		2012-01-06 20:48:16
*	Runtime:	0.176
*	Ranking:	2488
*/
public class Main10678 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		double d, L, a, b, pi = 3.1415926535897932384626433832795;
		int k = input.nextInt();
		while (k > 0) {
			k--;
			d = input.nextDouble();
			L = input.nextDouble();
			a = L / 2;
			b = Math.sqrt((L / 2) * (L / 2) - (d / 2) * (d / 2));
			System.out.printf("%.3f\n", a * b * pi);
		}
		input.close();
		// TODO Auto-generated method stub
	}
}
