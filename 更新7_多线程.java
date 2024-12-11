public class MultiThreadOddEven {
    public static void main(String[] args) {
        Thread oddThread = new Thread(new OddNumberPrinter(), "OddThread");
        Thread evenThread = new Thread(new EvenNumberPrinter(), "EvenThread");

        oddThread.start();
        evenThread.start();

        try {
            oddThread.join(); // 等待 oddThread 执行完毕
            evenThread.join(); // 等待 evenThread 执行完毕
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("end");
    }
}

class OddNumberPrinter implements Runnable {
    @Override
    public void run() {
        for (int i = 1; i < 10; i += 2) {
            System.out.println(Thread.currentThread().getName() + " outputs: " + i);
            try {
                Thread.sleep(100); // 模拟线程执行的延迟
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class EvenNumberPrinter implements Runnable {
    @Override
    public void run() {
        for (int i = 2; i <= 10; i += 2) {
            System.out.println(Thread.currentThread().getName() + " outputs: " + i);
            try {
                Thread.sleep(100); // 模拟线程执行的延迟
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
