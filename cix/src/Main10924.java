import java.util.Scanner;

/**
*	10924 - Prime Words
*
*
*	Submision:	9554337
*	Date:		2011-12-12 16:32:57
*	Runtime:	0.196
*	Ranking:	7892
*/
public class Main10924 {
	static int primos[] = { 2, 3, 5, 7, 9, 11, 13, 17, 19, 23, 29, 31, 37, 41,
			43, 47, 53 };

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String letras = " abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
		Scanner input = new Scanner(System.in);
		int sum, i;
		String word;
		while (input.hasNext()) {
			sum = 0;
			word = input.next();
			for (i = 0; i < word.length(); i++) {
				sum += letras.indexOf(word.charAt(i));
			}
			if (esprimo(sum)) {
				System.out.println("It is a prime word.");
			} else {
				System.out.println("It is not a prime word.");
			}
		}
		input.close();
	}

	static boolean esprimo(int n) {
		for (int i = 0; primos[i] <= Math.sqrt(n); i++) {
			if (n % primos[i] == 0) {
				return false;
			}
		}

		return true;
	}

}
