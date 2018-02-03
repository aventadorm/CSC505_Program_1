
public abstract class InsertionSort implements Comparable <Integer>{
  static int kc = 0;
    public static void main(String[] args) {
        int array[] = {5,4,3,2,1};
        //Record system time at start
        long startTime = System.currentTimeMillis();
        //Call to insertionsort
        insertionsort(array);
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
        for(int i = 0; i < array.length; i ++){
          System.out.println(array[i]);
        }

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
      kc++;
      return a - k;
    }
    public static void printArray(int[] array)
  	{
  		for(int i=0;i<array.length;i++)
  			System.out.println(array[i]);
  	}
}