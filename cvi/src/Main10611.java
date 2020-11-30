import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
*	10611 - The Playboy Chimp
*
*	Submission:	25788094
*	Date:		2020-11-30 15:30:32
*	Runtime:	0.380
*	Ranking:	6113 / 7660
*/
public class Main10611 {

	/**
	 * - Búsqueda binaria
	 *
	 * En un arreglo ordenado, encontrar el menor y el mayor dado un valor a ser buscado
	 */
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringBuilder output = new StringBuilder();
		int n, q;
		n = Integer.parseInt(br.readLine());
		args = br.readLine().split(" ");
		int array[] = new int[n];
		for (int i = 0; i < n; i++) {
			array[i] = Integer.parseInt(args[i]);
		}

		q = Integer.parseInt(br.readLine());

		args = br.readLine().split(" ");

		for (int i = 0; i < q; i++) {
			int value = Integer.parseInt(args[i]);

			int[] positions = busquedaBinaria(array, value);
			int mayor = -1, menor = -1;
			if (positions[2] > -1) {
				mayor = buscarMayorDesde(array, value, positions[2]);
				menor = buscarMenorDesde(array, value, positions[2]);

			} else if (positions[1] > -1 && positions[1] < array.length) {
				mayor = buscarMayor(array, value, positions[1]);
				menor = buscarMenor(array, value, positions[1]);
			} else if (positions[1] > -1 && positions[1] == array.length) {
				mayor = -1;
				menor = array[array.length - 1];
			} else {
				mayor = array[0];
				menor = -1;
			}

			if (menor == -1) {
				output.append(String.format("X %d\n", mayor));
			} else if (mayor == -1) {
				output.append(String.format("%d X\n", menor));
			} else {
				output.append(String.format("%d %d\n", menor, mayor));
			}

		}
		System.out.print(output);

	}

	private static int buscarMenor(int[] array, int value, int position) {
		while (position < array.length && array[position] < value) {
			position++;
		}
		if (position == array.length) {
			return -1;
		}
		return array[position - 1];
	}

	private static int buscarMenorDesde(int[] array, int value, int position) {
		while (position > -1 && array[position] >= value) {
			position--;
		}
		if (position < 0) {
			return -1;
		}
		return array[position];
	}

	private static int buscarMayorDesde(int[] array, int value, int position) {
		while (position < array.length && array[position] <= value) {
			position++;
		}
		if (position == array.length) {
			return -1;
		}
		return array[position];
	}

	private static int buscarMayor(int[] array, int value, int position) {

		while (position > 0 && array[position] > value) {
			position--;
		}
		if (position < 0) {
			return -1;
		}
		return array[position + 1];
	}

	private static int[] busquedaBinaria(int[] array, int value) {
		int left = 0, right = array.length;
		int positions[] = { -1, -1, -1 };
		while (left < right) {
			int middle = (left + right) / 2;
			// System.out.println(array[middle] + " :: "+middle);
			if (array[middle] == value) {
				positions[2] = middle;
				break;
			} else if (array[middle] > value) {

				positions[0] = right = middle - 1;

			} else {
				positions[1] = left = middle + 1;
			}

		}
		return positions;
	}

}
