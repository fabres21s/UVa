import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line;
		StringBuffer output = new StringBuffer();
		int r, n, answer, cases = 0;
		while (!(line = br.readLine()).equals("0 0")) {
			args = line.split(" ");
			r = Integer.parseInt(args[0]) - 1;
			n = Integer.parseInt(args[1]);
			answer = r / n;

			output.append("Case " + (++cases));
			if (answer > 26) {
				output.append(": impossible");
			} else { 
				output.append(": " + answer);
			}
			output.append("\n");

		}
		System.out.print(output);
	}

}
