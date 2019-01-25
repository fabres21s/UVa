import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main10450 {

	//TODO - Poner información
	//Mira donde viene a aparecer la serie de fibonacci
	public static void main(String[] args) throws NumberFormatException, IOException {
		// printNonConsecutive(16);
		long[] fibonacci = new long[60];
		generateFibonacciSerie(fibonacci);

		StringBuffer output = new StringBuffer();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testCases = Integer.parseInt(br.readLine());
		
		for (int i = 1; i <=testCases; i++) {
			output.append(String.format("Scenario #%d:\n%d\n\n", i, fibonacci[Integer.parseInt(br.readLine())]));
		}
		System.out.print(output);
	}

	private static void generateFibonacciSerie(long[] fibonacci) {
		fibonacci[0] = 1;
		fibonacci[1] = 2;
		for (int i = 2; i < 55; i++) {
			fibonacci[i] = fibonacci[i - 1] + fibonacci[i - 2];
		}
	}

	static void printNonConsecutive(int n) {
		// Let us first compute
		// 2 raised to power n.
		long p = (long) Math.pow(2, n);

		// loop 1 to n to check
		// all the numbers
		long count = 0;
		int pow = 1;
		for (long i = 0; i < p; i++) {

			// A number i doesn't contain
			// consecutive set bits if
			// bitwise and of i and left
			// shifted i do't contain a
			// commons set bit.
			if (i == pow) {
				System.out.println(count);
				pow *= 2;
			}
			if ((i & (i << 1)) == 0)
				count++;

		}

	}

}
