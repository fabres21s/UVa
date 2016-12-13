import java.io.IOException;
import java.util.Scanner;

/**
*	12461 - Airplane
*
*
*	Submision:	16456725
*	Date:		2015-11-18 20:52:31
*	Runtime:	0.139
*	Ranking:	910
*/
public class Main12461 {

	/**
	 * - Muy fácil
	 * 
	 * La probabilidad que la encuentre vacía siempre será 1/2 vacía u
	 * ocupada son las dos opciones
	 */
	public static void main(String[] args) throws IOException {

		Scanner input = new Scanner(System.in);

		while (( input.nextInt()) != 0) {
			System.out.println("1/2");
		}
		input.close();
	}

}
