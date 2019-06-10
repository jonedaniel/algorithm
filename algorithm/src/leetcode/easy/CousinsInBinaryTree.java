package leetcode.easy;


import java.util.ArrayList;
import java.util.List;

/**
 * 在二叉树中，根节点位于深度 0 处，每个深度为 k 的节点的子节点位于深度 k+1 处。
 * <p>
 * 如果二叉树的两个节点深度相同，但父节点不同，则它们是一对堂兄弟节点。
 * <p>
 * 我们给出了具有唯一值的二叉树的根节点 root，以及树中两个不同节点的值 x 和 y。
 * <p>
 * 只有与值 x 和 y 对应的节点是堂兄弟节点时，才返回 true。否则，返回 false。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * 输入：root = [1,2,3,4], x = 4, y = 3
 * 输出：false
 * <p>
 * 示例 2：
 * 输入：root = [1,2,3,null,4,null,5], x = 5, y = 4
 * 输出：true
 * <p>
 * 示例 3：
 * 输入：root = [1,2,3,null,4], x = 2, y = 3
 * 输出：false
 * <p>
 * 提示：
 * 二叉树的节点数介于 2 到 100 之间。
 * 每个节点的值都是唯一的、范围为 1 到 100 的整数。
 *
 * todo 未完成
 * @author zhaomh
 */
public class CousinsInBinaryTree {
    public static void main(String[] args) {
        CousinsInBinaryTree obj = new CousinsInBinaryTree();
        TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(2);
        TreeNode t3 = new TreeNode(3);
        TreeNode t4 = new TreeNode(4);
        TreeNode t5 = new TreeNode(5);

        t1.left = t2;
        t1.right = t3;
        t2.left = null;
        t2.right = null;
        t3.left = t4;
        t3.right = t5;
//        t4.left = null;
//        t4.right = t5;

        System.out.println(obj.isCousins(t1,4,5));
    }

    public boolean isCousins(TreeNode root, int x, int y) {
        List<TreeNode> list1 = new ArrayList<>();
        traversal(null,root, x,list1);
        if (list1.get(0) != null) {
            traversal(null,root, list1.get(0).val,list1);
        }

        List<TreeNode> list2 = new ArrayList<>();
        traversal(null,root, y,list2);
        if (list2.get(0) != null) {
            traversal(null,root, list2.get(0).val,list2);
        }

        return list1.get(0) != list2.get(0) && (list1.size() == 2 && list2.size() == 2 && list1.get(1) == list2.get(1));
    }

    private void traversal(TreeNode parentNode,TreeNode root, int target,List<TreeNode> list) {
        if (root == null) return;
        if (root.val == target) {
            list.add(parentNode);
            return;
        }
        if (root.left != null) traversal(root,root.left,target,list);
        if (root.right != null) traversal(root,root.right,target,list);
    }

}
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int val) {
        this.val = val;
    }
}
