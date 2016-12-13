import java.math.BigInteger;
import java.util.Scanner;

/**
*	10019 - Funny Encryption Method
*
*
*	Submision:	9703965
*	Date:		2012-02-03 02:16:16
*	Runtime:	0.148
*	Ranking:	8267
*/
public class Main10019 {
	/**
	 * - Sistemas de numeración
	 */
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int casos = input.nextInt(), dec, hex, i;
		BigInteger a;
		String valor;
		char[] decimal;
		char hexa[];
		while (casos > 0) {
			casos--;
			valor = input.next();
			a = new BigInteger(valor, 10);
			decimal = a.toString(2).toCharArray();
			a = new BigInteger(valor, 16);
			hexa = a.toString(2).toCharArray();
			dec = hex = 0;
			for (i = 0; i < decimal.length; i++)
				if (decimal[i] == '1')
					dec++;
			for (i = 0; i < hexa.length; i++)
				if (hexa[i] == '1')
					hex++;
			System.out.printf("%d %d\n", dec, hex);
		}
		input.close();
	}
}
