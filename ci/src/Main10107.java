import java.util.Scanner;

/**
*	10107 - What is the Median?
*
*
*	Submission:	9670327
*	Date:		2012-01-23 15:05:39
*	Runtime:	2.096
*	Ranking:	14803 / 15581
*/
public class Main10107{

	/**
	 * - Estad�stica
	 */
	public static void main(String[] args) {
		/*
		 * Vector <Integer>v=new Vector<Integer>(); int x=0; Scanner input=new
		 * Scanner (System.in); while(input.hasNext()) { v.add(input.nextInt());
		 * Collections.sort(v); System.out.println(v.get(x));
		 * v.add(input.nextInt()); Collections.sort(v);
		 * System.out.println((v.get(x)+v.get(x+1))/2); x++; }
		 */

		int list[] = new int[10050];
		Scanner input = new Scanner(System.in);
		int IN, R, I;
		int C = 1;
		list[0] = -9999;
		while (input.hasNext()) {
			IN = input.nextInt();
			for (I = C++; IN < list[I - 1]; I--) {
				list[I] = list[I - 1];
			}
			list[I] = IN;

			if (C % 2 == 1) {
				R = ((list[C / 2] + list[C / 2 + 1]) / 2);
			} else {
				R = list[C / 2];
			}
			System.out.printf("%d\n", R);
		}
		input.close();
	}
}
