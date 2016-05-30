import java.util.Scanner;

/**
*	10424 - Love Calculator
*
*
*	Submision:	9728606
*	Date:		2012-02-10 14:49:56
*	Runtime:	0.196
*	Ranking:	7315
*/
public class Main10424 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String abc = " abcdefghijklmnopqrstuvwxyz";
		Scanner input = new Scanner(System.in);
		int v1, v2, i, k;
		char[] p1, p2;
		double a, b;
		while (input.hasNext()) {
			v1 = v2 = 0;
			p1 = input.nextLine().toLowerCase().toCharArray();
			p2 = input.nextLine().toLowerCase().toCharArray();
			for (i = 0; i < p1.length; i++) {
				k = abc.indexOf(p1[i]);
				if (k > 0)
					v1 += k;
			}
			for (i = 0; i < p2.length; i++) {
				k = abc.indexOf(p2[i]);
				if (k > 0)
					v2 += k;
			}
			// System.out.println(v2);
			a = (double) v1 % 9;
			b = (double) v2 % 9;
			if (a == 0) {
				a = 9;
			}
			if (b == 0) {
				b = 9;
			}
			// System.out.println(a+"   "+b+"  "+v1+"  "+v2);
			// System.out.println(v1+"   "+v2+"  "+descomponer(v1)+"   "+descomponer(v2));
			System.out.printf("%.2f %%\n",
					Math.min(a, b) * 100 / (Math.max(a, b)));
			// a=descomponer(v1);
		}
		input.close();
		// TODO Auto-generated method stub

	}

	/*
	 * private static double descomponer(int n) { int sum=0; while(n>0) {
	 * sum+=n%10; n/=10; } if(sum>10) return descomponer(sum); return
	 * (double)sum; // TODO Auto-generated method stub
	 * 
	 * }
	 */

}
