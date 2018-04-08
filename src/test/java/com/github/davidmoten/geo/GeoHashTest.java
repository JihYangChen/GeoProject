package com.github.davidmoten.geo;

import org.junit.Rule;
import org.junit.Test;

import static org.junit.Assert.*;
import org.junit.rules.ExpectedException;

public class GeoHashTest {

    /* String right(String hash) */
    @Rule
    public ExpectedException thrown= ExpectedException.none();
    @Test
    public void rightTest_T25() {
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage("adjacent has no meaning for a zero length hash that covers the whole world");
        GeoHash.right("");
    }

    @Test
    public void rightTest_T26() {
        String adjacentHash = GeoHash.right("29jw");
        assertEquals("29jy", adjacentHash);
    }


    /* String left(String hash) */
    @Test
    public void leftTest_T27() {
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage("adjacent has no meaning for a zero length hash that covers the whole world");
        GeoHash.left("");
    }

    @Test
    public void leftTest_T28() {
        String adjacentHash = GeoHash.left("29jw");
        assertEquals("29jq", adjacentHash);
    }


    /* String top(String hash) */
    @Test
    public void topTest_T29() {
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage("adjacent has no meaning for a zero length hash that covers the whole world");
        GeoHash.top("");
    }

    @Test
    public void topTest_T30() {
        String adjacentHash = GeoHash.top("29jw");
        assertEquals("29jx", adjacentHash);
    }


    /* String bottom(String hash) */
    @Test
    public void bottomTest_T31() {
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage("adjacent has no meaning for a zero length hash that covers the whole world");
        GeoHash.bottom("");
    }

    @Test
    public void bottomTest_T32() {
        String adjacentHash = GeoHash.bottom("29jw");
        assertEquals("29jt", adjacentHash);
    }

}