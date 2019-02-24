package search;


import static util.ArrayUtil.print;

public class BinarySearch {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        print(arr);
        System.out.println(new BinarySearch().searchRound4(arr,9,0,arr.length-1));
    }

    private int searchRound4(int[] arr, int v, int l, int h) {
        if(l > h) return -1;
        int mid = l + (h - l) / 2;
        if(v ==arr[mid])return mid;
        else if(v > arr[mid]) return searchRound4(arr, v, mid + 1, h);
        else return searchRound4(arr, v, l, mid - 1);
    }

    private int searchRound3(int[] arr, int v, int low, int high) {
        int mid = low + (high - low) / 2;
        if(low > high)return -1;
        else if (arr[mid] == v)return mid;
        else if (arr[mid] > v) return searchRound3(arr, v, low, mid - 1);
        else return searchRound3(arr, v, mid + 1, high);
    }

    private int searchRound2(int[] arr, int v, int start, int end) {
        if(end < start) return -1;
        int mid = start + (end - start) / 2;
        if(arr[mid] == v)return mid;
        else if(arr[mid] > v) return searchRound2(arr, v, start, mid - 1);
        else if(arr[mid] < v) return searchRound2(arr, v, mid + 1, end);
        else return -1;
    }

    private int search(int[] arr, int v,int start,int end) {
        if (end < start) return -1;
        int mid = (end -start)/2+start;
        if(arr[mid]==v) return mid;
        else if (arr[mid] > v) return search(arr, v, start, mid - 1);
        else return search(arr, v, mid + 1, end);
    }

}
