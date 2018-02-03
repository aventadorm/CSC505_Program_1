import java.util.Scanner;

public abstract class InsertionSort implements Comparable <Integer>{
  static int comparisons = 0;
    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        int length = input.nextInt();
        int[] myArray= new int[length];

        for(int i=0;i<length;i++)
          myArray[i]=input.nextInt();
        input.close();
        //Record system time at start
        long startTime = System.currentTimeMillis();
        //Call to insertionsort
        insertionsort(myArray);
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
        System.err.println("comparisons," + comparisons);
        printArray(myArray);

    }
    public static void insertionsort(int array[]){
      for(int i = 1 ; i < array.length; i++){
        int key = array[i];
        int j = i - 1;

        while(j >= 0 && compareTo(array[j], key) > 0){
          array[j+1] = array[j];
          j--;
        }
        array[j+1] = key;
      }

      }


    public static int compareTo(int a, int k){
      comparisons++;
      return a - k;
    }
    public static void printArray(int[] array)
  	{
  		for(int i=0;i<array.length;i++)
  			System.out.println(array[i]);
  	}
}
