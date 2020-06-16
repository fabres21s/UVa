import java.util.Arrays;
import java.util.Scanner;

/**
*	576 - Haiku Review
*
*
*	Submission:	9901521
*	Date:		2012-03-23 21:11:41
*	Runtime:	0.132
*	Ranking:	3224
*/
public class Main576 {
	static String vocales = "aeiouy";

	/**
	 * - Cadena de caracteres
	 */
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		String fin[] = { "e", "o", "i" };

		while (input.hasNext()) {
			args = input.nextLine().split("/");
			if (Arrays.equals(args, fin))
				break;
			if (contarvocales(args[0]) == 5) {
				if (contarvocales(args[1]) == 7) {
					if (contarvocales(args[2]) == 5)
						System.out.println("Y");
					else
						System.out.println("3");
				} else
					System.out.println("2");
			} else
				System.out.println("1");

		}
		input.close();
	}

	static int contarvocales(String haiku) {
		haiku = " " + haiku;
		int c = 0, i;
		char[] p = haiku.toCharArray();
		for (i = 1; i < p.length; i++)
			if (vocales.indexOf(p[i]) > -1 && vocales.indexOf(p[i - 1]) < 0) {
				// System.out.println(p[i]+"   "+p[i-1]);
				c++;
			}
		return c;
	}
}
