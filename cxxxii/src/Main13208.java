import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main13208 {
	
	//TODO esperar UDebug :( o inventarse ejercicios
	

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int testCases = Integer.parseInt(br.readLine());
		int bottom, segments;
		while (testCases-- > 0) {
			args = br.readLine().split(" ");
			bottom = Integer.parseInt(args[0]);
			segments = Integer.parseInt(args[1]) + 2;

			int distances[] = new int[segments];
			int heights[] = new int[segments];

			args = br.readLine().split(" ");
			int index = 0;
			for (String s : args) {
				distances[index] = Integer.parseInt(s);
				index++;
			}

			index = 0;
			args = br.readLine().split(" ");
			for (String s : args) {
				heights[index] = Integer.parseInt(s);
				index++;
			}

			int a = heights[0];
			int b, d = distances[0];
			int volume = 0;
			for (index = 1; index < segments; index++) {
				b = heights[index];

				if (a < b || a == b) {
					volume += a * d * bottom;
					a = b;
				} else {
					// buscar mayor
					int mayor = 0, posMayor = 0;
					d = 0;
					for (int i = index; i < segments; i++) {
						if (heights[i] > mayor) {
							mayor = heights[i];
							posMayor = i;
						}
					}

					if (posMayor > 0) {
						for (int i = index - 1; i < posMayor; i++) {
							d += distances[i];
						}
						a = Math.min(heights[posMayor], a);
						b = heights[posMayor + 1];
						index = posMayor;
						volume += a * d * bottom;
						a = heights[posMayor];
						d = distances[posMayor];
					}
				}
			}
			System.out.println(volume);
		}
	}

}
