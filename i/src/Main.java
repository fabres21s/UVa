import java.awt.Point;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
	static int N = 3;
	static int ORDER = 9;
	static int[][][] sudoku = new int[ORDER][ORDER][ORDER + 1];

	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);
		for (int i = 0; i < ORDER; i++) {
			for (int j = 0; j < ORDER; j++) {
				sudoku[i][j][0] = input.nextInt();
			}
		}

		barrido();
		print();
	}

	private static void barrido() {

		for (int i = 0; i < ORDER; i++) {
			for (int j = 0; j < ORDER; j++) {
				int value = sudoku[i][j][0];
				if (value != 0) {

					// barido filas y columnas
					for (int x = 0; x < ORDER; x++) {
						sudoku[i][x][value] = value;
						sudoku[x][j][value] = value;

					}

					// barrido celdas
					// 0,1,2 -> 0 # 3,4,5 -> 3 # 6,7,8 -> 6
					int startCellRow = (i / N) * N;
					int startCellColumn = (j / N) * N;
					for (int p = startCellRow; p < startCellRow + N; p++) {
						for (int q = startCellColumn; q < startCellColumn + N; q++) {
							sudoku[p][q][value] = value;
						}
					}

					// sdas
					for (int p = 1; p < ORDER + 1; p++) {
						sudoku[i][j][p] = p;
						// sudoku[x][j][p] = p;
					}
				}
			}
		}

		for (int i = 0; i < ORDER; i++) {
			for (int j = 0; j < ORDER; j++) {
				if (sudoku[i][j][0] == 0) {
					int count = 0;
					int value = -1;
					for (int k = 1; k < ORDER + 1; k++) {
						if (sudoku[i][j][k] == 0) {
							count++;
							value = k;
						}
					}
					if (count == 1) {
						sudoku[i][j][0] = value;
						System.out.println("Barrido -- Se puso el valor " + value + " en la posicion " + (i) + "," + j);
						barrido();
					}
				}

			}
		}

		checkCells();

		checkRows();
		checkColumns();

	}

	private static void checkColumns() {
		Map<Integer, Point> map = new HashMap<Integer, Point>();
		for (int i = 0; i < ORDER; i++) {
			int array[] = new int[ORDER + 1];
			for (int j = 0; j < ORDER; j++) {
				for (int k = 1; k < ORDER + 1; k++) {
					if (sudoku[j][i][k] == 0) {
						array[k]++;
						map.put(k, new Point(i, j));
					}
				}
			}
			for (int z = 1; z < ORDER + 1; z++) {
				if (array[z] == 1) {
					Point point = map.get(z);
					sudoku[(int) point.getY()][(int) point.getX()][0] = z;
					System.out.println("Check Columns -- Se puso el valor " + z + " en la posicion " + (point.getY())
							+ "," + point.getX());
					barrido();
				}
			}

		}

	}

	private static void checkRows() {
		Map<Integer, Point> map = new HashMap<Integer, Point>();
		for (int i = 0; i < ORDER; i++) {
			int array[] = new int[ORDER + 1];
			for (int j = 0; j < ORDER; j++) {
				for (int k = 1; k < ORDER + 1; k++) {
					if (sudoku[i][j][k] == 0) {
						array[k]++;
						map.put(k, new Point(i, j));
					}
				}
			}
			for (int z = 1; z < ORDER + 1; z++) {
				if (array[z] == 1) {
					Point point = map.get(z);
					sudoku[(int) point.getX()][(int) point.getY()][0] = z;
					System.out.println("Check Rows -- Se puso el valor " + z + " en la posicion " + (point.getX()) + ","
							+ point.getY());
					barrido();
				}
			}

		}
	}

	private static void print() {
		for (int i = 0; i < ORDER; i += N) {
			for (int j = 0; j < ORDER; j += N) {

				for (int x = i; x < i + N; x++) {
					for (int y = j; y < j + N; y++) {

						System.out.println(Arrays.toString(sudoku[x][y]));
					}
					System.out.println("\n");
				}
			}
			System.out.println("\n");
		}

	}

	private static void checkCells() {
		Map<Integer, Point> map = new HashMap<Integer, Point>();
		for (int i = 0; i < ORDER; i += N) {
			for (int j = 0; j < ORDER; j += N) {

				int array[] = new int[ORDER + 1];
				for (int x = i; x < i + N; x++) {
					for (int y = j; y < j + N; y++) {
						for (int k = 1; k < ORDER + 1; k++) {
							if (sudoku[x][y][k] == 0) {
								array[k]++;

								if (array[k] == 1) {
									map.put(k, new Point(x, y));
								}
							}
						}
						// System.out.println(Arrays.toString(sudoku[x][y]));
					}
				}
				for (int z = 1; z < ORDER + 1; z++) {
					if (array[z] == 1) {
						Point point = map.get(z);
						sudoku[(int) point.getX()][(int) point.getY()][0] = z;
						System.out.println("Check Cells -- Se puso el valor " + z + " en la posicion " + (point.getX())
								+ "," + point.getY());
						barrido();
					}
				}

			}
		}

	}

}
