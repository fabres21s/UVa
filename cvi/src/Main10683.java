import java.util.Scanner;

/**
*	10683 - The decadary watch
*
*
*	Submision:	10310997
*	Date:		2012-07-09 14:50:00
*	Runtime:	2.020
*	Ranking:	1485
*/
public class Main10683 {

	/**
	 * - Calendario
	 */
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		char[] p;
		int total;
		while (input.hasNext())// validar lo de los 0's
		{
			p = input.next().toCharArray();
			total = (((p[0] - 48) * 10 + p[1] - 48) * 360000
					+ ((p[2] - 48) * 10 + p[3] - 48) * 6000
					+ ((p[4] - 48) * 10 + p[5] - 48) * 100 + ((p[6] - 48) * 10
					+ p[7] - 48)) * 125;
			System.out.println(completar(total / 108));
		}
		input.close();

	}

	static String completar(int i) {
		String cad = String.valueOf(i);
		int dif = 7 - cad.length();
		for (int k = 0; k < dif; k++)
			cad = "0" + cad;
		return cad;
	}

}
