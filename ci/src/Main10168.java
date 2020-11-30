import java.util.ArrayList;
import java.util.List;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
*	10168 - Summation of Four Primes
*
*	Submission:	20208587
*	Date:		2017-10-20 01:58:06
*	Runtime:	0.120
*	Ranking:	2184 / 5538
*/
public class Main10168 {

	static List<Integer> answerTestCase = new ArrayList<Integer>();
	static List<Integer> memory = new ArrayList<Integer>();

	/**
	 * - Números primos
	 * 
	 *  Encontrar una Conjetura de Goldbach con 4 números
	 */
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line;
		
		int number, n1, n2;
		boolean goldbachsConjecture;
		StringBuffer output = new StringBuffer();
		while ((line = br.readLine()) != null) {
			
			number = Integer.parseInt(line);

			if (number < 8) {
				output.append("Impossible.\n");
			} else {

				n1 = number / 2;
				n2 = n1 + number % 2;
				goldbachsConjecture = false;

				while (!goldbachsConjecture) {

					if (goldbachsConjecture(n1)) {
						if (goldbachsConjecture(n2)) {
							goldbachsConjecture = true;

							for (int x = 0; x < 3; x++) {
								output.append(answerTestCase.get(x));
								output.append(" ");
							}
							output.append(answerTestCase.get(3));
							output.append("\n");
						}
					}
					answerTestCase.clear();
					n1++;
					n2--;

				}
			}
			
		}
		System.out.print(output);
		
	}

	private static boolean goldbachsConjecture(int number) {

		if (isNumberPrime(number - 2)) {
			answerTestCase.add(2);
			answerTestCase.add(number - 2);
			return true;
		}

		if (number % 2 == 0) {
			
		
		
		for (int i = 3; i <= number / 2; i += 2) {
			if (isNumberPrime(i)) {
				if (isNumberPrime(number - i)) {
					answerTestCase.add(i);
					answerTestCase.add(number - i);
					return true;
				}
			}
		}
		}

		return false;
	}

	static boolean isNumberPrime(int valor) {

		if (memory.contains(valor)) {
			return true;
		}
		if (valor == 2) {
			return true;
		}

		if (valor % 2 == 0) {
			return false;
		}
		
		int sqrt = (int) Math.sqrt(valor) + 1;
		for (int i = 3; i <= sqrt; i += 2) {
			if (valor % i == 0) {
				return false;
			}
		}

		memory.add(valor);
		return true;
	}

}
