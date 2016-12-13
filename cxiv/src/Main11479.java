import java.util.Scanner;

/**
*	11479 - Is this the easiest problem?
*
*
*	Submision:	9760474
*	Date:		2012-02-19 20:42:22
*	Runtime:	0.128
*	Ranking:	6423
*/
public class Main11479 {

	/**
	 * - Triángulos
	 * - Fórmula
	 */
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		long A, B, C;
		int k = input.nextInt(), i;
		for (i = 0; i < k; i++) {
			A = input.nextLong();
			B = input.nextLong();
			C = input.nextLong();
			System.out.printf("Case %d: ", i + 1);
			if (A + B <= C || B + C <= A || A + C <= B)
				System.out.printf("Invalid\n");
			else if (A == B) {
				if (B == C)
					System.out.printf("Equilateral\n");
				else
					System.out.printf("Isosceles\n");
			} else if (A == C || B == C)
				System.out.printf("Isosceles\n");
			else
				System.out.printf("Scalene\n");
		}
		input.close();
	}
}
