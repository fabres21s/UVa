import java.util.Scanner;

/**
*	12015 - Doom's Day Algorithm
*
*
*	Submision:	9508824
*	Date:		2011-11-26 16:37:45
*	Runtime:	0.220
*	Ranking:	1420
*/
public class Main12019 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String days[] = { "Sunday", "Monday", "Tuesday", "Wednesday",
				"Thursday", "Friday", "Saturday" };
		int nums[] = { 0, 5, 1, 1, 4, 6, 2, 4, 0, 3, 5, 1, 3 };
		Scanner input = new Scanner(System.in);
		int casos = input.nextInt(), dia, mes;
		while (casos > 0) {
			casos--;
			mes = input.nextInt();
			dia = input.nextInt();
			System.out.println(days[(dia + nums[mes]) % 7]);
		}

	}

}
