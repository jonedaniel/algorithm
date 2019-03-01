package tree.binaryTree;

import java.util.ArrayList;
import java.util.List;

/**
 * Title: BinaryTree
 * Description: 二叉树实现
 *
 * @author zhaomenghui93@163.com
 * @createDate 2019/2/24
 */
public class BinaryTreeTraversal {
    public static void main(String[] args) {
        //create a binary tree
        MyNode        myNode1   = new MyNode(1);
        MyNode        myNode2   = new MyNode(2);
        MyNode        myNode3   = new MyNode(3);
        MyNode        myNode4   = new MyNode(4);
        MyNode        myNode5   = new MyNode(5);
        NodeContainer container = new NodeContainer();
        container.addAll(myNode3, myNode2, myNode1, myNode4, myNode5);
        MyNode        rootNode = container.getRootMyNode();
        List<Integer> list     = new ArrayList<>();
        traversal(list, rootNode);
        System.out.println(list);

        list = new ArrayList<>();
        inOrder(list, rootNode);
        System.out.println(list);

        list = new ArrayList<>();
        postOrder(list, rootNode);
        System.out.println(list);
    }

    /**
     * 先访问根节点,在访问叶子节点的遍历方式
     *
     * @createDate 2019/2/24
     */
    private static void traversal(List<Integer> list, MyNode node) {
        list.add(node.getVal());
        if (node.getLeft() != null) traversal(list, node.getLeft());
        if (node.getRight() != null) traversal(list, node.getRight());
    }

    /**
     * 中序遍历,先访问左(右)子树,再访问(右子树的)遍历方式
     *
     * @createDate 2019/2/24
     */
    private static void inOrder(List<Integer> list, MyNode node) {
        if (node.getLeft() != null) inOrder(list, node.getLeft());
        list.add(node.getVal());
        if (node.getRight() != null) inOrder(list, node.getRight());
    }

    /**
     * 先访问叶子节点,再访问根节点的遍历方式
     *
     * @createDate 2019/2/24
     */
    private static void postOrder(List<Integer> list, MyNode node) {
        if (node.getLeft() != null) postOrder(list, node.getLeft());
        if (node.getRight() != null) postOrder(list, node.getRight());
        list.add(node.getVal());
    }

    private static void bfs(List<Integer> list, MyNode node) {

    }

    private static void dfs(List<Integer> list, MyNode node) {

    }

}


