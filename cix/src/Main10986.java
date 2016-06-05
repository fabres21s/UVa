import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main10986 {

	public static void main(String[] args) {
		try {
			Scanner input = new Scanner(System.in);

			int testCases = input.nextInt();
			int servidores, conexiones, nodoOrigen, nodoFinal;
			int src, dst;
			int unreachable = Integer.MAX_VALUE;
			for (int i = 1; i <= testCases; i++) {

				servidores = input.nextInt();

				conexiones = input.nextInt();
				nodoOrigen = input.nextInt();
				nodoFinal = input.nextInt();

				int array[][] = new int[servidores][servidores];

				for (int x = 0; x < array.length; x++) {
					Arrays.fill(array[x], unreachable);
				}
				for (int j = 0; j < conexiones; j++) {
					src = input.nextInt();
					dst = input.nextInt();

					array[src][dst] = input.nextInt();
					array[dst][src] = array[src][dst];
				}

				int distances[][] = new int[servidores][servidores];
				for (int x = 0; x < servidores; x++) {
					Arrays.fill(distances[x], unreachable);
					distances[x][x] = 0;
				}

				boolean visited[] = new boolean[servidores];

				distances[0] = array[nodoOrigen];
				distances[0][nodoOrigen] = 0;

				visited[nodoOrigen] = true;
				PriorityQueue<Item> priorityQueue = new PriorityQueue<Item>();

				int nodo = 0;
				for (int x : distances[0]) {

					Item item = new Item(nodo, x);
					nodo++;
					priorityQueue.add(item);
				}

				while (priorityQueue.size() > 0) {
					Item item = priorityQueue.poll();
					if (!visited[item.getRow()]) {
						visited[item.getRow()] = true;
						distances[item.getRow()][item.getRow()] = item
								.getDistance();
						int array_selected[] = array[item.getRow()];

						nodo = 0;
						for (int x : array_selected) {
							if (!visited[nodo]) {
								priorityQueue.add(new Item(nodo, item
										.getDistance() + x));

							}
							nodo++;

						}
					}
				}
				if (distances[nodoFinal][nodoFinal] == unreachable) {
					System.out.printf("Case #%d: unreachable\n", i);
				} else {
					System.out.printf("Case #%d: %d\n", i,
							distances[nodoFinal][nodoFinal]);
				}

			}
		} catch (Exception exc) {
		}

	}
}

class Item implements Comparable<Item> {

	private int row;
	private int distance;

	@Override
	public int compareTo(Item o) {
		return this.distance - o.distance;
	}

	@Override
	public String toString() {
		return row + " ::: " + " ::: " + distance;
	}

	public Item(int row, int distance) {
		setRow(row);
		setDistance(distance);
	}

	public int getRow() {
		return row;
	}

	public void setRow(int row) {
		this.row = row;
	}

	public int getDistance() {
		return distance;
	}

	public void setDistance(int distance) {
		this.distance = distance;
	}

}
