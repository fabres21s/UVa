import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main13187 {
//TODO Poner información - 13187
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer output = new StringBuffer();
		int testCases = Integer.parseInt(br.readLine());
		long n;
		
		while (testCases --> 0) {
			n = Long.parseLong(br.readLine());
			
			n = n*n + 2*n;
			output.append(n);
			output.append("\n");
		}
		System.out.print(output);
	}

}
