import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;
import java.util.Vector;

/*
 *   Fabio Andr�s Sierra Jaraba
 *   Ananagrams    
 *   UVa:  156
 *    
 */

public class Main156 {

	/**
	 * @param args
	 */
	public static void main(String[] args) 
	{
		Scanner input=new Scanner(System.in);
		String p;
		Vector <String> diccionario=new Vector<String>();
		while(!(p=input.next()).equals("#"))
		{
			diccionario.add(p);
		}
		Vector <String> salida=new Vector<String>();
		salida=diccionario;
		//System.out.println(diccionario.size());
		char [] p1,p2;
		boolean found =false;
		for(int i=0;i<diccionario.size();i++)
		{
			p1=diccionario.get(i).toLowerCase().toCharArray();
			found=false;
			Arrays.sort(p1);
			//System.out.println("p1");
			//imprimir(p1);
			for(int j=i+1;j<diccionario.size();j++)
			{
				p2=diccionario.get(j).toLowerCase().toCharArray();
				Arrays.sort(p2);
				if(Arrays.equals(p1, p2))
				{
					found=true;
					diccionario.remove(j);
					j--;
				}
			}
			if(found)
			{
				diccionario.remove(i);
				i--;
			}
		}
		Collections.sort(salida);
		for(int i=0;i<diccionario.size();i++)
		{
			if(diccionario.contains(salida.get(i)))
			{
				System.out.println(salida.get(i));
			}
		}
		//System.out.println(diccionario.size());
		
		// TODO Auto-generated method stub

	}
	
	/*static void imprimir(char [] cadena)
	{
		for(int i=0; i<cadena.length; i++)
		{
			System.out.print(cadena[i]);
		}
		System.out.println("\n");
	}*/

}
