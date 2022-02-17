package lecture6.homework.task1;

public class ArrayCalculationConcurrency {

  static final int SIZE = 10_000_000;
  static final int HALF_SIZE = SIZE / 2;
  static float[] arr = new float[SIZE];

  public static void calculate() throws InterruptedException {

    for (float f : arr) {
      f = 1.f;
    }
    final long start = System.currentTimeMillis();

    Thread thread1 = new Thread(() -> {
      for (int i = 0; i < arr.length; i++) {
        arr[i] = calculateByFormula(arr[i], i);
      }
    });

    Thread thread2 = new Thread(() -> {
      for (int i = 0; i < arr.length; i++) {
        arr[i] = calculateByFormula(arr[i], i);
      }
    });
    thread1.start();
    thread2.start();
    thread1.join();
    thread2.join();

    final long end = System.currentTimeMillis();
    final long time = end - start;
    System.out
        .println("ArrayCalculationConcurrency.calculate() : Время на вполнение расчета : " + time + " миллисекнуд");

    System.out.println(arr.length);
    //final boolean isEqual = arr[0] == calculateByFormula(arr[0], 0);
    //System.out.println(isEqual);

    for (int i = 0; i < arr.length; i++) {
      final boolean tempIsEqual = arr[i] == calculateByFormula(arr[i], i);
      if (!tempIsEqual) {
        throw new IllegalStateException();
      }
    }
  }

  public static void calculateForkAndJoin() throws InterruptedException {

    for (float f : arr) {
      f = 1.f;
    }

    float[]a1 = new float[HALF_SIZE];
    float[]a2 = new float[HALF_SIZE];

    final long start = System.currentTimeMillis();

    System.arraycopy(arr,0,a1,0,HALF_SIZE);
    System.arraycopy(arr,HALF_SIZE,a2,0,HALF_SIZE);

    Thread thread1 = new Thread(()->{
      for (int i = 0; i < a1.length; i++) {
        a1[i] = calculateByFormula(a1[i], i);
      }
    });

    Thread thread2 = new Thread(()->{
      for (int i = 0; i < a2.length; i++) {
        a2[i] = calculateByFormula(a2[i], i);
      }
    });

    thread1.start();
    thread2.start();
    thread1.join();
    thread2.join();

    System.arraycopy(a1,0,arr,0,HALF_SIZE);
    System.arraycopy(a2,0,arr,HALF_SIZE,HALF_SIZE);

    final long end = System.currentTimeMillis();
    final long time = end-start;

    System.out.println("ArrayCalculationConcurrency.calculateForkAndJoin() : Время на вполнение расчета : " + time + " миллисекнуд");
    System.out.println(arr.length);
    //final boolean isEqual = arr[0] == calculateByFormula(arr[0], 0);
    //System.out.println(isEqual);

    for (int i=0;i<arr.length ; i++) {
      final boolean tempIsEqual = arr[i] == calculateByFormula(arr[i], i);
      if(!tempIsEqual) {
        throw new IllegalStateException();
      }
    }
  }

  private static float calculateByFormula(float v, int i) {
    return (float) (v * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math
        .cos(0.4f + i / 2));
  }
}
