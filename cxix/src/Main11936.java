import java.util.Scanner;

/**
*	11936 - The Lazy Lumberjacks
*
*
*	Submision:	10732301
*	Date:		2012-10-14 00:30:05
*	Runtime:	0.124
*	Ranking:	3832
*/
public class Main11936 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int a, b, c, casos = input.nextInt();
		while (casos-- > 0) {
			a = input.nextInt();
			b = input.nextInt();
			c = input.nextInt();
			if ((a + b <= c || (a + c) <= b) || (b + c) <= a)
				System.out.println("Wrong!!");
			else
				System.out.println("OK");
		}
	}

}
