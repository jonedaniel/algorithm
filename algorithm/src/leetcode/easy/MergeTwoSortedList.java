package leetcode.easy;


import java.util.Objects;
import java.util.Optional;

/**
 * Title: MergeTwoSortedList
 * Description:
 * <p>
 * 将两个有序链表合并为一个新的有序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
 * 示例：
 * 输入：1->2->4, 1->3->4
 * 输出：1->1->2->3->4->4
 *
 * @author zhaomenghui
 * @version 1.0
 * @createDate 2019/3/22
 */
public class MergeTwoSortedList {
    public static void main(String[] args) {
        MergeTwoSortedList obj = new MergeTwoSortedList();
        ListNode           l1  = obj.new ListNode(1, obj.new ListNode(2, obj.new ListNode(4)));
        ListNode           la  = obj.new ListNode(1, obj.new ListNode(3, obj.new ListNode(4, obj.new ListNode(5, obj.new ListNode(6)))));
        ListNode           lb  = obj.new ListNode(5);
        ListNode           lr  = obj.mergeTwoLists(l1, lb);
        obj.print(lr);
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode listNode = null;
        ListNode last     = null;
        while (Objects.nonNull(l1) || Objects.nonNull(l2)) {
            int val;
            if (Objects.nonNull(l1) && Objects.nonNull(l2)) {
                if (l1.val < l2.val) {
                    val = l1.val;
                    l1 = l1.next;
                } else {
                    val = l2.val;
                    l2 = l2.next;
                }
            } else if (Objects.nonNull(l1)) {
                val = l1.val;
                l1 = l1.next;
            }else{
                val = l2.val;
                l2 = l2.next;
            }
            if (Objects.isNull(listNode)) {
                listNode = new ListNode(val);
                last = listNode;
            } else {
                last.next = new ListNode(val);
                last = last.next;
            }

        }
        return listNode;
    }

    public class ListNode {
        int      val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }

        public ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public void print(ListNode l) {
        StringBuilder sb = new StringBuilder(3);
        do {
            sb.append(l.val);
            l = l.next;
        } while (Objects.nonNull(l));
        System.out.println(sb);
    }
}

