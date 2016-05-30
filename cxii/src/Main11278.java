import java.io.IOException;
import java.util.Scanner;


public class Main {
	
	static char [] qwertyu=" `1234567890-=qwertyuiop[]\\asdfghjkl;'zxcvbnm,./~!@#$%^&*()_+QWERTYUIOP{}|ASDFGHJKL:\"ZXCVBNM<>?".toCharArray();
	static char [] devorak=" `123qjlmfp/[]456.orsuyb;=\\789aehtdck-0zx,inwvg'~!@#QJLMFP?{}$%^>ORSUYB:+|&*(AEHTDCK_)ZX<INWVG\"".toCharArray();
	private static Scanner input;
	
	
	public static void main(String [] args) throws IOException
	{
		try{

		input = new Scanner(System.in);
		char [] a;
		StringBuffer buffer;
		int i;
		while(true)
		{
		
			a=input.nextLine().toCharArray();
			if(a.length==0){
				System.out.println();
				continue;
			}
			buffer=new StringBuffer();
			for(i=0;i<a.length;i++)
				buffer.append(buscar(a[i]));
			System.out.println(buffer.toString());

		}
		}
		catch(Exception e){}
		
	}

	private static char buscar(char c) 
	{
		int i=0;
		while(qwertyu[i]!=c)
			i++;
		return devorak[i];
	}

}
