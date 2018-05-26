import java.io.IOException;
import java.util.Scanner;

public class Main1347 {

	static double x[], y[];

	public static void main(String[] args) throws IOException {

		Scanner input = new Scanner(System.in);

		int i, j;

		double f[][] = new double[3005][3005];
		while (input.hasNext()) {

			int totalPoints = input.nextInt();
			x = new double[totalPoints + 1];
			y = new double[totalPoints + 1];
			for (i = 1; i <= totalPoints; ++i) {

				x[i] = input.nextDouble();
				y[i] = input.nextDouble();
			}
			for (i = 1; i <= totalPoints; ++i)
				for (j = i; j <= totalPoints; ++j)
					f[i][j] = 1e60;
			f[1][1] = 0;
			for (i = 1; i < totalPoints; ++i)
				for (j = i; j < totalPoints; ++j) {
					f[i][j + 1] = Math.min(f[i][j + 1], f[i][j] + dis(j, j + 1));
					f[j][j + 1] = Math.min(f[j][j + 1], f[i][j] + dis(i, j + 1));
				}
			System.out.printf("%.2f\n", f[totalPoints - 1][totalPoints] + dis(totalPoints - 1, totalPoints));

		}
		input.close();

	}

	static double dis(int i, int j) {
		return Math.sqrt(Math.pow(x[i] - x[j], 2) + Math.pow(y[i] - y[j], 2));
	}

}
