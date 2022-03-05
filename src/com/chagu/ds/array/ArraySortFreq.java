package com.chagu.ds.array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class ArraySortFreq {

    public static void main(String[] args) {
        int[] input = {4, 3, 1, 6, 4, 3, 6, 4};
        int[] output = new int[input.length];
        Map<Integer, Integer> mymap = new HashMap<>();
        for (int i = 0; i < input.length; i++) {
            if (mymap.containsKey(input[i])) {
                mymap.replace(input[i], mymap.get(input[i]) + 1);
            } else {
                mymap.put(input[i], 1);
            }
        }
        Map<Integer, Integer> sortedMap = mymap.entrySet().stream()
                .sorted(Map.Entry.<Integer, Integer>comparingByValue().reversed())
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));
        int position = 0;
        for (Map.Entry<Integer, Integer> entry : sortedMap.entrySet()) {
            for (int i = 0; i < entry.getValue(); i++) {
                output[position] = entry.getKey();
                position++;
            }
        }
        String inputStr = Arrays.toString(input);
        System.out.println(inputStr);
        String returnType = Arrays.toString(output);
        System.out.println(returnType);
    }
}
