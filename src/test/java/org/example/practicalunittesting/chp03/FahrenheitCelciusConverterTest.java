package org.example.practicalunittesting.chp03;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class FahrenheitCelciusConverterTest {

    @Test
    public void shouldConvertCelciusToFahrenheit() {
        assertEquals(32, FahrenheitCelciusConverter.toFahrenheit(0));
        assertEquals(98, FahrenheitCelciusConverter.toFahrenheit(37));
        assertEquals(212, FahrenheitCelciusConverter.toFahrenheit(100));
    }

    @Test
    public void shouldConvertFahrenheitToCelcius() {
        assertEquals(0, FahrenheitCelciusConverter.toCelcius(32));
        assertEquals(37, FahrenheitCelciusConverter.toCelcius(100));
        assertEquals(100, FahrenheitCelciusConverter.toCelcius(212));
    }

    @Test
    public void testAll() {
        assertAll(
                () -> Assertions.assertEquals(37, FahrenheitCelciusConverter.toCelcius(100)),
                () -> Assertions.assertEquals(98, FahrenheitCelciusConverter.toFahrenheit(37))
        );
    }
}
