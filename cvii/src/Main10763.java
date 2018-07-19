import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main10763 {

	//TODO Poner datos
	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int persons, MAX = 500001;

		StringBuffer output = new StringBuffer();
		while ((persons = Integer.parseInt(br.readLine())) != 0) {
			List<Point> points = new ArrayList<Point>();
			int arregloX[] = new int [MAX];
			int arregloY[] = new int [MAX];
			for (int i = 0; i < persons; i++) {
				args = br.readLine().split(" ");
				Point point = new Point(Integer.parseInt(args[0]), Integer.parseInt(args[1]));

				points.add(point);
				
				arregloX[point.x]++;
				arregloY[point.y]++;
			}
			
			boolean answer = true;
			for (Point point : points) {
				if (arregloX[point.x] != arregloY[point.x] || arregloY[point.y] != arregloX[point.y]) {
					answer = false;
				}
			}
			output.append(answer ? "YES":"NO");
			output.append("\n");
		}
		System.out.print(output);

	}

}
