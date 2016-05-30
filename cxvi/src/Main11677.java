import java.io.IOException;
import java.util.Scanner;

public class Main {

	/*
	 * Ver cuantos minutos faltan desde una hora inicial a una hora final
	 */

	public static void main(String[] args) throws IOException {

		Scanner input = new Scanner(System.in);
		int hi, mi, hf, mf;
		int t1, t2, t;
		while (input.hasNext()) {
			hi = input.nextInt() * 60;
			mi = input.nextInt();

			hf = input.nextInt() * 60;
			mf = input.nextInt();

			if (hi == 0 && mi == hi && mf == hi && hf == hi) {
				break;
			}
			t = (hf + mf) - (hi + mi);

			if (t < 0) {
				t = 1440 + t;
			}

			if (t > 1440) {
				t = 1440 - t;
			}
			System.out.println(t);

		}

		input.close();
	}

}
