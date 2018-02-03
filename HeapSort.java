public abstract class  HeapSort implements Comparable<Integer>  {

	static int n,comparisions=0;
	public static void main(String[] args)
	{
		int[] myArray= {16,12,1,4,19};

		//Record system time at start
		long startTime = System.currentTimeMillis();
		//Call to Heap Sort
		heap_sort(myArray);
		//Record system time at end
		long endTime = System.currentTimeMillis();
		//Difference is elapsed time and conver to integer.
		long elapsedTime = endTime - startTime;
		//Check to see if long goes over max integer value
		if(elapsedTime > Integer.MAX_VALUE){
			throw new IllegalArgumentException(elapsedTime + "cannot convert to int without modifying value");
		}
		//Typecast to integer and write to variable
		int runtime = (int) elapsedTime;
		//Write runtime and key comparisons to standard error
		System.err.println("runtime," + runtime);
		//System.err.println("comparisons," + kc);

		printArray(myArray);

	}
	public static void heap_sort(int[] myArray)
	{
		n=myArray.length;
		for(int i=n/2-1;i>=0;i--)
		{
			heapify(myArray,i);
		}
		for(int j=n-1;j>=0;j--)
		{
			int temp=myArray[0];
			myArray[0]=myArray[j];
			myArray[j]=temp;
			n=n-1;
			heapify(myArray,0);

		}

	}
	public static int compareTo(int l,int r)
	{
		comparisions++;
		return l-r;
	}
	public static void heapify(int[] myArray,int i)
	{
		int largest=i;
		int l=left(i);
		int r=right(i);

		if(l<n && compareTo(myArray[l],myArray[i])>=0)
		{
			largest=l;
		}
		else
		{	largest=i;

		}
		if(r<n && compareTo(myArray[r],myArray[largest])>=0)
		{
			largest=r;
		}
		if(largest!=i)
		{
			int temp=myArray[i];
			myArray[i]=myArray[largest];
			myArray[largest]=temp;

			heapify(myArray,largest);
		}
	}
	public static int left(int i)
	{
		return 2*i+1;
	}
	public static int right(int i)
	{
		return 2*i+2;
	}
	public static void printArray(int[] array)
	{
		for(int i=0;i<array.length;i++)
			System.out.println(array[i]);
	}

}
