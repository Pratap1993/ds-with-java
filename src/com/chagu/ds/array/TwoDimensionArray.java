package com.chagu.ds.array;

public class TwoDimensionArray {
    private final int[][] arr;
    private boolean isAssigned = false;

    public TwoDimensionArray(int rowSize, int columnSize) {
        validateRowColumnSize(rowSize, columnSize);
        this.arr = new int[rowSize][columnSize];
        for (int row = 0; row < rowSize; row++) {
            for (int column = 0; column < columnSize; column++)
                arr[row][column] = Integer.MIN_VALUE;
        }
    }

    public void traverseTheArray() {
        if (!isAssigned)
            return;
        for (int row = 0; row < arr.length; row++) {
            for (int column = 0; column < arr[row].length; column++) {
                System.out.print(arr[row][column] + " ");
            }
            System.out.println();
        }
    }

    public void insertValue(int row, int column, int value) {
        validateRowColumn(row, column);
        if (arr[row][column] == Integer.MIN_VALUE) {
            arr[row][column] = value;
        } else
            System.out.println("This cell is already occupied.");
        isAssigned = true;
    }

    public void overrideValue(int row, int column, int value) {
        validateRowColumn(row, column);
        arr[row][column] = value;
        System.out.println("Value overridden");
    }

    private void validateRowColumnSize(int rowSize, int columnSize) {
        if (rowSize < 1 && columnSize < 1)
            throw new RuntimeException("Row size and column size must be grater than zero.");
    }

    private void validateRowColumn(int rowSize, int columnSize) {
        if (rowSize < 0 && columnSize < 0)
            throw new RuntimeException("Row and column must not be negative numbers.");
    }

    public static void main(String[] args) {
        TwoDimensionArray twoDimensionArray = new TwoDimensionArray(3, 3);
        twoDimensionArray.insertValue(0,0, 10);
        twoDimensionArray.insertValue(0,1, 10);
        twoDimensionArray.insertValue(0,2, 10);
        twoDimensionArray.insertValue(1,0, 10);
        twoDimensionArray.insertValue(1,1, 10);
        twoDimensionArray.insertValue(1,2, 10);
        twoDimensionArray.insertValue(2,0, 10);
        twoDimensionArray.insertValue(2,1, 10);
        twoDimensionArray.insertValue(2,2, 10);
        twoDimensionArray.traverseTheArray();
    }
}
