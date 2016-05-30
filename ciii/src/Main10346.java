import java.util.Scanner;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) 
	{
		Scanner input=new Scanner(System.in);
		int n, k;
		while(input.hasNext())
		{
			n=input.nextInt();		
			k=input.nextInt();
			System.out.println((n+(n-1)/(k-1)));
		}
		input.close();
		// TODO Auto-generated method stub
	}
}
