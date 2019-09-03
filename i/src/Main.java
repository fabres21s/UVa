import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

	// 116
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int rows, columns;
		while (input.hasNext()) {
			rows = input.nextInt();
			columns = input.nextInt();

			int array[][] = new int[rows][columns];

			for (int i = 0; i < rows; i++) {
				for (int j = 0; j < columns; j++) {
					array[i][j] = input.nextInt();
				}
			}

			solve(array);

		}

	}

	private static void solve(int[][] array) {

		int n = array[0].length;
		int m = array.length;

		int minors[][] = new int[m][n];
		for (int x = 0; x < m; x++) {
			minors[x][0] = array[x][0];
		}

		for (int j = 1; j < n; j++) {
			for (int i = 0; i < m; i++) {
				minors[i][j] = array[i][j]
						+ min3(minors[(i + m - 1) % m][j - 1], minors[i][j - 1], minors[(i + 1) % m][j - 1]);
			}
			
		}
		int min = minors[0][n - 1];
		for (int i = 1; i < m; i++) {
			min = Math.min(min, minors[i][n - 1]);
		}
		System.out.println(min);

	}

	private static int min3(int i, int j, int k) {
		return Math.min(i, Math.min(j, k));
	}

}
