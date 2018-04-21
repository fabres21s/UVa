import java.util.Scanner;

/**
*	11172 - Relational Operator
*
*
*	Submission:	9567045
*	Date:		2011-12-16 20:49:40
*	Runtime:	0.380
*	Ranking:	26651
*/
public class Main11172 {

	/**
	 * - Muy f�cil
	 * 
	 * Muy f�cil Validar si un n�mero es mayor,
	 * menor o igual a otro
	 */
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int casos = input.nextInt(), a, b;
		while (casos > 0) {
			casos--;
			a = input.nextInt();
			b = input.nextInt();
			if (a > b) {
				System.out.println(">");
			} else if (a < b) {
				System.out.println("<");
			} else {
				System.out.println("=");
			}
		}
		input.close();
	}
}
