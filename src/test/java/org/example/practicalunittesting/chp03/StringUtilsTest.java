package org.example.practicalunittesting.chp03;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StringUtilsTest {
    @Test
    public void reverseString() {
        assertEquals("cba", StringUtils.reverse("abc"));
        Assertions.assertEquals("", StringUtils.reverse(""));
        Assertions.assertEquals("a", StringUtils.reverse("a"));
    }

    @Test
    public void reverseStringWithException() {
        NullPointerException thrown = assertThrows(NullPointerException.class,
                () -> StringUtils.reverse(null), "Hello");
        assertEquals("String must not null", thrown.getMessage());
    }
}