package other;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 筛选法求n以内素数
 * 没写上
 * @author zc
 */
public class GetPrime {

    public static void main(String[] args) {
        GetPrime gp = new GetPrime();
        System.out.println(gp.printPrime(100));
    }

    public List<Integer> printPrime(int n) {
        if (n < 2) {
            return null;
        }
        List<Integer> result = new ArrayList<>();
        boolean[] isPrime = new boolean[n + 1];
        Arrays.fill(isPrime, true);
        for (int i = 2; i <= n / 2; i++) {
            if (isPrime[i]) {
                for (int j = i + i; j <= n; j += i) {
                    isPrime[j] = false;
                }
            }
        }

        //注意 i从2开始取
        for (int i = 2; i <= n; i++) {
            if (isPrime[i]) {
                result.add(i);
            }
        }
        return result;
    }
}
