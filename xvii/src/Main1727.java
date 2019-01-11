import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/**
*	1727 - Counting Weekend Days
*
*	Submission:	22579830
*	Date:		2019-01-08 15:25:46
*	Runtime:	0.060
*	Ranking:	553
*/
public class Main1727 {

	/**
	 *  - Calendario
	 *  
	 *  Dados un mes y el primer día de la semana de ese mes, contar los viernes y sábados que tiene ese mes
	 */
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		Map<String, Integer> mapMonthsDays = new HashMap<String, Integer>();
		mapMonthsDays.put("JAN", 31);
		mapMonthsDays.put("FEB", 28);
		mapMonthsDays.put("MAR", 31);
		mapMonthsDays.put("APR", 30);
		mapMonthsDays.put("MAY", 31);
		mapMonthsDays.put("JUN", 30);
		mapMonthsDays.put("JUL", 31);
		mapMonthsDays.put("AUG", 31);
		mapMonthsDays.put("SEP", 30);
		mapMonthsDays.put("OCT", 31);
		mapMonthsDays.put("NOV", 30);
		mapMonthsDays.put("DEC", 31);

		String dayOfWeek[] = { "MON", "TUE", "WED", "THU", "FRI", "SAT", "SUN" };

		StringBuffer output = new StringBuffer();

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int testCases = Integer.parseInt(br.readLine());

		while (testCases-- > 0) {
			args = br.readLine().split(" ");

			int doomsDay = getDoomsDay(dayOfWeek, args[1]);
			int daysOfMonth = mapMonthsDays.get(args[0]);

			int firstFriday = ((doomsDay > 4) ? 12 : 5) - doomsDay;
			int firstSaturday = ((doomsDay > 5) ? 13 : 6) - doomsDay;

			output.append(String.format("%d\n",
					(1 + (daysOfMonth - firstFriday) / 7 + 1 + (daysOfMonth - firstSaturday) / 7)));

		}
		System.out.print(output);

	}

	private static int getDoomsDay(String[] dayOfWeek, String string) {
		for (int i = 0; i < dayOfWeek.length; i++) {
			if (dayOfWeek[i].equals(string)) {
				return i;
			}
		}
		return 0;
	}

}
