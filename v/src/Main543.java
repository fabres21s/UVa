import java.util.Scanner;
import java.util.Vector;

/**
*	543 - Goldbach's Conjecture
*
*
*	Submision:	9435807
*	Date:		2011-11-02 21:34:58
*	Runtime:	1.692
*	Ranking:	8928
*/
public class Main543 {
	static Vector<Integer> primos = new Vector<Integer>();

	/**
	 * - Números Primos
	 */
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int n, i;
		boolean found;
		while ((n = input.nextInt()) != 0) {
			if (esprimo(n - 2)) {
				System.out.println(n + " = " + 2 + " + " + (n - 2));
				continue;
			}
			found = false;
			for (i = 3; i <= n / 2; i += 2) {
				if (esprimo(i)) {
					if (esprimo(n - i)) {
						found = true;
						System.out.println(n + " = " + i + " + " + (n - i));
						break;
					}
				}
			}
			if (!found) {
				System.out.println("Goldbach's conjecture is wrong.");
			}

		}

	}

	static boolean esprimo(int valor) {
		if (valor == 2) {
			return true;
		}
		if (valor % 2 == 0) {
			return false;
		}
		for (int i = 3; i <= Math.sqrt(valor); i += 2) {
			if (valor % i == 0) {
				return false;
			}
		}

		return true;
	}

}
