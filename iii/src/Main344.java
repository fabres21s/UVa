import java.util.Scanner;

/**
*	344 - Roman Digititis
*
*
*	Submision:	9573594
*	Date:		2011-12-19 01:42:26
*	Runtime:	0.148
*	Ranking:	6024
*/
public class Main344 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int i, v, x, l, c, n, j;
		while ((n = input.nextInt()) != 0) {
			i = v = l = x = c = 0;
			for (j = 1; j <= n; j++) {
				switch (j % 10) {
				case 0:
					break;
				case 1:
					i++;
					break;

				case 2:
					i += 2;
					break;

				case 3:
					i += 3;
					break;

				case 4:
					i++;
					v++;
					break;

				case 5:
					v++;
					break;

				case 6:
					v++;
					i++;
					break;

				case 7:
					v++;
					i += 2;
					break;

				case 8:
					v++;
					i += 3;
					break;

				case 9:
					i++;
					x++;
					break;
				}
				switch (j / 10) {
				case 0:
					break;
				case 1:
					x++;
					break;

				case 2:
					x += 2;
					break;

				case 3:
					x += 3;
					break;

				case 4:
					x++;
					l++;
					break;

				case 5:
					l++;
					break;

				case 6:
					l++;
					x++;
					break;

				case 7:
					l++;
					x += 2;
					break;

				case 8:
					l++;
					x += 3;
					break;

				case 9:
					x++;
					c++;
					break;

				case 10:
					c++;
					break;
				}
			}
			System.out.printf("%d: %d i, %d v, %d x, %d l, %d c\n", n, i, v, x,
					l, c);
		}
		// TODO Auto-generated method stub
	}
}
