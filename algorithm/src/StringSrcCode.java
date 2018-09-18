import org.junit.Test;

public class StringSrcCode {

    @Test
    public void test1() {
        String str1 = "hello";
        String str2 = new String("hello");
        String str3 = "he" + "llo";
        String str4 = "he" + new String("llo");
        String str6 = new String(str2);
        System.out.println(str2 == str6);
        ;
    }
}
