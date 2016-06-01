import java.util.Arrays;
import java.util.Scanner;


//TODO No enviado - Gas Stations
public class Main12321 {

	/**
	 * @param args
	 */
	public static void main(String[] args) 
	{
		Scanner input=new Scanner(System.in);
		int l,g, i,aux, x,r,j;
		while(true)
		{
			l=input.nextInt();
			g=input.nextInt();
			if(g==0)
			{
				break;
			}
			 aux=-1;
			int[] arreglo=new int[2*g];
			for( i=0;i<g;i++)
			{
				 x=input.nextInt();
				 r=input.nextInt();
				aux++;
				arreglo[aux]=x-r;
				aux++;
				arreglo[aux]=x+r;
			}			
			if(arreglo[0]>0 || arreglo[aux]<l)
			{
				System.out.println("-1");
				continue;
			}
			boolean comp=true;
			for(i=2;i<2*g;i+=2)
			{
				if(arreglo[i]>arreglo[i-1])
				{
					System.out.println("-1");
					comp=false;
					break;
				}
			}
			if(!comp)
			{
				continue;
			}
			j=i=0;
			
			int [] solucion=new int[g];
			while(arreglo[i]<=0)
			{
				solucion[j]=calcular(arreglo,i);
				if(solucion[j]>0)
				{
					solucion[j]+=i/2;
				}
				j++;
				i+=2;

				
			}
			Arrays.sort(solucion);
			System.out.println(solucion[g-1]);
			
			
			
			//int solucion[]=new int[];
			//boolean found=false;
			/*for(int i=1;i<aux;i+=2)
			{
				if(arreglo[i]<arreglo[i+1])
				{
					found=true;
					break;
				}
			}*/
			/*System.out.println(Arrays.toString(arreglo));
			 eliminados=0;
			 //int comp=arreglo[2*g-2];
			 //System.out.println("vvvv"+comp);
				for( i=2;i<2*g-2;i+=2)
				{
					System.out.println(arreglo[i-1]+"  "+arreglo[i]);
					if(arreglo[i-1]>arreglo[i])
					{
						eliminados++;
						arreglo[i-1]=-1;
						arreglo[i-2]=-1;
						System.out.println("1 "+Arrays.toString(arreglo));
					}
					System.out.println(arreglo[i+1]+" * "+arreglo[i+2]);
					if(arreglo[i+1]>arreglo[i+2])
					{
						eliminados++;
						arreglo[i+2]=-1;
						arreglo[i+3]=-1;
						System.out.println("2 "+Arrays.toString(arreglo));
						i+=2;
					}					
					System.out.println("\n");					
				}
				int eliminados1=0;
				System.out.println("\n\n");
				for( i=2;i<2*g-2;i+=2)
				{
					System.out.println(arreglo[i-1]+"  "+arreglo[i]);
					if(arreglo[i-1]>arreglo[i])
					{
						eliminados1++;
						arreglo[i]=-1;
						arreglo[i+1]=-1;
						System.out.println("1 "+Arrays.toString(arreglo));
					}
					System.out.println(arreglo[i+1]+" * "+arreglo[i+2]);
					if(arreglo[i+1]>arreglo[i+2])
					{
						eliminados1++;
						arreglo[i+2]=-1;
						arreglo[i+3]=-1;
						System.out.println("2 "+Arrays.toString(arreglo));
						i+=2;
					}					
					System.out.println("\n");					
				}
				System.out.println("salio i "+i);
				System.out.println(Arrays.toString(arreglo)+"   "+eliminados+"   "+eliminados1);

			*/
		}
		input.close();

	}

	private static int calcular(int[] arreglo, int inicio) 
	{
		System.out.println(Arrays.toString(arreglo)+"   "+inicio);
		int eliminados=0,comp=arreglo[inicio+1];
		for(int i=inicio+2;i<arreglo.length;i+=2)
		{
			if(arreglo[i]<comp)
			{
				System.out.println(arreglo[i]+"   "+i+"   "+comp);
				eliminados++;
				continue;
			}
			comp=arreglo[i+1];
		}
		return eliminados;
	}
}

/*
 40 3
 5 5
 20 10
 40 10
 
 40 5
 5 5
 11 8
 20 10
 30 3
 40 10
 
 40 5
 0 10
 10 10
 20 10
 30 10
 40 10
 
 40 3
 10 10
 18 10
 25 10
 
 40 3
 10 10
 18 10 
 25 15
 
 */
