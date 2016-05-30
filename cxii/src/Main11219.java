import java.util.Scanner;

/**
*	11219 - How old are you?
*
*
*	Submision:	9849534
*	Date:		2012-03-12 15:46:56
*	Runtime:	0.252
*	Ranking:	4117
*/
public class Main11219 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int da, ma, ya, k, i, dn, mn, yn, age;
		k = input.nextInt() + 1;
		for (i = 1; i < k; i++) {
			args = input.next().split("/");
			age = -1;
			da = Integer.valueOf(args[0]);
			ma = Integer.valueOf(args[1]);
			ya = Integer.valueOf(args[2]);
			args = input.next().split("/");
			dn = Integer.valueOf(args[0]);
			mn = Integer.valueOf(args[1]);
			yn = Integer.valueOf(args[2]);
			if (ya < yn)
				System.out.printf("Case #%d: Invalid birth date\n", i);
			else if (ya == yn) {
				if (ma > mn)
					System.out.printf("Case #%d: 0\n", i);
				else if (ma == mn) {
					if (da < dn)
						System.out.printf("Case #%d: Invalid birth date\n", i);
					else
						System.out.printf("Case #%d: 0\n", i);
				} else
					System.out.printf("Case #%d: Invalid birth date\n", i);
			} else {
				age = ya - yn;
				if (mn > ma)
					age--;
				else if (mn == ma)
					if (da < dn)
						age--;
				if (age > 130)
					System.out.printf("Case #%d: Check birth date\n", i);
				else
					System.out.printf("Case #%d: %d\n", i, age);
			}
		}
		input.close();
		// TODO Auto-generated method stub

	}

}
