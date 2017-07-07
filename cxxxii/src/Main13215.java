import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
*	13215 - Polygonal Park
*
*
*	Submision:	19623414
*	Date:		2017-07-07 18:23:53
*	Runtime:	0.110
*	Ranking:	15
*/
public class Main13215 {

	/**
	 * TODO Poner información
	 * @param args
	 * @throws NumberFormatException
	 * @throws IOException
	 */
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testCases = Integer.parseInt(br.readLine());
		int figures;
		while (testCases-- > 0) {
			figures = Integer.parseInt(br.readLine());
			double area = 0, width = 0, height = 0;
			int corner = 0;
			boolean complete = false;
			while (figures-- > 0) {
				args = br.readLine().split(" ");
				double value = Integer.parseInt(args[1]);

				switch (args[0]) {
				case "C":
					corner++;
					area += value * value;

					break;
				case "S":
					area += value * value;

					break;
				case "T":
					area += value * Math.sqrt(3) * value / 4;
					break;
				}

				if (corner == 1) {
					width += value;
				}
				if (corner == 2) {
					if (height == 0) {
						width += value;
					}
					height += value;
				}
				if (corner == 3 && !complete) {
					height += value;
					complete = true;
				}
			}

			System.out.printf("%.4f\n",(width * height - area));
		}
	}
}
