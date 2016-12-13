import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

/**
*	13116 - Multistory Labyrinth
*
*
*	Submision:	17619344
*	Date:		2016-07-04 19:58:05
*	Runtime:	0.980
*	Ranking:	18 - Voy de último :|
*/
public class Main13116 {

	/**
	 * - Dijkstra con Arreglos
	 * - Priority Queue
	 * - Arreglos 
	 * 
	 * El ejercicio consiste en que dado un arreglo tridimensional, con una posición inicial
	 * y una posición final, encontrar la ruta más corta para llegar desde S hasta E
	 * con ciertas condiciones.
	 * 
	 * Parecido al 532, sólo que se puede cambiar de piso entre los ascensores, representados por -
	 * Casi que no lo acepta, tuve el peor tiempo
	 */
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String line;
		int dimensions, rows, columns;
		int i, j, k;
		StringBuffer output = new StringBuffer();
		char[] lineChar;
		Coordenada coordenada, coordenadaS = null, coordenadaE = null;
		while (!(line = br.readLine()).equals("0 0 0")) {
			args = line.split(" ");
			dimensions = Integer.parseInt(args[2]);
			rows = Integer.parseInt(args[0]);
			columns = Integer.parseInt(args[1]);

			char[][][] array = new char[dimensions + 2][rows + 2][columns + 2];
			int[][][] arrayDistances = new int[dimensions + 2][rows + 2][columns + 2];
			for (i = 1; i <= dimensions; i++) {
				for (j = 1; j <= rows; j++) {
					lineChar = br.readLine().toCharArray();
					for (k = 1; k <= columns; k++) {
						array[i][j][k] = lineChar[k - 1];
						if (array[i][j][k] == 'S') {
							coordenadaS = new Coordenada(i, j, k);
							arrayDistances[i][j][k] = 0;
						} else if (array[i][j][k] == 'E') {
							coordenadaE = new Coordenada(i, j, k);
						}

					}
				}
				br.readLine();
			}

			for (i = 1; i <= dimensions; i++) {
				for (j = 1; j <= rows; j++) {
					for (k = 1; k <= columns; k++) {
						if (array[i][j][k - 1] == '.'
								|| array[i][j][k - 1] == '-'
								|| array[i][j][k - 1] == 'E') {
							arrayDistances[i][j][k - 1] = 1;
						}
						if (array[i][j][k + 1] == '.'
								|| array[i][j][k + 1] == '-'
								|| array[i][j][k + 1] == 'E') {
							arrayDistances[i][j][k + 1] = 1;
						}
						if (array[i][j + 1][k] == '.'
								|| array[i][j + 1][k] == '-'
								|| array[i][j + 1][k] == 'E') {
							arrayDistances[i][j + 1][k] = 1;
						}
						if (array[i][j - 1][k] == '.'
								|| array[i][j - 1][k] == '-'
								|| array[i][j - 1][k] == 'E') {
							arrayDistances[i][j - 1][k] = 1;
						}

						// para los ascensores

						if (array[i][j][k] == '-') {
							if (array[i + 1][j][k] == '-') {
								arrayDistances[i + 1][j][k] = 1;
							}
							if (array[i - 1][j][k] == '-') {
								arrayDistances[i - 1][j][k] = 1;
							}
						}
					}
				}
			}

			// grafo.setNodoInicial(grafo.getNodosExistentes().get(coordenadaS.toString()));
			// grafo.setNodoFinal(grafo.getNodosExistentes().get(coordenadaE.toString()));

			coordenada = coordenadaS;
			boolean visited[][][] = new boolean[dimensions + 2][rows + 2][columns + 2];
			int distances[][][] = new int[dimensions + 2][rows + 2][columns + 2];

			PriorityQueue<Item> priorityQueue = new PriorityQueue<Item>();

			priorityQueue.add(new Item(coordenada, 0));

			while (priorityQueue.size() > 0) {
				Item item = priorityQueue.poll();
				coordenada = item.getCoordenada();
				i = coordenada.getX();
				j = coordenada.getY();
				k = coordenada.getZ();
				if (!visited[i][j][k]) {
					visited[i][j][k] = true;
					distances[i][j][k] = item.getDistance();

					
					Coordenada coordenada2;

					if (k < columns) {
						if (!visited[i][j][k + 1]) {
							if (array[i][j][k + 1] != '#') {
								coordenada2 = new Coordenada(i, j, k + 1);
								priorityQueue.add(new Item(coordenada2, item
										.getDistance()
										+ arrayDistances[i][j][k + 1]));
							}
						}
					}

					if (k > 1) {

						if (!visited[i][j][k - 1]) {
							if (array[i][j][k - 1] != '#') {
								coordenada2 = new Coordenada(i, j, k - 1);

								priorityQueue.add(new Item(coordenada2, item
										.getDistance()
										+ arrayDistances[i][j][k - 1]));
							}
						}
					}

					if (j < rows) {
						if (!visited[i][j + 1][k]) {
							if (array[i][j + 1][k] != '#') {
								coordenada2 = new Coordenada(i, j + 1, k);

								priorityQueue.add(new Item(coordenada2, item
										.getDistance()
										+ arrayDistances[i][j + 1][k]));
							}
						}
					}

					if (j > 1) {
						if (!visited[i][j - 1][k]) {
							if (array[i][j - 1][k] != '#') {
								coordenada2 = new Coordenada(i, j - 1, k);

								priorityQueue.add(new Item(coordenada2, item
										.getDistance()
										+ arrayDistances[i][j - 1][k]));
							}
						}
					}

					// para los ascensores

					if (array[i][j][k] == '-') {
						if (i < dimensions) {
							if (!visited[i + 1][j][k]) {
								if (array[i + 1][j][k] == '-') {
									coordenada2 = new Coordenada(i + 1, j, k);

									priorityQueue
											.add(new Item(
													coordenada2,
													item.getDistance()
															+ arrayDistances[i + 1][j][k]));
								}
							}
						}

						if (i > 1) {
							if (!visited[i - 1][j][k]) {
								if (array[i - 1][j][k] == '-') {
									coordenada2 = new Coordenada(i - 1, j, k);

									priorityQueue
											.add(new Item(
													coordenada2,
													item.getDistance()
															+ arrayDistances[i - 1][j][k]));
								}
							}
						}
					}

				}
			}

			if ( distances[coordenadaE.getX()][coordenadaE.getY()][coordenadaE
							.getZ()] == 0) {
				output.append("-1\n");
			} else {
				output.append(distances[coordenadaE.getX()][coordenadaE.getY()][coordenadaE
						.getZ()] + "\n");
			}
		}
		System.out.print(output);
	}
}

class Coordenada {
	int x, y, z;

	public Coordenada(int x, int y, int z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getZ() {
		return z;
	}

	public void setZ(int z) {
		this.z = z;
	}

	@Override
	public String toString() {
		return x + " " + y + " " + z;
	}
}

class Item implements Comparable<Item> {

	private Coordenada coordenada;
	private int distance;

	@Override
	public int compareTo(Item o) {
		return this.distance - o.distance;
	}

	public Item(Coordenada coordenada, int distance) {
		setCoordenada(coordenada);
		setDistance(distance);
	}

	public int getDistance() {
		return distance;
	}

	public void setDistance(int distance) {
		this.distance = distance;
	}

	public Coordenada getCoordenada() {
		return coordenada;
	}

	public void setCoordenada(Coordenada coordenada) {
		this.coordenada = coordenada;
	}
}
