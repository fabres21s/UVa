import java.util.Scanner;


/**
*	278 - Chess
*
*
*	Submision:	9573550
*	Date:		2011-12-19 01:13:26
*	Runtime:	0.132
*	Ranking:	3343
*/
public class Main278 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int casos = input.nextInt(), m, n, d, x;
		String pieza;
		while (casos > 0) {
			casos--;
			pieza = input.next();
			m = input.nextInt();
			n = input.nextInt();
			if (pieza.equals("Q") || pieza.equals("r")) {
				System.out.println(Math.min(m, n));
			} else if (pieza.equals("K")) {
				d = Math.max(m, n);
				n = Math.min(m, n);
				x = d / 2;
				if (d % 2 > 0) {
					x++;
				}
				n -= n / 2;
				m = n * x;
				System.out.println(m);
			} else {
				d = m * n;
				x = d / 2;
				if (d % 2 > 0) {
					x++;
				}
				System.out.println(x);
			}
		}
		// TODO Auto-generated method stub
	}
}
