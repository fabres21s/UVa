import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;

/**
*	929 - Number Maze
*
*
*	Submision:	17428548
*	Date:		2016-05-27 21:51:48
*	Runtime:	2.420
*	Ranking:	1652:::
*/
public class Main929 {

	/**
	 * - Dijkstra con arreglos
	 * - Arreglos
	 * - Priority Queue
	 * 
	 * Dado un arreglo (grafo) siendo los pesos el valor que hay
	 * en cada posición del areglo, encontrar la ruta más corta para ir de la
	 * posición 0,0 a la m-1,n-1
	 */
	public static void main(String[] args) throws NumberFormatException,
			IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int testCases = Integer.parseInt(br.readLine());
		int rows, columns;
		for (int i = 0; i < testCases; i++) {
			rows = Integer.parseInt(br.readLine());
			columns = Integer.parseInt(br.readLine());

			int array[][] = new int[rows][columns];
			int arrayDistances[][] = new int[rows][columns];
			boolean[][] visited = new boolean[rows][columns];
			for (int x = 0; x < rows; x++) {
				args = br.readLine().split(" ");
				for (int y = 0; y < columns; y++) {
					array[x][y] = Integer.parseInt(args[y]);
				}
			}

			solved(0, 0, rows - 1, columns - 1, array, visited, arrayDistances);
		}
	}

	private static void solved(int srcRow, int srcColumn, int dstRow,
			int dstColumn, int[][] array, boolean[][] visited,
			int[][] arrayDistances) {

		PriorityQueue<Item> priorityQueue = new PriorityQueue<Item>();
		priorityQueue
				.add(new Item(srcRow, srcColumn, array[srcRow][srcColumn]));

		for (int i = 0; i < arrayDistances.length; i++) {
			Arrays.fill(arrayDistances[i], Integer.MAX_VALUE);
		}
		arrayDistances[srcRow][srcColumn] = array[srcRow][srcColumn];
		int row, column, distance;
		// int count= 0;
		while (priorityQueue.size() > 0) {
			// count++;
			Item item = priorityQueue.poll();
			row = item.getRow();
			column = item.getColumn();

			if (!visited[row][column]) {
				distance = item.getDistance();
				visited[row][column] = true;
				arrayDistances[row][column] = distance;
				// ponemos en la cola de prioridad

				// si row es mayor que 0, ponemos al de arriba
				if (row > 0) {
					if (!visited[row - 1][column])
						priorityQueue.add(new Item(row - 1, column, Math.min(
								distance + array[row - 1][column],
								arrayDistances[row - 1][column])));
				}

				if (row < dstRow) {
					if (!visited[row + 1][column])
						priorityQueue.add(new Item(row + 1, column, Math.min(
								distance + array[row + 1][column],
								arrayDistances[row + 1][column])));
				}

				if (column > 0) {
					if (!visited[row][column - 1])
						priorityQueue.add(new Item(row, column - 1, Math.min(
								distance + array[row][column - 1],
								arrayDistances[row][column - 1])));
				}

				if (column < dstColumn) {
					if (!visited[row][column + 1])
						priorityQueue.add(new Item(row, column + 1, Math.min(
								distance + array[row][column + 1],
								arrayDistances[row][column + 1])));
				}
			}
		}
		System.out.println(arrayDistances[dstRow][dstColumn]);
	}

}

class Item implements Comparable<Item> {

	private int row;
	private int column;
	private int distance;

	@Override
	public int compareTo(Item o) {
		return this.distance - o.distance;
	}

	@Override
	public String toString() {
		return row + " ::: " + column + " ::: " + distance;
	}

	public Item(int row, int column, int distance) {
		setRow(row);
		setColumn(column);
		setDistance(distance);
	}

	public int getRow() {
		return row;
	}

	public void setRow(int row) {
		this.row = row;
	}

	public int getColumn() {
		return column;
	}

	public void setColumn(int column) {
		this.column = column;
	}

	public int getDistance() {
		return distance;
	}

	public void setDistance(int distance) {
		this.distance = distance;
	}

}
