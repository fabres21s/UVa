import java.util.Scanner;

/**
*	300 - Maya Calendar
*
*
*	Submission:	9593990
*	Date:		2011-12-27 00:00:34
*	Runtime:	0.540
*	Ranking:	2428
*/
public class Main300 {
	static String[] Haab = { "pop", "no", "zip", "zotz", "tzec", "xul",
			"yoxkin", "mol", "chen", "yax", "zac", "ceh", "mac", "kankin",
			"muan", "pax", "koyab", "cumhu", "uayet" };
	static String[] Tzolkin = { "imix", "ik", "akbal", "kan", "chicchan",
			"cimi", "manik", "lamat", "muluk", "ok", "chuen", "eb", "ben",
			"ix", "mem", "cib", "caban", "eznab", "canac", "ahau" };

	/**
	 * - Proceso matemático
	 */
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int casos = input.nextInt();

		System.out.println(casos);
		int yearhaab, monthhaab, dayhaab, yeartzolkin, monthtzolkin, daytzolkin, res;
		while (casos > 0) {
			casos--;
			dayhaab = Integer.parseInt(input.next().replace(".", ""));
			monthhaab = posicion(input.next());
			yearhaab = input.nextInt();
			res = 365 * yearhaab + monthhaab * 20 + dayhaab;
			yeartzolkin = res / 260;
			res %= 260;
			monthtzolkin = res % 20;
			daytzolkin = res % 13 + 1;
			System.out.printf("%d %s %d\n", daytzolkin, Tzolkin[monthtzolkin],
					yeartzolkin);
		}
		input.close();
	}

	static int posicion(String valor) {
		int i = 0;
		while (!Haab[i].equals(valor)) {
			i++;
		}
		return i;
	}

}
