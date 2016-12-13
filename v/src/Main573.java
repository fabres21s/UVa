import java.util.Scanner;

/**
*	573 - The Snail
*
*
*	Submision:	16039673
*	Date:		2015-09-03 14:06:45
*	Runtime:	0.079
*	Ranking:	8034
*/
public class Main573 {

	/**
	 * - Simulación
	 */
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		double meta, sube, up, baja, fatiga, r;
		boolean success;
		int i;
		while (true) {
			meta = input.nextDouble();
			sube = input.nextDouble();
			baja = input.nextDouble();
			up = sube;
			i = 0;
			r = 0;
			fatiga = input.nextDouble() * sube / 100;
			if (meta == 0) {
				break;
			}
			success = false;
			while (true) {

				// if(up>=0){
				// r+=up;
				// }
				// if(r > meta){
				// success = true;
				// break;
				// }
				//
				// r -= baja;
				// if(r < 0){
				// //i++;
				// success = false;
				// break;
				// }
				//
				// i++;
				//
				// up -= fatiga;

				++i;
				if (i > 1)
					up -= fatiga;
				if (up >= 0)
					r += up;
				if (r > meta) {
					success = true;
					break;
				}
				r -= baja;
				if (r < 0)
					break;

			}
			if (success) {
				System.out.println("succes on day " + i);
			} else {
				System.out.println("failure on day " + i);
			}
		}
		input.close();

	}

}
