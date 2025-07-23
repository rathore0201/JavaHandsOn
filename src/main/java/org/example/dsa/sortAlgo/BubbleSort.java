package org.example.dsa.sortAlgo;

public class BubbleSort {
    public static void main(String[] args) {
        int[] arr = {2,3,6,1,4,8,6,9};

        bubbleSort(arr, arr.length);

        for(int i: arr){
            System.out.println(i);
        }
    }


    public static void bubbleSort(int[] arr, int size){
        for(int i=0; i<size; i++){
            for(int j=0; j<size-1; j++){
                if(arr[j] > arr[j+1]){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
    }
}
