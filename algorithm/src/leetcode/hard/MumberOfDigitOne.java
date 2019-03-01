package leetcode.hard;

import static java.lang.Math.ceil;

public class MumberOfDigitOne {
    public static void main(String[] args) {
        int  wrongNum = 824883294;
        long now      = System.currentTimeMillis();
        System.out.println(new MumberOfDigitOne().countDigitOne(10));
//        System.out.println(new MumberOfDigitOne().rightAnswerButSlow(13));
        System.out.println(System.currentTimeMillis() - now);
    }

    /**
     * 抄的答案 (这tm是数学的问题)
     *
     * @author zhaomenghui
     * @createDate 2019/2/16
     */
    public int countDigitOne(int n) {
        int num = n, i = 1, s = 0;
        while (num > 0) {
            if (num % 10 == 0) s += (num / 10) * i;
            if (num % 10 == 1) s += (num / 10) * i + (n % i) + 1;
            if (num % 10 > 1) s += Math.ceil(num / 10.0) * i;

            num /= 10;
            i *= 10;
        }
        return s;
    }

    /**
     * 767944060
     * 17497
     *
     * @author zhaomenghui
     * @createDate 2019/2/16
     */
    public int rightAnswerButSlow(int n) {
        int count = 0;
        for (int i = 0; i <= n; i++) {
            int j = i;
            while (j > 0) {
                if (j % 10 == 1) {
                    count++;
                }
                j /= 10;
            }
        }
        return count;
    }
}
