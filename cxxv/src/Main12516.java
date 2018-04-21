import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main12516 {

	
	/*
	 * TODO - Poner información
	 */
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int row, column, persons, friends, r, c, i;
		StringBuffer output = new StringBuffer();
		int[][] cinema;
		boolean correcto;
		boolean seats[][];

		String line;
		while (!(line = br.readLine()).equals("0 0")) {

			args = line.split(" ");
			row = Integer.parseInt(args[0]);
			column = Integer.parseInt(args[1]);

			cinema = new int[row][column + 2];
			seats = new boolean[row][column + 2];
			persons = Integer.parseInt(br.readLine());
			while (persons-- > 0) {

				args = br.readLine().split(" ");
				r = args[0].substring(0, 1).toCharArray()[0] - 65;
				c = Integer.parseInt(args[0].substring(1));
				
				if (args[1].equals("+"))
					c++;

				cinema[r][c] = 1;
			}
			friends = Integer.parseInt(br.readLine());
			correcto = true;
			while (friends-- > 0) {
				args = br.readLine().split(" ");
				if (correcto) {
					r = args[0].substring(0, 1).toCharArray()[0] - 65;
					c = Integer.parseInt(args[0].substring(1));
					seats[r][c] = true;
				}
			}

			
			for(i  =0; i<row; i++) {
				for (int j  =0; j<column; j++) {
					if (seats[i][j]) {
						if (cinema[i][j + 1] == 0 && cinema[i][j] == 1)
							cinema[i][j + 1] = 1;
						else if (cinema[i][j + 1] == 1 && cinema[i][j] == 0)
							cinema[i][j] = 1;
						else if (cinema[i][j + 1] == 1 && cinema[i][j] == 1) {
							correcto = false;
							break;
						}
					}
				}
			}

			if (correcto)
				output.append("YES\n");
			else
				output.append("NO\n");

		}
		System.out.print(output);
	}

}
