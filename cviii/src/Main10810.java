import java.util.Arrays;

//TODO No enviado - Ultra-QuickSort
public class Main10810 {

	static int array[];
	static int length;
	static int tempMergArr[];
	static int intercambios =0;
	static int intercambios2 =0;
	static int intercambios3 =0;

	public static void main(String[] args) {
		int arreglo[] = {9,1,0,5,4};
	rapido(arreglo, 0, 4);
//	System.out.println(Arrays.toString(array));
	System.out.println(intercambios);

	}

	
   static  void rapido(int [] a, int primero, int ultimo)
   {
        
      int  i=primero;
       int j=ultimo;
   int    der=a[(primero+ultimo)/2];//der es el mismo pivote
       //System.out.println(der);

       do
       {           
           while(a[i]<der)
           {
              // iteraciones++;
               i++;
           }
           while(a[j]>der)
           {
               //iteraciones++;
               j--;
           }
           if(i<=j)
           {
               a=intercambios(a, j, i);                
               i++;
               j--;
           }
       }while(i<=j);

       
       if(primero<j)
       {
           rapido(a, primero, j);

       }
       if(ultimo>i)
       {
           rapido(a, i, ultimo);
       }
   }
    
    static  int [] intercambios(int []a, int x, int y)
    {
       int  aux=a[x];
        intercambios++;
        a[x]=a[y];
        a[y]=aux;
        System.out.println(Arrays.toString(a));
        return a;
    }
	
	static void sort(int inputArr[]) {
		array = inputArr;
		length = inputArr.length;
		tempMergArr = new int[length];
		doMergeSort(0, length - 1);
	}

	static void doMergeSort(int lowerIndex, int higherIndex) {

		if (lowerIndex < higherIndex) {
			int middle = lowerIndex + (higherIndex - lowerIndex) / 2;
			// Below step sorts the left side of the array
			doMergeSort(lowerIndex, middle);
			// Below step sorts the right side of the array
			doMergeSort(middle + 1, higherIndex);
			// Now merge both sides
			mergeParts(lowerIndex, middle, higherIndex);
		}
	}

	static void mergeParts(int lowerIndex, int middle, int higherIndex) {

		for (int i = lowerIndex; i <= higherIndex; i++) {
			tempMergArr[i] = array[i];
		}
		int i = lowerIndex;
		int j = middle + 1;
		int k = lowerIndex;
		while (i <= middle && j <= higherIndex) {
			if (tempMergArr[i] <= tempMergArr[j]) {
				array[k] = tempMergArr[i];
				intercambios++;
				i++;
			} else {
				intercambios2++;
				array[k] = tempMergArr[j];
				j++;
			}
			k++;
		}
		while (i <= middle) {
			array[k] = tempMergArr[i];
			intercambios3++;
			k++;
			i++;
		}

	}
}
