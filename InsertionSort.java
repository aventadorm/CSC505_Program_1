import java.util.Scanner;

public abstract class InsertionSort{
  static int kc = 0;
  static Integer x, y;
    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        //Parse length of array from first line
        int length = Integer.parseInt(input.nextLine().replaceAll("n ", ""));

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
        System.err.println("comparisons," + kc);
        printArray(myArray);

    }
    public static void insertionsort(int array[]){
      for(int i = 1 ; i < array.length; i++){
        int key = array[i];
        int j = i - 1;

        while(j >= 0 && compare(array[j], key) > 0){
          array[j+1] = array[j];
          j--;
        }
        array[j+1] = key;
      }

      }


    public static int compare(int a, int k){
      kc++;
      x = Integer.valueOf(a);
      y = Integer.valueOf(k);
      return x.compareTo(y);
    }
    public static void printArray(int[] array)
  	{
  		for(int i=0;i<array.length;i++)
  			System.out.println(array[i]);
  	}
}
