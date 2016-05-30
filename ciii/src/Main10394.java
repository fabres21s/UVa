import java.io.IOException;
import java.util.Scanner;

public class Main {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException 
	{
		Scanner input=new Scanner (System.in);
		int a,b,n, top=0;
		int []num=new int [20000002];
		int ans [][]=new int [100010][2];
		num[0]=num[1]=num[2]=1;
		for(a=3;a<20000001;a=a+2)
		{
			if(num[a]==0)
			{
				for(b=3;a*b<=20000000;b=b+2)
					num[a*b]=1;
				if(num[a-2]== 0 && top<=100009)
				{
					top++;
					ans[top][0]=a-2;
					ans[top][1]=a;
				}
				if(top>=100009)
					break;
			}
		}
		while(input.hasNext())
		{
			n=input.nextInt();
			System.out.printf("(%d, %d)\n",ans[n][0],ans[n][1]);
		}
		input.close();
		// TODO Auto-generated method stub
	}
}
