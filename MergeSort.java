import java.util.Scanner;

public abstract class MergeSort implements Comparable<Integer>  {
	static int comparisons=0;

	public static void main(String[] args)
	{
		Scanner input=new Scanner(System.in);
		String[] abc = input.nextLine().split(" ");
		int length = Integer.parseInt(abc[1].replaceAll("[^0-9]" ,""));
		//int length=input.nextInt();

		int[] myArray= new int[length];

		for(int i=0;i<length;i++)
			myArray[i]=input.nextInt();
		input.close();

		//Record system time at start
		long startTime = System.currentTimeMillis();
		//Call to merge sort
		merge_sort(myArray,0,length-1);
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
	public static void merge_sort(int[] myArray,int p,int r)
	{

		if(p<r)
		{
			int q=(int) ((p+r)/2);
			//int q=((r-p+1)/2);
			merge_sort(myArray,p,q);
			merge_sort(myArray,q+1,r);

			merge(myArray,p,q,r);
		}
	}
	//overridden function compareTo that increments the global counter
	public static int compareTo(int l,int r)
	{
		comparisons++;
		return l-r;
	}
	//function to sort the array
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
			//if left element is smaller, take that and increment counter of left array
			if(compareTo(L[i],R[j])<=0)
			{
				myArray[k]=L[i];
				i++;
			}
			//else if right element is smaller, take that and increment counter of right array
			else
			{
				myArray[k]=R[j];
				j++;
			}
			k++;

		}
		//copy remaining elements of left array
		while(i<n1)
		{
			myArray[k]=L[i];
			i++;
			k++;
		}
		//copy remaining elements of right arrays
		while(j<n2)
		{
			myArray[k]=R[j];
			j++;
			k++;
		}
	}
	//method to print any array
	public static void printArray(int[] array)
	{
		for(int i=0;i<array.length;i++)
			System.out.println(array[i]);
	}
}
