import java.util.Scanner;

/**
*	10071 - Back to High School Physics
*
*
*	Submission:	9314162
*	Date:		2011-09-29 20:51:17
*	Runtime:	1.600
*	Ranking:	50713 / 51389
*/
public class Main10071 {

	/**
	 * - Muy f�cil
	 * 
	 * Dadas la velocidad y el
	 * tiempo, hallar el espacio recorrido en el doble de ese tiempo
	 */
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		while (input.hasNext()) {
			int a = input.nextInt();
			int b = input.nextInt();
			System.out.println(2 * a * b);
		}
		input.close();
	}
}
