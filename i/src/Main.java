import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {

	static StringBuffer output = new StringBuffer();

	// 116
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int rows, columns;
		while (input.hasNext()) {
			rows = input.nextInt();
			columns = input.nextInt();

			if (rows == -1) {
				break;
			}
			int array[][] = new int[rows][columns];

			for (int i = 0; i < rows; i++) {
				for (int j = 0; j < columns; j++) {
					array[i][j] = input.nextInt();
				}
			}

			solve(array);

		}
		input.close();
		System.out.print(output);

	}

	private static void solve(int[][] array) {

		int n = array[0].length;// columnas
		int m = array.length;// filas

		int minors[][][] = new int[m][n][3];
		for (int x = 0; x < m; x++) {
			minors[x][0][0] = array[x][0];
			minors[x][0][1] = x +1 ;
		}

		for (int j = 1; j < n; j++) {
			for (int i = 0; i < m; i++) {

				Item item = posMin3(minors[(i + m - 1) % m][j - 1][0], minors[i][j - 1][0],

						minors[(i + 1) % m][j - 1][0],

						(i + m - 1) % m, i, (i + 1) % m);
				
				minors[i][j][0] = array[i][j] + item.getValue();

				minors[i][j][1] = item.getPosition();

			}

		}

		//la matriz está bien armada, pero toca buscar todas las posibles soluciones
		int pos = 0;
		int min = minors[0][n - 1][0];
		
		PriorityQueue<Item> listMenores = new PriorityQueue<>();
		for (int i = 1; i < m; i++) {
			if (minors[i][n - 1][0] <= min) {
				min = minors[i][n - 1][0];
				pos = i;
				minors[0][n - 1][2] = pos;
			}
		}

		
		
		for (int i = n - 1; i > -1; i--) {
			minors[0][i][2] = pos;
			pos = minors[pos][i][1];

		}

		for (int i = 0; i < n; i++) {
			output.append((minors[0][i][2] + 1));
			if (i < (n - 1)) {
				output.append(" ");
			}
		}
		output.append("\n");
		output.append(min);
		output.append("\n");

	}

	private static Item posMin3(int i, int j, int k, int posI, int posJ, int posK) {

		PriorityQueue<Item> priorityQueue = new PriorityQueue<>();
		priorityQueue.add(new Item(i, posI));
		priorityQueue.add(new Item(j, posJ));
		priorityQueue.add(new Item(k, posK));
		return priorityQueue.poll();
	}
}

class Item implements Comparable<Item> {

	public int getValue() {
		return value;
	}

	@Override
	public int compareTo(Item o) {
		if (this.value == o.value) {
			return this.position - o.position;
		}
		return this.value - o.value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public int getPosition() {
		return position;
	}

	public void setPosition(int position) {
		this.position = position;
	}

	private int value;
	private int position;

	public Item(int value, int position) {
		this.value = value;
		this.position = position;
	}

}
/*
 * 
 * 3 3 8 5 2 3 4 7 1 6 9
 * 
 */
