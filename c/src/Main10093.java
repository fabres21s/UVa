import java.io.IOException;
import java.util.Scanner;

/**
*	10093 - An Easy Problem!
*
*
*	Submision:	9314265
*	Date:		2011-09-29 21:30:48
*	Runtime:	0.016
*	Ranking:	821
*/
public class Main10093 {
	/**
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		Scanner input = new Scanner(System.in);
		int d, big, sum;
		String n;
		while (input.hasNext()) {
			sum = 0;
			big = 1;
			n = input.next();
			for (int i = 0; i < n.length(); i++) {
				d = count(n.charAt(i));
				sum += d;
				if (d > big) {
					big = d;
				}
			}
			for (; big < 62; big++) {
				if ((sum % big) == 0) {
					System.out.println((big + 1));
					break;
				}
			}
			if (big == 62) {
				System.out.println("such number is impossible!");
			}
		}
		input.close();
		// TODO Auto-generated method stub
	}

	static int count(char ch) {
		if (Character.isDigit(ch)) {
			return ch - '0';
		}
		if (Character.isUpperCase(ch)) {
			return ch - 'A' + 10;
		}
		if (Character.isLowerCase(ch)) {
			return ch - 'a' + 36;
		}
		return 0;
	}
}
