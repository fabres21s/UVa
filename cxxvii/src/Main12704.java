import java.util.Scanner;


public class Main {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		int casos = input.nextInt();
		double x,y,r, dc;
		while (casos -- > 0){
			x = input.nextInt();
			y = input.nextInt();
			r = input.nextInt();
			
			dc = Math.sqrt(x*x + y*y);
			
			System.out.printf("%.2f %.2f\n", (r -dc), (r + dc));
		}
		input.close();
	}

}
