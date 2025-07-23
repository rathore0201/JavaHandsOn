package org.example.dsa.searchAlgo;

public class LinearSearch {
    public static void main(String[] args) {
        int[] arr = {2,3,4,5,7,8,9};
        int target  = 8;

        int result = linearSearch(arr, target);
        if(result == -1){
            System.out.println("Element not found");
        }else {
            System.out.println("Element found at index : " + result);
        }
    }

    public static int linearSearch(int[] arr, int target){
        for(int i=0; i<arr.length; i++){
            if(arr[i] == target){
                return i;
            }
        }
        return -1;
    }
}
