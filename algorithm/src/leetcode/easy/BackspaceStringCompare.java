package leetcode.easy;

import java.util.LinkedList;

public class BackspaceStringCompare {
    public static void main(String[] args) {
        System.out.println(new BackspaceStringCompare().backspaceCompare("ab#c", "##c"));
    }
    public boolean backspaceCompare(String S, String T) {
        LinkedList<Character> queueS = new LinkedList<>();
        LinkedList<Character> queueT = new LinkedList<>();
        for (char c : S.toCharArray()) {
            if (c == '#') {
                queueS.poll();
            } else {
                queueS.push(c);
            }
        }
        for (char c : T.toCharArray()) {
            if (c == '#') {
                queueT.poll();
            } else {
                queueT.push(c);
            }
        }
        if(queueS.size() != queueT.size())return false;
        int size = queueS.size();
        for (int i = 0; i < size; i++) {
            if (queueS.poll()!=queueT.poll()) return false;
        }
        return true;
    }
}
