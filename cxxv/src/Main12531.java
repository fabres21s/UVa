import java.util.Scanner;

/**
*	12531 - Hours and Minutes
*
*
*	Submission:	10894940
*	Date:		2012-11-16 15:53:58
*	Runtime:	0.196
*	Ranking:	1326
*/
public class Main12531 {

	/**
	 * - Muy f�cil
	 */
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		while (input.hasNext()) {
			if ((input.nextInt()) % 6 == 0)
				System.out.println("Y");
			else
				System.out.println("N");
		}
		input.close();
	}

}
