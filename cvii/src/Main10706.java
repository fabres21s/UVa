import java.util.Scanner;

//TODO No enviado - Number Sequence
public class Main10706 {

	/**
	 * no enviado
	 */
	public static void main(String[] args) {
		int[][] intervalos = {
				{ 9, 99, 999, 9999, 19999, 29999, 30234 },
				{ 45, 9045, 1395495, 189414495, 828329495, 1967244495,
						200022060 } };
		// Scanner input=new Scanner(System.in);
		Scanner input = new Scanner(System.in);
		boolean flag = false;
		int n, i, x, res, aux, z;
		for (int p = 9000; p < 10000; p++)
		// while(input.hasNext())
		{
			// n=input.nextInt();
			n = p;
			i = 0;
			while (intervalos[1][i] < n)
				i++;
			i--;
			if (i == -1) {
				n = poruno(n);
			} else {
				n -= intervalos[1][i];
				if (i == 0) {
					n = pordos(n);
				}
				if (i == 1) {
					x = 192;
					// y=n;
					while ((n - x) > 0) {
						n -= x;
						x += 3;
						flag = true;
					}
					if (n > 189) {
						n -= 189;
						res = n % 3;
						aux = n / 3;
						z = 99 + aux + res;
						if (res == 0)// toma el ultimo digito
							n = z % 10;
						else if (res == 1) {// toma el de la mitad
							n = z / 100;
						} else
							// toma el primero
							n = (z % 100) / 10;
					} else if (n > 9) {
						n -= 9;
						res = n % 2;
						aux = n / 2;
						z = 9 + aux + res;
						if (res == 0)// toma el ultimo
							n = z % 10;
						else
							// toma el primero
							n = z / 10;
					} else {// aqui es donde hay que trabajar!!!!
						if (flag) {
							n = 99 + n / 3 + 2;
							res = n % 3;
							System.out.println("res " + res);
						} else {

						}

					}
				}
			}
			// System.out.println(n);
			System.out.println("p= " + p + " n= " + n);
			input.close();

		}
	}

	private static int pordos(int n) {
		int x = 11, res, aux, z;
		while ((n - x) > 0) {
			n -= x;
			x += 2;
		}
		if (n > 9) {
			n -= 9;
			res = n % 2;
			aux = n / 2;
			z = 9 + aux + res;
			if (res == 0)// toma hasta el ultimo
				n = z % 10;
			else
				// toma el primero
				n = z / 10;
		}
		return n;
	}

	private static int poruno(int n) {
		int x = 1;
		while ((n - x) > 0) {
			n -= x;
			x++;
		}
		return n;
	}
}
