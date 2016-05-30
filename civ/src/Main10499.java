import java.util.Scanner;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) 
	{
		long n;
		Scanner input=new Scanner(System.in);
		while((n=input.nextLong())>-1)
		{
			if(n==1)
			{
				System.out.println("0%");
				continue;
			}
			System.out.println(n*25+"%");
		}
		input.close();
		// TODO Auto-generated method stub		
	}
}
