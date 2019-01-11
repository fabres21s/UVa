import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
*	602 - What Day Is It?
*
*	Submission:	22596137
*	Date:		2019-01-11 16:19:14
*	Runtime:	0.950
*	Ranking:	917
*/
public class Main602 {

	/**
	 * - Calendario
	 * 
	 *  Mostrar el día de la semana en una fecha dada, con la condición
	 *  que si la fecha es mayor a 1752/09/14, se usa el calendario gregoriano
	 *  si es menor a 1752/09/02, se usa el calendario juliano
	 *  y los días faltantes son inválidos
	 */
	public static void main(String[] args) throws NumberFormatException, IOException {
		String daysOfWeek[] = { "", "Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday" };
		String months[] = { "", "January", "February", "March", "April", "May", "June", "July", "August", "September",
				"October", "November", "December" };
		

		StringBuffer output = new StringBuffer();

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int month, day, year;
		boolean invalidDate = true, useJulianCalendar;
		while (true) {
			
			GregorianCalendar gregorianCalendar = new GregorianCalendar();
			GregorianCalendar julianCalendar = new GregorianCalendar();
			julianCalendar.setGregorianChange(new Date(Long.MAX_VALUE));

			useJulianCalendar = false;
			invalidDate = false;
			args = br.readLine().split(" ");

			month = Integer.parseInt(args[0]);
			day = Integer.parseInt(args[1]);
			year = Integer.parseInt(args[2]);

			if (month == 0 && day == 0 && year == 0) {
				break;
			}

			if (year == 1752 && month == 9 && (day > 2 && day < 14)) {
				// dias que no existieron
				invalidDate = true;
			} else if (year <= 1752) {
				if (year == 1752 && month == 9 && day < 3) {
					useJulianCalendar = true;
				} else if (year == 1752 && month < 9) {
					useJulianCalendar = true;
				} else if (year < 1752) {
					useJulianCalendar = true;
				}
			}

			if (!invalidDate) {
				int dayOfWeek = getDayOfWeek(useJulianCalendar ? julianCalendar : gregorianCalendar, year, month, day);

				if (dayOfWeek == -1) {
					invalidDate = true;
				} else {
					output.append(
							String.format("%s %d, %d is a %s\n", months[month], day, year, daysOfWeek[dayOfWeek]));
				}
			}

			if (invalidDate) {
				output.append(String.format("%d/%d/%d is an invalid date.\n", month, day, year));
			}
		}
		System.out.print(output);

	}

	private static int getDayOfWeek(GregorianCalendar calendar, int year, int month, int day) {
		calendar.set(year, month - 1, day);

		if (calendar.get(Calendar.YEAR) != year || calendar.get(Calendar.MONTH) != month - 1
				|| calendar.get(Calendar.DATE) != day) {
			return -1;
		}

		return (calendar.get(Calendar.DAY_OF_WEEK));
	}

}
