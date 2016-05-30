import java.util.Scanner;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) 
	{
		int n,m,k;
		Scanner input=new Scanner(System.in);
		while(input.hasNext())
		{
			n=input.nextInt();
			m=input.nextInt();
			k=input.nextInt();
			if(n==0 && m==0 && k==0)
			{
				break;
			}
			if(m%2==0)
			{
				System.out.println("Gared");
			}
			else
			{
				System.out.println("Keka");
			}
		}
		input.close();
		// TODO Auto-generated method stub
	}
}
