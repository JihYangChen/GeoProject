package com.github.davidmoten.geo;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.Rule;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.*;

public class Base32Test {

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    /* String encodeBase32(long i, int length) */
    @Test
    public void encodeBase32Test_T1() {
        String encode = Base32.encodeBase32(Long.MIN_VALUE, 0);
        assertEquals("-8000000000000", encode);
    }

    @Test
    public void encodeBase32Test_T2() {
        String encode = Base32.encodeBase32(Long.MIN_VALUE, 4);
        assertEquals("-8000000000000", encode);
    }

    @Test
    public void encodeBase32Test_T3() {
        String encode = Base32.encodeBase32(-75324, 0);
        assertEquals("-29jw", encode);
    }

    @Test
    public void encodeBase32Test_T4() {
        String encode = Base32.encodeBase32(-75324, 4);
        assertEquals("-29jw", encode);
    }

    @Test
    public void encodeBase32Test_T5() {
        String encode = Base32.encodeBase32(0, 0);
        assertEquals("0", encode);
    }

    @Test
    public void encodeBase32Test_T6() {
        String encode = Base32.encodeBase32(0, 4);
        assertEquals("0000", encode);
    }

    @Test
    public void encodeBase32Test_T7() {
        String encode = Base32.encodeBase32(75324, 0);
        assertEquals("29jw", encode);
    }

    @Test
    public void encodeBase32Test_T8() {
        String encode = Base32.encodeBase32(75324, 4);
        assertEquals("29jw", encode);
    }

    @Test
    public void encodeBase32Test_T9() {
        String encode = Base32.encodeBase32(Long.MAX_VALUE, 0);
        assertEquals("7zzzzzzzzzzzz", encode);
    }

    @Test
    public void encodeBase32Test_T10() {
        String encode = Base32.encodeBase32(Long.MAX_VALUE, 4);
        assertEquals("7zzzzzzzzzzzz", encode);
    }


    /* String encodeBase32(long i) */
    @Test
    public void encodeBase32Test_T11() {
        String encode = Base32.encodeBase32(Long.MIN_VALUE);
        assertEquals("-8000000000000", encode);
    }

    @Test
    public void encodeBase32Test_T12() {
        String encode = Base32.encodeBase32(-75324);
        assertEquals("-0000000029jw", encode);
    }

    @Test
    public void encodeBase32Test_T13() {
        String encode = Base32.encodeBase32(0);
        assertEquals("000000000000", encode);
    }

    @Test
    public void encodeBase32Test_T14() {
        String encode = Base32.encodeBase32(75324);
        assertEquals("0000000029jw", encode);
    }

    @Test
    public void encodeBase32Test_T15() {
        String encode = Base32.encodeBase32(Long.MAX_VALUE);
        assertEquals("7zzzzzzzzzzzz", encode);
    }

    /* long decodeBase32(String hash) */
    @Test
    public void decodeBase32Test_T16() {
        long decode = Base32.decodeBase32("-8000000000000");
        assertEquals(Long.MIN_VALUE, decode);
    }

    @Test
    public void decodeBase32Test_T17() {
        long decode = Base32.decodeBase32("-29jw");
        assertEquals(-75324, decode);
    }

    @Test
    public void decodeBase32Test_T18() {
        long decode = Base32.decodeBase32("0");
        assertEquals(0, decode);
    }

    @Test
    public void decodeBase32Test_T19() {
        long decode = Base32.decodeBase32("29jw");
        assertEquals(75324, decode);
    }

    @Test
    public void decodeBase32Test_T20() {
        long decode = Base32.decodeBase32("7zzzzzzzzzzzz");
        assertEquals(Long.MAX_VALUE, decode);
    }


    /* int getCharIndex(char ch) */
    @Test
    public void getCharIndexTest_T21() {
        int index = Base32.getCharIndex('b');
        assertEquals(10, index);
    }

    @Rule
    public ExpectedException thrown= ExpectedException.none();
    @Test
    public void getCharIndexTest_T22() {
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage("not a base32 character: a");
        Base32.getCharIndex('a');
    }

    /* String padLeftWithZerosToLength(String s, int length) */
    @Test
    public void padLeftWithZerosToLengthTest_T23() {
        String returnString = Base32.padLeftWithZerosToLength("4bca", 8);
        assertEquals("00004bca", returnString);
    }

    @Test
    public void padLeftWithZerosToLengthTest_T24() {
        String returnString = Base32.padLeftWithZerosToLength("4bca", 2);
        assertEquals("4bca", returnString);
    }

}