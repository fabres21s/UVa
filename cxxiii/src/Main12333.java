import java.util.Scanner;

//TODO Perdido - Revenge of Fibonacci
public class Main12333 {

	/**
	 * @param args
	 */
	public static void main(String[] args) 
	{
		Scanner input=new Scanner(System.in);
		String palabra="";
		int c=0;
		while(!(palabra=input.next()).equals("#"))
		{
			c++;
		}
		System.out.println(palabra+" " +c);
		input.close();

	}

}
