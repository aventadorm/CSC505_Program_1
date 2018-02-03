import java.util.Arrays;
import java.util.Random;
public class DefaultSort {
    public static void main(String[] args) {
        //int array[] = {5,4,3,2,1};
        Random rand = new Random();
        int n = 300000;
        int[] array = new int[n];
        for(int i = 0; i < n; i ++){
          array[i] = rand.nextInt();
        }
        long startTime = System.currentTimeMillis();
        Arrays.sort(array);
        long endTime = System.currentTimeMillis();
        long elapsedTime = endTime - startTime;
        int MILLISECONDS = (int) elapsedTime;
        for(int i = 0; i < array.length; i ++){
          System.out.print(array[i]+ "\n");
        }
        System.out.print("Time :");

        System.out.print(MILLISECONDS);
        System.out.print("\n");

s

    }
}
