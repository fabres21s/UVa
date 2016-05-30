import java.util.Scanner;

public class Main {
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
