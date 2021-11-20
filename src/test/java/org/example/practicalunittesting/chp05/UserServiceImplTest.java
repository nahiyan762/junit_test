package org.example.practicalunittesting.chp05;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.security.NoSuchAlgorithmException;
import java.util.stream.Stream;

class UserServiceImplTest {
    static ISecurityService iSecurityService;
    static IUserDAO iUserDAO;
    UserServiceImpl userService;

    @BeforeAll
    static void setupGlobalUser() {
        iSecurityService = new SecurityService();
        iUserDAO = new UserDAO();
    }

    @BeforeEach
    void setupCalculator() {
        userService = new UserServiceImpl(iUserDAO, iSecurityService);
    }

    @ParameterizedTest
    @MethodSource("differentUserTypesAndExpectedTotals")
    void getTotalsWithDiscounts_regularAndPlatinumUser_returnsDifferentSubtotal(IUser iUser) {
        iUser.setPassword("asd");
        Assertions.assertNotNull(iSecurityService.md5(iUser.getPassword()));
        iUserDAO.insetUser(iUser);
    }

    @RepeatedTest(3)
    public void checkValidUserNotFound() {
        IUser user = new User(3);
        user.setPassword("qwe");
        Assertions.assertThrows(Exception.class, () -> userService.assignPassword(user));
    }

    @ParameterizedTest
    @MethodSource("differentUserTypesAndExpectedTotals")
    public void checkValidUserFound(IUser iUser) {
        iUser.setPassword("asd");
        Assertions.assertNotNull(iSecurityService.md5(iUser.getPassword()));
        Assertions.assertThrows(Exception.class, () -> userService.assignPassword(iUser));
    }


    private static Stream<Arguments> differentUserTypesAndExpectedTotals() {
        return Stream.of(
                Arguments.of(
                        new User(1)
                ),
                Arguments.of(
                        new User(2)
                )
        );
    }
}