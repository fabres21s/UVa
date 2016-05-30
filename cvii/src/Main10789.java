import java.util.Scanner;

/**
*	10789 - Prime Frequency
*
*
*	Submision:	9841445
*	Date:		2012-03-10 14:56:24
*	Runtime:	0.412
*	Ranking:	4030
*/
public class Main10789 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int i, j, k = input.nextInt() + 1;
		char[] seq;
		int[] arreglo;// =new int[75];
		boolean empty;
		for (j = 1; j < k; j++) {
			seq = input.next().toCharArray();
			arreglo = new int[80];
			for (i = 0; i < seq.length; i++)
				arreglo[seq[i] - 48]++;
			empty = true;
			// System.out.println(Arrays.toString(arreglo));
			System.out.printf("Case %d: ", j);
			for (i = 0; i < 80; i++)
				if (arreglo[i] > 1)
					if (esprimo(arreglo[i])) {
						System.out.print((char) (i + 48));
						empty = false;
					}
			if (empty)
				System.out.print("empty");
			System.out.println();
		}
		input.close();
		// TODO Auto-generated method stub

	}

	private static boolean esprimo(int x) {
		int i, c;
		c = x;
		if (c == 2)
			return true;
		while (c % 2 == 0)
			return false;
		i = 3;
		while (i <= (Math.sqrt(c) + 1)) {
			if (c % i == 0)
				return false;
			else
				i += 2;
		}
		if (c == x)
			return true;
		return false;
	}
}
