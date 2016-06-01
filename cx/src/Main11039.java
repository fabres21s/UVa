import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

//TODO TLE - Building designing
public class Main11039 {

	/*
	 * TLE
	 */
	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);
		int cases = input.nextInt();

		int pisos, size;

		int arreglo[];

		List<Integer> pisosRojos;
		while (cases-- > 0) {

			pisosRojos = new ArrayList<Integer>();
			pisos = input.nextInt();
			arreglo = new int[pisos];

			for (int i = 0; i < pisos; i++) {
				size = input.nextInt();
				arreglo[i] = Math.abs(size);

				if (size < 0) {
					pisosRojos.add(size * -1);
				}
			}

			Arrays.sort(arreglo);

			int max = 0;

			if (arreglo.length > 0) {
				boolean rojo = pisosRojos.contains(arreglo[0]);
				max = 1;
				for (int i = 1; i < pisos; i++) {

					if (rojo) {
						if (!pisosRojos.contains(arreglo[i])) {
							// es porque es azul
							max++;
							rojo = false;
						}
					} else {
						if (pisosRojos.contains(arreglo[i])) {
							max++;
							rojo = true;
						}
					}
				}
			}
			System.out.println(max);
		}
	}

}
