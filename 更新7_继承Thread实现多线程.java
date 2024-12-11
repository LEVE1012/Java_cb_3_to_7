import java.util.Random;

public class MultiThreadOddEven {
    public static void main(String[] args) {
        MyThread thread1 = new MyThread("Thread-1", new Random().nextInt(1000));
        MyThread thread2 = new MyThread("Thread-2", new Random().nextInt(1000));
        MyThread thread3 = new MyThread("Thread-3", new Random().nextInt(1000));

        thread1.start();
        thread2.start();
        thread3.start();
    }
}

class MyThread extends Thread {
    private final String whoAmI;
    private final int delay;

    public MyThread(String whoAmI, int delay) {
        this.whoAmI = whoAmI;
        this.delay = delay;
        this.setName(whoAmI);
    }

    @Override
    public void run() {
        System.out.println(whoAmI + " will sleep for " + delay + " milliseconds.");
        try {
            Thread.sleep(delay);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(whoAmI + " has finished execution.");
    }
}
