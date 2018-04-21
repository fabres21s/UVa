import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
*	13275 - Leap Birthdays
*
*	Submission:	21155577
*	Date:		2018-04-17 19:28:00
*	Runtime:	0.040
*	Ranking:	161
*/
public class Main13275 {

	/**
	 * -  Calendario
	 * 
	 * Dada una fecha de nacimiento de una persona y el año actual, determinar cuántas
	 * veces ha cumplido años esa persona, teniendo en cuenta
	 * que si nace el 29 de febrero, cumplirá cada 4 años
	 * 
	 */
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testCases = Integer.parseInt(br.readLine());
		StringBuffer output = new StringBuffer();
		
		int day, month, birthYear, finalYear, answer;
		int test = 0;
		while (testCases-- > 0) {
			args = br.readLine().split(" ");
			day = Integer.parseInt(args[0]);
			month = Integer.parseInt(args[1]);
			birthYear = Integer.parseInt(args[2]);
			finalYear = Integer.parseInt(args[3]);
			
			answer = finalYear - birthYear;
			
			if (isLeapYear(birthYear)) {
				if (day == 29 && month == 2) {
					answer = finalYear/4 + finalYear/400 - finalYear/100 - (birthYear/4 +birthYear/400 - birthYear/100);
				}
				
			}
			output.append("Case "+(++test)+": ");
			output.append(answer);
			output.append("\n");
		}
		System.out.print(output);
		
	}
	
	static boolean isLeapYear(int x) {
		if ((x % 4 == 0) && ((x % 100 != 0) || (x % 400 == 0)))
			return true;
		return false;
	}

}
