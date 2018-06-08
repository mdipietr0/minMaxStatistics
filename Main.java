package com.michael;

public class Main {

    public static void main(String[] args) {
        int[] a = {32, -9, -80, 54, 87, 34, 5, 98};
        System.out.println(minimum(a));
        System.out.println(maximum(a));
        int[] minMax = minMax(a);
        System.out.println(minMax[0]);
        System.out.println(minMax[1]);
    }

    public static int minimum(int[] a){
        int min = a[0];
        for(int i = 1; i < a.length; i++){
            if(a[i] < min){
                min = a[i];
            }
        }
        return min;
    }

    public static int maximum(int[] a){
        int max = a[0];
        for(int i = 1; i < a.length; i++){
            if(a[i] > max){
                max = a[i];
            }
        }
        return max;
    }

    //finds min and max with a total of 3*(n/2) comparisons
    //faster RT than executing min and max which takes 2n-2 comparisons
    public static int[] minMax(int[] a){
        final int MIN = 0;
        final int MAX = 1;
        int[] minMax = new int[2];
        int isEven;
        if(a.length % 2 == 0) {
            isEven = 1;
        } else {
            isEven = 0;
        }
        if (isEven == 1) {
            if(a[1] > a[0]){
                minMax[MIN] = a[0];
                minMax[MAX] = a[1];
            }
            else {
                minMax[MIN] = a[1];
                minMax[MAX] = a[0];
            }
        } else {
            minMax[MIN] = a[0];
            minMax[MAX] = a[0];
        }
        for(int i = 1 + isEven; i < a.length-1; i+=2){
            if(a[i] < a[i+1]){
                if(a[i] < minMax[MIN]){
                    minMax[MIN] = a[i];
                }
                if(a[i+1] > minMax[MAX]){
                    minMax[MAX] = a[i+1];
                }
            }else{
                if(a[i] > minMax[MAX]){
                    minMax[MAX] = a[i];
                }
                if(a[i+1] < minMax[MIN]){
                    minMax[MIN] = a[i+1];
                }
            }
        }
        return minMax;
    }
}
