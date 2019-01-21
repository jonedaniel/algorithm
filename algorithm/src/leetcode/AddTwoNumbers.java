package leetcode;

import java.util.LinkedList;
import java.util.List;

import static java.util.Arrays.asList;

/**
 * Title: AddTwoNumbers
 * Description:
 * You are given two non-empty linked lists representing two non-negative integers.
 * <p>
 * The digits are stored in reverse order and each of their nodes contain a single digit.
 * <p>
 * Add the two numbers and return it as a linked list.
 * <p>
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 * <p>
 * Example:
 * <p>
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 * Output: 7 -> 0 -> 8
 * Explanation: 342 + 465 = 807.
 *
 * @author zhaomenghui
 * @version 1.0
 * @url https://leetcode.com/problems/add-two-numbers/
 * @createDate 2019/1/21
 */
public class AddTwoNumbers {

    public static void main(String[] args) {
        ListNode listNode = new ListNode(1);
        listNode.addNext(new ListNode(2)).addNext(new ListNode(3));
//        System.out.println(listNode);
        AddTwoNumbers test = new AddTwoNumbers();
        List<Integer> list = test.toArr(listNode);
        System.out.println(new ListNode(0));
        System.out.println(test.addTwoList(new LinkedList<>(asList(2, 2, 2)), new LinkedList<>(asList(2, 2, 8, 9))));
        ListNode      toNode = test.toNode(test.addTwoList(new LinkedList<>(asList(2, 2, 2)), new LinkedList<>(asList(2, 2, 8, 9))));

    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        return toNode(addTwoList(toArr(l1), toArr(l2)));
    }

    public List<Integer> toArr(ListNode node) {
        List<Integer> list = new LinkedList<>();
        do {
            list.add(node.val);
            node = node.next;
        } while (node != null);
        return list;
    }

    public ListNode toNode(List<Integer> list) {
        ListNode listNode = new ListNode(list.get(0));
        ListNode node     = listNode;
        int      i        = 1;
        while (i < list.size()) {
            node.next = new ListNode(list.get(i));
            node = node.next;
            i++;
        }
        return listNode;
    }

    public List<Integer> addTwoList(List<Integer> l1, List<Integer> l2) {
        List<Integer> ret = new LinkedList<>();
        int nextToAdd = 0;
        List<Integer> smallList = l1.size() < l2.size() ? l1 : l2;
        List<Integer> biggerList = l1.size() > l2.size() ? l1 : l2;
        for (int i = 0; i < smallList.size(); i++) {
            int i1 = l1.get(i) + l2.get(i) + nextToAdd;
            if (i1 < 10) {
                ret.add(i1);
                nextToAdd = 0;
            } else {
                ret.add(i1 % 10);
                nextToAdd = i1 /= 10;
            }
        }
        for (int i = smallList.size(); i <biggerList.size(); i++) {
            int i1 = biggerList.get(i) + nextToAdd;
            if (i1 < 10) {
                ret.add(i1);
                nextToAdd = 0;
            } else {
                ret.add(i1 % 10);
                nextToAdd = i1 /= 10;
            }

        }
        if (nextToAdd > 0)
            ret.add(nextToAdd);
        return ret;
    }
}

class ListNode {
    int      val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }

    ListNode addNext(ListNode next) {
        this.next = next;
        return this.next;
    }

    @Override
    public String toString() {
        ListNode      node = this;
        StringBuilder sb   = new StringBuilder();
        sb.append(node.val).append("->");
        while (node.next != null) {
            node = node.next;
            sb.append(node.val == 0?"0":node.val).append("->");
        }
        sb.deleteCharAt(sb.length() - 1);
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }
}

class HalfAnswer1 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        return getListNode(getInt(l1) + getInt(l2));
    }

    public long getInt(ListNode listNode) {
        ListNode node = listNode;
        long     ret  = node.val;
        long     sign = 1;
        while (node.next != null) {
            node = node.next;
            ret += node.val * Math.pow(10, sign);
            sign++;
        }
        return ret;
    }

    public ListNode getListNode(long num) {
        ListNode listNode = new ListNode((int) (num % 10));
        num /= 10;
        ListNode node = listNode;
        while (num >= 0) {
            node.next = new ListNode((int) (num % 10));
            num /= 10;
            node = node.next;
        }
        return listNode;
    }
}
