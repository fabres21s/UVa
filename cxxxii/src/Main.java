import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer output = new StringBuffer();
		
		int testCases = Integer.parseInt(br.readLine());
		long answer, s;
		
		while (testCases --> 0) {
			s = Long.parseLong(br.readLine());
			
			answer = (s/2) * (s/2) + ((s+1)/2) * ((s+1)/2);
			output.append(answer);
			output.append("\n");
		}
		
		System.out.print(output);

	}

}
