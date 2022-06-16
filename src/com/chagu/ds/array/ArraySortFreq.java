package com.chagu.ds.array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class ArraySortFreq {

    public static void main(String[] args) {
        int[] input = {4, 3, 1, 6, 4, 3, 6, 4};
        int[] output = sortArrayInTermsOfRepeatFrequency(input);
        String inputStr = Arrays.toString(input);
        System.out.println(inputStr);
        String returnType = Arrays.toString(output);
        System.out.println(returnType);
    }

    //A method to sort an array based on repetition frequency descending-ly
    private static int[] sortArrayInTermsOfRepeatFrequency(int[] input) {
        int[] output = new int[input.length];
        Map<Integer, Integer> elementCountMap = new HashMap<>();
        for (int i : input) {
            if (elementCountMap.containsKey(i))
                elementCountMap.replace(i, elementCountMap.get(i) + 1);
            else
                elementCountMap.put(i, 1);
        }
        Map<Integer, Integer> sortedMap = elementCountMap.entrySet().stream()
                .sorted(Map.Entry.<Integer, Integer>comparingByValue().reversed())
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));
        int position = 0;
        for (Map.Entry<Integer, Integer> entry : sortedMap.entrySet()) {
            for (int i = 0; i < entry.getValue(); i++) {
                output[position] = entry.getKey();
                position++;
            }
        }
        return output;
    }
}
