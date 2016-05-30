import java.util.Scanner;

/**
*	11172 - Relational Operator
*
*
*	Submision:	9567045
*	Date:		2011-12-16 20:49:40
*	Runtime:	0.380
*	Ranking:	26651
*/
public class Main11172 {

	/*
	 * 11172 - Relational Operator - Muy fácil Validar si un número es mayor,
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
		// TODO Auto-generated method stub
	}
}
