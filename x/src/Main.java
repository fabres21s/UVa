import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		StringBuffer output = new StringBuffer();
		Scanner input = new Scanner(System.in);
		int n;
		
		while((n = input.nextInt()) != -1) {
			output.append(n+",\n");
		}
		System.out.println(output);

	}

}
