package concept;
import java.awt.Point;
import java.util.Arrays;
import java.util.Stack;

public class Main196 {

	int [][][]solutions = {
			{
				{0,7},{1,3}
			},
			{
				{0,7},{1,2}
			}
		};
	public static void main(String[] args) {
		int chessboard[][] = new int[8][8];
		Stack<Point> stackPoint = new Stack<Point>();
		int startColumn = 0;
		int s = 0;
		for (int i = 0; i < 8; i++) {

			boolean queenPut = false;
			for (int j = startColumn; j < 8; j++) {

				if (chessboard[i][j] == 0) {
					chessboard[i][j] = 8;
					marcarCasillas(i, j, 1, chessboard);
					queenPut = true;
					stackPoint.push(new Point(i, j));
					startColumn = 0;

					if (stackPoint.size() == 8) {
						s++;
						//print(chessboard);
						System.out.println("{");
						for (Point point : stackPoint) {
							System.out.print("{"+((int)point.getX() + 1)+ "," + ((int)point.getY()+1)+"},");
						}
						System.out.println();
						System.out.println("},");
						
						queenPut = false;
					}
					break;
				}
			}
			if (!queenPut) {
				if (stackPoint.size() > 0) {
					Point point = stackPoint.pop();
					i = (int) (point.getX());
					startColumn = (int) (point.getY());

					marcarCasillas(i, startColumn, -1, chessboard);
					chessboard[i][startColumn] = 0;
					// print(chessboard);
					i--;
					startColumn++;
				}
			}

		}
		System.out.println(s);

	}

	private static void marcarCasillas(int row, int column, int value, int[][] chessboard) {

		for (int i = 0; i < 8; i++) {
			// marcamos ocupada toda la fila
			if (chessboard[i][column] != 8) {
				chessboard[i][column] += value;
			}
			// marcamos ocupada toda la fila
			if (chessboard[row][i] != 8) {
				chessboard[row][i] += value;
			}
		}

		// arriba a la izquierda
		int i = row - 1, j = column - 1;

		while (i > 1 && j > 1) {
			if (chessboard[i][j] != 8) {
				chessboard[i][j] += value;
			}
			i--;
			j--;
		}

		// arriba a la derecha
		i = row + 1;
		j = column - 1;
		while (i < 8 && j > -1) {
			if (chessboard[i][j] != 8) {
				chessboard[i][j] += value;
			}
			i++;
			j--;
		}

		// abajo a la izquierda
		i = row - 1;
		j = column + 1;
		while (i > -1 && j < 8) {
			if (chessboard[i][j] != 8) {
				chessboard[i][j] += value;
			}
			i--;
			j++;
		}

		// abajo a la izquierda
		i = row + 1;
		j = column + 1;
		while (i < 8 && j < 8) {
			if (chessboard[i][j] != 8) {
				chessboard[i][j] += value;
			}
			i++;
			j++;
		}

		// print(chessboard);

	}

	private static void print(int[][] chessboard) {
		for (int i = 0; i < 8; i++) {
			System.out.println(Arrays.toString(chessboard[i]));
		}
		System.out.println();
	}

}
