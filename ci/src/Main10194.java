import java.util.Arrays;
import java.util.Scanner;

/*
 *   No enviado
 */
//TODO No enviado - Football (aka Soccer)
public class Main10194 
{
	static int [][] tablaposiciones;
	static int  aux[];
	static String equipos[], tokens[];
	static String x;
	/**
	 * @param args
	 */
	public static void main(String[] args) 
	{
		Scanner input=new Scanner(System.in);
		Scanner texto;//=new Scanner(System.in);
		int casos,equipoA,equipoB,golesA,golesB,j,i, partidos;
		String nombretorneo;
		String tokensb[];
		casos=input.nextInt();	
		boolean flag;
		while(casos>0)
		{
			flag=false;
			casos--;
			texto=new Scanner(System.in);
			nombretorneo=texto.nextLine();
			System.out.println(nombretorneo);
			j=input.nextInt();
			equipos=new String[j];
			for(i=0;i<j;i++)
			{
				equipos[i]=texto.nextLine();
			}
			Arrays.sort(equipos);
			tablaposiciones=new int [equipos.length][8];
			partidos=input.nextInt();
			while(partidos>0)
			{
				partidos--;
				tokens=texto.nextLine().split("@");
				tokensb=tokens[0].split("#");
				golesA=Integer.valueOf(tokensb[1]);
				equipoA=Arrays.binarySearch(equipos, tokensb[0]);
				tokensb=tokens[1].split("#");
				golesB=Integer.valueOf(tokensb[0]);
				equipoB=Arrays.binarySearch(equipos,tokensb[1] );
				tablaposiciones[equipoA][1]++;
				tablaposiciones[equipoB][1]++;
				if(golesA>golesB)
				{
					tablaposiciones[equipoA][0]+=3;
					tablaposiciones[equipoA][2]++;
					tablaposiciones[equipoB][4]++;
				}
				else if(golesA<golesB)
				{
					tablaposiciones[equipoB][0]+=3;
					tablaposiciones[equipoB][2]++;
					tablaposiciones[equipoA][4]++;
				}
				else
				{
					tablaposiciones[equipoA][0]++;
					tablaposiciones[equipoB][0]++;
					tablaposiciones[equipoA][3]++;
					tablaposiciones[equipoB][3]++;
				}
				tablaposiciones[equipoA][6]+=golesA;
				tablaposiciones[equipoA][7]+=golesB;
				tablaposiciones[equipoB][6]+=golesB;
				tablaposiciones[equipoB][7]+=golesA;							
			}			
			for(i=0;i<equipos.length;i++)
			{
				tablaposiciones[i][5]=tablaposiciones[i][6]-tablaposiciones[i][7];
			}
			ordenar(0,0,equipos.length);			
			for(i=0;i<equipos.length-1;i++)
			{
				j=i+1;
				while(tablaposiciones[j][0]==tablaposiciones[i][0])
				{
					j++;
					if(j==equipos.length)
					{
						break;
					}
				}
				if((j-1)!=i)
				{
					flag=true;
					while(j>i)
					{
						j++;
					}
					ordenar(2,i,j);
				}
			}
			if(flag)
			{
				flag=false;
				for(i=0;i<equipos.length-1;i++)
				{
					j=i+1;
					while(tablaposiciones[j][0]==tablaposiciones[i][0] && tablaposiciones[j][2]==tablaposiciones[i][2])
					{
						j++;
						if(j==equipos.length)
						{
							break;
						}
					}
					if((j-1)!=i)
					{
						flag=true;
						ordenar(5,i,j);
					}
				}
				if(flag)
				{
					flag=false;
					for(i=0;i<equipos.length-1;i++)
					{
						j=i+1;
						while(tablaposiciones[j][0]==tablaposiciones[i][0] && tablaposiciones[j][2]==tablaposiciones[i][2] && tablaposiciones[j][5]==tablaposiciones[i][5])
						{
							j++;
							if(j==equipos.length)
							{
								break;
							}
						}
						if((j-1)!=i)
						{
							flag=true;
							ordenar(6,i,j);
						}
					}
					if(flag)
					{
						flag=false;
						for(i=0;i<equipos.length-1;i++)
						{
							j=i+1;
							while(tablaposiciones[j][0]==tablaposiciones[i][0] && tablaposiciones[j][2]==tablaposiciones[i][2] && tablaposiciones[j][5]==tablaposiciones[i][5] && tablaposiciones[j][6]==tablaposiciones[i][6])
							{
								j++;
								if(j==equipos.length)
								{
									break;
								}
							}						
							if((j-1)!=i)
							{
								flag=true;
								ordenarmenor(1,i,j);
							}
						}
					}
					if(flag)
					{
						for(i=0;i<equipos.length-1;i++)
						{
							j=i+1;
							while(tablaposiciones[j][0]==tablaposiciones[i][0] && tablaposiciones[j][2]==tablaposiciones[i][2] && tablaposiciones[j][5]==tablaposiciones[i][5] && tablaposiciones[j][6]==tablaposiciones[i][6] && tablaposiciones[j][1]==tablaposiciones[i][1])
							{
								j++;
								if(j==equipos.length)
								{
									break;
								}
							}						
							if((j-1)!=i)
							{
								/*while(j>i)
								{
									j++;
								}*/
								//flag=true;
								//lexicograph(i,j);
							}
						}
					}
				}
			}
			//System.out.println(nombretorneo);
			for(i=0;i<equipos.length;i++)
			{
				System.out.printf("%d) %s %dp, %dg (%d-%d-%d), %dgd (%d-%d)\n",(i+1),equipos[i],tablaposiciones[i][0],tablaposiciones[i][1],tablaposiciones[i][2],tablaposiciones[i][3],tablaposiciones[i][4], tablaposiciones[i][5],tablaposiciones[i][6],tablaposiciones[i][7]);
			}
			System.out.println();
		}
		input.close();
	}
	
