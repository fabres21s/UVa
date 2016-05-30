import java.util.Scanner;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) 
	{
		Scanner input=new Scanner(System.in);
		int k=input.nextInt();
		System.out.println("Lumberjacks:");
		int i;
		while(k>0)
		{
			k--;
			boolean asc=true ,desc=true;
			int act, next;
			act=input.nextInt();
			for(i=1;i<10;i++)
			{
				next=input.nextInt();
				
				asc&=(next>act);
				desc&=(act>next);
				act=next;
			}
			System.out.println((asc || desc)?"Ordered":"Unordered");			
		}
		input.close();
		// TODO Auto-generated method stub
	}
}
