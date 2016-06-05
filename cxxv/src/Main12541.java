import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
*	12541 - Birthdates
*
*
*	Submision:	12306643
*	Date:		2013-09-06 17:16:15
*	Runtime:	0.222
*	Ranking:	1302
*/
public class Main12541 {

	/**
	 * - Calendario
	 * - Map
	 */
	public static void main(String[] args) throws ParseException {
		// GregorianCalendar calendar = new GregorianCalendar();
		//
		// if (calendar.isLeapYear(2007))
		// System.out.println("El a�o es bisiesto");
		// else
		// System.out.println("El a�o no es bisiesto");

		ArrayList<Date> fechas = new ArrayList<Date>();
		Map<Date, String> nombres = new HashMap<Date, String>();
		Scanner input = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyy");
		int casos = input.nextInt();
		int x = casos - 1;
		String fecha, nombre;
		Date date;
		while (casos-- > 0) {
			nombre = input.next();
			fecha = input.next() + "-" + input.next() + "-" + input.next();
			date = sdf.parse(fecha);
			fechas.add(date);
			nombres.put(date, nombre);
		}
		Collections.sort(fechas);
		System.out.println(nombres.get(fechas.get(x)));
		System.out.println(nombres.get(fechas.get(0)));
		input.close();

	}

}
