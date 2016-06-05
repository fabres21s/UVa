import java.util.Arrays;
import java.util.Scanner;

//TODO TLE - Playing with Wheels
public class Main10067 {
	static int[] inicial, fin;
	static int[][] invalido;

	/**
	 * time limit no sé en realidad, pero está muy bravo +-1, +-10, +-100, +-1000
	 */
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int t = input.nextInt(), i, x, j, dif, aux;
		boolean subir;
		while (t > 0) {
			t--;
			inicial = new int[4];
			fin = new int[4];
			for (i = 0; i < 4; i++)
				inicial[i] = input.nextInt();
			for (i = 0; i < 4; i++)
				fin[i] = input.nextInt();
			x = 0;
			invalido = new int[input.nextInt()][4];
			// System.out.println(invalido[0].length);
			for (i = 0; i < invalido.length; i++)
				for (j = 0; j < 4; j++)
					invalido[i][j] = input.nextInt();
			if (Arrays.equals(inicial, fin)) {
				if (!posible(inicial)) {
					System.out.println("0");
					continue;
				}
			}
			if (!posible(fin)) {
				System.out.println("-1");
				continue;
			}
			// System.out.println(Arrays.toString(inicial)+"  "+Arrays.toString(fin));
			while (!Arrays.equals(inicial, fin)) {
				// System.out.println(Arrays.toString(inicial)+" "+Arrays.toString(fin));
				for (i = 0; i < 4; i++) {
					subir = false;
					dif = inicial[i] - fin[i];
					if (dif < 0)
						dif += 10;
					if (dif > 5) {
						dif = 10 - dif;
						subir = true;
					}
					while (inicial[i] != fin[i]) {
						aux = inicial[i];
						if (subir)
							inicial[i] = (1 + inicial[i]) % 10;
						else
							inicial[i] = (9 + inicial[i]) % 10;
						// System.out.println(Arrays.toString(inicial));
						if (posible(inicial))
							x++;
						else {
							inicial[i] = aux;
							break;
						}
					}
				}
				if (x == 0) {
					x = -1;
					break;
				}
			}
			System.out.println(x + " 5 ");
		}
		input.close();
	}

	static boolean posible(int[] comparar) {
		for (int i = 0; i < invalido.length; i++) {
			// System.out.println(Arrays.toString(invalido[i])+" "+Arrays.toString(inicial));
			if (Arrays.equals(invalido[i], comparar))
				return false;
		}
		return true;
	}

}
