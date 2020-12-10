import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

//TODO - Enviar 11059
public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder output = new StringBuilder();
		String line;
		int N, testCases = 0;

		// while ((line = br.readLine()) != null) {
		while (!(line = br.readLine()).equals("#")) {
			N = Integer.parseInt(line);

			BigInteger[] values = new BigInteger[N];

			args = br.readLine().split(" ");
			for (int i = 0; i < N; i++) {
				values[i] = BigInteger.valueOf(Long.parseLong(args[i]));
			}

			BigInteger maxValue = BigInteger.ZERO;
			for (int i = 0; i < N; i++) {
				BigInteger multiply = values[i];
				if (multiply.compareTo(maxValue) > 0) {
					maxValue = multiply;
				}

				if (multiply.intValue() != 0) {
					for (int j = i + 1; j < N; j++) {
						if (values[j].intValue() == 0) {
							break;
						}
						multiply = multiply.multiply(values[j]);
						if (multiply.compareTo(maxValue) > 0) {
							maxValue = multiply;
						}
					}
				}
			}
			br.readLine();
			testCases++;

			output.append(String.format("Case #%d: The maximum product is %d.\n\n", testCases, maxValue));
		}
		System.out.print(output);
	}

}
