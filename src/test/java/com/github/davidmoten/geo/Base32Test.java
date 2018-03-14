package com.github.davidmoten.geo;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.Rule;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.*;

public class Base32Test {

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    /* String encodeBase32(long i, int length) */
    @Test
    public void encodeBase32_positive() throws Exception {
        String encode = Base32.encodeBase32(75324, 4);
        assertEquals("29jw", encode);
    }

    @Test
    public void encodeBase32_negative() throws Exception {
        String encode = Base32.encodeBase32(-75324, 4);
        assertEquals("-29jw", encode);
    }

    @Test
    public void encodeBase32_maxValue() throws Exception {
        String encode = Base32.encodeBase32(Long.MAX_VALUE, 4);
        assertEquals("7zzzzzzzzzzzz", encode);
    }

    @Test
    public void encodeBase32_minValue() throws Exception {
        String encode = Base32.encodeBase32(Long.MIN_VALUE, 4);
        assertEquals("-8000000000000", encode);
    }

    /* String encodeBase32(long i) */
    @Test
    public void encodeBase32_MAX_HASH_LENGTH_positive() throws Exception {
        String encode = Base32.encodeBase32(75324);
        assertEquals("0000000029jw", encode);
    }

    @Test
    public void encodeBase32_MAX_HASH_LENGTH_negative() throws Exception {
        String encode = Base32.encodeBase32(-75324);
        assertEquals("-0000000029jw", encode);
    }

    /* long decodeBase32(String hash) */
    @Test
    public void decodeBase32_positive() throws Exception {
        long decode = Base32.decodeBase32("29jw");
        assertEquals(75324, decode);
    }

    @Test
    public void decodeBase32_negative() throws Exception {
        long decode = Base32.decodeBase32("-29jw");
        assertEquals(-75324, decode);
    }

    @Test
    public void decodeBase32_maxValue() throws Exception {
        long decode = Base32.decodeBase32("7zzzzzzzzzzzz");
        assertEquals(Long.MAX_VALUE, decode);
    }

    @Test
    public void decodeBase32_minValue() throws Exception {
        long decode = Base32.decodeBase32("-8000000000000");
        assertEquals(Long.MIN_VALUE, decode);
    }

    /* int getCharIndex(char ch) */
    @Test
    public void getCharIndex() throws Exception {
        int index = Base32.getCharIndex('b');
        assertEquals(10, index);
    }

    @Rule
    public ExpectedException thrown= ExpectedException.none();
    @Test
    public void getCharIndex_exception() {
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage("not a base32 character: a");
        Base32.getCharIndex('a');
    }

    /* String padLeftWithZerosToLength(String s, int length) */
    @Test
    public void padLeftWithZerosToLength_shorterThanLength() throws Exception {
        String returnString = Base32.padLeftWithZerosToLength("4bca", 8);
        assertEquals("00004bca", returnString);
    }

    @Test
    public void padLeftWithZerosToLength_longerThanLength() throws Exception {
        String returnString = Base32.padLeftWithZerosToLength("4bca", 2);
        assertEquals("4bca", returnString);
    }

}