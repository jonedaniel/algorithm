package leetcode.medium;

import java.util.*;

import static java.util.Arrays.asList;

/**
 * Title: AccountMerge
 * Description:
 * <p>
 * 给定一个列表 accounts，每个元素 accounts[i] 是一个字符串列表，其中第一个元素 accounts[i][0] 是 名称 (name)，其余元素是 emails 表示该帐户的邮箱地址。
 * 现在，我们想合并这些帐户。如果两个帐户都有一些共同的邮件地址，则两个帐户必定属于同一个人。请注意，即使两个帐户具有相同的名称，它们也可能属于不同的人，
 * 因为人们可能具有相同的名称。一个人最初可以拥有任意数量的帐户，但其所有帐户都具有相同的名称。
 * 合并帐户后，按以下格式返回帐户：每个帐户的第一个元素是名称，其余元素是按顺序排列的邮箱地址。accounts 本身可以以任意顺序返回。
 * <p>
 * Input:
 * accounts = [["John", "johnsmith@mail.com", "john00@mail.com"], ["John", "johnnybravo@mail.com"], ["John", "johnsmith@mail.com", "john_newyork@mail.com"], ["Mary", "mary@mail.com"]]
 * Output: [["John", 'john00@mail.com', 'john_newyork@mail.com', 'johnsmith@mail.com'],  ["John", "johnnybravo@mail.com"], ["Mary", "mary@mail.com"]]
 * Explanation:
 * 第一个和第三个 John 是同一个人，因为他们有共同的电子邮件 "johnsmith@mail.com"。
 * 第二个 John 和 Mary 是不同的人，因为他们的电子邮件地址没有被其他帐户使用。
 * 我们可以以任何顺序返回这些列表，例如答案[['Mary'，'mary@mail.com']，['John'，'johnnybravo@mail.com']，
 * ['John'，'john00@mail.com'，'john_newyork@mail.com'，'johnsmith@mail.com']]仍然会被接受。
 * <p>
 * accounts的长度将在[1，1000]的范围内。
 * accounts[i]的长度将在[1，10]的范围内。
 * accounts[i][j]的长度将在[1，30]的范围内。
 * <p>
 * <p>
 * [["David","David0@m.co","David4@m.co","David3@m.co"],["David","David5@m.co","David5@m.co","David0@m.co"],["David","David1@m.co","David4@m.co","David0@m.co"],
 * ["David","David0@m.co","David1@m.co","David3@m.co"],["David","David4@m.co","David1@m.co","David3@m.co"]]
 *
 * @author zhaomenghui
 * @version 1.0
 * @createDate 2019/3/25
 */
public class AccountMerge {
    public static void main(String[] args) {
        System.out.println(new AccountMerge().accountsMerge(
                new ArrayList<>(
                        asList(asList("David", "David0@m.co", "David4@m.co", "David3@m.co"), asList("David", "David5@m.co", "David5@m.co", "David0@m.co"),
                                asList("David", "David1@m.co", "David4@m.co", "David0@m.co"), asList("David", "David0@m.co", "David1@m.co", "David3@m.co"),
                                asList("David", "David4@m.co", "David1@m.co", "David3@m.co"))
                )
        ));
    }

    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        List<List<String>> rl        = new ArrayList<>();
        int                size      = accounts.size();
        List<Integer>      oldIndexs = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            List<String> list1   = accounts.get(i);
            List<String> retList = new ArrayList<>();
            for (int j = 0; j < size; j++) {
                if (i == j || oldIndexs.contains(i) || oldIndexs.contains(j)) continue;
                List<String>      list2       = accounts.get(j);
                ArrayList<String> inspectList = new ArrayList<>(list2);
                for (String s1 : list1) {
                    inspectList.removeIf(s2 -> s2.equals(s1));
                }
                if (inspectList.size() < list2.size() - 1) {
                    Set<String> list = new TreeSet<>();
                    list.addAll(list1);
                    list.addAll(inspectList);
                    ArrayList<String> toAddList = new ArrayList<>(list);
                    oldIndexs.add(i);
                    oldIndexs.add(j);
                    boolean flag = true;
                    for (List<String> existList : rl) {
                        int size2 = existList.size();
                        existList.removeIf(s-> s.contains(".") && toAddList.contains(s));
                        if (existList.size() < size2) {
                            existList.addAll(toAddList.subList(1,toAddList.size()));
                            flag = false;
                        }
                    }
                    if(flag) rl.add(toAddList);
                }
            }
        }

        for (int i = 0; i < accounts.size(); i++) {
            if (!oldIndexs.contains(i)) {
                rl.add(new ArrayList<>(new HashSet<>(accounts.get(i))));
            }
        }
        rl.forEach(l -> {
            List<String> list = l.subList(1, l.size());
            list.sort(String::compareTo);
        });
        return rl;
    }
}
