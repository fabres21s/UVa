import java.util.Arrays;
import java.util.Scanner;

//TODO TLE - Xavier is Learning to Count 
public class Main12327 
{
	static int numeros[];
	static StringBuffer buf;
	/**
	 * time limit - revisar como poder optimizarlo y/o pasarlo a C
	 */
	public static void main(String[] args) 
	{
		
		Scanner input=new Scanner(System.in);
		int casos=input.nextInt();
		int tam, p, j;
		for(int i=1; i<=casos;i++)
		{
			tam=input.nextInt();
			p=input.nextInt();
			int arreglo[]=new int [tam];
			for(j=0; j<tam;j++)
			{
				arreglo[j]=input.nextInt();
			}
			System.out.println("Case # "+i+":");
			evaluar(arreglo, p);
		}
		input.close();

	}
	
	static void evaluar(int [] arreglo, int p)
	{
		numeros=new int [65000];
		int i,j,k,l,m;
		Arrays.sort(arreglo);
		
		switch(p)
		{
		case 1:
			for( i=0;i<arreglo.length;i++)
			{
				System.out.println(arreglo[i]+": "+1);
			}
			break;
		case 2:
			for(i=0;i<arreglo.length-1;i++ )
			{
				for(j=i+1;j<arreglo.length;j++)
				{
					numeros[arreglo[i]+arreglo[j]]++;
				}
			}
			break;
		case 3:
			for(i=0;i<arreglo.length-2;i++ )
			{
				for(j=i+1;j<arreglo.length-1;j++)
				{
					for(k=j+1;k<arreglo.length;k++)
					{
						numeros[arreglo[i]+arreglo[j]+arreglo[k]]++;					
					}
				}
			}
			break;
		case 4:
			for(i=0;i<arreglo.length-3;i++ )
			{
				for(j=i+1;j<arreglo.length-2;j++)
				{
					for(k=j+1;k<arreglo.length-1;k++)
					{
						for(l=k+1;l<arreglo.length;l++)
						{
							numeros[arreglo[i]+arreglo[j]+arreglo[k]+arreglo[l]]++;
						}
					}
				}
			}
			break;
		case 5:
			for(i=0;i<arreglo.length-4;i++ )
			{
				for(j=i+1;j<arreglo.length-3;j++)
				{
					for(k=j+1;k<arreglo.length-2;k++)
					{
						for(l=k+1;l<arreglo.length-1;l++)
						{
							for(m=l+1;m<arreglo.length;m++)
							{								
								numeros[arreglo[i]+arreglo[j]+arreglo[k]+arreglo[l]+arreglo[m]]++;
							}
						}
					}
				}
			}
			break;				
		}
		buf=new StringBuffer();
		if(p!=1)
		{
			k=0;
			for(i=arreglo.length-1;i>arreglo.length-1-p;i--)
			{
				k+=arreglo[i];
			}
			for(i=1;i<=k;i++)
			{
				if(numeros[i]!=0)
				{
					buf.append((i)+": "+numeros[i]+"\n");
				}
			}
		}
		System.out.println(buf);
	}
}
