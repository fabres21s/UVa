import java.util.Scanner;

/**
*	12602 - Nice Licence Plates
*
*
*	Submision:	12306606
*	Date:		2013-09-06 17:02:34
*	Runtime:	0.182
*	Ranking:	1489
*/
public class Main12602 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int casos = input.nextInt();
		while (casos-- > 0) {
			args = input.next().split("-");
			char c[] = args[0].toCharArray();
			int sum = 0, exp = 2, mul = 0;
			for (int i = 0; i < c.length; i++) {
				if (exp == 2) {
					mul = 26 * 26;
				} else if (exp == 1) {
					mul = 26;
				} else {
					mul = 1;
				}
				sum += (c[i] - 65) * mul;
				exp--;
			}
			if (Math.abs((sum - Integer.valueOf(args[1]))) <= 100) {
				System.out.println("nice");
			} else {
				System.out.println("not nice");
			}
		}
		input.close();
		// TODO Auto-generated method stub

	}

}
