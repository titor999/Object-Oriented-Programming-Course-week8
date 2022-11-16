package org.oop.apps;

import java.util.*;

import static org.oop.util.Util.convertListStringToIntegerList;
import static org.oop.util.Util.convertStringToList;

public class Permutations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a listArray -> ");
        String s = scanner.nextLine();
        System.out.println(perms(convertListStringToIntegerList(convertStringToList(s))));
    }

    public static <E> List<List<E>> perms(List<E> original) {
        if (original.isEmpty()) {
            List<List<E>> result = new ArrayList<>();
            result.add(new ArrayList<>());
            return result;
        }
        E firstElement = original.remove(0);
        List<List<E>> returnValue = new ArrayList<>();
        List<List<E>> permutations = perms(original);
        for (List<E> smallerPermutated : permutations) {
            for (int index = 0; index <= smallerPermutated.size(); index++) {
                List<E> temp = new ArrayList<>(smallerPermutated);
                temp.add(index, firstElement);
                returnValue.add(temp);
            }
        }
        return returnValue;
    }
}
