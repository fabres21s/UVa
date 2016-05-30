import java.util.Scanner;

/**
*	636 - Squares (III)
*
*
*	Submision:	9611902
*	Date:		2012-01-02 16:51:01
*	Runtime:	0.120
*	Ranking:	1788
*/
public class Main636 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int i, sum, p, a, n, N;
		while ((n = input.nextInt()) != 0) {
			for (i = mayor(n); i < 100; i++) {
				sum = 0;
				p = 0;
				N = n;
				while (N > 0) {
					sum += (N % 10) * (Math.pow(i, p));
					N = N / 10;
					p++;
				}
				a = (int) Math.sqrt(sum);
				if (a * a == sum) {
					System.out.println(i);
					break;
				}
			}
		}
		// TODO Auto-generated method stub
	}

	private static int mayor(int n) {
		int max = -1;
		while (n > 0) {
			if (n % 10 > max) {
				max = n % 10;
			}
			n /= 10;
		}
		return max + 1;
		// TODO Auto-generated method stub
	}
}
