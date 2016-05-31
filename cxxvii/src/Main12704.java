import java.util.Scanner;

/**
*	12704 - Little Masters
*
*
*	Submision:	16391116
*	Date:		2015-11-05 13:34:47
*	Runtime:	0.112
*	Ranking:	1268
*/
public class Main12704 {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		int casos = input.nextInt();
		double x, y, r, dc;
		while (casos-- > 0) {
			x = input.nextInt();
			y = input.nextInt();
			r = input.nextInt();

			dc = Math.sqrt(x * x + y * y);

			System.out.printf("%.2f %.2f\n", (r - dc), (r + dc));
		}
		input.close();
	}

}
