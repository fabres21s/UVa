import java.util.Scanner;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args)	
	{
		Scanner input=new Scanner(System.in);
		long n=1;
		long [] fact=new long[15];
		for(int i=2;i<=13;i++)
		{
			n=n*i;
			fact[i]=n;
		}
		int i;
		while(input.hasNext())
		{
			i=input.nextInt();
			if(i<0)
			{
				if(i%2==0)
				{
					System.out.println("Underflow!");
				}
				else
				{
					System.out.println("Overflow!");
				}
				continue;
			}
			if(i>13)
			{
				System.out.println("Overflow!");
			}
			else if(i<8)
			{
				System.out.println("Underflow!");
			}
			else 
			{
				System.out.println(fact[i]);
			}
		}	
		input.close();
		// TODO Auto-generated method stub
	}
}
