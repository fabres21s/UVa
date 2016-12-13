import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Scanner;

/**
*	11947 - Cancer or Scorpio
*
*
*	Submision:	16173741
*	Date:		2015-09-27 20:13:21
*	Runtime:	0.102
*	Ranking:	637
*/
public class Main11947 {

	/**
	 * - Calendario
	 * 
	 * Dada una fecha, sumarle 40 semanas, determinar en qué signo zodiacal cae
	 */
	public static void main(String[] args) {
		Calendar calendar = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");

		Scanner input = new Scanner(System.in);

		int casos = input.nextInt();
		String fecha = "";
		int dia, mes, anho;
		String signo = "";
		for (int i = 0; i < casos; i++) {
			fecha = input.next();
			mes = Integer.valueOf(fecha.substring(0, 2));
			dia = Integer.valueOf(fecha.substring(2, 4));
			anho = Integer.valueOf(fecha.substring(4, 8));

			calendar.set(Calendar.YEAR, anho);
			calendar.set(Calendar.MONTH, mes - 1);
			calendar.set(Calendar.DATE, dia);

			calendar.add(Calendar.WEEK_OF_YEAR, 40);

			mes = calendar.get(Calendar.MONTH) + 1;
			dia = calendar.get(Calendar.DATE);

			switch (mes) {
			case 1:
				if (dia > 20) {
					signo = "aquarius";
				} else {
					signo = "capricorn";
				}
				break;

			case 2:
				if (dia > 19) {
					signo = "pisces";
				} else {
					signo = "aquarius";
				}
				break;

			case 3:
				if (dia > 20) {
					signo = "aries";
				} else {
					signo = "pisces";
				}
				break;

			case 4:
				if (dia > 20) {
					signo = "taurus";
				} else {
					signo = "aries";
				}
				break;

			case 5:
				if (dia > 21) {
					signo = "gemini";
				} else {
					signo = "taurus";
				}
				break;

			case 6:
				if (dia > 21) {
					signo = "cancer";
				} else {
					signo = "gemini";
				}
				break;

			case 7:
				if (dia > 22) {
					signo = "leo";
				} else {
					signo = "cancer";
				}
				break;

			case 8:
				if (dia > 21) {
					signo = "virgo";
				} else {
					signo = "leo";
				}
				break;

			case 9:
				if (dia > 23) {
					signo = "libra";
				} else {
					signo = "virgo";
				}
				break;

			case 10:
				if (dia > 23) {
					signo = "scorpio";
				} else {
					signo = "libra";
				}
				break;

			case 11:
				if (dia > 22) {
					signo = "sagittarius";
				} else {
					signo = "scorpio";
				}
				break;

			case 12:
				if (dia > 22) {
					signo = "capricorn";
				} else {
					signo = "sagittarius";
				}
				break;
			}

			System.out.println((i + 1) + " " + sdf.format(calendar.getTime())
					+ " " + signo);
		}
		input.close();
	}

}
