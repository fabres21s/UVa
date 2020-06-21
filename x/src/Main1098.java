import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

/**
*	1098 - Robots on Ice 
*
*	Submission:	21302083
*	Date:		2018-05-12 11:52:11
*	Runtime:	1.610
*	Ranking:	121 / 292
*/
public class Main1098 {
	static int FILAS = 0;
	static int COLUMNAS = 6;
	static int count = 0;
	static int r1, c1, r2, c2, r3, c3, s1, s2, s3;
	static boolean[][] grid;
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };

	/**
	 * - Recursividad
	 * 
	 * Encontrar en un arreglo, el camino dados un comienzo, un fin, y unas restricciones intermedias
	 * de pasos obligados en un número determinado 
	 */
	
	//Fuente https://github.com/yubinbai/pcuva-problems/blob/master/UVa%201098%20-%20Robots%20on%20Ice/Main.java
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer output = new StringBuffer();
		String line;
		int testCases = 0;
		while (!(line = br.readLine()).equals("0 0")) {

			args = line.split(" ");
			FILAS = Integer.parseInt(args[0]);
			COLUMNAS = Integer.parseInt(args[1]);

			grid = new boolean[FILAS][COLUMNAS];

			grid[0][0] = true;

			args = br.readLine().split(" ");
			r1 = Integer.parseInt(args[0]);
			c1 = Integer.parseInt(args[1]);
			s1 = FILAS * COLUMNAS / 4;

			r2 = Integer.parseInt(args[2]);
			c2 = Integer.parseInt(args[3]);
			s2 = FILAS * COLUMNAS / 2;

			r3 = Integer.parseInt(args[4]);
			c3 = Integer.parseInt(args[5]);
			s3 = 3 * FILAS * COLUMNAS / 4;

			count = 0;
			solve(0, 0, 1);
			output.append("Case "+(++testCases)+": ");
			output.append(count);
			output.append("\n");
		}
		System.out.print(output);

	}

	public static void solve(int x, int y, int step) {
		if (x == 0 && y == 1) {
			if (step == FILAS * COLUMNAS)
				count++;
			return;
		}

		// if reached checkpoints before time
		if (x == r1 && y == c1 && step != s1)
			return;
		if (x == r2 && y == c2 && step != s2)
			return;
		if (x == r3 && y == c3 && step != s3)
			return;
		// if didn't reach checkpoints on time
		if (step == s1 && (x != r1 || y != c1))
			return;
		if (step == s2 && (x != r2 || y != c2))
			return;
		if (step == s3 && (x != r3 || y != c3))
			return;

		if (step < s1 && manhattan(x, y, r1, c1) > (s1 - step))
			return;
		if (step < s2 && manhattan(x, y, r2, c2) > (s2 - step))
			return;
		if (step < s3 && manhattan(x, y, r3, c3) > (s3 - step))
			return;

		// if not connected
		if (isDisconnected())
			return;

		// check neighborhood condition
		int urgent = 0, index = -1;
		for (int k = 0; k < dx.length; k++) {
			int r = x + dx[k], c = y + dy[k];
			if (!valid(r, c) || grid[r][c] || (r == 0 && c == 1))
				continue;
			int neighbors = 0;
			for (int i = 0; i < dx.length; i++) {
				int nr = r + dx[i], nc = c + dy[i];
				if (!valid(nr, nc) || grid[nr][nc])
					continue;
				neighbors++;
			}
			if (neighbors == 0)
				return;
			if (neighbors == 1) {
				urgent++;
				index = k;
			}
		}

		// applying action on neighborhood case
		if (urgent > 1)
			return;
		else if (urgent == 1) {
			grid[x + dx[index]][y + dy[index]] = true;
			solve(x + dx[index], y + dy[index], step + 1);
			grid[x + dx[index]][y + dy[index]] = false;
			return;
		}

		// ordinary case
		for (int k = 0; k < dx.length; k++) {
			int r = x + dx[k], c = y + dy[k];
			if (!valid(r, c) || grid[r][c])
				continue;
			grid[r][c] = true;
			solve(r, c, step + 1);
			grid[r][c] = false;
		}
	}

	public static int manhattan(int x1, int y1, int x2, int y2) {
		return Math.abs(x1 - x2) + Math.abs(y1 - y2);
	}

	public static boolean isDisconnected() {
		Queue<Point> q = new LinkedList<Point>();
		boolean[][] vis = new boolean[FILAS][COLUMNAS];
		boolean found = false;
		for (int i = 0; i < grid.length && !found; i++)
			for (int j = 0; j < grid[i].length && !found; j++)
				if (!grid[i][j]) {
					q.add(new Point(i, j));
					vis[i][j] = true;
					found = true;
				}

		while (!q.isEmpty()) {
			Point c = q.poll();
			for (int i = 0; i < dx.length; i++) {
				int x = c.x + dx[i], y = c.y + dy[i];
				if (!valid(x, y) || vis[x][y] || grid[x][y])
					continue;
				q.add(new Point(x, y));
				vis[x][y] = true;
			}
		}
		for (int i = 0; i < vis.length; i++)
			for (int j = 0; j < vis[i].length; j++)
				if (!vis[i][j] && !grid[i][j])
					return true;
		return false;
	}

	public static boolean valid(int x, int y) {
		return x >= 0 && x < FILAS && y >= 0 && y < COLUMNAS;
	}

}
