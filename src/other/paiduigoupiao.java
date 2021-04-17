package other;

/**
 * @author zhoucong
 * @time 2018/5/17
 */
public class paiduigoupiao {
    /**
     * 注意
     * <p>
     * 1、售票工作正在进行，每张票为50元，现在有m+n人排队等待购票，其中有m人手持50元，n人手持100
     * 元，假设售票处不设找零，那么若想使售票处不会出现找不开零钱的局面，请你帮忙设计不同的排队方案。特别说明的是，拿同样面值的人对换位置为同一种方案。
     * <p>
     * 2、男女排队问题
     * m个男生，n个女生 要求任意位置前 男生比女生多,求有多少种排队方案
     * <p>
     * https://blog.csdn.net/hyperprogram/article/details/60970520
     *
     * @param m
     * @param n
     * @return
     */
    private int f(int m, int n) {
        if (m < n) {
            return 0;
        }
        if (n == 0) {
            return 1;
        }
        return f(m - 1, n) + f(m, n - 1);
    }

    /**
     * leet:860. 柠檬水找零
     */
    public boolean lemonadeChange(int[] bills) {
        if (bills == null || bills.length == 0) {
            return false;
        }
        int fives = 0, tens = 0;
        for (int i : bills) {
            if (i == 5) {
                fives++;
                continue;
            }
            if (i == 10) {
                if (fives > 0) {
                    fives--;
                    tens++;
                } else {
                    return false;
                }
                continue;
            }
            if (i == 20) {
                if (tens > 0) {
                    tens--;
                    if (fives > 0) {
                        fives--;
                    } else {
                        return false;
                    }
                } else {
                    if (fives >= 3) {
                        fives -= 3;
                    } else {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}


