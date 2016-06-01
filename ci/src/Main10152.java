import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

/*
 * No Enviado al UVa
 * Parece que el ejercicio es al rev�s
 */

//TODO No enviado - ShellSort
public class Main10152 {

	/**
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		Scanner input = new Scanner(System.in);
		BufferedReader reader = new BufferedReader(new InputStreamReader(
				System.in));
		int casos = input.nextInt(), cantidad, i;
		String[] original;
		int[] deseado;
		while (casos > 0) {
			casos--;
			cantidad = input.nextInt();
			original = new String[cantidad];
			deseado = new int[cantidad];
			for (i = 0; i < cantidad; i++) {
				original[i] = reader.readLine();
			}
			for (i = 0; i < cantidad; i++) {
				deseado[buscar(original, reader.readLine())] = i;
			}
			shellsort(original, deseado);
			if (casos > 0) {
				System.out.println();
			}
		}
		input.close();

	}

	private static void shellsort(String[] original, int[] deseado) {

		int i, j, busq;
		for (i = 0; i < deseado.length - 1; i++) {
			// System.out.println(Arrays.toString(original)+"\n"+Arrays.toString(deseado));
			busq = deseado[i] - 1;
			// System.out.println(busq);
			for (j = i + 1; j < deseado.length; j++) {
				// System.out.println("desado["+j+"] = "+deseado[j]);
				if (deseado[j] == busq) {
					System.out.println(original[j]);
					String mover = original[j];
					while (j > 0)// /kjehfrkjhefke
					{
						deseado[j] = deseado[j - 1];
						original[j] = original[j - 1];
						// System.out.println("while "+Arrays.toString(original));
						j--;
					}
					deseado[0] = busq;
					original[0] = mover;

					i = -1;
					break;
				}
			}
		}


	}

	private static int buscar(String[] original, String key) {
		int i = 0;
		while (!original[i].equals(key)) {
			i++;
		}
		return i;
	}

}
/*
 * 2 3 Yertle Duke of Earl Sir Lancelot Duke of Earl Yertle Sir Lancelot 9
 * Yertle Duke of Earl Sir Lancelot Elizabeth Windsor Michael Eisner Richard M.
 * Nixon Mr. Rogers Ford Perfect Mack Yertle Richard M. Nixon Sir Lancelot Duke
 * of Earl Elizabeth Windsor Michael Eisner Mr. Rogers Ford Perfect Mack
 * 
 * 
 * 
 * Duke of Earl Sir Lancelot Elizabeth Windsor Michael Eisner Richard M. Nixon
 * Mr. Rogers Yertle Ford Perfect Mack
 * 
 * Yertle Elizabeth Windsor Duke of Earl Richard M. Nixon Mr. Rogers Mack Sir
 * Lancelot Michael Eisner Ford Perfect
 */
