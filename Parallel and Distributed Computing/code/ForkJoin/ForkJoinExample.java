import java.util.concurrent.*;

public class ForkJoinExample {
 
  private static final int ARRAY_SIZE = 100000;
  private static int[] numberArray = new int[ARRAY_SIZE];
 
  private static int sumVectorUsingForkJoin() {
    int total = 0;
    ForkJoinPool pool = new ForkJoinPool(); // create thread pool for fork/join
    SumVectorTask task = new SumVectorTask(numberArray, 0, ARRAY_SIZE);
    total = pool.invoke(task); // submit the task to fork/join pool
    pool.shutdown();
    return total;
  }
 
  public static void main(String[] args) {
    // fill the big array with integers andomly
    for (int i = 0; i < ARRAY_SIZE; i++) {
      //numberArray[i] = (int) (Math.random() * ARRAY_SIZE + 1); 
      numberArray[i] = i;
    }

    // prinf array for confirmation
    /* for (int i = 0; i < ARRAY_SIZE; i++) {
      System.out.println (numberArray[i]);
    }
    System.out.println();*/
    

    int count = sumVectorUsingForkJoin();
    System.out.printf("Using ForkJoin, vector sum is %d \n", count);
  }
}
