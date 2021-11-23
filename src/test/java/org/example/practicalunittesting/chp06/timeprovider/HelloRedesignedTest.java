package org.example.practicalunittesting.chp06.timeprovider;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Calendar;
import java.util.stream.Stream;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
class HelloRedesignedTest {

    private HelloRedesigned helloRedesigned;

    @Mock
    TimeProvider timeProvider;

    @BeforeEach
    void setUp() {
        helloRedesigned = new HelloRedesigned(timeProvider);
    }

    private static Stream<Integer> afternoonHour() {
        return Stream.of(12, 22);
    }

    private Calendar getCalendar(int hour) {
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.HOUR_OF_DAY, hour);
        return cal;
    }

    @ParameterizedTest
    @MethodSource("afternoonHour")
    void shouldSayGoodAfternoonInTheAfternoon(int afternoonHour) {
        when(timeProvider.getTime()).thenReturn(getCalendar(afternoonHour));
        Assertions.assertEquals(helloRedesigned.sayHello(), "Good Afternoon!");
    }

}