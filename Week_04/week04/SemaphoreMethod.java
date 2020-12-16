import java.util.concurrent.ExecutionException;
import java.util.concurrent.Semaphore;

/**
 * @author WANGFEI
 * SemaphoreMethod
 */
public class SemaphoreMethod {
    private volatile Integer value = null;
    private final Semaphore semaphore = new Semaphore(1);

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        long start = System.currentTimeMillis();
        // 在这里创建一个线程或线程池，
        // 异步执行 下面方法

        final SemaphoreMethod method = new SemaphoreMethod();

        Thread thread = new Thread(() -> {
            try {
                method.sum(30);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        thread.start();

        //这是得到的返回值
        int result = method.getValue();

        // 确保  拿到result 并输出
        System.out.println("异步计算结果为：" + result);

        System.out.println("使用时间：" + (System.currentTimeMillis() - start) + " ms");

        // 然后退出main线程
    }

    public void sum(int num) throws InterruptedException {
        semaphore.acquire();
        value = FibonacciUtils.fibonacciResult(num);
        semaphore.release();
    }

    public int getValue() throws InterruptedException {
        int result;
        semaphore.acquire();
        result = this.value;
        semaphore.release();
        return result;
    }

}
