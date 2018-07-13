import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
//12673
public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line;
		int matches, goals, goalsA, goalsB, diff, totalPoints;
		while ((line = br.readLine()) != null) {
			args = line.split(" ");

			matches = Integer.parseInt(args[0]);
			goals = Integer.parseInt(args[1]);
			int[] arrayDiff = new int[101];
			totalPoints = 0;

			for (int i = 0; i < matches; i++) {
				args = br.readLine().split(" ");
				goalsA = Integer.parseInt(args[0]);
				goalsB = Integer.parseInt(args[1]);

				diff = goalsB - goalsA;

				if (diff > -1) {
					arrayDiff[diff]++;
				}

				if (goalsA > goalsB) {
					totalPoints += 3;
				} else if (goalsA == goalsB) {
					totalPoints++;
				}
			}

			for (int i = 0; i < 100; i++) {
				while (arrayDiff[i] > 0 && goals > 0) {
					if (goals > i) {
						goals -= (i + 1);

						arrayDiff[i]--;
						if (i == 0) {
							totalPoints += 2;
						} else {
							totalPoints += 3;
						}
					} else if (goals == i) {
						goals -= i;
						arrayDiff[i]--;
						totalPoints++;
					} else {
						break;
					}

				}
			}
			System.out.println(totalPoints);
		}
	}

}
