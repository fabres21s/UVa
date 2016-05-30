import java.util.Scanner;


public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner input=new Scanner(System.in);
		int casos=input.nextInt()+1,res;
		char p [];
		for(int i=1;i<casos;i++){
			res=input.nextInt();
			res=0;
			p=input.next().toCharArray();
			for(int j=0;j<p.length;){
				if(p[j]=='.'){
					j+=3;
					res++;
				}
				else
					j++;
			}
			System.out.printf("Case %d: %d\n",i,res);
		}
		// TODO Auto-generated method stub

	}

}
