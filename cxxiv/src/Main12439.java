import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
*	12439 - February 29
*
*
*	Submission:	12307424
*	Date:		2013-09-06 20:30:06
*	Runtime:	0.509
*	Ranking:	799
*/
public class Main12439 {

	/**
	 * - Calendario
	 */
	public static void main(String[] args) {
		Map<String, Integer> months = new HashMap<String, Integer>();
		months.put("January", 1);
		months.put("February", 2);
		months.put("March", 3);
		months.put("April", 4);
		months.put("May", 5);
		months.put("June", 6);
		months.put("July", 7);
		months.put("August", 8);
		months.put("September", 9);
		months.put("October", 10);
		months.put("November", 11);
		months.put("December", 12);

		Scanner input = new Scanner(System.in);
		int casos = input.nextInt();
		int mes, anho;
		int mes2, anho2, leapYear, dia2;

		for (int i = 1; i <= casos; i++) {
			leapYear = 1;

			mes = months.get(input.next());
			input.next();
			anho = input.nextInt();

			mes2 = months.get(input.next());
			dia2 = Integer.valueOf(input.next().replace(",", ""));
			anho2 = input.nextInt();

			leapYear = anho2 / 4 + anho2 / 400 - anho2 / 100
					- (anho / 4 + anho / 400 - anho / 100);

			if (bisiesto(anho)) {
				if (mes < 3) {
					leapYear++;
				}
			}

			if (bisiesto(anho2)) {
				if (mes2 == 1 || (mes2 == 2 && dia2 < 29)) {
					leapYear--;
				}
			}

			/*
			 * if(mes>2){ leapYear--; } if(mes2<=2 &&dia2<29){ leapYear--; }
			 */

			System.out.printf("Case %d: %d\n", i, leapYear);
		}
		input.close();

	}

	static boolean bisiesto(int x) {
		if ((x % 4 == 0) && ((x % 100 != 0) || (x % 400 == 0)))
			return true;
		return false;
	}

}
