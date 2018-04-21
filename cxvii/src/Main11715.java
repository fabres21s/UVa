import java.util.Scanner;

/**
*	11715 - Car
*
*
*	Submission:	10733955
*	Date:		2012-10-14 12:24:43
*	Runtime:	0.184
*	Ranking:	3703
*/
public class Main11715 {

	/**
	 * - F�rmula
	 */
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		double vf, vi, a, x, t, r1 = -4, r2 = -1;
		int n, casos = 1;
		while ((n = input.nextInt()) != 0) {
			switch (n) {
			case 1:
				vi = input.nextDouble();
				vf = input.nextDouble();
				t = input.nextDouble();
				r2 = (vf - vi) / t;
				// System.out.println(r2);
				// System.out.println((vf*vf-(vi*vi)));
				r1 = (vf * vf - (vi * vi)) / (2 * r2);
				break;
			case 2:
				vi = input.nextDouble();
				vf = input.nextDouble();
				a = input.nextDouble();
				r1 = (vf * vf - vi * vi) / (2 * a);
				r2 = (vf - vi) / a;
				break;
			case 3:
				vi = input.nextDouble();
				a = input.nextDouble();
				x = input.nextDouble();
				r1 = Math.sqrt(2 * a * x + vi * vi);
				r2 = (r1 - vi) / a;
				break;
			case 4:
				vf = input.nextDouble();
				a = input.nextDouble();
				x = input.nextDouble();
				r1 = Math.sqrt(vf * vf - 2 * a * x);
				r2 = (vf - r1) / a;
				break;
			}
			System.out.printf("Case %d: %.3f %.3f\n", casos, r1, r2);
			casos++;
		}
		input.close();

	}

}
