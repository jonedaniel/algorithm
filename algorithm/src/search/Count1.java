package search;

public class Count1 {

    public static void main(String[] args) {
        System.out.println(0b101 & 0b100);
        System.out.println(withAnd(5));
    }

    /**
     * 消除最后一个1
     *
     * @author zhaomenghui
     * @createDate 2019/2/18
     */
    private static int withAnd(int n) {
        int count = 0;
        while (n > 0) {
            count++;
            n &= n - 1;
        }
        return count;
    }

    private static int posiitonMove(int n) {
        int count = 0;
        do {
            if ((n & 1) == 1) {
                count++;
            }
            n >>= 1;
        } while (n > 0);
        return count;
    }


}
