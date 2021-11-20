package org.example;

import org.example.model.CartItem;
import org.example.model.CartTotals;
import org.example.model.User;
import org.example.model.UserType;
import org.example.service.TotalsWithDiscountCalculator;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TotalsWithDiscountCalculatorTest {
    static User globalUser;
    TotalsWithDiscountCalculator totalsWithDiscountCalculator;

    @BeforeAll
    static void setupGlobalUser() {
        globalUser = new User("nahiyan", UserType.REGULAR, 100.00);
    }

    @BeforeEach
    void setupCalculator() {
        totalsWithDiscountCalculator = new TotalsWithDiscountCalculator(globalUser);
    }

    @Test
    void getTotalsWithDiscounts_userWithCredit_creditLessThanSubtotal() {
        TotalsWithDiscountCalculator calculator = new TotalsWithDiscountCalculator(new User("User with a lot of credit", UserType.REGULAR, 15.0));
        CartTotals totals = calculator.getTotals(List.of(new CartItem("Twenty dollar item", 20.0, 0)));
        assertEquals(new CartTotals(5.0, 0), totals);
    }

    @RepeatedTest(3)
    void getTotalsWithDiscounts_userWithCredit_chargedMultipleTimes(RepetitionInfo repetitionInfo) {
        totalsWithDiscountCalculator.getTotals(List.of(new CartItem("Twenty dollar item", 20.0, 0)));
        assertEquals(100.0 - 20 * repetitionInfo.getCurrentRepetition(), globalUser.getCredit());
    }

    @ParameterizedTest
    @MethodSource("differentUserTypesAndExpectedTotals")
    void getTotalsWithDiscounts_regularAndPlatinumUser_returnsDifferentSubtotal(User user, CartTotals expectedCartTotals) {
        TotalsWithDiscountCalculator calculator = new TotalsWithDiscountCalculator(user);

        CartTotals totals = calculator.getTotals(List.of(new CartItem("Ten dollar item", 10.0, 1.0)));

        assertEquals(expectedCartTotals, totals);

    }

    private static Stream<Arguments> differentUserTypesAndExpectedTotals() {
        return Stream.of(
                Arguments.of(
                        new User("Regular User", UserType.REGULAR, 0.0),
                        new CartTotals(10.0, 1.0)
                ),
                Arguments.of(
                        new User("Platinum User", UserType.PLATINUM, 0.0),
                        new CartTotals(9.0, 1.0)
                )
        );
    }

}
