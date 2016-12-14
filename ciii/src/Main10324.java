import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main10324 {

	// 10324 TODO asignar categoria, poner todos los datos
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String line;
		int testCases = 1, tests;
		int m, n, start, end;
		while ((line = br.readLine()) != null) {
			tests = Integer.parseInt(br.readLine());
			System.out.println("Case " + testCases + ":");
			testCases++;
			for (int i = 0; i < tests; i++) {
				args = br.readLine().split(" ");

				m = Integer.parseInt(args[0]);
				n = Integer.parseInt(args[1]);

				start = Math.min(m, n);
				end = Math.max(m, n);

				char[] array = line.substring(start, end+1).toCharArray();
				char c = array[0];
				boolean equals = true;
				for (char x : array) {
					if (c != x) {
						equals = false;
						break;
					}
				}
				System.out.println(equals ? "Yes" : "No");
				
			}
		}
	}

}
