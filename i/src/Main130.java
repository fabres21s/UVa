import java.util.Scanner;

/*
 * 130
 */

public class Main130 
{
	static int [] queue;;
	static int n,k;

	/**
	 * @param args
	 */
	public static void main(String[] args) 
	{
		Scanner input=new Scanner(System.in);
		while(input.hasNext())
		{
			n=input.nextInt();
			k=input.nextInt();
			if(n==0 && n==k)
			{
				break;
			}
			roman();
		}
		// TODO Auto-generated method stub
	}
	
	static void roman()
	{
		queue=new int [110];
		int count,i,next=-1,killed;
		for(i=0;i<n;i++)
		{
			queue[i]=i+1;
		}
		while(i>1)
		{
			count=0;
			while(count<k)
			{
				next=(next+1)%n;
				if(queue[next]>0)
				{
					count++;
				}
			}
			killed=next;
			queue[next]=0;
			count=0;
			next--;
			while(count<k)
			{
				next=(next+1)%n;
				if(queue[next]>0)
				{
					count++;
				}
			}
			queue[killed]=queue[next];
			queue[next]=0;
			next=killed;
			i--;
		}
		for(i=0;i<n;i++)
		{
			if(queue[i]>0)
			{
				if(queue[i]==1)
				{
					System.out.println(1);
				}
				else
				{
					System.out.println((n-queue[i]+2));
				}
			}
		}
	}

}
