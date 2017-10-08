import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
*	11385 - Da Vinci Code
*
*	Submision:	20140732
*	Date:		2017-10-08 22:23:12
*	Runtime:	0.090
*	Ranking:	1637
*/

public class Main11385 {

	static long fibos[] = new long[50];

	/**
	 * - Serie de Fibonacci
	 * - Cadena de caracteres
	 * 
	 * Decodificar un mensaje usando la serie de Fibonacci
	 * 
	 */
	public static void main(String[] args) {

		fibos[0] = 1;
		fibos[1] = 2;
		for (int i = 2; i < 50; i++) {
			fibos[i] = fibos[i - 1] + fibos[i - 2];
		}
		
		Scanner input = new Scanner(System.in);
		int k = Integer.valueOf(input.nextLine()), n, i;

		while (k-- > 0) {

			n = Integer.valueOf(input.nextLine());
			long arreglo[] = new long[n];
			args = input.nextLine().split(" ");
			long max = 0;
			for (i = 0; i < n; i++) {
				arreglo[i] = Integer.valueOf(args[i]);
				if (arreglo[i] > max) {
					max = arreglo[i];
				}
			}

			System.out.println(decode(arreglo, input.nextLine()));

		}
		input.close();

	}

	public static String decode(long[] arreglo, String text) {

		char c[] = text.toCharArray();
		StringBuffer buffer;
		Map<Long, Character> map = new HashMap<Long, Character>();
		int x = 0, i;

		long max = 0;
		for (i = 0; i < arreglo.length; i++) {
			if (arreglo[i] > max) {
				max = arreglo[i];
			}
		}

		for (i = 0; i < c.length; i++) {
			if (c[i] > 64 && c[i] < 91) {

				map.put(arreglo[x], c[i]);
				x++;

			}
			if (x == arreglo.length) {
				break;
			}

		}
		x = 0;
		Character s;
		buffer = new StringBuffer();
		while (fibos[x] <= max) {
			s = map.get(fibos[x]);
			if (s == null)
				buffer.append(" ");
			else {
				buffer.append(s);
			}
			x++;
		}
		return (buffer.toString());

	}

}
