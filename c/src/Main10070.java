import java.math.BigInteger;
import java.util.GregorianCalendar;
import java.util.Scanner;

/**
*	10070 - Leap Year or Not Leap Year and ...
*
*
*	Submision:	12312354
*	Date:		2013-09-07 22:21:16
*	Runtime:	0.615
*	Ranking:	4489
*/
public class Main10070 {

	static BigInteger a = new BigInteger("4");
	static BigInteger b = new BigInteger("100");
	static BigInteger c = new BigInteger("400");
	static BigInteger d = new BigInteger("15");
	static BigInteger e = new BigInteger("55");

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		// GregorianCalendar gregorian=new GregorianCalendar();

		Scanner input = new Scanner(System.in);
		BigInteger n;
		boolean leapYear, flag, first = true;
		while (input.hasNext()) {
			flag = leapYear = false;
			n = input.nextBigInteger();
			if (!first) {
				System.out.println();
			}
			if (bisiesto(n)) {
				System.out.println("This is leap year.");
				leapYear = true;
				flag = true;
			}
			if ((n.mod(d)).intValue() == 0) {
				System.out.println("This is huluculu festival year.");
				flag = true;
			}
			if (leapYear) {
				if ((n.mod(e)).intValue() == 0) {
					System.out.println("This is bulukulu festival year.");
					flag = true;
				}
			}
			if (!flag) {
				System.out.println("This is an ordinary year.");
			}
			first = false;

		}
		input.close();

	}

	static boolean bisiesto(BigInteger x) {

		if ((x.mod(a)).intValue() == 0
				&& ((x.mod(b)).intValue() != 0 || (x.mod(c)).intValue() == 0))
			return true;
		return false;
	}

}
