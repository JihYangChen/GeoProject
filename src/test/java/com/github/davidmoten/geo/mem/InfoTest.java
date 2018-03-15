package com.github.davidmoten.geo.mem;
import com.google.common.base.Optional;

import org.junit.Test;

import static org.junit.Assert.*;

public class InfoTest {

    /* double id() */
    @Test
    public void idTest_nonNull() {
        Info<String, Integer> info = new Info<String, Integer>(23.25, 120.55, 123, "2", Optional.of(30));
        assertEquals(Optional.of(30), info.id());
    }

    @Test
    public void idTest_null() {
        Integer i = null;
        Info<String, Integer> info = new Info<String, Integer>(23.25, 120.55, 123, "2", Optional.fromNullable(i));
        assertTrue(!info.id().isPresent());
    }

    /* double lat() */
    @Test
    public void latTest() {
        Info<String, Integer> info = new Info<String, Integer>(23.25, 120.55, 123, "2", Optional.of(30));
        assertEquals(23.25, info.lat(), 0);
    }

    /* double lon() */
    @Test
    public void lonTest() {
        Info<String, Integer> info = new Info<String, Integer>(23.25, 120.55, 123, "2", Optional.of(30));
        assertEquals(120.55, info.lon(), 0);
    }

    /* long time() */
    @Test
    public void timeTest() {
        Info<String, Integer> info = new Info<String, Integer>(23.25, 120.55, 123, "2", Optional.of(30));
        assertEquals(123, info.time());
    }

    /* long value() */
    @Test
    public void valueTest() {
        Info<String, Integer> info = new Info<String, Integer>(23.25, 120.55, 123, "2", Optional.of(30));
        assertEquals("2", info.value());
    }

    /* String toString() */
    @Test
    public void toStringTest() {
        Info<String, Integer> info = new Info<String, Integer>(23.25, 120.55, 123, "2", Optional.of(30));
        assertEquals("Info [lat=23.25, lon=120.55, time=123, value=2, id=Optional.of(30)]", info.toString());
    }
}