import java.util.Scanner;

/**
*	12015 - Google is Feeling Lucky
*
*
*	Submision:	9961586
*	Date:		2012-04-06 12:53:41
*	Runtime:	0.120
*	Ranking:	4684
*/
public class Main12015 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int[] relevances = new int[10];
		int max, i, j;
		String urls[] = new String[10];
		int k = input.nextInt() + 1;
		for (i = 1; i < k; i++) {
			max = -1;
			for (j = 0; j < 10; j++) {
				urls[j] = input.next();
				relevances[j] = input.nextInt();
				if (relevances[j] > max)
					max = relevances[j];
			}
			System.out.printf("Case #%d:\n", i);
			for (j = 0; j < 10; j++)
				if (relevances[j] == max)
					System.out.println(urls[j]);
		}
		// TODO Auto-generated method stub

	}

}
