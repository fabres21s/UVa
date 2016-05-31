import java.util.Scanner;

/**
*	113 - Power of Cryptography
*
*
*	Submision:	9337765
*	Date:		2011-10-05 20:11:10
*	Runtime:	0.608
*	Ranking:	15383
*/
public class Main113 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		double n, p;
		long k;
		while (input.hasNext()) {
			n = input.nextDouble();
			p = input.nextDouble();
			// k=(long)(Math.log10(p)/Math.log10(n));
			k = (long) Math.round(Math.pow(p, 1 / n));
			System.out.println(k);
		}

	}

}
