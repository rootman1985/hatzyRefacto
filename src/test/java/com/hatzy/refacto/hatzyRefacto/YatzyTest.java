package com.hatzy.refacto.hatzyRefacto;

import org.junit.jupiter.api.Test;

import static com.hatzy.refacto.hatzyRefacto.Yatzy.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class YatzyTest {

    @Test
    public void should_get_chance_scores_sum_of_all_dice() {
        int expected_15 = 15;
        int expected_16 = 16;

        assertEquals(expected_15, chance(2, 3, 4, 5, 1));
        assertEquals(expected_16, chance(3, 3, 4, 5, 1));
    }

    @Test
    public void should_get_yatzy_scores_50() {
        int expected_50 = 50;
        int expected_0 = 0;

        assertEquals(expected_50, yatzy(4, 4, 4, 4, 4));
        assertEquals(expected_50, yatzy(6, 6, 6, 6, 6));
        assertEquals(expected_0, yatzy(6, 6, 6, 6, 3));
    }

    @Test
    public void should_get_ones() {
        assertEquals(1, ones(1, 2, 3, 4, 5));
        assertEquals(2, ones(1, 2, 1, 4, 5));
        assertEquals(0, ones(6, 2, 2, 4, 5));
        assertEquals(4, ones(1, 2, 1, 1, 1));
    }

    @Test
    public void should_get_twos() {
        assertEquals(4, twos(1, 2, 3, 2, 6));
        assertEquals(10, twos(2, 2, 2, 2, 2));
    }

    @Test
    public void should_get_threes() {
        assertEquals(6, threes(1, 2, 3, 2, 3));
        assertEquals(12, threes(2, 3, 3, 3, 3));
    }

    @Test
    public void should_get_fours() {
        assertEquals(12, fours(4, 4, 4, 5, 5));
        assertEquals(8, fours(4, 4, 5, 5, 5));
        assertEquals(4, fours(4, 5, 5, 5, 5));
    }

    @Test
    public void should_get_fives() {
        assertEquals(10, fives(4, 4, 4, 5, 5));
        assertEquals(15, fives(4, 4, 5, 5, 5));
        assertEquals(20, fives(4, 5, 5, 5, 5));
    }

    @Test
    public void should_get_sixes() {
        assertEquals(0, sixes(4, 4, 4, 5, 5));
        assertEquals(6, sixes(4, 4, 6, 5, 5));
        assertEquals(18, sixes(6, 5, 6, 6, 5));
    }

    @Test
    public void should_get_one_pair() {
        assertEquals(6, score_pair(3, 4, 3, 5, 6));
        assertEquals(10, score_pair(5, 3, 3, 3, 5));
        assertEquals(12, score_pair(5, 3, 6, 6, 5));
    }

    @Test
    public void should_get_two_Pair() {
        assertEquals(16, two_pair(3, 3, 5, 4, 5));
        assertEquals(16, two_pair(3, 3, 5, 5, 5));
    }

    @Test
    public void should_get_three_of_a_kind() {
        assertEquals(9, three_of_a_kind(3, 3, 3, 4, 5));
        assertEquals(15, three_of_a_kind(5, 3, 5, 4, 5));
        assertEquals(9, three_of_a_kind(3, 3, 3, 3, 5));
        assertEquals(9, three_of_a_kind(3, 3, 3, 3, 3));
    }

    @Test
    public void should_get_four_of_a_knd() {
        assertEquals(12, four_of_a_kind(3, 3, 3, 3, 5));
        assertEquals(20, four_of_a_kind(5, 5, 5, 4, 5));
    }

    @Test
    public void should_get_smallStraight() {
        assertEquals(15, smallStraight(1, 2, 3, 4, 5));
        assertEquals(15, smallStraight(2, 3, 4, 5, 1));
        assertEquals(0, smallStraight(1, 2, 2, 4, 5));
    }

    @Test
    public void should_get_largeStraight() {
        assertEquals(20, largeStraight(6, 2, 3, 4, 5));
        assertEquals(20, largeStraight(2, 3, 4, 5, 6));
        assertEquals(0, largeStraight(1, 2, 2, 4, 5));
    }

    @Test
    public void should_get_fullHouse() {
        assertEquals(18, fullHouse(6, 2, 2, 2, 6));
        assertEquals(0, fullHouse(2, 3, 4, 5, 6));
    }
}
