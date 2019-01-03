import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main167 {

	static int[][][] solutions = { 
			{ { 0, 0 }, { 1, 4 }, { 2, 7 }, { 3, 5 }, { 4, 2 }, { 5, 6 }, { 6, 1 }, { 7, 3 }, },
			{ { 0, 0 }, { 1, 5 }, { 2, 7 }, { 3, 2 }, { 4, 6 }, { 5, 3 }, { 6, 1 }, { 7, 4 }, },
			{ { 0, 0 }, { 1, 6 }, { 2, 3 }, { 3, 5 }, { 4, 7 }, { 5, 1 }, { 6, 4 }, { 7, 2 }, },
			{ { 0, 0 }, { 1, 6 }, { 2, 4 }, { 3, 7 }, { 4, 1 }, { 5, 3 }, { 6, 5 }, { 7, 2 }, },
			{ { 0, 1 }, { 1, 3 }, { 2, 5 }, { 3, 7 }, { 4, 2 }, { 5, 0 }, { 6, 6 }, { 7, 4 }, },
			{ { 0, 1 }, { 1, 4 }, { 2, 6 }, { 3, 0 }, { 4, 2 }, { 5, 7 }, { 6, 5 }, { 7, 3 }, },
			{ { 0, 1 }, { 1, 4 }, { 2, 6 }, { 3, 3 }, { 4, 0 }, { 5, 7 }, { 6, 5 }, { 7, 2 }, },
			{ { 0, 1 }, { 1, 5 }, { 2, 0 }, { 3, 6 }, { 4, 3 }, { 5, 7 }, { 6, 2 }, { 7, 4 }, },
			{ { 0, 1 }, { 1, 5 }, { 2, 7 }, { 3, 2 }, { 4, 0 }, { 5, 3 }, { 6, 6 }, { 7, 4 }, },
			{ { 0, 1 }, { 1, 6 }, { 2, 2 }, { 3, 5 }, { 4, 7 }, { 5, 4 }, { 6, 0 }, { 7, 3 }, },
			{ { 0, 1 }, { 1, 6 }, { 2, 4 }, { 3, 7 }, { 4, 0 }, { 5, 3 }, { 6, 5 }, { 7, 2 }, },
			{ { 0, 1 }, { 1, 7 }, { 2, 5 }, { 3, 0 }, { 4, 2 }, { 5, 4 }, { 6, 6 }, { 7, 3 }, },
			{ { 0, 2 }, { 1, 0 }, { 2, 6 }, { 3, 4 }, { 4, 7 }, { 5, 1 }, { 6, 3 }, { 7, 5 }, },
			{ { 0, 2 }, { 1, 4 }, { 2, 1 }, { 3, 7 }, { 4, 0 }, { 5, 6 }, { 6, 3 }, { 7, 5 }, },
			{ { 0, 2 }, { 1, 4 }, { 2, 1 }, { 3, 7 }, { 4, 5 }, { 5, 3 }, { 6, 6 }, { 7, 0 }, },
			{ { 0, 2 }, { 1, 4 }, { 2, 6 }, { 3, 0 }, { 4, 3 }, { 5, 1 }, { 6, 7 }, { 7, 5 }, },
			{ { 0, 2 }, { 1, 4 }, { 2, 7 }, { 3, 3 }, { 4, 0 }, { 5, 6 }, { 6, 1 }, { 7, 5 }, },
			{ { 0, 2 }, { 1, 5 }, { 2, 1 }, { 3, 4 }, { 4, 7 }, { 5, 0 }, { 6, 6 }, { 7, 3 }, },
			{ { 0, 2 }, { 1, 5 }, { 2, 1 }, { 3, 6 }, { 4, 0 }, { 5, 3 }, { 6, 7 }, { 7, 4 }, },
			{ { 0, 2 }, { 1, 5 }, { 2, 1 }, { 3, 6 }, { 4, 4 }, { 5, 0 }, { 6, 7 }, { 7, 3 }, },
			{ { 0, 2 }, { 1, 5 }, { 2, 3 }, { 3, 0 }, { 4, 7 }, { 5, 4 }, { 6, 6 }, { 7, 1 }, },
			{ { 0, 2 }, { 1, 5 }, { 2, 3 }, { 3, 1 }, { 4, 7 }, { 5, 4 }, { 6, 6 }, { 7, 0 }, },
			{ { 0, 2 }, { 1, 5 }, { 2, 7 }, { 3, 0 }, { 4, 3 }, { 5, 6 }, { 6, 4 }, { 7, 1 }, },
			{ { 0, 2 }, { 1, 5 }, { 2, 7 }, { 3, 0 }, { 4, 4 }, { 5, 6 }, { 6, 1 }, { 7, 3 }, },
			{ { 0, 2 }, { 1, 5 }, { 2, 7 }, { 3, 1 }, { 4, 3 }, { 5, 0 }, { 6, 6 }, { 7, 4 }, },
			{ { 0, 2 }, { 1, 6 }, { 2, 1 }, { 3, 7 }, { 4, 4 }, { 5, 0 }, { 6, 3 }, { 7, 5 }, },
			{ { 0, 2 }, { 1, 6 }, { 2, 1 }, { 3, 7 }, { 4, 5 }, { 5, 3 }, { 6, 0 }, { 7, 4 }, },
			{ { 0, 2 }, { 1, 7 }, { 2, 3 }, { 3, 6 }, { 4, 0 }, { 5, 5 }, { 6, 1 }, { 7, 4 }, },
			{ { 0, 3 }, { 1, 0 }, { 2, 4 }, { 3, 7 }, { 4, 1 }, { 5, 6 }, { 6, 2 }, { 7, 5 }, },
			{ { 0, 3 }, { 1, 0 }, { 2, 4 }, { 3, 7 }, { 4, 5 }, { 5, 2 }, { 6, 6 }, { 7, 1 }, },
			{ { 0, 3 }, { 1, 1 }, { 2, 4 }, { 3, 7 }, { 4, 5 }, { 5, 0 }, { 6, 2 }, { 7, 6 }, },
			{ { 0, 3 }, { 1, 1 }, { 2, 6 }, { 3, 2 }, { 4, 5 }, { 5, 7 }, { 6, 0 }, { 7, 4 }, },
			{ { 0, 3 }, { 1, 1 }, { 2, 6 }, { 3, 2 }, { 4, 5 }, { 5, 7 }, { 6, 4 }, { 7, 0 }, },
			{ { 0, 3 }, { 1, 1 }, { 2, 6 }, { 3, 4 }, { 4, 0 }, { 5, 7 }, { 6, 5 }, { 7, 2 }, },
			{ { 0, 3 }, { 1, 1 }, { 2, 7 }, { 3, 4 }, { 4, 6 }, { 5, 0 }, { 6, 2 }, { 7, 5 }, },
			{ { 0, 3 }, { 1, 1 }, { 2, 7 }, { 3, 5 }, { 4, 0 }, { 5, 2 }, { 6, 4 }, { 7, 6 }, },
			{ { 0, 3 }, { 1, 5 }, { 2, 0 }, { 3, 4 }, { 4, 1 }, { 5, 7 }, { 6, 2 }, { 7, 6 }, },
			{ { 0, 3 }, { 1, 5 }, { 2, 7 }, { 3, 1 }, { 4, 6 }, { 5, 0 }, { 6, 2 }, { 7, 4 }, },
			{ { 0, 3 }, { 1, 5 }, { 2, 7 }, { 3, 2 }, { 4, 0 }, { 5, 6 }, { 6, 4 }, { 7, 1 }, },
			{ { 0, 3 }, { 1, 6 }, { 2, 0 }, { 3, 7 }, { 4, 4 }, { 5, 1 }, { 6, 5 }, { 7, 2 }, },
			{ { 0, 3 }, { 1, 6 }, { 2, 2 }, { 3, 7 }, { 4, 1 }, { 5, 4 }, { 6, 0 }, { 7, 5 }, },
			{ { 0, 3 }, { 1, 6 }, { 2, 4 }, { 3, 1 }, { 4, 5 }, { 5, 0 }, { 6, 2 }, { 7, 7 }, },
			{ { 0, 3 }, { 1, 6 }, { 2, 4 }, { 3, 2 }, { 4, 0 }, { 5, 5 }, { 6, 7 }, { 7, 1 }, },
			{ { 0, 3 }, { 1, 7 }, { 2, 0 }, { 3, 2 }, { 4, 5 }, { 5, 1 }, { 6, 6 }, { 7, 4 }, },
			{ { 0, 3 }, { 1, 7 }, { 2, 0 }, { 3, 4 }, { 4, 6 }, { 5, 1 }, { 6, 5 }, { 7, 2 }, },
			{ { 0, 3 }, { 1, 7 }, { 2, 4 }, { 3, 2 }, { 4, 0 }, { 5, 6 }, { 6, 1 }, { 7, 5 }, },
			{ { 0, 4 }, { 1, 0 }, { 2, 3 }, { 3, 5 }, { 4, 7 }, { 5, 1 }, { 6, 6 }, { 7, 2 }, },
			{ { 0, 4 }, { 1, 0 }, { 2, 7 }, { 3, 3 }, { 4, 1 }, { 5, 6 }, { 6, 2 }, { 7, 5 }, },
			{ { 0, 4 }, { 1, 0 }, { 2, 7 }, { 3, 5 }, { 4, 2 }, { 5, 6 }, { 6, 1 }, { 7, 3 }, },
			{ { 0, 4 }, { 1, 1 }, { 2, 3 }, { 3, 5 }, { 4, 7 }, { 5, 2 }, { 6, 0 }, { 7, 6 }, },
			{ { 0, 4 }, { 1, 1 }, { 2, 3 }, { 3, 6 }, { 4, 2 }, { 5, 7 }, { 6, 5 }, { 7, 0 }, },
			{ { 0, 4 }, { 1, 1 }, { 2, 5 }, { 3, 0 }, { 4, 6 }, { 5, 3 }, { 6, 7 }, { 7, 2 }, },
			{ { 0, 4 }, { 1, 1 }, { 2, 7 }, { 3, 0 }, { 4, 3 }, { 5, 6 }, { 6, 2 }, { 7, 5 }, },
			{ { 0, 4 }, { 1, 2 }, { 2, 0 }, { 3, 5 }, { 4, 7 }, { 5, 1 }, { 6, 3 }, { 7, 6 }, },
			{ { 0, 4 }, { 1, 2 }, { 2, 0 }, { 3, 6 }, { 4, 1 }, { 5, 7 }, { 6, 5 }, { 7, 3 }, },
			{ { 0, 4 }, { 1, 2 }, { 2, 7 }, { 3, 3 }, { 4, 6 }, { 5, 0 }, { 6, 5 }, { 7, 1 }, },
			{ { 0, 4 }, { 1, 6 }, { 2, 0 }, { 3, 2 }, { 4, 7 }, { 5, 5 }, { 6, 3 }, { 7, 1 }, },
			{ { 0, 4 }, { 1, 6 }, { 2, 0 }, { 3, 3 }, { 4, 1 }, { 5, 7 }, { 6, 5 }, { 7, 2 }, },
			{ { 0, 4 }, { 1, 6 }, { 2, 1 }, { 3, 3 }, { 4, 7 }, { 5, 0 }, { 6, 2 }, { 7, 5 }, },
			{ { 0, 4 }, { 1, 6 }, { 2, 1 }, { 3, 5 }, { 4, 2 }, { 5, 0 }, { 6, 3 }, { 7, 7 }, },
			{ { 0, 4 }, { 1, 6 }, { 2, 1 }, { 3, 5 }, { 4, 2 }, { 5, 0 }, { 6, 7 }, { 7, 3 }, },
			{ { 0, 4 }, { 1, 6 }, { 2, 3 }, { 3, 0 }, { 4, 2 }, { 5, 7 }, { 6, 5 }, { 7, 1 }, },
			{ { 0, 4 }, { 1, 7 }, { 2, 3 }, { 3, 0 }, { 4, 2 }, { 5, 5 }, { 6, 1 }, { 7, 6 }, },
			{ { 0, 4 }, { 1, 7 }, { 2, 3 }, { 3, 0 }, { 4, 6 }, { 5, 1 }, { 6, 5 }, { 7, 2 }, },
			{ { 0, 5 }, { 1, 0 }, { 2, 4 }, { 3, 1 }, { 4, 7 }, { 5, 2 }, { 6, 6 }, { 7, 3 }, },
			{ { 0, 5 }, { 1, 1 }, { 2, 6 }, { 3, 0 }, { 4, 2 }, { 5, 4 }, { 6, 7 }, { 7, 3 }, },
			{ { 0, 5 }, { 1, 1 }, { 2, 6 }, { 3, 0 }, { 4, 3 }, { 5, 7 }, { 6, 4 }, { 7, 2 }, },
			{ { 0, 5 }, { 1, 2 }, { 2, 0 }, { 3, 6 }, { 4, 4 }, { 5, 7 }, { 6, 1 }, { 7, 3 }, },
			{ { 0, 5 }, { 1, 2 }, { 2, 0 }, { 3, 7 }, { 4, 3 }, { 5, 1 }, { 6, 6 }, { 7, 4 }, },
			{ { 0, 5 }, { 1, 2 }, { 2, 0 }, { 3, 7 }, { 4, 4 }, { 5, 1 }, { 6, 3 }, { 7, 6 }, },
			{ { 0, 5 }, { 1, 2 }, { 2, 4 }, { 3, 6 }, { 4, 0 }, { 5, 3 }, { 6, 1 }, { 7, 7 }, },
			{ { 0, 5 }, { 1, 2 }, { 2, 4 }, { 3, 7 }, { 4, 0 }, { 5, 3 }, { 6, 1 }, { 7, 6 }, },
			{ { 0, 5 }, { 1, 2 }, { 2, 6 }, { 3, 1 }, { 4, 3 }, { 5, 7 }, { 6, 0 }, { 7, 4 }, },
			{ { 0, 5 }, { 1, 2 }, { 2, 6 }, { 3, 1 }, { 4, 7 }, { 5, 4 }, { 6, 0 }, { 7, 3 }, },
			{ { 0, 5 }, { 1, 2 }, { 2, 6 }, { 3, 3 }, { 4, 0 }, { 5, 7 }, { 6, 1 }, { 7, 4 }, },
			{ { 0, 5 }, { 1, 3 }, { 2, 0 }, { 3, 4 }, { 4, 7 }, { 5, 1 }, { 6, 6 }, { 7, 2 }, },
			{ { 0, 5 }, { 1, 3 }, { 2, 1 }, { 3, 7 }, { 4, 4 }, { 5, 6 }, { 6, 0 }, { 7, 2 }, },
			{ { 0, 5 }, { 1, 3 }, { 2, 6 }, { 3, 0 }, { 4, 2 }, { 5, 4 }, { 6, 1 }, { 7, 7 }, },
			{ { 0, 5 }, { 1, 3 }, { 2, 6 }, { 3, 0 }, { 4, 7 }, { 5, 1 }, { 6, 4 }, { 7, 2 }, },
			{ { 0, 5 }, { 1, 7 }, { 2, 1 }, { 3, 3 }, { 4, 0 }, { 5, 6 }, { 6, 4 }, { 7, 2 }, },
			{ { 0, 6 }, { 1, 0 }, { 2, 2 }, { 3, 7 }, { 4, 5 }, { 5, 3 }, { 6, 1 }, { 7, 4 }, },
			{ { 0, 6 }, { 1, 1 }, { 2, 3 }, { 3, 0 }, { 4, 7 }, { 5, 4 }, { 6, 2 }, { 7, 5 }, },
			{ { 0, 6 }, { 1, 1 }, { 2, 5 }, { 3, 2 }, { 4, 0 }, { 5, 3 }, { 6, 7 }, { 7, 4 }, },
			{ { 0, 6 }, { 1, 2 }, { 2, 0 }, { 3, 5 }, { 4, 7 }, { 5, 4 }, { 6, 1 }, { 7, 3 }, },
			{ { 0, 6 }, { 1, 2 }, { 2, 7 }, { 3, 1 }, { 4, 4 }, { 5, 0 }, { 6, 5 }, { 7, 3 }, },
			{ { 0, 6 }, { 1, 3 }, { 2, 1 }, { 3, 4 }, { 4, 7 }, { 5, 0 }, { 6, 2 }, { 7, 5 }, },
			{ { 0, 6 }, { 1, 3 }, { 2, 1 }, { 3, 7 }, { 4, 5 }, { 5, 0 }, { 6, 2 }, { 7, 4 }, },
			{ { 0, 6 }, { 1, 4 }, { 2, 2 }, { 3, 0 }, { 4, 5 }, { 5, 7 }, { 6, 1 }, { 7, 3 }, },
			{ { 0, 7 }, { 1, 1 }, { 2, 3 }, { 3, 0 }, { 4, 6 }, { 5, 4 }, { 6, 2 }, { 7, 5 }, },
			{ { 0, 7 }, { 1, 1 }, { 2, 4 }, { 3, 2 }, { 4, 0 }, { 5, 6 }, { 6, 3 }, { 7, 5 }, },
			{ { 0, 7 }, { 1, 2 }, { 2, 0 }, { 3, 5 }, { 4, 1 }, { 5, 4 }, { 6, 6 }, { 7, 3 }, },
			{ { 0, 7 }, { 1, 3 }, { 2, 0 }, { 3, 2 }, { 4, 5 }, { 5, 1 }, { 6, 6 }, { 7, 4 }, }

	};

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testCases = Integer.parseInt(br.readLine().trim());
		int [][] array = new int[8][8];
		while (testCases --> 0) {
			for (int i = 0; i< 8; i++) {
				args = br.readLine().trim().split(" ");
				int j = 0;
				for (String s: args) {
					array[i] [j++] = Integer.parseInt(s.trim());
				}
			}
			int max = 0;
			for (int i = 0; i < 92; i++) {
				int sum = 0;
				
				for (int j = 0; j<8; j++) {
					int x  = solutions[i][j][0];
					int y = solutions[i][j][1];
					
					sum += array[x][y];
				}
				max = Math.max(sum, max);
			}
			System.out.printf("%5d\n",max);
		}
		
	}

}
