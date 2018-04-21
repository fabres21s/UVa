import java.util.Scanner;

/**
*	12503 - Robot Instructions
*
*
*	Submission:	10744520
*	Date:		2012-10-16 16:14:01
*	Runtime:	0.532
*	Ranking:	2749
*/
public class Main12503 {

	/**
	 * Simulaci�n
	 */
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int casos = input.nextInt(), moves;
		int actual, i;
		while (casos-- > 0) {
			moves = input.nextInt() + 1;
			int instrucciones[] = new int[moves];
			actual = 0;
			String accion;
			for (i = 1; i < moves; i++) {
				// System.out.println(Arrays.toString(instrucciones)+" "+actual);
				accion = input.next();
				if (accion.equals("LEFT")) {
					instrucciones[i] = -1;

				} else if (accion.equals("RIGHT")) {
					instrucciones[i] = 1;

				} else {
					input.next();
					instrucciones[i] = instrucciones[input.nextInt()];

				}
				actual += instrucciones[i];
				// System.out.println(actual);

			}
			System.out.println(actual);
		}
		input.close();

	}

}
