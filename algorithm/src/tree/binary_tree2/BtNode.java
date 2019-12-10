package tree.binary_tree2;

class BtNode {
    BtNode left;
    BtNode right;
    String val;

    BtNode(String val) {
        this.val = val;
    }

    BtNode(String val,BtNode left, BtNode right) {
        this.left = left;
        this.right = right;
        this.val = val;
    }
}
