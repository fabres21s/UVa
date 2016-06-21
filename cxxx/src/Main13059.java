import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main13059 {

	//TODO - Ponerle categoría y llevarlo al workspace
	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in ));
		String line;
		while (( line = br.readLine()) != null) {
			System.out.println(Long.valueOf(line) - 1);
		}
//		while (true ){
//			int players = input.nextInt();
//			int matches = 0;
//			while (players != 1){
//				matches += players /2;
//				players = players/2 + players%2;
//			}
//			System.out.println(matches);
//		}
	}

}
