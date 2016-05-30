import java.util.Scanner;
import java.util.Vector;
 
public class Main 
{
	static Vector<Integer> v=new Vector<Integer>();

	/**
	 * @param args
	 */
	public static void main(String[] args) 
	{
		Scanner input=new Scanner (System.in);				
		long r;
		double root, num;
		while((num=input.nextLong())!=0)
		{
			r=(long)Math.sqrt(num);
			root=Math.pow(r, 2);
			if(root==num)
			{
				System.out.println("yes");
			}
			else
			{
				System.out.println("no");
			}			
		}
		input.close();
		// TODO Auto-generated method stub
	}
}



