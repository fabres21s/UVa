import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//TODO Asignar categoría y poner información
public class Main13130 {

	//13130
	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int testCases = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < testCases; i++) {
			args = br.readLine().split(" ");
			String last = "";
			boolean scale = true;
			for (String s: args) {
				if (last.compareTo(s) != -1) {
					scale = false;
					break;
				}
				last = s;
			}
			
			System.out.println(scale ? "Y" : "N");
		}
	}

}
