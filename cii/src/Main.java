import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Objects;
import java.util.TreeMap;

public class Main {

	static int records = 0;

	//10226
	public static void main(String[] args) throws NumberFormatException, IOException {
		final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringBuilder output = new StringBuilder();

		int testCases = Integer.parseInt(br.readLine());
		br.readLine();
		String specie;
		while (testCases-- > 0) {

			TreeMap<String, Integer> treeMap = new TreeMap<String, Integer>();
			records = 0;
			while (!(specie = br.readLine()).equals("")) {
				Integer times = treeMap.get(specie);

				if (Objects.isNull(times)) {
					times = 1;
				} else {
					times++;
				}

				treeMap.put(specie, times);
				records++;
			}

			treeMap.entrySet().stream().forEach(e -> output
					.append(String.format("%s %.04f\n", e.getKey(), Double.valueOf(e.getValue() * 100) / records)));

			if (testCases > 0) {
				output.append("\n");
			}
		}
		System.out.print(output);
	}

}
