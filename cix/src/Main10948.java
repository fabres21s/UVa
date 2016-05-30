import java.util.Scanner;

public class Main 
{
	/**
	 * @param args
	 */
	public static void main(String[] args) 
	{
		Scanner input=new Scanner(System.in);		
		int n,i=-1;
		boolean found;
		while((n=input.nextInt())!=0)
		{
			if(esprimo(n-2))
			{
				System.out.println(n+":\n"+2+"+"+(n-2));
				continue;
			}
			found=false;
			if(n%2!=1)
			{			
				for(i=3;i<=n/2;i+=2)
				{
					if(esprimo(i))
					{
						if(esprimo(n-i))
						{
							found=true;
							System.out.println(n+":\n"+i+"+"+(n-i));
							break;
						}
					}
				}
			}
			if(!found)
			{
				System.out.println(n+":\nNO WAY!");
			}			
		}
		input.close();
		// TODO Auto-generated method stub
	}
	
	static boolean esprimo (int n)
	{
		int i;
		if((n%2)==0)
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
			i+=2;			
		}	
		return true;
	}
}
