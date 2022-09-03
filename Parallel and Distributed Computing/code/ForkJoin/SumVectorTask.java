import java.util.concurrent.RecursiveTask;
 
class SumVectorTask extends RecursiveTask<Integer> {
 
  private static final int ACCEPTABLE_SIZE = 1000;
  private int[] numberArray;
  private int start;
  private int stop;
 
  public SumVectorTask(int[] numberArray, int start, int stop) {
    this.numberArray = numberArray;
    this.start = start;
    this.stop = stop;
  }
 
  @Override
  protected Integer compute() {
    int count = 0;
    int workLoadSize = stop - start;
    if (workLoadSize < ACCEPTABLE_SIZE) {
      String threadName = Thread.currentThread().getName();
      //System.out.printf("Calculation [%d-%d] in Thread %s\n",start,stop,threadName);
      for (int i = start; i < stop; i++) {
        count = count + numberArray[i];
      }
    } else {
      int mid = start + workLoadSize / 2;
      SumVectorTask left = new SumVectorTask(numberArray, start, mid);
      SumVectorTask right = new SumVectorTask(numberArray, mid, stop);
 
      // fork (push to queue)-> compute -> join
      left.fork();
      int rightResult = right.compute();
      int leftResult = left.join();
      count = leftResult + rightResult;
    }
    return count;
  }
}
