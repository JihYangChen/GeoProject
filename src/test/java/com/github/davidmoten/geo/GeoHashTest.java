package com.github.davidmoten.geo;

import org.junit.Rule;
import org.junit.Test;

import static org.junit.Assert.*;
import org.junit.rules.ExpectedException;

public class GeoHashTest {

    /* String right(String hash) */
    @Test
    public void right() {
        String adjacentHash = GeoHash.right("29jw");
        assertEquals("29jy", adjacentHash);
    }

    @Rule
    public ExpectedException thrown= ExpectedException.none();
    @Test
    public void right_illegalArgumentException() {
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage("adjacent has no meaning for a zero length hash that covers the whole world");
        GeoHash.right("");
    }

    /* String left(String hash) */
    @Test
    public void left() {
        String adjacentHash = GeoHash.left("29jw");
        assertEquals("29jq", adjacentHash);
    }

    @Test
    public void left_illegalArgumentException() {
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage("adjacent has no meaning for a zero length hash that covers the whole world");
        GeoHash.left("");
    }

    /* String top(String hash) */
    @Test
    public void top() {
        String adjacentHash = GeoHash.top("29jw");
        assertEquals("29jx", adjacentHash);
    }

    @Test
    public void top_illegalArgumentException() {
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage("adjacent has no meaning for a zero length hash that covers the whole world");
        GeoHash.top("");
    }

    /* String bottom(String hash) */
    @Test
    public void bottom() {
        String adjacentHash = GeoHash.bottom("29jw");
        assertEquals("29jt", adjacentHash);
    }

    @Test
    public void bottom_illegalArgumentException() {
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage("adjacent has no meaning for a zero length hash that covers the whole world");
        GeoHash.bottom("");
    }
}