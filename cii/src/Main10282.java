import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		String line = "";
		Map<String, String> map = new HashMap<String, String>();
		String r = "";
		boolean answer = false;
		while (input.hasNext()) {

			line = input.nextLine();

			if (answer) {
				r = map.get(line);
				System.out.println((r == null) ? "eh" : r);
			} else {

				answer = (line.isEmpty());

				if (!answer) {

					args = line.split(" ");
					map.put(args[1], args[0]);
				}

			}

		}
	}

}
