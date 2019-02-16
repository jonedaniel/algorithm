package leetcode.hard;

public class MumberOfDigitOne {
    public static void main(String[] args) {
        long now = System.currentTimeMillis();
        System.out.println(new MumberOfDigitOne().countDigitOne(824883294));
        System.out.println(System.currentTimeMillis()-now);
    }

    public int countDigitOne(int n) {
        return divideCount(0,n);
    }

    public int divideCount(int start, int end) {
        int count = 0;
        if ((end - start) > 100) {

        } else {
            for (int i = start; i <= end; i++) {
                int j = i;
                while (j > 0) {
                    if (j % 10 == 1) {
                        count++;
                    }
                    j /= 10;
                }
            }
        }
        return count;
    }
}
