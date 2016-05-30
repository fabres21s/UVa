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


public class Main {

	/**
	 * @param args
	 * @throws ParseException 
	 */
	public static void main(String[] args) throws ParseException {
//		GregorianCalendar calendar = new GregorianCalendar();
//
//		if (calendar.isLeapYear(2007))
//			System.out.println("El año es bisiesto");
//		else
//			System.out.println("El año no es bisiesto");
		
		ArrayList<Date> fechas= new ArrayList<Date>();
		Map <Date, String> nombres=new HashMap<Date,String>();
		Scanner input=new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyy");
		int casos=input.nextInt();
		int x=casos-1;
		String fecha, nombre;
		Date date;
		while(casos-->0){
			nombre=input.next();
			fecha=input.next()+"-"+input.next()+"-"+input.next();
			date=sdf.parse(fecha);
			fechas.add(date);
			nombres.put(date, nombre);
		}
		Collections.sort(fechas);
		System.out.println(nombres.get(fechas.get(x)));
		System.out.println(nombres.get(fechas.get(0)));
		input.close();
		// TODO Auto-generated method stub

	}

}
