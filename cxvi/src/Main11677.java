import java.io.IOException;
import java.util.Scanner;

/**
*	11677 - Alarm Clock
*
*
*	Submision:	16495717
*	Date:		2015-11-26 15:57:27
*	Runtime:	0.086
*	Ranking:	4317
*/
public class Main11677 {

	/**
	 * - Proceso matemático
	 * 
	 * Ver cuantos minutos faltan desde una hora inicial a una hora final
	 */
	public static void main(String[] args) throws IOException {

		Scanner input = new Scanner(System.in);
		int hi, mi, hf, mf;
		int  t;
		while (input.hasNext()) {
			hi = input.nextInt() * 60;
			mi = input.nextInt();

			hf = input.nextInt() * 60;
			mf = input.nextInt();

			if (hi == 0 && mi == hi && mf == hi && hf == hi) {
				break;
			}
			t = (hf + mf) - (hi + mi);

			if (t < 0) {
				t = 1440 + t;
			}

			if (t > 1440) {
				t = 1440 - t;
			}
			System.out.println(t);

		}

		input.close();
	}

}
