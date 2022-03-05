package com.chagu.ds.array;

public class ArrayMain {

    public static void main(String[] args) {
        testOneDimensionArrayTraversal();
    }

    public static void testOneDimensionArrayTraversal() {
        OneDimensionArray oneDArray = new OneDimensionArray(5);
        for (int i = 0; i < oneDArray.arr.length; i++) {
            oneDArray.arr[i] = (i + 1) * 10;
        }
        System.out.println(oneDArray.toString());
        System.out.println(oneDArray.accessIndex(4));
        System.out.println(oneDArray.linearSearchValue(50));
    }
}
