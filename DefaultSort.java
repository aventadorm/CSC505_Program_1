import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;


public abstract class DefaultSort implements Comparable<Integer>{
    static int comparisons=0;
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

        Integer[] test = new Integer[myArray.length];
        int i = 0;
        for (int value : myArray) {
            test[i++] = Integer.valueOf(value);
        }
        Arrays.sort(test, new Comparator<Integer>(){
          //@Override
          public int compare(Integer a, Integer b){
            comparisons++;
            return a.compareTo(b);
          }
        });

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

        i = 0;
        for(Integer intobject : test){
          myArray[i++] = intobject.intValue();
        }
        printArray(myArray);




    }
    public static void printArray(int[] array)
    {
        for(int i=0;i<array.length;i++)
            System.out.println(array[i]);
    }
}
