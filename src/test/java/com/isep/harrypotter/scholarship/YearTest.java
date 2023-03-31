package com.isep.harrypotter.scholarship;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class YearTest {

    @Test
    public void testSkipClass() {
        Year yearSeven = new Year(7, "seventh", "The Deathly Hallows", "Hogwarts", "We recommand you to attend the sorcery class as your final exam is a practice exam on the spell Expelliarmus. ");

        float percentSuccess = 0.5f;
        float expected = 0.45f;
        float actual = yearSeven.SkipClass(percentSuccess);
        assertEquals(expected, actual, 0.01, "percent between 0.3 and 0.95");

        percentSuccess = 0.2f;
        expected = 0.2f;
        actual = yearSeven.SkipClass(percentSuccess);
        assertEquals(expected, actual, 0.01, "percent < 0.3");

        percentSuccess = 0.96f;
        expected = 0.96f;
        actual = yearSeven.SkipClass(percentSuccess);
        assertEquals(expected, actual, 0.01, "percent > 0.95");
    }

    @Test
    public void testSkipClassFireworks() {
        Year yearSeven = new Year(7, "seventh", "The Deathly Hallows", "Hogwarts", "We recommand you to attend the sorcery class as your final exam is a practice exam on the spell Expelliarmus. ");

        float percentFireworks = 0.5f;
        float expected = 0.55f;
        float actual = yearSeven.SkipClassFireworks(percentFireworks);
        assertEquals(expected, actual, 0.01, "percent between 0.3 and 0.95");

        percentFireworks = 0.2f;
        expected = 0.2f;
        actual = yearSeven.SkipClassFireworks(percentFireworks);
        assertEquals(expected, actual, 0.01, "percent < 0.3");

        percentFireworks = 0.96f;
        expected = 0.96f;
        actual = yearSeven.SkipClassFireworks(percentFireworks);
        assertEquals(expected, actual, 0.01, "percent > 0.95");
    }



}
