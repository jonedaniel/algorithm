package leetcode.easy;

import java.util.LinkedList;

public class NumberOfRecentCalls {
    public static void main(String[] args) {

    }

    public NumberOfRecentCalls() {

    }

    /**
     *  返回从 3000 毫秒前到现在的 ping 数。
     *
     * 任何处于 [t - 3000, t] 时间范围之内的 ping 都将会被计算在内，包括当前（指 t 时刻）的 ping。
     * @author zhaomenghui
     * @createDate 2019/2/16
     */
    private LinkedList<Integer>  callTimesList = new LinkedList<>();;
    public int ping(int t) {
        while (callTimesList.peekFirst() != null && (t - callTimesList.peekFirst()) > 3000) callTimesList.removeFirst();
        callTimesList.add(t);
        return callTimesList.size();
    }
}
