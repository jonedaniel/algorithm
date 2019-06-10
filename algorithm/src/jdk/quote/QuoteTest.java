package jdk.quote;

/**
 * 引用传值
 * java只有值传递,非原始类型传递的是 引用的副本
 * java如果想实现引用传递，可以用boxing，即用数组来存取。
 *
 * @author zhaomh
 * @since 2019/6/10
 */
public class QuoteTest {
    public static void main(String[] args) {
        Pojo p1 = new Pojo(1);
        returnQuote(p1);
        System.out.println(p1.val);
    }

    public static Pojo returnQuote(Pojo pojo) {
        pojo = new Pojo(2);
        return pojo;
    }
}
