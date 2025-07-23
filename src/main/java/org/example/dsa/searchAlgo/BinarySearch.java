package org.example.dsa.searchAlgo;

public class BinarySearch {
    public static void main(String[] args) {
        int[] arr = {2,3,4,5,7,8,9};
        int target  = 8;

//        int result = binarySearch(arr, target);


        int result = binarySearchWithRecursion(arr, target, 0, arr.length-1);
        if(result == -1){
            System.out.println("Element not found");
        }else {
            System.out.println("Element found at index : " + result);
        }
    }

    public static int binarySearch(int[] arr, int target){
        int left = 0;
        int right = arr.length - 1;

        while (left <= right){
            int mid = (left + right) / 2;

            if(arr[mid] == target){
                return mid;
            }else if(target < arr[mid]){
                right = mid - 1;
            }else {
                left = mid + 1;
            }
        }
        return -1;
    }

    public static int binarySearchWithRecursion(int[] arr, int target, int left, int right){

        if(left <= right){
            int mid = (left + right) / 2;
            if(arr[mid] == target)
                return mid;
            else if (target < arr[mid]) {
                return binarySearchWithRecursion(arr, target, left, mid-1);
            }else
                return binarySearchWithRecursion(arr, target, mid+1, right);
        }
        return -1;
    }
}
