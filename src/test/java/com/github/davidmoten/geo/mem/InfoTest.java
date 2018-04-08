package com.github.davidmoten.geo.mem;
import com.google.common.base.Optional;

import org.junit.Test;

import static org.junit.Assert.*;

public class InfoTest {

    /* double id() */
    @Test
    public void idTest_T33() {
        Integer i = null;
        Info<String, Integer> info = new Info<String, Integer>(23.25, 120.55, 123, "2", Optional.fromNullable(i));
        assertTrue(!info.id().isPresent());
    }

    @Test
    public void idTest_T34() {
        Info<String, Integer> info = new Info<String, Integer>(23.25, 120.55, 123, "2", Optional.of(30));
        assertEquals(Optional.of(30), info.id());
    }


    /* double lat() */
    @Test
    public void latTest_T35() {
        Info<String, Integer> info = new Info<String, Integer>(-23.25, 120.55, 123, "2", Optional.of(30));
        assertEquals(-23.25, info.lat(), 0);
    }

    @Test
    public void latTest_T36() {
        Info<String, Integer> info = new Info<String, Integer>(0, 120.55, 123, "2", Optional.of(30));
        assertEquals(0, info.lat(), 0);
    }

    @Test
    public void latTest_T37() {
        Info<String, Integer> info = new Info<String, Integer>(23.25, 120.55, 123, "2", Optional.of(30));
        assertEquals(23.25, info.lat(), 0);
    }


    /* double lon() */
    @Test
    public void lonTest_T38() {
        Info<String, Integer> info = new Info<String, Integer>(23.25, -120.55, 123, "2", Optional.of(30));
        assertEquals(-120.55, info.lon(), 0);
    }

    @Test
    public void lonTest_T39() {
        Info<String, Integer> info = new Info<String, Integer>(23.25, 0, 123, "2", Optional.of(30));
        assertEquals(0, info.lon(), 0);
    }

    @Test
    public void lonTest_T40() {
        Info<String, Integer> info = new Info<String, Integer>(23.25, 120.55, 123, "2", Optional.of(30));
        assertEquals(120.55, info.lon(), 0);
    }


    /* long time() */
    @Test
    public void timeTest_T41() {
        Info<String, Integer> info = new Info<String, Integer>(23.25, 120.55, -123, "2", Optional.of(30));
        assertEquals(-123, info.time());
    }

    @Test
    public void timeTest_T42() {
        Info<String, Integer> info = new Info<String, Integer>(23.25, 120.55, 0, "2", Optional.of(30));
        assertEquals(0, info.time());
    }

    @Test
    public void timeTest_T43() {
        Info<String, Integer> info = new Info<String, Integer>(23.25, 120.55, 123, "2", Optional.of(30));
        assertEquals(123, info.time());
    }


    /* long value() */
    @Test
    public void valueTest_T44() {
        Info<String, Integer> info = new Info<String, Integer>(23.25, 120.55, 123, "", Optional.of(30));
        assertEquals("", info.value());
    }

    @Test
    public void valueTest_T45() {
        Info<String, Integer> info = new Info<String, Integer>(23.25, 120.55, 123, "2", Optional.of(30));
        assertEquals("2", info.value());
    }


    /* String toString() */
    @Test
    public void toStringTest_T46() {
        Integer i = null;
        Info<String, Integer> info = new Info<String, Integer>(23.25, 120.55, 123, "2", Optional.fromNullable(i));
        assertEquals("Info [lat=23.25, lon=120.55, time=123, value=2, id=Optional.absent()]", info.toString());
    }

    @Test
    public void toStringTest_T47() {
        Info<String, Integer> info = new Info<String, Integer>(23.25, 120.55, 123, "2", Optional.of(30));
        assertEquals("Info [lat=23.25, lon=120.55, time=123, value=2, id=Optional.of(30)]", info.toString());
    }
}