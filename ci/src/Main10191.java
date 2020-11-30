import java.io.InputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.Scanner;

/**
*	10191 - Longest Nap
*
*
*	Submission:	9362476
*	Date:		2011-10-12 12:30:42
*	Runtime:	0.232
*	Ranking:	3760 / 3819
*/
class Schedule implements Comparable<Schedule> {
	public String startTime;
	public String endTime;

	public Schedule(String startTime, String endTime) {
		this.startTime = startTime;
		this.endTime = endTime;
	}

	@Override
	public int compareTo(Schedule otherSchedule) {
		return startTime.compareTo(otherSchedule.startTime);
	}

	public int minus(Schedule beforeSchedule) {
		int currentStartTime = toMinutes(startTime);
		int beforeEndTime = toMinutes(beforeSchedule.endTime);
		return currentStartTime - beforeEndTime;
	}

	public static int toMinutes(String time) {
		String[] splitedTime = time.split(":");
		return Integer.parseInt(splitedTime[0]) * 60
				+ Integer.parseInt(splitedTime[1]);
	}
}

public class Main10191 {
	Scanner in;
	PrintStream out;
	Schedule[] scheduleArray;
	String napStartTime;
	int maxNapTime;
	int day = 0;

	public Main10191(InputStream inputStream, PrintStream printStream) {
		in = new Scanner(inputStream);
		out = printStream;
		while (in.hasNext()) {
			day++;
			init();
			start();
			print();
		}
	}

	public void init() {
		int scheduleCount = in.nextInt();
		scheduleArray = new Schedule[scheduleCount + 2];
		maxNapTime = 0;
		for (int i = 0; i < scheduleCount; i++) {
			scheduleArray[i] = new Schedule(in.next(), in.next());
			in.nextLine();
		}
		// start()
		scheduleArray[scheduleCount] = new Schedule("00:00", "10:00");
		scheduleArray[scheduleCount + 1] = new Schedule("18:00", "00:00");
		// startTime
		Arrays.sort(scheduleArray);
	}

	public void start() {
		Schedule beforeTime = scheduleArray[0];
		Schedule currentTime;
		int timeGap;
		for (int i = 1; i < scheduleArray.length; i++) {
			currentTime = scheduleArray[i];
			timeGap = currentTime.minus(beforeTime);
			if (timeGap > maxNapTime) {
				maxNapTime = timeGap;
				napStartTime = beforeTime.endTime;
			}
			beforeTime = currentTime;
		}
	}

	private void print() {
		String formatedString1 = "Day #%d: the longest nap starts at %s and will last for %d minutes.";
		String formatedString2 = "Day #%d: the longest nap starts at %s and will last for %d hours and %d minutes.";
		if (maxNapTime < 60) {
			out.println(String.format(formatedString1, day, napStartTime,
					maxNapTime));
		} else {
			out.println(String.format(formatedString2, day, napStartTime,
					maxNapTime / 60, maxNapTime % 60));
		}
	}

	/**
	 * - Sort
	 */
	public static void main(String[] args) {
		new Main10191(System.in, System.out);
	}
}