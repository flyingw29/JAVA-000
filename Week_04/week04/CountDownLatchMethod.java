package zhazha;

import java.util.concurrent.CountDownLatch;

/**
 * @author WANGFEI
 */
public class CountDownLatchMethod {

    public static void main(String[] args) throws InterruptedException {
        long start = System.currentTimeMillis();
        // 在这里创建一个线程或线程池，
        // 异步执行 下面方法

        CountDownLatch downLatch = new CountDownLatch(1);

        new Thread(() -> {
            Integer result = FibonacciUtils.fibonacciResult(30);
            //这是得到的返回值

            // 确保  拿到result 并输出
            System.out.println("异步计算结果为：" + result);

            System.out.println("使用时间：" + (System.currentTimeMillis() - start) + " ms");

            // 然后退出main线程
        }).start();
        downLatch.await();
        downLatch.countDown();
    }

}
