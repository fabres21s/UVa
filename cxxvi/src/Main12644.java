import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;


//TODO No enviado - Vocabulary
public class Main12644 {

	/**
	 * no enviado a Uva
	 */
	public static void main(String[] args) {
		
		Scanner input=new Scanner(System.in);
		int v,c,i,j,x;
		while(input.hasNext()){
			//args=input.nextLine().split(" ");
			v=input.nextInt();
			c=input.nextInt();
			input.nextLine();
			ArrayList<String> jack=new ArrayList<String>();
			for(i=0;i<v;i++){
				jack.add(input.next());
			}
			//ArrayList<String> jill=new ArrayList<String>();
			int posibles=0;
			for(i=0;i<c;i++){
				char [] jill=input.next().toCharArray();
				Arrays.sort(jill);
				
				for(j=0;j<jack.size();j++){
					char vocabularioJack[]=jack.get(j).toCharArray();
					Arrays.sort(vocabularioJack);
					boolean found=true;
					for(x=0;x<jill.length;x++){
						if(Arrays.binarySearch(vocabularioJack,jill[x])<0){
							found=false;
							break;
						}
					}
					if(found){
						posibles++;
						jack.remove(j);
						break;
					}
				}
				
			}
			System.out.println(posibles);
			
			input=new Scanner(System.in);
		}
		input.close();

	}

}
