import java.util.Scanner;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) 
	{
		Scanner input=new Scanner(System.in);
		int i,j,k,ck=-1;
		char a[],s[];
		while(input.hasNext())
		{
			k=0;
			a=input.next().toCharArray();
			s=input.next().toCharArray();
			for(i=0;i<a.length;i++)
			{
				ck=0;
				for(j=k;j<s.length;j++)
				{
					if(a[i]==s[j])
					{
						k=j+1;
						ck=1;
						break;
					}
				}
				if(ck==0)
				{
					break;
				}
			}
			if(ck!=0)
			{
				System.out.println("Yes");
			}
			else
			{
				System.out.println("No");
			}
		}
	    input.close();
		// TODO Auto-generated method stub
	}
}
