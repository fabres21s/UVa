import java.util.Scanner;

/**
*	583 - Prime Factors
*
*
*	Submision:	9543400
*	Date:		2011-12-08 13:31:05
*	Runtime:	2.484
*	Ranking:	4887
*/
public class Main583 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int n;
		while ((n = input.nextInt()) != 0) {
			descomponer(n);
		}
		// TODO Auto-generated method stub

	}

	static void descomponer(int n) {
		if (n == 1) {
			System.out.println("1 = 1");
			return;
		}

		int x = n;
		StringBuffer buffer = new StringBuffer();
		if (n < 0) {
			buffer.append("-1 x ");
			n *= -1;
		}
		while ((n % 2) == 0) {
			buffer.append("2 x ");
			n = n / 2;
		}
		int i = 3;
		while (i <= Math.sqrt(n) + 1) {
			if ((n % i) == 0) {
				// System.out.println("    "+i);
				buffer.append(i + " x ");
				n = n / i;
			} else {
				i += 2;
			}

		}
		if (n > 1) {
			buffer.append(n + " x ");
		}
		// System.out.println(buffer);
		String respuesta = buffer.toString();
		System.out.println(x + " = "
				+ respuesta.substring(0, respuesta.length() - 3));
	}

}
