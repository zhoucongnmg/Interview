package other;

/**
 * @author zhoucong
 * @time 2018/5/17
 * 1、售票工作正在进行，每张票为50元，现在有m+n人排队等待购票，其中有m人手持50元，n人手持100
 * 元，假设售票处不设找零，那么若想使售票处不会出现找不开零钱的局面，请你帮忙设计不同的排队方案。特别说明的是，拿同样面值的人对换位置为同一种方案。
 * <p>
 * 2、男女排队问题
 * m个男生，n个女生 要求任意位置前 男生比女生多,求有多少种排队方案
 *
 * https://blog.csdn.net/hyperprogram/article/details/60970520
 */
public class paiduigoupiao {
    private int f(int m, int n) {
        if (m < n) {
            return 0;
        }
        if (n == 0) {
            return 1;
        }
        return f(m - 1, n) + f(m, n - 1);
    }
}


