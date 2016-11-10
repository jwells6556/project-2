package com.justinwells.project2;

import org.junit.Test;

import static junit.framework.Assert.assertEquals;

/**
 * Created by justinwells on 11/10/16.
 */

public class MovieTest {
    Movie movie = new Movie("Justin Wells: A Hero's Journey", "Action","$20.00", 5, 5,
         "A young boy sets out to " +
         "fulfil his destiny. Along the way he realizes he has become a man", 2016);

    @Test
    public void testIfTitleIsCorrect() {
        String expected = "Justin Wells: A Hero's Journey";
        String actual = movie.getTitle();
        assertEquals(expected, actual);
    }

    @Test
    public void testIfGenreIsCorrect() {
        String expected = "Action";
        String actual = movie.getGenre();
        assertEquals(expected, actual);
    }

    @Test
    public void testIfPriceIsCorrect() {
        String expected = "$20.00";
        String actual = movie.getPrice();
        assertEquals(expected, actual);
    }

    @Test
    public void testIfIdIsCorrect() {
        int expected = 5;
        int actual = movie.getId();
        assertEquals(expected, actual);
    }

    @Test
    public void testIfRatingIsCorrect() {
        int expected = 5;
        int actual = movie.getReview();
        assertEquals(expected, actual);
    }

    @Test
    public void testIfDescriptionIsCorrect() {
        String expected = "A young boy sets out to fulfil his destiny. Along the way he realizes " +
                "he has become a man";
        String actual = movie.getDescription();
        assertEquals(expected, actual);
    }

    @Test
    public void testIfReleaseIsCorrect() {
        int expected = 2016;
        int actual = movie.getRelease();
        assertEquals(expected, actual);
    }

}
