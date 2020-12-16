import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @author WANGFEI
 */
public class FutureTaskMethod {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        long start = System.currentTimeMillis();
        // 在这里创建一个线程或线程池，
        // 异步执行 下面方法

        FutureTask<Integer> value = new FutureTask<>(() -> FibonacciUtils.fibonacciResult(30));
        new Thread(value).start();

        //这是得到的返回值
        int result = value.get();

        // 确保  拿到result 并输出
        System.out.println("异步计算结果为：" + result);

        System.out.println("使用时间：" + (System.currentTimeMillis() - start) + " ms");

        // 然后退出main线程
    }

}
