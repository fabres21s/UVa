import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main1583 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		Map<Integer, Integer> mapDigits = new HashMap<Integer, Integer>();
		for (int i = 100000; i > 0; i--) {
			mapDigits.put(digitGenerator(i), i);
		}
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer output = new StringBuffer();
		
		int testCases = Integer.parseInt(br.readLine());
		
		Integer digitGenerated;
		while (testCases --> 0) {
			digitGenerated = mapDigits.get(Integer.parseInt(br.readLine()));
			
			output.append( (digitGenerated == null ) ? "0" : digitGenerated);
			output.append("\n");
		}
		System.out.print(output);
		
	}

	private static Integer digitGenerator(int n) {
		int sum = n;
		while (n > 0) {
			sum += n %10;
			n /= 10;
		}
		return sum;
	}

}
