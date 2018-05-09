import java.awt.Point;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Main1098 {
	// TODO No enviado
	static int FILAS = 3;
	static int COLUMNAS = 6;
	static int count = 0;
	static Map<Integer, Point> priority = new HashMap<Integer, Point>();

	public static void main(String[] args) {
		int[][] array = new int[FILAS][COLUMNAS];
		array[0][0] = 1;
		// solve(0, 0, array, 1);
		priority.put(4, new Point(2, 1));
		priority.put(9, new Point(2, 4));

		array[1][0] = 2;
		boot(array, 2, 1,0);
		

		// array[1][0] = 2;
		// array[2][0] = 3;
		// solve(2, 0, array, 3);
	}

	private static void boot(int[][] array, int step, int i, int j) {
		solve(i, j, array, step);
		
	}

	private static void solve(int i, int j, int[][] array, int step) {

		Point point = priority.get(step);
		if (point != null) {

			if (i == (int) point.getX() && (j == (int) point.getY())) {
				array[i][j] = step;
				priority.remove(step);
				boot(array, step, i, j);
//				if (i - 1 > -1) {
//					
//					if (array[i - 1][j] == 0) {
//						solve(i - 1, j, array, step + 1);
//					}
//				}
//
//				if ((i + 1) < FILAS) {
//
//					if (array[i + 1][j] == 0) {
//						
//						solve(i + 1, j, array, step + 1);
//					}
//
//				}
//
//				if ((j - 1) > -1) {
//					if (array[i][j - 1] == 0) {
//						solve(i, j - 1, array, step + 1);
//					}
//				}
//				if ((j + 1) < COLUMNAS) {
//					if (array[i][j + 1] == 0) {
//						solve(i, j + 1, array, step + 1);
//
//					}
//				}
				

			} else {
				for (int[] array3 : array) {
					//System.out.println(Arrays.toString(array3));
				}
				System.out.println("camino imposible");
			}
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
			System.out.println("******* " + (++count));
		}

		array[i][j] = 0;

	}

}
