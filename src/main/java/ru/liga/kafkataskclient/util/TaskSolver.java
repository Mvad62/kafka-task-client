package ru.liga.kafkataskclient.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TaskSolver {

    public static List<Integer> solveFirstTask(List<Integer> numbers) {
        List<Integer> result = new ArrayList<>(numbers);
        Collections.sort(result);
        return result;
    }

    public static List<Integer> solveSecondTask(List<Integer> numbers) {
        List<Integer> result = new ArrayList<>();
        for (int number : numbers) {
            if (isPrime(number)) {
                result.add(number);
            }
        }
        return result;
    }

    private static boolean isPrime(int number) {
        if (number < 2) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }
}
