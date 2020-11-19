import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	static int maxCount = 0;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringBuilder output = new StringBuilder();
		String suggestion1, suggestion2;
		int testCases = 0;

		while (!(suggestion1 = br.readLine()).equals("#")) {
			suggestion2 = br.readLine();

			maxCount = 0;
			testCases++;

			long t = System.currentTimeMillis();
			hallarMaximaSecuencia(suggestion1.toCharArray(), 0, suggestion2.toCharArray(), 0, 0);
			System.out.println("tiempo empleado "+testCases + " ::: "+ (System.currentTimeMillis() - t));

			

			
			output.append(String.format("Case #%d: you can visit at most %d cities.\n", testCases, maxCount));
			
			
		}

		System.out.print(output);
	}

	public static void hallarMaximaSecuencia(char[] a, int startA, char[] b, int startB, int count) throws IOException {

		for (int i = startA; i < a.length; i++) {
			for (int j = startB; j < b.length; j++) {
				if (a[i] == b[j]) {

					hallarMaximaSecuencia(a, i + 1, b, j + 1, count + 1);
					break;
				}
			}

		}
		maxCount = Math.max(count, maxCount);
	}

}
