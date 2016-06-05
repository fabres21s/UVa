import java.util.Scanner;

/**
*	11942 - Lumberjack Sequencing
*
*
*	Submision:	9719421
*	Date:		2012-02-07 20:15:54
*	Runtime:	0.168
*	Ranking:	5702
*/
public class Main11942 {

	/**
	 * TODO Asignar Categoría!!!
	 */
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int k = input.nextInt();
		System.out.println("Lumberjacks:");
		int i;
		while (k > 0) {
			k--;
			boolean asc = true, desc = true;
			int act, next;
			act = input.nextInt();
			for (i = 1; i < 10; i++) {
				next = input.nextInt();

				asc &= (next > act);
				desc &= (act > next);
				act = next;
			}
			System.out.println((asc || desc) ? "Ordered" : "Unordered");
		}
		input.close();
	}
}
