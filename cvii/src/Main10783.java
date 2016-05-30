import java.util.Scanner;

/**
*	10783 - Odd Sum
*
*
*	Submision:	9521413
*	Date:		2011-11-30 17:52:01
*	Runtime:	0.160
*	Ranking:	19142
*/
public class Main10783 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] arreglo = new int[100];
		arreglo[1] = 1;
		for (int i = 3; i < 101; i += 2) {
			arreglo[i] = i + arreglo[i - 2];
		}
		Scanner input = new Scanner(System.in);
		int casos = input.nextInt();
		int a, b;
		for (int i = 1; i <= casos; i++) {
			a = input.nextInt();
			b = input.nextInt();
			if (a % 2 == 0) {
				a++;
			}
			if (b % 2 == 0) {
				b--;
			}
			if (a == 1) {
				System.out.println("Case " + i + ": " + arreglo[b]);
				continue;
			}
			System.out.println("Case " + i + ": "
					+ (arreglo[b] - arreglo[a - 2]));
		}
		input.close();
		// TODO Auto-generated method stub
	}

}
