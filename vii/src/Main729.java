import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
*	729 - The Hamming Distance Problem
*
*
*	Submission:	16887818
*	Date:		2016-02-22 17:56:52
*	Runtime:	0.539
*	Ranking:	2894
*/
public class Main729 {

	/**
	 * - Pregenerados
	 * - Map
	 * - List
	 * - Sistemas de numeraci�n
	 * 
	 * Dado un n�mero n y una catidad de unos, encontrar, en binario
	 * hasta 2^n los n�meros que cantidad dicha cantidad de unos
	 */
	public static void main(String[] args) {

		Map<Integer, List<String>> superMap = new HashMap<Integer, List<String>>();
		for (int i = 1; i <= 16; i++) {

			superMap.put(i, new ArrayList<String>());
		}

		List<String> list;
		for (int i = 1; i < 65536; i++) {
			String binary = BigInteger.valueOf(i).toString(2);
			int cantidadUnos = binary.replaceAll("0", "").length();
			list = superMap.get(cantidadUnos);
			list.add(binary);

			superMap.put(cantidadUnos, list);
		}

		Scanner input = new Scanner(System.in);
		StringBuffer output = new StringBuffer();
		int testCases = input.nextInt();
		while (testCases-- > 0) {
			int n = input.nextInt();
			int unos = input.nextInt();
			list = superMap.get(unos);
			for (String binary : list) {
				if (binary.length() > n) {
					break;
				}
				output.append(complete(binary, n) + "\n");
			}
			if (testCases > 0) {
				output.append("\n");
			}

		}
		System.out.print(output);
		input.close();
	}

	private static String complete(String binary, int n) {
		int faltantes = n - binary.length();

		for (int i = 0; i < faltantes; i++) {
			binary = "0" + binary;
		}
		return binary;
	}

}
