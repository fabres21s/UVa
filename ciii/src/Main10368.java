import java.util.Scanner;

/**
*	10368 - Euclid's Game
*
*
*	Submision:	9673639
*	Date:		2012-01-25 01:58:20
*	Runtime:	0.164
*	Ranking:	1024
*/
public class Main10368 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		long a, b;
		while (input.hasNext()) {
			a = input.nextLong();
			b = input.nextLong();
			if (a == 0 && b == 0) {
				break;
			}
			if (gcd(a, b)) {
				System.out.println("Stan wins");
			} else {
				System.out.println("Ollie wins");
			}
		}
		input.close();
	}

	private static boolean gcd(long a, long b) {
		if (b > a) {
			return gcd(b, a);
		}
		if (b == 0) {
			return false;
		}
		if (a / b == 1) {
			return !gcd(b, a % b);
		}
		return true;
	}

}
