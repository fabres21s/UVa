import java.util.Scanner;

public class Main 
{

	/**
	 * @param args
	 */
	public static void main(String[] args) 
	{
		Scanner input=new Scanner(System.in);
		long n,i;
		while((n=input.nextLong())!=-1)
		{
			while((n%2)==0)
			{
				System.out.println("    "+2);
				n=n/2;
			}
			i=3;
			while(i<=Math.sqrt(n)+1)
			{
				if((n%i)==0)
				{
					System.out.println("    "+i);
					n=n/i;
				}
				else
				{
					i+=2;
				}
				
			}
			if(n>1)
			{
				System.out.println("    "+n);
			}
			System.out.println();
		}
		input.close();
		// TODO Auto-generated method stub
	}
}
