import java.util.Scanner;


public class Main {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int a, b,c;
		while  (input.hasNext()){
			
			a = input.nextInt();
			b = input.nextInt();
			c = input.nextInt();
			
			if (a == b && b == c){
				System.out.println("*");
			} else if (a != b && b == c){
				System.out.println("A");
			} else if (b != c && a == c){
				System.out.println("B");
			} else if (c !=b && a == b){
				System.out.println("C");
			}
		}
		input.close();
	}

}
