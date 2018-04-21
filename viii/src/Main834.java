import java.util.Scanner;

/**
*	834 - Continued Fractions
*
*
*	Submission:	9893009
*	Date:		2012-03-21 19:28:48
*	Runtime:	0.112
*	Ranking:	5142
*/
public class Main834 {

	/**
	 * - Proceso matem�tico
	 */
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int n, m, k, d, temp;
		while (input.hasNext()) {
			n = input.nextInt();
			m = input.nextInt();
			System.out.printf("[%d;", n / m);
			k = n / m;
			d = n - m * k;
			while (true) {
				temp = m;
				m = d;
				d = temp;

				System.out.printf("%d", d / m);
				if (m == 1)
					break;
				k = d / m;
				d = d - k * m;
				System.out.print(",");
			}
			System.out.println("]");
		}
		input.close();
	}

}
