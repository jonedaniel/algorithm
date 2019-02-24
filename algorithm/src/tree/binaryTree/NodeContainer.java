package tree.binaryTree;

import lombok.Data;

/**
 * Title: NodeContainer
 * Description: 节点容器
 *
 * @author zhaomenghui93@163.com
 * @createDate 2019/2/24
 */
@Data
public class NodeContainer {

    private MyNode rootMyNode;

    private void add(MyNode myNode) {
        if (rootMyNode == null) rootMyNode = myNode;
        else add(rootMyNode,myNode);
    }

    private void add(MyNode parent, MyNode son) {
        if (parent.compareTo(son) > 0) {
            if (parent.getLeft() == null)
                parent.setLeft(son);
            else
                this.add(parent.getLeft(), son);
        } else {
            if (parent.getRight() == null) {
                parent.setRight(son);
            } else {
                this.add(parent.getRight(), son);
            }
        }
    }

    void addAll(MyNode... myNodes) {
        for (MyNode myNode : myNodes) {
            this.add(myNode);
        }
    }

}
