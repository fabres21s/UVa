import java.util.Scanner;

/**
*	11799 - Horror Dash
*
*
*	Submision:	10707714
*	Date:		2012-10-09 15:33:59
*	Runtime:	0.296
*	Ranking:	9887
*/
public class Main11799 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int casos = input.nextInt() + 1, x, max, j;
		for (int i = 1; i < casos; i++) {
			x = input.nextInt();
			max = -1;
			while (x-- > 0) {
				j = input.nextInt();
				if (j > max)
					max = j;
			}
			System.out.printf("Case %d: %d\n", i, max);
		}
		input.close();
		// TODO Auto-generated method stub

	}

}
