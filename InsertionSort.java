
public abstract class InsertionSort implements Comparable <Integer>{
  static int kc = 0;
    public static void main(String[] args) {
        int array[] = {5,4,3,2,1};
        sort(array);
        System.out.print("Key Comparisons :" + kc +"\n");
        for(int i = 0; i < array.length; i ++){
          System.out.print(array[i]+ "\n");
        }

    }
    public static void sort(int array[]){
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

}
