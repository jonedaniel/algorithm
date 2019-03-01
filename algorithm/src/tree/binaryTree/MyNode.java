package tree.binaryTree;

import lombok.Data;


/**
 * Title: MyNode
 * Description: 节点对象
 *
 * @author zhaomenghui93@163.com
 * @createDate 2019/2/24
 */
@Data
public class MyNode implements Comparable<MyNode> {
    private MyNode left;
    private MyNode right;
    private int    val;

    MyNode(int val) {
        this.val = val;
    }

    @Override
    public int compareTo(MyNode o2) {
        return Integer.compare(this.getVal(), o2.getVal());
    }
}
