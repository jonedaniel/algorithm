package tree.binary_tree2;

import java.util.Objects;

class BtNodeTrace {
    public static void main(String[] args) {
        BtNode foot1 = new BtNode("foot1");
        BtNode foot2 = new BtNode("foot2");
        BtNode foot3 = new BtNode("foot3");

        BtNode bodyR = new BtNode("body-r", foot2, foot3);
        BtNode bodyL = new BtNode("body-l", foot1, null);
        BtNode root = new BtNode("root", bodyL, bodyR);
        traceBtTree(root);
    }

    private static void traceBtTree(BtNode root) {
        System.out.println(root.val);
        if (Objects.nonNull(root.left)) {
            traceBtTree(root.left);
        }
        if (Objects.nonNull(root.right)) {
            traceBtTree(root.right);
        }

    }
}
