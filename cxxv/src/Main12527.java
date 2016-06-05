import java.util.Scanner;

/**
*	12527 - Different Digits
*
*
*	Submision:	10894968
*	Date:		2012-11-16 16:01:25
*	Runtime:	0.252
*	Ranking:	1419
*/
public class Main12527 {

	/**
	 * - Pregenerados
	 */
	public static void main(String[] args) {
		boolean arreglo[] = new boolean[5005];
		for (int i = 0; i < 5002; i++) {
			arreglo[i] = diferente(i);
		}
		int x, y, c, i;
		Scanner input = new Scanner(System.in);
		while (input.hasNext()) {
			x = input.nextInt();
			y = input.nextInt();
			c = 0;
			for (i = x; i <= y; i++) {
				if (arreglo[i])
					c++;
			}
			System.out.println(c);
		}
		input.close();
	}

	private static boolean diferente(int i) {
		int arreglo[] = new int[10];
		while (i > 0) {
			arreglo[i % 10]++;
			i = i / 10;
		}
		for (i = 0; i < 10; i++)
			if (arreglo[i] > 1)
				return false;
		return true;
	}

}
