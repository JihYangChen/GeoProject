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


    /* String encodeHash(double latitude, double longitude, int length) */
    @Test
    public void encodeHashTest_T33() {
        String encodeHash = GeoHash.encodeHash(-90, -180, 4);
        assertEquals("0000", encodeHash);
    }

    @Test
    public void encodeHashTest_T34() {
        String encodeHash = GeoHash.encodeHash(-90, 0, 4);
        assertEquals("h000", encodeHash);
    }

    @Test
    public void encodeHashTest_T35() {
        String encodeHash = GeoHash.encodeHash(-90, 180, 4);
        assertEquals("pbpb", encodeHash);
    }

    @Test
    public void encodeHashTest_T36() {
        String encodeHash = GeoHash.encodeHash(0, -180, 4);
        assertEquals("8000", encodeHash);
    }

    @Test
    public void encodeHashTest_T37() {
        String encodeHash = GeoHash.encodeHash(0, 0, 4);
        assertEquals("s000", encodeHash);
    }

    @Test
    public void encodeHashTest_T38() {
        String encodeHash = GeoHash.encodeHash(0, 180, 4);
        assertEquals("xbpb", encodeHash);
    }

    @Test
    public void encodeHashTest_T39() {
        String encodeHash = GeoHash.encodeHash(90, -180, 4);
        assertEquals("bpbp", encodeHash);
    }

    @Test
    public void encodeHashTest_T40() {
        String encodeHash = GeoHash.encodeHash(90, 0, 4);
        assertEquals("upbp", encodeHash);
    }

    @Test
    public void encodeHashTest_T41() {
        String encodeHash = GeoHash.encodeHash(90, 180, 4);
        assertEquals("zzzz", encodeHash);
    }


    /* decodeHash(String geohash) */
    @Test
    public void decodeHash_T42() {
        thrown.expect(NullPointerException.class);
        thrown.expectMessage("geohash cannot be null");
        GeoHash.decodeHash(null);
    }

    @Test
    public void decodeHash_T43() {
        LatLong latlong = new LatLong(90, 0);
        LatLong decodeHash = GeoHash.decodeHash("upbp");

        assertEquals(latlong.getLat(), decodeHash.getLat(), 1);
        assertEquals(latlong.getLon(), decodeHash.getLon(), 1);
    }


    /* encodeHashToLong(double latitude, double longitude, int length) */
    @Test
    public void encodeHashToLong_T1() {
        long decodeHash = GeoHash.encodeHashToLong(23, 120, 0);
        long assertHash = Long.parseLong("0");
        assertEquals(assertHash, decodeHash);
    }

    @Test
    public void encodeHashToLong_T2() {
        long decodeHash = GeoHash.encodeHashToLong(23, 120, 4);
        long assertHash = Long.parseLong("-1863821742661697532");
        assertEquals(assertHash, decodeHash);
    }

}