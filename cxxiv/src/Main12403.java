import java.util.Scanner;

/**
*	12403 - Save Setu
*
*
*	Submision:	10329061
*	Date:		2012-07-13 15:38:17
*	Runtime:	0.140
*	Ranking:	5316
*/
public class Main12403 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int n = input.nextInt(), total = 0;
		while (n > 0) {
			n--;
			if (input.next().equals("donate"))
				total += input.nextInt();
			else
				System.out.println(total);
		}
		input.close();

	}

}
