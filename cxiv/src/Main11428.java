import java.util.Scanner;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) 
	{
		int cubos []=new int [1000];
		for(int i=1;i<1000;i++)		
			cubos[i]=i*i*i;		
		Scanner input=new Scanner(System.in);
		int n,i,j;
		while((n=input.nextInt())!=0)
		{
			i=2;
			while(true)
			{
				j=1;
				while((cubos[i]-cubos[j])>n)
				{
					j++;					
				}
				if((cubos[i]-cubos[j])==n)
				{
					System.out.println(i+" "+j);
					break;
				}
				else if((cubos[i]-cubos[i-1])>n)
				{
					System.out.println("No solution");
					break;
				}
				i++;
			}
		}
		input.close();
		// TODO Auto-generated method stub
	}
}
