import java.io.IOException;
import java.util.Scanner;

/**
*	10195 - The Knights Of The Round Table
*
*
*	Submision:	9317707
*	Date:		2011-09-30 16:45:03
*	Runtime:	0.804
*	Ranking:	4941
*/
public class Main10195 {

	/**
	 * - Círculo
	 */
	public static void main(String[] args) throws IOException {
		Scanner input = new Scanner(System.in);
		double a, b, c, k, r;
		while (input.hasNext()) {
			a = input.nextDouble();
			b = input.nextDouble();
			c = input.nextDouble();
			if (a <= 0 || b <= 0 || c <= 0) {
				System.out.println("The radius of the round table is: 0.000");
				continue;
			}
			k = (a + b + c) / 2;
			r = (Math.sqrt(k * (k - a) * (k - b) * (k - c))) / k;
			System.out.printf("The radius of the round table is: %.3f\n", r);
		}
		input.close();
	}
}
