import java.util.Scanner;

/**
*	10042 - Smith Numbers
*
*
*	Submision:	9242715
*	Date:		2011-09-09 16:42:26
*	Runtime:	0.236
*	Ranking:	1775
*/
public class Main10042 {
	static int sum = 0;

	/**
	 * - Números Primos
	 * - Proceso matemático
	 */
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int cant = input.nextInt();
		int n;
		for (int i = 0; i < cant; i++) {
			n = input.nextInt();
			get(n);
		}
		input.close();
	}

	public static void get(int n) {
		while (true) {
			sum = 0;
			n++;
			if (!esprimo(n)) {
				if (smith(n)) {
					System.out.println(n);
					return;
				}
			}
		}
	}

	public static boolean esprimo(int num) {
		if (num == 2) {
			return true;
		}
		if (num % 2 == 0) {
			return false;
		}
		for (int i = 3; i <= Math.sqrt(num); i += 2) {
			if (num % i == 0) {
				return false;
			}
		}
		return true;
	}

	public static boolean smith(int num) {
		int tempSum = 0;
		int k = num;
		while (true) {
			if (k / 10 > 0) {
				tempSum += k % 10;
				k /= 10;
			} else {
				tempSum += k;
				break;
			}
		}
		for (int i = 2; i <= (int) Math.sqrt(num);) {
			if (num % i == 0) {
				sumatoria(i);
				num = num / i;
			} else
				i++;
		}
		sumatoria(num);
		if (sum == tempSum)
			return true;
		return false;
	}

	public static void sumatoria(int i) {
		while (true) {
			if (i / 10 > 0) {
				sum += i % 10;
				i /= 10;
			} else {
				sum += i;
				break;
			}
		}
	}
}
