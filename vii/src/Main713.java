import java.math.BigInteger;
import java.util.Scanner;
/**
*	713 - Adding Reversed Numbers
*
*
*	Submision:	16456541
*	Date:		2015-11-18 19:43:57
*	Runtime:	0.232
*	Ranking:	5688
*/
public class Main713 {

	/*
	 * cojer dos números darles la vuelta, sumarlos y volverles a dar la vuelta
	 */
	static BigInteger ONE = BigInteger.ONE;
	static BigInteger TEN = BigInteger.TEN;
	static BigInteger ZERO = BigInteger.ZERO;

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int casos = input.nextInt();
		BigInteger a, b;
		while (casos-- > 0) {
			a = input.nextBigInteger();
			b = input.nextBigInteger();
			System.out.println(reverse(reverse(a).add(reverse(b))));
		}
		input.close();
	}

	static BigInteger reverse(BigInteger n) {
		BigInteger x = ZERO;

		BigInteger mult = ONE;
		while (mult.compareTo(n) <= 0) {
			mult = mult.multiply(TEN);
		}

		while (n.compareTo(ZERO) > 0) {
			mult = mult.divide(TEN);
			x = x.add(n.mod(TEN).multiply(mult));
			n = n.divide(TEN);

		}

		return x;
	}

}
