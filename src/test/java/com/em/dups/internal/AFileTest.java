package com.em.dups.internal;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * to test the functionality of the obj
 */
public class AFileTest {

    String input ="afile.txt";

    @Test
    public void extractName() {

        String expected = "afile";
        String actual = AFile.extractName(input);
        assertEquals(expected,actual);
    }

    @Test
    public void extractType() {
        String expected = "txt";
        String actual = AFile.extractName(input);
        assertEquals(expected,actual);
    }

    @Test
    public void createObject() {
    }

    @Test
    public void extractType1() {
    }
}