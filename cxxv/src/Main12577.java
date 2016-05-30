import java.util.Scanner;


public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int casos=1;
		Scanner input=new Scanner(System.in);
		String word;
		while(!(word=input.next()).equals("*")){
			if(word.length()==4){
				System.out.printf("Case %d: Hajj-e-Akbar\n",casos);
			}else{
				System.out.printf("Case %d: Hajj-e-Asghar\n",casos);
			}
			casos++;
		}
		input.close();
		// TODO Auto-generated method stub

	}

}
