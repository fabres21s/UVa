import java.util.Scanner;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) 
	{
		Scanner input=new Scanner(System.in);
		long n;
		while((n=input.nextLong())!=0)		
			factorizacion(n);
		input.close();
		// TODO Auto-generated method stub
	}	
	
	static void factorizacion (long n)
	{
		n=Math.abs(n);
		long i,ultimo=-1,x=n;
		int cont=0;
		while((n%2)==0)
		{
			n=n/2;
			cont=1;
		}
		i=3;
		while(i<=Math.sqrt(n)+1)
		{
			if((n%i)==0)
			{
				cont++;
				ultimo=i;
				while(n%i==0)
				{				
					n=n/i;
				}				
			}
			i+=2;			
		}		
		if(n>1 && n!=x)
		{
			ultimo=n;
			cont++;
		}
		if(cont<2)
		{
			ultimo=-1;
		}	
		System.out.println(ultimo);					
	}
}
