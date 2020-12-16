/**
 * @author WANGFEI
 */
public class FibonacciUtils {
    /**
     * Fibonacci数列
     *
     * @param number 输入
     * @return result
     */
    public static int fibonacciResult(int number) {
        if (number < 2) {
            return 1;
        }
        return fibonacciResult(number - 1) + fibonacciResult(number - 2);
    }
}
