package search;


import static util.ArrayUtil.print;

public class BinarySearch {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        print(arr);
        System.out.println(new BinarySearch().search(arr,1,0,arr.length-1));
    }

    private int search(int[] arr, int v,int start,int end) {
        if (end < start) return -1;
        int mid = (end -start)/2+start;
        if(arr[mid]==v) return mid;
        else if (arr[mid] > v) return search(arr, v, start, mid - 1);
        else return search(arr, v, mid + 1, end);
    }

}
