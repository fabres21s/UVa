import java.math.BigDecimal;
import java.util.Scanner;

/**
*	748 - Exponentiation
*
*
*	Submision:	9498931
*	Date:		2011-11-23 13:32:15
*	Runtime:	0.132
*	Ranking:	2693
*/
public class Main748 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);
		BigDecimal base;// =new BigDecimal();
		int exp;
		while (input.hasNext()) {
			base = input.nextBigDecimal();
			exp = input.nextInt();
			base = base.pow(exp);
			String ans = new String(base.toPlainString());
			int end_zero = ans.length();
			for (int i = ans.length() - 1; i >= 0; --i) {
				if (ans.charAt(i) == '0') {
					end_zero = i;
				} else
					break;
			}
			ans = ans.substring(0, end_zero);
			if (base.compareTo(BigDecimal.ONE) < 0) {
				ans = ans.substring(1);
			}
			System.out.println(ans);
		}
		// TODO Auto-generated method stub

	}
}
