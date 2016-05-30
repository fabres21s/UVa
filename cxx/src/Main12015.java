import java.util.Scanner;

/*
 * Fabio Andrés Sierra
 * Google is Feeling Lucky
 * UVa: 12015
 */
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) 
	{
		Scanner input=new Scanner(System.in);
		int []relevances=new int[10];
		int max,i,j;
		String urls[]=new String[10];
		int k=input.nextInt()+1;
		for(i=1;i<k;i++)
		{
			max=-1;
			for(j=0;j<10;j++)
			{
				urls[j]=input.next();
				relevances[j]=input.nextInt();
				if(relevances[j]>max)
					max=relevances[j];
			}
			System.out.printf("Case #%d:\n",i);
			for(j=0;j<10;j++)
				if(relevances[j]==max)
					System.out.println(urls[j]);
		}
		// TODO Auto-generated method stub

	}

}
