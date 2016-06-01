import java.util.Arrays;
import java.util.Scanner;

/**
 * 
 * @author fabio
 *
 *         TLE
 */
//TODO TLE - Sending email
public class Main10986 {

	public static int MAX = Integer.MAX_VALUE;

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		int testCases = input.nextInt();
		int servidores, conexiones, nodoOrigen, nodoFinal;
		int src, dst;
		for (int i = 1; i <= testCases; i++) {

			servidores = input.nextInt();

			conexiones = input.nextInt();
			nodoOrigen = input.nextInt();
			nodoFinal = input.nextInt();

			int array[][] = new int[servidores][servidores];

			for (int x = 0; x < array.length; x++) {
				Arrays.fill(array[x], Integer.MAX_VALUE);
			}
			for (int j = 0; j < conexiones; j++) {
				src = input.nextInt();
				dst = input.nextInt();

				array[src][dst] = input.nextInt();
				array[dst][src] = array[src][dst];
			}

			int distances[][] = new int[servidores][servidores];
			for (int x = 0; x < distances.length; x++) {
				Arrays.fill(distances[x], Integer.MAX_VALUE);
			}

			int recorridoPrevio = 0;
			int arrayDistances[] = array[nodoOrigen];
			int min = Integer.MAX_VALUE;
			int posMin = 0;
			
			for (int x = 0; x < arrayDistances.length; x ++) {
				if (arrayDistances[x] < min) {
					posMin = x;
					min = arrayDistances[x];
				}
			}

		}

	}
}
