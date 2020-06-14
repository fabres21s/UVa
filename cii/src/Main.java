import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Objects;
import java.util.TreeMap;

public class Main {

	static  int records = 0;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		final BufferedReader br = new BufferedReader(new InputStreamReader(
				System.in));
		
		int testCases = Integer.parseInt(br.readLine());
		
		String specie;
		while (testCases --> 0) {
			if (testCases > 0) {
				System.out.println();
			}
			
			br.readLine();			
			
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
			
			
			treeMap.entrySet().stream().forEach(e -> System.out.printf("%s %.04f\n", e.getKey(), Double.valueOf(e.getValue()*100)/records));
		}
	}

}
