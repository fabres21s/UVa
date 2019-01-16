import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main12356 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int soldiers, loss;
		int left, right, i;
		int[] LS = new int[1000100];
		int[] RS = new int[1000100];
		StringBuffer output = new StringBuffer();
		while (true) {
			args = br.readLine().split(" ");
			soldiers = Integer.parseInt(args[0]);
			loss = Integer.parseInt(args[1]);

			if (soldiers == 0 && soldiers == loss) {
				break;
			}

			

			for (i = 0; i <= soldiers + 1; i++) {
				LS[i] = i - 1;
				RS[i] = i + 1;
			}
			for (i = 0; i < loss; i++) {
				args = br.readLine().split(" ");
				left = Integer.parseInt(args[0]);
				right = Integer.parseInt(args[1]);

				if (LS[left] < 1)
					output.append("* ");
				else
					output.append(String.format("%d ", LS[left]));
				if (RS[right] > soldiers)
					output.append("*\n");
				else
					output.append(String.format("%d\n", RS[right]));

				LS[RS[right]] = LS[left];
				RS[LS[left]] = RS[right];

			}
			output.append("-\n");
		}
		System.out.print(output);
	}

}
