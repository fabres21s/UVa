import java.util.Scanner;


/**
*	256 - Quirksome Squares
*
*
*	Submision:	9573530
*	Date:		2011-12-19 00:59:08
*	Runtime:	0.120
*	Ranking:	5218
*/
public class Main256 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int n;
		while (input.hasNext()) {
			n = input.nextInt();
			switch (n) {
			case 2:
				System.out.println("00\n01\n81");
				break;

			case 4:
				System.out.println("0000\n0001\n2025\n3025\n9801");
				break;

			case 6:
				System.out.println("000000\n000001\n088209\n494209\n998001");
				break;

			case 8:
				System.out
						.println("00000000\n00000001\n04941729\n07441984\n24502500\n25502500\n52881984\n60481729\n99980001");
				break;
			}
		}
		// TODO Auto-generated method stub
	}
}
