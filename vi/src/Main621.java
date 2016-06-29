import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main621 {

	//TODO Poner categoria
	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testCases = Integer.parseInt(br.readLine());
		String s, result;
		for (int i = 0; i < testCases; i++) {
			s = br.readLine();
			
			result = "?";
			if (s.equals("1") || s.equals("4") || s.equals("78")) {
				result = "+";
			} else if (s.endsWith("35")) {
				result = "-";
			} else if (s.startsWith("9") && s.endsWith("4")) {
				result = "*";
			} 
			System.out.println(result);
		}
	}

}
