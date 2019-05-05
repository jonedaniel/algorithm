package bit_manipulate;

public class BitBasic {

    public static void main(String[] args) {
        byte x  = 0b101;
        byte y  = 0b110;//6
        byte y1 = (byte) (~y + 1); // -6: 原码6=>取反获得反码=>+1获得补码-6. 再计算机中使用补码计算

        //与运算 101 &  110 = 100 4
        //或运算 101 | 110 = 111 7
        //非运算 ~110 = 11111001
        //异或运算  3 ^ 5 = 6 (0b11 ^ 0b101),6^5= 3 (110 ^ 101)
        //左移,右移运算 5>>1 = 1
        System.out.println(5>>1);

        //异或交换int值.
        int a = 5;
        int b = 123;
        a = a ^ b;
        b = a ^ b;
        a = a ^ b;
        System.out.println( a + " " + b);

    }
}
