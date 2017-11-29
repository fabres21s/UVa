import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
*	10810 - Ultra-QuickSort
*
*
*	Submision:	20417474
*	Date:		2017-11-29 13:24:46
*	Runtime:	0.260
*	Ranking:	1435
*/
public class Main10810 {

	static int array[];
	static int length;
	static int L[];
	static int R[];
	static long intercambios =0;
	static int inf =Integer.MAX_VALUE;

	/**
	 * - Sort
	 * 
	 *  Utilizando el método de ordenamiento Merge Sort, contar los intercambios necesarios para ordenar un arreglo
	 *  
	 */
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringBuffer output = new StringBuffer();
		int n;
		int array[];
		while ((n = Integer.parseInt(br.readLine())) != 0) {
			array = new int[n];
			for (int i = 0; i < n; i++) {
				array[i] = Integer.parseInt(br.readLine());
			}
			intercambios = 0;
			sort(array);
			output.append(intercambios);
			output.append("\n");
		}
		System.out.print(output);

	}

	
  
	static void sort(int inputArr[]) {
		array = inputArr;
		length = inputArr.length;
		L = new int[length + 1];
		R = new int[length + 1];
		doMergeSort(0, length - 1);
	}

	
	/**
	 * 
	 * @param lowerIndex = p
	 * @param higherIndex = r
	 * middle = q
	 */
	static void doMergeSort(int lowerIndex, int higherIndex) {

		if (lowerIndex < higherIndex) {
			int middle = (higherIndex + lowerIndex) / 2;
			// Below step sorts the left side of the array
			doMergeSort(lowerIndex, middle);
			// Below step sorts the right side of the array
			doMergeSort(middle + 1, higherIndex);
			// Now merge both sides
			mergeParts(lowerIndex, middle, higherIndex);
		}
	}

	
	/**
	 * 
	 * @param lowerIndex = p
	 * @param higherIndex = r
	 * middle = q
	 */
	static void mergeParts(int p, int q, int r) {

		 int ind1,ind2,k,i,j;
		    for(i=p,ind1=1; i<=q; i++)
		        L[ind1++]=array[i];
		    L[ind1]=inf;
		    for(i=q+1,ind2=1; i<=r; i++)
		        R[ind2++]=array[i];
		    R[ind2]=inf;
		    i=j=1;
		    for(k=p; k<=r; k++)
		    {

		        if(L[i]>R[j])
		        {
		            intercambios+=ind1-i;
		            array[k]=R[j];
		            j++;
		        }
		        else
		        {
		            array[k]=L[i];
		            i++;
		        }

		    }
	}
}
