package search;

public class FibonacciSolution {
    public static void main(String[] args) {
//        System.out.println(directSimple(20));
        System.out.println(orderAsc(100));
        System.out.println(generalFormulas(45));

    }

    private static long directSimple(int n) {
        if (n == 0) return 0;
        else if (n == 1) return 1;
        else return directSimple(n - 1) + directSimple(n - 2);
    }

    /**
     * 正序解决
     *
     * @author zhaomenghui
     * @createDate 2019/2/18
     */
    private static long orderAsc(int n) {
        long[] arr = new long[n + 1];
        arr[0] = 0;
        arr[1] = 1;
        for (int i = 2; i <= n; i++) {
            arr[i] = arr[i - 1] + arr[i - 2];
        }
        return arr[n];
    }

    /**
     * 通过百度获得通项公式
     *
     * @author zhaomenghui
     * @createDate 2019/2/18
     */
    private static int generalFormulas(int n) {
        return (int) (1.0/Math.pow(5, 0.5)*(Math.pow((1 + Math.pow(5, 0.5)) / 2, n) - Math.pow((1 - Math.pow(5, 0.5)) / 2, n)));
    }

}
