import java.util.Scanner;

/**
*	10104 - Euclid Problem
*
*
*	Submision:	9317604
*	Date:		2011-09-30 16:22:45
*	Runtime:	2.764
*	Ranking:	4319
*/
public class Main10104 {
	static int lastx = 1, lasty = 1;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int a, b, g;
		while (input.hasNext()) {
			a = input.nextInt();
			b = input.nextInt();
			g = extendedEuclidAlgorithm(a, b);
			System.out.println(lastx + " " + lasty + " " + g);
		}
		input.close();
		// TODO Auto-generated method stub
	}

	// algoritmo de Euclides
	static int extendedEuclidAlgorithm(int a, int b) {
		int x = 0;
		int y = 1;
		int tmp = 0;
		lastx = 1;
		lasty = 0;
		int quotient = 0;

		while (b != 0) {
			tmp = b;
			quotient = a / b;
			b = a % b;
			a = tmp;

			tmp = x;
			x = lastx - quotient * x;
			lastx = tmp;

			tmp = y;
			y = lasty - quotient * y;
			lasty = tmp;
		}
		return a;
	}
}
