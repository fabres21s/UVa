import java.util.Scanner;


public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner input=new Scanner(System.in);
		StringBuffer buffer=new StringBuffer();
		int casos=input.nextInt()+1;
		int n,j,sol;
		int arreglo[];
		for(int i=1;i<casos;i++){
			sol=0;
			arreglo=new int[4];
			n=input.nextInt();
			j=2;
			while(sol<3){
				if(n%j==0){
					arreglo[sol]=j;
					arreglo[sol+1]=n/j;
					sol+=2;
				}
				j++;
			}
			buffer.append("Case #"+i+": "+n+" = "+arreglo[0]+" * "+arreglo[1]+" = "+arreglo[2]+" * "+arreglo[3]+"\n");
		}		
		System.out.println(buffer.toString());
		input.close();
		// TODO Auto-generated method stub

	}

}
