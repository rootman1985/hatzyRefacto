package com.hatzy.refacto.hatzyRefacto;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import static java.util.Arrays.asList;

public class Yatzy {

    public static int chance(int... dice) {
        return sum(dice);
    }

    public static int yatzy(int... dice) {
        if (diceFrequencies(dice).containsValue(5)) {
            return 50;
        }
        return 0;
    }

    public static int ones(int... dice) {
        return numberOfDiceFrequency(1, dice);
    }

    public static int twos(int... dice) {
        return numberOfDiceFrequency(2, dice);
    }

    public static int threes(int... dice) {
        return numberOfDiceFrequency(3, dice);
    }

    public static int fours(int... dice) {
        return numberOfDiceFrequency(4, dice);
    }

    public static int fives(int... dice) {
        return numberOfDiceFrequency(5, dice);
    }

    public static int sixes(int... dice) {
        return numberOfDiceFrequency(6, dice);
    }

    public static int two_pair(int... dice) {
        Map<Integer, Integer> frequencies = diceFrequencies(dice);
        int score = 0;
        boolean containsTwoPair = frequencies
                .values()
                .stream()
                .filter(value -> value >= 2)
                .count() == 2;

        if (containsTwoPair) {
            for (int maxFace : asList(6, 5, 4, 3, 2, 1)) {
                if (frequencies.get(maxFace) >= 2) {
                    score += maxFace * 2;
                }
            }
        }
        return score;
    }

    public static int score_pair(int... dice) {
        return numberOfAKind(2, dice);
    }

    public static int four_of_a_kind(int... dice) {
        return numberOfAKind(4, dice);
    }

    public static int three_of_a_kind(int... dice) {
        return numberOfAKind(3, dice);
    }

    public static int smallStraight(int... dice) {
        if (isStraight(dice) && diceFrequencies(dice).get(6) == 0) {
            return sum(dice);
        }
        return 0;
    }

    public static int largeStraight(int... dice) {
        if (isStraight(dice) && diceFrequencies(dice).get(1) == 0) {
            return sum(dice);
        }
        return 0;
    }

    public static int fullHouse(int... dice) {
        Map<Integer, Integer> frequencies = diceFrequencies(dice);
        if (frequencies.containsValue(2) && frequencies.containsValue(3)) {
            return sum(dice);
        }
        return 0;
    }

    private static Map<Integer, Integer> diceFrequencies(int... dice) {
        HashMap<Integer, Integer> frequencies = new HashMap<>();
        for (int face : asList(1, 2, 3, 4, 5, 6)) {
            frequencies.put(face, 0);
        }
        for (int die : dice) {
            frequencies.put(die, frequencies.get(die) + 1);
        }

        return frequencies;
    }

    private static int numberOfDiceFrequency(int number, int... dice) {
        return diceFrequencies(dice).get(number) * number;
    }

    private static int numberOfAKind(int number, int... dice) {
        for (int maxFace : asList(6, 5, 4, 3, 2, 1)) {
            if (diceFrequencies(dice).get(maxFace) >= number) {
                return maxFace * number;
            }
        }
        return 0;
    }

    private static boolean isStraight(int... dice) {
        return diceFrequencies(dice)
                .values()
                .stream()
                .filter(value -> value == 1)
                .count() == 5;
    }

    private static int sum(int[] dice) {
        return Arrays
                .stream(dice)
                .sum();
    }
}