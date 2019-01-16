import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main12650 {

	//TODO - POner información
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer output = new StringBuffer();
		String line;
		int volunteers, lives;
		while ((line = br.readLine()) != null) {
			args = line.split(" ");
			volunteers = Integer.parseInt(args[0]);
			lives = Integer.parseInt(args[1]);
			int array[] = new int[volunteers + 1];

			args = br.readLine().split(" ");

			for (String s : args) {
				array[Integer.parseInt(s)]++;
			}

			StringBuffer outputTest = new StringBuffer();
			boolean deads = false;
			for (int i = 1; i <= volunteers; i++) {
				if (array[i] == 0) {
					outputTest.append(i + " ");
					deads  =true;
				}
			}
			
			if (deads) {
				output.append(outputTest.toString()+"\n");
			} else {
				output.append("*\n");
			}

		}
		System.out.print(output);
	}

}
