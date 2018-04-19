import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main12516 {

	
	/*
	 * TODO - WA generar casos de prueba
	 */
	public static void main(String[] args) throws NumberFormatException, IOException {
		ArrayList<String> sinasignar;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int row, column, persons, friends, r, c, i;
		StringBuffer output = new StringBuffer();
		int[][] cinema;
		boolean correcto;

		String line;
		while (!(line = br.readLine()).equals("0 0")) {

			args = line.split(" ");
			row = Integer.parseInt(args[0]);
			column = Integer.parseInt(args[1]);

			cinema = new int[row][2 * column + 1];
			persons = Integer.parseInt(br.readLine());
			while (persons-- > 0) {

				args = br.readLine().split(" ");
				r = args[0].substring(0, 1).toCharArray()[0] - 65;
				c = Integer.parseInt(args[0].substring(1));
				c = 2 * c - 1;
				if (args[1].equals("-"))
					c--;
				else
					c++;
				cinema[r][c] = 1;
			}
			friends = Integer.parseInt(br.readLine());
			correcto = true;
			sinasignar = new ArrayList<String>();
			while (friends-- > 0) {
				args = br.readLine().split(" ");
				if (correcto) {
					r = args[0].substring(0, 1).toCharArray()[0] - 65;
					c = Integer.parseInt(args[0].substring(1));
					c = 2 * c - 1;
					if (cinema[r][c + 1] == 0 && cinema[r][c - 1] == 1)
						cinema[r][c + 1] = 1;
					else if (cinema[r][c + 1] == 1 && cinema[r][c - 1] == 0)
						cinema[r][c - 1] = 1;
					else if (cinema[r][c + 1] == 1 && cinema[r][c - 1] == 1)
						correcto = false;
					else
						sinasignar.add(args[0]);
				}
			}

			if (correcto) {
				for (i = sinasignar.size() - 1; i > -1; i--) {
					String dir = sinasignar.get(i);

					r = dir.substring(0, 1).toCharArray()[0] - 65;
					c = Integer.valueOf(dir.substring(1));
					c = 2 * c - 1;
					if (cinema[r][c + 1] == 0 && cinema[r][c - 1] == 1)
						cinema[r][c + 1] = 1;
					else if (cinema[r][c + 1] == 1 && cinema[r][c - 1] == 0)
						cinema[r][c - 1] = 1;
					else if (cinema[r][c + 1] == 1 && cinema[r][c - 1] == 1) {
						correcto = false;
						break;
					} else {
						System.out.println("estoy suponiendo (mal) que no llega hasta aqui");
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
