import java.util.Scanner;

/**
*	10139 - Factovisors
*
*
*	Submission:	9483351
*	Date:		2011-11-18 18:32:57
*	Runtime:	2.148
*	Ranking:	3938 / 4315
*/
public class Main10139 {
	static int Primes[] = new int[6550];
	static int Len;

	/**
	 * - Pregenerados
	 * - Factorial
	 * - N�meros Primos
	 */
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int a, b;
		getprime();
		while (input.hasNext()) {
			a = input.nextInt();
			b = input.nextInt();
			int temp = b, dim, sumdim;
			boolean flag = true;
			if (a == 0) {
				if (b == 1)
					System.out.println(b + " divides " + a + "!");// << endl;
				else
					System.out.println(b + " does not divide " + a + "!");// <<
																			// endl;
				continue;
			}
			if (b == 0) {
				System.out.println(b + " does not divide " + a + "!");// <<
																		// endl;
				continue;
			}

			for (int i = 0; Primes[i] * Primes[i] <= temp && i < Len; ++i) {
				dim = 0;
				while (temp % Primes[i] == 0) {
					dim++;
					temp /= Primes[i];
				}
				if (dim > 0) {
					sumdim = 0;
					for (int j = Primes[i]; j <= a; j *= Primes[i])
						sumdim += a / j;
					if (dim > sumdim) {
						flag = false;
						break;
					}
				}
			}

			if (temp == b || temp != 1) // b 是一个质数 或temp是质数
			{
				if (a < temp)
					flag = false;
			}
			if (flag)
				System.out.println(b + " divides " + a + "!");// << endl;
			else
				System.out.println(b + " does not divide " + a + "!");// <<
																		// endl;
		}
		input.close();
	}

	static void getprime() {
		boolean flag[] = new boolean[65537];// = { false };
		for (int i = 2; i < 65537; ++i)
			if (!flag[i])
				for (int j = i + i; j < 65537; j += i)
					flag[j] = true;

		for (int i = 2; i < 65537; ++i)
			if (!flag[i])
				Primes[Len++] = i;
	}
}
