import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

//TODO - Enviar 10523
public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		BigInteger  a, sum;
		int N;
		String line;
		while ((line = br.readLine()) != null) {
			args = line.split(" ");
			N = Integer.valueOf(args[0]);

			a = BigInteger.valueOf(Integer.valueOf(args[0]));
			sum = BigInteger.ZERO;

			for (int i = 1; i <= N; i++) {
				sum = sum.add(BigInteger.valueOf(i).multiply(a.pow(i)));
			}

			System.out.println(sum);
		}

	}

}
