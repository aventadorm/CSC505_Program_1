import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;
public class DefaultSort {
    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        int length=input.nextInt();
        int[] myArray= new int[length];

        for(int i=0;i<length;i++)
          myArray[i]=input.nextInt();
        input.close();
        /*Random rand = new Random();
        int n = 300000;
        int[] array = new int[n];
        for(int i = 0; i < n; i ++){
          array[i] = rand.nextInt();
        }
        */
        //Record system time at start
        long startTime = System.currentTimeMillis();

        Arrays.sort(myArray);

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
        printArray(myArray);




    }
    public static void printArray(int[] array)
  	{
  		for(int i=0;i<array.length;i++)
  			System.out.println(array[i]);
  	}
}
