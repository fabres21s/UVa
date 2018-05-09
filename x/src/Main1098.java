import java.util.Arrays;

public class Main1098 {
	// TODO No enviado
	static int FILAS = 3;
	static int COLUMNAS = 6;
	static int count = 0;
	// static Map<Integer, Point> priority = new HashMap<Integer, Point>();
	static int[][] priority;

	public static void main(String[] args) {

		int[][] array = new int[FILAS][COLUMNAS];
		priority = new int[FILAS][COLUMNAS];
		array[0][0] = 1;

		priority[2][1] = 4;
		priority[2][4] = 9;
		priority[0][1] = 18;
		priority[0][4] = 13;

		array[1][0] = 2;
		long t = System.nanoTime();
		solve(1, 0, array, 2);
		System.out.println(System.nanoTime() - t);
		System.out.println("count >> " + count);
	}

	private static void solve(int i, int j, int[][] array, int step) {

		if (priority[i][j] != 0 && priority[i][j] != step) {
			return;
		}

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

		if (step == FILAS * COLUMNAS) {
			array[i][j] = step;
			for (int[] array3 : array) {
				System.out.println(Arrays.toString(array3));
			}
			// count++;
			System.out.println("******* " + (++count));
		}

		array[i][j] = 0;

	}

}
