import java.util.Scanner;

/**
*	10656 - Maximum Sum (II)
*
*
*	Submission:	9673622
*	Date:		2012-01-25 01:41:43
*	Runtime:	2.308
*	Ranking:	2905
*/
public class Main10656 {
	static int v[] = new int[1024];

	/**
	 *  - Proceso matem�tico
	 */
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int n;
		int a[] = new int[1000 + 10];

		while ((n = input.nextInt()) > 0) {

			boolean space = false;

			for (int i = 0; i < n; i++) {
				a[i] = input.nextInt();
			}

			for (int i = 0; i < n; i++) {
				if (a[i] > 0) {
					if (space)
						System.out.printf(" ");
					space = true;
					System.out.printf("%d", a[i]);
				}
			}

			if (!space)
				System.out.printf("0");

			System.out.printf("\n");
		}
		input.close();

	}

}
