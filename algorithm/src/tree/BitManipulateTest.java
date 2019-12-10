package tree;


public class BitManipulateTest {
    public static void main(String[] args) {
        byte x = 0b110;
        byte y = 0b101;
        System.out.println(x+" "+y);
        x = (byte) (x ^ y);// 011
        y = (byte) (x ^ y);// 110
        x = (byte) (x ^ y);// 101
        System.out.println(x+" "+y);
    }
}
