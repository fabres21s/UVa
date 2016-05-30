
import java.util.Arrays;
import java.util.Scanner;


public class Main {

	/**
	 * 
	 * 
	 * 
	 * wa - no entiendo porque
	 */
	public static void main(String[] args) 
	{
		Scanner input=new Scanner(System.in);
		int n,q,busq,i,casos=1;
		int marbles[];
		StringBuffer buffer = new StringBuffer();
		
		while(true)
		{
			n=input.nextInt();
			q=input.nextInt();
			if (n==0){
				break;
			}
			marbles=new int[n];
			for(i=0;i<n;i++)
				marbles[i]=input.nextInt();
			//buffer.append("CASE# "+casos+":\n");
			System.out.printf("CASE# %d:\n",casos);
			Arrays.sort(marbles);
			for(i=0;i<q;i++)
			{
				busq=input.nextInt();
				
				int p=-1;
				for (int k=0; k< n; k++){
					if (marbles[k] == busq){
						p = k+1;
						break;
					}
					if(marbles [k] > busq){
						break;
					}
				}
				
				if(p>-1){

					
					//buffer.append(busq+" found at "+(p)+"\n");
					System.out.printf("%d found at %d\n",busq,(p));
				}
				else{
					//buffer.append(busq+" not found\n");
					System.out.printf("%d not found\n",busq);
				}
			}
			casos++;
		}
		//System.out.println(buffer.toString());
		input.close();
		// TODO Auto-generated method stub
	}
}
