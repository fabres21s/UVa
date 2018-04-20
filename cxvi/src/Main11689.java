import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main11689 {

	//TODO Poner información
	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testCases = Integer.parseInt(br.readLine());
		int e, f, c;
		StringBuffer output = new StringBuffer();
		while (testCases-- > 0) {
			args = br.readLine().split(" ");

			e = Integer.parseInt(args[0]);
			f = Integer.parseInt(args[1]);
			c = Integer.parseInt(args[2]);
			output.append(calculate(e + f, c));
			output.append("\n");
		}
		System.out.print(output);

	}

	public static int calculate(int total, int div) {
		int sum = 0;
		while (total >= div) {
			sum += total / div;

			total = total / div + total % div;
		}
		return sum;
		// if (total == 0) {
		// return 0;
		// } 10891 http://codealltheproblems.blogspot.com.co/2015/10/uva-10891-game-of-sum.html
		// return (total / (div - 1) - ((total % (div - 1) == 0) ? 1 : 0));
	}

}
