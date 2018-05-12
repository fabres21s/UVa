import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main1098 {
	// TODO No enviado
	static int FILAS = 0;
	static int COLUMNAS = 6;
	static int count = 0;
	static int[][] priority;
	static int r1, c1, r2, c2, r3, c3, s1, s2, s3;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String line;
		while (!(line = br.readLine()).equals("0 0")) {

			args = line.split(" ");
			FILAS = Integer.parseInt(args[0]);
			COLUMNAS = Integer.parseInt(args[1]);

			int[][] array = new int[FILAS][COLUMNAS];
			priority = new int[FILAS][COLUMNAS];

			array[0][0] = 1;
			array[1][0] = 2;

			priority[0][1] = FILAS * COLUMNAS;

			args = br.readLine().split(" ");
			r1 = Integer.parseInt(args[0]);
			c1 = Integer.parseInt(args[1]);
			s1 = priority[r1][c1] = FILAS * COLUMNAS / 4;

			r2 = Integer.parseInt(args[2]);
			c2 = Integer.parseInt(args[3]);
			s2 = priority[r2][c2] = FILAS * COLUMNAS / 2;

			r3 = Integer.parseInt(args[4]);
			c3 = Integer.parseInt(args[5]);
			s3 = priority[r3][c3] = 3 * FILAS * COLUMNAS / 4;

			long t = System.currentTimeMillis();
			count = 0;
			solve(1, 0, array, 2);
			System.out.println(System.currentTimeMillis() - t);
			System.out.println("count >> " + count);
		}

	}

	private static void solve(int i, int j, int[][] array, int step) {

		if (step == FILAS * COLUMNAS) {

			count++;
			//System.out.println(count);
			return;
		}

		if (priority[i][j] != 0 && priority[i][j] != step) {
			return;
		}

		// if reached checkpoints before time
		if (i == r1 && j == c1 && step != s1)
			return;
		if (i == r2 && j == c2 && step != s2)
			return;
		if (i == r3 && j == c3 && step != s3)
			return;
		// if didn't reach checkpoints on time
		if (step == s1 && (i != r1 || j != c1))
			return;
		if (step == s2 && (i != r2 || j != c2))
			return;
		if (step == s3 && (i != r3 || j != c3))
			return;

		if (step < s1 && manhattan(i, j, r1, c1) > (s1 - step))
			return;
		if (step < s2 && manhattan(i, j, r2, c2) > (s2 - step))
			return;
		if (step < s3 && manhattan(i, j, r3, c3) > (s3 - step))
			return;

		if (i - 1 > -1) {

			if (array[i - 1][j] == 0) {
				array[i][j] = step;
				solve(i - 1, j, array, step + 1);

				array[i][j] = 0;

			}
		}
		if ((i + 1) < FILAS) {

			if (array[i + 1][j] == 0) {
				array[i][j] = step;
				solve(i + 1, j, array, step + 1);
				array[i][j] = 0;
			}

		}
		if ((j - 1) > -1) {
			if (array[i][j - 1] == 0) {
				array[i][j] = step;
				solve(i, j - 1, array, step + 1);
				array[i][j] = 0;
			}
		}
		if ((j + 1) < COLUMNAS) {
			if (array[i][j + 1] == 0) {
				array[i][j] = step;
				solve(i, j + 1, array, step + 1);
				array[i][j] = 0;

			}
		}

		array[i][j] = 0;

	}

	public static int manhattan(int x1, int y1, int x2, int y2) {
		return Math.abs(x1 - x2) + Math.abs(y1 - y2);
	}

}
