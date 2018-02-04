import java.util.Scanner;

public abstract class MergeSort {
	static int comparisons=0;
	static Integer x, y;

	//overridden function compareTo that increments the global counter
	public static int compare(int l,int r)
	{
		comparisons++;
		x = Integer.valueOf(l);
		y = Integer.valueOf(r);
		return x.compareTo(y);
	}
	public static void main(String[] args)
	{
		Scanner input=new Scanner(System.in);
		//Parse length of array from first line
		int length = Integer.parseInt(input.nextLine().replaceAll("n ", ""));
		//int length=input.nextInt();

		int[] myArray= new int[length];

		for(int i=0;i<length;i++)
			myArray[i]=input.nextInt();
		input.close();

		//Record system time at start
		long startTime = System.currentTimeMillis();
		//Call to merge sort
		merge_sort(myArray);
		//Record system time at end
		long endTime = System.currentTimeMillis();
		//Difference is elapsed time and convert to integer.
		long elapsedTime = endTime - startTime;
		//Check to see if long goes over max integer value
		if(elapsedTime > Integer.MAX_VALUE){
			throw new IllegalArgumentException(elapsedTime + "cannot convert to int without modifying value");
		}
		//Typecast to integer and write to variable
		int runtime = (int) elapsedTime;
		printArray(myArray);

		//Write runtime and key comparisons to standard error
		System.err.println("runtime," + runtime);
		System.err.println("comparisons," + comparisons);


	}
	//recursively split the array and then merge
	public static void merge_sort(int[] myArray)
	{


		 if (myArray.length > 1)
		 {
	            // split array into two halves
	            int[] L = leftHalf(myArray);
	            int[] R = rightHalf(myArray);

	            // recursively sort the two halves
	            merge_sort(L);
	            merge_sort(R);

	            // merge the sorted halves into a sorted whole
	            merge(myArray, L, R);
	        }


	}
	public static int[] leftHalf(int[] array) {
        int size1 = array.length / 2;
        int[] left = new int[size1];
        for (int i = 0; i < size1; i++) {
            left[i] = array[i];
        }
        return left;
    }

    // Returns the second half of the given array.
    public static int[] rightHalf(int[] array) {
        int size1 = array.length / 2;
        int size2 = array.length - size1;
        int[] right = new int[size2];
        for (int i = 0; i < size2; i++) {
            right[i] = array[i + size1];
        }
        return right;
    }

	//function to sort the array
	public static void merge(int[] myArray, int[] L, int[] R)
	{
		int i1 = 0;   // index into left array
        int i2 = 0;   // index into right array

        for (int i = 0; i < myArray.length; i++) {
            if (i2 >= R.length || (i1 < L.length && compare(L[i1],R[i2])<=0)) {
            	myArray[i] = L[i1];    // take from left
                i1++;
            } else {
            	myArray[i] = R[i2];   // take from right
                i2++;
            }
        }
	}

	//method to print any array
	public static void printArray(int[] array)
	{
		for(int i=0;i<array.length;i++)
			System.out.println(array[i]);
	}
}
