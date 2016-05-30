import java.util.Scanner;
import java.util.Vector;

/**
*	10110 - Light, more light
*
*
*	Submision:	9216370
*	Date:		2011-09-02 22:07:24
*	Runtime:	1.400
*	Ranking:	11760
*/
public class Main10110 {
	static Vector<Integer> v = new Vector<Integer>();

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		long r;
		double root, num;
		while ((num = input.nextLong()) != 0) {
			r = (long) Math.sqrt(num);
			root = Math.pow(r, 2);
			if (root == num) {
				System.out.println("yes");
			} else {
				System.out.println("no");
			}
		}
		input.close();
		// TODO Auto-generated method stub
	}
}
