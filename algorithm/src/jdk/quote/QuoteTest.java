package jdk.quote;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static java.util.Arrays.asList;

/**
 * 引用传值
 * java只有值传递,非原始类型传递的是 引用的副本
 * java如果想实现引用传递，可以用boxing，即用数组来存取。
 *
 * @author zhaomh
 * @since 2019/6/10
 */
public class QuoteTest {
    /*    public static void main(String[] args) {
            Pojo p1 = new Pojo(1);
            //System.out.println(returnQuote(p1).val );
            //System.out.println(p1.val);
            Pojo[] pojos = {p1};
            arrQuote(pojos);
            System.out.println(pojos[0].val);
        }

        public static Pojo returnQuote(Pojo pojo) {
            pojo = new Pojo(2);
            return pojo;
        }

        public static void arrQuote(Pojo[] pojos) {
            pojos[0] = new Pojo(2);
        }*/
    String str = new String("good");
    char[] ch = {'a', 'b', 'c'};
    int i = 10;
    List<String> list = new ArrayList<String>(asList("f", "y", "c"));

    public void change(String str, char[] ch, int i,List<String> list) {
        str = "test ok";
        ch[0] = 'g';
        i++;
        list.add("u");
    }
    public static void main(String[] args) {
        QuoteTest test = new QuoteTest();
        test.change(test.str, test.ch, test.i,test.list);
        System.out.println(test.str + "  " + Arrays.toString(test.ch) + "  " + test.i + "  " + test.list);

    }

}
