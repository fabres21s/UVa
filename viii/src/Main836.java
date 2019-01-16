import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main836 {

	//TODO - Poner información
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringBuffer output = new StringBuffer();
		

		int testCases = Integer.parseInt(br.readLine());
		br.readLine();

		boolean firstCase = true;
		while (testCases-- > 0) {
			char[][] array = new char[30][30];

			int index = 0;
			if (!firstCase) {
				output.append("\n");
			}
			firstCase = false;
			String line = "";

			while ((line = br.readLine()) != null && !(line).isEmpty()) {
				array[index++] = line.toCharArray();
			}

			int maxi = -1;

			int[][] a = new int[index + 5][index + 5];

			for (int i = 0; i < index; i++)
				for (int j = 0; j < index; j++)
					a[i][j] = array[i][j] == '1' ? 1 : 0;

			for (int i = 1; i < index; i++)
				for (int j = 0; j < index; j++)
					a[i][j] = a[i][j] == 1 ? a[i - 1][j] + 1 : 0;

			for (int i = 0; i < index; i++) {
				for (int j = 0; j < index; j++) {
					int cnt = 1;
					for (int k = j - 1; k >= 0 && a[i][k] >= a[i][j]; k--)
						cnt++;
					for (int k = j + 1; k < index && a[i][k] >= a[i][j]; k++)
						cnt++;
					cnt *= a[i][j];
					if (maxi < cnt)
						maxi = cnt;
				}
			}

			output.append(String.format("%d\n", maxi));
		}
		System.out.print(output);
	}

}
