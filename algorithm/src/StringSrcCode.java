public class StringSrcCode {

    public static void main(String[] args) {
        String s = "test";
        System.out.println(s);
        /**
         * string是引用传递，但是string引用指向的值无法修改，而是创建了一个新对象。
         * 原来的引用还是指向原来的对象，方法内部的引用被回收
         * @author zhaomenghui
         * @createDate 2018/9/29
         */
        change(s);
        System.out.println(s);


        System.out.println("---------------------");
        StringBuffer sb = new StringBuffer();
        sb.append("test");
        System.out.println(sb);
        change(sb);
        System.out.println(sb);
    }

    public static void change(StringBuffer sb) {
        //调用该方法时实际参数的sb和形式参数的sb指向的是同一个对象(StringBuffer容器)
        //方法内部又在该容器里添加了"itcast",所以方法结束时,局部变量的sb消失,但是实际参数的sb所指向的容器的内部的内容已经发生了改变
        sb.append("itcast");
    }

    public static void change(String s) {
        s += "itcast";
    }

}
