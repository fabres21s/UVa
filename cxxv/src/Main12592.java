import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
*	12592 - Slogan Learning of Princess
*
*
*	Submision:	16398715
*	Date:		2015-11-06 20:33:20
*	Runtime:	0.069
*	Ranking:	1215
*/
public class Main12592 {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		int n = Integer.valueOf(input.nextLine());

		StringBuffer response = new StringBuffer();

		Map<String, String> map = new HashMap<String, String>();

		for (int i = 0; i < n; i++) {
			map.put(input.nextLine(), input.nextLine());
		}

		n = Integer.valueOf(input.nextLine());
		for (int i = 0; i < n; i++) {
			response.append(map.get(input.nextLine()) + "\n");
		}

		System.out.print(response);
		input.close();
	}

}
