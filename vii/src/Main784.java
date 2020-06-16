import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
*	748 - Maze Exploration
*
*
*	Submission:	9498931
*	Date:		2020-06-16 23:25:14
*	Runtime:	0.250
*	Ranking:	3351
*/
public class Main784 {

	static char[][] maze;

	/**
	 * - Arreglos
	 * 
	 * Similar al 352
	 */
	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int testCases = Integer.valueOf(br.readLine());
		StringBuffer output = new StringBuffer();

		String line;
		while (testCases-- > 0) {

			List<String> lines = new ArrayList<String>();

			while (!(line = br.readLine()).startsWith("_")) {
				lines.add(line);
			}

			maze = new char[lines.size()][];

			for (int i = 0; i < lines.size(); i++) {
				maze[i] = lines.get(i).toCharArray();
			}

			for (int i = 0; i < maze.length; i++) {
				for (int j = 0; j < maze[i].length; j++) {
					if (maze[i][j] == '*') {
						fill(i, j);
						break;
					}
				}
			}
			
			for (int i = 0; i < maze.length; i++) {
				for (int j = 0; j < maze[i].length; j++) {
					output.append(maze[i][j]);
				}
				output.append("\n");
			}
			
			output.append(line);
			output.append("\n");
		}
		System.out.print(output);

	}

	private static void fill(int i, int j) {
		maze[i][j] = '#';
		if (maze[i - 1][j] == ' ') {
			fill(i - 1, j);
		}
		if (maze[i + 1][j] == ' ') {
			fill(i + 1, j);
		}
		if (maze[i][j - 1] == ' ') {
			fill(i, j - 1);
		}
		if (maze[i][j + 1] == ' ') {
			fill(i, j + 1);
		}
	}

}
