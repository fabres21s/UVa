import java.io.InputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
*	10037 - Bridge
*
*
*	Submision:	9362500
*	Date:		2011-10-12 12:39:21
*	Runtime:	1.064
*	Ranking:	2237
*/
public class Main10037 {
	Scanner in;
	PrintStream out;
	ArrayList<int[]> groupOfCrossTheBridgeHistory;
	int[] speedOfPeople;
	int totalSpeedOfCrossTheBridge;
	int countOfPeople;

	
	public Main10037(InputStream inputStream, PrintStream printStream) {
		in = new Scanner(inputStream);
		out = printStream;
		int countOfTestCase = in.nextInt();
		for (int i = 0; i < countOfTestCase; i++) {
			init();
			start();
			print(i);
		}
	}

	public void init() {
		totalSpeedOfCrossTheBridge = 0;
		countOfPeople = in.nextInt();
		speedOfPeople = new int[countOfPeople];
		groupOfCrossTheBridgeHistory = new ArrayList<int[]>(5000);
		for (int i = 0; i < countOfPeople; i++) {
			speedOfPeople[i] = in.nextInt();
		}
		Arrays.sort(speedOfPeople);
	}

	private void print(int testCaseNum) {
		if (testCaseNum > 0) {
			out.println();
		}
		out.println(totalSpeedOfCrossTheBridge);
		for (int[] groupOfPeople : groupOfCrossTheBridgeHistory) {
			for (int i = 0; i < groupOfPeople.length; i++) {
				if (i > 0) {
					out.print(" ");
				}
				out.print(groupOfPeople[i]);
			}
			out.println();
		}
	}

	public void start() {
		crossTheBridge(countOfPeople);
	}

	private void crossTheBridge(int endIndex) {
		if (endIndex == 1) {
			groupOfCrossTheBridgeHistory.add(new int[] { speedOfPeople[0] });
			totalSpeedOfCrossTheBridge += speedOfPeople[0];
		} else if (endIndex == 2) {
			groupOfCrossTheBridgeHistory.add(new int[] { speedOfPeople[0],
					speedOfPeople[1] });
			totalSpeedOfCrossTheBridge += speedOfPeople[1];
		} else if (endIndex == 3) {
			groupOfCrossTheBridgeHistory.add(new int[] { speedOfPeople[0],
					speedOfPeople[2] });
			groupOfCrossTheBridgeHistory.add(new int[] { speedOfPeople[0] });
			totalSpeedOfCrossTheBridge += speedOfPeople[2];
			totalSpeedOfCrossTheBridge += speedOfPeople[0];
			crossTheBridge(2);
		} else {
			crossTheBridgeLast2People(endIndex);
		}
	}

	private void crossTheBridgeLast2People(int endIndex) {
		int speedOfCase1 = speedOfPeople[1] * 2;
		int speedOfCase2 = speedOfPeople[0] + speedOfPeople[endIndex - 2];
		if (speedOfCase1 <= speedOfCase2) {
			groupOfCrossTheBridgeHistory.add(group(speedOfPeople[0],
					speedOfPeople[1]));
			groupOfCrossTheBridgeHistory.add(group(speedOfPeople[0]));
			groupOfCrossTheBridgeHistory.add(group(speedOfPeople[endIndex - 2],
					speedOfPeople[endIndex - 1]));
			groupOfCrossTheBridgeHistory.add(group(speedOfPeople[1]));
			int speedOfCrossABridge = speedOfPeople[0] + speedOfPeople[1] * 2
					+ speedOfPeople[endIndex - 1];
			totalSpeedOfCrossTheBridge += speedOfCrossABridge;
		} else {
			groupOfCrossTheBridgeHistory.add(group(speedOfPeople[0],
					speedOfPeople[endIndex - 1]));
			groupOfCrossTheBridgeHistory.add(group(speedOfPeople[0]));
			groupOfCrossTheBridgeHistory.add(group(speedOfPeople[0],
					speedOfPeople[endIndex - 2]));
			groupOfCrossTheBridgeHistory.add(group(speedOfPeople[0]));
			int speedOfCrossABridge = speedOfPeople[0] * 2
					+ speedOfPeople[endIndex - 2] + speedOfPeople[endIndex - 1];
			totalSpeedOfCrossTheBridge += speedOfCrossABridge;
		}
		crossTheBridge(endIndex - 2);
	}

	private int[] group(int... speedOfPeople) {
		return speedOfPeople;
	}

	/**
	 * - Simulación
	 * - Proceso matemático
	 * 
	 * Dadas unas personas, con sus velocidades y condiciones,
	 * hacerlas cruzar un puente en el menor tiempo posible
	 */
	public static void main(String[] args) {
		new Main10037(System.in, System.out);
	}
}
