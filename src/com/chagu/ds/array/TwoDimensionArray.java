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

    public int accessCell(int row, int column) {
        validateRowColumn(row, column);
        if (arr[row][column] == Integer.MIN_VALUE)
            throw new RuntimeException("Cell is not assigned.");
        return arr[row][column];
    }

    public void searchValue(int value) {
        for (int row = 0; row < arr.length; row++) {
            for (int column = 0; column < arr[row].length; column++) {
                if (arr[row][column] == value) {
                    System.out.println("Value " + value + " found at [" + row + "][" + column + "]");
                    return;
                }
            }
        }
        System.out.println("Value " + value + " is not present in the array.");
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
        twoDimensionArray.insertValue(0, 0, 10);
        twoDimensionArray.insertValue(0, 1, 10);
        twoDimensionArray.insertValue(0, 2, 10);
        twoDimensionArray.insertValue(1, 0, 10);
        twoDimensionArray.insertValue(1, 1, 10);
        twoDimensionArray.insertValue(1, 2, 10);
        twoDimensionArray.insertValue(2, 0, 10);
        twoDimensionArray.insertValue(2, 1, 10);
        twoDimensionArray.insertValue(2, 2, 10);
        twoDimensionArray.overrideValue(2, 2, 25);
        twoDimensionArray.traverseTheArray();
        System.out.println("Value at cell number [2][2] is " + twoDimensionArray.accessCell(2, 2));
        twoDimensionArray.searchValue(25);
    }
}
