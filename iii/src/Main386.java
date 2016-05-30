
/**
*	386 - Perfect Cubes
*
*
*	Submision:	9573621
*	Date:		2011-12-19 02:21:54
*	Runtime:	0.432
*	Ranking:	2591
*/
public class Main386 {

	/**
	 * @param args
	 */
	public static void main(String[] args) 
	{
		int n,i,j,k,i3,n3,j3,k3;
		n=6;
		while(n<201)
		{	
			n3=n*n*n;
			for(i=2; i<n;i++)
			{	
				i3=i*i*i;
				for(j=i+1;j<n;j++)
				{			
					j3=j*j*j;
					for(k=j+1;k<n;k++)
					{
						k3=k*k*k;
						if(n3==(i3+j3+k3))
						{
							System.out.printf("Cube = %d, Triple = (%d,%d,%d)\n",n,i,j,k);
						}
					}
				}
			}
			n++;
		}
		// TODO Auto-generated method stub
	}
}
