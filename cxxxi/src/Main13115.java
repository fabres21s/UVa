import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

/**
*	13115 - Sudoku
*
*
*	Submision:	17595433
*	Date:		2016-06-29 17:13:33
*	Runtime:	0.080
*	Ranking:	42
*/
public class Main13115 {

	/*
	 * - Juegos - Sudoku
	 * - Validaciones
	 * - Arreglos
	 * - Set
	 * 
	 * Validar si un sudoku está llenado correctamente
	 */
	public static void main(String[] args) throws NumberFormatException, IOException {
		int sudoku[] [] = {{1,2,3,4},
							{3,4,1,2},
							{2,3,4,1},
							{4,1,2,3}};
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testCases = Integer.parseInt(br.readLine());
		while (testCases-- > 0) {
			int n = Integer.parseInt(br.readLine());
			sudoku = new int[n][n];
			for (int i = 0; i < n; i++) {
				args = br.readLine().split(" ");
				for (int j  =0; j < n; j++) {
					sudoku[i] [j] = Integer.parseInt(args[j]);
				}
			}
			 
			String result = "no";
			if (checkGrids(sudoku, (int) Math.sqrt(n))) {
				if (checkColumns(sudoku, n)) {
					if (checkRows(sudoku, n)) {
						result = "yes";
					}
				}
			}
			System.out.println(result);
		}
		
	}

	private static boolean checkRows(int[][] sudoku, int n) {
		for (int i = 0; i <n; i++) {
			Set<Integer> set = new HashSet<Integer>();
			for (int j = 0; j < n; j++) {
				if (!set.add(sudoku[i][j])) {
					return false;
				}
			}
		}
		return true;
	}

	private static boolean checkColumns(int[][] sudoku, int n) {
		for (int i = 0; i <n; i++) {
			Set<Integer> set = new HashSet<Integer>();
			for (int j = 0; j < n; j++) {
				if (!set.add(sudoku[j][i])) {
					return false;
				}
			}
		}
		return true;
	}

	private static boolean checkGrids(int[][] sudoku, int n) {
		for (int i = 0; i < n*n; i += n ) {
			for (int j = 0; j < n*n; j +=n) {
				Set<Integer> set = new HashSet<Integer>();
				for (int x = i; x < i + n; x ++) {
					for (int y = j; y < j + n; y++) {
						if (!set.add(sudoku[x][y])) {
							return false;
						}
					}
				}
			}
		}
		return true;
	}

}
