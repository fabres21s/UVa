import java.util.Arrays;

public class Main {

	//524
	private static int primos[] = {2,3,5,7,11,13,17,19,23,29,31};
	
	public static void main(String[] args) {
		int numbers[] ={2};
		permute(numbers, 0, 0);
		
		
		

	}
	
	public static void permute(int[] ary, int startIndex, int endIndex) {
        if(startIndex == endIndex){
        	
        	evaluate(ary); 
        	
        }else{
            for(int i=startIndex;i<=endIndex;i++) {
                 swap(ary, startIndex, i );
                 permute(ary, startIndex+1, endIndex);
                 swap(ary, startIndex, i );
            }
        }
    }

    private static void evaluate(int[] ary) {
    	int ant = 1;
    	boolean isSolution = true;
    	for (int c : ary) {
    		if (Arrays.binarySearch(primos, (c + ant)) < 0) {
    			isSolution = false;
    			break;
    		}
    		ant = c;
    	}
    	
    	
    	if (isSolution) {
    		if (Arrays.binarySearch(primos, 1 + ary[ary.length - 1]) > 0) {
    			System.out.println(Arrays.toString(ary));
    		}
    	}
    	
    	
	}

	public static void swap(int[] ary, int x, int y) {
        int temp = ary[x];
        ary[x] = ary[y];
        ary[y] = temp;
    }

}
