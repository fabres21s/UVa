import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//TODO poner toda la información
public class Main13178 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testCases = Integer.parseInt(br.readLine());
		StringBuffer output = new StringBuffer();
		int n;
		while (testCases --> 0) {
			n = Integer.parseInt(br.readLine());
			if (n % 3 == 1) {
				output.append("NO\n");
			} else {
				output.append("YES\n");
			}
		}
		System.out.print(output);
	}

}
