import java.util.Scanner;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		Scanner input=new Scanner(System.in);
		int n;
		while(input.hasNext())
		{
			n=input.nextInt();
			System.out.println((n+n/2));
		}
		input.close();
		// TODO Auto-generated method stub
	}
}
