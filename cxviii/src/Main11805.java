import java.util.Scanner;


public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) 
	{
		int c,res,p,k,n,i;
		Scanner input=new Scanner(System.in);
		c=input.nextInt()+1;
		for(i=1;i<c;i++)
		{
			n=input.nextInt();
			k=input.nextInt();
			p=input.nextInt();
			if(p+k>n)
				res=p+k-n;
			else
				res=p+k;
			while(res>n)
				res-=n;
			System.out.printf("Case %d: %d\n",i,res);
		}
		// TODO Auto-generated method stub

	}

}
