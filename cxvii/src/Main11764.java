import java.util.Scanner;

/**
*	11764 - Jumping Mario
*
*
*	Submision:	9849751
*	Date:		2012-03-12 16:32:16
*	Runtime:	0.192
*	Ranking:	9040
*/
public class Main11764 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int k, i, j, high, low;
		k = input.nextInt() + 1;
		for (i = 1; i < k; i++) {
			high = low = 0;
			int[] walls = new int[input.nextInt()];
			walls[0] = input.nextInt();
			for (j = 1; j < walls.length; j++) {
				// System.out.println(walls.length);
				walls[j] = input.nextInt();
				if (walls[j] > walls[j - 1]) {
					// System.out.println(walls[j]+" > "+walls[j-1]);
					high++;
				} else if (walls[j] < walls[j - 1]) {
					low++;
					// System.out.println(walls[j]+" < "+walls[j-1]);
				}
			}
			System.out.printf("Case %d: %d %d\n", i, high, low);
		}
		input.close();
		// TODO Auto-generated method stub
	}
}
