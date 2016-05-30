import java.util.Scanner;


public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner input=new Scanner(System.in);
		while(input.hasNext()){
			if((input.nextInt())%6==0)
				System.out.println("Y");
			else
				System.out.println("N");
		}
		input.close();
	}

}
