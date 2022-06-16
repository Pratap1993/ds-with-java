package com.chagu.ds.array;

public class OneDimensionArray {

    private final int[] arr;

    public OneDimensionArray(int arraySize) {
        arr = new int[arraySize];
        for (int i = 0; i < arraySize; i++)
            arr[i] = Integer.MIN_VALUE;
    }

    public void insert(int location, int value) {
        if (arr.length - 1 < location || location < 0)
            throw new ArrayIndexOutOfBoundsException("Invalid index to insert data !!!");
        arr[location] = value;
    }

    public void safeInsert(int location, int value) {
        if (arr.length - 1 < location || location < 0)
            throw new ArrayIndexOutOfBoundsException("Invalid index to insert data !!!");
        if (arr[location] > Integer.MIN_VALUE)
            throw new RuntimeException("Accessed index is already occupied !!!");
        arr[location] = value;
    }

    public int accessIndex(int location) {
        if (arr.length - 1 < location || location < 0)
            throw new ArrayIndexOutOfBoundsException("Invalid index to access data !!!");
        return arr[location];
    }

    public int linearSearchValue(int value) {
        int indexToReturn = -1;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == value) {
                indexToReturn = i;
                break;
            }
        }
        if (indexToReturn == -1)
            throw new RuntimeException("Data not found !!!");
        return indexToReturn;
    }

    @Override
    public String toString() {
        if (arr.length == 0)
            return "[ ]";
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < arr.length; i++) {
            if (i == arr.length - 1)
                sb.append(arr[i]);
            else
                sb.append(arr[i]).append(", ");
        }
        sb.append("]");
        return sb.toString();
    }

    public static void main(String[] args) {
        OneDimensionArray oneDArray = new OneDimensionArray(5);
        for (int i = 0; i < oneDArray.arr.length; i++)
            oneDArray.arr[i] = (i + 1) * 10;
        System.out.println(oneDArray);
        System.out.println(oneDArray.accessIndex(4));
        System.out.println(oneDArray.linearSearchValue(50));
        oneDArray.insert(2, 25);
        System.out.println(oneDArray);
    }

}
