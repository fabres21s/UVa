import java.util.Collections;
import java.util.Scanner;
import java.util.Vector;

/**
*	10008 - What's Cryptanalysis?
*
*
*	Submision:	9520737
*	Date:		2011-11-30 12:20:52
*	Runtime:	0.212
*	Ranking:	12229
*/
public class Main10008 
{
	/**
	 * - Cadena de caracteres
	 * 
	 */
	//TODO String - Poner categoria
	public static void main(String[] args) 
	{
		Vector <Integer>v=new Vector<Integer>();
		Scanner input=new Scanner(System.in);
        int  [][]arreglo=new int[26][2];
        int aux,i,j, k, min;
        for(i=0;i<26;i++)        
            arreglo[i][0]=i;        
        int lineas=input.nextInt();
        String abc="ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String linea;
        while(lineas>-1)
        {
            lineas--;
            linea=input.nextLine().toUpperCase();
            for( i=0;i<linea.length();i++)
            {
            	aux=abc.indexOf(linea.charAt(i));
            	if(aux>-1)                
                    arreglo[aux][1]++;                
            }
        }
        for( i=0;i<25;i++)
        {
        	min=i;
            for( j=i+1;j<26;j++)            
            	if(arreglo[j][1]>arreglo[min][1])            	
            		min=j;            	            
            if(i!=min)
            {
            	aux=arreglo[i][1];
                arreglo[i][1]=arreglo[min][1];
                arreglo[min][1]=aux;
                aux=arreglo[i][0];
                arreglo[i][0]=arreglo[min][0];
                arreglo[min][0]=aux;
            }
        }   
        for(i=1;i<26;i++)
        {
        	if(arreglo[i-1][1]==arreglo[i][1] && arreglo[i-1][1]>0)
        	{
        		v=new Vector<Integer>();
        		min=i;
        		while(arreglo[i-1][1]==arreglo[i][1])
        		{    
        			v.add(arreglo[i-1][0]);
        			i++;
        			if(i==26)        			
        				break;        			
        		}
        		v.add(arreglo[i-1][0]);
        		Collections.sort(v);
        		for(k=min;k<=i;k++)       		
        			arreglo[k-1][0]=v.get(k-min);        		        		
        	}
        }        
        i=0;   
        StringBuffer buffer=new StringBuffer();
        while(arreglo[i][1]!=0)
        {
            buffer.append(abc.charAt(arreglo[i][0])+" "+arreglo[i][1]+"\n");
            i++;
            if(i==26)            
            	break;            
        }
        System.out.print(buffer);
        input.close();
	}
}
