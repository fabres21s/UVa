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
			if(prime(n))
			{
				if(emirp(n))
				{
					System.out.printf("%d is emirp.\n",n);
				}
				else
				{
					System.out.printf("%d is prime.\n",n);
				}
			}
			else
			{
				System.out.printf("%d is not prime.\n",n);
			}
		}
		input.close();
		// TODO Auto-generated method stub
	}

	private static boolean emirp(int n) 
	{
		//char [] p=String.valueOf(n).toCharArray();
		String valor="";
		int p,aux=n;
		while(n>0)
		{
			valor+=n%10;
			n/=10;
		}
		p=Integer.parseInt(valor);
		if(p==aux)
		{
			return false;
		}
		if(prime(p))
		{
			return true;
		}
		// TODO Auto-generated method stub
		return false;
	}

	private static boolean prime(int n) 
	{
		if(n==2)
			return true;
		int i;
		while((n%2)==0)
		{
			return false;
		}
		i=3;
		while(i<=Math.sqrt(n)+1)
		{
			if((n%i)==0)
			{
				return false;
			}
			else
			{
				i+=2;
			}
			
		}
		// TODO Auto-generated method stub
		return true;
	}

}