	/*private static void lexicograph(int inicio,int fin)
	{
		int i,j,min;
		for(i=inicio;i<fin-1;i++)
		{
			min=i;
			for(j=i+1;j<fin;j++)
			{
				if(equipos[j].compareToIgnoreCase(equipos[min])>1)
				{
					min=j;
				}
			}
	    	if(min!=i)
	    	{
	    		aux=tablaposiciones[i];
	    		tablaposiciones[i]=tablaposiciones[min];
	    		tablaposiciones[min]=aux;
	    		x=equipos[i];
	    		equipos[i]=equipos[min];
	    		equipos[min]=x;
	    	}
		}
	}*/

	private static void ordenarmenor(int columna, int inicio, int fin) 
	{
		int i,j,min;
	    for(i=inicio;i<fin-1;i++)
	    {
	    	min=i;
	    	for(j=i+1;j<fin;j++)
	    	{
	    		if(tablaposiciones[j][columna]<tablaposiciones[min][columna])
	    		{
	    			min=j;
	    		}
	    	}
	    	if(min!=i)
	    	{
	    		aux=tablaposiciones[i];
	    		tablaposiciones[i]=tablaposiciones[min];
	    		tablaposiciones[min]=aux;
	    		x=equipos[i];
	    		equipos[i]=equipos[min];
	    		equipos[min]=x;
	    	}
	    }
	}

	private static void ordenar(int columna, int inicio, int fin) 
	{
	    int i,j,max;
	    for(i=inicio;i<fin-1;i++)
	    {
	    	max=i;
	    	for(j=i+1;j<fin;j++)
	    	{
	    		if(tablaposiciones[j][columna]>tablaposiciones[max][columna])
	    		{
	    			max=j;
	    		}
	    	}
	    	if(max!=i)
	    	{
	    		aux=tablaposiciones[i];
	    		tablaposiciones[i]=tablaposiciones[max];
	    		tablaposiciones[max]=aux;
	    		x=equipos[i];
	    		equipos[i]=equipos[max];
	    		equipos[max]=x;
	    	}
	    }
	}
}
