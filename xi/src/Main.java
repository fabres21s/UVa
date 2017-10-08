import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line;
		int n, s, i;
		
		int sum, t,min;
		int array[];
		while ((line = br.readLine()) != null) {
			args = line.split(" ");
			n = Integer.parseInt(args[0]);
			s = Integer.parseInt(args[1]);
			
			array = new int[n];
			args = br.readLine().split(" ");
			for ( i = 0; i < n; i++) {
				array[i] = Integer.parseInt(args[i]);
			}
			
			min = s; sum = 0; t = -1;
			for (i = 0; i < n; i++) {
				while (sum < s && t + 1 < n) {
					sum += array[++t];
				}
				if (min > (t-i) && sum >= s) {
					min = t - i;
				}
				sum -= array[i];
			}
			if (min == s) {
				min = -1;
			}
			System.out.println(min + 1);
		}
	}

}
