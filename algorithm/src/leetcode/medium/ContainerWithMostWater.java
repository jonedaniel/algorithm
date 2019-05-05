package leetcode.medium;

/**
 * Title: ContainerWithMostWater
 * Description:
 * 给定 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。
 * 在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0)。
 * 找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
 * 说明：你不能倾斜容器，且 n 的值至少为 2。
 *
 * @author zhaomenghui
 * @version 1.0
 * @createDate 2019/3/21
 */
public class ContainerWithMostWater {
    public static void main(String[] args) {
        System.out.println(new ContainerWithMostWater().maxArea(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7}));
    }

    public int maxArea(int[] arr) {
        int sum = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                int temp = (arr[i] > arr[j] ? arr[j] : arr[i]) * (j - i);
                sum = sum > temp ? sum : temp;
                if (sum == 56) {
                    System.out.println("在这");
                }
            }
        }
        return sum;
    }
}
