public abstract class MergeSort implements Comparable<Integer>  {
	static int comparisons=0;

	public static void main(String[] args)
	{
		int[] myArray= {1,2,3,4,5,6,7,8};

		//Record system time at start
		long startTime = System.currentTimeMillis();
		//Call to merge sort
		merge_sort(myArray,0,myArray.length-1);
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
		System.err.println("comparisons," + kc);


		printArray(myArray);
	}
	public static void merge_sort(int[] myArray,int p,int r)
	{

		if(p<r)
		{
			int q=(int) ((p+r)/2);
			merge_sort(myArray,p,q);
			merge_sort(myArray,q+1,r);

			merge(myArray,p,q,r);
		}
	}
	public static int compareTo(int l,int r)
	{
		comparisons++;
		return l-r;
	}
	public static void merge(int[] myArray, int p, int q, int r )
	{
		int n1=q-p+1;
		int n2=r-q;
		int L[]=new int[n1];
		int R[]=new int[n2];

		for(int i=0;i<n1;i++)
			L[i]=myArray[p+i];
		for(int j=0;j<n2;j++)
			R[j]=myArray[q+j+1];
		int i=0,j=0,k=p;
		while(i<n1 && j<n2)
		{
			//if(L[i]<=R[j])
			if(compareTo(L[i],R[j])<=0)
			{
				myArray[k]=L[i];
				i++;
			}
			else
			{
				myArray[k]=R[j];
				j++;
			}
			k++;

		}

		while(i<n1)
		{
			myArray[k]=L[i];
			i++;
			k++;
		}
		while(j<n2)
		{
			myArray[k]=R[j];
			j++;
			k++;
		}
	}
	public static void printArray(int[] array)
	{
		for(int i=0;i<array.length;i++)
			System.out.println(array[i]);
	}
}
