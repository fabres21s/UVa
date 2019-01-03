import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

//TODO - Poner información
public class Main455 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testCases = Integer.parseInt(br.readLine());
		int length;
		String line;
		StringBuffer output = new StringBuffer();
		boolean firstCase = true;
		while (testCases > 0) {
			
			line = br.readLine();
			
			if (!line.isEmpty()) {
				testCases--;
				length = line.length();
				int size = length;
				for (int i = 1; i <= length/2; i++) {
					Set<String> set = new HashSet<String>();
					for (int j = 0; j <length; j+=i ) {
						set.add(line.substring(j, Math.min(j+i, length)));
					}
					if (set.size() == 1) {
						for (String s: set) {
							size = s.length();
						}
						break;
					}
					
				}

				if (!firstCase) {
					output.append("\n");
				}
				output.append(size);
				output.append("\n");
				firstCase  =false;
				
			}
		}
		System.out.print(output);
		
	}

}
