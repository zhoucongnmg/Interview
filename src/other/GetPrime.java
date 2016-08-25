package other;

import java.util.Arrays;

/**
 * 筛选法求n以内素数
 * 
 * @author zc
 *
 */
public class GetPrime {

	public static void main(String[] args) {
		GetPrime gp = new GetPrime();
		gp.printPrime(100);
	}

	public void printPrime(int n) {
		if (n < 2)
			return;
		boolean[] isPrime = new boolean[n + 1];
		Arrays.fill(isPrime, true);
		for (int i = 2; i <= n / 2; i++) {
			if (isPrime[i]) {
				for (int j = i + i; j <= n; j += i)
					isPrime[j] = false;
			}
		}

		for (int i = 2; i <= n; i++) {
			if (isPrime[i])
				System.out.print(i + "  ");
		}
	}
}
